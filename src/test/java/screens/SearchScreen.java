package screens;

import io.qameta.allure.Step;
import screens.component.АctionComponent;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.*;
import static org.assertj.core.api.Assertions.assertThat;

public class SearchScreen {
    АctionComponent action = new АctionComponent();
    @Step("Выполнение поиска с главной страницы по запросу '{0}' в Wikipedia с непустым запросом")
    public void performSearchNotNull(String searchText) {
        if (searchText == null || searchText.isEmpty()) {
            throw new IllegalArgumentException("Search text cannot be null or empty.");
        }
        $(accessibilityId("Search Wikipedia")).click();
        $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys(searchText);
    }

    @Step("Проверка очистки поиска")
    public void checkClearHistorySearchResultsPresent() {

        $(id("org.wikipedia.alpha:id/search_empty_message"))
                .shouldBe(text("Search Wikipedia in more languages"));
    }

    @Step("Клик по поиску")
    public void clickSearch() {
        $(id("org.wikipedia.alpha:id/page_toolbar_button_search")).click();
    }

    @Step("Поиск со страницы по слову '{0}'")
    public void inputSearch(String searchText) {
        clickSearch();//Search Wikipedia
        $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys(searchText);
    }

    @Step("Очистить историю")
    public void clearSearch() {
        $(id("org.wikipedia.alpha:id/recent_searches_delete_button")).click();
        action.actionTrue();
    }
}
