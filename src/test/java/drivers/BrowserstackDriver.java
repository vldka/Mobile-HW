package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.AuthConfig;
import config.DriverConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackDriver implements WebDriverProvider {
    AuthConfig authConfig = ConfigFactory.create(AuthConfig.class, System.getProperties());
    DriverConfig deviceConfig = ConfigFactory.create(DriverConfig.class, System.getProperties());

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {

        MutableCapabilities caps = new MutableCapabilities();
        caps.setCapability("browserstack.user", authConfig.getUser());
        caps.setCapability("browserstack.key", authConfig.getKey());
        caps.setCapability("app", deviceConfig.getApp());
        caps.setCapability("device", deviceConfig.getDevice());
        caps.setCapability("os_version", deviceConfig.getOsVersion());
        caps.setCapability("project", deviceConfig.project());
        caps.setCapability("build", deviceConfig.build());
        caps.setCapability("name", deviceConfig.name());

        try {
            return new RemoteWebDriver(
                    new URL(authConfig.getRemoteUrl()), caps);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
