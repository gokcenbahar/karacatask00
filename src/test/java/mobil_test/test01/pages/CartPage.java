package mobil_test.test01.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.testng.Assert;

public class CartPage {
    AndroidDriver driver;

    public CartPage(AndroidDriver driver) {
        this.driver = driver;
    }

    By goToCartButton = By.xpath("//android.view.View[@content-desc='Sepete Git']");

    public void verifyProductInCart(String expectedProductName) {
        String actualText = driver.findElement(goToCartButton).getText();
        Assert.assertTrue(actualText.toLowerCase().contains(expectedProductName.toLowerCase()),
                "Sepette beklenen ürün bulunamadı!");
    }
}
