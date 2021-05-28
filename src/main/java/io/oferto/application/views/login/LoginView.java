//package io.oferto.application.views.login;
//
//import com.vaadin.flow.component.dependency.CssImport;
//import com.vaadin.flow.component.html.H1;
//import com.vaadin.flow.component.login.LoginForm;
//import com.vaadin.flow.component.orderedlayout.VerticalLayout;
//import com.vaadin.flow.router.*;
//import io.oferto.application.views.register.RegisterView;
//
//@Route(value = "login")
//@PageTitle("Login | Ingenia Bank")
//@CssImport("./views/login/login-view.css")
//public class LoginView extends VerticalLayout implements BeforeEnterObserver {
//	LoginForm loginForm = new LoginForm();
//
//	public LoginView() {
//        setJustifyContentMode(JustifyContentMode.CENTER);
//        setAlignItems(Alignment.CENTER);
//
//		loginForm.setForgotPasswordButtonVisible(false);
//		loginForm.setAction("login");
//
//		add(new RouterLink("Registro", RegisterView.class), new H1("Ingenia Bank"), loginForm);
//	}
//
//    @Override
//    public void beforeEnter(BeforeEnterEvent beforeEnterEvent) {
//        if(beforeEnterEvent.getLocation()
//        .getQueryParameters()
//        .getParameters()
//        .containsKey("error")) {
//        	loginForm.setError(true);
//        }
//    }
//}
