package Community;

import User.User;
import Utils.*;
import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import User.Follower;
import java.util.List;

public class CommunityServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("收到微信小程序的请求");
        resp.setContentType("text/html;charset=utf-8");
        System.out.println("这里是社区响应");
        req.setCharacterEncoding("utf-8");

        String type = req.getParameter("type");
        JSONArray jsonArray = new JSONArray();

        if(type.equals("community")) {

            DiscussionDaoImpl discussionDao = new DiscussionDaoImpl();

            List<Discussion> discussions = discussionDao.selectAll();
            getDisList(jsonArray, discussions);
        }

        if(type.equals("comment")){
            CommentDaoImpl commentDao = new CommentDaoImpl();

            getCommentList(jsonArray, commentDao);
        }

        if(type.equals("searchResult")){
            DiscussionDaoImpl discussionDao = new DiscussionDaoImpl();
            String name = req.getParameter("name");
            List<Discussion> discussions = discussionDao.searchDiscussion(name);
            getDisList(jsonArray, discussions);
        }

        if(type.equals("community_new_comment")){

            String id = req.getParameter("discussion_id");
            System.out.println("——————————————————————————————————————开始创建新的评论——————————————————————————————————");
            long discussion_id = Integer.parseInt(id);

            CommentDaoImpl commentDao = new CommentDaoImpl();
            List<Comment> list = commentDao.search(discussion_id);
            String info = req.getParameter("info");


            Comment comment = new Comment();

            if(list != null){
                long comment_id = 0;
                for(Comment comment1:list){
                    if(comment_id <= comment1.getComment_id()){
                        comment_id = comment1.getComment_id()+1;
                    }
                }
                comment.setComment_id(comment_id);
            }
            else{
                comment.setComment_id(0);
            }
            comment.setDiscussion_id(discussion_id);
            comment.setComment_content(info);

            String name = req.getParameter("discussion_adminName");
            UserDaoImpl userDao = new UserDaoImpl();
            User usr = userDao.findUserName(name);
            comment.setComment_responder_id(usr.getUserId());

            commentDao.insert(comment);

            getCommentList(jsonArray, commentDao);
        }

        if(type.equals("createDisRequest")){
            String user_name = req.getParameter("user_name");
            UserDaoImpl userDao = new UserDaoImpl();

            User user = userDao.findUserName(user_name);
            JSONObject jsonObject = new JSONObject();

            jsonObject.put("user_isBan",user.isUser_isBan());
            jsonArray.add(jsonObject);
        }

        if(type.equals("send")){
            String user_name = req.getParameter("user_name");
            UserDaoImpl userDao = new UserDaoImpl();

            User user = userDao.findUserName(user_name);
            JSONObject jsonObject = new JSONObject();

            jsonObject.put("user_isBan",user.isUser_isBan());
            jsonArray.add(jsonObject);
        }

        if(type.equals("attention")){
            FollowerDaoImpl followerDao = new FollowerDaoImpl();
            List<Follower> followers = followerDao.selectAll();
            UserDaoImpl userDao = new UserDaoImpl();
            if(followers != null){
                for(Follower follower:followers){
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("discussion_title_img_url","https://shixunimageandvideo.oss-cn-beijing.aliyuncs.com/images/%E5%A4%B4%E5%83%8F.png");
                    User user = userDao.findUserId(follower.getFollower_id());
                    if(user != null){
                        jsonObject.put("adminName",user.getUserName());
                    }
                    jsonArray.add(jsonObject);
                }
            }
        }

        System.out.println("JSON语句为："+jsonArray);
        System.out.println("发出信息：");
        System.out.println(jsonArray.toString());
        Writer out = resp.getWriter();
        out.write(jsonArray.toString());
        out.flush();
    }

    public void getCommentList(JSONArray jsonArray, CommentDaoImpl commentDao) {
        List<Comment> comments = commentDao.selectAll();
        UserDaoImpl userDao = new UserDaoImpl();
        if(comments != null) {
            for (Comment comment : comments) {
                JSONObject jo = new JSONObject();
                jo.put("discussion_id", comment.getDiscussion_id());

                jo.put("comment_id", comment.getComment_id());
                jo.put("comment_content", comment.getComment_content());
                jo.put("comment_responder_id", comment.getComment_responder_id());
                User user = userDao.findUserId(comment.getComment_responder_id());
                if (user != null) {
                    jo.put("comment_user_name", user.getUserName());
                }
                jo.put("comment_img_url", "https://shixunimageandvideo.oss-cn-beijing.aliyuncs.com/images/%E5%A4%B4%E5%83%8F.png");
                jsonArray.add(jo);
            }
        }
    }

    public void getDisList(JSONArray jsonArray, List<Discussion> discussions) {
        UserDaoImpl userDao = new UserDaoImpl();
        if(discussions != null) {
            for (Discussion discussion : discussions) {
                JSONObject jo = new JSONObject();
                jo.put("discussion_id", discussion.getDiscussion_id());
                jo.put("discussion_adminId", discussion.getAdminId());
                User user = userDao.findUserId(discussion.getAdminId());
                if(user != null){
                    jo.put("adminName",user.getUserName());
                }
                jo.put("discussion_name", discussion.getDiscussion_name());
                jo.put("discussion_title_img_url", discussion.getDiscussion_title_img_url());
                jo.put("discussion_content", discussion.getDescription());
                jo.put("comment_img","https://shixunimageandvideo.oss-cn-beijing.aliyuncs.com/images/LegalHigh01.png");
                jsonArray.add(jo);
            }
        }
    }
}
