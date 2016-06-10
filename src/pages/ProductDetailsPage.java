package pages;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.NoElementFound;
import utils.WebElementsActions;

/**
 * Created by user on 6/5/2016.
 */
public class ProductDetailsPage {

    private WebElementsActions web;
    public static final Logger log = Logger.getLogger(ProductDetailsPage.class);

    public ProductDetailsPage(WebDriver driver) {
        web = new WebElementsActions(driver);
    }


    public boolean isDisplayedCorrectProductPage() throws NoElementFound {

            if (web.isElementPresent("MainImage") && web.isElementAvailable("MainImage")
                    && web.isElementPresent("FirstThumbnail") && web.isElementAvailable("FirstThumbnail")) {
                log.info("Correct switch to product page");
                return true;
            } else {
                log.error("INCORRECT switch to product page!");
                return false;
            }

    }

    public boolean isMainImageAvailable() throws NoElementFound {
            if (web.isElementPresent("MainImage") && web.isElementAvailable("MainImage")) {
                log.info("Main image is present");
                return true;
            } else {
                log.error("Main image is not present");
                return false;
            }
    }

    public boolean isSizeDropdownAvailable() throws NoElementFound {

        if (web.isElementPresent("DressSizeDropDown") && web.isElementAvailable("DressSizeDropDown")) {
            log.info("Size dropdown is present");
            return true;
        } else {
            log.error("Size dropdown is not present");
            return false;
        }
    }

    public boolean isColorDropdownAvailable() throws NoElementFound {
            if (web.isElementPresent("DressColorDropDown") && web.isElementAvailable("DressColorDropDown")) {
                log.info("Color dropdown is present");
                return true;
            } else {
                log.error("Color dropdown is not present");
                return false;
            }
    }


    public boolean isTheFirstThumbnailAvailable() throws NoElementFound {

            if (web.isElementPresent("FirstThumbnail") && web.isElementAvailable("FirstThumbnail")) {
                log.info("The FirstThumbnail is present");
                return true;
            } else {
                log.error("The FirstThumbnail is not present");
                return false;
            }

    }

    public boolean isTheSecondThumbnailAbailable() throws NoElementFound {

            if (web.isElementPresent("SecondThumbnail") && web.isElementAvailable("SecondThumbnail")) {
                log.info("The Second Thumbnail is present");
                return true;
            } else {
                log.error("The Second Thumbnail is not present");
                return false;
            }

    }

    public boolean isTheThirdThumbnailAvailable() throws NoElementFound {

            if (web.isElementPresent("ThirdThumbnail") && web.isElementAvailable("ThirdThumbnail")) {
                log.info("The Third Thumbnail is present");
                return true;
            } else {
                log.error("The Third Thumbnail is not present");
                return false;
            }

    }

    public boolean isTheFourthThumbnailAvailable() throws NoElementFound {

            if (web.isElementPresent("FourthThumbnail") && web.isElementAvailable("FourthThumbnail")) {
                log.info("The Fourth Thumbnail is present");
                return true;
            } else {
                log.error("The Fourth Thumbnail is not present");
                return false;
            }


    }

    public boolean isAddToCartButtonAvailable() throws  NoElementFound {
        if(web.isElementPresent("AddToCartButton") && web.isElementAvailable("AddToCartButton")) {
            log.info("Add to Cart button is present");
            return true;
        } else {
            log.error("Add to Cart button is not displayed");
            return false;
        }
    }

    public void selectProductSize()  {
        try {
            web.clickElement("SizeDropdownField");
            log.info("Dropdown field was clicked");
            web.clickElement("36SizeItem");
            log.info("Size was selected");
        } catch (NoElementFound noElementFound) {
            log.error("Dropdown field was not clicked");
        }
    }

    public void chekcCorrectPDPUI() throws NoElementFound {
        /*if (isMainImageAvailable()
                && isTheFirstThumbnailAvailable()
                &&
                ...
                ...
                ) {

            log.info("Product attributes is correct");
        } else {
            String stringError = "image is not displayed - " + isMainImageAvailable() + "\n" +
                    "irst thumbnails is not displayed - " + isTheFirstThumbnailAvailable();

            log.error(stringError);
            Assert.fail(stringError);

            //OR

            log.error("image is not displayed - " + isMainImageAvailable() +
            "irst thumbnails is not displayed - " + isTheFirstThumbnailAvailable()
            ...
            ...
            );
            Assert.fail("image is not displayed - " + isMainImageAvailable() +
                    "irst thumbnails is not displayed - " + isTheFirstThumbnailAvailable()
            ...
            ...
            );   */
        }

/*        Assert.assertTrue("Main image is not displayed", productDetailPage.isMainImageAvailable());
        Assert.assertTrue("The first thumbnails is not displayed", productDetailPage.isTheFirstThumbnailAvailable());
        Assert.assertTrue("The second thumbnails is not displayed", productDetailPage.isTheSecondThumbnailAbailable());
        Assert.assertTrue("The third thumbnails is not displayed", productDetailPage.isTheThirdThumbnailAvailable());
        Assert.assertTrue("The fourth thumbnails is not displayed", productDetailPage.isTheFourthThumbnailAvailable());
        Assert.assertTrue("The size dropdown is not displayed", productDetailPage.isSizeDropdownAvailable());
        Assert.assertTrue("The color dropdown is not displayed", productDetailPage.isColorDropdownAvailable());
        Assert.assertTrue("The Add to cart button is not displayed", productDetailPage.isAddToCartButtonAvailable());*/




   /* public boolean isSizeDropdownAvailble() {
        if (web.isElementPresent("")
                && web.isElementAvailable()) {  //driver.isEnable()
            log.info("");
            return true;
        } else {
            log.error("");
            return false;
        }
    }


    public void checkSizeDropdownAvailble() {
        if (web.isElementPresent("")
                && web.isElementAvailable()) {  //driver.isEnable()
            log.info("");
        } else {
            log.error("");
            Assert.fail("");
        }
    }*/




}
