package ua.kovalnohov.pages.menu.subMenu;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.kovalnohov.pages.BasePage;
import ua.kovalnohov.pages.ItemsPage;
import ua.kovalnohov.pages.menu.Menu;

public class MenMenu extends BasePage implements SubMenu {

    private WebDriver driver;
    @FindBy(xpath="(.//span[text()='Tops'])[2]")
    private WebElement topsMenuItem;
    @FindBy(xpath="(.//span[text()='Bottoms'])[2]")
    private WebElement bottomsMenuItem;

    public MenMenu(WebDriver driver) {
        super(driver);
        this.driver = driver;
        waitUntilElementVisible(topsMenuItem);
    }


    @Override
    public SubMenu selectMenuItem(SubMenuItems item) {
        switch (item){
            case TOPS:{
                moveToElement(topsMenuItem);
            }
           /* case BOTTOMS:{
                moveToElement(bottomsMenuItem);
            }*/
        }
        return this;
    }

    @Override
    public ItemsPage openItemsPage() {
        return null;
    }
}
