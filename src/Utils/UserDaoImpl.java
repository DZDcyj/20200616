package Utils;

import User.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl extends DButils implements UserDao{
    @Override
    public int insert(User user) {
        Object params[] = {user.getUserId(), user.getUserName()
                , user.getUserAge()
                , user.getUserSex(), user.getUserAddress(),user.isUser_isBan(),user.getUser_ban_time()};
        //要执行的sql语句
        String sql = "insert into user values(?,?,?,?,?,?,?)";

        //执行sql语句
        int i = doUpdate(sql, params);

        //释放资源
        getClose();
        return i;
    }

    @Override
    public List<User> selectAll() {
        // 要执行的sql语句
        String sql = "select * from student";


        return getUserList(sql);
    }

    @Override
    public List<User> selectSomeUser(String name) {
        String sql = "select * from user where userName="+"\""+name+"\"";
        // 执行sql语句
       return getUserList(sql);
    }

    public User findUserId(long id) {
        String sql = "select * from user where userId="+id;
        // 执行sql语句
       List<User> users = getUserList(sql);
       if(users != null) {
           for (User user : users) {
               if (user.getUserId() == id){
                   return user;
               }
           }
       }
       return null;
    }

    public User findUserName(String name) {
        String sql = "select * from user where userName="+"\""+name+"\"";
        // 执行sql语句
        List<User> users = getUserList(sql);
        if(users != null) {
            for (User user : users) {
                if (user.getUserName().equals(name)){
                    return user;
                }
            }
        }
        return null;
    }

    public List<User> getUserList(String sql){
        ResultSet rs = doQuery(sql, null);
        //存放学生的list集合
        List<User> list = null;


        try {
            if (rs.next()) {//判断是否至少存在一条数据记录
                rs.beforeFirst();//将光标移动到第一行数据之前
                list = new ArrayList<User>();

                //将学生存放在list集合中
                while (rs.next()) {
                    //将每一个学生记录保存在list集合中
                    User user = new User();
                    user.setUserId(rs.getInt(1));
                    user.setUserName(rs.getString(2));
                    user.setUserAge(rs.getInt(3));
                    user.setUserSex(rs.getString(4));
                    user.setUserAddress(rs.getString(5));
                    user.setUser_isBan(rs.getBoolean(6));
                    user.setUser_ban_time(rs.getInt(7));

                    list.add(user);
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        // 释放资源
        getClose();
        return list;
    }

    @Override
    public int update(User user) {
        Object params[]
                = {user.getUserName()
                ,  user.getUserAge()
                , user.getUserSex(), user.getUserAddress(),user.isUser_isBan(),user.getUser_ban_time(),user.getUserId()};
        // 要执行的sql语句
        String sql = "update user set userName=?,userAge=?,userSex=?,userAddress=?,user_isBan=?,user_ban_time=? where userId=?";
        // 执行sql语句
        int i = doUpdate(sql, params);

        // 释放资源
        getClose();
        return i;
    }

    @Override
    public int delete(User user) {
        Object params[] = {user.getUserId()};
        // 要执行的sql语句
        String sql = "delete from user where userID=?";

        // 执行sql语句
        int i = doUpdate(sql, params);

        // 释放资源
        getClose();
        return i;
    }

}
