package Utils;

import Community.Comment;
import Course.Course;

import java.util.List;

public interface CommentDao {
    /**
     *添加
     * */
    public int insert(Comment comment);

    /**
     * 删除
     * **/
    public int delete(Comment comment);

    /**
     * 修改
     * */
    public int update(Comment comment);

    /**
     * 查询
     * */
    public List<Comment> selectAll();

    public List<Comment> search(long discussion_id);
}
