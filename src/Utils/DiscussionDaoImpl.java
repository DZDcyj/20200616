package Utils;

import Community.Discussion;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DiscussionDaoImpl extends DButils implements DiscussionDao {

    /**
     * 在讨论表中插入讨论的信息
     * */

    @Override
    public int insert(Discussion discussion) {
        Object params [] = {discussion.getDiscussion_id(),discussion.getAdminId(),discussion.getDiscussion_name(),discussion.getDiscussion_title_img_url(),discussion.getDescription()};
        String sql = "insert into Discussion values(?,?,?,?,?)";
        int i = doUpdate(sql,params);
        getClose();
        return i;
    }

    /**
     * 获取所有讨论列表
     * */

    @Override
    public List<Discussion> selectAll() {
        String sql = "select * from Discussion";
        return getDiscussion(sql);
    }

    /**
     * 获取讨论列表
     * */

    public List<Discussion> getDiscussion(String sql){
        ResultSet rs = doQuery(sql,null);
        List<Discussion> list = null;

        try {
            if(rs.next()){
                rs.beforeFirst();
                list = new ArrayList<Discussion>();
                while(rs.next()){
                    Discussion discussion = new Discussion();
                    discussion.setDiscussion_id(rs.getInt(1));
                    discussion.setAdminId(rs.getInt(2));
                    discussion.setDiscussion_name(rs.getString(3));
                    discussion.setDiscussion_title_img_url(rs.getString(4));
                    discussion.setDescription(rs.getString(5));
                    list.add(discussion);
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    /**
     * 更新讨论信息
     * 根据讨论id
     * */

    @Override
    public int update(Discussion discussion) {
        Object params [] = {discussion.getDiscussion_id(),discussion.getAdminId(),discussion.getDiscussion_name(),discussion.getDiscussion_title_img_url(),discussion.getDescription(),discussion.getDiscussion_id()};
        String sql = "update Discussion set discussion_id=?,discussion_adminId=?,discussion_name=?,discussion_title_img_url=?,discussion_description=? where discussion_id=?";
        int i = doUpdate(sql, params);
        // 释放资源
        getClose();
        return i;
    }

    /**
     * 根据讨论版块的id删除课程
     * */

    @Override
    public int delete(Discussion discussion) {
        Object params[] = {discussion.getDiscussion_id()};
        // 要执行的sql语句
        String sql = "delete from Discussion where discussion_id=?";

        // 执行sql语句
        int i = doUpdate(sql, params);

        // 释放资源
        getClose();
        return i;
    }

    /**
     * 搜索讨论版块
     * 根据讨论版块的名称
     * */

    public List<Discussion> searchDiscussion(String name){
        Object params[] = {name};
        String sql = "select * from discussion where discussion_name like "+"'%"+name+"%'";
        return getDiscussion(sql);
    }

    /**
     * 搜索讨论版块
     * 根据课程创建者的id
     * */

    public List<Discussion> findNums(long id){
        Object params[] = {id};
        String sql = "select * from discussion where discussion_adminId="+id;
        return getDiscussion(sql);
    }
}
