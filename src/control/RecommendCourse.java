package control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;

public class RecommendCourse extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");

        long userId = Integer.valueOf(request.getParameter("userId"));//获取表单值，待修改。
        long recCourseId = Integer.valueOf(request.getParameter("recCourseId"));
        
        UserDao userDao = new UserDao();
		try {     
			userDao.addRecCourse(userId, recCourseId);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		
	}
	

}
