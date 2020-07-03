package User;

import Community.Comment;
import Community.Discussion;
import Utils.CommentDaoImpl;
import Utils.DiscussionDaoImpl;
import Utils.FollowerDaoImpl;
import Utils.UserDaoImpl;
import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("收到微信小程序的请求");
        resp.setContentType("text/html;charset=utf-8");
        System.out.println("这里是账户响应");
        req.setCharacterEncoding("utf-8");
        String type = req.getParameter("type");

        /**
         * 处理关注信息
         * */

        if(type.equals("subscribe")){
            UserDaoImpl userDao = new UserDaoImpl();

            String subscribe_user_name = req.getParameter("subscribe_user_name");
            User subscribe_user = userDao.findUserName(subscribe_user_name);

            String user_name = req.getParameter("click_user");
            User click_user = userDao.findUserName(user_name);

            Follower follower = new Follower();
            follower.setUser_id(click_user.getUserId());
            follower.setFollower_id(subscribe_user.getUserId());

            FollowerDaoImpl followerDao = new FollowerDaoImpl();
            Follower follower1 = followerDao.find(follower);
            System.out.println(follower1);
            if(follower1 == null) {
                followerDao.insert(follower);
            }

        }

        /**
         * 完成账户界面的加载
         * */

        if(type.equals("account")){
            System.out.println("加载用户信息");
            FollowerDaoImpl followerDao = new FollowerDaoImpl();
            UserDaoImpl userDao = new UserDaoImpl();

            User user = new User();
            user.setUserName(req.getParameter("name"));
            List<User> users = userDao.selectSomeUser(user.getUserName());
            long user_id = -1;
            List<Follower> followers = null;

            if(users != null) {
                followers = followerDao.search(users.get(0).getUserId());
                user_id = users.get(0).getUserId();
                System.out.println(user_id);
            }

            List<Discussion> discussions = null;
            List<Comment> comments  = null;
            if(user_id != -1){
                DiscussionDaoImpl discussionDao = new DiscussionDaoImpl();
                CommentDaoImpl commentDao = new CommentDaoImpl();

                discussions = discussionDao.findNums(user_id);
                comments = commentDao.searchByUserId(user_id);

            }

            JSONArray jsonArray = new JSONArray();
            JSONObject jo = new JSONObject();
            User user1 = userDao.findUserName(req.getParameter("name"));
            if(user1 != null) {
                jo.put("user_privilege",user1.getUser_privilege());
            }
            else{
                jo.put("user_privilege",0);
            }

            if(user_id != -1) {
                if(followers != null) {
                    jo.put("follower_nums", followers.size());
                }
                else{
                    jo.put("follower_nums", 0);
                }

                if(discussions != null) {
                    jo.put("discussion_nums", discussions.size());
                }
                else{
                    jo.put("discussion_nums", 0);
                }

                if(comments != null) {
                    jo.put("comment_nums", comments.size());
                }
                else{
                    jo.put("comment_nums", 0);
                }
                jsonArray.add(jo);
                if(followers != null) {
                    for (Follower follower : followers) {
                        JSONObject jsonObject = new JSONObject();
                        jsonObject.put("user_id", follower.getUser_id());
                        jsonObject.put("follower_id", follower.getFollower_id());
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
    }
}
