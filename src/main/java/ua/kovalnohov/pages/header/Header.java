package ua.kovalnohov.pages.header;

import com.github.dockerjava.api.command.CopyArchiveToContainerCmd;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.kovalnohov.pages.*;

public class Header extends BasePage {
    private WebDriver driver;
    @FindBy(xpath = ".//div[@class='panel header']//ul//li[@class='authorization-link']//a")
    private WebElement signIn;
    @FindBy(xpath = ".//div[@class='panel header']//ul//li//a[text()='Create an Account']")
    private WebElement createAccountButton;
    @FindBy(id = "search")
    private WebElement searchField;
    @FindBy(xpath = ".//span[@class='counter-number']")
    private WebElement cartCounter;
    @FindBy(xpath = ".//*[@class='action showcart']")
    private WebElement cart;

    private ItemsCardPage itemsCardPage;

    public Header(WebDriver driver) {
        super(driver);
        this.driver = driver;
        itemsCardPage = new ItemsCardPage(driver);
    }

    public CustomerLoginPage openCustomerLoginPage() {
        clickOnElement(signIn);
        return new CustomerLoginPage(driver);
    }

    public CreateAccountPage openCreateAccountPage() {
        clickOnElement(createAccountButton);
        return new CreateAccountPage(driver);
    }

    public ItemsCardPage getItemsCardPage() {
        return new ItemsCardPage(driver);
    }

    public ItemsCardPage search(String searchValue) {
        typeTextToElements(searchValue, searchField);
        searchField.sendKeys(Keys.ENTER);
        return new ItemsCardPage(driver);
    }

    public Cart openCart(){
        clickOnElement(cart);
        return new Cart(driver);
    }

    public int getCartCounter(){
        return Integer.valueOf( getText(cartCounter));
    }

    public Header checkCartCounter(int expectedCount){
        Assert.assertEquals("Counter number is wrong",getCartCounter(),expectedCount);
        return this;
    }
}
