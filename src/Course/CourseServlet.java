package Course;

import User.ClassToUser;
import User.User;
import Utils.CourseDaoImpl;
import Utils.StudentToClassDaoImpl;
import Utils.TeacherToClassDaoImpl;
import Utils.UserDaoImpl;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CourseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置响应头允许ajax跨域访问
        System.out.println("收到微信小程序的请求");
        resp.setContentType("text/html;charset=utf-8");
        req.setCharacterEncoding("utf-8");
        System.out.println("这里是课程响应");

        String userName = req.getParameter("name");
        System.out.println("用户昵称为："+userName);

        String type = req.getParameter("type");

        JSONArray jo = new JSONArray();

        /**
         * 显示我学的课程
         * */

        if(type.equals("myCourse_learn")){

            UserDaoImpl userDao = new UserDaoImpl();
            User user = userDao.findUserName(userName);
            long id0 = user.getUserId();

            CourseDaoImpl courseDao = new CourseDaoImpl();
            List<Course> courses = courseDao.selectAll();
            if(courses != null) {
                List<Course> courseList = handleCourse(1, courses, id0);
                if(courseList != null) {
                    jo = getAllCourse(courseList);
                }
            }
        }

        /**
         * 显示我教的课程
         * */

        if(type.equals("myCourse_teach")){
            UserDaoImpl userDao = new UserDaoImpl();
            User user = userDao.findUserName(userName);
            long id0 = user.getUserId();

            CourseDaoImpl courseDao = new CourseDaoImpl();
            List<Course> courses = courseDao.selectAll();
            if(courses != null) {
                List<Course> courseList = handleCourse(0, courses, id0);
                if(courseList != null) {
                    jo = getAllCourse(courseList);
                }
            }
        }

        /**
         * 显示所有课程
         * */

        if(type.equals("Course")){
            UserDaoImpl userDao = new UserDaoImpl();
            User user = userDao.findUserName(userName);
            long id0 = user.getUserId();

            CourseDaoImpl courseDao = new CourseDaoImpl();
            List<Course> courses = courseDao.selectAll();
            System.out.println("执行COurse");
            if(courses != null) {
                jo = getAllCourse(courses);
            }
        }

        /**
         * 播放视频
         * */

        if(type.equals("video")){
            UserDaoImpl userDao = new UserDaoImpl();
            User user = userDao.findUserName(userName);
            long id0 = user.getUserId();

            CourseDaoImpl courseDao = new CourseDaoImpl();
            List<Course> courses = courseDao.selectAll();
            String sentId = req.getParameter("id");
            long id = Integer.parseInt(sentId);
            jo = getSpecificCourse(courses,id);

            CourseSort courseSort = new CourseSort(courses);
            List<Course> courseList = courseSort.sortResult();
            if(courseList != null){
                for(Course course:courseList){
                    getJSONArray(jo,course);
                }
            }
        }

        /**
         * 显示搜索结果
         * */

        if(type.equals("searchResult")){
            CourseDaoImpl courseDao = new CourseDaoImpl();

            String input = req.getParameter("input");
            System.out.println("输入信息为："+input);
            String user_name  = req.getParameter("name");
            System.out.println("username is"+user_name);

            UserDaoImpl userDao = new UserDaoImpl();
            User user = userDao.findUserName(user_name);
            long id0 = user.getUserId();

            String sign_s = req.getParameter("course_num");
            int sign;

            if(sign_s == null){
                sign = -1;
            }
            else{
                System.out.println("sign is"+sign_s);
                sign = Integer.parseInt(sign_s);

            }
            List<Course> resultCourses = courseDao.selectSomeCourses(input);
            resultCourses = handleCourse(sign, resultCourses, id0);
            jo = getAllCourse(resultCourses);

        }

        System.out.println("JSON语句为："+jo);
        System.out.println("发出信息：");
        System.out.println(jo.toString());
        Writer out = resp.getWriter();
        out.write(jo.toString());
        out.flush();
    }

    /**
     * @param courses 课程集合
     * @param id      要查询的课程id
     * */
    public JSONArray getSpecificCourse(List<Course> courses,long id){
        JSONArray jo = new JSONArray();
        Course searchedCourse = null;
        for(Course course:courses){
            if(course.getCourse_id()==id){
                searchedCourse = course;
                course.setCourse_views(course.getCourse_views()+1);
                new CourseDaoImpl().update(course);
                break;
            }
        }
        getJSONArray(jo, searchedCourse);
        return jo;
    }

    /**
     * @param jo Json类型文件的数组
     * @param course 课程信息的实体类
     * 向json数组JSONARRAY中添加课程信息
     * */

    private void getJSONArray(JSONArray jo, Course course) {
        if(course != null) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("course_id", course.getCourse_id());
            jsonObject.put("course_name", course.getCourse_name());
            jsonObject.put("course_image_url", course.getImage_url());
            jsonObject.put("course_video_url", course.getVideo_url());
            jsonObject.put("course_views", course.getCourse_views());
            jsonObject.put("course_description", course.getCourse_description());
            jo.add(jsonObject);
        }
    }

    /**
     * @param courses 课程集合
     * 将课程集合中的所有课程加入到jo中
     * */
    public JSONArray getAllCourse(List<Course> courses){
        JSONArray jo = new JSONArray();
        if(courses != null) {
            for (Course course : courses) {
                getJSONArray(jo, course);
            }
        }
        return jo;
    }

    /**
     * 处理获取到的课程列表
     * @param sign 0表示我教的课程，1表示我学的课程
     * */
    public List<Course> handleCourse(int sign,List<Course> courses,long usr_id){
        /**
         * 0为我教的课
         * */
        int flag = 0;
        if(sign == 0){
            if(courses != null){
                TeacherToClassDaoImpl teacherToClassDao = new TeacherToClassDaoImpl();
                List<ClassToUser> classToUsers = teacherToClassDao.search(0,usr_id);

                Iterator<Course> courseIterator = courses.iterator();
                if(classToUsers != null) {
                    while (courseIterator.hasNext()) {
                        Course course = courseIterator.next();
                        for (int i = 0; i < classToUsers.size() && flag == 0; i++) {
                            if (course.getCourse_id() == classToUsers.get(i).getCourse_id()) {
                                flag = 1;
                            }
                        }
                        if (flag == 0) {
                            courseIterator.remove();
                        }
                        flag = 0;
                    }
                }
                else{
                    return null;
                }
            }
        }
        /**
         *1为我学的课程
         * */
        if(sign == 1){
            if(courses != null){

                StudentToClassDaoImpl studentToClassDao = new StudentToClassDaoImpl();
                System.out.println("用户id号为："+usr_id);
                List<ClassToUser> classToUsers = studentToClassDao.search(0,usr_id);
                Iterator<Course> courseIterator = courses.iterator();


                if(classToUsers != null) {
                    while (courseIterator.hasNext()) {
                        Course course = courseIterator.next();
                        for (int j = 0; j < classToUsers.size() && flag == 0; j++) {
                            if (course.getCourse_id() == classToUsers.get(j).getCourse_id()) {
                                flag = 1;
                            }
                        }
                        if (flag == 0) {
                            courseIterator.remove();
                        }
                        flag = 0;
                    }
                }
                else{
                    return null;
                }
            }
        }
        return courses;
    }
}
