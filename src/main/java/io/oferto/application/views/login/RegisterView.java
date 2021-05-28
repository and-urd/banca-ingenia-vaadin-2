package io.oferto.application.views.login;


import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import io.oferto.application.backend.servicebanca.impl.AuthService;

@Route("register")
public class RegisterView extends VerticalLayout {

    private final AuthService authService;

    public RegisterView(AuthService authService) {
        this.authService = authService;

        setHeightFull();
        setJustifyContentMode(JustifyContentMode.CENTER);
        setAlignItems(Alignment.CENTER);

        add(registerComponent());
    }


    public Component registerComponent() {

        Image logo = new Image("images/logo-banca-ingenia.PNG", "Banca Ingenia");
        H3 tittle = new H3("Sign up");
        TextField username = new TextField("Username");
        PasswordField password1 = new PasswordField("Password");
        PasswordField password2 = new PasswordField("Confirm password");
        Button registerButton = new Button("Submit", event -> register(
                username.getValue(),
                password1.getValue(),
                password2.getValue()
        ));

        VerticalLayout registerLayout = new VerticalLayout();

        registerLayout.add(logo, tittle, username,password1,password2,registerButton);
        registerLayout.setHeightFull();
        registerLayout.setJustifyContentMode(JustifyContentMode.CENTER);
        registerLayout.setAlignItems(Alignment.CENTER);


        return registerLayout;
    }

    public void register(String username, String password1, String password2) {
        if (username.trim().isEmpty()) {
            Notification.show("Enter a username");
        } else if (password1.isEmpty()) {
            Notification.show("Enter a password");
        } else if (!password1.equals(password2)) {
            Notification.show("Passwords don't match");
        } else {
            authService.register(username, password1);
            UI.getCurrent().getPage().setLocation("login");
        }
    }
}
