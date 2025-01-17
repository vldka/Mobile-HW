package screens;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.className;
import static io.appium.java_client.AppiumBy.id;
import static org.assertj.core.api.Assertions.assertThat;

public class SearchResultScreen {

    @Step("Переход к первому результату из результатов поиска")
    public void openFirstSearchResult() {
        $$(id("org.wikipedia.alpha:id/page_list_item_title")).first().click();
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
}
