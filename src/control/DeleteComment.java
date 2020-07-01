package control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import User.User;
import dao.CommentDao;

public class DeleteComment extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");

        int id = Integer.valueOf(request.getParameter("id"));//获取表单值
        
       	CommentDao commentDao = new CommentDao();
        User user;
		try {
			commentDao.delete(id);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		
	}
}