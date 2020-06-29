package Utils;

import java.util.List;

public class TeacherToClassImpl implements ManyToMany{

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
    public List<Long> search(long principal_id, long subordinate_id) {
        return null;
    }
}
