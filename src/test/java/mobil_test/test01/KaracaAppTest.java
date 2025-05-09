package mobil_test.test01;

import mobil_test.test01.pages.CartPage;
import mobil_test.test01.pages.HomePage;
import mobil_test.test01.pages.ProductDetailPage;
import mobil_test.test01.pages.SearchResultsPage;
import org.testng.annotations.Test;

public class KaracaAppTest extends SetupDriver{

    @Test
    public void testKaracaProductFlow() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        SearchResultsPage resultsPage = new SearchResultsPage(driver);
        ProductDetailPage detailPage = new ProductDetailPage(driver);
        CartPage cartPage = new CartPage(driver);

        // Uygulama açıldığında "Devam Et" butonuna tıklanıyor
        homePage.clickContinueButtonTwice();  // HomePage'deki buton tıklama fonksiyonu çağrılır
        //homePage.grantLocationPermission(); // konum izni
        // 🔍 Arama sayfasına gitmek için arama ikonuna tıklanıyor
        homePage.clickSearchIcon();
        homePage.searchProduct("tabak");
        resultsPage.selectFirstProduct();
        detailPage.addToCart();
        detailPage.goToCart();

    }
}

