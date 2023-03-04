package ua.kovalnohov.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage extends BasePage {

    private WebDriver driver;
    @FindBy(xpath = ".//span[@class='logged-in']")
    private WebElement userGreating;
    @FindBy(xpath = ".//div[@role='alert']")
    private WebElement successMessage;

    public MyAccountPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public MyAccountPage checkThatUserRedirectedOnAccountPage(String name, String lastName) {
        //TODO need delete sleep from constructor and add wait document ready state
        Assert.assertTrue("User greatings is not present  ", isElementDisplayed(userGreating));
        Assert.assertEquals("Greating hs wrong text ", userGreating.getText(), String.format("Welcome, %s %s!", name, lastName));
        return this;
    }

    public MyAccountPage checkThatSuccessMessageDisplayed() {
      Assert.assertTrue("Success message about user creation is not visisble", isElementDisplayed(successMessage));
        return this;
    }
}
