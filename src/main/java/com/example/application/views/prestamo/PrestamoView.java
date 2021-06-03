package com.example.application.views.prestamo;

import com.example.application.backend.modelbanca.Cuenta;
import com.example.application.backend.modelbanca.Prestamo;
import com.example.application.backend.modelbanca.Usuario;
import com.example.application.backend.servicebanca.CuentaService;
import com.example.application.backend.servicebanca.PrestamoService;
import com.example.application.backend.servicebanca.impl.AuthService;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.PageTitle;

import java.util.List;

@PageTitle("Préstamo")
public class PrestamoView extends VerticalLayout {

    private final PrestamoService prestamoService;
    private final AuthService authService;
    private final CuentaService cuentaService;
    private Prestamo prestamo;
    private Binder<Prestamo>prestamoBinder = new BeanValidationBinder<>(Prestamo.class);

    private FormLayout formLayout;

    private NumberField cantidad;
    private NumberField duracion;
    private NumberField tipoInteres;
    private ComboBox<Cuenta> cuentaIngreso;
    private ComboBox<Cuenta> cuentaCobro;

    public PrestamoView(PrestamoService prestamoService, AuthService authService, CuentaService cuentaService){
        this.prestamoService = prestamoService;
        this.authService = authService;
        this.cuentaService = cuentaService;

        add(createTitle(),createFormLayout(), new Hr(), createToolbarLayout());

        prestamoBinder.bindInstanceFields(this);
    }

    public void setPrestamo(Prestamo prestamo){
        this.prestamo = prestamo;
        prestamoBinder.readBean(prestamo);
    }

    public Prestamo getPrestamo(){
        return this.prestamo;
    }

    public List<Cuenta> getCuentas(){
        Usuario usuario = authService.recuperaUsuarioLogeado();
        List<Cuenta>cuentas = cuentaService.encuentraCuentasDeUsuario(usuario.getId());
                return cuentas;
    }

    private Component createTitle(){
        return new H3("Solicita tu Préstamo");
    }

    private Component createFormLayout(){
        formLayout = new FormLayout();
        formLayout.setWidthFull();

        cuentaIngreso = new ComboBox<Cuenta>();
        cuentaIngreso.setId("cuentaIngreso");
        cuentaIngreso.setItemLabelGenerator(Cuenta::getEntidad);
        cuentaIngreso.setLabel("Cuenta Ingreso");
        cuentaIngreso.setItems(getCuentas());
        prestamoBinder.forField(cuentaIngreso);

        cuentaCobro = new ComboBox<Cuenta>();
        cuentaCobro.setId("cuentaCobro");
        cuentaCobro.setItemLabelGenerator(Cuenta::getEntidad);
        cuentaCobro.setLabel("Cuenta Cobro");
        cuentaCobro.setItems(getCuentas());
        prestamoBinder.forField(cuentaCobro);

        cantidad = new NumberField();
        cantidad.setId("cantidad");
        cantidad.setLabel("Cantidad");
        prestamoBinder.forField(cantidad);

        duracion = new NumberField();
        duracion.setId("duracion");
        duracion.setLabel("Duración");
        prestamoBinder.forField(duracion);

        tipoInteres = new NumberField();
        tipoInteres.setId("interes");
        tipoInteres.setLabel("Interes");
        prestamoBinder.forField(tipoInteres);

        formLayout.add(cuentaIngreso, cuentaCobro, cantidad, duracion, tipoInteres);
        return formLayout;
    }

    private Component createToolbarLayout(){
        Button saveButton = new Button("Confirm", event -> {
            prestamoBinder.writeBeanIfValid(prestamo);
            prestamoService.createPrestamo(prestamo);
        });
        HorizontalLayout formToolBar = new HorizontalLayout(saveButton);
        formToolBar.setWidthFull();

        return formToolBar;
    }

}
