package io.oferto.application.views.register;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

//TODO
@Route(value = "register")
@PageTitle("Register | Ingenia Bank")
public class RegisterView extends VerticalLayout/* implements BeforeEnterObserver*/ {

    public RegisterView(){
        this.setSizeFull();
        this.setPadding(true);

        H1 h1 = new H1("Página registro");
    }


    /*LoginForm registerForm = new LoginForm();

    public RegisterView() {
        setJustifyContentMode(JustifyContentMode.CENTER);
        setAlignItems(Alignment.CENTER);

        registerForm.setForgotPasswordButtonVisible(false);
        registerForm.setAction("register");//login

        add(new H1("Ingenia Bank"), registerForm);
    }

    @Override
    public void beforeEnter(BeforeEnterEvent beforeEnterEvent) {
        if(beforeEnterEvent.getLocation()
                .getQueryParameters()
                .getParameters()
                .containsKey("error")) {
            registerForm.setError(true);
        }
    }
*/

}
