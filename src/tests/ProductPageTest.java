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
public class ProductPageTest {

    private static WebDriver driver;
    private static WebElementsActions web;
    private String baseUrl = "http://www.ellos.se/";

    @BeforeClass
    public static void setUp() {
        driver = new FirefoxDriver();
        web = new WebElementsActions(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }



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

    }

    public static void tearDown() {
        driver.quit();
    }


}
