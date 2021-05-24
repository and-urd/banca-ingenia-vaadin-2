package io.oferto.application.backend.repositorybanca;


import io.oferto.application.backend.modelbanca.Tarjeta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarjetaRepository extends JpaRepository<Tarjeta, Long> {

    // Comprueba si el número de tarjeta ya existe en la bbdd
    Boolean existsByNumeroTarjeta(String numeroTarjeta);

}
