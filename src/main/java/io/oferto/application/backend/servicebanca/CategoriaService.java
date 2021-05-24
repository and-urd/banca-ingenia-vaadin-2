package io.oferto.application.backend.servicebanca;

import io.oferto.application.backend.modelbanca.Categoria;

import java.util.List;

public interface CategoriaService {

    // Crear una categoria
    Categoria crearCategoria(Categoria categoria);

    // Encuentra todas las categorias
    List<Categoria> encuentraCategorias ();

    // Borrar categoria
    void borrarCategoria(Categoria categoria);


}
