package utils;

import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class WebElementsActions {

    private WebDriver driver;
    private static WebDriverWait waitForElement;

    public static final Logger log = Logger.getLogger(WebElementsActions.class);


    public WebElementsActions(WebDriver driver) {

        this.driver = driver;
        waitForElement = new WebDriverWait(driver, 20);
    }


    public void openPage(String siteURL){
        driver.get(siteURL);
    }

    public void clickElement(String elementLocator) throws NoElementFound {
        driver.findElement(LocatorsParser.ui(elementLocator)).click();
    }

    /**
     * Click a button
     */
    public void clickButton(String buttonLocator) throws NoElementFound {
        driver.findElement(LocatorsParser.ui(buttonLocator)).click();
        log.info("Click on Button " + buttonLocator);
    }

    /**
     * Click link
     */
    public void clickLink(String linkLocator) throws NoElementFound {
        driver.findElement(LocatorsParser.ui(linkLocator)).click();
        log.info("Click on Link " + linkLocator);
    }

    /**
     * Insert value into text input HTML field
     */
    public void input(String inputLocator, String inputData) throws NoElementFound {
        driver.findElement(LocatorsParser.ui(inputLocator)).clear();
        driver.findElement(LocatorsParser.ui(inputLocator)).sendKeys(inputData);
        log.info("Input in " + inputLocator + ", value - " + inputData);
    }

    public void clearField(String inputLocator) throws NoElementFound {
        driver.findElement(LocatorsParser.ui(inputLocator)).clear();
        log.info("Plaseholder was cleaned");
    }

    /**
     * Insert value into text input HTML field and Click ENTER for Field which used "Value" in the xpath expression
     */
    public void inputAndClickEnter(String inputLocator, String inputData) throws NoElementFound {
        driver.findElement(LocatorsParser.ui(inputLocator)).clear();
        driver.findElement(LocatorsParser.ui(inputLocator)).sendKeys(inputData);
        driver.findElement(LocatorsParser.ui(inputLocator)).sendKeys(Keys.ENTER);
        log.info("Input in " + inputLocator + ", value -" + inputData + "and click <Enter> button");
    }
    /**
     * Method is used to check that element is present on page.
     */
    public boolean isElementPresent(String elementLocator) throws NoElementFound {
        if (!driver.findElement(LocatorsParser.ui(elementLocator)).isDisplayed()) {
            log.info("Element is not found");
            return false;
        }
        log.info("Element is present on the page");
        return true;
    }

    /**
     * Method is used to check that element is present in the DOM.
     */
    public boolean isElementAvailable(String elementLocator) throws NoElementFound {
        if(!driver.findElement(LocatorsParser.ui(elementLocator)).isEnabled()) {
            log.info("Element is not found");
            return false;
        }
        log.info("Element is available in the DOM");
        return  true;
    }

    /*private boolean isElementPresent(By by) {
        try {
            driver.findElement(by).isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }*/

    /**
     * This method is used to agree messages on pop-up windows
     */
    public boolean isAlertPresent() {
        boolean alertPresence = false;
        try {
            Alert alert = driver.switchTo().alert();
            alertPresence = true;
            alert.accept();
            log.info("Alert is present");
        } catch (NoAlertPresentException ex) {
            ex.printStackTrace();
            log.info("Alert is not found");
            return alertPresence;
        }
        return alertPresence;
    }


    /**
     * This method is used to get text from pop-up windows
     */
    public String getAlertText() {
        String alertText;
        try {
            Alert alert = driver.switchTo().alert();
            alertText = alert.getText();
            alert.accept();
            log.info("Alert text: " + alertText);
        } catch (NoAlertPresentException ex) {
            alertText = "Alert is not found";
            log.error("Alert is not found");
            ex.printStackTrace();
        }
        return alertText;
    }

    public void moveToElementAndClick(String moveToLocator, String clickToElement) throws NoElementFound {
        WebElement webElement = driver.findElement(LocatorsParser.ui(moveToLocator));

        Actions actions = new Actions(driver);
        actions.moveToElement(webElement);
        actions.perform();  //!!! always need
        clickButton(clickToElement);
        log.info("moved To Element " + moveToLocator + "and clicked on" + clickToElement);
    }

    /**
     *Method#1 for refresh page
     */
    public void refreshPage() {
        driver.navigate().refresh();
        log.info("Page is refreshed");
    }

    /**
     *Methods for pressing the keypad buttons
     */
    public void pressSpaceKey(String inputLocator) throws NoElementFound {

        driver.findElement(LocatorsParser.ui(inputLocator)).sendKeys(Keys.SPACE);
        log.info("input <space> into " + inputLocator + "by pressing the space button on the keypad");
    }

    public void pressEnterKey(String inputLocator) throws NoElementFound {

        driver.findElement(LocatorsParser.ui(inputLocator)).sendKeys(Keys.ENTER);
        log.info("input <ENTER> into " + inputLocator + "by pressing the space button on the keypad");
    }

    public void pressESCAPEKey(String inputLocator) throws  NoElementFound{
        driver.findElement(LocatorsParser.ui(inputLocator)).sendKeys(Keys.ESCAPE);
    }

    public void pressPageUp(String inputLocator) throws NoElementFound {
        driver.findElement(LocatorsParser.ui(inputLocator)).sendKeys(Keys.PAGE_UP);
    }

    public void pressTAB(String locator) throws NoElementFound {

        WebElement webElement = driver.findElement(LocatorsParser.ui((locator)));
        webElement.sendKeys(Keys.TAB);
        log.info(String.format("press TAB"));

    }


    /**
     * This method is used to wait for getting response from all Ajax requests
     */
    public boolean waitForAjaxResponse(int timeoutSeconds) throws InterruptedException {
        //TODO js executor
        if (driver instanceof JavascriptExecutor) {
            JavascriptExecutor jsDriver = (JavascriptExecutor) driver;

            for (int i = 0; i < timeoutSeconds; i++) {
                Long numberOfConnections = (Long) jsDriver.executeScript("return jQuery.active");
                if (numberOfConnections instanceof Long) {
                    log.debug("Number of active jQuery Ajax calls is <" + numberOfConnections + ">");

                    if (numberOfConnections == 0)
                        break;
                }
                // stay(1);
            }
            return false;
        } else {
            log.info("WebElementsActions Driver: <" + driver + "> cann't execute JavaScript");
            return false;
        }
    }

    /**
     * This method is used to do Focus to Element And Click
     * Use Actions class
     */
/*    public void doFocusToElementAndClick(String focusElementLocator, String elementLocator) {
        new Actions(driver.getOriginalDriver()).moveToElement(getElement(focusElementLocator)).perform();
        log.info("Focus in to element" + focusElementLocator);
        driver.switchTo();
        if (isElementPresent(elementLocator)) {
            clickButton(elementLocator);
        }
    }*/


    public WebElement getElement(String elementLocator) throws NoElementFound {
        return driver.findElement(LocatorsParser.ui(elementLocator));
    }

    public List<WebElement> getElements(String elementsLocator) throws NoElementFound {
        return driver.findElements(LocatorsParser.ui(elementsLocator));
    }


    public String getElementText(String elementsLocator) throws NoElementFound {
        return driver.findElement(LocatorsParser.ui(elementsLocator)).getText();
    }

    /**
     * Insert value into text input HTML field without Clean
     */
    public void inputWithoutClean(String inputLocator, String inputData) throws NoElementFound {
        driver.findElement(LocatorsParser.ui(inputLocator)).sendKeys(inputData);
        log.info("Input in " + inputLocator + ", value - " + inputData);
    }


    /**
     * Select value from drop down list
     */
    public void selectFromList(String listLocator, String listValue) throws NoElementFound {
        new Select(driver.findElement(LocatorsParser.ui(listLocator))).selectByValue(listValue);
    }

    /**
     * Wait the element on page specified time
     */
    public void waitElementNotVisible(String elementLocator, int timeoutInS) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeoutInS);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(LocatorsParser.ui(elementLocator)));
        } catch (NoElementFound noElementFound) {
            noElementFound.printStackTrace();
        }
    }

    /**
     * An expectation for checking that an element is present on the DOM of a page and visible.
     * Visibility means that the element is not only displayed but also has a height and width that is greater than 0.
     * Advantages of this method over isElementPresent(By elementLocator); is that it expects the appearance of an element.
     */
    public boolean waitForElementPresent(String elementLocator) {
        try {
            waitForElement.until(ExpectedConditions.visibilityOfElementLocated(LocatorsParser.ui(elementLocator)));
            log.info("WaitForElement _" + elementLocator + "_ Present");
        } catch (NoElementFound noElementFound) {
            log.error("Waiting for the appearance of the element _" + elementLocator + "_ was not successful " +
                    "WaitForElement _" + elementLocator + "_ Present");
            noElementFound.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * Scroll a window
     *
     * @see {@link JavascriptExecutor} and {@link JavascriptExecutor#executeScript(String, Object...)}
     */
    public void windowScroll() {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        // Vertical scroll - down by 100  pixels
        javascriptExecutor.executeScript("window.scrollBy(0,100)", "");
    }



}