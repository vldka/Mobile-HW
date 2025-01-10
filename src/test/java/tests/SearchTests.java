package tests;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.*;
import screens.OnboardingScreen;
import screens.SearchScreen;

@Owner("Vlad Kashkarov")
@DisplayName("Тест на проверку поиска")
public class SearchTests extends TestBase {
    OnboardingScreen onboardingScreen = new OnboardingScreen();
    String[] searchText = new String[]{"Main", "Java", "Sum"};

        @Test
        @DisplayName("Проверка поискового запроса")
        void successfulSearchTest() {
            onboardingScreen.clickSkipOnboardButton();
            SearchScreen.performSearch(searchText[0]);
            SearchScreen.verifySearchResultsPresent();
        }
        @Test
        @DisplayName("Проверка Заголовка при переходе на статью")
        void androidUnsuccessfulOpenTest() {
            onboardingScreen.clickSkipOnboardButton();
            SearchScreen.performSearch(searchText[0]);
            SearchScreen.openFirstSearchResult();
            SearchScreen.checkPageText(searchText[0]);
        }
    @Test
    @DisplayName("Проверка истории поиска")
    void checkHistorySearchTest() {
        onboardingScreen.clickSkipOnboardButton();
        SearchScreen.performSearch(searchText[0]);
        SearchScreen.openFirstSearchResult();
        SearchScreen.clickSearch();
        SearchScreen.checkHistorySearchResultsPresent(searchText[0]);
    }

    @Test
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
