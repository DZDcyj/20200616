package test;

import Course.Course;
import Utils.CourseDaoImpl;
import Utils.StudentToClassDaoImpl;
import Utils.TeacherToClassDaoImpl;

public class Test_course {
    public static void main(String args[]){
        /*Course course = new Course();
        CourseDaoImpl courseDao = new CourseDaoImpl();
        course.setCourse_id(0);
        course.setCourse_name("操作系统");
        course.setCourse_description("操作系统(Operating System，简称OS)是管理计算机硬件与软件资源的计算机程序");
        course.setImage_url("https://shixunimageandvideo.oss-cn-beijing.aliyuncs.com/images/%E6%93%8D%E4%BD%9C%E7%B3%BB%E7%BB%9F.png");
        course.setVideo_url("https://shixunimageandvideo.oss-cn-beijing.aliyuncs.com/video/%E6%93%8D%E4%BD%9C%E7%B3%BB%E7%BB%9F.mp4");
        course.setCourse_views(0);
        courseDao.delete(course);
        courseDao.insert(course);
*/
        StudentToClassDaoImpl studentToClassDao = new StudentToClassDaoImpl();
        studentToClassDao.delete(3,2);
        TeacherToClassDaoImpl teacherToClassDao = new TeacherToClassDaoImpl();
        teacherToClassDao.delete(3,2);
        CourseDaoImpl courseDao = new CourseDaoImpl();
        Course course = new Course();
        course.setCourse_id(1);
        courseDao.delete(course);
       // studentToClassDao.insert(0,2);
    }
}

