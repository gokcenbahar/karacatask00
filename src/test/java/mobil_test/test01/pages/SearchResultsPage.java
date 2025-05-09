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
                //By.xpath("//androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup")));
              /* By.xpath("//android.view.View[@content-desc=\"Karaca Icequeen 18 Parça 6 Kişilik Yemek Takımı\n" +
                        "4.6 (28)\n" +
                        "1.499 TL\n" +
                        "Anneler Günü Son Fırsatlar\"]")
        ));

               */




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

        // 4. (İsteğe bağlı) Sayfa başlığını kontrol edebilirsin
        // String detailTitle = driver.getTitle(); veya başka bir element ile kontrol
    }



  /*  public void selectFirstProduct() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Sayfa kaynağını yazdır (XPath doğru mu kontrol için)
        System.out.println("Ürün liste sayfası:");
        System.out.println(driver.getPageSource());

        // Ürün listesini al
        List<WebElement> productList = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                By.xpath("//androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup")
        ));

        if (!productList.isEmpty()) {
            WebElement firstProduct = productList.get(0);

            try {
                firstProduct.click(); // Ürüne tıkla
                System.out.println("İlk ürüne tıklandı.");
            } catch (Exception e) {
                // TouchAction fallback
                System.out.println("Normal tıklama olmadı, TouchAction deneniyor...");
                TouchAction<?> touchAction = new TouchAction<>(driver);
                touchAction.tap(ElementOption.element(firstProduct)).perform();
            }

        } else {
            System.out.println("Ürün listesi boş!");
            Assert.fail("Ürün listesi boş, detay sayfasına geçilemedi!");
        }
    }

   */

    //dünkü kod
/*
    public void selectFirstProduct() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"Karaca Icequeen 18 Parça 6 Kişilik Yemek Takımı\n" +
                "4.6 (28)\n" +
                "1.499 TL\"]")).click();

        // Ürün listesini bekle (RecyclerView içindeki ViewGroup'lar)
        List<WebElement> productList = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                By.xpath("//androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup")
        ));

        if (!productList.isEmpty()) {
            WebElement firstProduct = productList.get(0);

            try {
                firstProduct.click(); // Ürüne tıkla
            } catch (Exception e) {
                // Eğer doğrudan tıklama başarısızsa TouchAction ile dene
                TouchAction<?> touchAction = new TouchAction<>(driver);
                touchAction.tap(ElementOption.element(firstProduct)).perform();
            }

        } else {
            System.out.println("Ürün listesi boş, ilk ürün tıklanamadı!");
            Assert.fail("Ürün listesi boş!");
        }
    }

 */



     


// çalışıyor ama direkt sepete ekleme sepete gitme
  /* public void selectFirstProduct() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

            // Scroll ederek ürünün görünmesini sağla
            WebElement product = driver.findElement(AppiumBy.androidUIAutomator(
                    "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(" +
                            "new UiSelector().description(\"Karaca Icequeen 18 Parça 6 Kişilik Yemek Takımı 4.6 (28) 1.499 TL\"))"
            ));

            // Ürünün görünür ve tıklanabilir olduğunu kontrol et
            wait.until(ExpectedConditions.visibilityOf(product));
            wait.until(ExpectedConditions.elementToBeClickable(product));

            // Ürüne tıkla
            product.click();
            System.out.println("Ürün detay sayfasına giriş yapıldı.");

        } catch (Exception e) {
            System.out.println("Ürüne tıklarken hata oluştu: " + e.getMessage());
        }
    }


   */



