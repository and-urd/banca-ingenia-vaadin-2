package io.oferto.application.backend.servicebanca.impl;


import io.oferto.application.backend.modelbanca.Cuenta;
import io.oferto.application.backend.modelbanca.Movimiento;
import io.oferto.application.backend.modelbanca.Usuario;
import io.oferto.application.backend.repositorybanca.MovimientoRepository;
import io.oferto.application.backend.servicebanca.MovimientoService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MovimientoServiceImpl implements MovimientoService {

    //Inyección del repositorio
    private final MovimientoRepository movimientoRepository;
//    private final MovimientoDAO movimientoDAO;

    public MovimientoServiceImpl(MovimientoRepository movimientoRepository) {
        this.movimientoRepository = movimientoRepository;
    }


    /*
    Recuperar Movimientos por IdUsuario y filtralos por Mes, Año y Categoria
     */
//    @Override
//    public List<Movimiento> recuperaMovimientosPorIdUsuarioFiltrados(Long id, Map<String, String> customQuery) {
//        if (recuperaMovimientosPorIdUsuario(id) == null){
//            return null;
//        }
//        return movimientoDAO.movimientosFiltrados(customQuery);
//    }


//    @Override
//    public List<Movimiento> recuperaMovimientosPorIdUsuarioFiltrados(Long id, LocalDate fechaOperacion, String tipoCategoria) {
//        List <Movimiento> movimientosPorIdUsuario = recuperaMovimientosPorIdUsuario(id);
//        List <Movimiento> movimientosResultado = new ArrayList<>();
//
//        for (int i = 0; i < movimientosPorIdUsuario.size(); i++) {
//
//            if(fechaOperacion ==  movimientosPorIdUsuario.get(i).getFechaOperacion()
//              && tipoCategoria.equals(movimientosPorIdUsuario.get(i).getCategoria().getTipoCategoria())){
//                movimientosResultado.add(movimientosPorIdUsuario.get(i));
//            }
//        }
//        return movimientosResultado;
//    }


    @Override
    public List<Movimiento> recuperaMovimientosPorIdUsuario(Long idUsuario) {

        // Todos los movimientos de la BBDD
        List<Movimiento> listMovimientos = movimientoRepository.findAll();

        // Aquí se guardarán los movimientos del usuario con id=idUsuario
        List<Movimiento> listResultado = new ArrayList<>();

        for (int i = 0; i < listMovimientos.size(); i++) {

            Cuenta cuenta = listMovimientos.get(i).getCuenta();

            List<Usuario> listadoUsuarios = cuenta.getUsers();

            for (int j = 0; j < listadoUsuarios.size(); j++) {
                if(listadoUsuarios.get(j).getId() == idUsuario)
                    listResultado.add(listMovimientos.get(i));
            }

        }
        return listResultado;
    }

    @Override
    public List<Movimiento> recuperaTodosMovimientos() {
        return movimientoRepository.findAll();
    }

    @Override
    public Optional<Movimiento> movimientoPorId(Long id) {

        Optional<Movimiento> movimiento = movimientoRepository.findById(id);

        return movimiento;
    }

    @Override
    public Double saldoTotalTarjeta(String numTarjeta) {
        List<Movimiento> listadoMovimientos = this.recuperaTodosMovimientos();
        Double saldoTotal = 0d;

        for (Movimiento movimiento:
                listadoMovimientos) {
            if(movimiento.getNumTarjeta().equals(numTarjeta)){
                saldoTotal += movimiento.getCantidad();
            }
        }

        return saldoTotal;
    }


}
