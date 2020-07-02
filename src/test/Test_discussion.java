package test;

import Community.Comment;
import Community.Discussion;
import Utils.CommentDaoImpl;
import Utils.DiscussionDaoImpl;

public class Test_discussion {
    public static void main(String args[]){
        Discussion discussion = new Discussion();
        Comment comment = new Comment();
        DiscussionDaoImpl discussionDao = new DiscussionDaoImpl();
        CommentDaoImpl commentDao = new CommentDaoImpl();

        //discussion.setDiscussion_id(19);
        //discussionDao.delete(discussion);
        discussion.setDiscussion_id(1);
        discussion.setAdminId(1);
        discussion.setDiscussion_name("这道题怎么做");
        discussion.setDescription("在做等离子物理对撞实验的时候，如果把第三能量的极坐标，向负方向调整三个阿尔法单位，那么对最终结果将会产生多少影响？\",\n");
        discussion.setDiscussion_title_img_url("https://shixunimageandvideo.oss-cn-beijing.aliyuncs.com/images/%E5%A4%B4%E5%83%8F.png");

        discussionDao.insert(discussion);

        discussion.setDiscussion_id(2);
        discussion.setAdminId(2);
        discussion.setDiscussion_name("如何看待互联网大厂程序员因厌恶编程，辞去月薪2w+的工作去当司机？");
        discussion.setDescription("如题");
        discussion.setDiscussion_title_img_url("https://shixunimageandvideo.oss-cn-beijing.aliyuncs.com/images/%E5%A4%B4%E5%83%8F.png");

        discussionDao.insert(discussion);

        discussion.setDiscussion_id(3);
        discussion.setAdminId(3);
        discussion.setDiscussion_name("如何看待推特网友要求耶鲁大学改名，原因是其以奴隶主命名？");
        discussion.setDescription("Yale（取消耶鲁）在美国登上热搜，因一条推特指出耶鲁以奴隶主伊利胡·耶鲁命名。网友还把矛头指向耶鲁校友希拉里，称她的事业建立在奴隶制基础上。发起者还要求数所大学改名，包括布朗和乔治城大学。？");
        discussion.setDiscussion_title_img_url("https://shixunimageandvideo.oss-cn-beijing.aliyuncs.com/images/%E5%A4%B4%E5%83%8F.png");

        discussionDao.insert(discussion);

        discussion.setDiscussion_id(4);
        discussion.setAdminId(4);
        discussion.setDiscussion_name("这如何看待赫鲁晓夫之子在美国去世，死于头部枪伤？");
        discussion.setDescription("苏联领导人赫鲁晓夫之子谢尔盖·赫鲁晓夫在美国罗得岛州家中因枪伤死亡，享年84岁。美联社24日援引罗得岛州验尸官消息报道，谢尔盖18日死于头部枪伤。罗得岛警方18日清晨接到谢尔盖妻子报警电话，前往他们位于当地克兰斯顿家中。警察抵达现场时谢尔盖已死。当地警官托德·帕特拉诺24日说，没有迹象显示“外界不当行为”导致谢尔盖死亡。警方目前已经结案，没有对任何人提起刑事诉讼。谢尔盖早年是苏联火箭专家，1991年移居美国罗得岛，在布朗大学教授冷战相关课程。谢尔盖和妻子瓦莲京娜在1999年7月加入美国国籍。他生前接受采访时说，1971年逝世的父亲赫鲁晓夫应该会支持自己的这一决定。瓦莲京娜告诉俄罗斯塔斯社，今年10月将在莫斯科为谢尔盖举行葬礼。（新华社）");
        discussion.setDiscussion_title_img_url("https://shixunimageandvideo.oss-cn-beijing.aliyuncs.com/images/%E5%A4%B4%E5%83%8F.png");

        discussionDao.insert(discussion);
        /*comment.setComment_id(1);
        comment.setComment_responder_id(1);
        comment.setDiscussion_id(1);
        comment.setComment_content("2伽马伊普西隆根号三");*/

       /* reply.setComment_id(1);
        reply.setReply_id(1);
        reply.setReply_user_id(1);
        reply.setReply_content("苟利国家");

        replyDao.insert(reply);*/
    }
}
