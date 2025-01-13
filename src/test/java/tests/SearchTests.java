package tests;

import io.qameta.allure.AllureId;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import screens.*;

@Owner("Vlad Kashkarov")
@DisplayName("Тест на проверку поиска")
public class SearchTests extends TestBase {
    OnboardingScreen onboardingScreen = new OnboardingScreen();
    SearchScreen searchScreen = new SearchScreen();
    ClickSearchScreen clickSearchScreen = new ClickSearchScreen();
    DeleteSearchScreen deleteSearchScreen = new DeleteSearchScreen();
    PageResultScreens pageResultScreens = new PageResultScreens();
    String[] searchText = new String[]{"Main", "Java", "Sum"};

    @Test
    @Feature("Wiki")
    @Story("Search")
    @AllureId("35670")
    @Tags({@Tag("CRITICAL"), @Tag("REGRESS")})
    @DisplayName("Проверка поискового запроса")
    void successfulSearchTest() {
        onboardingScreen.clickSkipOnboardButton();
        searchScreen.performSearchNotNull("Appium");
        searchScreen.verifySearchResultsPresent();
    }

    @Test
    @Feature("Wiki")
    @Story("Search")
    @AllureId("35671")
    @Tags({@Tag("CRITICAL"), @Tag("REGRESS")})
    @DisplayName("Проверка Заголовка при переходе на статью")
    void androidUnsuccessfulOpenTest() {
        onboardingScreen.clickSkipOnboardButton();
        searchScreen.performSearchNotNull(searchText[0]);
        clickSearchScreen.openFirstSearchResult();
        pageResultScreens.checkPageText(searchText[0]);
    }

    @Test
    @Feature("Wiki")
    @Story("Search")
    @AllureId("35669")
    @Tags({@Tag("CRITICAL"), @Tag("REGRESS")})
    @DisplayName("Проверка истории поиска")
    void checkHistorySearchTest() {
        onboardingScreen.clickSkipOnboardButton();
        searchScreen.performSearchNotNull(searchText[0]);
        clickSearchScreen.openFirstSearchResult();
        clickSearchScreen.clickSearch();
        searchScreen.checkHistorySearchResultsPresent(searchText[0]);
    }

    @Test
    @Feature("Wiki")
    @Story("Search")
    @AllureId("35668")
    @Tags({@Tag("CRITICAL"), @Tag("REGRESS")})
    @DisplayName("Проверка Очистки поиска")
    void clearHistorySearchTest() {
        onboardingScreen.clickSkipOnboardButton();
        searchScreen.performSearchNotNull(searchText[0]);
        clickSearchScreen.openFirstSearchResult();
        clickSearchScreen.clickSearch(searchText[1]);
        clickSearchScreen.openFirstSearchResult();
        clickSearchScreen.clickSearch(searchText[2]);
        clickSearchScreen.openFirstSearchResult();
        clickSearchScreen.clickSearch();
        deleteSearchScreen.clearSearch();
        searchScreen.checkClearHistorySearchResultsPresent();
    }
}
