-- MySQL dump 10.13  Distrib 8.0.18, for osx10.15 (x86_64)
--
-- Host: localhost    Database: course
-- ------------------------------------------------------
-- Server version	8.0.20

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Comment`
--

DROP TABLE IF EXISTS `Comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Comment` (
  `discussion_id` bigint DEFAULT NULL,
  `comment_id` bigint DEFAULT NULL,
  `comment_content` text,
  `comment_responder_id` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Comment`
--

LOCK TABLES `Comment` WRITE;
/*!40000 ALTER TABLE `Comment` DISABLE KEYS */;
/*!40000 ALTER TABLE `Comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comment_responder`
--

DROP TABLE IF EXISTS `comment_responder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comment_responder` (
  `comment_id` bigint DEFAULT NULL,
  `reply_id` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment_responder`
--

LOCK TABLES `comment_responder` WRITE;
/*!40000 ALTER TABLE `comment_responder` DISABLE KEYS */;
/*!40000 ALTER TABLE `comment_responder` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Course`
--

DROP TABLE IF EXISTS `Course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Course` (
  `course_id` bigint DEFAULT NULL,
  `course_name` char(255) DEFAULT NULL,
  `course_image_url` text,
  `course_video_url` text,
  `course_views` bigint DEFAULT NULL,
  `course_description` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Course`
--

LOCK TABLES `Course` WRITE;
/*!40000 ALTER TABLE `Course` DISABLE KEYS */;
INSERT INTO `Course` VALUES (1,'机器学习','https://shixunimageandvideo.oss-cn-beijing.aliyuncs.com/images/ml.png','https://shixunimageandvideo.oss-cn-beijing.aliyuncs.com/video/ml.mp4',1,'机器学习是一门多领域交叉学科，涉及概率论、统计学、逼近论、凸分析、算法复杂度理论等多门学科。'),(2,'深度学习','https://shixunimageandvideo.oss-cn-beijing.aliyuncs.com/images/dl.png','https://shixunimageandvideo.oss-cn-beijing.aliyuncs.com/video/dl.mp4',3,'深度学习(DL, Deep Learning)是机器学习(ML, Machine Learning)领域中一个新的研究方向，它被引入机器学习使其更接近于最初的目标。'),(3,'操作系统','https://shixunimageandvideo.oss-cn-beijing.aliyuncs.com/images/%E6%93%8D%E4%BD%9C%E7%B3%BB%E7%BB%9F.png','https://shixunimageandvideo.oss-cn-beijing.aliyuncs.com/video/%E6%93%8D%E4%BD%9C%E7%B3%BB%E7%BB%9F.mp4',1,'操作系统(Operating System，简称OS)是管理计算机硬件与软件资源的计算机程序。操作系统需要处理如管理与配置内存、决定系统资源供需的优先次序、控制输入设备与输出设备、操作网络与管理文件系统等基本事务。操作系统也提供一个让用户与系统交互的操作界面。');
/*!40000 ALTER TABLE `Course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course_student`
--

DROP TABLE IF EXISTS `course_student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course_student` (
  `course_id` bigint DEFAULT NULL,
  `user_id` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course_student`
--

LOCK TABLES `course_student` WRITE;
/*!40000 ALTER TABLE `course_student` DISABLE KEYS */;
INSERT INTO `course_student` VALUES (3,2),(1,2);
/*!40000 ALTER TABLE `course_student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course_teacher`
--

DROP TABLE IF EXISTS `course_teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course_teacher` (
  `course_id` bigint DEFAULT NULL,
  `user_id` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course_teacher`
--

LOCK TABLES `course_teacher` WRITE;
/*!40000 ALTER TABLE `course_teacher` DISABLE KEYS */;
INSERT INTO `course_teacher` VALUES (2,2),(1,2);
/*!40000 ALTER TABLE `course_teacher` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Discussion`
--

DROP TABLE IF EXISTS `Discussion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Discussion` (
  `discussion_id` bigint DEFAULT NULL,
  `discussion_adminId` bigint DEFAULT NULL,
  `discussion_name` char(255) DEFAULT NULL,
  `discussion_title_img_url` text,
  `discussion_description` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Discussion`
--

LOCK TABLES `Discussion` WRITE;
/*!40000 ALTER TABLE `Discussion` DISABLE KEYS */;
INSERT INTO `Discussion` VALUES (2,2,'如何看待互联网大厂程序员因厌恶编程，辞去月薪2w+的工作去当司机？','https://shixunimageandvideo.oss-cn-beijing.aliyuncs.com/images/%E5%A4%B4%E5%83%8F.png','如题'),(3,3,'如何看待推特网友要求耶鲁大学改名，原因是其以奴隶主命名？','https://shixunimageandvideo.oss-cn-beijing.aliyuncs.com/images/%E5%A4%B4%E5%83%8F.png','Yale（取消耶鲁）在美国登上热搜，因一条推特指出耶鲁以奴隶主伊利胡·耶鲁命名。网友还把矛头指向耶鲁校友希拉里，称她的事业建立在奴隶制基础上。发起者还要求数所大学改名，包括布朗和乔治城大学。？'),(4,4,'这如何看待赫鲁晓夫之子在美国去世，死于头部枪伤？','https://shixunimageandvideo.oss-cn-beijing.aliyuncs.com/images/%E5%A4%B4%E5%83%8F.png','苏联领导人赫鲁晓夫之子谢尔盖·赫鲁晓夫在美国罗得岛州家中因枪伤死亡，享年84岁。美联社24日援引罗得岛州验尸官消息报道，谢尔盖18日死于头部枪伤。罗得岛警方18日清晨接到谢尔盖妻子报警电话，前往他们位于当地克兰斯顿家中。警察抵达现场时谢尔盖已死。当地警官托德·帕特拉诺24日说，没有迹象显示“外界不当行为”导致谢尔盖死亡。警方目前已经结案，没有对任何人提起刑事诉讼。谢尔盖早年是苏联火箭专家，1991年移居美国罗得岛，在布朗大学教授冷战相关课程。谢尔盖和妻子瓦莲京娜在1999年7月加入美国国籍。他生前接受采访时说，1971年逝世的父亲赫鲁晓夫应该会支持自己的这一决定。瓦莲京娜告诉俄罗斯塔斯社，今年10月将在莫斯科为谢尔盖举行葬礼。（新华社）'),(1,1,'这道题怎么做','https://shixunimageandvideo.oss-cn-beijing.aliyuncs.com/images/%E5%A4%B4%E5%83%8F.png','在做等离子物理对撞实验的时候，如果把第三能量的极坐标，向负方向调整三个阿尔法单位，那么对最终结果将会产生多少影响？\",\n');
/*!40000 ALTER TABLE `Discussion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `discussion_comment`
--

DROP TABLE IF EXISTS `discussion_comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `discussion_comment` (
  `discussion_id` bigint DEFAULT NULL,
  `comment_id` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `discussion_comment`
--

LOCK TABLES `discussion_comment` WRITE;
/*!40000 ALTER TABLE `discussion_comment` DISABLE KEYS */;
/*!40000 ALTER TABLE `discussion_comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `discussion_type`
--

DROP TABLE IF EXISTS `discussion_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `discussion_type` (
  `discussion_id` bigint DEFAULT NULL,
  `discussion_type` char(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `discussion_type`
--

LOCK TABLES `discussion_type` WRITE;
/*!40000 ALTER TABLE `discussion_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `discussion_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `follower`
--

DROP TABLE IF EXISTS `follower`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `follower` (
  `user_id` bigint DEFAULT NULL,
  `follower_id` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `follower`
--

LOCK TABLES `follower` WRITE;
/*!40000 ALTER TABLE `follower` DISABLE KEYS */;
INSERT INTO `follower` VALUES (2,1),(2,3),(2,4),(2,3),(2,2);
/*!40000 ALTER TABLE `follower` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Reply`
--

DROP TABLE IF EXISTS `Reply`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Reply` (
  `comment_id` bigint DEFAULT NULL,
  `reply_id` bigint DEFAULT NULL,
  `reply_user_id` bigint DEFAULT NULL,
  `reply_content` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Reply`
--

LOCK TABLES `Reply` WRITE;
/*!40000 ALTER TABLE `Reply` DISABLE KEYS */;
INSERT INTO `Reply` VALUES (1,1,1,'苟利国家');
/*!40000 ALTER TABLE `Reply` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `userId` bigint DEFAULT NULL,
  `userName` char(255) DEFAULT NULL,
  `userAge` int DEFAULT NULL,
  `userSex` char(255) DEFAULT NULL,
  `userAddress` text,
  `user_isBan` tinyint(1) DEFAULT NULL,
  `user_ban_time` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'李多朋',20,'男','河北石家庄',0,0),(3,'王天梦',20,'男','湖北黄石',1,0),(4,'李佳航',20,'男','甘肃兰州',1,0),(2,'橡木盾',100,'男','北京',0,0);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-07-01 18:17:55
