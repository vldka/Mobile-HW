package screens;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.className;

public class PageResultScreens {

    @Step("Проверка страницы '{0}'")
    public void checkPageText(String searchText) {
        $$(className("android.widget.TextView")).first().shouldBe(text(searchText));
    }
}
