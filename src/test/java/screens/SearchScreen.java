package screens;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.*;
import static org.assertj.core.api.Assertions.assertThat;

public class SearchScreen {

    @Step("Выполнение поиска по запросу '{0}' в Wikipedia с непустым запросом")
    public void performSearchNotNull(String searchText) {
        if (searchText == null || searchText.isEmpty()) {
            throw new IllegalArgumentException("Search text cannot be null or empty.");
        }
        $(accessibilityId("Search Wikipedia")).click();
        $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys(searchText);
    }

    @Step("Проверка результатов поиска на вхождение минимум одной записи")
    public void verifySearchResultsPresent() {
        assertThat($$(id("org.wikipedia.alpha:id/page_list_item_title")))
                .as("Expected at least one search result")
                .hasSizeGreaterThan(0);
    }

    @Step("Проверка истории поиска")
    public void checkHistorySearchResultsPresent(String text) {

        $(id("org.wikipedia.alpha:id/recent_searches")).
                $$(className("android.widget.TextView")).find(text(text)).should(exist);
    }

    @Step("Проверка очистки поиска")
    public void checkClearHistorySearchResultsPresent() {

        $(id("org.wikipedia.alpha:id/search_empty_message"))
                .shouldBe(text("Search Wikipedia in more languages"));

    }
}
