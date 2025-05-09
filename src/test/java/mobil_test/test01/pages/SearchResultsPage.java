package mobil_test.test01.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


import java.time.Duration;
import java.util.List;


public class SearchResultsPage {
    AndroidDriver driver;
    WebDriverWait wait;

    public SearchResultsPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void selectFirstProduct() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // 1. Ürün listesi yüklenene kadar bekle
        List<WebElement> productList = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                //By.xpath("//android.view.View[contains(@content-desc, 'Karaca')]")));
                By.xpath("//android.widget.ImageView[@content-desc=\"Karaca Icequeen 18 Parça 6 Kişilik Yemek Takımı\n" +
                        "4.6 (28)\n" +
                        "1.499 TL\n" +
                        "Anneler Günü Son Fırsatlar\"]")));

        // 2. Liste boş değilse ilk ürüne tıkla
        if (!productList.isEmpty()) {
            WebElement firstProduct = productList.get(0);
            try {
                // Kısa bekleme gerekebilir (animasyon veya render gecikmesi için)
                Thread.sleep(1000);
                firstProduct.click();
                System.out.println("İlk ürüne tıklandı.");
            } catch (Exception e) {
                System.out.println("Tıklama hatası, TouchAction ile dene.");
                TouchAction<?> touchAction = new TouchAction<>(driver);
                touchAction.tap(ElementOption.element(firstProduct)).perform();
            }
        } else {
            System.out.println("Ürün listesi boş!");
            Assert.fail("Ürün listesi boş, detay sayfasına geçilemedi!");
        }

        // 3. Detay sayfası açıldı mı kontrol için kısa bekleme
        try {
            Thread.sleep(2000);  // Yavaş cihazlar için önerilir
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
