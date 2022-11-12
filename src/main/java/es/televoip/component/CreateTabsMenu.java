package es.televoip.component;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.tabs.Tabs;

public class CreateTabsMenu {

    public static Tabs CreateTabs(Component[] component, boolean status) {
        Tabs tabs1 = new Tabs();
        tabs1.setOrientation(Tabs.Orientation.VERTICAL);
        tabs1.setId("tabs");
        tabs1.setAutoselect(status); // no permitimos se auotoseleccione
        tabs1.add(component); // añadimos los items del menu1
        return tabs1;
    }

}
