package Community;

public class Comment {

    private long discussion_id;
    private long comment_id;
    private String comment_content;
    private long comment_responder_id;


    public long getDiscussion_id() {
        return discussion_id;
    }

    public void setDiscussion_id(long discussion_id) {
        this.discussion_id = discussion_id;
    }

    public long getComment_responder_id() {
        return comment_responder_id;
    }

    public void setComment_responder_id(long comment_responder_id) {
        this.comment_responder_id = comment_responder_id;
    }

    public long getComment_id() {
        return comment_id;
    }

    public void setComment_id(long comment_id) {
        this.comment_id = comment_id;
    }

    public String getComment_content() {
        return comment_content;
    }

    public void setComment_content(String comment_content) {
        this.comment_content = comment_content;
    }

}
