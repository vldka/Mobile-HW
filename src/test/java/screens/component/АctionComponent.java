package screens.component;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;

public class АctionComponent {

    @Step("Подтверждение действия")
    public void actionTrue() {
        $(id("android:id/button1")).click();
    }
}
