package screens;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.*;
import static org.assertj.core.api.Assertions.assertThat;

public class SearchScreen {

    @Step("Выполнение поиска по запросу '{0}' в Wikipedia")
    public static void performSearch(String searchText) {
        if (searchText == null || searchText.isEmpty()) {
            throw new IllegalArgumentException("Search text cannot be null or empty.");
        }
        $(accessibilityId("Search Wikipedia")).click();
        $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys(searchText);
    }


    @Step("Переход к первому результату из результатов поиска")
    public static void openFirstSearchResult() {
        $$(id("org.wikipedia.alpha:id/page_list_item_title")).first().click();
    }

    @Step("Проверка результатов поиска")
    public static void verifySearchResultsPresent() {
        assertThat($$(id("org.wikipedia.alpha:id/page_list_item_title")))
                .as("Expected at least one search result")
                .hasSizeGreaterThan(0);
    }

    @Step("Проверка страницы '{0}'")
    public static void checkPageText(String searchText) {
        $$(className("android.widget.TextView")).first().shouldBe(text(searchText));
    }
}
