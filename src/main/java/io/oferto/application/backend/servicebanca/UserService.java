package io.oferto.application.backend.servicebanca;


import io.oferto.application.backend.modelbanca.Usuario;

import java.util.List;

public interface UserService {

    // Comprueba si un user existe por su Id
    boolean existeUserConId(Long id);

    // Crear un usuarios
    Usuario crearUsuario(Usuario usuario);

    // Recuperar todos los usuarios
    List<Usuario> encotrarTodosUsuarios();
}
