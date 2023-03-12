package ua.kovalnohov.pages;

import org.openqa.selenium.WebDriver;
import ua.kovalnohov.pages.header.Header;
import ua.kovalnohov.pages.menu.Menu;

public class BasePage extends ActionsWithElement {
    private WebDriver driver;


    public BasePage(WebDriver driver) {
        super(driver);
        this.driver = driver;

    }

    public Header getHeader() {
        return new Header(driver);
    }

}
