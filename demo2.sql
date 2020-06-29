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
INSERT INTO `Comment` VALUES (1,1,'2伽马伊普西隆根号三',1),(1,2,'经验+3',2),(1,3,'希腊奶',3),(1,4,'经验加三',4),(2,1,'2伽马伊普西隆根号三',1),(2,2,'经验+3',2),(2,3,'希腊奶',3),(2,4,'经验加三',4),(3,1,'2伽马伊普西隆根号三',1),(3,2,'经验+3',2),(3,3,'希腊奶',3),(3,4,'经验加三',4),(4,1,'2伽马伊普西隆根号三',1),(4,2,'经验+3',2),(4,3,'希腊奶',3),(4,4,'经验加三',4);
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
INSERT INTO `Course` VALUES (20200627,'LegalHigh01','https://shixunimageandvideo.oss-cn-beijing.aliyuncs.com/images/LegalHigh01.png','https://shixunimageandvideo.oss-cn-beijing.aliyuncs.com/video/2012%20LegalHigh%2001.mp4',32,'LEGAL HIGH》（リーガル・ハイ），是日本富士电视台于2012年4月17日首播的电视剧。该剧是由古泽良太编剧的原创作品，由石川淳一、城宝秀则执导，堺雅人、新垣结衣等主演'),(20200626,'sekiro','https://shixunimageandvideo.oss-cn-beijing.aliyuncs.com/images/weimingyixin.png','https://shixunimageandvideo.oss-cn-beijing.aliyuncs.com/video/Segment_0001.mp4',7,'只狼：影逝二度(Sekiro：Shadows Die Twice)》是一款由From Software制作的第三人称视角的动作冒险沙盒类游戏，玩家将操控一位忍者，拯救他的主人---拥有日本贵族血统的大能的皇子，并向他的天敌复仇。该游戏已于2019年3月22日全球同步上市，并支持中文版'),(20200625,'LoveDeathAndRobot','https://shixunimageandvideo.oss-cn-beijing.aliyuncs.com/images/lovedeathandrobot.png','https://shixunimageandvideo.oss-cn-beijing.aliyuncs.com/video/%E7%88%B1-%E6%AD%BB%E4%BA%A1%E5%92%8C%E6%9C%BA%E5%99%A8%E4%BA%BA%E7%AC%AC%E4%B8%80%E5%AD%A301.mp4',15,'爱，死亡和机器人》（Love,Death&Robots）是由NetFlix出品，提姆·米勒和大卫·芬奇执行监制的成人向动画短片集，于2019年3月15日在美国首播 [1]  宣布将续订第二季，提姆·米勒和大卫·芬奇继续担任该剧第二季的执行制片人，导演吕寅荣也会加入主创团队，成为第二季的监察导演之一');
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
INSERT INTO `Discussion` VALUES (1,1,'这道题怎么做','https://shixunimageandvideo.oss-cn-beijing.aliyuncs.com/images/%E5%A4%B4%E5%83%8F.png','在做等离子物理对撞实验的时候，如果把第三能量的极坐标，向负方向调整三个阿尔法单位，那么对最终结果将会产生多少影响？\",\n'),(2,2,'如何看待互联网大厂程序员因厌恶编程，辞去月薪2w+的工作去当司机？','https://shixunimageandvideo.oss-cn-beijing.aliyuncs.com/images/%E5%A4%B4%E5%83%8F.png','如题'),(3,3,'如何看待推特网友要求耶鲁大学改名，原因是其以奴隶主命名？','https://shixunimageandvideo.oss-cn-beijing.aliyuncs.com/images/%E5%A4%B4%E5%83%8F.png','Yale（取消耶鲁）在美国登上热搜，因一条推特指出耶鲁以奴隶主伊利胡·耶鲁命名。网友还把矛头指向耶鲁校友希拉里，称她的事业建立在奴隶制基础上。发起者还要求数所大学改名，包括布朗和乔治城大学。？'),(4,4,'这如何看待赫鲁晓夫之子在美国去世，死于头部枪伤？','https://shixunimageandvideo.oss-cn-beijing.aliyuncs.com/images/%E5%A4%B4%E5%83%8F.png','苏联领导人赫鲁晓夫之子谢尔盖·赫鲁晓夫在美国罗得岛州家中因枪伤死亡，享年84岁。美联社24日援引罗得岛州验尸官消息报道，谢尔盖18日死于头部枪伤。罗得岛警方18日清晨接到谢尔盖妻子报警电话，前往他们位于当地克兰斯顿家中。警察抵达现场时谢尔盖已死。当地警官托德·帕特拉诺24日说，没有迹象显示“外界不当行为”导致谢尔盖死亡。警方目前已经结案，没有对任何人提起刑事诉讼。谢尔盖早年是苏联火箭专家，1991年移居美国罗得岛，在布朗大学教授冷战相关课程。谢尔盖和妻子瓦莲京娜在1999年7月加入美国国籍。他生前接受采访时说，1971年逝世的父亲赫鲁晓夫应该会支持自己的这一决定。瓦莲京娜告诉俄罗斯塔斯社，今年10月将在莫斯科为谢尔盖举行葬礼。（新华社）'),(5,1,'zCC','https://shixunimageandvideo.oss-cn-beijing.aliyuncs.com/images/%E5%A4%B4%E5%83%8F.png','21312'),(6,1,'goulisda','https://shixunimageandvideo.oss-cn-beijing.aliyuncs.com/images/%E5%A4%B4%E5%83%8F.png','czX'),(7,1,'czXVzcb','https://shixunimageandvideo.oss-cn-beijing.aliyuncs.com/images/%E5%A4%B4%E5%83%8F.png','2321'),(8,1,'23213','https://shixunimageandvideo.oss-cn-beijing.aliyuncs.com/images/%E5%A4%B4%E5%83%8F.png','test1'),(9,1,' xvz','https://shixunimageandvideo.oss-cn-beijing.aliyuncs.com/images/%E5%A4%B4%E5%83%8F.png','xzc'),(10,1,'dsas','https://shixunimageandvideo.oss-cn-beijing.aliyuncs.com/images/%E5%A4%B4%E5%83%8F.png','2312'),(11,1,'','https://shixunimageandvideo.oss-cn-beijing.aliyuncs.com/images/%E5%A4%B4%E5%83%8F.png','');
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
  `follower` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `follower`
--

LOCK TABLES `follower` WRITE;
/*!40000 ALTER TABLE `follower` DISABLE KEYS */;
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
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-06-30  3:13:41
