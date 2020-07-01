package control;

import User.User;
import Utils.UserDaoImpl;
import dao.UserDao;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.io.IOException;
import java.io.Writer;
import java.sql.SQLException;
import java.util.List;

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


		String type = request.getParameter("type");
		UserDaoImpl userDao = new UserDaoImpl();


		String userName = request.getParameter("name");//获取表单值，待修改。
		System.out.println("获取到的姓名为："+userName);


		if(type.equals("initBanPage")){
			List<User> users = userDao.selectAll();
			JSONArray jsonArray = new JSONArray();

			for(User user:users){
				JSONObject jo = new JSONObject();

				jo.put("userId",user.getUserId());
				jo.put("userName",user.getUserName());
				jo.put("userAge",user.getUserAge());
				jo.put("userSex",user.getUserSex());
				jo.put("userAddress",user.getUserAddress());
				jo.put("user_isBan",user.isUser_isBan());
				jo.put("user_img_url","https://shixunimageandvideo.oss-cn-beijing.aliyuncs.com/images/%E5%A4%B4%E5%83%8F.png");

				jsonArray.add(jo);
			}

			System.out.println("JSON语句为："+jsonArray);
			System.out.println("发出信息：");
			System.out.println(jsonArray.toString());
			Writer out = response.getWriter();
			out.write(jsonArray.toString());
			out.flush();
		}

		if(type.equals("banUser")){
			userDao.banUser(userName);
		}


	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		
	}
}
