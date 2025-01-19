package tests;

import io.qameta.allure.AllureId;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import screens.OnboardingScreen;

@Feature("Wiki")
@Story("Onboard ")
@Tags({@Tag("CRITICAL"), @Tag("REGRESS")})
@Owner("Vlad Kashkarov")
@DisplayName("Тест на проверку Онбординга")
public class OnboardingTests extends TestBase {

    OnboardingScreen onboardingScreen = new OnboardingScreen();

    @Test
    @AllureId("35667")
    @DisplayName("Проверка прохождения онбординга приложения")
    public void OnboardingTest() {
        onboardingScreen.checkOnboarding("The Free Encyclopedia\n" +
                "…in over 300 languages");
        onboardingScreen.clickContinueOnboardButton();
        onboardingScreen.checkOnboarding("New ways to explore");
        onboardingScreen.clickContinueOnboardButton();
        onboardingScreen.checkOnboarding("Reading lists with sync");
        onboardingScreen.clickContinueOnboardButton();
        onboardingScreen.checkOnboarding("Data & Privacy");
    }

}
