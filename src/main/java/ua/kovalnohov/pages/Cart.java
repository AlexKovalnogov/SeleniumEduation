package ua.kovalnohov.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Cart extends BasePage {
    private WebDriver driver;
@FindBy(xpath=".//div[@id='minicart-content-wrapper']//li[@class='item product product-item']")
   private List<WebElement> items;

    public Cart(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public Cart checkItemsCountInCart( int expected){
        Assert.assertEquals("",expected,items.size());
        return this;
    }
}
