package ua.kovalnohov.pages;

import org.openqa.selenium.WebDriver;
import ua.kovalnohov.pages.menu.subMenu.SubMenu;

public class ItemsPage  extends BasePage{
    private WebDriver driver;

    public ItemsPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
    }

    public void selectItem(int index){


    }
}
