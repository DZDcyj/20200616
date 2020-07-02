package Utils;

import Community.Comment;
import User.Follower;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FollowerDaoImpl extends DButils implements FollowerDao{
    /**
     * 插入关注表信息
     * */

    @Override
    public int insert(Follower follower) {
        Object params[] = {follower.getUser_id(),follower.getFollower_id()};
        String sql = "insert into follower values(?,?)";
        int i = doUpdate(sql,params);
        getClose();
        return i;
    }

    /**
     * 删除关注表信息
     * 根据被关注者id
     * */

    @Override
    public int delete(Follower follower) {
        Object params[] = {follower.getFollower_id()};
        // 要执行的sql语句
        String sql = "delete from follower where follower_id=?";

        // 执行sql语句
        int i = doUpdate(sql, params);

        // 释放资源
        getClose();
        return i;
    }

    /**
     * 根据用户id
     * 更新关注信息
     * */

    @Override
    public int update(Follower follower) {
        Object params[] = {follower.getFollower_id(),follower.getUser_id()};
        String sql = "update follower set follower_id where user_id";
        int i = doUpdate(sql,params);
        getClose();
        return i;
    }

    /**
     * 获取所有用户列表
     *  */

    @Override
    public List<Follower> selectAll() {
        String sql = "select * from follower";
        return getList(sql);
    }

    /**
     * 根据被关注的人的id
     * 查找用户列表
     * */

    @Override
    public List<Follower> search(long follower_id) {
        String sql = "select * from follower where user_id="+follower_id;
        return getList(sql);
    }

    /**
     * 获取跟随者列表
     * */

    public List<Follower> getList(String sql){
        ResultSet rs = doQuery(sql,null);
        List<Follower> list = null;

        try {
            if(rs.next()){
                rs.beforeFirst();
                list = new ArrayList<Follower>();
                while(rs.next()){
                    Follower follower = new Follower();
                    follower.setUser_id(rs.getInt(1));
                    follower.setFollower_id(rs.getInt(2));
                    list.add(follower);
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    /**
     * 根据关注用户的信息
     * 具体查找某个用户
     * */

    public Follower find(Follower follower){
        List<Follower>  followers = selectAll();
        int flag;
        if(followers != null) {
            for (Follower follower1 : followers) {
                if (follower1.getUser_id() == follower.getUser_id()) {
                    flag = 1;
                    return follower1;
                }
            }
        }
        return null;
    }
}
