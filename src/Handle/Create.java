package Handle;

import Community.Discussion;
import User.User;
import Utils.DiscussionDaoImpl;
import Utils.UserDaoImpl;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

public class Create extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("收到微信小程序的请求");
        resp.setContentType("text/html;charset=utf-8");
        System.out.println("这里是创建讨论响应");
        req.setCharacterEncoding("utf-8");

        String type = req.getParameter("type");
        JSONArray jsonArray = new JSONArray();

        /**
         * 创建一个新的讨论板块
         * 并更新数据库中的信息
         * */

        if(type.equals("CreateDis")){
            String discussion_name = req.getParameter("title");
            String discussion_description = req.getParameter("description");
            UserDaoImpl userDao = new UserDaoImpl();
            Discussion discussion = new Discussion();
            DiscussionDaoImpl discussionDao = new DiscussionDaoImpl();

            List<Discussion> discussionList = discussionDao.selectAll();

            discussion.setDiscussion_id(1);
            if(discussionList != null) {
                long discussion_id = 0;
                for(Discussion discussion1:discussionList){
                    if(discussion_id <= discussion1.getDiscussion_id()){
                        discussion_id = discussion1.getDiscussion_id() + 1;
                    }
                }
                discussion.setDiscussion_id(discussion_id);
            }
            User user = userDao.findUserName(req.getParameter("name"));
            if(user != null) {
                discussion.setAdminId(user.getUserId());
            }
            discussion.setDiscussion_title_img_url("https://shixunimageandvideo.oss-cn-beijing.aliyuncs.com/images/%E5%A4%B4%E5%83%8F.png");
            discussion.setDiscussion_name(discussion_name);
            discussion.setDescription(discussion_description);

            discussionDao.insert(discussion);

            List<Discussion> discussions = discussionDao.selectAll();
        }
    }

}
