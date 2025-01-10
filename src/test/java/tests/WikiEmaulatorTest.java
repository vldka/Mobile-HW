package tests;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import screens.OnboardingScreen;

@Tag("remote")
@Owner("Vlad Kashkarov")
@DisplayName("Тест на Android Эмуляторе")
public class WikiEmaulatorTest extends TestBase {

    OnboardingScreen onboardingScreen = new OnboardingScreen();

    @Test
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
