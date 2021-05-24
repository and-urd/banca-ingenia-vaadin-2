package io.oferto.application.backend.servicebanca.impl;


import io.oferto.application.backend.modelbanca.Cuenta;
import io.oferto.application.backend.modelbanca.Tarjeta;
import io.oferto.application.backend.modelbanca.Usuario;
import io.oferto.application.backend.repositorybanca.TarjetaRepository;
import io.oferto.application.backend.servicebanca.CuentaService;
import io.oferto.application.backend.servicebanca.TarjetaService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TarjetaServiceImpl implements TarjetaService {

    private final TarjetaRepository tarjetaRepository;
    private final CuentaService cuentaService;

    public TarjetaServiceImpl(TarjetaRepository tarjetaRepository, CuentaService cuentaService) {
        this.tarjetaRepository = tarjetaRepository;
        this.cuentaService = cuentaService;
    }


    //Devuelva las tarjetas de una cuenta por su id
    @Override
    public List<String> tarjetasDeCuentasPorId(Long idCuenta) {

        List<Tarjeta> listadoTarjetas = cuentaService.recuperarCuentaPorId(idCuenta).get().getTarjetas();

        List<String> listadoResultante = new ArrayList<>();

        for (int i = 0; i < listadoTarjetas.size(); i++) {

            listadoResultante.add(listadoTarjetas.get(i).getNumeroTarjeta());
        }
        return listadoResultante;

    }

    @Override
    public List<String> tarjetasPorIdUsuario(Long idUsuario) {

        List<String> listadoResultado = new ArrayList<>();

        for (Cuenta cuenta: cuentaService.listadoCompletoCuentas()) {
            for (Usuario user: cuenta.getUsers()) {
                if(user.getId()== idUsuario){
                    for (Tarjeta tarjeta : cuenta.getTarjetas()) {
                        listadoResultado.add(tarjeta.getNumeroTarjeta());
                    }
                }
            }
        }
        return listadoResultado;
    }

    @Override
    public Tarjeta crearTarjeta(Tarjeta tarjeta) {

        if(tarjetaRepository.existsByNumeroTarjeta(tarjeta.getNumeroTarjeta()) == true
                && tarjeta.getId()==null){
            // Si existe ya este número de cuenta
            return null;
        }else{
            return tarjetaRepository.save(tarjeta);
        }
    }

    @Override
    public List<Tarjeta> encuentraTarjetas() {
        return tarjetaRepository.findAll();
    }

    @Override
    public void borrarTarjeta(Tarjeta tarjeta) {
        tarjetaRepository.deleteById(tarjeta.getId());
    }

}
