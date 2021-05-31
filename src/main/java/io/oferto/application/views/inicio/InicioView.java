package io.oferto.application.views.inicio;

import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.RouterLink;
import io.oferto.application.backend.servicebanca.MovimientoService;
import io.oferto.application.backend.servicebanca.TarjetaService;
import io.oferto.application.backend.servicebanca.impl.AuthService;
import io.oferto.application.views.movimientos.MovimientosView;

//@RouteAlias(value = "", layout = MainView.class)
//@Route(value = "inicio", layout = MainView.class)
@PageTitle("Bienvenido/a a tu banca")
public class InicioView extends VerticalLayout {

    private final MovimientoService movimientoService;
    private final TarjetaService tarjetaService;
    private final AuthService authService;

    public InicioView(MovimientoService movimientoService, TarjetaService tarjetaService, AuthService authService){
        this.movimientoService = movimientoService;
        this.tarjetaService = tarjetaService;
        this.authService = authService;

        this.setSizeFull();
        this.setPadding(true);

        PanelTarjetasInicio panelTarjetasInicio = new PanelTarjetasInicio(movimientoService, this.tarjetaService, this.authService);
        PanelMovimientosInicio panelMovimientosInicio = new PanelMovimientosInicio(movimientoService);

        //createPanelTarjetaLayout()
        add(panelTarjetasInicio);
        createPanelMovimientoLayout();
        add(panelMovimientosInicio);
    }

    private void createPanelMovimientoLayout(){
        HorizontalLayout toolBarLayout = new HorizontalLayout();
//        toolBarLayout.setWidthFull();
        toolBarLayout.setWidth("1000px");
        H3 h3Movimientos = new H3("Movimientos");
        h3Movimientos.getElement().getStyle().set("margin-right", "auto");

        RouterLink routerLink = new RouterLink("Ver más", MovimientosView.class);
//        routerLink.getElement().getStyle().set("margin-top", "auto");

        toolBarLayout.add(h3Movimientos, routerLink);
        add(toolBarLayout);
    }

}
