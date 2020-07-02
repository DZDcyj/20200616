package control;

import java.io.DataInput;
import java.io.IOException;
import java.io.Writer;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import Community.Comment;
import User.ClassToUser;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Community.Discussion;
import Course.Course;
import User.User;
import Utils.*;
import dao.UserDao;
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

		if(type.equals("deletediscussion")){
			/*StudentToClassDaoImpl studentToClassDao = new StudentToClassDaoImpl();

			long id = Integer.valueOf(request.getParameter("id"));
			String name = request.getParameter("name");*/

			UserDaoImpl userDao = new UserDaoImpl();
			//User user = userDao.findUserName(name);

			System.out.println("-----------------------------");


				DiscussionDaoImpl discussionDao = new DiscussionDaoImpl();
				List<Discussion> discussions = discussionDao.selectAll();

				if(discussions != null){
					for(Discussion discussion:discussions){
						JSONObject jsonObject = new JSONObject();
						jsonObject.put("discussion_id", discussion.getDiscussion_id());
						jsonObject.put("discussion_adminId", discussion.getAdminId());
						User user = userDao.findUserId(discussion.getAdminId());
						if(user != null){
							jsonObject.put("adminName",user.getUserName());
						}
						jsonObject.put("discussion_name", discussion.getDiscussion_name());
						jsonObject.put("discussion_title_img_url", discussion.getDiscussion_title_img_url());
						jsonObject.put("discussion_content", discussion.getDescription());
						jsonObject.put("comment_img","https://shixunimageandvideo.oss-cn-beijing.aliyuncs.com/images/LegalHigh01.png");
						jo.add(jsonObject);
					}
				}
		}

		if(type.equals("deletemydiscussion")){
			String user_name = request.getParameter("user_name");
			UserDaoImpl userDao = new UserDaoImpl();
			User user = userDao.findUserName(user_name);
			DiscussionDaoImpl discussionDao = new DiscussionDaoImpl();
			List<Discussion> discussions = null;

			if(user != null) {
				discussions = discussionDao.findNums(user.getUserId());
			}
			if(discussions != null){
				for(Discussion discussion:discussions){
					JSONObject jsonObject = new JSONObject();
					jsonObject.put("discussion_id", discussion.getDiscussion_id());
					jsonObject.put("discussion_adminId", discussion.getAdminId());
					User user1 = userDao.findUserId(discussion.getAdminId());
					if(user1 != null){
						jsonObject.put("adminName",user1.getUserName());
					}
					jsonObject.put("discussion_name", discussion.getDiscussion_name());
					jsonObject.put("discussion_title_img_url", discussion.getDiscussion_title_img_url());
					jsonObject.put("discussion_content", discussion.getDescription());
					jsonObject.put("comment_img","https://shixunimageandvideo.oss-cn-beijing.aliyuncs.com/images/LegalHigh01.png");
					jo.add(jsonObject);
				}
			}
		}

		if(type.equals("initMy")){
			String user_name = request.getParameter("user_name");
			UserDaoImpl userDao = new UserDaoImpl();
			System.out.println("用户为："+user_name);

			User user = userDao.findUserName(user_name);

			if(user != null){
				StudentToClassDaoImpl studentToClassDao = new StudentToClassDaoImpl();
				TeacherToClassDaoImpl teacherToClassDao = new TeacherToClassDaoImpl();

				List<ClassToUser> courses = studentToClassDao.search(0,user.getUserId());
				List<ClassToUser> courseList = teacherToClassDao.search(0,user.getUserId());

				CourseDaoImpl courseDao = new CourseDaoImpl();
				List<Course> courses1 = new ArrayList<Course>();
				Iterator<ClassToUser> classToUserIterator1 = null;
				Iterator<ClassToUser> classToUserIterator = null;

				if(courses != null) {
					classToUserIterator = courses.iterator();
				}

				if(courseList != null) {
					classToUserIterator1 = courseList.iterator();
				}

				if(classToUserIterator != null && classToUserIterator1 != null) {
					while (classToUserIterator.hasNext()) {
						ClassToUser classToUser = classToUserIterator.next();
						while (classToUserIterator1.hasNext()) {
							ClassToUser classToUser1 = classToUserIterator1.next();
							if (classToUser.getCourse_id() == classToUser1.getCourse_id()) {
								classToUserIterator1.remove();
							}
						}
					}
				}

				if(courses != null) {
					for (ClassToUser classToUser : courses) {
						courses1.add(courseDao.searchCourse(classToUser.getCourse_id()));
					}
				}
				if(courseList != null){
					for(ClassToUser classToUser: courseList){
						courses1.add(courseDao.searchCourse(classToUser.getCourse_id()));
					}
				}
				for(Course course:courses1){
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


		if(type.equals("delete")){
        	String course_id = request.getParameter("id");
        	long id = Integer.valueOf(course_id);

        	DiscussionDaoImpl discussionDao =  new DiscussionDaoImpl();

        	Discussion discussion = new Discussion();
        	CommentDaoImpl commentDao = new CommentDaoImpl();

        	discussion.setDiscussion_id(id);
			Comment comment = new Comment();
			comment.setDiscussion_id(id);
			commentDao.deleteDisComment(comment);
        	discussionDao.delete(discussion);

		}

		if(type.equals("deletecourse" )|| type.equals("deletemycourse")){
			String course_id_s = request.getParameter("id");
			long course_id = Integer.valueOf(course_id_s);

			String user_name = request.getParameter("user_name");

			UserDaoImpl userDao = new UserDaoImpl();
			User user = userDao.findUserName(user_name);

			if(user != null){
				TeacherToClassDaoImpl teacherToClassDao1 = new TeacherToClassDaoImpl();
				ClassToUser classToUser = teacherToClassDao1.findCourse(user.getUserId(),course_id);
				if(classToUser != null){
					CourseDaoImpl courseDao = new CourseDaoImpl();
					Course course = new Course();
					course.setCourse_id(course_id);
					courseDao.delete(course);
				}
			}
			CourseDaoImpl courseDao = new CourseDaoImpl();
			Course course = new Course();
			if(type.equals("deletecourse")) {
				course.setCourse_id(course_id);
				courseDao.delete(course);
			}

			TeacherToClassDaoImpl teacherToClassDao = new TeacherToClassDaoImpl();
			teacherToClassDao.delete(course_id,-1);

			StudentToClassDaoImpl studentToClassDao = new StudentToClassDaoImpl();
			studentToClassDao.delete(course_id,-1);
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
