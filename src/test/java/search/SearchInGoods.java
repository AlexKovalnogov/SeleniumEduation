package search;

import Executor.TestRunner;
import org.junit.Test;
import ua.kovalnohov.pages.menu.Menu;
import ua.kovalnohov.pages.menu.subMenu.SubMenu;

public class SearchInGoods extends TestRunner {

    @Test
    public void testThatUserIsAbleToSearch () {
        homePage.getMenu()
                .selectMenuItem(Menu.Items.MAN)
                .selectMenuItem(SubMenu.SubMenuItems.TOPS)
                .openItemsPage()
                .getHeader()
                .search("Chloe")
                .checkExpectedItemsCount(1)
                .selectItem(1)
                .checkProductCardName("Chloe Compete Tank");
    }
}
