package mobil_test.test01.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class ProductDetailPage {AndroidDriver driver;

    public ProductDetailPage(AndroidDriver driver) {
        this.driver = driver;
    }




    By addToCartButton = By.xpath("//android.widget.ImageView[@content-desc='SEPETE EKLE']");
    By goToCartButton = By.xpath("//android.view.View[@content-desc='Sepete Git']");

    public void addToCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
        button.click();
        System.out.println("Sayfa kaynak kodu:\n" + driver.getPageSource());


        // Tıklama sonrası bekleme (animasyonlar, geçişler için)
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void goToCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement cartButton = wait.until(ExpectedConditions.elementToBeClickable(goToCartButton));
        cartButton.click();

    // Tıklama sonrası bekleme (animasyonlar, geçişler için)
        try {
        Thread.sleep(2000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}
}
