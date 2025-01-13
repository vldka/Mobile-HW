package screens;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;

public class DeleteSearchScreen {
    @Step("Очистить историю")
    public void clearSearch() {
        $(id("org.wikipedia.alpha:id/recent_searches_delete_button")).click();
        $(id("android:id/button1")).click();
    }

}
