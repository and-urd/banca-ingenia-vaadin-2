package io.oferto.application.backend.servicebanca;


import io.oferto.application.backend.modelbanca.Usuario;

public interface UserService {

    // Comprueba si un user existe por su Id
    boolean existeUserConId(Long id);

    // Crear un usuarios
    Usuario crearUsuario(Usuario usuario);
}
