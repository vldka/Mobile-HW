package config;

import org.aeonbits.owner.Config;
@Config.Sources({
        "classpath:properties/${deviceHost}.properties"
})
public interface EmulatorDriverConfig extends Config {


    @Key("platformVersion")
    String getPlatformVersion();

    @Key("deviceName")
    String getDeviceName();

    @Key("appPackage")
    String getAppPackage();

    @Key("appActivity")
    String getAppActivity();

    @Key("appiumServerUrl")
    String getAppiumServerUrl();
}
