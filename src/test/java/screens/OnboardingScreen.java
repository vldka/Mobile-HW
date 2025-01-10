package screens;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;

public class OnboardingScreen {

    @Step("Проверка текста '{0}' онбординга")
    public OnboardingScreen checkOnboarding(String text) {
        $(id("org.wikipedia.alpha:id/primaryTextView")).shouldHave(text(text));

        return this;
    }

    @Step("Нажатие кнопку 'Continue' в онбординге")
    public OnboardingScreen clickContinueOnboardButton() {
        $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();

        return this;
    }

    @Step("Нажатие кнопку 'Skip' в онбординге")
    public OnboardingScreen clickSkipOnboardButton() {
        $(id("org.wikipedia.alpha:id/fragment_onboarding_skip_button")).click();

        return this;
    }
}
