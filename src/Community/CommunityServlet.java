package Community;

import Utils.CommentDaoImpl;
import Utils.DiscussionDaoImpl;
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
            System.out.println(id);
            long discussion_id = Integer.parseInt(id);

            CommentDaoImpl commentDao = new CommentDaoImpl();
            List<Comment> list = commentDao.search(discussion_id);
            String info = req.getParameter("info");


            Comment comment = new Comment();

            comment.setComment_id(list.size()+1);
            comment.setDiscussion_id(discussion_id);
            comment.setComment_content(info);
            comment.setComment_responder_id(10);

            commentDao.insert(comment);

            getCommentList(jsonArray, commentDao);
        }

        System.out.println("JSON语句为："+jsonArray);
        System.out.println("发出信息：");
        System.out.println(jsonArray.toString());
        Writer out = resp.getWriter();
        out.write(jsonArray.toString());
        out.flush();
    }

    private void getCommentList(JSONArray jsonArray, CommentDaoImpl commentDao) {
        List<Comment> comments = commentDao.selectAll();

        for(Comment comment:comments){
            JSONObject jo = new JSONObject();
            jo.put("discussion_id",comment.getDiscussion_id());
            jo.put("comment_id",comment.getComment_id());
            jo.put("comment_content",comment.getComment_content());
            jo.put("comment_responder_id",comment.getComment_responder_id());
            jo.put("comment_img_url","https://shixunimageandvideo.oss-cn-beijing.aliyuncs.com/images/%E5%A4%B4%E5%83%8F.png");
            jsonArray.add(jo);
        }
    }

    private void getDisList(JSONArray jsonArray, List<Discussion> discussions) {
        if(discussions != null) {
            for (Discussion discussion : discussions) {
                JSONObject jo = new JSONObject();
                jo.put("discussion_id", discussion.getDiscussion_id());
                jo.put("discussion_adminId", discussion.getAdminId());
                jo.put("discussion_name", discussion.getDiscussion_name());
                jo.put("discussion_title_img_url", discussion.getDiscussion_title_img_url());
                jo.put("discussion_content", discussion.getDescription());
                jo.put("comment_img","https://shixunimageandvideo.oss-cn-beijing.aliyuncs.com/images/LegalHigh01.png");
                jsonArray.add(jo);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
