package Course;

import Utils.CourseDaoImpl;

import java.util.List;

public class SearchCourse {
    private String name;

    /**
     * @param name 搜索的课程的名称
     **/
    public SearchCourse(String name){
        this.name = name;
    }

    public List<Course> searchCourse(){
        CourseDaoImpl courseDao = new CourseDaoImpl();
        List<Course> selectedCourses = courseDao.selectSomeCourses(name);
        return selectedCourses;
    }
}
