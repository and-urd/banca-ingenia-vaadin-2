package io.oferto.application.views.cuentas;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.provider.DataProvider;
import com.vaadin.flow.data.provider.ListDataProvider;
import com.vaadin.flow.data.provider.SortDirection;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import io.oferto.application.backend.modelbanca.Cuenta;
import io.oferto.application.backend.servicebanca.CuentaService;
import io.oferto.application.views.main.MainView;

import java.util.List;

@Route(value = "cuentas", layout = MainView.class)
@PageTitle("Cuentas")
public class CuentasView extends VerticalLayout {

    private CuentaService cuentaService;
    private Grid <Cuenta> cuentaGrid = new Grid<>(Cuenta.class);
    private List<Cuenta> cuentaList;
    private ListDataProvider<Cuenta>cuentaListDataProvider;

    public CuentasView(CuentaService cuentaService){
        this.setSizeFull();
        this.setPadding(true);

        this.cuentaService=cuentaService;

        loadData();

        configureGrid();
    }

    private void loadData(){
        try{
            this.cuentaList = cuentaService.findAll();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

    private void loadGrid(){
        cuentaListDataProvider = DataProvider.ofCollection(this.cuentaList);
        cuentaListDataProvider.setSortOrder(Cuenta::getEntidad, SortDirection.ASCENDING);

        cuentaGrid.setDataProvider(cuentaListDataProvider);
    }

    private void configureGrid(){
        loadGrid();
        cuentaGrid.setSizeFull();
        add(cuentaGrid);

        cuentaGrid.setColumns("numeroCuenta", "saldo", "entidad", "tipoCuenta");
        cuentaGrid.getColumnByKey("numeroCuenta").setHeader("Nº Cuenta");
        cuentaGrid.getColumnByKey("saldo").setHeader("Saldo");
        cuentaGrid.getColumnByKey("entidad").setHeader("Entidad");
        cuentaGrid.getColumnByKey("tipoCuenta").setHeader("Tipo de Cuenta");

        cuentaGrid.addThemeVariants(GridVariant.LUMO_NO_BORDER,
                GridVariant.LUMO_NO_ROW_BORDERS,
                GridVariant.LUMO_ROW_STRIPES);

    }

}
