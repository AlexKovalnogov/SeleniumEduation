package ua.kovalnohov.pages.menu;

import ua.kovalnohov.pages.menu.subMenu.SubMenu;

public interface Menu {

     enum Items {
        WHATS_NEW,
        MAN,
        WOMAN,
        GEAR,
        TRAINING,
        SALE,
         TOPS,
         JACKET;
    }
    public SubMenu selectMenuItem(Items item);

}
