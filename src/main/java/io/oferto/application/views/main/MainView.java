package io.oferto.application.views.main;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentUtil;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.contextmenu.MenuItem;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.menubar.MenuBar;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.component.tabs.TabsVariant;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.server.PWA;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;
import io.oferto.application.security.SecurityConfiguration;
import io.oferto.application.views.cuentas.CuentasView;
import io.oferto.application.views.inicio.InicioView;
import io.oferto.application.views.movimientos.MovimientosView;
import io.oferto.application.views.tarjetas.TarjetasView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * The main view is a top-level placeholder for other views.
 */
@PWA(name = "stock-manager", shortName = "stock-manager", enableInstallPrompt = false)
@JsModule("./styles/shared-styles.js")
@CssImport("lumo-css-framework/all-classes.css")
@CssImport("./views/main/main-view.css")
@Theme(value = Lumo.class)
public class MainView extends AppLayout {

	//private UserDetails userDetails;
    private final Tabs menu;
    private H1 viewTitle;

    public MainView() {
        setPrimarySection(Section.DRAWER);
                  
        addToNavbar(true, createHeaderContent());
        menu = createMenu();
        addToDrawer(createDrawerContent(menu));                
    }

    private Component createHeaderContent() {
        HorizontalLayout layout = new HorizontalLayout();
        
        layout.setId("header");
//        layout.getThemeList().set("dark", true);
        layout.setWidthFull();
        layout.setSpacing(false);
        layout.setAlignItems(FlexComponent.Alignment.CENTER);
        layout.add(new DrawerToggle());
        
        viewTitle = new H1();
        
        layout.add(viewTitle);

        //Añadimos la inicial del nombre del usuario dentro del avatar
        layout.add(new Avatar(SecurityConfiguration.getUserDetails().getUsername()));

        //Creamos un menu con el nombre completo del usuario y con opcion de Logout
        layout.add(createProfileMenu());
        
        return layout;
    }

    private Component createDrawerContent(Tabs menu) {
        VerticalLayout layout = new VerticalLayout();
        
        layout.setSizeFull();
        layout.setPadding(false);
        layout.setSpacing(false);
        layout.getThemeList().set("spacing-s", true);
        layout.setAlignItems(FlexComponent.Alignment.STRETCH);
        
        HorizontalLayout logoLayout = new HorizontalLayout();

        logoLayout.setId("logo");
        logoLayout.setAlignItems(FlexComponent.Alignment.CENTER);

        Image logo = new Image("images/logo-banca-ingenia.PNG", "Banca Ingenia");
        logo.setHeight("50px");
        logo.setWidth("50px");

        logoLayout.add(logo, new H3("Ingenia Bank"));
        layout.add(  logoLayout, menu);
        
        return layout;
    }

    private Tabs createMenu() {
        final Tabs tabs = new Tabs();
        
        tabs.setOrientation(Tabs.Orientation.VERTICAL);
        tabs.addThemeVariants(TabsVariant.LUMO_MINIMAL);
        tabs.setId("tabs");
        tabs.add(createMenuItems());
        
        return tabs;
    }

    private Component[] createMenuItems() {    	    	
    	List<Tab> tabs = new ArrayList<Tab>();
        tabs.add(createTab("Inicio", InicioView.class));
        tabs.add(createTab("Tarjetas", TarjetasView.class));
        tabs.add(createTab("Cuentas", CuentasView.class));
        tabs.add(createTab("Movimientos", MovimientosView.class));
    	return tabs.toArray(new Tab[tabs.size()]);
    }
    
    private static Tab createTab(String text, Class<? extends Component> navigationTarget) {
        final Tab tab = new Tab();


        Icon icono;
        switch (text){
            case "Inicio":
                icono = new Icon(VaadinIcon.HOME_O);
                break;
            case "Tarjetas":
                icono = new Icon(VaadinIcon.CREDIT_CARD);
                break;
            case "Cuentas":
                icono = new Icon(VaadinIcon.USERS);
                break;
            case "Movimientos":
                icono = new Icon(VaadinIcon.EXCHANGE);
                break;
            default:
                icono = new Icon();
        }


        tab.add(icono, new RouterLink(text, navigationTarget));
        ComponentUtil.setData(tab, Class.class, navigationTarget);
        return tab;
    }

    /*
    Create un menu con el nombre del usuario y un submenu con opcion de Logout
     */
    private Component createProfileMenu(){
        MenuBar menuBarProfile = new MenuBar();
        MenuItem menuItemProfile = menuBarProfile.addItem(SecurityConfiguration.getUserDetails().getUsername());
        menuItemProfile.getSubMenu().addItem("Logout", e ->{
            menuItemProfile.getUI().ifPresent(ui -> ui.getPage().setLocation("/logout"));
        });
//        menuBarProfile.setOpenOnHover(true);
        return menuBarProfile;
    }

    
    @Override
    protected void afterNavigation() {
        super.afterNavigation();
        
        getTabForComponent(getContent()).ifPresent(menu::setSelectedTab);
        viewTitle.setText(getCurrentPageTitle());
    }

    private Optional<Tab> getTabForComponent(Component component) {
        return menu.getChildren().filter(tab -> ComponentUtil.getData(tab, Class.class).equals(component.getClass()))
                .findFirst().map(Tab.class::cast);
    }

    private String getCurrentPageTitle() {
        PageTitle title = getContent().getClass().getAnnotation(PageTitle.class);
        
        return title == null ? "" : title.value();
    }
}
