package Java.service;


import Java.model.User;
import Java.repo.UserDataLoader;

public class LoginService {
    private static final LoginService loginService = new LoginService();

    private final UserDataLoader userDataLoader;

    public LoginService() {
        this.userDataLoader = new UserDataLoader();
    }

    public static LoginService getInstance() {
        return loginService;
    }

    public User login(String username, String password) throws Exception {
        User user;

        user = userDataLoader.findUserBy(username);

        if (!validUserPassword(user, password)) {
            throw new Exception("Password not right");
        }

        return user;
    }

    private boolean validUserPassword(User user, String password) {
        return user.getPassword().equals(password);
    }
}
