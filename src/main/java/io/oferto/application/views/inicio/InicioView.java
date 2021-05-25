package io.oferto.application.views.inicio;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import io.oferto.application.views.main.MainView;

@RouteAlias(value = "", layout = MainView.class)
@Route(value = "inicio", layout = MainView.class)
@PageTitle("Inicio")
public class InicioView extends VerticalLayout {
}
