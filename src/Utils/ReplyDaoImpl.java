package Utils;

import Community.Reply;
import Course.Course;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReplyDaoImpl extends DButils implements ReplyDao{
    @Override
    public int insert(Reply reply) {
        Object params [] = {reply.getComment_id(),reply.getReply_id(),reply.getReply_user_id(),reply.getReply_content()};
        String sql = "insert into reply values(?,?,?,?)";
        int i = doUpdate(sql,params);
        getClose();
        return i;
    }

    @Override
    public int delete(Reply reply) {
        Object params[] = {reply.getReply_id()};
        // 要执行的sql语句
        String sql = "delete from reply where reply_id=?";

        // 执行sql语句
        int i = doUpdate(sql, params);

        // 释放资源
        getClose();
        return i;
    }

    @Override
    public int update(Reply reply) {
        Object params [] = {reply.getComment_id(),reply.getReply_id(),reply.getReply_user_id(),reply.getReply_content(),reply.getReply_id()};
        String sql = "update reply set comment_id=?,reply_id=?,reply_user_id=?,reply_content=? where reply_id=?";
        int i = doUpdate(sql,params);
        getClose();
        return i;
    }

    @Override
    public List<Reply> selectAll() {
        String sql = "select * from reply";
        return getReply(sql);
    }

    private List<Reply> getReply(String sql) {
        ResultSet rs = doQuery(sql,null);
        List<Reply> list = null;
        try {
            if(rs.next()){
                rs.beforeFirst();
                list = new ArrayList<Reply>();
                while(rs.next()){
                    Reply reply = new Reply();
                    reply.setComment_id(rs.getInt(1));
                    reply.setReply_id(rs.getInt(2));
                    reply.setReply_user_id(rs.getInt(3));
                    reply.setReply_content(rs.getString(4));
                    list.add(reply);
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        getClose();
        return list;
    }

    public List<Reply> search(long comment_id){
        String sql = "select * from reply where comment_id="+comment_id;
        return getReply(sql);
    }
}
