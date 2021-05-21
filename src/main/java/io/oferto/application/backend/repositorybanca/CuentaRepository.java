package io.oferto.application.backend.repositorybanca;



import io.oferto.application.backend.modelbanca.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CuentaRepository extends JpaRepository<Cuenta, Long> {

    Optional<Cuenta> findById(Long id);
}

