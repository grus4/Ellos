package pages;


import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import utils.WebElementsActions;

public class MyDashboardPage {

    private WebElementsActions web;
    public static final Logger log = Logger.getLogger(MyDashboardPage.class);

    public MyDashboardPage(WebDriver driver) {
        web = new WebElementsActions(driver);
    }


}
