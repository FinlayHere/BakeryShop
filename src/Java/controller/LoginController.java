package Java.controller;


import Java.model.User;
import Java.service.LoginService;

public class LoginController {

    private static final LoginController loginController = new LoginController();

    private final LoginService loginService;

    public LoginController() {
        this.loginService = LoginService.getInstance();
    }

    public static LoginController getInstance() {
        return loginController;
    }


    public User login(String username, String password) throws Exception {
        return loginService.login(username, password);
    }
}
