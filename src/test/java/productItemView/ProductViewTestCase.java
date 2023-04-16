package productItemView;

import Executor.TestRunner;
import org.junit.Test;
import ua.kovalnohov.pages.ItemsCardPage;
import ua.kovalnohov.pages.menu.Menu;
import ua.kovalnohov.pages.menu.subMenu.SubMenu;

public class ProductViewTestCase extends TestRunner {
    @Test
    public void testThatUserCanChangeGoodsView() {
        homePage.getMenu()
                .selectMenuItem(Menu.Items.MAN)
                .selectMenuItem(SubMenu.SubMenuItems.TOPS).
                openItemsPage()
                .changeProductView(ItemsCardPage.ProductsView.LIST)
                .checkItemsView(ItemsCardPage.ProductsView.LIST);
    }
}
