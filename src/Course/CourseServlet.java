package Course;

import Utils.CourseDaoImpl;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
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
        String type = req.getParameter("type");


        System.out.println("用户昵称为："+userName);
        CourseDaoImpl courseDao = new CourseDaoImpl();
        List<Course> courses = courseDao.selectAll();
        JSONArray jo = new JSONArray();


        if(type.equals("myCourse")){
            jo = getAllCourse(courses);
        }

        if(type.equals("video")){
            String sentId = req.getParameter("id");
            long id = Integer.parseInt(sentId);
            jo = getSpecificCourse(courses,id);
        }

        if(type.equals("searchResult")){
            String name = req.getParameter("name");
            System.out.println("输入信息为："+name);
            List<Course> resultCourses = courseDao.selectSomeCourses(name);
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
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("course_id",course.getCourse_id());
        jsonObject.put("course_name",course.getCourse_name());
        jsonObject.put("course_image_url",course.getImage_url());
        jsonObject.put("course_video_url",course.getVideo_url());
        jsonObject.put("course_views",course.getCourse_views());
        jsonObject.put("course_description",course.getCourse_description());
        jo.add(jsonObject);
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
}
