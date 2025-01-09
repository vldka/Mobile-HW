package config;

import org.aeonbits.owner.Config;
@Config.Sources({
        "classpath:project.properties"})
public interface AuthConfig extends Config {
    @Key("remoteUrl")
    @DefaultValue("https://hub.browserstack.com/wd/hub")
    String getRemoteUrl();

    @Key("key")
    String getKey();

    @Key("user")
    String getUser();
}
