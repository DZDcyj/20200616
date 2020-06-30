package Utils;

import Community.Comment;
import User.Follower;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FollowerDaoImpl extends DButils implements FollowerDao{
    @Override
    public int insert(Follower follower) {
        Object params[] = {follower.getUser_id(),follower.getFollower_id()};
        String sql = "insert into follower values(?,?)";
        int i = doUpdate(sql,params);
        getClose();
        return i;
    }

    @Override
    public int delete(Follower follower) {
        return 0;
    }

    @Override
    public int update(Follower follower) {
        Object params[] = {follower.getFollower_id(),follower.getUser_id()};
        String sql = "update follower set follower_id where user_id";
        int i = doUpdate(sql,params);
        getClose();
        return i;
    }

    @Override
    public List<Follower> selectAll() {
        String sql = "select * from follower";
        return getList(sql);
    }

    @Override
    public List<Follower> search(long follower_id) {
        String sql = "select * from follower where user_id="+follower_id;
        return getList(sql);
    }

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

    public Follower find(Follower follower){
        List<Follower>  followers = selectAll();
        int flag;
        for(Follower follower1:followers){
            if(follower1.getUser_id() == follower.getUser_id()){
                flag = 1;
                return follower1;
            }
        }
        return null;
    }
    public List<Follower> getListFind(String sql,Object[] params){
        ResultSet rs = doQuery(sql,params);
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
}
