package ua.kovalnohov.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateAccountPage extends BasePage {
    private WebDriver driver;
    @FindBy(id = "firstname")
    private WebElement firstNameField;
    @FindBy(id = "lastname")
    private WebElement lastNameField;
    @FindBy(id = "email_address")
    private WebElement emailField;
    @FindBy(id = "password")
    private WebElement passwordField;
    @FindBy(id = "password-confirmation")
    private WebElement confirmPasswordField;
    @FindBy(xpath = ".//button[@class='action submit primary']")
    private WebElement createAccountButton;
    @FindBy(xpath = ".//h1//span")
    private WebElement createPageLabel;

    public CreateAccountPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public CreateAccountPage typeFirstName(String name) {
        typeTextToElements(name, firstNameField);

        return this;
    }

    public CreateAccountPage typeLastName(String lastName) {
        typeTextToElements(lastName, lastNameField);
        return this;
    }

    public CreateAccountPage typeEmail(String email) {
        typeTextToElements(email, emailField);
        return this;
    }

    public CreateAccountPage typePassword(String password) {
        typeTextToElements(password, passwordField);
        return this;
    }

    public CreateAccountPage typeConfirmPassword(String password) {
        typeTextToElements(password, confirmPasswordField);
        return this;
    }

    public CustomerAccountPage clickCreateAccountButton() {
        clickOnElement(createAccountButton);
        waitUntilElementNotVisible(createAccountButton);
        return new CustomerAccountPage(driver);
    }

    public CreateAccountPage checkIsRedorectToCreateAccountPage() {
        Assert.assertTrue("Create account page is not opened", createPageLabel.isDisplayed());
        return this;
    }
}
