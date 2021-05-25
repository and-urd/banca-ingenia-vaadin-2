package io.oferto.application.views.movimientos;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.provider.DataProvider;
import com.vaadin.flow.data.provider.ListDataProvider;
import com.vaadin.flow.data.provider.SortDirection;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import io.oferto.application.backend.modelbanca.Movimiento;
import io.oferto.application.backend.servicebanca.MovimientoService;
import io.oferto.application.views.main.MainView;

import java.util.List;

@Route(value = "movimientos", layout = MainView.class)
@PageTitle("Movimientos")
public class MovimientosView extends VerticalLayout {

    private MovimientoService movimientoService;
    private Grid<Movimiento> movimientoGrid = new Grid<>(Movimiento.class);
    private List<Movimiento> movimientoList;
    private ListDataProvider<Movimiento>movimientoListDataProvider;

    public MovimientosView(MovimientoService movimientoService){
        this.setSizeFull();
        this.setPadding(true);

        this.movimientoService = movimientoService;

        loadData();

        configureGrid();
    }

    private void loadData(){
        try{
            this.movimientoList = movimientoService.recuperaTodosMovimientos();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

    private void loadGrid(){
        movimientoListDataProvider = DataProvider.ofCollection(this.movimientoList);
        movimientoListDataProvider.setSortOrder(Movimiento::getFechaOperacion, SortDirection.ASCENDING);

        movimientoGrid.setDataProvider(movimientoListDataProvider);

    }

    private void configureGrid(){
        loadGrid();
        movimientoGrid.setSizeFull();
        add(movimientoGrid);

        movimientoGrid.setColumns("numTarjeta", "cantidad", "concepto", "fechaOperacion");
        movimientoGrid.getColumnByKey("numTarjeta").setHeader("Nº Tarjeta");
        movimientoGrid.getColumnByKey("cantidad").setHeader("Cantidad");
        movimientoGrid.getColumnByKey("concepto").setHeader("Concepto");
        movimientoGrid.getColumnByKey("fechaOperacion").setHeader("Fecha");
        movimientoGrid.addComponentColumn(item ->{
            Icon icon;
            if(item.getCantidad() < 0.0){
                icon = VaadinIcon.CHEVRON_CIRCLE_DOWN_O.create();
                icon.setColor("red");
            }else{
                icon = VaadinIcon.CHEVRON_CIRCLE_UP_O.create();
                icon.setColor("green");
            }
            return icon;
        }).setKey("icon").setHeader("");

        movimientoGrid.addThemeVariants(GridVariant.LUMO_NO_BORDER,
                GridVariant.LUMO_NO_ROW_BORDERS,
                GridVariant.LUMO_ROW_STRIPES);

    }
}
