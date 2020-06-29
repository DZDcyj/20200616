package Community;

import Utils.ReplyDaoImpl;

import java.util.List;

public class ReplyHandle {

    public void CreateReply(Reply reply){
        ReplyDaoImpl replyDao = new ReplyDaoImpl();
        replyDao.insert(reply);
    }

    public void deleteReply(Reply reply){
        ReplyDaoImpl replyDao = new ReplyDaoImpl();
        replyDao.delete(reply);
    }

    public List<Reply> searchReply(long comment_id){
        ReplyDaoImpl replyDao = new ReplyDaoImpl();
        return replyDao.search(comment_id);
    }

    public void updateReply(Reply reply){
        ReplyDaoImpl replyDao = new ReplyDaoImpl();
        replyDao.update(reply);
    }
}
