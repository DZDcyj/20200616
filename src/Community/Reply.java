package Community;

public class Reply {
    private long comment_id;
    private long reply_id;
    private long reply_user_id;
    private String reply_content;

    public long getComment_id() {
        return comment_id;
    }

    public void setComment_id(long comment_id) {
        this.comment_id = comment_id;
    }

    public long getReply_id() {
        return reply_id;
    }

    public void setReply_id(long reply_id) {
        this.reply_id = reply_id;
    }

    public long getReply_user_id() {
        return reply_user_id;
    }

    public void setReply_user_id(long reply_user_id) {
        this.reply_user_id = reply_user_id;
    }

    public String getReply_content() {
        return reply_content;
    }

    public void setReply_content(String reply_content) {
        this.reply_content = reply_content;
    }
}
