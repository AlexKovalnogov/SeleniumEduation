package ua.kovalnohov.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {
    private WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected WebElement getWebElement(String xpath) {
        return driver.findElement(By.xpath(xpath));
    }

    protected void typeTextToElements(String text, WebElement element) {
        try {
            element.clear();
            element.sendKeys(text);
        } catch (Exception e) {
            throw new AssertionError(e);
        }
    }

    protected void clickOnElement(WebElement element) {
        try {
            element.click();
        } catch (Exception e) {

        }

    }

}
