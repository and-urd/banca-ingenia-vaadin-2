package com.example.application.views.prestamo;

import com.example.application.backend.modelbanca.Cuenta;
import com.example.application.backend.modelbanca.Movimiento;
import com.example.application.backend.modelbanca.Prestamo;
import com.example.application.backend.servicebanca.CategoriaService;
import com.example.application.backend.servicebanca.CuentaService;
import com.example.application.backend.servicebanca.MovimientoService;
import com.example.application.backend.servicebanca.PrestamoService;
import com.example.application.backend.servicebanca.impl.AuthService;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.NativeButton;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.BinderValidationStatus;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;

import java.time.LocalDate;

@PageTitle("Préstamo")
public class PrestamoAndresView extends VerticalLayout {

    // Inyección de servicios
    private final PrestamoService prestamoService;
    private final AuthService authService;
    private final CuentaService cuentaService;
    private final MovimientoService movimientoService;
    private final CategoriaService categoriaService;


    public PrestamoAndresView(PrestamoService prestamoService, AuthService authService, CuentaService cuentaService, MovimientoService movimientoService, CategoriaService categoriaService){
        this.prestamoService = prestamoService;
        this.authService = authService;
        this.cuentaService = cuentaService;
        this.movimientoService = movimientoService;
        this.categoriaService = categoriaService;


        FormLayout layoutWithBinder = new FormLayout();
        Binder<Prestamo> binder = new Binder<>();

// The object that will be edited
        Prestamo prestamoBeingEdited = new Prestamo();

// Create the fields

        NumberField cantidad = new NumberField();
        cantidad.setValueChangeMode(ValueChangeMode.EAGER);

        NumberField duracion = new NumberField();
        duracion.setValueChangeMode(ValueChangeMode.EAGER);

        NumberField tipoInteres = new NumberField();
        tipoInteres.setValueChangeMode(ValueChangeMode.EAGER);

        Label infoLabel = new Label();
        NativeButton save = new NativeButton("Save");
        NativeButton reset = new NativeButton("Reset");

        layoutWithBinder.addFormItem(cantidad, "Cantidad");
        layoutWithBinder.addFormItem(duracion, "Duración");
        layoutWithBinder.addFormItem(tipoInteres, "Tipo interés");

// Button bar
        HorizontalLayout actions = new HorizontalLayout();
        actions.add(save, reset);
        save.getStyle().set("marginRight", "10px");





// Both phone and email cannot be empty
//        SerializablePredicate<String> phoneOrEmailPredicate = value -> !phone
//                .getValue().trim().isEmpty()
//                || !email.getValue().trim().isEmpty();

// E-mail and phone have specific validators

        Binder.Binding<Prestamo, Double> cantidadBinding = binder.forField(cantidad)
                .withNullRepresentation(0d)
                /*.withValidator(phoneOrEmailPredicate,
                        "Please specify your email")
                .withValidator(new EmailValidator("Incorrect email address"))*/
                .bind(Prestamo::getCantidad, Prestamo::setCantidad);

        Binder.Binding<Prestamo, Double> duracionBinding = binder.forField(duracion)
                /*.withValidator(phoneOrEmailPredicate,
                        "Please specify your phone")*/
                .bind(Prestamo::getDuracion, Prestamo::setDuracion);



        Binder.Binding<Prestamo, Double> tipoInteresBinding = binder.forField(tipoInteres)
                /*.withValidator(phoneOrEmailPredicate,
                        "Please specify your phone")*/
                .bind(Prestamo::getTipoInteres, Prestamo::setTipoInteres);
// Trigger cross-field validation when the other field is changed
//        email.addValueChangeListener(event -> phoneBinding.validate());
//        phone.addValueChangeListener(event -> emailBinding.validate());

// Address is a required field
//        address.setRequiredIndicatorVisible(true);
//        binder.forField(address)
//                .withValidator(new StringLengthValidator(
//                        "Please add the address", 1, null))
//                .bind(Contact::getAddress, Contact::setAddress);

// Click listeners for the buttons
        save.addClickListener(event -> {
            if (binder.writeBeanIfValid(prestamoBeingEdited)) {
                infoLabel.setText("Saved bean values: " + prestamoBeingEdited);


                crearPrestamo();


            } else {
                BinderValidationStatus<Prestamo> validate = binder.validate();
//                String errorText = validate.getFieldValidationStatuses()
//                        .stream().filter(BindingValidationStatus::isError)
//                        .map(BindingValidationStatus::getMessage)
//                        .map(Optional::get).distinct()
//                        .collect(Collectors.joining(", "));
//                infoLabel.setText("There are errors: " + errorText);
            }
        });
        reset.addClickListener(event -> {
            // clear fields by setting null
            binder.readBean(null);
            infoLabel.setText("");
        });
        add(layoutWithBinder, actions, infoLabel);



    }

    private void crearPrestamo(/*Prestamo prestamo*/) {

        Prestamo prestamo = new Prestamo();
            prestamo.setCantidad(3000d);
            prestamo.setDuracion(12d);
            prestamo.setTipoInteres(0.3d);
            prestamo.setCuentaIngreso(cuentaService.recuperarCuentaPorId(1L).get());
            prestamo.setCuentaCobro(cuentaService.recuperarCuentaPorId(2L).get());

        Double cantidad = prestamo.getCantidad();
        Double duracion = prestamo.getDuracion();
        Double tipoInteres = prestamo.getTipoInteres();
        Cuenta cuentaIngreso = prestamo.getCuentaIngreso();
        Cuenta cuentaCobro = prestamo.getCuentaCobro();

        // CREACIÓN DE PRESTAMO
        // Persistimos el prestamo en BBDD
        prestamoService.createPrestamo(prestamo);


        // SIMULACIÓN DE LA EJECUCIÓN DE PRESTAMO
        // Se crea un movimiento en la cuenta de INGRESO de la cantidad del prestamo,
        Movimiento movimientoIngreso = new Movimiento();
            movimientoIngreso.setCantidad(cantidad);



            movimientoIngreso.setCategoria(categoriaService.encuentraPorTipoCategoria("Préstamo"));
            movimientoIngreso.setConcepto("Ingreso Préstamo");
            movimientoIngreso.setCuenta(cuentaIngreso);
            movimientoIngreso.setFechaOperacion(LocalDate.now());
            movimientoIngreso.setFechaValor(LocalDate.now());
            movimientoIngreso.setSaldoActual(cuentaIngreso.getSaldo() + cantidad);

            // Persistimos el movimiento en BBDD
        movimientoService.creaMovimiento(movimientoIngreso);

        // se actualiza el saldo de la cuenta INGRESO y persiste la cuenta
            cuentaIngreso.setSaldo(cuentaIngreso.getSaldo() + cantidad);
            cuentaService.actualizaCuenta(cuentaIngreso);


        // Se realizan los movimientos correspondientes en la cuenta de COBRO




    }

}
