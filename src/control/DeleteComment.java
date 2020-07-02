package control;

import java.io.IOException;
import java.io.Writer;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Community.Comment;
import User.User;
import Utils.CommentDaoImpl;
import Utils.StudentToClassDaoImpl;
import Utils.UserDaoImpl;
import dao.CommentDao;
import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class DeleteComment extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");
        System.out.println("这里是评论信息删除");

        String type = request.getParameter("type");//获取表单值
		CommentDaoImpl commentDao = new CommentDaoImpl();

		JSONArray jsonArray = new JSONArray();

		if(type.equals("init")){
			List<Comment> comments = commentDao.selectAll();
			UserDaoImpl userDao = new UserDaoImpl();
			if(comments != null) {
				for (Comment comment : comments) {
					JSONObject jo = new JSONObject();
					jo.put("comment_id", comment.getComment_id());
					jo.put("comment_img_url", "https://shixunimageandvideo.oss-cn-beijing.aliyuncs.com/images/%E5%A4%B4%E5%83%8F.png");
					jo.put("comment_content", comment.getComment_content());
					if (userDao.findUserId(comment.getComment_responder_id()) != null) {
						jo.put("comment_user_name", userDao.findUserId(comment.getComment_responder_id()).getUserName());
					}
					jo.put("comment_responder_id", comment.getComment_responder_id());

					jsonArray.add(jo);
				}
			}
		}

		if(type.equals("delete")){
			System.out.println("这里删除我的评论" );

			Comment comment = new Comment();
			comment.setComment_id(Integer.valueOf(request.getParameter("id")));
			UserDaoImpl userDao = new UserDaoImpl();
			String name = request.getParameter("responder");
			long responder_id = Integer.valueOf(name);
			comment.setComment_responder_id(responder_id);

			System.out.println(comment.getComment_id());
			commentDao.deleteComment(comment);


		}

		if(type.equals("initMy")){
			System.out.println("用户界面初始化");
			String name = request.getParameter("user_name");
			UserDaoImpl userDao = new UserDaoImpl();
			User user = userDao.findUserName(name);
			List<Comment> comments = null;
			if(user != null) {
				 comments = commentDao.searchByUserId(user.getUserId());
			}
			if(comments != null) {
				for (Comment comment : comments) {
					JSONObject jo = new JSONObject();
					jo.put("comment_id", comment.getComment_id());
					jo.put("comment_img_url", "https://shixunimageandvideo.oss-cn-beijing.aliyuncs.com/images/%E5%A4%B4%E5%83%8F.png");
					jo.put("comment_content", comment.getComment_content());
					if (userDao.findUserId(comment.getComment_responder_id()) != null) {
						jo.put("comment_user_name", userDao.findUserId(comment.getComment_responder_id()).getUserName());
					}
					jo.put("comment_responder_id", comment.getComment_responder_id());

					jsonArray.add(jo);
				}
			}
		}

		System.out.println("JSON语句为："+jsonArray);
		System.out.println("发出信息：");
		System.out.println(jsonArray.toString());
		Writer out = response.getWriter();
		out.write(jsonArray.toString());
		out.flush();
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		
	}
}