package cart;

import Executor.TestRunner;
import org.junit.Test;
import ua.kovalnohov.pages.menu.Menu;
import ua.kovalnohov.pages.menu.subMenu.SubMenu;

public class AddGoodsToCart extends TestRunner {

    @Test
    public void testThatNotAuthorizesUserCanAddGoodsToCard() {
      homePage.getMenu()
              .selectMenuItem(Menu.Items.MAN)
              .selectMenuItem(SubMenu.SubMenuItems.TOPS)
              .selectMenuItem(SubMenu.SubMenuItems.JACKETS)
              .openItemsPage();
    }
}
