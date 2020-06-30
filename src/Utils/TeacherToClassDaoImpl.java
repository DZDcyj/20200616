package Utils;

import Community.DisAndCom;
import User.ClassToUser;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TeacherToClassDaoImpl extends DButils implements ManyToManyDao {
    @Override
    public int insert(long principal_id, long subordinate_id) {
        Object params [] = {principal_id,subordinate_id};
        String sql = "insert into course_teacher values(?,?)";

        int i = doUpdate(sql,params);
        getClose();
        return i;
    }

    @Override
    public int delete(long principal_id, long subordinate_id) {
        Object[] params;
        String sql;
        /**
         *discussion被删除的情况
         **/
        if(subordinate_id == -1) {
            params = new Object[]{principal_id};
            sql = "delete from course_teacher where course_id=?";
        }
        /**
         *comment被删除的情况
         * */
        else{
            params = new Object[]{principal_id, subordinate_id};
            sql = "delete from course_teacher where course_id=? and user_id=?";
        }

        int i = doUpdate(sql,params);
        getClose();
        return i;
    }

    @Override
    public int update(long principal_id, long subordinate_id) {
        Object params[] = {principal_id,subordinate_id,principal_id};
        String sql = "update course_teacher course_id=?,user_id=? where class_id=?";
        int i = doUpdate(sql,params);
        getClose();
        return i;
    }

    @Override
    public List search(long principal_id, long subordinate_id) {
        Object params[] = {principal_id};
        String sql = "select * from course_user where class_id=?";
        return getList(sql);
    }
    public List<ClassToUser> getList(String sql){

        ResultSet rs = doQuery(sql,null);
        List<ClassToUser> list = null;

        try {
            if(rs.next()){
                rs.beforeFirst();
                list = new ArrayList<ClassToUser>();
                while(rs.next()){
                    ClassToUser classToUser = new ClassToUser();
                    classToUser.setCourse_id(1);
                    classToUser.setCourse_id(2);
                    list.add(classToUser);
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }
}
