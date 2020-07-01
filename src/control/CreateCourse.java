package control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Course.Course;
import dao.CourseDao;

public class CreateCourse extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");

        long courseId = Integer.valueOf(request.getParameter("id"));//获取表单值
        String courseName = request.getParameter("title");
        String courseImgUrl = request.getParameter("img_url");
        String courseVideoUrl = request.getParameter("vidio_url");
        String description = request.getParameter("description");
        
        Course course = new Course();
        course.setCourse_id(courseId);
        course.setCourse_name(courseName);
        course.setImage_url(courseImgUrl);
        course.setVideo_url(courseVideoUrl);
        course.setCourse_description(description);
        
       	CourseDao courseDao = new CourseDao();
		try {
			courseDao.add(course);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		
	}
}
