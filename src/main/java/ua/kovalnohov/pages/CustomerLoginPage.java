package ua.kovalnohov.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CustomerLoginPage extends BasePage {
    private WebDriver driver;
    @FindBy(id = "email")
    private WebElement emailInput;
    @FindBy(id = "pass")
    private WebElement passwordInput;
    @FindBy(id = "send2")
    private WebElement signIn;

    public CustomerLoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public CustomerLoginPage typeEmail(String email) {
        typeTextToElements(email, emailInput);
        return this;
    }

    public CustomerLoginPage typePassword(String password) {
        typeTextToElements(password, passwordInput);
        return this;
    }

    public HomePage clickSignIn() {
        clickOnElement(signIn);
        return new HomePage(driver);
    }

    public HomePage signInWithCreds(String email, String password) {
        typeEmail(email);
        typePassword(password);
        return clickSignIn();
    }
}
