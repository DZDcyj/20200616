package Utils;

import Community.DisAndCom;
import User.ClassToUser;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentToClassDaoImpl extends DButils implements ManyToManyDao {

    /**
     * 根据课程id和用户id
     * 添加到数据库
     * */

    @Override
    public int insert(long principal_id, long subordinate_id) {
        Object params [] = {principal_id,subordinate_id};
        String sql = "insert into course_student values(?,?)";

        int i = doUpdate(sql,params);
        getClose();
        return i;
    }

    /**
     * 删除课程-学生表中到信息
     * */

    @Override
    public int delete(long principal_id, long subordinate_id) {
        Object[] params;
        String sql;
        /**
         * course被删除的情况
         **/
        if(subordinate_id == -1) {
            params = new Object[]{principal_id};
            sql = "delete from course_student where course_id=?";
        }
        /**
         * user被删除的情况
         * */
        else{
            params = new Object[]{principal_id, subordinate_id};
            sql = "delete from course_student where course_id=? and user_id=?";
        }

        int i = doUpdate(sql,params);
        getClose();
        return i;
    }

    /**
     * 更新课程-学神表中的信息
     * */

    @Override
    public int update(long principal_id, long subordinate_id) {
        Object params[] = {principal_id,subordinate_id,principal_id};
        String sql = "update course_student course_id=?,user_id=? where class_id=?";
        int i = doUpdate(sql,params);
        getClose();
        return i;
    }

    /**
     * 根据用户id搜索课程
     *
     * */

    @Override
    public List search(long principal_id, long subordinate_id) {
        String sql = "select * from course_student where user_id="+subordinate_id;
        return getList(sql);
    }
    public List searchCourse( long subordinate_id) {
        String sql = "select * from course_student where user_id="+subordinate_id;
        return getList(sql);
    }

    /**
     * 获取课程-学生列表
     * */

    public List<ClassToUser> getList(String sql){

        ResultSet rs = doQuery(sql,null);
        List<ClassToUser> list = null;

        try {
            if(rs.next()){
                rs.beforeFirst();
                list = new ArrayList<ClassToUser>();
                while(rs.next()){
                    ClassToUser classToUser = new ClassToUser();
                    classToUser.setCourse_id(rs.getInt(1));
                    classToUser.setUser_id(rs.getInt(2));
                    list.add(classToUser);
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }
}
