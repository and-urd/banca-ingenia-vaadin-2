package io.oferto.application.backend.daobanca;

import io.oferto.application.backend.modelbanca.Movimiento;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface MovimientoDAO {

    List<Movimiento> movimientosFiltrados(Map<String, String> customQuery);

}
