package tests;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import screens.SearchScreen;

@Owner("Vlad Kashkarov")
@DisplayName("Тест на Android")
public class AndroidTests extends TestBase{

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
