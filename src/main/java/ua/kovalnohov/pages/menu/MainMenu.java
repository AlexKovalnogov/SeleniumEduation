package ua.kovalnohov.pages.menu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.kovalnohov.pages.BasePage;
import ua.kovalnohov.pages.menu.subMenu.MenMenu;
import ua.kovalnohov.pages.menu.subMenu.SubMenu;

public class MainMenu extends BasePage implements Menu {
    private WebDriver driver;
    @FindBy(xpath = ".//span[text()='Men']")
    private WebElement menMenuItem;

    public MainMenu(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }


    public SubMenu selectMenuItem(Items item) {
        SubMenu menu=null;
        switch (item) {
            case WHATS_NEW: {

            }
            case MAN: {
                moveToElement(menMenuItem);
                menu = new MenMenu(driver);
                return menu;
            }
            case WOMAN: {

            }
            case GEAR: {

            }
            case TRAINING: {

            }
            case SALE: {

            }
        }
        return menu;
    }


}
