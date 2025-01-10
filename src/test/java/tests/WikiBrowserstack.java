package tests;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import screens.SearchScreen;

@Tag("browserstack")
@Owner("Vlad Kashkarov")
@DisplayName("Тест на Android browserstack")
public class WikiBrowserstack extends TestBase{

    @Test
    @DisplayName("Проверка поискового запроса")
    void successfulSearchTest() {
        SearchScreen.performSearch("Appium");
        SearchScreen.verifySearchResultsPresent();
    }

    @Test
    @DisplayName("Проверка ошибки при переходе на статью")
    void androidUnsuccessfulOpenArticleTest() {
        SearchScreen.performSearch("Java");
        SearchScreen.openFirstSearchResult();
        SearchScreen.checkPageError();
    }
}
