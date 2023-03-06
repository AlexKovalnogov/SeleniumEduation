package ua.kovalnohov.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.kovalnohov.pages.menu.MainMenu;

public class HomePage extends BasePage {
    private WebDriver driver;
    private MainMenu menu;
    @FindBy(xpath = "//div[@class='panel header']//ul//li//a[text()='Create an Account']")
    private WebElement createAccountButton;
    @FindBy(xpath = "//div[@class='panel header']//ul//li[@class='authorization-link']//a")
    private WebElement signIn;


    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.menu=new MainMenu(driver);
    }

    public MainMenu getMenu() {
        return menu;
    }

    public CreateAccountPage openCreateAccountPage() {
        clickOnElement(createAccountButton);
        return new CreateAccountPage(driver);
    }

    public CustomerLoginPage openCustomerLoginPage() {
        clickOnElement(signIn);
        return new CustomerLoginPage(driver);
    }


}
