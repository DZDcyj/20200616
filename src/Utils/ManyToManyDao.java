package Utils;

import Community.Discussion;

import java.util.List;

public interface ManyToManyDao {
    /**
     *添加
     * */
    public int insert(long principal_id,long subordinate_id);

    /**
     * 删除
     * **/
    public int delete(long principal_id,long subordinate_id);

    /**
     * 修改
     * */
    public int update(long principal_id,long subordinate_id);

    /**
     * 查询
     * */
    public List search(long principal_id,long subordinate_id);
}
