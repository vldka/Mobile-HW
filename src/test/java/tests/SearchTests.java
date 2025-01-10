package tests;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.*;
import screens.OnboardingScreen;
import screens.SearchScreen;

@Owner("Vlad Kashkarov")
@DisplayName("Тест на Android browserstack")
public class SearchTests extends TestBase {
    OnboardingScreen onboardingScreen = new OnboardingScreen();

    @Test
    @DisplayName("Проверка поискового запроса")
    void successfulSearchTest() {
        onboardingScreen.clickSkipOnboardButton();
        SearchScreen.performSearch("Appium");
        SearchScreen.verifySearchResultsPresent();
    }

    @Test
    @DisplayName("Проверка Заголовка при переходе на статью")
    void androidUnsuccessfulOpenTest() {
        String searchText = "Java";
        onboardingScreen.clickSkipOnboardButton();
        SearchScreen.performSearch(searchText);
        SearchScreen.openFirstSearchResult();
        SearchScreen.checkPageText(searchText);
    }
}
