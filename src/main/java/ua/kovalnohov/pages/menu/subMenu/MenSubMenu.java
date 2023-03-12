package ua.kovalnohov.pages.menu.subMenu;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.kovalnohov.pages.BasePage;
import ua.kovalnohov.pages.ItemsCardPage;

public class MenSubMenu extends BasePage implements SubMenu {

    private WebDriver driver;
    @FindBy(xpath = "(.//span[text()='Jackets'])[2]")
    private WebElement jacketItem;

    public MenSubMenu(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Override
    public MenSubMenu selectMenuItem(SubMenuItems item) {
        switch (item) {
            case JACKETS: {
                moveToElement(jacketItem);
            }
        }

        return this;
    }

    @Override
    public ItemsCardPage openItemsPage() {
        click();
        return new ItemsCardPage(driver);
    }
}
