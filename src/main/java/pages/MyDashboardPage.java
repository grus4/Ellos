package pages;


import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import utils.ClassNameUtil;
import utils.WebDriverWrapper;
import utils.WebElementsActions;

public class MyDashboardPage extends Page{

    public static final Logger log = Logger.getLogger(ClassNameUtil.getCurrentClassName());

    public MyDashboardPage(WebDriverWrapper dr) {
        super(dr);
    }
}
