package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import drivers.BrowserstackDriver;
import drivers.EmulatorDriver;
import helpers.AllureAttach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class TestBase {
    private static final String device = System.getProperty("deviceHost", "browserstack");

    @BeforeAll
    static void beforeAll() {
        if (device.equals("emulator") || device.equals("real")) {
            Configuration.browser = EmulatorDriver.class.getName();
        } else if (device.equals("browserstack")) {
            Configuration.browser = BrowserstackDriver.class.getName();
        }

        Configuration.browserSize = null;
        Configuration.timeout = 30000;
    }

    @BeforeEach
    void beforeEach() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        open();
    }

    @AfterEach
    void addAttachments() {

        if (device.equals("browserstack")) {
            String sessionId = Selenide.sessionId().toString();
            AllureAttach.addVideo(sessionId);
        }
        if (device.equals("emulator")) {
            AllureAttach.screenshotAs("Last screenshot");
        }
        AllureAttach.pageSource();
        closeWebDriver();
    }
}
