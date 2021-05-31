package io.oferto.application.backend.servicebanca;



import io.oferto.application.backend.modelbanca.Movimiento;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface MovimientoService {

    List<Movimiento>recuperaMovimientosPorIdUsuarioFiltrados(Long id, Map<String, String> customQuery);

    // Recupera movimientos de un usuario por id
    List<Movimiento> recuperaMovimientosPorIdUsuario(Long idUsuario);

    // Recupera todos los movimientos de la bbdd
    List<Movimiento> recuperaTodosMovimientos();

    // Recupera movimiento por su id
    Optional<Movimiento> movimientoPorId(Long id);

    // Calcula el saldo total realizado por una tarjeta (numero de tarjeta (string))
    Double saldoTotalTarjeta(String numTarjeta);
}
