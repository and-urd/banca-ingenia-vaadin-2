package io.oferto.application.backend.servicebanca.impl;


import io.oferto.application.backend.modelbanca.Usuario;
import io.oferto.application.backend.repositorybanca.UserRepository;
import io.oferto.application.backend.servicebanca.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    // Inyección del repositorio userRepository
    private final UserRepository userRepository;
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean existeUserConId(Long id) {
        return userRepository.existsById(id);
    }

    @Override
    public Usuario crearUsuario(Usuario usuario) {
        if(usuario.getId() == null){
            return userRepository.save(usuario);
        }else{
            return null;
        }
    }
}
