package mobil_test.test01.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class HomePage {
    AndroidDriver driver;

    public HomePage(AndroidDriver driver) {
        this.driver = driver;

    }

    public void clickContinueButtonTwice() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        By devamEtXpath = By.xpath("//android.view.View[@content-desc='Devam Et']");
        By izinButonuXpath = By.xpath("//android.widget.Button[@resource-id='com.android.permissioncontroller:id/permission_allow_one_time_button']");

        for (int i = 0; i < 3; i++) {
            try {
                // Eğer Devam Et butonu görünürse tıkla
                WebElement continueButton = wait.until(ExpectedConditions.visibilityOfElementLocated(devamEtXpath));
                if (continueButton.isDisplayed()) {
                    continueButton.click();
                    System.out.println((i + 1) + ". Devam Et tıklandı.");
                }
            } catch (Exception e) {
                System.out.println((i + 1) + ". Devam Et butonu bulunamadı.");
            }

            // Devam Et'ten sonra izin ekranı geldiyse tıkla
            try {
                WebElement izinButonu = new WebDriverWait(driver, Duration.ofSeconds(3))
                        .until(ExpectedConditions.visibilityOfElementLocated(izinButonuXpath));
                izinButonu.click();
                System.out.println("Konum izni verildi.");
            } catch (Exception e) {
                System.out.println("Konum izni görünmedi, geçiliyor.");
            }
        }

        // Eğer Devam Et tıklamalarından sonra da hala izin ekranı geldiyse en sonda tekrar kontrol et
        try {
            WebElement izinButonu = new WebDriverWait(driver, Duration.ofSeconds(3))
                    .until(ExpectedConditions.visibilityOfElementLocated(izinButonuXpath));
            izinButonu.click();
            System.out.println("Devam Et sonrası konum izni verildi.");
        } catch (Exception e) {
            // izin ekranı görünmediyse sorun yok
        }
    }

    By searchIcon = By.xpath("//android.view.View[@resource-id='bottomBar1']/android.widget.ImageView");

    public void clickSearchIcon() {
        driver.findElement(searchIcon).click();
    }


    By searchBox = By.id("net.btpro.client.karaca:id/search_src_text");

    public void searchProduct(String keyword) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Arama ikonuna tıkla
        By searchIconField = By.xpath("//android.widget.ImageView[@content-desc='Aradığın Her Şey']");
        wait.until(ExpectedConditions.elementToBeClickable(searchIconField)).click();

        // Arama kutusunu bul
        By searchBox = By.xpath("//android.view.View[@resource-id='search_field']");
        WebElement searchField = wait.until(ExpectedConditions.elementToBeClickable(searchBox));
        searchField.click();
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        // Klavye ile yazma (harf harf)
        AndroidDriver androidDriver = (AndroidDriver) driver;
        for (char ch : keyword.toCharArray()) {
            AndroidKey key = AndroidKey.valueOf(String.valueOf(ch).toUpperCase());
            androidDriver.pressKey(new KeyEvent(key));
        }
        // ENTER tuşuna bas (ya da SEARCH)
        androidDriver.pressKey(new KeyEvent(AndroidKey.ENTER)); // veya AndroidKey.SEARCH


        try { Thread.sleep(200); } catch (InterruptedException e) {}


}}
