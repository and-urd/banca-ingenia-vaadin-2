package io.oferto.application.views.cuentas;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import io.oferto.application.views.main.MainView;

@Route(value = "cuentas", layout = MainView.class)
@PageTitle("Cuentas")
public class CuentasView extends VerticalLayout {
}
