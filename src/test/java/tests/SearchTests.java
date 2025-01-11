package tests;

import io.qameta.allure.AllureId;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;
import screens.OnboardingScreen;
import screens.SearchScreen;

@Owner("Vlad Kashkarov")
@DisplayName("Тест на проверку поиска")
public class SearchTests extends TestBase {
    OnboardingScreen onboardingScreen = new OnboardingScreen();
    String[] searchText = new String[]{"Main", "Java", "Sum"};

    @Test
    @Feature("Wiki")
    @Story("Search")
    @AllureId("35670")
    @Tags({@Tag("CRITICAL"), @Tag("REGRESS")})
    @DisplayName("Проверка поискового запроса")
    void successfulSearchTest() {
        onboardingScreen.clickSkipOnboardButton();
        SearchScreen.performSearch("Appium");
        SearchScreen.verifySearchResultsPresent();
    }

    @Test
    @Feature("Wiki")
    @Story("Search")
    @AllureId("35671")
    @Tags({@Tag("CRITICAL"), @Tag("REGRESS")})
    @DisplayName("Проверка Заголовка при переходе на статью")
    void androidUnsuccessfulOpenTest() {
        onboardingScreen.clickSkipOnboardButton();
        SearchScreen.performSearch(searchText[0]);
        SearchScreen.openFirstSearchResult();
        SearchScreen.checkPageText(searchText[0]);
    }

    @Test
    @Feature("Wiki")
    @Story("Search")
    @AllureId("35669")
    @Tags({@Tag("CRITICAL"), @Tag("REGRESS")})
    @DisplayName("Проверка истории поиска")
    void checkHistorySearchTest() {
        onboardingScreen.clickSkipOnboardButton();
        SearchScreen.performSearch(searchText[0]);
        SearchScreen.openFirstSearchResult();
        SearchScreen.clickSearch();
        SearchScreen.checkHistorySearchResultsPresent(searchText[0]);
    }

    @Test
    @Feature("Wiki")
    @Story("Search")
    @AllureId("35668")
    @Tags({@Tag("CRITICAL"), @Tag("REGRESS")})
    @DisplayName("Проверка Очистки поиска")
    void clearHistorySearchTest() {
        onboardingScreen.clickSkipOnboardButton();
        SearchScreen.performSearch(searchText[0]);
        SearchScreen.openFirstSearchResult();
        SearchScreen.clickSearch(searchText[1]);
        SearchScreen.openFirstSearchResult();
        SearchScreen.clickSearch(searchText[2]);
        SearchScreen.openFirstSearchResult();
        SearchScreen.clickSearch();
        SearchScreen.clearSearch();
        SearchScreen.checkClearHistorySearchResultsPresent();
    }
}
