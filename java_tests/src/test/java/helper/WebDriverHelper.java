package helper;

import com.codeborne.selenide.WebDriverProvider;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URI;
import java.util.Arrays;

public class WebDriverHelper implements WebDriverProvider {
        @Override
        public RemoteWebDriver createDriver(DesiredCapabilities desiredCapabilities) {

            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setBrowserName("chrome");
            try {
                RemoteWebDriver driver = new RemoteWebDriver(
                        URI.create("http://chrome_remote:4444/wd/hub").toURL(),
                        capabilities
                );
                driver.setFileDetector(new LocalFileDetector());
                return driver;
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }

        }

    }
