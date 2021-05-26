package io.oferto.application.views.inicio;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.NativeButton;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import io.oferto.application.backend.servicebanca.MovimientoService;
import io.oferto.application.backend.servicebanca.TarjetaService;
import io.oferto.application.views.main.MainView;

@RouteAlias(value = "", layout = MainView.class)
@Route(value = "inicio", layout = MainView.class)
@PageTitle("Bienvenido/a a tu banca")
public class InicioView extends VerticalLayout {

    private final MovimientoService movimientoService;
    private final TarjetaService tarjetaService;

    public InicioView(MovimientoService movimientoService, TarjetaService tarjetaService){
        this.movimientoService = movimientoService;
        this.tarjetaService = tarjetaService;

        this.setSizeFull();
        this.setPadding(true);

        PanelTarjetasInicio panelTarjetasInicio = new PanelTarjetasInicio(movimientoService, this.tarjetaService);
        PanelMovimientosInicio panelMovimientosInicio = new PanelMovimientosInicio(movimientoService);
        PanelTarjetasInicio panelTarjetasInicio = new PanelTarjetasInicio();

        add(panelTarjetasInicio);
        createPanelMovimientoLayout();
        add(panelMovimientosInicio);
    }

    private void createPanelMovimientoLayout(){
        toolBarLayout = new HorizontalLayout();
        toolBarLayout.setWidthFull();

        H3 h3Movimientos = new H3("Movimientos");
        h3Movimientos.getElement().getStyle().set("margin-right", "auto");

        NativeButton button = new NativeButton(
                "Ver Más");
        button.addClickListener(e ->
                button.getUI().ifPresent(ui ->
                        ui.navigate("movimientos"))
        );

        toolBarLayout.add(h3Movimientos, button);
        add(toolBarLayout);
    }

}
