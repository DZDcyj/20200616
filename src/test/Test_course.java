package test;

import Course.Course;
import Utils.CourseDaoImpl;
import Utils.StudentToClassDaoImpl;
import Utils.TeacherToClassDaoImpl;

public class Test_course {
    public static void main(String args[]){
        Course course = new Course();
        CourseDaoImpl courseDao = new CourseDaoImpl();
        course.setCourse_id(1);
        course.setCourse_name("机器学习");
        course.setCourse_description("机器学习是一门多领域交叉学科，涉及概率论、统计学、逼近论、凸分析、算法复杂度理论等多门学科。");
        course.setImage_url("https://shixunimageandvideo.oss-cn-beijing.aliyuncs.com/images/ml.png");
        course.setVideo_url("https://shixunimageandvideo.oss-cn-beijing.aliyuncs.com/video/ml.mp4");
        course.setCourse_views(0);
        courseDao.update(course);
    }
}

