package control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import User.ClassToUser;
import Ali.AliOssUtil;
import Course.Course;
import User.User;
import Utils.CourseDaoImpl;
import Utils.TeacherToClassDaoImpl;
import Utils.UserDaoImpl;

public class CreateCourse extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");

        String type = request.getParameter("type");


        if(type.equals("createCourse")) {
            CourseDaoImpl courseDao = new CourseDaoImpl();


            long courseId = courseDao.selectAll().size();//获取表单值
            String courseName = request.getParameter("title");
            String courseImgUrl = request.getParameter("img_url");
            String courseVideoUrl = request.getParameter("video_url");
            String description = request.getParameter("description");
            String user_name = request.getParameter("user_name");

            Course course = new Course();
            course.setCourse_id(courseId);
            course.setCourse_name(courseName);
            course.setImage_url(courseImgUrl);
            course.setVideo_url(courseVideoUrl);
            course.setCourse_description(description);

            String object_img_path = "images/"+course.getCourse_name()+".png";
            String local_img_path = course.getImage_url();

            AliOssUtil aliOssUtil_img = new AliOssUtil(object_img_path,local_img_path);
            aliOssUtil_img.uploadFile();
            String img_url = aliOssUtil_img.getUrl();
            course.setImage_url(img_url);

            String object_video_path = "video/"+course.getCourse_name()+".mp4";

            String local_video_path = course.getVideo_url();

            AliOssUtil aliOssUtil_video = new AliOssUtil(object_video_path,local_video_path);
            aliOssUtil_video.uploadFile();

            String video_url = aliOssUtil_video.getUrl();
            course.setVideo_url(video_url);
            System.out.println(video_url);

            UserDaoImpl userDao = new UserDaoImpl();
            User user = userDao.findUserName(user_name);

            TeacherToClassDaoImpl teacherToClassDao = new TeacherToClassDaoImpl();

            ClassToUser classToUser = new ClassToUser();
            classToUser.setCourse_id(courseId);
            classToUser.setUser_id(user.getUserId());

            teacherToClassDao.insert(classToUser.getCourse_id(),classToUser.getUser_id());

            courseDao.insert(course);
        }

	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		
	}
}
