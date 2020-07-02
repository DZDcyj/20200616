package Utils;

import Course.Course;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseDaoImpl extends DButils implements CourseDao{
    /**
     * 向数据库添加课程的处理函数
     * */

    @Override
    public int insert(Course course) {
        Object params [] = {course.getCourse_id(),course.getCourse_name(),course.getImage_url(),course.getVideo_url(),course.getCourse_views(),course.getCourse_description()};
        String sql = "insert into Course values(?,?,?,?,?,?)";
        int i = doUpdate(sql,params);
        getClose();
        return i;
    }

    /**
     * 选取数据库中的所有课程
     * */

    @Override
    public List<Course> selectAll() {
        String sql = "select * from course";

        return getCourses(sql);
    }

    /**
     * 获得课程列表
     * **/

    public List<Course> getCourses(String sql) {
        ResultSet rs = doQuery(sql,null);
        List<Course> list = null;
        try {
            if(rs.next()){
                rs.beforeFirst();
                list = new ArrayList<Course>();
                while(rs.next()){
                    Course course = new Course();
                    course.setCourse_id(rs.getInt(1));
                    course.setCourse_name(rs.getString(2));
                    course.setImage_url(rs.getString(3));
                    course.setVideo_url(rs.getString(4));
                    course.setCourse_views(rs.getInt(5));
                    course.setCourse_description(rs.getString(6));
                    list.add(course);
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        getClose();
        return list;
    }

    /**
     * 提供搜索所用的接口
     * 根据讨论的名称搜索
     * **/

    @Override
    public List<Course> selectSomeCourses(String name) {
        Object params[] = {name};
        String sql = "select * from course where course_name like "+"'%"+name+"%'";
        return getCourses(sql);

    }

    /**
     * 更新课程信息
     * 根据课程id，选取课程更新
     * */

    @Override
    public int update(Course course) {
        Object params[] = {course.getCourse_id(),course.getCourse_name(),course.getImage_url(),course.getVideo_url(),course.getCourse_views(),course.getCourse_description(),course.getCourse_id()};
        String sql = "update course set course_id=?,course_name=?,course_image_url=?,course_video_url=?,course_views=?,course_description=? where course_id=?";
        int i = doUpdate(sql, params);

        // 释放资源
        getClose();
        return i;
    }

    /**
     * 从数据库中删除课程
     * 根据课程id删除
     * */

    @Override
    public int delete(Course course) {
        Object params[] = {course.getCourse_id()};
        // 要执行的sql语句
        String sql = "delete from course where course_id=?";

        // 执行sql语句
        int i = doUpdate(sql, params);

        // 释放资源
        getClose();
        return i;
    }

    public Course searchCourse(long id){
        String sql = "select * from course where course_id="+id;
        if(getCourses(sql) != null) {
            return getCourses(sql).get(0);
        }
        return null;
    }
}
