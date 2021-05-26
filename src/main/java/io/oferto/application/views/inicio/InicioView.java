package io.oferto.application.views.inicio;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import io.oferto.application.backend.servicebanca.MovimientoService;
import io.oferto.application.backend.servicebanca.TarjetaService;
import io.oferto.application.views.main.MainView;

@RouteAlias(value = "", layout = MainView.class)
@Route(value = "inicio", layout = MainView.class)
@PageTitle("Inicio")
public class InicioView extends VerticalLayout {

    private final MovimientoService movimientoService;
    private final TarjetaService tarjetaService;

    public InicioView(MovimientoService movimientoService, TarjetaService tarjetaService){
        this.movimientoService = movimientoService;
        this.tarjetaService = tarjetaService;


        PanelTarjetasInicio panelTarjetasInicio = new PanelTarjetasInicio(movimientoService, this.tarjetaService);
        PanelMovimientosInicio panelMovimientosInicio = new PanelMovimientosInicio(movimientoService);
        this.add(panelTarjetasInicio, panelMovimientosInicio);

    }


}
