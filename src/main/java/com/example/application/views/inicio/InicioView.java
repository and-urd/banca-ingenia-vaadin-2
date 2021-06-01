package com.example.application.views.inicio;

import com.example.application.backend.servicebanca.CategoriaService;
import com.example.application.backend.servicebanca.MovimientoService;
import com.example.application.backend.servicebanca.TarjetaService;
import com.example.application.views.balance.BalanceView;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.RouterLink;
import com.example.application.backend.servicebanca.impl.AuthService;
import com.example.application.views.movimientos.MovimientosView;

//@RouteAlias(value = "", layout = MainView.class)
//@Route(value = "inicio", layout = MainView.class)
@PageTitle("Bienvenido/a a tu banca")
public class InicioView extends VerticalLayout {

    private final MovimientoService movimientoService;
    private final TarjetaService tarjetaService;
    private final AuthService authService;
    private final CategoriaService categoriaService;

    public InicioView(MovimientoService movimientoService, TarjetaService tarjetaService, AuthService authService, CategoriaService categoriaService){
        this.movimientoService = movimientoService;
        this.tarjetaService = tarjetaService;
        this.authService = authService;
        this.categoriaService = categoriaService;

//        this.setSizeFull();
        this.setWidth("1000px");
        this.setPadding(true);

        HorizontalLayout layoutSuperior = new HorizontalLayout();

        PanelTarjetasInicio panelTarjetasInicio = new PanelTarjetasInicio(movimientoService, this.tarjetaService, this.authService);

        layoutSuperior.add(panelTarjetasInicio);
        layoutSuperior.add(BalanceView.layoutGrafica1(categoriaService, authService,movimientoService, "350px", "350px"));


        HorizontalLayout layoutInferior = new HorizontalLayout();

        PanelMovimientosInicio panelMovimientosInicio = new PanelMovimientosInicio(movimientoService, this.authService);
        layoutInferior.add(panelMovimientosInicio);
        layoutInferior.add(new H1("Grafica Barras"));


        //createPanelTarjetaLayout()
        add(layoutSuperior);
//        createPanelMovimientoLayout();
        add(layoutInferior);
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
