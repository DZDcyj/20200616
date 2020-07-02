package User;

import Utils.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class UserRegister extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("收到微信小程序的请求");
        resp.setContentType("text/html;charset=utf-8");
        System.out.println("这里是账户注册");
        req.setCharacterEncoding("utf-8");
        String type = req.getParameter("type");

        String name = req.getParameter("name");
        String age_s = req.getParameter("age");
        int age = Integer.valueOf(age_s);
        String sex = req.getParameter("sex");
        if(sex.equals("1")){
            sex = "男";
        }
        else{
             sex = "女";
        }
        String addr = req.getParameter("addr");
        boolean isBan = false;
        int banTime = 0 ;
        int privilege = 0;

        User user = new User();
        UserDaoImpl userDao = new UserDaoImpl();
        List<User> users = userDao.selectAll();
        int id =0;
        for(User user1:users){
            if(id < user1.getUserId()){
                id = user1.getUserId();
            }
        }
        user.setUserId(id+1);
        user.setUserName(name);
        user.setUserAge(age);
        user.setUserSex(sex);
        user.setUserAddress(addr);
        user.setUser_privilege(0);
        user.setUser_isBan(isBan);

        userDao.insert(user);
    }
}
