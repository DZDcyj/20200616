package Utils;

import Community.RepAndCom;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReplyToCommentImpl extends DButils implements ManyToMany{
    @Override
    public int insert(long principal_id, long subordinate_id) {
        Object params[] = {principal_id,subordinate_id};
        String sql = "insert into comment_responder values(?,?)";
        int i = doUpdate(sql,params);
        getClose();
        return i;
    }

    @Override
    public int delete(long principal_id, long subordinate_id) {
        Object[] params;
        String sql;
        /**
         *discussion被删除的情况
         **/
        if(subordinate_id == -1) {
            params = new Object[]{principal_id};
            sql = "delete from comment_responder where comment_id=?";
        }
        /**
         *comment被删除的情况
         * */
        else{
            params = new Object[]{principal_id, subordinate_id};
            sql = "delete from comment_responder where comment_id=? and reply_id=?";
        }

        int i = doUpdate(sql,params);
        getClose();
        return i;
    }

    @Override
    public int update(long principal_id, long subordinate_id) {
        Object params[] = {principal_id,subordinate_id,principal_id};
        String sql = "update comment_responder comment_id=?,reply_id=? where comment_id";
        int i = doUpdate(sql,params);
        getClose();
        return i;
    }

    @Override
    public List<RepAndCom> search(long principal_id, long subordinate_id) {
        Object params[] = {principal_id};
        String sql = "select * from comment_responder where comment_id=?";
        return getList(sql);
    }

    public List<RepAndCom> getList(String sql){
        ResultSet rs = doQuery(sql,null);
        List<RepAndCom> list = null;

        try {
            if(rs.next()){
                rs.beforeFirst();
                list = new ArrayList<RepAndCom>();
                while(rs.next()){
                    RepAndCom repAndCom = new RepAndCom();
                    repAndCom.setComment_id(rs.getInt(1));
                    repAndCom.setReply_id(rs.getInt(2));
                    list.add(repAndCom);
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }
}
