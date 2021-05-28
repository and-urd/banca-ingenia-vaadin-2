package io.oferto.application.views.login;


import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.router.RouterLink;
import io.oferto.application.backend.servicebanca.impl.AuthService;

@RouteAlias(value="")
@Route(value = "login")
@PageTitle("Login")
//@CssImport("./styles/views/login/login-view.css")
public class LoginView extends VerticalLayout {

    public LoginView(AuthService authService) {

        setPadding(false);
        setJustifyContentMode(JustifyContentMode.START);
        setAlignItems(Alignment.START);

        setId("login-view");
        var username = new TextField("Username");
        var password = new PasswordField("Password");
        add(
                new H1("Welcome"),
                username,
                password,
                new Button("Login", event -> {
                    try {
                        authService.authenticate(username.getValue(), password.getValue());
                        UI.getCurrent().navigate("inicio");
                    } catch (AuthService.AuthException e) {
                        Notification.show("Credenciales erróneas");
                    }
                }),
                new RouterLink("Registro", RegisterView.class)
        );
    }

}
