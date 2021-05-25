package io.oferto.application.views.movimientos;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import io.oferto.application.views.main.MainView;

@Route(value = "movimientos", layout = MainView.class)
@PageTitle("Movimientos")
public class MovimientosView extends VerticalLayout {
}
