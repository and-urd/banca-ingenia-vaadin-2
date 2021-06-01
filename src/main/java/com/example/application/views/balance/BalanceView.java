package com.example.application.views.balance;

import com.example.application.backend.modelbanca.Categoria;
import com.example.application.backend.servicebanca.CategoriaService;
import com.example.application.backend.servicebanca.MovimientoService;
import com.example.application.backend.servicebanca.impl.AuthService;
import com.storedobject.chart.*;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H5;
import com.vaadin.flow.component.html.H6;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@PageTitle("Balance")
public class BalanceView extends VerticalLayout {

    private final MovimientoService movimientoService;
    private final AuthService authService;
    private final CategoriaService categoriaService;

    public BalanceView(MovimientoService movimientoService, AuthService authService, CategoriaService categoriaService){
        this.movimientoService = movimientoService;
        this.authService = authService;
        this.categoriaService = categoriaService;
        this.setSizeFull();
        this.setPadding(true);





        add(layoutGrafica1(), new Hr(), layoutGrafica2());










    }



    private VerticalLayout layoutGrafica1() {

        VerticalLayout layout = new VerticalLayout();



        // Creating a chart display area.
        SOChart soChart = new SOChart();
        soChart.setSize("800px", "300px");


        Integer numTotalMovim = 100;

        List<Categoria> listCategoria = categoriaService.encuentraCategorias();
        List<Double> listTotales = new ArrayList<>(); // Lista de totales por categorias


        Long idUsuarioLogeado = authService.recuperaUsuarioLogeado().getId();

        for (Categoria categoria : listCategoria) {
            // Calcula el total de cada categoria
            listTotales.add(movimientoService.totalPorCategoria(idUsuarioLogeado, categoria.getTipoCategoria(),numTotalMovim));
        }

        Double totalGlobal = 0d; // Calculo de total de todos los elementos negativos
        for (Double y :
                listTotales) {
            if (y < 0)
                        totalGlobal += y;
        }




        CategoryData labels = new CategoryData();
        Data data = new Data();


        for (int i = 0; i < listTotales.size(); i++) {

            if (listTotales.get(i) < 0){ // Se comtemplan solamente los movimientos negativos
                labels.add(listCategoria.get(i).getTipoCategoria());
                double porcentaje = 100*listTotales.get(i)/totalGlobal;
                data.add(Math.round(porcentaje*100.0)/100.0); // añado el porcentaje
            }

        }





// We are going to create a couple of charts. So, each chart should be positioned
// appropriately.
// Create a self-positioning chart.
        NightingaleRoseChart nc = new NightingaleRoseChart(labels, data);
        Position p = new Position();
        p.setTop(Size.percentage(15));
        p.setBottom(Size.percentage(5));
        p.setLeft(Size.percentage(5));
        p.setRight(Size.percentage(5));

        nc.setPosition(p); // Position it leaving 50% space at the top


// Second chart to add.
//        BarChart bc = new BarChart(labels, data);
//        RectangularCoordinate rc;
//        rc  = new RectangularCoordinate(new XAxis(DataType.CATEGORY), new YAxis(DataType.NUMBER));
//        p = new Position();
//        p.setBottom(Size.percentage(55));
//        rc.setPosition(p); // Position it leaving 55% space at the bottom
//        bc.plotOn(rc); // Bar chart needs to be plotted on a coordinate system

// Just to demonstrate it, we are creating a "Download" and a "Zoom" toolbox button.


// Add the chart components to the chart display area.
        H5 h5Titulo = new H5("Categorias");
        H5 h5Subtitulo = new H5("(porcentaje)");
        h5Subtitulo.getStyle().set("margin", "0px 0px");

        layout.add(h5Titulo, h5Subtitulo);
        soChart.add(nc);

// Now, add the chart display (which is a Vaadin Component) to your layout.
        layout.add(soChart);



        return layout;
    }







    private VerticalLayout layoutGrafica2() {

        VerticalLayout layout = new VerticalLayout();

        layout.add(new H1("Grafica 2"));

        return layout;
    }
}
