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
            log.info("Correct switching to product page");
            return true;
        } else {
            log.error("INCORRECT switching to product page!");
            Assert.fail("INCORRECT switch to product page!");
            return false;
        }

    }

    public boolean isMainImageAvailable() throws NoElementFound {
        if (web.isElementPresent("MainImage") && web.isElementAvailable("MainImage")) {
            log.info("Main image is present");
            return true;
        } else {
            log.error("Main image is not present");
            Assert.fail("Main image is not displayed");
            return false;
        }
    }

    public boolean isSizeDropdownAvailable() throws NoElementFound {

        if (web.isElementPresent("DressSizeDropDown") && web.isElementAvailable("DressSizeDropDown")) {
            log.info("Size dropdown is present");
            return true;
        } else {
            log.error("Size dropdown is not present");
            Assert.fail("Size dropdown is not displayed on the page");
            return false;
        }
    }

    public boolean isColorDropdownAvailable() throws NoElementFound {
        if (web.isElementPresent("DressColorDropDown") && web.isElementAvailable("DressColorDropDown")) {
            log.info("Color dropdown is present");
            return true;
        } else {
            log.error("Color dropdown is not present");
            Assert.fail("Color dropdown is not displayed");
            return false;
        }
    }


    public boolean isTheFirstThumbnailAvailable() throws NoElementFound {

        if (web.isElementPresent("FirstThumbnail") && web.isElementAvailable("FirstThumbnail")) {
            log.info("The FirstThumbnail is present");
            return true;
        } else {
            log.error("The FirstThumbnail is not present");
            Assert.fail("The FirstThumbnail is not present");
            return false;
        }

    }

    public boolean isTheSecondThumbnailAbailable() throws NoElementFound {

        if (web.isElementPresent("SecondThumbnail") && web.isElementAvailable("SecondThumbnail")) {
            log.info("The Second Thumbnail is present");
            return true;
        } else {
            log.error("The Second Thumbnail is not present");
            Assert.fail("The Second Thumbnail is not present");
            return false;
        }

    }

    public boolean isTheThirdThumbnailAvailable() throws NoElementFound {

        if (web.isElementPresent("ThirdThumbnail") && web.isElementAvailable("ThirdThumbnail")) {
            log.info("The Third Thumbnail is present");
            return true;
        } else {
            log.error("The Third Thumbnail is not present");
            Assert.fail("The Third Thumbnail is not present");
            return false;
        }

    }

    public boolean isTheFourthThumbnailAvailable() throws NoElementFound {

        if (web.isElementPresent("FourthThumbnail") && web.isElementAvailable("FourthThumbnail")) {
            log.info("The Fourth Thumbnail is present");
            return true;
        } else {
            log.error("The Fourth Thumbnail is not present");
            Assert.fail("The Fourth Thumbnail is not present");
            return false;
        }


    }

    public boolean isAddToCartButtonAvailable() throws NoElementFound {
        if (web.isElementPresent("AddToCartButton") && web.isElementAvailable("AddToCartButton")) {
            log.info("Add to Cart button is present");
            return true;
        } else {
            log.error("Add to Cart button is not displayed");
            Assert.fail("Add to Cart button is not displayed");
            return false;
        }
    }

    public boolean isProductPriceAvailable() throws NoElementFound {
        if (web.isElementPresent("ProductPrice") && web.isElementAvailable("ProductPrice")) {
            log.info("Product price is displayed correctly on the PDP");
            return true;
        } else {
            log.error("Product price is not displayed");
            Assert.fail("Product price is not displayed");
            return false;
        }
    }


    public void selectProductSize() {
        try {
            web.clickElement("SizeDropdownField");
            log.info("Dropdown field was clicked");
            web.clickElement("FirsSizeItem");
            log.info("Size was selected");
        } catch (NoElementFound noElementFound) {
            log.error("Dropdown field was not clicked");
        }
    }

    public void checkingImages() throws NoElementFound {
        if (isMainImageAvailable()
                && isTheFirstThumbnailAvailable()
                && isTheSecondThumbnailAbailable()
                && isTheThirdThumbnailAvailable()
                && isTheFourthThumbnailAvailable()) {
            log.info("Main image and product thumbnails are displayed correctly");

        } else {

            String stringError = "main image is not displayed - " + isMainImageAvailable() + "\n" +
                    "The first thumbnail is not displayed - " + isTheFirstThumbnailAvailable() + "\n" +
                    "The second thumbnail is not displayed - " + isTheSecondThumbnailAbailable() + "\n" +
                    "The third thumbnail is not displayed - " + isTheThirdThumbnailAvailable() + "\n" +
                    "The fourth thumbnail is not displayed - " + isTheFourthThumbnailAvailable();

            log.error(stringError);
            Assert.fail(stringError);

        }
    }
        public void checkingProductAtributes() throws NoElementFound {

            if(isProductPriceAvailable()
                    && isColorDropdownAvailable()
                    && isSizeDropdownAvailable()) {

                log.info("Product attributes are displayed correctly");

            } else {
                String stringError = "Product price is not displayed - " + isProductPriceAvailable() + "\n" +
                        "Color dropdown is not displayed - " + isColorDropdownAvailable() + "\n" +
                        "Size dropdown is not displayed - " + isSizeDropdownAvailable();

                log.info(stringError);
                Assert.fail(stringError);
            }
    }

    public void checkingAddToCartButton() throws NoElementFound {
        if(isAddToCartButtonAvailable()) {
            log.info("Add to cart button is displayed correctly");
        } else {
            log.error("Add to cart button is not displayed - " + isAddToCartButtonAvailable());
            Assert.fail("Add to cart button is not displayed - " + isAddToCartButtonAvailable());
        }
    }



    public void checkSelectedSize() throws NoElementFound {
        String selectedSize = web.getElementText("FirsSizeItem");
        String expected = "38";

        Assert.assertEquals("Selected size" + selectedSize + " is incorrect", expected, selectedSize);
    }

    public void checkProductDetailPageUI() throws NoElementFound {

        checkingImages();
        checkingProductAtributes();
        checkingAddToCartButton();
    }

    public void addProductToCart() throws NoElementFound {
        web.windowScroll();
        web.clickButton("AddToCartButton");
        log.info("Add to cart button was clicked");
    }





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
