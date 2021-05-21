package io.oferto.application.views.about;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.BinderValidationStatus;
import com.vaadin.flow.data.validator.StringLengthValidator;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.orderedlayout.FlexComponent;

import io.oferto.application.backend.model.Warehouse;
import io.oferto.application.backend.modelbanca.Categoria;
import io.oferto.application.backend.servicebanca.CategoriaService;
import io.oferto.application.views.main.MainView;

import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.component.dependency.CssImport;
import io.oferto.application.views.warehouse.form.WarehouseForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Route(value = "about", layout = MainView.class)
@PageTitle("About")
@CssImport("./views/about/about-view.css")
public class AboutView extends VerticalLayout {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    private final CategoriaService categoriaService;
    public AboutView(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;

        addClassName("about-view");
        
        setSizeFull();
        setPadding(true);
        
//        this.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);

//        VerticalLayout layoutHorCrearCategoria = new VerticalLayout();
//        layoutHorCrearCategoria.add(new H3("Crear categoria"));
//        TextField txtFieldtipoCategoria = new TextField();
//
//        Button btnGuardar = new Button("Guardar");
//        btnGuardar.addClickListener( funcion ->{
//            Categoria nuevaCategoria = new Categoria();
//
//            if (txtFieldtipoCategoria.getValue().equals("") == false){
//
//                nuevaCategoria.setTipoCategoria(txtFieldtipoCategoria.getValue());
//                if(categoriaService.crearCategoria(nuevaCategoria) != null){
//                    Notification.show("Creada la categoria: " + nuevaCategoria.getTipoCategoria(), 2000, Notification.Position.MIDDLE);
//                }else{
//                    Notification.show("Categoria ya existe.", 2000, Notification.Position.MIDDLE);
//                }
//
//            }else{
//                Notification.show("Nombre de categoria necesario", 2000, Notification.Position.MIDDLE);
//            }
//        });
//
//        layoutHorCrearCategoria.add(txtFieldtipoCategoria, btnGuardar, new Hr());
//
//        this.add(layoutHorCrearCategoria);

        ///////////////////////////////////////////////////////
        FormLayout layoutWithBinder = new FormLayout();
        Binder<Categoria> binder = new Binder<>();

        // Entidad Categoria que se va a bindear
        Categoria categoriaSiendoEditada = new Categoria();

        // Creo el textField
        TextField tipoCategoria = new TextField();
        tipoCategoria.setValueChangeMode(ValueChangeMode.EAGER);

        VerticalLayout layoutEntrada = new VerticalLayout();

        layoutEntrada.add(new H4("Crear categoria"),tipoCategoria);

        Label infoLabel = new Label();
        NativeButton save = new NativeButton("Save");
        NativeButton reset = new NativeButton("Reset");

        layoutWithBinder.addFormItem(tipoCategoria, "Tipo de categoria:");

        HorizontalLayout actions = new HorizontalLayout();
        actions.add(save, reset);
        save.getStyle().set("marginRight", "10px");


        tipoCategoria.setRequiredIndicatorVisible(true);
        binder.forField(tipoCategoria)
                .withValidator(new StringLengthValidator(
                        "Por favor añadir el tipo de Categoria", 1, null))
                .bind(Categoria::getTipoCategoria, Categoria::setTipoCategoria);



        save.addClickListener(event -> {
            if (binder.writeBeanIfValid(categoriaSiendoEditada)) {
//                infoLabel.setText("Saved bean values: " + categoriaSiendoEditada);

                if(categoriaService.crearCategoria(categoriaSiendoEditada) != null){
                    Notification.show("Categoria creada.", 2000, Notification.Position.MIDDLE);
                }else{
                    Notification.show("Esta categoria ya existe.", 2000, Notification.Position.MIDDLE);
                }

            } else {
                BinderValidationStatus<Categoria> validate = binder.validate();

                infoLabel.setText("Se ha producido un error");
            }
        });
        reset.addClickListener(event -> {

            binder.readBean(null);
            infoLabel.setText("");
        });
        add(layoutEntrada,layoutWithBinder, actions, infoLabel);

    }

}
