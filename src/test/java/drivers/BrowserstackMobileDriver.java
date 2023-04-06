package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.MobileDriverConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackMobileDriver implements WebDriverProvider {

    public static URL getAppiumServerUrk() {
        try {
            return new URL("http://hub.browserstack.com/wd/hub");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

    }

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        MobileDriverConfig config =
                ConfigFactory.create(MobileDriverConfig.class, System.getProperties());

        String user = config.getUser();
        String password = config.getPassword();
        String app = config.getApp();
        String device = config.getDevice();
        String version = config.getOsVersion();
        String project = config.getProject();
        String build = config.getBuild();
        String name = config.getName();

        MutableCapabilities mutableCapabilities = new MutableCapabilities();
        mutableCapabilities.merge(capabilities);

        // Set your access credentials
        mutableCapabilities.setCapability("browserstack.user", user);
        mutableCapabilities.setCapability("browserstack.key", password);

        // Set URL of the application under test
        mutableCapabilities.setCapability("app", app);

        // Specify device and os_version for testing
        mutableCapabilities.setCapability("device", device);
        mutableCapabilities.setCapability("os_version", version);

        // Set other BrowserStack mutableCapabilities
        mutableCapabilities.setCapability("project", project);
        mutableCapabilities.setCapability("build", build);
        mutableCapabilities.setCapability("name", name);

        return new RemoteWebDriver(getAppiumServerUrk(), mutableCapabilities);

    }
}
