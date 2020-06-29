package test;

import Course.Course;
import Utils.CourseDaoImpl;

public class Test_course {
    public static void main(String args[]){
        Course course = new Course();
        CourseDaoImpl courseDao = new CourseDaoImpl();
        course.setCourse_id(20200625);
        course.setCourse_name("LoveDeathAndRobot");
        course.setImage_url("https://shixunimageandvideo.oss-cn-beijing.aliyuncs.com/images/lovedeathandrobot.png");
        course.setVideo_url("https://shixunimageandvideo.oss-cn-beijing.aliyuncs.com/video/%E7%88%B1-%E6%AD%BB%E4%BA%A1%E5%92%8C%E6%9C%BA%E5%99%A8%E4%BA%BA%E7%AC%AC%E4%B8%80%E5%AD%A301.mp4");
        course.setCourse_description("爱，死亡和机器人》（Love,Death&Robots）是由NetFlix出品，提姆·米勒和大卫·芬奇执行监制的成人向动画短片集，于2019年3月15日在美国首播 [1]  宣布将续订第二季，提姆·米勒和大卫·芬奇继续担任该剧第二季的执行制片人，导演吕寅荣也会加入主创团队，成为第二季的监察导演之一");
        course.setCourse_views(0);
        courseDao.update(course);
    }
}

