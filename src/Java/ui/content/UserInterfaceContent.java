package Java.ui.content;


import static Java.ui.constant.UserInterfaceConstant.*;

public class UserInterfaceContent {

    private static final UserInterfaceContent content = new UserInterfaceContent();

    private UserInterfaceContent() {
    }

    public static UserInterfaceContent getInstance() {
        return content;
    }

    public void showLoginPage() {
        String loginPage =
                LINE
                + BLANK
                + BLANK
                + LOGIN_USER_NAME
                + LOGIN_PASSWORD
                + BLANK
                + BLANK
                + LINE;

        System.out.println(loginPage);
    }

    public void showHeroPage() {
        String loginPage =
                LINE
                + BLANK
                + BLANK
                + CREATE_ORDER
                + BLANK
                + BLANK
                + BLANK
                + LINE;

        System.out.println(loginPage);

    }


}
