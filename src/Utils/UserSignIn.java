package Utils;

import User.User;

import java.util.List;

public class UserSignIn {
    private int userId;
    private String userPassword;

    public int getUserId() {
        return userId;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    /*public User signIn() {
        UserDao userDao = new UserDao();
        List<User> users = userDao.selectAll();
        for(int i=0;i<users.size();i++){
            if(users.get(i).getUserId()==userId&&users.get(i).getUserPassword()==userPassword)
                return users.get(i);
        }
        return null;
    }*/
}