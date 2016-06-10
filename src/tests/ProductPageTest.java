package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.CategoryLandingPage;
import pages.MainPage;
import pages.ProductDetailsPage;
import utils.WebElementsActions;

/**
 * Created by user on 6/5/2016.
 */
public class ProductPageTest {

    public WebDriver driver = Runner.driver;
    public WebElementsActions web = new WebElementsActions(driver);
    public static final String baseUrl = "http://www.ellos.se/";


    @Test
    public void testForStandardWomenProductDetailsPageUI() throws Exception {

        web.openPage(baseUrl);
        web.refreshPage();

        MainPage mainPage = new MainPage(driver);
        mainPage.switchToLinnenSubcategoryLandingPage();
        CategoryLandingPage categoryLandingPage = new CategoryLandingPage(driver);
        categoryLandingPage.switchToFirstProductDetailPage();
        ProductDetailsPage productDetailPage = new ProductDetailsPage(driver);

        productDetailPage.chekcCorrectPDPUI();
        //Assert.assertTrue("PDP is incorrect", productDetailPage.isDisplayedCorrectProductPage());
    }

    @Test
    public void checkingColorAndSizeSelectionTest () throws Exception {
        web.openPage(baseUrl);
        web.refreshPage();

        MainPage mainPage = new MainPage(driver);
        mainPage.switchToLinnenSubcategoryLandingPage();
        CategoryLandingPage categoryLandingPage = new CategoryLandingPage(driver);
        categoryLandingPage.switchToFirstProductDetailPage();
        ProductDetailsPage productDetailPage = new ProductDetailsPage(driver);
        productDetailPage.selectProductSize();


    }



}
