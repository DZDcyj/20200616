package Utils;

import Course.Course;

import java.util.List;

public interface CourseDao {
    /**
     *添加
     * */
    public int insert(Course course);

    /**
     * 删除
     * **/
    public int delete(Course course);

    /**
     * 修改
     * */
    public int update(Course course);

    /**
     * 查询
     * */
    public List<Course> selectAll();
    /**
     * 模糊搜索
     * */
    public List<Course> selectSomeCourses(String name);
}
