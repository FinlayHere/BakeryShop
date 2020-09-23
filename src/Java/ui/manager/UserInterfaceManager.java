package Java.ui.manager;



import Java.controller.LoginController;
import Java.model.User;
import Java.ui.content.UserInterfaceContent;

import java.util.Scanner;

public class UserInterfaceManager {

    private UserInterfaceContent content;
    private LoginController loginController;
    private User currentUser;

    public UserInterfaceManager() {
        this.content = UserInterfaceContent.getInstance();
        this.loginController = LoginController.getInstance();
        this.currentUser = new User();
    }

    public void entry() {
        try {
            currentUser = login();
            System.out.println("login successfully");
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        finally {
            if (null == currentUser){
                entry();
            }
        }

        showHeroPageTo(currentUser);
    }

    private User login() throws Exception {
        Scanner userInput = new Scanner(System.in);
        showLoginPage();
        System.out.println("please input your user name:");
        String userName = userInput.next();
        System.out.println("please input your password:");
        String password = userInput.next();
        return loginController.login(userName, password);
    }

    public void showLoginPage() {
        content.showLoginPage();
    }


    private void showHeroPageTo(User currentUser) {
        content.showHeroPage();


    }

}
