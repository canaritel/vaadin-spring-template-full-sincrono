package es.televoip.views;

import es.televoip.views.helloworld.HelloWorldView;
import es.televoip.views.others.OtherView2;
import es.televoip.views.others.OtherView3;
import es.televoip.views.others.OtherView4;
import es.televoip.views.others.OtherView5;
import es.televoip.views.others.OtherView6;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentUtil;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.contextmenu.MenuItem;
import com.vaadin.flow.component.contextmenu.SubMenu;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.menubar.MenuBar;
import com.vaadin.flow.component.menubar.MenuBarVariant;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.theme.lumo.LumoUtility;
import java.util.Optional;

public class MainView extends AppLayout {

    private final Tabs menu;
    private final Tabs menu2;
    private final Span viewTitle = new Span(); // creamos componente título de Página
    private Tabs tabs1;
    private Tabs tabs2;
    private final String TEXT_LOGO = "Proyecto Síncrono";

    public MainView() {
        setPrimarySection(Section.DRAWER);
        addToNavbar(true, createHeaderContent());
        menu = createMenu();
        menu2 = createMenu2();
        addToDrawer(createDrawerContent(menu));
        addToDrawer(createDrawerContent2(menu2));
    }

    private Component createHeaderContent() {
        // Creamos la barra superior oscura y avatar en la parte arriba-derecha
        HorizontalLayout layout = new HorizontalLayout();
        layout.setId("header");
        layout.getThemeList().set("dark", true);
        //layout.getThemeList().set("light", true);
        layout.setWidthFull();
        layout.setSpacing(false);
        layout.setAlignItems(FlexComponent.Alignment.CENTER);

        HorizontalLayout componentLeftMenu = new HorizontalLayout();
        componentLeftMenu.add(new DrawerToggle(), viewTitle);
        componentLeftMenu.setSpacing(false);
        componentLeftMenu.setPadding(false);
        componentLeftMenu.setAlignItems(FlexComponent.Alignment.CENTER);

        Avatar avatar = new Avatar("Tonitech");
        HorizontalLayout componentAvatar = new HorizontalLayout(createMenuAvatar(avatar));
        componentAvatar.setSpacing(true);
        componentAvatar.setPadding(true);

        layout.add(componentLeftMenu);
        layout.add(componentAvatar);
        layout.setJustifyContentMode(FlexComponent.JustifyContentMode.BETWEEN);

        return layout;
    }

    private Component createMenuAvatar(Avatar avatar) {
        MenuBar menuBar = new MenuBar();
        menuBar.addThemeVariants(MenuBarVariant.LUMO_TERTIARY_INLINE);

        MenuItem menuItem = menuBar.addItem(createAvatar(avatar));
        SubMenu subMenu = menuItem.getSubMenu();
        subMenu.addItem("Profile");
        subMenu.addItem("Settings");
        subMenu.addItem("Help");
        subMenu.addItem("Sign out");

        return menuBar;
    }

    private Component createAvatar(Avatar avatar) {
        // Cargamos la imagen y convertimos para ser enviada al objeto avatar
        // StreamResource imageResource = ConvertToImage.convertToStreamImage(user.getImagen());
        // avatar.setImageResource(imageResource);
        avatar.setImage("images/antonio_avatar.png");
        avatar.setColorIndex(7); // color de fondo para el avatar
        avatar.setAbbreviation("Antonio González");

        return avatar;
    }

