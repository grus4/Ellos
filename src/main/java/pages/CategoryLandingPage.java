package pages;


import org.apache.log4j.Logger;
import utils.ClassNameUtil;
import utils.WebDriverWrapper;



public class CategoryLandingPage extends Page {

    public static final Logger log = Logger.getLogger(ClassNameUtil.getCurrentClassName());

    public CategoryLandingPage(WebDriverWrapper dr) {
        super(dr);

    }

    public void switchToFirstProductDetailPage() {
        web.moveToElementAndClick("FirstProductLinnenLP","ActiveThumbnail");
        log.info("the first element was clicked");
        web.windowScroll();
    }


}
