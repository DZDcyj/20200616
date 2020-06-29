package Community;

public class Community {

    private String discussion_topic;
    private long discussion_adminId;
    private long discussion_id;
    private String discussion_name;
    private String discussion_description;


    public String getDiscussion_description() {
        return discussion_description;
    }

    public void setDiscussion_brief(String discussion_description) {
        this.discussion_description = discussion_description;
    }

    public String getTopic() {
        return discussion_topic;
    }

    public long getAdminName() {
        return discussion_adminId;
    }

    public long getDiscussion_id() {
        return discussion_id;
    }

    public String getDiscussion_name() {
        return discussion_name;
    }

    public void setTopic(String topic) {
        this.discussion_topic = topic;
    }

    public void setAdminName(long adminId) {
        this.discussion_adminId = adminId;
    }

    public void setDiscussion_id(long discussion_id) {
        this.discussion_id = discussion_id;
    }

    public void setDiscussion_name(String discussion_name) {
        this.discussion_name = discussion_name;
    }
}
