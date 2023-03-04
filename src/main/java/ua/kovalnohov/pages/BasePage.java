package ua.kovalnohov.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    private WebDriver driver;
    protected Logger log = Logger.getLogger(BasePage.class);

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
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

    protected boolean isElementDisplayed(WebElement element) {
        try {
            boolean state = element.isDisplayed();
            String message;
            if (state) {
                message = getElementName(element) + " Element is displayed";
            } else {
                message = getElementName(element) + " Element is not displayed";
            }
            log.info(message);
            return state;
        } catch (Exception e) {
            log.info("Element is not displayed");
            return false;
        }
    }

    protected void waitUntilElementNotVisible(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.invisibilityOf(element));
    }
    protected  void waitForLoad(WebDriver driver) {

    }

    private String getElementName(WebElement element) {
        try {
            return element.getAccessibleName();
        } catch (Exception e) {
            return "";
        }
    }

}
