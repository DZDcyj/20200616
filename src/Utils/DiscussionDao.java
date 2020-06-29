package Utils;

import Community.Discussion;

import java.util.List;

public interface DiscussionDao {
    /**
     *添加
     * */
    public int insert(Discussion discussion);

    /**
     * 删除
     * **/
    public int delete(Discussion discussion);

    /**
     * 修改
     * */
    public int update(Discussion discussion);

    /**
     * 查询
     * */
    public List<Discussion> selectAll();

}
