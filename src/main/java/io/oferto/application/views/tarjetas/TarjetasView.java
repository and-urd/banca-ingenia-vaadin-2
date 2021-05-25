package io.oferto.application.views.tarjetas;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.provider.DataProvider;
import com.vaadin.flow.data.provider.ListDataProvider;
import com.vaadin.flow.data.provider.SortDirection;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import io.oferto.application.backend.modelbanca.Tarjeta;
import io.oferto.application.backend.servicebanca.CuentaService;
import io.oferto.application.backend.servicebanca.MovimientoService;
import io.oferto.application.backend.servicebanca.TarjetaService;
import io.oferto.application.components.AuthenticatedButton;
import io.oferto.application.security.SecurityConfiguration;
import io.oferto.application.views.main.MainView;
import io.oferto.application.views.tarjeta.TarjetaForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Route(value = "tarjetas", layout = MainView.class)
@PageTitle("Tarjetas")
public class TarjetasView extends VerticalLayout {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    private Grid<Tarjeta> gridTarjeta = new Grid<>(Tarjeta.class);
    private ListDataProvider<Tarjeta> tarjetaProvider;
    private List<Tarjeta> tarjetas;

    // Inyección del servicio TarjetaService
    private final TarjetaService tarjetaService;
    private final CuentaService cuentaService;
    private final MovimientoService movimientoService;

    public TarjetasView(TarjetaService tarjetaService, CuentaService cuentaService, MovimientoService movimientoService){
        this.tarjetaService = tarjetaService;
        this.cuentaService = cuentaService;
        this.movimientoService = movimientoService;



//        addClassName("about-view");
        setSizeFull();
        setPadding(true);


        // Botón para crear una nueva Tarjeta
//        Button btnCrearTarjeta = new Button("Crear Tarjeta");
//        btnCrearTarjeta.addClickListener(event ->{
//            TarjetaForm formularioTarjeta = new TarjetaForm(null, tarjetaService, this.cuentaService);
//            formularioTarjeta.open();
//            formularioTarjeta.addOpenedChangeListener(event1 -> {
//                loadData();
//                loadGrid();
//            });
//        });

//        this.add(btnCrearTarjeta, new Hr());



        // load data from service
        loadData();

        // fill grid with data
        configureGrid();

        // create view layput
        add(gridTarjeta);

    }



    private void loadData() {
        try {
            this.tarjetas = tarjetaService.encuentraTarjetas();
        }
        catch(Exception ex) {
            ex.printStackTrace();

            logger.debug(ex.getLocalizedMessage());
        }
    }

    private void loadGrid() {
        tarjetaProvider =  DataProvider.ofCollection(this.tarjetas);
        tarjetaProvider.setSortOrder(Tarjeta::getTipoTarjeta, SortDirection.ASCENDING);

        gridTarjeta.setDataProvider(tarjetaProvider);
    }


    private void configureGrid() {
        loadGrid();

        gridTarjeta.setSizeFull();


        gridTarjeta.setColumns("numeroTarjeta");
        gridTarjeta.getColumnByKey("numeroTarjeta").setFlexGrow(0).setWidth("200px").setHeader("Numero tarjeta").setVisible(false);

        gridTarjeta.addColumn(tarjeta -> tarjetaUltimosDigitos(tarjeta.getNumeroTarjeta())).setFlexGrow(0).setWidth("200px").setHeader("Número tarjeta").setSortable(true);
        gridTarjeta.addColumn(item -> saldoPorTarjeta(gridTarjeta, item)).setFlexGrow(0).setWidth("200px").setHeader("Gasto Tarjeta").setSortable(true);
        gridTarjeta.addColumn(Tarjeta::getTipoTarjeta).setFlexGrow(0).setWidth("200px").setHeader("Tipo tarjeta").setSortable(true);
        gridTarjeta.addColumn(Tarjeta::getLimiteMaximo).setFlexGrow(0).setWidth("200px").setHeader("Límite máximo").setSortable(true);
        gridTarjeta.addColumn(tarjeta -> tarjeta.getCuenta().getNumeroCuenta()).setFlexGrow(0).setWidth("200px").setHeader("Número cuenta").setSortable(true);
        gridTarjeta.addColumn(tarjeta -> tarjeta.getCuenta().getEntidad()).setFlexGrow(0).setWidth("200px").setHeader("Entidad bancaria").setSortable(true);


//        gridTarjeta.getColumnByKey("tipoTarjeta").setFlexGrow(0).setWidth("200px").setHeader("Tipo tarjeta");
//        gridTarjeta.getColumnByKey("limiteMaximo").setFlexGrow(0).setWidth("200px").setHeader("Límite máximo");
//        gridTarjeta.getColumnByKey("cuenta.numeroCuenta").setFlexGrow(0).setWidth("200px").setHeader("Cuenta asociada");
//        gridTarjeta.getColumnByKey("cuenta.entidad").setFlexGrow(0).setWidth("200px").setHeader("Entidad bancaria");
//        gridTarjeta.getColumnByKey("fechaCaducidad").setFlexGrow(0).setWidth("200px").setHeader("Caducidad");
//        gridTarjeta.getColumnByKey("cvv").setFlexGrow(0).setWidth("200px").setHeader("CVV");



        // Se dibujan los botones 'Actualizar' y 'Borrar'
//        if (SecurityConfiguration.isAdmin()) {
//            gridTarjeta.addComponentColumn(item -> updateProductButton(gridTarjeta, item)).setFlexGrow(0).setWidth("120px").setHeader("");
//            gridTarjeta.addComponentColumn(item -> RemoveButton(gridTarjeta, item)).setFlexGrow(0).setWidth("120px").setHeader("");
//        }

        gridTarjeta.addThemeVariants(GridVariant.LUMO_NO_BORDER,
                GridVariant.LUMO_NO_ROW_BORDERS,
                GridVariant.LUMO_ROW_STRIPES);
    }

    public static String tarjetaUltimosDigitos(String numeroTarjeta) {
        if (numeroTarjeta.isEmpty()){
            return numeroTarjeta;
        }
        int size = numeroTarjeta.length();
        return "***" + numeroTarjeta.substring(size - 4);
    }

    private Object saldoPorTarjeta(Grid<Tarjeta> gridTarjeta, Tarjeta item) {
        return movimientoService.saldoTotalTarjeta(item.getNumeroTarjeta());
    }


//    private Component RemoveButton(Grid<Tarjeta> gridTarjeta, Tarjeta tarjeta) {
//        AuthenticatedButton button = new AuthenticatedButton("Borrar");
//        button.addClickListener(event -> {
//            tarjetaService.borrarTarjeta(tarjeta);
//            loadData();
//            loadGrid();
//        });
//        return button;
//
//    }


//    private Button updateProductButton(Grid<Tarjeta> grid, Tarjeta tarjeta) {
//        AuthenticatedButton button = new AuthenticatedButton("Actualizar");
//        button.addClickListener(event -> {
//            TarjetaForm formularioTarjeta = new TarjetaForm(tarjeta, tarjetaService, cuentaService);
//            formularioTarjeta.open();
//            formularioTarjeta.addOpenedChangeListener(event1 -> {
//                loadData();
//                loadGrid();
//            });
//        });
//
//
//
//
//
//        return button;
//    }





}
