package ua.kovalnohov.pages.menu.subMenu;

import ua.kovalnohov.pages.ItemsCardPage;
import ua.kovalnohov.pages.header.Header;


public interface SubMenu {
    enum SubMenuItems {
        TOPS,
        BOTTOMS,
        JACKETS;
    }

    public SubMenu selectMenuItem(SubMenuItems item);

    public ItemsCardPage openItemsPage();

    public Header getHeader();
}
