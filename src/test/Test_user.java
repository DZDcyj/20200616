package test;

import User.User;
import Utils.FollowerDaoImpl;
import Utils.UserDaoImpl;
import User.Follower;
public class Test_user {
    public static void main(String args[]){
        User user = new User();
        UserDaoImpl userDao = new UserDaoImpl();
        /*user.setUserName("李多朋");
        user.setUserAge(20);
        user.setUserId(1);
        user.setUserSex("男");
        user.setUserAddress("河北石家庄");

        userDao.insert(user);*/

        user.setUserName("橡木盾");
        user.setUserAge(21);
        user.setUserId(2);
        user.setUserSex("男");
        user.setUserAddress("北京朝阳");

        userDao.insert(user);

        /*user.setUserName("王天梦");
        user.setUserAge(20);
        user.setUserId(3);
        user.setUserSex("男");
        user.setUserAddress("湖北黄石");

        userDao.insert(user);

        user.setUserName("李佳航");
        user.setUserAge(20);
        user.setUserId(4);
        user.setUserSex("男");
        user.setUserAddress("甘肃兰州");

        userDao.insert(user);*/
        /*Follower follower = new Follower();
        FollowerDaoImpl followerDao = new FollowerDaoImpl();
        follower.setUser_id(2);
        follower.setFollower_id(1);

        followerDao.insert(follower);

        follower.setUser_id(2);
        follower.setFollower_id(3);

        followerDao.insert(follower);

        follower.setUser_id(2);
        follower.setFollower_id(4);

        followerDao.insert(follower);*/
    }
}
