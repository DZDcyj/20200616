package Community;

public class Discussion {
    private long adminId;
    private long discussion_id;
    private String discussion_name;

    private String discussion_title_img_url;
    private String description;

    public long getAdminId() {
        return adminId;
    }

    public void setAdminId(long adminId) {
        this.adminId = adminId;
    }

    public long getDiscussion_id() {
        return discussion_id;
    }

    public void setDiscussion_id(long discussion_id) {
        this.discussion_id = discussion_id;
    }

    public String getDiscussion_name() {
        return discussion_name;
    }

    public void setDiscussion_name(String discussion_name) {
        this.discussion_name = discussion_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDiscussion_title_img_url() {
        return discussion_title_img_url;
    }

    public void setDiscussion_title_img_url(String discussion_title_img_url) {
        this.discussion_title_img_url = discussion_title_img_url;
    }
}
