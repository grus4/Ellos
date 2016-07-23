package pages;


import utils.WebDriverWrapper;
import utils.WebElementsActions;


public class Ellos {

    public WebElementsActions web;
    public MainPage mainPage;
    public LoginPage loginPage;
    public ProductDetailsPage productDetailsPage;
    public SuccessfulRegistrationPage successfulRegistrationPage;
    public CategoryLandingPage categoryLandingPage;

    public Ellos(WebDriverWrapper driver) {

        web  = new WebElementsActions(driver);
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        productDetailsPage = new ProductDetailsPage(driver);
        successfulRegistrationPage = new SuccessfulRegistrationPage(driver);
        categoryLandingPage = new CategoryLandingPage(driver);

    }

}