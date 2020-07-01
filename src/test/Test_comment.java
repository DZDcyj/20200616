package test;

import Community.Comment;
import Utils.CommentDaoImpl;

public class Test_comment {
    public static void main(String args[]){
        Comment comment = new Comment();
        CommentDaoImpl commentDao = new CommentDaoImpl();

        comment.setDiscussion_id(4);
        comment.setComment_id(1);
        comment.setComment_content("2伽马伊普西隆根号三");
        comment.setComment_responder_id(1);

        commentDao.insert(comment);

        comment.setDiscussion_id(4);
        comment.setComment_id(2);
        comment.setComment_content("经验+3");
        comment.setComment_responder_id(2);

        commentDao.insert(comment);

        comment.setDiscussion_id(4);
        comment.setComment_id(3);
        comment.setComment_content("希腊奶");
        comment.setComment_responder_id(3);

        commentDao.insert(comment);

        comment.setDiscussion_id(4);
        comment.setComment_id(4);
        comment.setComment_content("经验加三");
        comment.setComment_responder_id(4);

        commentDao.insert(comment);
        //comment.setComment_responder_id(10);
        //commentDao.delete1(comment);
    }
}
