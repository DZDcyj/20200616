package control;

import java.io.IOException;
import java.io.Writer;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Course.Course;
import User.User;
import Utils.CourseDaoImpl;
import Utils.StudentToClassDaoImpl;
import Utils.TeacherToClassDaoImpl;
import Utils.UserDaoImpl;
import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class DeleteCourse extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");

        String type = request.getParameter("type");
		JSONArray jo = new JSONArray();

        if(type.equals("init")) {
			CourseDaoImpl courseDao = new CourseDaoImpl();
			List<Course> courses = courseDao.selectAll();


			if(courses != null) {
				for (Course course : courses) {
					JSONObject jsonObject = new JSONObject();
					jsonObject.put("course_id", course.getCourse_id());
					jsonObject.put("course_name", course.getCourse_name());
					jsonObject.put("course_image_url", course.getImage_url());
					jsonObject.put("course_video_url", course.getVideo_url());
					jsonObject.put("course_views", course.getCourse_views());
					jsonObject.put("course_description", course.getCourse_description());
					jo.add(jsonObject);
				}
			}
		}
		if(type.equals("add")){
			StudentToClassDaoImpl studentToClassDao = new StudentToClassDaoImpl();

			long id = Integer.valueOf(request.getParameter("id"));
			String name = request.getParameter("name");

			UserDaoImpl userDao = new UserDaoImpl();
			User user = userDao.findUserName(name);

			StudentToClassDaoImpl toClassDao =  new StudentToClassDaoImpl();
			toClassDao.insert(id,user.getUserId());
		}

		if(type.equals("delete")){
        	String course_id = request.getParameter("id");
        	long id = Integer.valueOf(course_id);
        	CourseDaoImpl courseDao = new CourseDaoImpl();
        	Course course = new Course();

        	course.setCourse_id(id);

        	courseDao.delete(course);

			TeacherToClassDaoImpl teacherToClassDao = new TeacherToClassDaoImpl();
			teacherToClassDao.delete(id,-1);

			StudentToClassDaoImpl studentToClassDao = new StudentToClassDaoImpl();
			studentToClassDao.delete(id,-1);
		}
		System.out.println("JSON语句为："+jo);
		System.out.println("发出信息：");
		System.out.println(jo.toString());
		Writer out = response.getWriter();
		out.write(jo.toString());
		out.flush();
       /*	CourseDao courseDao = new CourseDao();//创建Dao类实现对数据库中course表的访问
		try {
			courseDao.delete(courseId);//删除指定课程
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/

	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		
	}
}
