package io.oferto.application.views.inicio;

import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import io.oferto.application.backend.servicebanca.MovimientoService;
import io.oferto.application.views.movimientos.MovimientosView;

public class PanelMovimientosInicio extends HorizontalLayout {

    private final MovimientoService movimientoService;

    public PanelMovimientosInicio(MovimientoService movimientoService) {
        this.movimientoService = movimientoService;

        MovimientosView movimientosView = new MovimientosView(movimientoService);

        this.add(movimientosView);
    }
}
