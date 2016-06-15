package tests;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CategoryLandingPage;
import pages.MainPage;
import pages.ProductDetailsPage;
import utils.NoElementFound;
import utils.WebElementsActions;

/**
 * Created by user on 6/5/2016.
 */
public class ProductPageTest {

    private WebDriver driver = Fixture.driver;
    private WebElementsActions web = new WebElementsActions(driver);
    private static final String baseUrl = "http://www.ellos.se/";


    @Test
    public void checkingStandardWomenProductDetailsPageUITest() throws NoElementFound {

        web.openPage(baseUrl);
        web.refreshPage();

        MainPage mainPage = new MainPage(driver);
        mainPage.switchToLinnenSubcategoryLandingPage();
        CategoryLandingPage categoryLandingPage = new CategoryLandingPage(driver);
        categoryLandingPage.switchToFirstProductDetailPage();
        ProductDetailsPage productDetailPage = new ProductDetailsPage(driver);

        productDetailPage.checkProductDetailPageUI();

    }

    @Test
    public void checkingColorAndSizeSelectionTest () throws NoElementFound {
        web.openPage(baseUrl);
        web.refreshPage();

        MainPage mainPage = new MainPage(driver);
        mainPage.switchToLinnenSubcategoryLandingPage();
        CategoryLandingPage categoryLandingPage = new CategoryLandingPage(driver);
        categoryLandingPage.switchToFirstProductDetailPage();
        ProductDetailsPage productDetailPage = new ProductDetailsPage(driver);
        productDetailPage.selectProductSize();
        productDetailPage.checkSelectedSize();

    }

    @Test
    public void openProductPageTest() throws NoElementFound {
        web.openPage(baseUrl);
        web.refreshPage();

        MainPage mainPage = new MainPage(driver);
        mainPage.switchToLinnenSubcategoryLandingPage();
        CategoryLandingPage categoryLandingPage = new CategoryLandingPage(driver);
        categoryLandingPage.switchToFirstProductDetailPage();
        ProductDetailsPage productDetailPage = new ProductDetailsPage(driver);

        Assert.assertTrue(productDetailPage.isDisplayedCorrectProductPage(), "Switching to Product Detail Page was incorrect");
    }



}
