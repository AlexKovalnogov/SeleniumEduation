package cart;

import Executor.TestRunner;
import org.junit.Test;
import ua.kovalnohov.pages.ProductCard;
import ua.kovalnohov.pages.header.Header;
import ua.kovalnohov.pages.menu.Menu;
import ua.kovalnohov.pages.menu.subMenu.SubMenu;

public class AddGoodsToCart extends TestRunner {

    @Test
    public void testThatNotAuthorizesUserCanAddGoodsToCard() {
        ProductCard jacket = homePage.getMenu()
                .selectMenuItem(Menu.Items.MAN)
                .selectMenuItem(SubMenu.SubMenuItems.TOPS)
                .selectMenuItem(SubMenu.SubMenuItems.JACKETS)
                .openItemsPage()
                .checkIsRedirectToCorrectPage("Jackets")
                .selectItem(1)
                .selectColor(ProductCard.Colors.Black)
                .selectSize(ProductCard.Size.M)
                .AddToCart();


        jacket.checkSuccessfulAddingAlertMessage(jacket.getProductTitle());
        jacket.getHeader()
                .checkCartCounter(1)
                .openCart()
                .checkItemsCountInCart(1);

    }
}
