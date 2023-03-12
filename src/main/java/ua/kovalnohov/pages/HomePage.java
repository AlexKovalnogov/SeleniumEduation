package ua.kovalnohov.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.kovalnohov.pages.header.Header;
import ua.kovalnohov.pages.menu.MainMenu;

public class HomePage extends BasePage {
    private WebDriver driver;
    private MainMenu menu;
    private Header header;

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.menu=new MainMenu(driver);
        this.header= new Header(driver);
    }

    public MainMenu getMenu() {
        return menu;
    }

}
