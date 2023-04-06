package config;

import org.aeonbits.owner.Config;

@MobileDriverConfig.Sources({
        "classpath:${env}.properties"
})

public interface MobileDriverConfig extends Config {


    @Key("user")
    String getUser();

    @Key("password")
    String getPassword();

    @Key("app")
    String getApp();

    @Key("device")
    String getDevice();

    @Key("version")
    String getOsVersion();

    @Key("project")
    String getProject();

    @Key("build")
    String getBuild();

    @Key("name")
    String getName();

    @Key("deviceName")
    String deviceName();
    @Key("appPackage")
    String appPackage();
    @Key("appActivity")
    String appActivity();


}
