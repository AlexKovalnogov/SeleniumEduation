package ua.kovalnohov.pages.menu.subMenu;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.kovalnohov.pages.BasePage;
import ua.kovalnohov.pages.ItemsCardPage;
import ua.kovalnohov.pages.header.Header;

public class MenMenu extends BasePage implements SubMenu {

    private WebDriver driver;
    @FindBy(xpath = "(.//span[text()='Tops'])[2]")
    private WebElement topsMenuItem;
    @FindBy(xpath = "(.//span[text()='Bottoms'])[2]")
    private WebElement bottomsMenuItem;

    public MenMenu(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }


    @Override
    public SubMenu selectMenuItem(SubMenuItems item) {
        switch (item) {
            case TOPS: {
                moveToElement(topsMenuItem);
            }
           /* case BOTTOMS:{
                moveToElement(bottomsMenuItem);
            }*/
        }
        return new MenSubMenu(driver);
    }

    @Override
    public ItemsCardPage openItemsPage() {
        click();
        return new ItemsCardPage(driver);
    }

}
