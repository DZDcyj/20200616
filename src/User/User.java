package User;

import Course.Course;

import java.util.ArrayList;

public class User {
    private Integer userId;//用户ID
    private String userName;//用户名
    //private String userPassword;//密码
    private Integer userAge;//年龄
    private String userSex;//性别
    private String userAddress;//地址
    private boolean user_isBan = false;
    private long user_ban_time = 0;

    public boolean isUser_isBan() {
        return user_isBan;
    }

    public void setUser_isBan(boolean user_isBan) {
        this.user_isBan = user_isBan;
    }

    public long getUser_ban_time() {
        return user_ban_time;
    }

    public void setUser_ban_time(long user_ban_time) {
        this.user_ban_time = user_ban_time;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }


    public Integer getUserAge() {
        return userAge;
    }

    public String getUserSex() {
        return userSex;
    }

    public String getUserAddress() {
        return userAddress;
    }


   /* public ArrayList<Course> getCourse() {
        return course;
    }*/

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public void setUserAddress(String stuAddress) {
        this.userAddress = stuAddress;
    }

  /*  public void addCourse(Course course){
        this.course.add(course);
    }*/
}