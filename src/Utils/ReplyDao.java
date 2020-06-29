package Utils;

import Community.Discussion;
import Community.Reply;

import java.util.List;

public interface ReplyDao {
    /**
     *添加
     * */
    public int insert(Reply reply);

    /**
     * 删除
     * **/
    public int delete(Reply reply);

    /**
     * 修改
     * */
    public int update(Reply reply);

    /**
     * 查询
     * */
    public List<Reply> selectAll();

}
