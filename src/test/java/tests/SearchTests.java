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
    ArticleScreen articleScreen = new ArticleScreen();
    SearchResultScreen searchResultScreen = new SearchResultScreen();
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
        searchResultScreen.verifySearchResultsPresent();
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
        searchResultScreen.openFirstSearchResult();
        articleScreen.checkPageText(searchText[0]);
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
        searchResultScreen.openFirstSearchResult();
        searchScreen.clickSearch();
        searchResultScreen.checkHistorySearchResultsPresent(searchText[0]);
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
        searchResultScreen.openFirstSearchResult();
        searchScreen.inputSearch(searchText[1]);
                //searchScreen.inputSearch(searchText[1]);
        searchResultScreen.openFirstSearchResult();
        searchScreen.inputSearch(searchText[2]);
        searchResultScreen.openFirstSearchResult();
        searchScreen.clickSearch();
        searchScreen.clearSearch();
        searchScreen.checkClearHistorySearchResultsPresent();
    }
}
