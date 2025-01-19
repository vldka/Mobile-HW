package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:properties/${deviceHost}.properties",
        "classpath:properties/browserstack.properties"
})
public interface DriverConfig extends Config {

    @Key("app")
    @DefaultValue("bs://sample.app")
    String getApp();

    @Key("device")
    @DefaultValue("Google Pixel 3")
    String getDevice();

    @Key("os_version")
    @DefaultValue("9.0")
    String getOsVersion();

    @Key("project")
    @DefaultValue("Default Mobile Java Project")
    String project();

    @Key("build")
    @DefaultValue("Default-browserstack-build")
    String build();

    @Key("name")
    @DefaultValue("Default Mobile Test")
    String name();
}
