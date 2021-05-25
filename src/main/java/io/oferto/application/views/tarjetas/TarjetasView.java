package io.oferto.application.views.tarjetas;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import io.oferto.application.views.main.MainView;

@Route(value = "tarjetas", layout = MainView.class)
@PageTitle("Tarjetas")
public class TarjetasView extends VerticalLayout {
}
