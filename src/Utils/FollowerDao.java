package Utils;

import Community.Comment;
import User.Follower;

import java.util.List;

public interface FollowerDao {
    /**
     *添加
     * */
    public int insert(Follower follower);

    /**
     * 删除
     * **/
    public int delete(Follower follower);

    /**
     * 修改
     * */
    public int update(Follower follower);

    /**
     * 查询
     * */
    public List<Follower> selectAll();

    public List<Follower> search(long follower_id);
}
