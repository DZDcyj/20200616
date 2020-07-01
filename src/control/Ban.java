package control;

import dao.UserDao;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Ban extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");

        String userName = request.getParameter("name");//获取表单值，待修改。
        
       	UserDao UserDao = new UserDao();
		try {
			UserDao.banUser(userName);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		
	}
}
