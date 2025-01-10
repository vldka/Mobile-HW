package tests;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.*;
import screens.OnboardingScreen;
import screens.SearchScreen;

@Tag("browserstack")
@Owner("Vlad Kashkarov")
@DisplayName("Тест на Android browserstack")
public class WikiBrowserstackTest extends TestBase{
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
    void androidUnsuccessfulOpenArticleTest() {
        onboardingScreen.clickSkipOnboardButton();
        SearchScreen.performSearch("Java");
        SearchScreen.openFirstSearchResult();
        SearchScreen.checkScroll();
        SearchScreen.checkPageOpen("Java");
    }
}
