package screens;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.id;

public class ClickSearchScreen {
    @Step("Клик по поиску")
    public void clickSearch() {
        $(id("org.wikipedia.alpha:id/page_toolbar_button_search")).click();
    }

    @Step("Поиск со страницы по слову '{0}'")
    public void clickSearch(String searchText) {
        clickSearch();
        $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys(searchText);
    }

    @Step("Переход к первому результату из результатов поиска")
    public void openFirstSearchResult() {
        $$(id("org.wikipedia.alpha:id/page_list_item_title")).first().click();
    }
}
