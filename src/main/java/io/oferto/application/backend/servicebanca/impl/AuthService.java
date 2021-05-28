package io.oferto.application.backend.servicebanca.impl;


import com.vaadin.flow.component.Component;
import com.vaadin.flow.router.RouteConfiguration;
import com.vaadin.flow.server.VaadinSession;
import io.oferto.application.backend.modelbanca.Role;
import io.oferto.application.backend.modelbanca.Usuario;
import io.oferto.application.backend.repositorybanca.UserRepository;
import io.oferto.application.views.cuentas.CuentasView;

import io.oferto.application.views.inicio.InicioView;

import io.oferto.application.views.login.RegisterView;
import io.oferto.application.views.main.MainView;
import io.oferto.application.views.movimientos.MovimientosView;
import io.oferto.application.views.tarjetas.TarjetasView;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthService {

    public record AuthorizedRoute(String route, String name, Class<? extends Component> view) {

    }

    public class AuthException extends Exception {

    }

    private final UserRepository userRepository;


    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private Usuario usuarioLogeado;
    public Usuario recuperaUsuarioLogeado(){
        return usuarioLogeado;
    }


    public void authenticate(String username, String password) throws AuthException {
        Usuario user = userRepository.getByUsername(username);
        usuarioLogeado = user;
        if (user != null && user.checkPassword(password)/* && user.isActive()*/) {
            VaadinSession.getCurrent().setAttribute(Usuario.class, user);
            createRoutes(user.getRole());
        } else {
            throw new AuthException();
        }
    }

    private void createRoutes(Role role) {
        getAuthorizedRoutes(role).stream()
                .forEach(route ->
                        RouteConfiguration.forSessionScope().setRoute(
                                route.route, route.view, MainView.class));
    }

    public List<AuthorizedRoute> getAuthorizedRoutes(Role role) {
        var routes = new ArrayList<AuthorizedRoute>();

        if (role.equals(Role.USER)) {
            routes.add(new AuthorizedRoute("inicio", "Inicio", InicioView.class));
            routes.add(new AuthorizedRoute("cuentas", "Cuentas", CuentasView.class));
            routes.add(new AuthorizedRoute("tarjetas", "Tarjetas", TarjetasView.class));
            routes.add(new AuthorizedRoute("movimientos", "Movimientos", MovimientosView.class));

        } else if (role.equals(Role.ADMIN)) {
            routes.add(new AuthorizedRoute("inicio", "Inicio", InicioView.class));
            routes.add(new AuthorizedRoute("cuentas", "Cuentas", CuentasView.class));
            routes.add(new AuthorizedRoute("tarjetas", "Tarjetas", TarjetasView.class));
            routes.add(new AuthorizedRoute("movimientos", "Movimientos", MovimientosView.class));
        }

        return routes;
    }

    public void register(String email, String password) {
        Usuario user = userRepository.save(new Usuario(email, password, Role.USER));
//        String text = "http://localhost:8080/activate?code=" + user.getActivationCode();
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setFrom("noreply@example.com");
//        message.setSubject("Confirmation email");
//        message.setText(text);
//        message.setTo(email);
//        mailSender.send(message);
    }

    public void activate(String activationCode) throws AuthException {
        Usuario user = userRepository.getByActivationCode(activationCode);
        if (user != null) {
            user.setActive(true);
            userRepository.save(user);
        } else {
            throw new AuthException();
        }
    }

}
