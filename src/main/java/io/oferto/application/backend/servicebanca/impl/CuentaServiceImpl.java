package io.oferto.application.backend.servicebanca.impl;


import io.oferto.application.backend.modelbanca.Cuenta;
import io.oferto.application.backend.modelbanca.Movimiento;
import io.oferto.application.backend.modelbanca.Tarjeta;
import io.oferto.application.backend.modelbanca.Usuario;
import io.oferto.application.backend.repositorybanca.CuentaRepository;
import io.oferto.application.backend.repositorybanca.MovimientoRepository;
import io.oferto.application.backend.repositorybanca.TarjetaRepository;
import io.oferto.application.backend.repositorybanca.UserRepository;
import io.oferto.application.backend.servicebanca.CuentaService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CuentaServiceImpl implements CuentaService {

    // Inyección del repositorio
    private final CuentaRepository cuentaRepository;
    private final UserRepository userRepository;
    private final TarjetaRepository tarjetaRepository;
    private final MovimientoRepository movimientoRepository;

    public CuentaServiceImpl(CuentaRepository cuentaRepository, UserRepository userRepository, TarjetaRepository tarjetaRepository, MovimientoRepository movimientoRepository) {
        this.cuentaRepository = cuentaRepository;
        this.userRepository = userRepository;
        this.tarjetaRepository = tarjetaRepository;
        this.movimientoRepository = movimientoRepository;
    }


    // Devuelve una cuenta por ID
    @Override
    public Optional<Cuenta> recuperarCuentaPorId(Long id) {
        return cuentaRepository.findById(id);
    }


    // Devuelve las cuentas de un usuario por su id
    @Override
    public List<String> cuentasDeUsuarioPorId(Long idUsuario) {

        List<Cuenta> listadoCuentas = cuentaRepository.findAll();

        List<String> listadoResultante = new ArrayList<>();

        for (int i = 0; i < listadoCuentas.size(); i++) {

            List<Usuario> listadoUsers = listadoCuentas.get(i).getUsers();

            for (int j = 0; j < listadoUsers.size(); j++) {
                if (listadoUsers.get(j).getId() == idUsuario)
                    listadoResultante.add(listadoCuentas.get(i).getNumeroCuenta());
            }
        }

        return listadoResultante;
    }

    // Devuelve el saldo de una cuenta por numero de cuenta
    @Override
    public Double saldoDeCuenta(String numCuenta) {
        List<Cuenta> listadoCuentas = cuentaRepository.findAll();

        Double saldoResultante = 0.0;

        for (int i = 0; i < listadoCuentas.size(); i++) {

            if (listadoCuentas.get(i).getNumeroCuenta().equals(numCuenta)) {
                saldoResultante = listadoCuentas.get(i).getSaldo();
            }
//            List<User> listadoUsers = listadoCuentas.get(i).getUsers();
//
//            for (int j = 0; j < listadoUsers.size(); j++) {
//                if(listadoUsers.get(j).getId() == idUsuario)
//                    listadoResultante.add(listadoCuentas.get(i).getNumeroCuenta());
//            }
        }

        return saldoResultante;

    }




    @Override
    public List<Cuenta> listadoCompletoCuentas() {
        return cuentaRepository.findAll();
    }

    @Override
    public Cuenta crearCuenta(Cuenta cuenta) {

        Cuenta cuentaNueva;

        if(cuenta.getId() == null){

            cuentaNueva = cuentaRepository.save(cuenta);

            // Tarjetas
            List<Tarjeta> listaTarjetas = new ArrayList<>();

            for (Tarjeta tarjeta : cuenta.getTarjetas()) {
                Tarjeta tarjetaNueva = tarjeta;

                tarjetaNueva.setCuenta(cuentaNueva);

                tarjetaRepository.save(tarjetaNueva);
                listaTarjetas.add(tarjetaNueva);
            }

            cuentaNueva.setTarjetas(listaTarjetas);

            // Movimientos
            List<Movimiento> listaMovimientos = new ArrayList<>();

            for (Movimiento movimiento : cuenta.getMovimientos()) {
                Movimiento movimientoNuevo = movimiento;

                movimientoNuevo.setCuenta(cuentaNueva);
                movimientoRepository.save(movimientoNuevo);
                listaMovimientos.add(movimientoNuevo);
            }

            cuentaNueva.setMovimientos(listaMovimientos);



            return cuentaNueva;

        }else{
            return null;
        }
    }

    @Override
    public List<Cuenta> findAll() {
         return cuentaRepository.findAll();
    }

//    @Override
//    public Cuenta creaCuentaCompleta(Cuenta cuenta, Usuario usuario,  Tarjeta tarjeta, Movimiento movimiento) {
//
//        Cuenta cuentaNueva = new Cuenta();
//
//        if(cuenta.getId() != null ) return null;
//
//        cuentaNueva = cuenta;
////
////
////        Tarjeta tarjetaCreada = tarjetaRepository.save(tarjeta);
////
////        List<Tarjeta> listadoTarjetas = cuenta.getTarjetas();
////        listadoTarjetas.add(tarjetaCreada);
////
////        cuenta.setTarjetas(listadoTarjetas);
//
//        Tarjeta tarjetaNueva = new Tarjeta();
//        tarjetaNueva = tarjetaRepository.save(tarjeta);
//
//
//        cuentaRepository.save(cuenta);
//
//        return cuenta;
//    }


}
