package Utils;


import User.User;

import java.util.List;

public interface UserDao {
    /**
    *添加
     * */
    public int insert(User user);

    /**
     * 删除
     * **/
    public int delete(User user);

    /**
     * 修改
     * */
    public int update(User user);

    /**
     * 查询
     * */
    public List<User> selectAll();

}
