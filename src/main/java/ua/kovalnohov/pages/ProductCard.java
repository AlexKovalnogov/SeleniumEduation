package ua.kovalnohov.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductCard extends BasePage {
    private WebDriver driver;
    private int cardIndex;
    String cardXpath = "(.//div[@class='product-item-info'])[%s]";
    String sizeXpath = "//div[@aria-label='%s']";
    String colorXpath = "//div[@aria-label='%s']";
    String addToCartXpath = "//span[text()='Add to Cart']";
    String productTitle = "//a[@class='product-item-link']";
    String alertMessage = "//div[@class='page messages']";

    public ProductCard(WebDriver driver, int cardIndex) {
        super(driver);
        this.driver = driver;
        this.cardIndex = cardIndex;
    }

    public enum Size {
        XS,
        M,
        L,
        XL
    }

    public enum Colors {
        Red,
        Black,
        Blue,
        Orange
    }


    public ProductCard selectSize(Size size) {
        clickOnElement(getWebElement(String.format(cardXpath, cardIndex) + String.format(sizeXpath, size.name())));
        return this;
    }

    public ProductCard selectColor(Colors itemColor) {
        clickOnElement(getWebElement(String.format(cardXpath, cardIndex) + String.format(colorXpath, itemColor.name())));
        return this;
    }

    public ProductCard AddToCart() {
        clickOnElement(getWebElement(addToCartXpath));
        waitUntilElementClickable(getWebElement(addToCartXpath));
        return this;
    }

    public String getProductTitle(){
        return getText(getWebElement(String.format(cardXpath, cardIndex) + productTitle));
    }

    public ProductCard checkProductCardName(String itemName) {
        WebElement webElement = getWebElement(String.format(cardXpath, cardIndex) + productTitle);
        Assert.assertEquals("Wrong product item Name ", getText(webElement), itemName);
        return this;
    }

    public ProductCard checkSuccessfulAddingAlertMessage(String name) {
        WebElement alert = getWebElement(alertMessage);
        Assert.assertTrue("Alert is non visible after adding item to cart", isElementDisplayed(alert));
        Assert.assertEquals("Wrong text in alert", String.format("You added %s to your shopping cart.", name), getText(alert));
        return this;
    }
}
