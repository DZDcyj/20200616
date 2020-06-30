package Modify;

import User.User;
import Utils.UserDaoImpl;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

public class ModifyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("收到微信小程序的请求");
        resp.setContentType("text/html;charset=utf-8");
        System.out.println("这里是修改用户响应");
        req.setCharacterEncoding("utf-8");

        String type = req.getParameter("type");
        System.out.println(type);

        if(type.equals("modfiysubmit")){
            UserDaoImpl userDao1 = new UserDaoImpl();
            User user1 = new User();

            String id_s = req.getParameter("id");
            Integer id = Integer.parseInt(id_s);
            user1.setUserId(id);

            user1.setUserName(req.getParameter("name"));
            String age_s = req.getParameter("age");
            if(age_s != "") {
                Integer age = Integer.parseInt(age_s);
                user1.setUserAge(age);
            }
            String sex = req.getParameter("sex");
            user1.setUserSex(sex);

            String addr = req.getParameter("addr");
            user1.setUserAddress(req.getParameter("addr"));

            user1.setUser_isBan(false);
            user1.setUser_ban_time(0);

            userDao1.update(user1);
        }

        if(type.equals("modify")){
            UserDaoImpl userDao = new UserDaoImpl();
            String name = req.getParameter("name");
            System.out.println("用户名称为："+name);
            JSONArray jsonArray = null;

            User user = userDao.findUserName(name);

            if(user != null){
                JSONObject jo = new JSONObject();
                jo.put("userId",user.getUserId());
                jo.put("userName",user.getUserName());
                jo.put("userAge",user.getUserAge());
                jo.put("userSex",user.getUserSex());
                jo.put("userAddress",user.getUserAddress());

                jsonArray = new JSONArray();
                jsonArray.add(jo);
            }

            if(jsonArray != null) {
                System.out.println("JSON语句为：" + jsonArray);
                System.out.println("发出信息：");
                System.out.println(jsonArray.toString());
                Writer out = resp.getWriter();
                out.write(jsonArray.toString());
                out.flush();
            }
        }
    }
}
