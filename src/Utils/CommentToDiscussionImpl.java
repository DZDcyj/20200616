package Utils;

import Community.Comment;
import Community.DisAndCom;
import Community.Discussion;
import Course.Course;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CommentToDiscussionImpl extends DButils implements ManyToMany{
    @Override
    /**
     * @params principal_id 指代discussion_id
     * @params subordinate_id指代comment_id
     * */
    public int insert(long principal_id, long subordinate_id) {
        Object params [] = {principal_id,subordinate_id};
        String sql = "insert into discussion_comment values(?,?)";

        int i = doUpdate(sql,params);
        getClose();
        return i;
    }

    /**
     * @params principal_id 指代discussion_id
     * @params subordinate_id指代comment_id
     * @params -1代表对应的discussion被删除
     * */

    @Override
    public int delete(long principal_id, long subordinate_id) {
        Object[] params;
        String sql;
        /**
         *discussion被删除的情况
         **/
        if(subordinate_id == -1) {
            params = new Object[]{principal_id};
            sql = "delete from discussion_comment where discussion_id=?";
        }
        /**
         *comment被删除的情况
         * */
        else{
            params = new Object[]{principal_id, subordinate_id};
            sql = "delete from discussion_comment where discussion_id=? and comment_id=?";
        }

        int i = doUpdate(sql,params);
        getClose();
        return i;
    }

    /**
     * @params principal_id 指代discussion_id
     * @params subordinate_id指代comment_id
     * */

    @Override
    public int update(long principal_id, long subordinate_id) {
        Object params[] = {principal_id,subordinate_id,principal_id};
        String sql = "update discussion_comment discussion_id=?,comment_id=? where discussion_id=?";
        int i = doUpdate(sql,params);
        getClose();
        return i;
    }

    /**
     * @params principal_id 指代discussion_id
     * @params subordinate_id指代comment_id
     * */

    @Override
    public List<DisAndCom> search(long principal_id, long subordinate_id) {
        Object params[] = {principal_id};
        String sql = "select * from discussion_comment where discussion_id=?";
        return getList(sql);
    }

    public List<DisAndCom> getList(String sql){
        ResultSet rs = doQuery(sql,null);
        List<DisAndCom> list = null;

        try {
            if(rs.next()){
                rs.beforeFirst();
                list = new ArrayList<DisAndCom>();
                while(rs.next()){
                    DisAndCom disAndCom = new DisAndCom();
                    disAndCom.setDiscussion_id(rs.getInt(1));
                    disAndCom.setComment_id(rs.getInt(2));
                    list.add(disAndCom);
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }
}
