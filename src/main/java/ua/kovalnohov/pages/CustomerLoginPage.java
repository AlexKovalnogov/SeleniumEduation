package ua.kovalnohov.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.kovalnohov.utils.ImageUtils;

public class CustomerLoginPage extends BasePage {
    private WebDriver driver;
    @FindBy(id = "email")
    private WebElement emailInput;
    @FindBy(id = "pass")
    private WebElement passwordInput;
    @FindBy(id = "send2")
    private WebElement signIn;
  /*  @FindBy(xpath = "img[@class='captcha-img']")
    private WebElement capcha;
    @FindBy(id = "captcha_user_login")
    private WebElement capchaInput;*/

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
        clickSignIn();
        typeEmail(email);
        typePassword(password);
        typeCapcha();
        return clickSignIn();
    }

    private CustomerLoginPage typeCapcha() {
        WebElement capcha = getWebElement(By.xpath(".//img[@class='captcha-img']"));
        WebElement capchaInput = getWebElement(By.id("captcha_user_login"));
        String capchaData = ImageUtils.getCapchaValue(capcha.getAttribute("src"));
        typeTextToElements(capchaData, capchaInput);
        return this;
    }


}
