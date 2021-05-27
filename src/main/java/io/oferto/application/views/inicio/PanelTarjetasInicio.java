package io.oferto.application.views.inicio;

import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.orderedlayout.BoxSizing;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.RouterLink;
import io.oferto.application.backend.modelbanca.Tarjeta;
import io.oferto.application.backend.servicebanca.MovimientoService;
import io.oferto.application.backend.servicebanca.TarjetaService;
import io.oferto.application.views.tarjetas.TarjetasView;

import java.util.List;

public class PanelTarjetasInicio extends VerticalLayout {

    // Inyección de servicios
    private final MovimientoService movimientoService;
    private final TarjetaService tarjetaService;

    public PanelTarjetasInicio(MovimientoService movimientoService, TarjetaService tarjetaService) {
        this.movimientoService = movimientoService;
        this.tarjetaService = tarjetaService;

        this.setBoxSizing(BoxSizing.BORDER_BOX);
        this.setPadding(false);

        HorizontalLayout layoutHorCabecera = new HorizontalLayout();
//        layoutHorCabecera.setWidthFull();
        layoutHorCabecera.setWidth("1000px");
        layoutHorCabecera.setPadding(false);

        H3 titulo = new H3("Tarjetas");





        RouterLink routerLink = new RouterLink("Ver tarjetas", TarjetasView.class);
        routerLink.getElement().getStyle().set("margin-left", "auto");

        layoutHorCabecera.add(titulo, routerLink);

        this.add(layoutHorCabecera);

        HorizontalLayout layoutCards = new HorizontalLayout();
        layoutCards.setWidth("1000px");
        layoutCards.setPadding(false);

        List<Tarjeta> listadoTarjetas = tarjetaService.encuentraTarjetas();

        int numTarjetasAMostrar = 3;
        for (int i = 0; i < numTarjetasAMostrar ; i++) {
            Tarjeta tarjeta = listadoTarjetas.get(i);
            CardTarjeta cardTarjeta = new CardTarjeta(  tarjeta.getCuenta().getEntidad(),
                                                        movimientoService.saldoTotalTarjeta(tarjeta.getNumeroTarjeta()),
                                                        TarjetasView.tarjetaUltimosDigitos(tarjeta.getNumeroTarjeta()),
                                                        tarjeta.getTipoTarjeta());
            layoutCards.addAndExpand(cardTarjeta);
        }




//        CardTarjeta cardTarjeta1 = new CardTarjeta("BBVA", 12340d, "***2372");
//        CardTarjeta cardTarjeta2 = new CardTarjeta("CAIXA", 1005d, "***0678");
//        CardTarjeta cardTarjeta3 = new CardTarjeta("UNICAJA", 760.4d, "***2427");
//
//        layoutCards.add(cardTarjeta1, cardTarjeta2, cardTarjeta3);

        this.add(layoutCards);
    }
}
