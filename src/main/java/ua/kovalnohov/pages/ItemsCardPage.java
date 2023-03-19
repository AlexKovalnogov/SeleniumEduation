package ua.kovalnohov.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ItemsCardPage extends BasePage {
    private WebDriver driver;
    @FindBy(xpath = ".//div[@class='product-item-info']")
    private List<WebElement> productItems;
    @FindBy(xpath = ".//span[@data-ui-id='page-title-wrapper']")
    private WebElement categoryTitle;
    @FindBy(xpath = ".//a[@title='Grid']")
    private WebElement gridViewButton;
    @FindBy(xpath = ".//a[@title='List']")
    private WebElement listViewButton;


    public ItemsCardPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void checkItemsView(ProductsView list) {
        WebElement element = productItems.get(0);
        String attribute = element.getAttribute("data-container");
            Assert.assertTrue("Wrong products view after switching", attribute.contains(list.name().toLowerCase()));


    }

    public enum ProductsView {
        LIST,
        GRID;
    }

    public ProductCard selectItem(int index) {
        return new ProductCard(driver, index);
    }

    public ItemsCardPage checkIsRedirectToCorrectPage(String itemsCategory) {
        Assert.assertEquals(String.format("Page with %s is not opened", itemsCategory), categoryTitle.getText(), itemsCategory);
        return this;
    }

    public ItemsCardPage checkExpectedItemsCount(int expecetedCount) {
        Assert.assertTrue("Count expected items and items in list are different", expecetedCount == productItems.size());
        return this;
    }

    public ItemsCardPage changeProductView(ProductsView view) {
        switch (view) {
            case LIST:
                clickOnElement(listViewButton);
                break;
            case GRID:
                clickOnElement(gridViewButton);
                break;
        }
        return this;
    }
}
