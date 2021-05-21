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


        // Botón para crear una nueva Categoria
        Button btnCrearCategoria = new Button("Crear Categoria");
        btnCrearCategoria.addClickListener(event ->{
            CategoriaForm formularioCategoria = new CategoriaForm(null, categoriaService);
            formularioCategoria.open();
        });

        this.add(btnCrearCategoria, new Hr());







    }

}
