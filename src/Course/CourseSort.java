package Course;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CourseSort {
    List<Course> courseList;

    public CourseSort(List<Course> courses){
        this.courseList = courses;
    }

    public List<Course> sortResult(){
        Collections.sort(courseList, new Comparator<Course>() {
            @Override
            public int compare(Course o1, Course o2) {
                if(o1.getCourse_views() - o2.getCourse_views() >0){
                    return 1;
                }
                else{
                    return -1;
                }
            }
        });
        return courseList;
    }
}
