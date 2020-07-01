package control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CourseDao;

public class DeleteCourse extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");

        int courseId = Integer.valueOf(request.getParameter("id"));//获取表单
        
       	CourseDao courseDao = new CourseDao();//创建Dao类实现对数据库中course表的访问
		try {
			courseDao.delete(courseId);//删除指定课程
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		
	}
}
