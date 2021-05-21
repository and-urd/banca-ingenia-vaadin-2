package io.oferto.application.backend.repositorybanca;


import io.oferto.application.backend.modelbanca.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    Boolean existsByTipoCategoria(String tipoCategoria);

}
