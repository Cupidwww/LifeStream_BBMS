-- MySQL dump 10.13  Distrib 5.7.31, for Linux (x86_64)
--
-- Host: localhost    Database: springbootypiqw
-- ------------------------------------------------------
-- Server version	5.7.31

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `springbootypiqw`
--

/*!40000 DROP DATABASE IF EXISTS `springbootypiqw`*/;

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `springbootypiqw` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `springbootypiqw`;

--
-- Table structure for table `caixuedengji`
--

DROP TABLE IF EXISTS `caixuedengji`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `caixuedengji` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `xianxuebianhao` varchar(200) DEFAULT NULL COMMENT '献血编号',
  `xianxuexingming` varchar(200) DEFAULT NULL COMMENT '献血姓名',
  `xingbie` varchar(200) DEFAULT NULL COMMENT '性别',
  `xuedaibianhao` varchar(200) DEFAULT NULL COMMENT '血袋编号',
  `xueyezhonglei` varchar(200) DEFAULT NULL COMMENT '血液种类',
  `xuexing` varchar(200) DEFAULT NULL COMMENT '血型',
  `xueliang` varchar(200) DEFAULT NULL COMMENT '血量',
  `shifouhege` varchar(200) DEFAULT NULL COMMENT '是否合格',
  `dengjiriqi` date DEFAULT NULL COMMENT '登记日期',
  `gonghao` varchar(200) DEFAULT NULL COMMENT '工号',
  `xingming` varchar(200) DEFAULT NULL COMMENT '姓名',
  PRIMARY KEY (`id`),
  UNIQUE KEY `xuedaibianhao` (`xuedaibianhao`)
) ENGINE=InnoDB AUTO_INCREMENT=1679021783295 DEFAULT CHARSET=utf8 COMMENT='采血登记';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `caixuedengji`
--

