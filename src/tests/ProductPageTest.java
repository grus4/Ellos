import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.CategoryLandingPage;
import pages.MainPage;
import pages.ProductDetailsPage;
import utils.WebElementsActions;

import java.util.concurrent.TimeUnit;

/**
 * Created by user on 6/5/2016.
 */
public class ProductPageTest extends Fixture {



    @Test
    public void testForStandardWomenProductDetailsPageUI() throws Exception {

        web.openPage(baseUrl);
        web.refreshPage();

        MainPage mainPage = new MainPage(driver);
        mainPage.switchToLinnenSubcategoryLandingPage();
        CategoryLandingPage categoryLandingPage = new CategoryLandingPage(driver);
        categoryLandingPage.switchToFirstProductDetailPage();
        ProductDetailsPage productDetailPage = new ProductDetailsPage(driver);

        //Assert.assertTrue("PDP is incorrect", productDetailPage.isDisplayedCorrectProductPage());
        Assert.assertTrue("Main image is not displayed", productDetailPage.isMainImageAvailable());
        Assert.assertTrue("The first thumbnails is not displayed", productDetailPage.isTheFirstThumbnailAvailable());
        Assert.assertTrue("The second thumbnails is not displayed", productDetailPage.isTheSecondThumbnailAbailable());
        Assert.assertTrue("The third thumbnails is not displayed", productDetailPage.isTheThirdThumbnailAvailable());
        Assert.assertTrue("The fourth thumbnails is not displayed", productDetailPage.isTheFourthThumbnailAvailable());
        Assert.assertTrue("The size dropdown is not displayed", productDetailPage.isSizeDropdownAvailable());
        Assert.assertTrue("The color dropdown is not displayed", productDetailPage.isColorDropdownAvailable());
        Assert.assertTrue("The Add to cart button is not displayed", productDetailPage.isAddToCartButtonAvailable());

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
