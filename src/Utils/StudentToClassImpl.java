package Utils;

import User.User;

import java.util.List;

public class StudentToClassImpl implements ManyToMany{
    @Override
    public int insert(long principal_id, long subordinate_id) {
        return 0;
    }

    @Override
    public int delete(long principal_id, long subordinate_id) {
        return 0;
    }

    @Override
    public int update(long principal_id, long subordinate_id) {
        return 0;
    }

    @Override
    public List<User> search(long principal_id, long subordinate_id) {
        return null;
    }
}