LOCK TABLES `caixuedengji` WRITE;
/*!40000 ALTER TABLE `caixuedengji` DISABLE KEYS */;
INSERT INTO `caixuedengji` VALUES (31,'2023-03-17 02:40:51','献血编号1','献血姓名1','性别1','1111111111','血液种类1','AB','血量1','是','2023-03-17','工号1','姓名1'),(32,'2023-03-17 02:40:51','献血编号2','献血姓名2','性别2','2222222222','血液种类2','AB','血量2','是','2023-03-17','工号2','姓名2'),(33,'2023-03-17 02:40:51','献血编号3','献血姓名3','性别3','3333333333','血液种类3','AB','血量3','是','2023-03-17','工号3','姓名3'),(34,'2023-03-17 02:40:51','献血编号4','献血姓名4','性别4','4444444444','血液种类4','AB','血量4','是','2023-03-17','工号4','姓名4'),(35,'2023-03-17 02:40:51','献血编号5','献血姓名5','性别5','5555555555','血液种类5','AB','血量5','是','2023-03-17','工号5','姓名5'),(36,'2023-03-17 02:40:51','献血编号6','献血姓名6','性别6','6666666666','血液种类6','AB','血量6','是','2023-03-17','工号6','姓名6'),(37,'2023-03-17 02:40:51','献血编号7','献血姓名7','性别7','7777777777','血液种类7','AB','血量7','是','2023-03-17','工号7','姓名7'),(38,'2023-03-17 02:40:51','献血编号8','献血姓名8','性别8','8888888888','血液种类8','AB','血量8','是','2023-03-17','工号8','姓名8'),(1679021783294,'2023-03-17 02:56:23','111','张三','男','1679021776424','xxxx','AB','xxxx','是','2023-03-17','222','李四');
/*!40000 ALTER TABLE `caixuedengji` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chat`
--

DROP TABLE IF EXISTS `chat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `chat` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `userid` bigint(20) NOT NULL COMMENT '用户id',
  `adminid` bigint(20) DEFAULT NULL COMMENT '管理员id',
  `ask` longtext COMMENT '提问',
  `reply` longtext COMMENT '回复',
  `isreply` int(11) DEFAULT NULL COMMENT '是否回复',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1679022026827 DEFAULT CHARSET=utf8 COMMENT='医院客服';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chat`
--

LOCK TABLES `chat` WRITE;
/*!40000 ALTER TABLE `chat` DISABLE KEYS */;
INSERT INTO `chat` VALUES (111,'2023-03-17 02:40:52',1,1,'提问1','回复1',1),(112,'2023-03-17 02:40:52',2,2,'提问2','回复2',2),(113,'2023-03-17 02:40:52',3,3,'提问3','回复3',3),(114,'2023-03-17 02:40:52',4,4,'提问4','回复4',4),(115,'2023-03-17 02:40:52',5,5,'提问5','回复5',5),(116,'2023-03-17 02:40:52',6,6,'提问6','回复6',6),(117,'2023-03-17 02:40:52',7,7,'提问7','回复7',7),(118,'2023-03-17 02:40:52',8,8,'提问8','回复8',8),(1679021689360,'2023-03-17 02:54:49',1679021649777,NULL,'可以联系在线客服',NULL,0),(1679022026826,'2023-03-17 03:00:26',1679021649777,1,NULL,'回复用户',NULL);
/*!40000 ALTER TABLE `chat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chengfenluru`
--

DROP TABLE IF EXISTS `chengfenluru`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `chengfenluru` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `xuedaibianhao` varchar(200) DEFAULT NULL COMMENT '血袋编号',
  `xueyezhonglei` varchar(200) DEFAULT NULL COMMENT '血液种类',
  `xueliang` varchar(200) DEFAULT NULL COMMENT '血量',
  `xuexing` varchar(200) DEFAULT NULL COMMENT '血型',
  `riqi` date DEFAULT NULL COMMENT '日期',
  `gonghao` varchar(200) DEFAULT NULL COMMENT '工号',
  `xingming` varchar(200) DEFAULT NULL COMMENT '姓名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1679021906679 DEFAULT CHARSET=utf8 COMMENT='成分录入';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chengfenluru`
--

LOCK TABLES `chengfenluru` WRITE;
/*!40000 ALTER TABLE `chengfenluru` DISABLE KEYS */;
INSERT INTO `chengfenluru` VALUES (91,'2023-03-17 02:40:52','血袋编号1','血液种类1','血量1','血型1','2023-03-17','工号1','姓名1'),(92,'2023-03-17 02:40:52','血袋编号2','血液种类2','血量2','血型2','2023-03-17','工号2','姓名2'),(93,'2023-03-17 02:40:52','血袋编号3','血液种类3','血量3','血型3','2023-03-17','工号3','姓名3'),(94,'2023-03-17 02:40:52','血袋编号4','血液种类4','血量4','血型4','2023-03-17','工号4','姓名4'),(95,'2023-03-17 02:40:52','血袋编号5','血液种类5','血量5','血型5','2023-03-17','工号5','姓名5'),(96,'2023-03-17 02:40:52','血袋编号6','血液种类6','血量6','血型6','2023-03-17','工号6','姓名6'),(97,'2023-03-17 02:40:52','血袋编号7','血液种类7','血量7','血型7','2023-03-17','工号7','姓名7'),(98,'2023-03-17 02:40:52','血袋编号8','血液种类8','血量8','血型8','2023-03-17','工号8','姓名8'),(1679021906678,'2023-03-17 02:58:26','11111','xxx','5000','ab','2023-03-17','222','李四');
/*!40000 ALTER TABLE `chengfenluru` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `config`
--

DROP TABLE IF EXISTS `config`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(100) NOT NULL COMMENT '配置参数名称',
  `value` varchar(100) DEFAULT NULL COMMENT '配置参数值',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='配置文件';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `config`
--

LOCK TABLES `config` WRITE;
/*!40000 ALTER TABLE `config` DISABLE KEYS */;
INSERT INTO `config` VALUES (1,'picture1','upload/picture1.jpg'),(2,'picture2','upload/picture2.jpg'),(3,'picture3','upload/picture3.jpg');
/*!40000 ALTER TABLE `config` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gongzuorenyuan`
--

DROP TABLE IF EXISTS `gongzuorenyuan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `gongzuorenyuan` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gonghao` varchar(200) NOT NULL COMMENT '工号',
  `mima` varchar(200) NOT NULL COMMENT '密码',
  `xingming` varchar(200) NOT NULL COMMENT '姓名',
  `xingbie` varchar(200) DEFAULT NULL COMMENT '性别',
  `nianling` int(11) DEFAULT NULL COMMENT '年龄',
  `shouji` varchar(200) DEFAULT NULL COMMENT '手机',
  `youxiang` varchar(200) DEFAULT NULL COMMENT '邮箱',
  PRIMARY KEY (`id`),
  UNIQUE KEY `gonghao` (`gonghao`)
) ENGINE=InnoDB AUTO_INCREMENT=1679021723067 DEFAULT CHARSET=utf8 COMMENT='工作人员';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gongzuorenyuan`
--

LOCK TABLES `gongzuorenyuan` WRITE;
/*!40000 ALTER TABLE `gongzuorenyuan` DISABLE KEYS */;
INSERT INTO `gongzuorenyuan` VALUES (11,'2023-03-17 02:40:51','工号1','123456','姓名1','男',1,'13823888881','773890001@qq.com'),(12,'2023-03-17 02:40:51','工号2','123456','姓名2','男',2,'13823888882','773890002@qq.com'),(13,'2023-03-17 02:40:51','工号3','123456','姓名3','男',3,'13823888883','773890003@qq.com'),(14,'2023-03-17 02:40:51','工号4','123456','姓名4','男',4,'13823888884','773890004@qq.com'),(15,'2023-03-17 02:40:51','工号5','123456','姓名5','男',5,'13823888885','773890005@qq.com'),(16,'2023-03-17 02:40:51','工号6','123456','姓名6','男',6,'13823888886','773890006@qq.com'),(17,'2023-03-17 02:40:51','工号7','123456','姓名7','男',7,'13823888887','773890007@qq.com'),(18,'2023-03-17 02:40:51','工号8','123456','姓名8','男',8,'13823888888','773890008@qq.com'),(1679021723066,'2023-03-17 02:55:23','222','222','李四','男',30,'18154541454','hugjhjgjjh@qq.com');
/*!40000 ALTER TABLE `gongzuorenyuan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `messages`
--

DROP TABLE IF EXISTS `messages`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `messages` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `userid` bigint(20) NOT NULL COMMENT '留言人id',
  `username` varchar(200) DEFAULT NULL COMMENT '用户名',
  `avatarurl` longtext COMMENT '头像',
  `content` longtext NOT NULL COMMENT '留言内容',
  `cpicture` longtext COMMENT '留言图片',
  `reply` longtext COMMENT '回复内容',
  `rpicture` longtext COMMENT '回复图片',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1679021671507 DEFAULT CHARSET=utf8 COMMENT='留言板';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `messages`
--

LOCK TABLES `messages` WRITE;
/*!40000 ALTER TABLE `messages` DISABLE KEYS */;
INSERT INTO `messages` VALUES (131,'2023-03-17 02:40:52',1,'用户名1','upload/messages_avatarurl1.jpg','留言内容1','upload/messages_cpicture1.jpg','回复内容1','upload/messages_rpicture1.jpg'),(132,'2023-03-17 02:40:52',2,'用户名2','upload/messages_avatarurl2.jpg','留言内容2','upload/messages_cpicture2.jpg','回复内容2','upload/messages_rpicture2.jpg'),(133,'2023-03-17 02:40:52',3,'用户名3','upload/messages_avatarurl3.jpg','留言内容3','upload/messages_cpicture3.jpg','回复内容3','upload/messages_rpicture3.jpg'),(134,'2023-03-17 02:40:52',4,'用户名4','upload/messages_avatarurl4.jpg','留言内容4','upload/messages_cpicture4.jpg','回复内容4','upload/messages_rpicture4.jpg'),(135,'2023-03-17 02:40:52',5,'用户名5','upload/messages_avatarurl5.jpg','留言内容5','upload/messages_cpicture5.jpg','回复内容5','upload/messages_rpicture5.jpg'),(136,'2023-03-17 02:40:52',6,'用户名6','upload/messages_avatarurl6.jpg','留言内容6','upload/messages_cpicture6.jpg','回复内容6','upload/messages_rpicture6.jpg'),(137,'2023-03-17 02:40:52',7,'用户名7','upload/messages_avatarurl7.jpg','留言内容7','upload/messages_cpicture7.jpg','回复内容7','upload/messages_rpicture7.jpg'),(138,'2023-03-17 02:40:52',8,'用户名8','upload/messages_avatarurl8.jpg','留言内容8','upload/messages_cpicture8.jpg','回复内容8','upload/messages_rpicture8.jpg'),(1679021671506,'2023-03-17 02:54:31',1679021649777,'111','upload/1679021648279.jpg','可以添加留言','upload/1679021669867.jpg','回复留言',NULL);
/*!40000 ALTER TABLE `messages` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `news`
--

DROP TABLE IF EXISTS `news`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `news` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `title` varchar(200) NOT NULL COMMENT '标题',
  `introduction` longtext COMMENT '简介',
  `picture` longtext NOT NULL COMMENT '图片',
  `content` longtext NOT NULL COMMENT '内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1679022012299 DEFAULT CHARSET=utf8 COMMENT='医疗资讯';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `news`
--

LOCK TABLES `news` WRITE;
/*!40000 ALTER TABLE `news` DISABLE KEYS */;
INSERT INTO `news` VALUES (121,'2023-03-17 02:40:52','有梦想，就要努力去实现','不管你想要怎样的生活，你都要去努力争取，不多尝试一些事情怎么知道自己适合什么、不适合什么呢?你说你喜欢读书，让我给你列书单，你还问我哪里有那么多时间看书;你说自己梦想的职业是广告文案，问我如何成为一个文案，应该具备哪些素质;你说你计划晨跑，但总是因为学习、工作辛苦或者身体不舒服第二天起不了床;你说你一直梦想一个人去长途旅行，但是没钱，父母觉得危险。','upload/news_picture1.jpg','<p>不管你想要怎样的生活，你都要去努力争取，不多尝试一些事情怎么知道自己适合什么、不适合什么呢?</p><p>你说你喜欢读书，让我给你列书单，你还问我哪里有那么多时间看书;你说自己梦想的职业是广告文案，问我如何成为一个文案，应该具备哪些素质;你说你计划晨跑，但总是因为学习、工作辛苦或者身体不舒服第二天起不了床;你说你一直梦想一个人去长途旅行，但是没钱，父母觉得危险。其实，我已经厌倦了你这样说说而已的把戏，我觉得就算我告诉你如何去做，你也不会照做，因为你根本什么都不做。</p><p>真正有行动力的人不需要别人告诉他如何做，因为他已经在做了。就算碰到问题，他也会自己想办法，自己动手去解决或者主动寻求可以帮助他的人，而不是等着别人为自己解决问题。</p><p>首先要学习独立思考。花一点时间想一下自己喜欢什么，梦想是什么，不要别人说想环游世界，你就说你的梦想是环游世界。</p><p>很多人说现实束缚了自己，其实在这个世界上，我们一直都可以有很多选择，生活的决定权也—直都在自己手上，只是我们缺乏行动力而已。</p><p>如果你觉得安于现状是你想要的，那选择安于现状就会让你幸福和满足;如果你不甘平庸，选择一条改变、进取和奋斗的道路，在这个追求的过程中，你也一样会感到快乐。所谓的成功，即是按照自己想要的生活方式生活。最糟糕的状态，莫过于当你想要选择一条不甘平庸、改变、进取和奋斗的道路时，却以一种安于现状的方式生活，最后抱怨自己没有得到想要的人生。</p><p>因为喜欢，你不是在苦苦坚持，也因为喜欢，你愿意投入时间、精力，长久以往，获得成功就是自然而然的事情。</p>'),(122,'2023-03-17 02:40:52','又是一年毕业季','又是一年毕业季，感慨万千，还记的自己刚进学校那时候的情景，我拖着沉重的行李箱站在偌大的教学楼前面，感叹自己未来的日子即将在这个陌生的校园里度过，而如今斗转星移，浮光掠影，弹指之间，那些青葱岁月如同白驹过隙般悄然从指缝溜走。过去的种种在胸口交集纠结，像打翻的五味瓶，甜蜜，酸楚，苦涩，一并涌上心头。','upload/news_picture2.jpg','<p>又是一年毕业季，感慨万千，还记的自己刚进学校那时候的情景，我拖着沉重的行李箱站在偌大的教学楼前面，感叹自己未来的日子即将在这个陌生的校园里度过，而如今斗转星移，浮光掠影，弹指之间，那些青葱岁月如同白驹过隙般悄然从指缝溜走。</p><p>过去的种种在胸口交集纠结，像打翻的五味瓶，甜蜜，酸楚，苦涩，一并涌上心头。一直都是晚会的忠实参与者，无论是台前还是幕后，忽然间，角色转变，那种感觉确实难以用语言表达。</p><p>	过去的三年，总是默默地期盼着这个好雨时节，因为这时候，会有灿烂的阳光，会有满目的百花争艳，会有香甜的冰激凌，这是个毕业的季节，当时不经世事的我们会殷切地期待学校那一大堆的活动，期待穿上绚丽的演出服或者礼仪服，站在大礼堂镁光灯下尽情挥洒我们的澎拜的激情。</p><p>百感交集，隔岸观火与身临其境的感觉竟是如此不同。从来没想过一场晚会送走的是我们自己的时候会是怎样的感情，毕业就真的意味着结束吗?倔强的我们不愿意承认，谢谢学弟学妹们慷慨的将这次的主题定为“我们在这里”。我知道，这可能是他们对我们这些过来人的尊敬和施舍。</p><p>没有为这场晚会排练、奔波，没有为班级、学生会、文学院出点力，还真有点不习惯，百般无奈中，用“工作忙”个万能的借口来搪塞自己，欺骗别人。其实自己心里明白，那只是在逃避，只是不愿面对繁华落幕后的萧条和落寞。大四了，大家各奔东西，想凑齐班上的人真的是难上加难，敏燕从越南回来，刚落地就匆匆回了学校，那么恋家的人也启程回来了，睿睿学姐也是从家赶来跟我们团圆。大家—如既往的寒暄、打趣、调侃对方，似乎一切又回到了当初的单纯美好。</p><p>看着舞台上活泼可爱的学弟学妹们，如同一群机灵的小精灵，清澈的眼神，稚嫩的肢体，轻快地步伐，用他们那热情洋溢的舞姿渲染着在场的每一个人，我知道，我不应该羡慕嫉妒他们，不应该顾自怜惜逝去的青春，不应该感叹夕阳无限好，曾经，我们也拥有过，曾经，我们也年轻过，曾经，我们也灿烂过。我深深地告诉自己，人生的每个阶段都是美的，年轻有年轻的活力，成熟也有成熟的魅力。多—份稳重、淡然、优雅，也是漫漫时光掠影遗留下的.珍贵赏赐。</p>'),(123,'2023-03-17 02:40:52','挫折路上，坚持常在心间','回头看看，你会不会发现，曾经的你在这里摔倒过;回头看看，你是否发现，一次次地重复着，却从没爬起过。而如今，让我们把视线转向前方，那一道道金色的弧线，是流星飞逝的痕迹，或是成功运行的轨道。今天的你，是否要扬帆起航，让幸福来敲门?清晨的太阳撒向大地，神奇的宇宙赋予它神奇的色彩，大自然沐浴着春光，世界因太阳的照射而精彩，林中百鸟啾啾，河水轻轻流淌，汇成清宁的山间小调。','upload/news_picture3.jpg','<p>回头看看，你会不会发现，曾经的你在这里摔倒过;回头看看，你是否发现，一次次地重复着，却从没爬起过。而如今，让我们把视线转向前方，那一道道金色的弧线，是流星飞逝的痕迹，或是成功运行的轨道。今天的你，是否要扬帆起航，让幸福来敲门?</p><p>清晨的太阳撒向大地，神奇的宇宙赋予它神奇的色彩，大自然沐浴着春光，世界因太阳的照射而精彩，林中百鸟啾啾，河水轻轻流淌，汇成清宁的山间小调。</p><p>是的，面对道途上那无情的嘲讽，面对步伐中那重复的摔跤，面对激流与硬石之间猛烈的碰撞，我们必须选择那富于阴雨，却最终见到彩虹的荆棘路。也许，经历了那暴风雨的洗礼，我们便会变得自信，幸福也随之而来。</p><p>司马迁屡遭羞辱，却依然在狱中撰写《史记》，作为一名史学家，不因王权而极度赞赏，也不因卑微而极度批判，然而他在坚持自己操守的同时，却依然要受统治阶级的阻碍，他似乎无权选择自己的本职。但是，他不顾于此，只是在面对道途的阻隔之时，他依然选择了走下去的信念。终于一部开山巨作《史记》诞生，为后人留下一份馈赠，也许在他完成毕生的杰作之时，他微微地笑了，没有什么比梦想实现更快乐的了......</p><p>	或许正如“长风破浪会有时，直挂云帆济沧海”一般，欣欣然地走向看似深渊的崎岖路，而在一番耕耘之后，便会发现这里另有一番天地。也许这就是困难与快乐的交融。</p><p>也许在形形色色的社会中，我们常能看到一份坚持，一份自信，但这里却还有一类人。这类人在暴风雨来临之际，只会闪躲，从未懂得这也是一种历炼，这何尝不是一份快乐。在阴暗的角落里，总是独自在哭，带着伤愁，看不到一点希望。</p><p>我们不能堕落于此，而要像海燕那般，在苍茫的大海上，高傲地飞翔，任何事物都无法阻挡，任何事都是幸福快乐的。</p>'),(124,'2023-03-17 02:40:52','挫折是另一个生命的开端','当遇到挫折或失败，你是看见失败还是看见机会?挫折是我们每个人成长的必经之路，它不是你想有就有，想没有就没有的。有句名言说的好，如果你想一生摆脱苦难，你就得是神或者是死尸。这句话形象地说明了挫折是伴随着人生的，是谁都逃不掉的。','upload/news_picture4.jpg','<p>当遇到挫折或失败，你是看见失败还是看见机会?</p><p>挫折是我们每个人成长的必经之路，它不是你想有就有，想没有就没有的。有句名言说的好，如果你想一生摆脱苦难，你就得是神或者是死尸。这句话形象地说明了挫折是伴随着人生的，是谁都逃不掉的。</p><p>人生在世，从古到今，不分天子平民，机遇虽有不同，但总不免有身陷困境或遭遇难题之处，这时候唯有通权达变，才能使人转危为安，甚至反败为胜。</p><p>大部分的人，一生当中，最痛苦的经验是失去所爱的人，其次是丢掉一份工作。其实，经得起考验的人，就算是被开除也不会惊慌，要学会面对。</p><p>	“塞翁失马，焉知非福。”人生的道路，并不是每一步都迈向成功，这就是追求的意义。我们还要认识到一点，挫折作为一种情绪状态和一种个人体验，各人的耐受性是大不相同的，有的人经历了一次次挫折，就能够坚忍不拔，百折不挠;有的人稍遇挫折便意志消沉，一蹶不振。所以，挫折感是一种主观感受，因为人的目的和需要不同，成功标准不同，所以同一种活动对于不同的人可能会造成不同的挫折感受。</p><p>凡事皆以平常心来看待，对于生命顺逆不要太执著。能够“破我执”是很高层的人生境界。</p><p>人事的艰难就是一种考验。就像—支剑要有磨刀来磨，剑才会利:一块璞玉要有粗石来磨，才会发出耀眼的光芒。我们能够做到的，只是如何减少、避免那些由于自身的原因所造成的挫折，而在遇到痛苦和挫折之后，则力求化解痛苦，争取幸福。我们要知道，痛苦和挫折是双重性的，它既是我们人生中难以完全避免的，也是我们在争取成功时，不可缺少的一种动力。因为我认为，推动我们奋斗的力量，不仅仅是对成功的渴望，还有为摆脱痛苦和挫折而进行的奋斗。</p>'),(125,'2023-03-17 02:40:52','你要去相信，没有到不了的明天','有梦想就去努力，因为在这一辈子里面，现在不去勇敢的努力，也许就再也没有机会了。你要去相信，一定要相信，没有到不了的明天。不要被命运打败，让自己变得更强大。不管你现在是一个人走在异乡的街道上始终没有找到一丝归属感，还是你在跟朋友们一起吃饭开心址笑着的时候闪过一丝落寞。','upload/news_picture5.jpg','<p>有梦想就去努力，因为在这一辈子里面，现在不去勇敢的努力，也许就再也没有机会了。你要去相信，一定要相信，没有到不了的明天。不要被命运打败，让自己变得更强大。</p><p>不管你现在是一个人走在异乡的街道上始终没有找到一丝归属感，还是你在跟朋友们一起吃饭开心址笑着的时候闪过一丝落寞。</p><p>	不管你现在是在图书馆里背着怎么也看不进去的英语单词，还是你现在迷茫地看不清未来的方向不知道要往哪走。</p><p>不管你现在是在努力着去实现梦想却没能拉近与梦想的距离，还是你已经慢慢地找不到自己的梦想了。</p><p>你都要去相信，没有到不了的明天。</p><p>	有的时候你的梦想太大，别人说你的梦想根本不可能实现;有的时候你的梦想又太小，又有人说你胸无大志;有的时候你对死党说着将来要去环游世界的梦想，却换来他的不屑一顾，于是你再也不提自己的梦想;有的时候你突然说起将来要开个小店的愿望，却发现你讲述的那个人，并没有听到你在说什么。</p><p>不过又能怎么样呢，未来始终是自己的，梦想始终是自己的，没有人会来帮你实现它。</p><p>也许很多时候我们只是需要朋友的一句鼓励，一句安慰，却也得不到。但是相信我，世界上还有很多人，只是想要和你说说话。</p><p>因为我们都一样。一样的被人说成固执，一样的在追逐他们眼里根本不在意的东西。</p><p>所以，又有什么关系呢，别人始终不是你、不能懂你的心情，你又何必多去解释呢。这个世界会来阻止你，困难也会接踵而至，其实真正关键的只有自己，有没有那个倔强。</p><p>这个世界上没有不带伤的人，真正能治愈自己的，只有自己。</p>'),(126,'2023-03-17 02:40:52','离开是一种痛苦，是一种勇气，但同样也是一个考验，是一个新的开端','无穷无尽是离愁，天涯海角遍寻思。当离别在即之时，当面对着相濡以沫兄弟般的朋友时，当面对着经历了四年的磨合而形成的真挚友谊之时，我内心激动无语，说一声再见，道一声珍重都很难出口。回想自己四年大学的风风雨雨，回想我们曾经共同经历的岁月流年，我感谢大家的相扶相依，感谢朋友们的莫大支持与帮助。虽然舍不得，但离别的脚步却不因我们的挚情而停滞。','upload/news_picture6.jpg','<p>无穷无尽是离愁，天涯海角遍寻思。当离别在即之时，当面对着相濡以沫兄弟般的朋友时，当面对着经历了四年的磨合而形成的真挚友谊之时，我内心激动无语，说一声再见，道一声珍重都很难出口。回想自己四年大学的风风雨雨，回想我们曾经共同经历的岁月流年，我感谢大家的相扶相依，感谢朋友们的莫大支持与帮助。虽然舍不得，但离别的脚步却不因我们的挚情而停滞。离别的确是一种痛苦，但同样也是我们走入社会，走向新环境、新领域的一个开端，希望大家在以后新的工作岗位上能够确定自己的新起点，坚持不懈，向着更新、更高的目标前进，因为人生最美好的东西永远都在最前方!</p><p>忆往昔峥嵘岁月，看今朝潮起潮落，望未来任重而道远。作为新时代的我们，就应在失败时，能拼搏奋起，去谱写人生的辉煌。在成功时，亦能居安思危，不沉湎于一时的荣耀、鲜花和掌声中，时时刻刻怀着一颗积极寻找自己新的奶酪的心，处变不惊、成败不渝，始终踏着自己坚实的步伐，从零开始，不断向前迈进，这样才能在这风起云涌、变幻莫测的社会大潮中成为真正的弄潮儿!</p>'),(127,'2023-03-17 02:40:52','Leave未必是一种痛苦','无穷无尽是离愁，天涯海角遍寻思。当离别在即之时，当面对着相濡以沫兄弟般的朋友时，当面对着经历了四年的磨合而形成的真挚友谊之时，我内心激动无语，说一声再见，道一声珍重都很难出口。回想自己四年大学的风风雨雨，回想我们曾经共同经历的岁月流年，我感谢大家的相扶相依，感谢朋友们的莫大支持与帮助。虽然舍不得，但离别的脚步却不因我们的挚情而停滞。','upload/news_picture7.jpg','<p>无穷无尽是离愁，天涯海角遍寻思。当离别在即之时，当面对着相濡以沫兄弟般的朋友时，当面对着经历了四年的磨合而形成的真挚友谊之时，我内心激动无语，说一声再见，道一声珍重都很难出口。回想自己四年大学的风风雨雨，回想我们曾经共同经历的岁月流年，我感谢大家的相扶相依，感谢朋友们的莫大支持与帮助。虽然舍不得，但离别的脚步却不因我们的挚情而停滞。离别的确是一种痛苦，但同样也是我们走入社会，走向新环境、新领域的一个开端，希望大家在以后新的工作岗位上能够确定自己的新起点，坚持不懈，向着更新、更高的目标前进，因为人生最美好的东西永远都在最前方!</p><p>忆往昔峥嵘岁月，看今朝潮起潮落，望未来任重而道远。作为新时代的我们，就应在失败时，能拼搏奋起，去谱写人生的辉煌。在成功时，亦能居安思危，不沉湎于一时的荣耀、鲜花和掌声中，时时刻刻怀着一颗积极寻找自己新的奶酪的心，处变不惊、成败不渝，始终踏着自己坚实的步伐，从零开始，不断向前迈进，这样才能在这风起云涌、变幻莫测的社会大潮中成为真正的弄潮儿!</p>'),(128,'2023-03-17 02:40:52','坚持才会成功','回头看看，你会不会发现，曾经的你在这里摔倒过;回头看看，你是否发现，一次次地重复着，却从没爬起过。而如今，让我们把视线转向前方，那一道道金色的弧线，是流星飞逝的痕迹，或是成功运行的轨道。今天的你，是否要扬帆起航，让幸福来敲门?清晨的太阳撒向大地，神奇的宇宙赋予它神奇的色彩，大自然沐浴着春光，世界因太阳的照射而精彩，林中百鸟啾啾，河水轻轻流淌，汇成清宁的山间小调。','upload/news_picture8.jpg','<p>回头看看，你会不会发现，曾经的你在这里摔倒过;回头看看，你是否发现，一次次地重复着，却从没爬起过。而如今，让我们把视线转向前方，那一道道金色的弧线，是流星飞逝的痕迹，或是成功运行的轨道。今天的你，是否要扬帆起航，让幸福来敲门?</p><p>清晨的太阳撒向大地，神奇的宇宙赋予它神奇的色彩，大自然沐浴着春光，世界因太阳的照射而精彩，林中百鸟啾啾，河水轻轻流淌，汇成清宁的山间小调。</p><p>是的，面对道途上那无情的嘲讽，面对步伐中那重复的摔跤，面对激流与硬石之间猛烈的碰撞，我们必须选择那富于阴雨，却最终见到彩虹的荆棘路。也许，经历了那暴风雨的洗礼，我们便会变得自信，幸福也随之而来。</p><p>司马迁屡遭羞辱，却依然在狱中撰写《史记》，作为一名史学家，不因王权而极度赞赏，也不因卑微而极度批判，然而他在坚持自己操守的同时，却依然要受统治阶级的阻碍，他似乎无权选择自己的本职。但是，他不顾于此，只是在面对道途的阻隔之时，他依然选择了走下去的信念。终于一部开山巨作《史记》诞生，为后人留下一份馈赠，也许在他完成毕生的杰作之时，他微微地笑了，没有什么比梦想实现更快乐的了......</p><p>	或许正如“长风破浪会有时，直挂云帆济沧海”一般，欣欣然地走向看似深渊的崎岖路，而在一番耕耘之后，便会发现这里另有一番天地。也许这就是困难与快乐的交融。</p><p>也许在形形色色的社会中，我们常能看到一份坚持，一份自信，但这里却还有一类人。这类人在暴风雨来临之际，只会闪躲，从未懂得这也是一种历炼，这何尝不是一份快乐。在阴暗的角落里，总是独自在哭，带着伤愁，看不到一点希望。</p><p>我们不能堕落于此，而要像海燕那般，在苍茫的大海上，高傲地飞翔，任何事物都无法阻挡，任何事都是幸福快乐的。</p>'),(1679022012298,'2023-03-17 03:00:11','XXXX','XXXX','upload/1679022009994.jpg','<p>XXXXX</p>');
/*!40000 ALTER TABLE `news` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tijianxinxi`
--

DROP TABLE IF EXISTS `tijianxinxi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tijianxinxi` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `xianxuebianhao` varchar(200) DEFAULT NULL COMMENT '献血编号',
  `xianxuexingming` varchar(200) DEFAULT NULL COMMENT '献血姓名',
  `tizhong` varchar(200) DEFAULT NULL COMMENT '体重',
  `maibo` varchar(200) DEFAULT NULL COMMENT '脉搏',
  `pifubing` varchar(200) DEFAULT NULL COMMENT '皮肤病',
  `sizhiqueshi` varchar(200) DEFAULT NULL COMMENT '四肢缺失',
  `tijianshijian` date DEFAULT NULL COMMENT '体检时间',
  `tijianjieguo` varchar(200) DEFAULT NULL COMMENT '体检结果',
  `gonghao` varchar(200) DEFAULT NULL COMMENT '工号',
  `xingming` varchar(200) DEFAULT NULL COMMENT '姓名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1679021796986 DEFAULT CHARSET=utf8 COMMENT='体检信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tijianxinxi`
--

LOCK TABLES `tijianxinxi` WRITE;
/*!40000 ALTER TABLE `tijianxinxi` DISABLE KEYS */;
INSERT INTO `tijianxinxi` VALUES (51,'2023-03-17 02:40:51','献血编号1','献血姓名1','体重1','脉搏1','无','无','2023-03-17','合格','工号1','姓名1'),(52,'2023-03-17 02:40:51','献血编号2','献血姓名2','体重2','脉搏2','无','无','2023-03-17','合格','工号2','姓名2'),(53,'2023-03-17 02:40:51','献血编号3','献血姓名3','体重3','脉搏3','无','无','2023-03-17','合格','工号3','姓名3'),(54,'2023-03-17 02:40:51','献血编号4','献血姓名4','体重4','脉搏4','无','无','2023-03-17','合格','工号4','姓名4'),(55,'2023-03-17 02:40:51','献血编号5','献血姓名5','体重5','脉搏5','无','无','2023-03-17','合格','工号5','姓名5'),(56,'2023-03-17 02:40:51','献血编号6','献血姓名6','体重6','脉搏6','无','无','2023-03-17','合格','工号6','姓名6'),(57,'2023-03-17 02:40:51','献血编号7','献血姓名7','体重7','脉搏7','无','无','2023-03-17','合格','工号7','姓名7'),(58,'2023-03-17 02:40:51','献血编号8','献血姓名8','体重8','脉搏8','无','无','2023-03-17','合格','工号8','姓名8'),(1679021796985,'2023-03-17 02:56:36','111','张三','80','60','无','无','2023-03-17','合格','222','李四');
/*!40000 ALTER TABLE `tijianxinxi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `token`
--

DROP TABLE IF EXISTS `token`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `token` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userid` bigint(20) NOT NULL COMMENT '用户id',
  `username` varchar(100) NOT NULL COMMENT '用户名',
  `tablename` varchar(100) DEFAULT NULL COMMENT '表名',
  `role` varchar(100) DEFAULT NULL COMMENT '角色',
  `token` varchar(200) NOT NULL COMMENT '密码',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '新增时间',
  `expiratedtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '过期时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='token表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `token`
--

LOCK TABLES `token` WRITE;
/*!40000 ALTER TABLE `token` DISABLE KEYS */;
INSERT INTO `token` VALUES (1,1,'admin','users','管理员','97jz3nzsit44lluo9u1oq6w9a0313r4b','2023-03-17 02:48:45','2023-03-17 03:58:49'),(2,21,'献血编号1','xianxuerenyuan','献血人员','ucgay0h8fy8i2fqsl0gcoeu4m5dkme0m','2023-03-17 02:48:58','2023-03-17 03:48:58'),(3,11,'工号1','gongzuorenyuan','工作人员','o840vdutur9br2giv7pdx4dbr52alhp9','2023-03-17 02:49:20','2023-03-17 03:49:20'),(4,1679021649777,'111','xianxuerenyuan','献血人员','hkbg3ajz5yvrnr1gbkebrcq5lb9i9xg5','2023-03-17 02:54:13','2023-03-17 03:58:40'),(5,1679021723066,'222','gongzuorenyuan','工作人员','ouzwpn2jsqx9z7kew9db11j4ldgvo252','2023-03-17 02:55:26','2023-03-17 03:55:27');
/*!40000 ALTER TABLE `token` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(100) NOT NULL COMMENT '用户名',
  `password` varchar(100) NOT NULL COMMENT '密码',
  `role` varchar(100) DEFAULT '管理员' COMMENT '角色',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '新增时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='用户表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'admin','admin','管理员','2023-03-17 02:40:52');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `xianxuerenyuan`
--

DROP TABLE IF EXISTS `xianxuerenyuan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `xianxuerenyuan` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `xianxuebianhao` varchar(200) NOT NULL COMMENT '献血编号',
  `mima` varchar(200) NOT NULL COMMENT '密码',
  `xianxuexingming` varchar(200) NOT NULL COMMENT '献血姓名',
  `xingbie` varchar(200) DEFAULT NULL COMMENT '性别',
  `nianling` int(11) DEFAULT NULL COMMENT '年龄',
  `lianxidianhua` varchar(200) DEFAULT NULL COMMENT '联系电话',
  `shenfenzheng` varchar(200) DEFAULT NULL COMMENT '身份证',
  `jiatingzhuzhi` varchar(200) DEFAULT NULL COMMENT '家庭住址',
  `xuexing` varchar(200) DEFAULT NULL COMMENT '血型',
  `touxiang` longtext COMMENT '头像',
  PRIMARY KEY (`id`),
  UNIQUE KEY `xianxuebianhao` (`xianxuebianhao`)
) ENGINE=InnoDB AUTO_INCREMENT=1679021649778 DEFAULT CHARSET=utf8 COMMENT='献血人员';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `xianxuerenyuan`
--

LOCK TABLES `xianxuerenyuan` WRITE;
/*!40000 ALTER TABLE `xianxuerenyuan` DISABLE KEYS */;
INSERT INTO `xianxuerenyuan` VALUES (21,'2023-03-17 02:40:51','献血编号1','123456','献血姓名1','男',1,'13823888881','440300199101010001','家庭住址1','A','upload/xianxuerenyuan_touxiang1.jpg'),(22,'2023-03-17 02:40:51','献血编号2','123456','献血姓名2','男',2,'13823888882','440300199202020002','家庭住址2','A','upload/xianxuerenyuan_touxiang2.jpg'),(23,'2023-03-17 02:40:51','献血编号3','123456','献血姓名3','男',3,'13823888883','440300199303030003','家庭住址3','A','upload/xianxuerenyuan_touxiang3.jpg'),(24,'2023-03-17 02:40:51','献血编号4','123456','献血姓名4','男',4,'13823888884','440300199404040004','家庭住址4','A','upload/xianxuerenyuan_touxiang4.jpg'),(25,'2023-03-17 02:40:51','献血编号5','123456','献血姓名5','男',5,'13823888885','440300199505050005','家庭住址5','A','upload/xianxuerenyuan_touxiang5.jpg'),(26,'2023-03-17 02:40:51','献血编号6','123456','献血姓名6','男',6,'13823888886','440300199606060006','家庭住址6','A','upload/xianxuerenyuan_touxiang6.jpg'),(27,'2023-03-17 02:40:51','献血编号7','123456','献血姓名7','男',7,'13823888887','440300199707070007','家庭住址7','A','upload/xianxuerenyuan_touxiang7.jpg'),(28,'2023-03-17 02:40:51','献血编号8','123456','献血姓名8','男',8,'13823888888','440300199808080008','家庭住址8','A','upload/xianxuerenyuan_touxiang8.jpg'),(1679021649777,'2023-03-17 02:54:09','111','111','张三','男',25,'18156541454','441458569882545415','XXX住址','AB','upload/1679021648279.jpg');
/*!40000 ALTER TABLE `xianxuerenyuan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `xuekuxinxi`
--

DROP TABLE IF EXISTS `xuekuxinxi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `xuekuxinxi` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `xuekubianhao` varchar(200) DEFAULT NULL COMMENT '血库编号',
  `xuexing` varchar(200) DEFAULT NULL COMMENT '血型',
  `xueyezhonglei` varchar(200) DEFAULT NULL COMMENT '血液种类',
  `daishu` int(11) DEFAULT NULL COMMENT '袋数',
  `xueliang` float DEFAULT NULL COMMENT '血量',
  `beizhu` varchar(200) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  UNIQUE KEY `xuekubianhao` (`xuekubianhao`)
) ENGINE=InnoDB AUTO_INCREMENT=1679021982710 DEFAULT CHARSET=utf8 COMMENT='血库信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `xuekuxinxi`
--

LOCK TABLES `xuekuxinxi` WRITE;
/*!40000 ALTER TABLE `xuekuxinxi` DISABLE KEYS */;
INSERT INTO `xuekuxinxi` VALUES (61,'2023-03-17 02:40:51','1111111111','AB','全血',1,1,'备注1'),(62,'2023-03-17 02:40:51','2222222222','AB','全血',2,2,'备注2'),(63,'2023-03-17 02:40:51','3333333333','AB','全血',3,3,'备注3'),(64,'2023-03-17 02:40:51','4444444444','AB','全血',4,4,'备注4'),(65,'2023-03-17 02:40:51','5555555555','AB','全血',5,5,'备注5'),(66,'2023-03-17 02:40:51','6666666666','AB','全血',6,6,'备注6'),(67,'2023-03-17 02:40:51','7777777777','AB','全血',7,7,'备注7'),(68,'2023-03-17 02:40:51','8888888888','AB','全血',12,58,'备注8'),(1679021982709,'2023-03-17 02:59:42','1679021976813','A','红细胞',20,100,'XX');
/*!40000 ALTER TABLE `xuekuxinxi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `xueyechuku`
--

DROP TABLE IF EXISTS `xueyechuku`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `xueyechuku` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `xuekubianhao` varchar(200) DEFAULT NULL COMMENT '血库编号',
  `xuexing` varchar(200) DEFAULT NULL COMMENT '血型',
  `xueyezhonglei` varchar(200) DEFAULT NULL COMMENT '血液种类',
  `daishu` int(11) DEFAULT NULL COMMENT '袋数',
  `xueliang` float DEFAULT NULL COMMENT '血量',
  `chukuriqi` date DEFAULT NULL COMMENT '出库日期',
  `beizhu` varchar(200) DEFAULT NULL COMMENT '备注',
  `gonghao` varchar(200) DEFAULT NULL COMMENT '工号',
  `xingming` varchar(200) DEFAULT NULL COMMENT '姓名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1679021884234 DEFAULT CHARSET=utf8 COMMENT='血液出库';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `xueyechuku`
--

LOCK TABLES `xueyechuku` WRITE;
/*!40000 ALTER TABLE `xueyechuku` DISABLE KEYS */;
INSERT INTO `xueyechuku` VALUES (81,'2023-03-17 02:40:51','血库编号1','血型1','血液种类1',1,1,'2023-03-17','备注1','工号1','姓名1'),(82,'2023-03-17 02:40:51','血库编号2','血型2','血液种类2',2,2,'2023-03-17','备注2','工号2','姓名2'),(83,'2023-03-17 02:40:51','血库编号3','血型3','血液种类3',3,3,'2023-03-17','备注3','工号3','姓名3'),(84,'2023-03-17 02:40:52','血库编号4','血型4','血液种类4',4,4,'2023-03-17','备注4','工号4','姓名4'),(85,'2023-03-17 02:40:52','血库编号5','血型5','血液种类5',5,5,'2023-03-17','备注5','工号5','姓名5'),(86,'2023-03-17 02:40:52','血库编号6','血型6','血液种类6',6,6,'2023-03-17','备注6','工号6','姓名6'),(87,'2023-03-17 02:40:52','血库编号7','血型7','血液种类7',7,7,'2023-03-17','备注7','工号7','姓名7'),(88,'2023-03-17 02:40:52','血库编号8','血型8','血液种类8',8,8,'2023-03-17','备注8','工号8','姓名8'),(1679021884233,'2023-03-17 02:58:03','8888888888','AB','全血',1,50,'2023-03-17','备注8','222','李四');
/*!40000 ALTER TABLE `xueyechuku` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `xueyejiance`
--

DROP TABLE IF EXISTS `xueyejiance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `xueyejiance` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `xianxuebianhao` varchar(200) DEFAULT NULL COMMENT '献血编号',
  `xianxuexingming` varchar(200) DEFAULT NULL COMMENT '献血姓名',
  `xingbie` varchar(200) DEFAULT NULL COMMENT '性别',
  `shiguanbianhao` varchar(200) DEFAULT NULL COMMENT '试管编号',
  `xuexing` varchar(200) DEFAULT NULL COMMENT '血型',
  `yigan` varchar(200) DEFAULT NULL COMMENT '乙肝',
  `hiv` varchar(200) DEFAULT NULL COMMENT 'hiv',
  `meidu` varchar(200) DEFAULT NULL COMMENT '梅毒',
  `jiancejieguo` varchar(200) DEFAULT NULL COMMENT '检测结果',
  `jianceshijian` date DEFAULT NULL COMMENT '检测时间',
  `gonghao` varchar(200) DEFAULT NULL COMMENT '工号',
  `xingming` varchar(200) DEFAULT NULL COMMENT '姓名',
  PRIMARY KEY (`id`),
  UNIQUE KEY `shiguanbianhao` (`shiguanbianhao`)
) ENGINE=InnoDB AUTO_INCREMENT=1679021832345 DEFAULT CHARSET=utf8 COMMENT='血液检测';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `xueyejiance`
--

LOCK TABLES `xueyejiance` WRITE;
/*!40000 ALTER TABLE `xueyejiance` DISABLE KEYS */;
INSERT INTO `xueyejiance` VALUES (41,'2023-03-17 02:40:51','献血编号1','献血姓名1','性别1','1111111111','A','有','有','有','合格','2023-03-17','工号1','姓名1'),(42,'2023-03-17 02:40:51','献血编号2','献血姓名2','性别2','2222222222','A','有','有','有','合格','2023-03-17','工号2','姓名2'),(43,'2023-03-17 02:40:51','献血编号3','献血姓名3','性别3','3333333333','A','有','有','有','合格','2023-03-17','工号3','姓名3'),(44,'2023-03-17 02:40:51','献血编号4','献血姓名4','性别4','4444444444','A','有','有','有','合格','2023-03-17','工号4','姓名4'),(45,'2023-03-17 02:40:51','献血编号5','献血姓名5','性别5','5555555555','A','有','有','有','合格','2023-03-17','工号5','姓名5'),(46,'2023-03-17 02:40:51','献血编号6','献血姓名6','性别6','6666666666','A','有','有','有','合格','2023-03-17','工号6','姓名6'),(47,'2023-03-17 02:40:51','献血编号7','献血姓名7','性别7','7777777777','A','有','有','有','合格','2023-03-17','工号7','姓名7'),(48,'2023-03-17 02:40:51','献血编号8','献血姓名8','性别8','8888888888','A','有','有','有','合格','2023-03-17','工号8','姓名8'),(1679021832344,'2023-03-17 02:57:11','111','张三','男','1679021828554','AB','无','无','无','合格','2023-03-17','222','李四');
/*!40000 ALTER TABLE `xueyejiance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `xueyeruku`
--

DROP TABLE IF EXISTS `xueyeruku`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `xueyeruku` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `xuekubianhao` varchar(200) DEFAULT NULL COMMENT '血库编号',
  `xuexing` varchar(200) DEFAULT NULL COMMENT '血型',
  `xueyezhonglei` varchar(200) DEFAULT NULL COMMENT '血液种类',
  `daishu` int(11) DEFAULT NULL COMMENT '袋数',
  `xueliang` float DEFAULT NULL COMMENT '血量',
  `rukuriqi` date DEFAULT NULL COMMENT '入库日期',
  `beizhu` varchar(200) DEFAULT NULL COMMENT '备注',
  `gonghao` varchar(200) DEFAULT NULL COMMENT '工号',
  `xingming` varchar(200) DEFAULT NULL COMMENT '姓名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1679021863461 DEFAULT CHARSET=utf8 COMMENT='血液入库';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `xueyeruku`
--

LOCK TABLES `xueyeruku` WRITE;
/*!40000 ALTER TABLE `xueyeruku` DISABLE KEYS */;
INSERT INTO `xueyeruku` VALUES (71,'2023-03-17 02:40:51','血库编号1','血型1','血液种类1',1,1,'2023-03-17','备注1','工号1','姓名1'),(72,'2023-03-17 02:40:51','血库编号2','血型2','血液种类2',2,2,'2023-03-17','备注2','工号2','姓名2'),(73,'2023-03-17 02:40:51','血库编号3','血型3','血液种类3',3,3,'2023-03-17','备注3','工号3','姓名3'),(74,'2023-03-17 02:40:51','血库编号4','血型4','血液种类4',4,4,'2023-03-17','备注4','工号4','姓名4'),(75,'2023-03-17 02:40:51','血库编号5','血型5','血液种类5',5,5,'2023-03-17','备注5','工号5','姓名5'),(76,'2023-03-17 02:40:51','血库编号6','血型6','血液种类6',6,6,'2023-03-17','备注6','工号6','姓名6'),(77,'2023-03-17 02:40:51','血库编号7','血型7','血液种类7',7,7,'2023-03-17','备注7','工号7','姓名7'),(78,'2023-03-17 02:40:51','血库编号8','血型8','血液种类8',8,8,'2023-03-17','备注8','工号8','姓名8'),(1679021863460,'2023-03-17 02:57:42','8888888888','AB','全血',5,100,'2023-03-17','备注8','222','李四');
/*!40000 ALTER TABLE `xueyeruku` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `yingyangbutie`
--

DROP TABLE IF EXISTS `yingyangbutie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `yingyangbutie` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `xianxuebianhao` varchar(200) DEFAULT NULL COMMENT '献血编号',
  `xianxuexingming` varchar(200) DEFAULT NULL COMMENT '献血姓名',
  `xingbie` varchar(200) DEFAULT NULL COMMENT '性别',
  `nianling` int(11) DEFAULT NULL COMMENT '年龄',
  `shenfenzheng` varchar(200) DEFAULT NULL COMMENT '身份证',
  `lianxidianhua` varchar(200) DEFAULT NULL COMMENT '联系电话',
  `butiejine` float DEFAULT NULL COMMENT '补贴金额',
  `butieshijian` date DEFAULT NULL COMMENT '补贴时间',
  `beizhu` varchar(200) DEFAULT NULL COMMENT '备注',
  `gonghao` varchar(200) DEFAULT NULL COMMENT '工号',
  `xingming` varchar(200) DEFAULT NULL COMMENT '姓名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1679021802414 DEFAULT CHARSET=utf8 COMMENT='营养补贴';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `yingyangbutie`
--

LOCK TABLES `yingyangbutie` WRITE;
/*!40000 ALTER TABLE `yingyangbutie` DISABLE KEYS */;
INSERT INTO `yingyangbutie` VALUES (101,'2023-03-17 02:40:52','献血编号1','献血姓名1','性别1',1,'440300199101010001','13823888881',1,'2023-03-17','备注1','工号1','姓名1'),(102,'2023-03-17 02:40:52','献血编号2','献血姓名2','性别2',2,'440300199202020002','13823888882',2,'2023-03-17','备注2','工号2','姓名2'),(103,'2023-03-17 02:40:52','献血编号3','献血姓名3','性别3',3,'440300199303030003','13823888883',3,'2023-03-17','备注3','工号3','姓名3'),(104,'2023-03-17 02:40:52','献血编号4','献血姓名4','性别4',4,'440300199404040004','13823888884',4,'2023-03-17','备注4','工号4','姓名4'),(105,'2023-03-17 02:40:52','献血编号5','献血姓名5','性别5',5,'440300199505050005','13823888885',5,'2023-03-17','备注5','工号5','姓名5'),(106,'2023-03-17 02:40:52','献血编号6','献血姓名6','性别6',6,'440300199606060006','13823888886',6,'2023-03-17','备注6','工号6','姓名6'),(107,'2023-03-17 02:40:52','献血编号7','献血姓名7','性别7',7,'440300199707070007','13823888887',7,'2023-03-17','备注7','工号7','姓名7'),(108,'2023-03-17 02:40:52','献血编号8','献血姓名8','性别8',8,'440300199808080008','13823888888',8,'2023-03-17','备注8','工号8','姓名8'),(1679021802413,'2023-03-17 02:56:41','111','张三','男',25,'441458569882545415','18156541454',500,'2023-03-17','','222','李四');
/*!40000 ALTER TABLE `yingyangbutie` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-03-18 14:43:07
