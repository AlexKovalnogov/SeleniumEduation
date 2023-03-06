package ua.kovalnohov.pages.menu.subMenu;

import ua.kovalnohov.pages.ItemsPage;
import ua.kovalnohov.pages.menu.Menu;

public interface SubMenu {
    enum SubMenuItems {
        TOPS,
        BOTTOMS,
        JACKETS;
    }

    public SubMenu selectMenuItem(SubMenuItems item);

    public ItemsPage openItemsPage();
}
