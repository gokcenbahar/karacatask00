package mobil_test.test01;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;




import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class SetupDriver {


    protected AndroidDriver driver;

    @BeforeClass
    public void setup() throws MalformedURLException{

    UiAutomator2Options options = new UiAutomator2Options()
                .setPlatformName("android")
                .setAutomationName("UIautomator2")
                .setUdid("emulator-5554")
                .setApp("C:\\Users\\kadir\\Downloads\\App.apk\\src\\test\\resources\\app (8).apk")
                .setAppPackage("net.btpro.client.karaca")
                .setAppActivity("net.btpro.client.karaca.MainActivity")
                .setAutoGrantPermissions(true)
                .setAppWaitActivity("*")
                .setAvdLaunchTimeout(Duration.ofMinutes(4));


        URL url = new URL("http://0.0.0.0:4723");

        driver = new AndroidDriver(url, options);
        //AndroidDriver driver = new AndroidDriver(url,options);
        System.out.println("İlk ekran PageSource:");
        System.out.println(driver.getPageSource());

    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }



}

