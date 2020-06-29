package Community;

import User.User;
import Utils.CommentDaoImpl;
import Utils.CommentToDiscussionImpl;
import Utils.DiscussionDaoImpl;

import java.util.List;

public class DiscussionHandle {

    public void CreateDiscussion(Discussion discussion){
        DiscussionDaoImpl discussionDao = new DiscussionDaoImpl();
        discussionDao.insert(discussion);
    }

    public void DeleteDiscussion(Discussion discussion){
        DiscussionDaoImpl discussionDao = new DiscussionDaoImpl();
        discussionDao.delete(discussion);
    }

    public List<Comment> SearchComment(Discussion discussion){
        CommentDaoImpl commentDao = new CommentDaoImpl();
        return commentDao.search(discussion.getDiscussion_id());
    }

    public void modifyComment(Discussion discussion){
        DiscussionDaoImpl discussionDao = new DiscussionDaoImpl();
        discussionDao.update(discussion);
    }
}