/*    public void selectFirstProduct() {
        try {
            // "Karaca" kelimesini içeren ilk görünür ImageView ürünü bul
            WebElement firstProduct = driver.findElement(AppiumBy.androidUIAutomator(
                    "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(" +
                            "new UiSelector().className(\"android.widget.ImageView\").descriptionContains(\"Karaca\"))"
            ));

            // WebDriverWait ile öğenin tıklanabilir olmasını bekleyin
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Öğenin görünür olduğundan ve tıklanabilir olduğundan emin olun
            wait.until(ExpectedConditions.visibilityOf(firstProduct));
            wait.until(ExpectedConditions.elementToBeClickable(firstProduct));

            // Ürüne tıklayın
            firstProduct.click();
            System.out.println("İlk ürüne tıklanarak ürün sayfasına gidildi.");

        } catch (Exception e) {
            System.out.println("Hata oluştu: " + e.getMessage());
        }
    }

 */

  /*  public void selectFirstProduct() {
        try {
            // "Karaca" kelimesini içeren ilk görünür ImageView ürünü bul
            WebElement firstProduct = driver.findElement(AppiumBy.androidUIAutomator(
                    "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView("
                            + "new UiSelector().className(\"android.widget.ImageView\").descriptionContains(\"Karaca\"))"
            ));


            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
            wait.until(ExpectedConditions.elementToBeClickable(firstProduct)).click();
            System.out.println("İlk ürüne tıklanarak ürün sayfasına gidildi.");
        } catch (Exception e) {
            System.out.println("Hata oluştu: " + e.getMessage());
        }
    }


   */

  /*  public void selectFirstProduct() {
        try {
            // Tüm ürünlerin imageView içeren ve content-desc'e sahip olanlarını bul
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            List<WebElement> products = driver.findElements(By.xpath("//android.widget.ImageView[@content-desc]"));

            if (products.size() > 0) {
                // İlk ürünün tıklanabilir olmasını bekle
                WebElement firstProduct = wait.until(ExpectedConditions.elementToBeClickable(products.get(0)));
                firstProduct.click();
                System.out.println("İlk ürüne tıklanarak ürün sayfasına gidildi.");
            } else {
                System.out.println("Ürün bulunamadı.");
            }
        } catch (Exception e) {
            System.out.println("Hata oluştu: " + e.getMessage());
        }
    }

   */

 /*   public <MobileElement> void selectFirstProduct() {
        // Tüm ürünlerin image view'lerini al, ilkine tıkla
        List<WebElement> products = driver.findElements(By.xpath("//android.widget.ImageView[@content-desc]"));
        products.get(0).click(); // İlk ürünü seç

        // UiAutomator kullanarak arama sonuçlarından ilk ürünü tıklama
        //String uiAutomatorSelector = "new UiSelector().className(\"android.view.View\").instance(23)";

        // WebDriverWait kullanarak öğenin tıklanabilir olmasını bekliyoruz
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //WebElement firstProduct = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator(uiAutomatorSelector)));

        if (firstProduct != null) {
            firstProduct.click();
            System.out.println("İlk ürüne tıklanarak ürün sayfasına gidildi.");
        } else {
            System.out.println("Ürün bulunamadı.");
        }
    }


  */


    /*public void selectFirstProduct() {
        // Arama sonuçları yüklendikten sonra ilk ürüne tıklama
        By firstProduct = By.xpath("(//android.view.View[contains(@content-desc, 'TL')])[1]");

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement productElement = wait.until(ExpectedConditions.elementToBeClickable(firstProduct));
            productElement.click();
            System.out.println("İlk ürün başarıyla seçildi.");
        } catch (Exception e) {
            System.out.println("İlk ürüne tıklanırken bir hata oluştu: " + e.getMessage());
        }
    }

     */

   /* public void selectFirstProduct() {
        List<WebElement> allViews = driver.findElements(By.className("android.view.View"));

        if (allViews.size() > 24) {
            allViews.get(24).click();
            System.out.println("İlk ürüne tıklandı ve ürün sayfasına gidildi.");
        } else {
            System.out.println("Yeterli sayıda öğe bulunamadı.");
        }
    }

    */


 /*   public void selectFirstProduct() {
        // content-desc'i olan ilk android.view.View öğesi (ürün)
        By firstProduct = By.xpath("(//android.view.View[contains(@content-desc, 'TL')])[1]");

        // Ürünü tıklamak için bekleyip işlem yap
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement productElement = wait.until(ExpectedConditions.elementToBeClickable(firstProduct));
        productElement.click();

        System.out.println("İlk ürün başarıyla seçildi.");
    }

  */


    /*public void selectFirstProduct() {
        By firstProduct = By.xpath("(//android.view.View[contains(@content-desc,'Karaca')])[1]");
        driver.findElement(firstProduct).click();
    }

     */






/*
    By firstProduct = By.xpath("//android.view.View[contains(@content-desc, 'Karaca Pure')]");


    public void selectFirstProduct() {
        driver.findElement(firstProduct).click();
    }
    public void selectProductByName(String partialName) {
        By product = By.xpath("//android.view.View[contains(@content-desc, '" + partialName + "')]");
        wait.until(ExpectedConditions.elementToBeClickable(product)).click();
    }


 */




}
