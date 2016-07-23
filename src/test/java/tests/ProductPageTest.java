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
public class ProductPageTest extends Fixture{



    @Test
    public void checkingStandardWomenProductDetailsPageUITest() throws NoElementFound {

        ellos.web.openPage(SITE_URL);
        ellos.web.refreshPage();

        ellos.mainPage.switchToLinnenSubcategoryLandingPage();
        ellos.categoryLandingPage.switchToFirstProductDetailPage();

        ellos.productDetailsPage.checkProductDetailPageUI();

    }

    @Test
    public void checkingColorAndSizeSelectionTest () throws NoElementFound {

        ellos.web.openPage(SITE_URL);
        ellos.web.refreshPage();

        ellos.mainPage.switchToLinnenSubcategoryLandingPage();
        ellos.categoryLandingPage.switchToFirstProductDetailPage();
        ellos.productDetailsPage.selectProductSize();
        ellos.productDetailsPage.checkSelectedSize();

    }

    @Test
    public void openProductPageTest() throws NoElementFound {

        ellos.web.openPage(SITE_URL);
        ellos.web.refreshPage();

        ellos.mainPage.switchToLinnenSubcategoryLandingPage();
        ellos.categoryLandingPage.switchToFirstProductDetailPage();

        Assert.assertTrue(ellos.productDetailsPage.isDisplayedCorrectProductPage(), "Switching to Product Detail Page was incorrect");
    }



}