    private Component createDrawerContent(Tabs menu) {
        VerticalLayout layout = new VerticalLayout();
        layout.setWidthFull();
        layout.setPadding(false);
        layout.setSpacing(true);
        layout.getThemeList().set("spacing-s", true);
        layout.setAlignItems(FlexComponent.Alignment.STRETCH);
        // Añadimos logo y texto parte superior izquierda
        HorizontalLayout logoLayout = new HorizontalLayout();
        H2 texto = new H2(TEXT_LOGO);
        texto.addClassNames(LumoUtility.Padding.Bottom.MEDIUM,
                LumoUtility.FontWeight.BOLD,
                LumoUtility.TextColor.PRIMARY); // personalizamos el CSS directamente desde el código
        logoLayout.setId("logo");
        logoLayout.setAlignItems(FlexComponent.Alignment.CENTER);
        Image image = new Image("images/logo_canaritel2.png", "Async logo");
        image.setHeight("80px");
        // personalizamos el CSS directamente desde el código
        image.addClassNames(LumoUtility.Background.PRIMARY_10,
                LumoUtility.BoxShadow.MEDIUM,
                LumoUtility.BorderRadius.LARGE);
        // añadimos los componentes
        logoLayout.add(image);
        logoLayout.add(texto);
        layout.add(logoLayout, menu);

        return layout;
    }

    private Component createDrawerContent2(Tabs menutab) {
        Div layout = new Div();
        layout.setWidthFull();
        layout.add(menutab);
        return layout;
    }

    private Tabs createMenu() {
        tabs1 = new Tabs();
        tabs1.setOrientation(Tabs.Orientation.VERTICAL);
        tabs1.setId("tabs");
        tabs1.add(createMenuItems()); // añadimos los items del menu1
        return tabs1;
    }

    private Tabs createMenu2() {
        tabs2 = new Tabs();
        tabs2.setOrientation(Tabs.Orientation.VERTICAL);
        tabs2.setId("tabs");
        tabs2.setAutoselect(false); // no permitimos se auotoseleccione
        tabs2.add(createMenuItems2()); // añadimos los items del menu2
        return tabs2;
    }

    private Component[] createMenuItems() {
        return new Tab[]{
            createTab("Hello World", HelloWorldView.class, VaadinIcon.USER),
            createTab("Otro menú2", OtherView2.class, VaadinIcon.COG),
            createTab("Otro menú3", OtherView3.class, VaadinIcon.INFO_CIRCLE),};
    }

    private Component[] createMenuItems2() {
        return new Tab[]{
            createTab("Otro menú4", OtherView4.class, VaadinIcon.INSTITUTION),
            createTab("Otro menú5", OtherView5.class, VaadinIcon.MEGAPHONE),
            createTab("Otro menú6", OtherView6.class, VaadinIcon.SHOP),};
    }

    private static Tab createTab(String text, Class<? extends Component> navigationTarget, VaadinIcon icon) {
        final Tab tab = new Tab(icon.create());
        tab.add(new RouterLink(text, navigationTarget));
        ComponentUtil.setData(tab, Class.class, navigationTarget);
        return tab;
    }

    @Override
    protected void afterNavigation() {
        super.afterNavigation();
        // cuando regresamos de una ventana nos continua en el último tab abierto
        getTabForComponent(getContent()).ifPresent(menu::setSelectedTab);
        // establecemos el título de cada View como texto superior
        getCurrentPageTitle();
        // establecemos la selección de tabs, pudiendo saltar entre distintos menus de tabs
        selectionMenuAndTabs();

    }

    private Optional<Tab> getTabForComponent(Component component) {
        return menu.getChildren().filter(tab -> ComponentUtil.getData(tab, Class.class).equals(component.getClass()))
                .findFirst().map(Tab.class::cast);
    }

    private void getCurrentPageTitle() {
        UI.getCurrent()
                .getPage()
                .executeJs("return document.title")
                .then(String.class, pageTitle -> {
                    viewTitle.setText(pageTitle);
                });
    }

    private void selectionMenuAndTabs() {
        // Creamos listener para que desactiven el menú que no está activo
        menu.addSelectedChangeListener(event -> {
            menu2.setSelectedTab(null);
        });

        menu2.addSelectedChangeListener(event -> {
            menu.setSelectedTab(null);
        });

        // Creamos listener para que solo activen el grupo tabs seleccionado
        tabs1.addSelectedChangeListener(event -> {
            try {
                tabs1.setSelectedTab(event.getSelectedTab());
            } catch (Exception e) {
            }
        });

        tabs2.addSelectedChangeListener(event -> {
            try {
                tabs2.setSelectedTab(event.getSelectedTab());
            } catch (Exception e) {
            }
        });
    }

}
