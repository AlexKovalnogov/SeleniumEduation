package ua.kovalnohov.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {
    protected WebDriver driver;
    @FindBy(xpath = "//div[@class='panel header']//ul//li//a[text()='Create an Account']")
    private WebElement createAccountButton;
    @FindBy(xpath = "//div[@class='panel header']//ul//li[@class='authorization-link']//a")
    private WebElement signIn;


    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public CreateAccountPage clickCreateAccount() {
        clickOnElement(createAccountButton);
        return new CreateAccountPage(driver);
    }

    public CustomerLoginPage clickSignIn() {
        clickOnElement(signIn);
        return new CustomerLoginPage(driver);
    }
}
