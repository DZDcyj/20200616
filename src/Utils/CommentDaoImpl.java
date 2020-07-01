package Utils;

import Community.Comment;

import javax.xml.transform.Result;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CommentDaoImpl extends DButils implements CommentDao {
    @Override

    /**
     * 在数据库中增加一条评论信息
     * */

    public int insert(Comment comment) {
        Object params [] = {comment.getDiscussion_id(),comment.getComment_id(),comment.getComment_content(),comment.getComment_responder_id()};
        String sql = "insert into comment values(?,?,?,?)";
        int i = doUpdate(sql,params);
        getClose();
        return i;
    }


    /**
     * 在数据库中删除一条评论信息
     * */

    @Override
    public int delete(Comment comment) {
        Object params[] = {comment.getComment_id()};
        String sql = "delete from comment where comment_id=?";
        int i = doUpdate(sql,params);
        getClose();
        return i;
    }

    /**
     * 在数据库中更新一条评论信息
     * */

    @Override
    public int update(Comment comment) {
        Object params[] = {comment.getDiscussion_id(),comment.getComment_id(),comment.getComment_content(),comment.getComment_responder_id(),comment.getComment_id()};
        String sql = "update comment set discussion_id=?,comment_id=?,comment_content=?,comment_responder_id=? where comment_id=?";
        int i = doUpdate(sql,params);
        getClose();
        return i;
    }

    /**
     * 按照回复者id来删除评论
     * */

    public int delete1(Comment comment) {
        Object params[] = {comment.getComment_responder_id()};
        String sql = "delete from comment where comment_responder_id=?";
        int i = doUpdate(sql,params);
        getClose();
        return i;
    }

    /**
     * 从数据库中选取所有评论
     * */

    @Override
    public List<Comment> selectAll() {
        String sql = "select * from comment";
        return getList(sql);
    }

    /**
     * 获取评论列表
     * */

    public List<Comment> getList(String sql){
        ResultSet rs = doQuery(sql,null);
        List<Comment> list = null;

        try {
            if(rs.next()){
                rs.beforeFirst();
                list = new ArrayList<Comment>();
                while(rs.next()){
                    Comment comment = new Comment();
                    comment.setDiscussion_id(rs.getInt(1));
                    comment.setComment_id(rs.getInt(2));
                    comment.setComment_content(rs.getString(3));
                    comment.setComment_responder_id(rs.getInt(4));
                    list.add(comment);
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    /**
     *根据讨论版块的id搜索
     * 该讨论版块下的评论
     * */

    public List<Comment> search(long discussion_id){
        String sql = "select * from comment where discussion_id="+discussion_id;
        return getList(sql);
    }
}
