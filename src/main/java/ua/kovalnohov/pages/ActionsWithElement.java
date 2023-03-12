package ua.kovalnohov.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ActionsWithElement {
    private WebDriver driver;
    protected Logger log = Logger.getLogger(ActionsWithElement.class);

    public ActionsWithElement(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
        waitForPageLoad();
    }


    protected WebElement getWebElement(String xpath) {
        return driver.findElement(By.xpath(xpath));
    }

    protected WebElement getWebElement(By by) {
        return driver.findElement(by);
    }

    protected void typeTextToElements(String text, WebElement element) {
        try {
            element.clear();
            element.sendKeys(text);
        } catch (Exception e) {
            throw new AssertionError(e);
        }
    }

    protected String getText(WebElement element) {
        try {
            return element.getText();
        } catch (Exception e) {
            return "";
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

    protected void waitUntilElementNotVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    protected void waitUntilElementVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOf(element));
    }


    protected void waitForPageLoad() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String state = js.executeScript("return document.readyState").toString();
        while (!state.equals("complete")) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {

            }
        }
    }

    protected void waitUntilElementClickable(WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
            wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e) {

        }
    }

    protected void moveToElement(By by) {
        WebElement element = getWebElement(by);
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();
    }

    protected void moveToElement(WebElement element) {
        //waitUntilElementVisible(element);
        waitUntilElementClickable(element);
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();
    }

    protected void click() {
        Actions actions = new Actions(driver);
        actions.click();
        actions.perform();
    }

    private String getElementName(WebElement element) {
        try {
            return element.getAccessibleName();
        } catch (Exception e) {
            return "";
        }
    }
}