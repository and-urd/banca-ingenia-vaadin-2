package io.oferto.application.views.inicio;

import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class CardTarjeta extends VerticalLayout {

    private String nombreEntidad;
    private Double saldo;
    private String numeroTarjeta;
    private String tipoTarjeta;
    // todo -- campo para el icono

    public CardTarjeta(String nombreEntidad, Double saldoCuenta, String numTarjeta, String tipoDeTarjeta) {
        this.nombreEntidad = nombreEntidad;
        this.saldo = saldoCuenta;
        this.numeroTarjeta = numTarjeta;
        this.tipoTarjeta = tipoDeTarjeta;

        // Estilos de la cardTarjeta
        this.setWidthFull();
        this.setMinWidth("200px");
        this.setMaxWidth("200px");

        this.getStyle().set("border", "1px solid #800080");
        this.getStyle().set("border-radius",  "20px");
//        this.getStyle().set("border-color", "#800080");


        H2 hEntidad =new H2(nombreEntidad);
        hEntidad.setWidthFull();


        H2 hSaldo = new H2(saldo.toString() + " €");
        hSaldo.getStyle().set("color", "#800080");



        HorizontalLayout layoutTarjeta = new HorizontalLayout();

        H3 hNumeroTarjeta = new H3(numeroTarjeta);
        H3 hTipoTarjeta = new H3(tipoTarjeta);

        layoutTarjeta.add(hTipoTarjeta, hNumeroTarjeta);
        add(hEntidad , hSaldo, layoutTarjeta);
    }
}
