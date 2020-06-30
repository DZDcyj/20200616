package Course;


/**
 * @Class Name Course的实体类
 * */
public class Course {
    private long course_id;
    private String course_name;

    private String course_image_url;
    private String course_video_url;
    private long course_views = 0;
    private String course_description;

    public String getCourse_description() {
        return course_description;
    }

    public void setCourse_description(String course_description) {
        this.course_description = course_description;
    }


    public void setCourse_views(long course_views) {
        this.course_views = course_views;
    }

    public long getCourse_views() {
        return course_views;
    }



    public String getImage_url() {
        return course_image_url;
    }

    public String getVideo_url() {
        return course_video_url;
    }

    public void setImage_url(String image_url) {
        this.course_image_url = image_url;
    }

    public void setVideo_url(String video_url) {
        this.course_video_url = video_url;
    }


    public void setCourse_id(long course_id) {
        this.course_id = course_id;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public long getCourse_id() {
        return course_id;
    }

    public String getCourse_name() {
        return course_name;
    }
}
