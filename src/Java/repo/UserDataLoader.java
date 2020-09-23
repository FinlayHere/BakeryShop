package Java.repo;

import Java.model.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDataLoader {

    public List<User> loadAllUserData() {

        List<User> users = new ArrayList<>();
        File userData = new File("/Users/fanchaokong/Desktop/FIT5136/BakeShop/src/resource/user.csv");

        try {
            BufferedReader textFile = new BufferedReader(new FileReader(userData));
            String lineDta = "";

            while ((lineDta = textFile.readLine()) != null) {
                String[] arr = lineDta.split(",");
                users.add(transferUserInfo(arr));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return users;
    }

    private User transferUserInfo(String[] userInfo){
        User user = new User();

        user.setUsername(userInfo[0]);
        user.setPassword(userInfo[1]);

        return user;
    }

    public User findUserBy(String username) throws Exception {
        List<User> users = loadAllUserData();

        users.remove(0);

        Optional<User> targetUserOpt = users.stream().filter(user -> username.equals(user.getUsername())).findFirst();
        if (targetUserOpt.isEmpty()){
            throw new Exception("Username does not exit");
        }

        return targetUserOpt.get();
    }




}
