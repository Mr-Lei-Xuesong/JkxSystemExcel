/*
SQLyog Ultimate v12.5.0 (64 bit)
MySQL - 8.0.18 : Database - jkx_system
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`jkx_system` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `jkx_system`;

/*Table structure for table `student_info` */

DROP TABLE IF EXISTS `student_info`;

CREATE TABLE `student_info` (
  `Id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID主键',
  `studentName` varchar(255) DEFAULT NULL COMMENT '姓名',
  `gender` varchar(20) DEFAULT NULL COMMENT '性别',
  `college` varchar(255) DEFAULT NULL COMMENT '系部',
  `stuClass` varchar(255) DEFAULT NULL COMMENT '班级',
  `major` varchar(255) DEFAULT NULL COMMENT '专业',
  `birthday` datetime(6) DEFAULT NULL COMMENT '生日',
  `nativePlace` text COMMENT '籍贯',
  `nation` varchar(255) DEFAULT NULL COMMENT '民族',
  `familyTel` varchar(255) DEFAULT NULL COMMENT '家庭电话',
  `politicCountenance` varchar(255) DEFAULT NULL COMMENT '政治面貌',
  `inGrade` varchar(255) DEFAULT NULL COMMENT '入学年级',
  `inType` varchar(255) DEFAULT NULL COMMENT '入学方式（统招、对口、保送等等）',
  `email` varchar(255) DEFAULT NULL COMMENT '邮箱',
  `studyCategory` varchar(255) DEFAULT NULL COMMENT '学籍类别（如退学、休学、暂缓等等）',
  `studyStatus` varchar(255) DEFAULT NULL COMMENT '学籍状态（如正常、专升本、跳级等等）',
  `residentType` varchar(255) DEFAULT NULL COMMENT '户口性质（如农村、城市）',
  `bank` varchar(255) DEFAULT NULL COMMENT '开户银行',
  `bankCardID` varchar(255) DEFAULT NULL COMMENT '银行卡号',
  `isLoan` varchar(255) DEFAULT NULL COMMENT '是否贷款',
  `studentPlace` varchar(255) DEFAULT NULL COMMENT '生源地',
  `identityType` varchar(255) DEFAULT NULL COMMENT '证件类型（如 身份证、军官证等等)',
  `identityID` varchar(255) DEFAULT NULL COMMENT '身份证',
  `fatherName` varchar(255) DEFAULT NULL COMMENT '父亲姓名',
  `fatherTel` varchar(255) DEFAULT NULL COMMENT '父亲电话',
  `motherName` varchar(255) DEFAULT NULL COMMENT '母亲姓名',
  `motherTel` varchar(255) DEFAULT NULL COMMENT '母亲电话',
  `selfTel` varchar(255) DEFAULT NULL COMMENT '本人电话',
  `address` text COMMENT '家庭地址',
  `clothesSize` varchar(10) DEFAULT NULL COMMENT '衣服尺寸',
  `shoeSize` varchar(10) DEFAULT NULL COMMENT '鞋码',
  `educationType` enum('职高','普高') DEFAULT NULL COMMENT '职高还是普高',
  `dormNum` varchar(255) DEFAULT NULL COMMENT '寝室号',
  `examNum` varchar(255) DEFAULT NULL COMMENT '考号',
  `studentNum` varchar(255) DEFAULT NULL COMMENT '学号',
  `gradeFatherTel` varchar(255) DEFAULT NULL COMMENT '爷爷电话',
  `gradeMotherTel` varchar(255) DEFAULT NULL COMMENT '奶奶电话',
  `religion` varchar(255) DEFAULT NULL COMMENT '宗教信仰',
  `photo` varchar(255) DEFAULT NULL COMMENT '相片路径',
  PRIMARY KEY (`Id`) USING BTREE
) ENGINE=MyISAM AUTO_INCREMENT=1514 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

/*Data for the table `student_info` */

insert  into `student_info`(`Id`,`studentName`,`gender`,`college`,`stuClass`,`major`,`birthday`,`nativePlace`,`nation`,`familyTel`,`politicCountenance`,`inGrade`,`inType`,`email`,`studyCategory`,`studyStatus`,`residentType`,`bank`,`bankCardID`,`isLoan`,`studentPlace`,`identityType`,`identityID`,`fatherName`,`fatherTel`,`motherName`,`motherTel`,`selfTel`,`address`,`clothesSize`,`shoeSize`,`educationType`,`dormNum`,`examNum`,`studentNum`,`gradeFatherTel`,`gradeMotherTel`,`religion`,`photo`) values 
(1513,'朱海燕','女','','','','2020-09-18 00:00:00.000000','','','','','','','','','','','','','','','','511902200007116989','朱强','18782419111','吴利娟','18982189105','18782710865','四川省巴中市巴州区将军大道德顺苑8单元302号','M','36','普高','9-203-2','','','','','',''),
(1512,'康超','男','','','','2020-09-18 00:00:00.000000','','','','','','','','','','','','','','','','510821200006076834','何泽','13548466623','康赵清','18724095369','18582972078','四川省旺苍县三江镇分水村1组68号','M','39','职高','11-514-3','','','','','',''),
(1511,'何浩东','男','','','','2020-09-18 00:00:00.000000','','','','','','','','','','','','','','','','510821200109178518','何俊林','15114882973','佘臣','18783467522','13158751929','四川省旺苍县木门镇三合村4社78号','XL','42','职高','11-514-2','','','','','',''),
(1510,'郝利','女','','','','2020-09-18 00:00:00.000000','','','','','','','','','','','','','','','','510821200103191324','郝宗伦','15760626012','康春芍','18781236629','18583435609','四川省旺苍县嘉川镇群力村5组26号','S','35','职高','9#','','','','','',''),
(1509,'赵帅','男','','','','2020-09-18 00:00:00.000000','','','','','','','','','','','','','','','','510821200108136834','赵万军','19932252965','陈安翠','19952250962','18683922934','四川省旺苍县三江镇红军路180号','M','39','职高','11-514-1','','','','','',''),
(1508,'陈慧苹','女','','','','2020-09-18 00:00:00.000000','','','','','','','','','','','','','','','','510184200011045327','陈宇','13551868644','夏道芜','13628063605','17780504834','四川省崇州市羊马镇安阜社','L','37','职高','9-203-2','','','','','',''),
(1507,'唐培杰','男','','','','2020-09-18 00:00:00.000000','','','','','','','','','','','','','','','','510902200007199517','唐昌元','13980187915','任明荇','13541414176','13002848815','四川省遂宁市船山区盐市街24号8单元7楼11号','XXL','42','职高','11-515-3','','','','','',''),
(1506,'袁云培','男','','','','2020-09-18 00:00:00.000000','','','','','','','','','','','','','','','','510181200105301919','袁显刚','18030695569','杨琼','18030879969','17380474920','四川省都江堰市幸福镇奎光东二街87号','XL','43','职高','11-515-5','','','','','',''),
(1505,'王小林','男','','','','2020-09-18 00:00:00.000000','','','','','','','','','','','','','','','','513423199903024733','王学军','15984963761','杨吉柏','13881536771','17608342650','四川省盐源县平川镇青天铺村4组37号','M','39','普高','11-512-2','','','','','',''),
(1504,'沙华','男','','','','2020-09-18 00:00:00.000000','','','','','','','','','','','','','','','','513423200006029214','','15196180745','安阿牛','','','四川省盐源县大河乡李子村4组5号','L','41','普高','11-512-1','','','','','',''),
(1503,'贺泽民','男','','','','2020-09-18 00:00:00.000000','','','','','','','','','','','','','','','','51092320021216071X','贺军','13882587002','','','17503034311','四川省大英县蓬莱镇瓦草村7社16号','XL','43','职高','11#','','','','','',''),
(1502,'陈广顺','男','','','','2020-09-18 00:00:00.000000','','','','','','','','','','','','','','','','511002199901267816','陈国明','18980944720','尤秀清','13348903715','17345805176','四川省郫县红光镇幸福路北一段169号10栋2单元10楼1004号','L','42','普高','11-516-3','','','','','',''),
(1501,'鲍兴龙','男','','','','2020-09-18 00:00:00.000000','','','','','','','','','','','','','','','','513921200207208678','鲍军','15267832015','陈杰','13566045070','17608219465','四川省资阳市安岳县千佛乡洪庙村13组','M','40','普高','11-516-5','','','','','',''),
(1500,'谢磊','男','','','','2020-09-18 00:00:00.000000','','','','','','','','','','','','','','','','510122200102168112','谢华富','15928169730','周艳如','13550012354','13940882803','四川省成都市双流区黄甲镇檬子5组','L','41','普高','11-516-4','','','','','',''),
(1499,'罗俊杰','男','','','','2020-09-18 00:00:00.000000','','','','','','','','','','','','','','','','513922199911051476','罗明辉','15884209153','蒲永华','15282212391','','四川省资阳市乐至县东山镇心中赛老村12组','L','43','职高','11-516-6','','','','','',''),
(1498,'潘广福','男','','','','2020-09-18 00:00:00.000000','','','','','','','','','','','','','','','','510902200003148499','潘传海','13882520444','','','15282504931','四川省遂宁市盛世上江城','XL','41','职高','11-516-2','','','','','',''),
(1497,'周冰','男','','','','2020-09-18 00:00:00.000000','','','','','','','','','','','','','','','','510122200106299419','周万军','13551196286','彭永超','15828394676','17396255513','四川省成都市天府新区大林镇','L','41','职高','11#','','','','','',''),
(1496,'吴旭','男','','','','2020-09-18 00:00:00.000000','','','','','','','','','','','','','','','','513921200102233279','吴勤兵','13550692051','','','18581762524','四川省资阳市安岳县林凤镇石滚村9组','L','42','普高','11-505-6','','','','','',''),
(1495,'刘玉雪','女','','','','2020-09-18 00:00:00.000000','','','','','','','','','','','','','','','','513425200002080429','刘从柱','18398487339','田朝清','15760268706','15756829260','四川省会理县果元乡羊木村2组36号','S','36','普高','9-204-5','','','','','',''),
(1494,'张文洁','女','','','','2020-09-18 00:00:00.000000','','','','','','','','','','','','','','','','513124200005040665','张勤','18383514477','李庆秀','15881246258','13398404285','四川省汉源县富林镇市荣社区5组38号','S','35','普高','9-204-4','','','','','',''),
(1493,'陶君豪','男','','','','2020-09-18 00:00:00.000000','','','','','','','','','','','','','','','','513023200005184018','陶锋','13631733868','梁晓容','19130796551','13438419659','四川省开江县灵岩镇街道5号','XL','41','普高','11-517-5','','','','','',''),
(1492,'王永莉','女','','','','2020-09-18 00:00:00.000000','','','','','','','','','','','','','','','','510421200109083525','王胜','13092812766','杨关秀','15984572926','17608125646','四川省米易县白马镇龙塘村台子社50号附1号','L','36','普高','9#','','','','','',''),
(1491,'晏永康','男','','','','2020-09-18 00:00:00.000000','','','','','','','','','','','','','','','','513435200107050317','晏江忠','15202805137','杨德玉','17380833580','18881142009','四川省甘洛县田坝镇新店村4组7号','L','40','普高','11#','','','','','',''),
(1490,'李洪旭','男','','','','2020-09-18 00:00:00.000000','','','','','','','','','','','','','','','','511623200106012873','李学兵','18784227745','王友燕','13286818816','18728664858','四川省邻水县九龙镇八角村3组','L','42','普高','11-517-1','','','','','',''),
(1489,'刘云','男','','','','2020-09-18 00:00:00.000000','','','','','','','','','','','','','','','','51162120000627075X','刘正全','13118250217','周维琼','14708280267','15884944116','四川省岳池县九龙镇三合寨村3组6号','XL','42','普高','11-517-2','','','','','',''),
(1488,'罗睿','男','','','','2020-09-18 00:00:00.000000','','','','','','','','','','','','','','','','510902200107254878','罗从军','18583088709','邓春艳','','15520697583','四川省遂宁市安居区保石镇石湾村12社20号附1号','M','39','普高','11-517-4','','','','','',''),
(1487,'杨敏敏','女','','','','2020-09-18 00:00:00.000000','','','','','','','','','','','','','','','','511602200009287101','杨厚建','18181832539','陆清艳','18181832519','17380273938','四川省广安市前锋区代市镇永兴街20号9栋2单元602室','L','39','普高','9-204-3','','','','','',''),
(1486,'张永现','男','','','','2020-09-18 00:00:00.000000','','','','','','','','','','','','','','','','513426200110204018','张华平','13734936796','陈礼芝','15082295536','15244970507','四川省会东县铅锌镇小岩村3组31号','XL','42','普高','11#','','','','','',''),
(1485,'张浩伟','男','','','','2020-09-18 00:00:00.000000','','','','','','','','','','','','','','','','51032120010925531X','张松柏','13518465966','古桂英','15808236859','18882009496','四川省荣县旭阳镇荣州大道二段121号10栋6单元4楼1号','L','41','普高','11-515-2','','','','','',''),
(1484,'朱佳','女','','','','2020-09-18 00:00:00.000000','','','','','','','','','','','','','','','','510722200101105606','朱术林','17608290844','张小蓉','18683796831','18602856381','四川省三台县幸福乡春燕村七组002号','L','37','普高','9-204-2','','','','','',''),
(1483,'王博豪','男','','','','2020-09-18 00:00:00.000000','','','','','','','','','','','','','','','','510824200011141011','王露辛','15282061922','杨雪','18116786919','18111355143','四川省苍溪县陵江镇江南村七组','XL','41','职高','11#','','','','','',''),
(1482,'刘席正','男','','','','2020-09-18 00:00:00.000000','','','','','','','','','','','','','','','','510921200103030016','刘波','13808263955','席银春','13547762758','18728551219','四川省蓬溪县赤城镇白塔街20号2幢2单元7号','XXL','41','职高','11#','','','','','',''),
(1481,'张宏涛','男','','','','2020-09-18 00:00:00.000000','','','','','','','','','','','','','','','','511324200006017335','张旭光','13536566769','王海英','18575601835','17581718531','四川省仪陇县双胜镇火井村二组43号','XL','40','普高','11-518-5','','','','','',''),
(1480,'何洋龙','男','','','','2020-09-18 00:00:00.000000','','','','','','','','','','','','','','','','510722200008130137','何军','15308198418','杨洪','18180489196','18980539719','四川省绵阳市三台县北坝镇林家巷011号','XL','42','普高','11#','','','','','',''),
(1479,'舒浩','男','','','','2020-09-18 00:00:00.000000','','','','','','','','','','','','','','','','510904200110172219','舒荣华','15908401362','唐艳','18180249277','18728588821','四川省遂宁市安居区聚贤镇木桶井村7社1号','XXL','41','普高','11-518-2','','','','','',''),
(1478,'丁家淋','男','','','','2020-09-18 00:00:00.000000','','','','','','','','','','','','','','','','510322200011148758','丁国邦','15982025989','兰瑞琴','13881908919','15881347632','四川省富顺县骑龙镇石山村5组33号','XL','41','普高','11-324-5','','','','','',''),
(1477,'吴双','男','','','','2020-09-18 00:00:00.000000','','','','','','','','','','','','','','','','510902200011031856','吴大勇','13882588776','王娟','13547752699','18584190024','四川省遂宁市安居区安居镇西街36号','XL','44','职高','11-324-3','','','','','',''),
(1476,'张博','男','','','','2020-09-18 00:00:00.000000','','','','','','','','','','','','','','','','510704200006195110','邱守俊','15280928682','张艳玲','15082179351','17608158668','四川省绵阳市游仙区沉抗镇七曲村六组','L','41','职高','11-324-4','','','','','',''),
(1475,'刘琪','女','','','','2020-09-18 00:00:00.000000','','','','','','','','','','','','','','','','510902200110208522','刘建','13118208885','李芙蓉','13118208886','13118208867','四川省遂宁市船山区北固乡龙楼村11社24号','XL','37','职高','9#','','','','','',''),
(1474,'李雨波','男','','','','2020-09-18 00:00:00.000000','','','','','','','','','','','','','','','','510921200010262352','李斌','13568701036','徐萍','13982588029','19130900076','四川省遂宁市船山区开善路239号','XXL','41','普高','11-324-1','','','','','',''),
(1473,'何泊润','男','','','','2020-09-18 00:00:00.000000','','','','','','','','','','','','','','','','511921200003151639','何义','18321399956','王明月','17380976562','17790253038','四川省通江县至诚镇鸳鸯村四社','L','42','普高','11-520-6','','','','','',''),
(1472,'陈志朋','男','','','','2020-09-18 00:00:00.000000','','','','','','','','','','','','','','','','510923200002262718','陈仪强','15181918058','杨芳','13882568220','15881929962','四川省大英县隆盛镇前明村5社8号','L','41','职高','11-518-1','','','','','',''),
(1471,'张培森','男','','','','2020-09-18 00:00:00.000000','','','','','','','','','','','','','','','','511325200108033316','张伟','15307611508','冯锦','','13458274133','四川省西充县槐树镇马氏祠村2组5号','XL','40','普高','11-520-3','','','','','',''),
(1470,'李红','女','','','','2020-09-18 00:00:00.000000','','','','','','','','','','','','','','','','510921200302212509','包建华','13795757749','李培英','13419365572','13795759884','四川省蓬溪县红江镇红江村8社4号','XL','36','职高','9#','','','','','',''),
(1469,'夏嘉明','男','','','','2020-09-18 00:00:00.000000','','','','','','','','','','','','','','','','510921200107081937','夏六文','18823381918','邓义英','13713523225','18280898617','四川省蓬溪县明月镇碧山庙村3组24号','L','39','职高','11#','','','','','',''),
(1468,'巫尚阳','男','','','','2020-09-18 00:00:00.000000','','','','','','','','','','','','','','','','510921200104192113','巫泽刚','13092833052','韩瑞华','14780086325','18190164475','四川省蓬溪县板桥乡跳墩村3社27号','L','41','职高','11-520-2','','','','','',''),
(1467,'张泳池','男','','','','2020-09-18 00:00:00.000000','','','','','','','','','','','','','','','','510181200010255710','张伟','13541382930','刘霞','13688081525','18200528697','四川省都江堰市龙池镇东岳村4组','XXXL','43','普高','11#','','','','','',''),
(1466,'蒲浏云','男','','','','2020-09-18 00:00:00.000000','','','','','','','','','','','','','','','','510402200101257210','蒲有才','18982337526','柴家莲','18089597230','17321821316','四川省攀枝花市东区银江镇五道河村2组37号','XXL','44','职高','11#','','','','','',''),
(1465,'姚威龙','男','','','','2020-09-18 00:00:00.000000','','','','','','','','','','','','','','','','511622200104292510','王伯川','15215096073','陈运秀','13251469789','18083007998','四川省武胜县万善镇伏虎村9组29号','XXL','41','普高','11-526-3','','','','','',''),
(1464,'唐安','男','','','','2020-09-18 00:00:00.000000','','','','','','','','','','','','','','','','511622200005171318','唐国祥','18882677793','李红琼','13883169249','17628623207','四川省武胜县烈面镇高梯村6组20号','XL','41','普高','11-526-4','','','','','',''),
(1463,'李银华','男','','','','2020-09-18 00:00:00.000000','','','','','','','','','','','','','','','','513422199905013812','李兴文','13881485822','罗文珍','15183478355','13881522373','四川省木里藏族自治县博科乡日古村日古组49号','XL','41','普高','11-520-5','','','','','',''),
(1462,'张磊','男','','','','2020-09-18 00:00:00.000000','','','','','','','','','','','','','','','','510923200005301751','张济高','','张玉秀','17078046201','18482586337','四川省大英县隆盛镇赵坝村2社6号','M','42','普高','11-324-2','','','','','',''),
(1461,'谈世豪','男','','','','2020-09-18 00:00:00.000000','','','','','','','','','','','','','','','','511602200009082798','谈廷斌','15082677191','杨红艳','15982665538','18728627808','四川省广安市广安区协兴镇协心村9组','XXXL','42','普高','11#','','','','','',''),
(1460,'邓雪松','男','','','','2020-09-18 00:00:00.000000','','','','','','','','','','','','','','','','510504200001110615','邓强','13378258294','谭友勤','17738578958','17738577595','四川省泸州市龙马潭区石洞镇河咀村二十社7号','L','43','普高','11-529-6','','','','','',''),
(1459,'石永涛','男','','','','2020-09-18 00:00:00.000000','','','','','','','','','','','','','','','','511922200002106736','石光禹','18782733189','何淑兰','18282788121','18244472490','四川省南江县柳湾乡黄土村3社','L','40','职高','11-520-4','','','','','',''),
(1458,'杨豪','男','','','','2020-09-18 00:00:00.000000','','','','','','','','','','','','','','','','511622200009290031','杨毅','15982614533','易春琴','17761159463','13541857165','四川省武胜县沿口镇五一村4组43号','S','37','普高','11-526-1','','','','','',''),
(1457,'赵亚婷','女','','','','2020-09-18 00:00:00.000000','','','','','','','','','','','','','','','','510202200007136629','赵先','13108305999','胡全蓉','13118033988','17780100545','四川省泸州市江阳区江北镇先锋村十二组86号','S','36','普高','9-205-5','','','','','',''),
(1456,'张凤鸣','女','','','','2020-09-18 00:00:00.000000','','','','','','','','','','','','','','','','511923200012210429','张立权','15308297552','向嫦娥','15308293353','18382360769','四川省平昌县江口镇金宝五小组19号','S','36','职高','9-205-4','','','','','',''),
(1455,'陈毅','男','','','','2020-09-18 00:00:00.000000','','','','','','','','','','','','','','','','513921199909096214','陈世彬','18398070185','杨燕','15196808271','15775117258','四川省资阳市安岳县元坝镇安良村1组','XXXL','42','普高','11-530-6','','','','','',''),
(1454,'唐伟杰','男','','','','2020-09-18 00:00:00.000000','','','','','','','','','','','','','','','','511724200108016677','唐建','18113384663','何昌竹','18123202983','17628669668','四川省大竹县一环路南段15号','XL','41','职高','11-529-2','','','','','',''),
(1453,'朱云龙','男','','','','2020-09-18 00:00:00.000000','','','','','','','','','','','','','','','','511721200002235274','朱江林','15328971275','黄新丽','18784843593','15282420304','四川省达县碑高乡永必坝村6组49号','M','41','职高','11-529-4','','','','','',''),
(1452,'彭韦','男','','','','2020-09-18 00:00:00.000000','','','','','','','','','','','','','','','','513021199909023913','彭桉','13512366503','韦朱云','17828866768','15182883931','四川省达州市通川区北山镇顺堂村4组2号','M','42','职高','11-529-3','','','','','',''),
(1451,'袁天生','男','','','','2020-09-18 00:00:00.000000','','','','','','','','','','','','','','','','513021199909094033','袁发均','13410062989','曾美红','13717068304','18781843433','四川省达州市达川区木头乡红星村1组59号','XL','43','职高','11-529-1','','','','','',''),
(1450,'程志洪','男','','','','2020-09-18 00:00:00.000000','','','','','','','','','','','','','','','','513021200008167093','程学秀','13520021259','盛冬梅','13683207239','17628673372','四川省达州市达川区堡子镇盛家坪村2组','XL','42','职高','11-529-5','','','','','',''),
(1449,'雷海森','男','','','','2020-09-18 00:00:00.000000','','','','','','','','','','','','','','','','511722200104252098','雷晓晴','15005849051','王乐秀','15867810810','17628674542','四川省宣汉县马渡乡百丈村10组69号','XL','42','普高','11-530-4','','','','','',''),
(1448,'张书华','男','','','','2020-09-18 00:00:00.000000','','','','','','','','','','','','','','','','511921199909206231','张成河','13219290138','朱东梅','18301767651','15775799498','四川省通江县空山乡后坝村3社','M','40','普高','11-530-3','','','','','',''),
(1447,'陈静','女','','','','2020-09-18 00:00:00.000000','','','','','','','','','','','','','','','','511528200109230661','陈宗德','18028307762','王海英','15876050310','17321979316','四川省兴文县莲花镇大坪村6组13号','L','36','职高','9-205-1','','','','','',''),
(1446,'舒昌斌','男','','','','2020-09-18 00:00:00.000000','','','','','','','','','','','','','','','','510322200005036071','舒世良','13458771813','邵双分','18084114709','16608138908','四川省富顺县飞龙镇发农村18组61号','3X','43','职高','11-531-6','','','','','',''),
(1445,'彭毅','男','','','','2020-09-18 00:00:00.000000','','','','','','','','','','','','','','','','511622200011053414','彭宴辉','1366463278','秦玉琴','13665765816','17628231473','四川省武胜县中心镇锡壶沟村1组32号','L','42','职高','11-531-4','','','','','',''),
(1444,'陈建骏','男','','','','2020-09-18 00:00:00.000000','','','','','','','','','','','','','','','','513434200103080010','陈新文','15883460803','蒋慧琼','15348523417','18982558871','四川省越西县越城镇三叉口328号','L','39','普高','11-531-1','','','','','',''),
(1443,'陈亮','男','','','','2020-09-18 00:00:00.000000','','','','','','','','','','','','','','','','510504200104270910','陈家祥','18117972968','刘守秀','13398278349','13330781765','四川省泸州市龙马潭区胡市镇金山村7社3号','XL','41','普高','11-531-3','','','','','',''),
(1442,'蔡自丽','女','','','','2020-09-18 00:00:00.000000','','','','','','','','','','','','','','','','510322200003200544','蔡义平','18608123413','刘成蓉','15281626429','18308123413','四川省富顺县东湖镇东大街601号','M','37','职高','9#205-2','','','','','',''),
(1441,'王茂','男','','','','2020-09-18 00:00:00.000000','','','','','','','','','','','','','','','','510921200101230831','王云华','13999176348','何素芬','13982555365','14780080857','四川省蓬溪县新会镇猫山村5社13号','L','41','普高','11#536#6','','','','','',''),
(1440,'向艳','女','','','','2020-09-18 00:00:00.000000','','','','','','','','','','','','','','','','510902200012219527','向荣辉','15082548188','刘春燕','19950913995','15196931498','四川省遂宁市船山区和平西路70号3单元4楼2号','XL','38','普高','9#206#3','','','','','',''),
(1439,'陈丹','女','','','','2020-09-18 00:00:00.000000','','','','','','','','','','','','','','','','511724200209046824','陈志华','15814479843','宋明芳','15915319874','18582809534','四川省大竹县周家镇同心4组','L','38','普高','','','','','','',''),
(1438,'赵景泉','男','','','','2020-09-18 00:00:00.000000','','','','','','','','','','','','','','','','510821199909116811','赵大位','15883577320','何代智','18111779182','17683093491','四川省旺苍县三江镇分水村9组467号','L','40','职高','11#537#6','','','','','',''),
(1437,'罗涛','男','','','','2020-09-18 00:00:00.000000','','','','','','','','','','','','','','','','511922200012234512','罗福寿','13564864118','刘春华','18721835232','18682797563','四川省南江县元谭镇字库村4社','XL','41','职高','11#536#3','','','','','',''),
(1436,'谭朝灵','男','','','','2020-09-18 00:00:00.000000','','','','','','','','','','','','','','','','511922200106193416','谭峰一','15908347016','何敏','15983982314','15348279935','四川省南江县黑潭乡南鹰村2社','XL','41','职高','11#536#4','','','','','',''),
(1435,'柯昊','男','','','','2020-09-18 00:00:00.000000','','','','','','','','','','','','','','','','511181199908295511','柯昌荣','15328621571','朱翠英','15386543573','18080619392','四川省峨眉山市双福镇塘房村3组8号','L','40','普高','11#532#4','','','','','',''),
(1434,'徐琴','女','','','','2020-09-18 00:00:00.000000','','','','','','','','','','','','','','','','511622200005261620','徐少明','13657601573','王琼兰','17311879753','13541873570','四川省武胜县金牛镇望乡坪村11组43号','L','37','职高','9#206#5','','','','','',''),
(1433,'谢亚琼','女','','','','2020-09-18 00:00:00.000000','','','','','','','','','','','','','','','','511622200011255227','谢洪春','18723411378','黄素兰','13983298544','18282677817','四川省武胜县高石乡新民村4村8组22号','M','37','职高','9#206#4','','','','','',''),
(1432,'易香','女','','','','2020-09-18 00:00:00.000000','','','','','','','','','','','','','','','','500382200012248982','易建平','15521552162','唐士红','13541863296','13419300986','重庆市合川区燕窝镇滨江路1号附516号','M','37','职高','9#206#6','','','','','',''),
(1431,'杨惠文','男','','','','2020-09-18 00:00:00.000000','','','','','','','','','','','','','','','','510183200010526994','杨鹏','15928118216','尹慧','15828008273','18780141928','四川省邛崃市平乐镇金河村8组','L','42','普高','','','','','','',''),
(1430,'黄浩然','男','','','','2020-09-18 00:00:00.000000','','','','','','','','','','','','','','','','510603200011087972','黄万华','18280599796','张兴波','13518262588','15008347498','四川省德阳市旌阳区西湖街468号附4号','M','41','职高','','','','','','',''),
(1429,'齐琪','男','','','','2020-09-18 00:00:00.000000','','','','','','','','','','','','','','','','510603200108102753','齐文亮','13990297637','谭森珍','13541713060','15008353845','四川省德阳市旌阳区西湖街439号','M','41','职高','','','','','','',''),
(1428,'刘欣宇','男','','','','2020-09-18 00:00:00.000000','','','','','','','','','','','','','','','','512021200303011170','刘永强','13648827443','吴成坤','15825265389','16683051880','四川省安岳县通贤镇四方村3-1','M','41','普高','','','','','','',''),
(1427,'刘金浩','男','','','','2020-09-18 00:00:00.000000','','','','','','','','','','','','','','','','513723199801085814','刘江平','18398929346','杨尚芝','15060946192','18982856692','四川省平昌县云台镇龙尾村5社18号','XXL','42','普高','','','','','','',''),
(1426,'李再宏','男','','','','2020-09-18 00:00:00.000000','','','','','','','','','','','','','','','','513029199802266836','李祚国','15112727302','袁花','18938512536','18384827862','四川省大竹县周家镇高峰寨村7组','M','40','普高','11#536#2','','','','','',''),
(1425,'刘陈','男','','','','2020-09-18 00:00:00.000000','','','','','','','','','','','','','','','','511622200011040234','刘太亮','13658383736','陈登芬 ','15282637146','18282674772','四川省武胜县礼安镇半边街村1组18号','M','39','职高','','','','','','',''),
(1424,'潘云文','男','','','','2020-09-18 00:00:00.000000','','','','','','','','','','','','','','','','51018220000616381X','潘显均','13980089851','张秀平','18384228273','13688033212','四川省彭州市红岩镇白石沟村4组62号','L','40','普高','11#537#4','','','','','',''),
(1423,'宋磊','男','','','','2020-09-18 00:00:00.000000','','','','','','','','','','','','','','','','513434200104030058','宋建辉','18111410871','耿玉','15283438254','18282898701','四川省岳西县越城镇吊桥路161号','L','40','普高','11#601#1','','','','','',''),
(1422,'周昊','男','','','','2020-09-18 00:00:00.000000','','','','','','','','','','','','','','','','513433200011140016','','','郑霞','15881581950','17381607692','四川省冕宁县大桥镇安源电站1幢5号','L','41','普高','','','','','','',''),
(1421,'徐顺江','男','','','','2020-09-18 00:00:00.000000','','','','','','','','','','','','','','','','510823200008063335','徐星茂','13552152579','唐小容','13641299674','13118155125','四川省剑阁县碗泉乡碗泉村5组2号','L','41','普高','11#532#2','','','','','',''),
(1420,'张浩宇','男','','','','2020-09-18 00:00:00.000000','','','','','','','','','','','','','','','','51382320001110003X','张勇','','刘继英','18123020068','18141399689','四川省彭山县凤鸣镇东街153号','L','42','职高','','','','','','',''),
(1419,'郭宇航','男','','','','2020-09-18 00:00:00.000000','','','','','','','','','','','','','','','','510521199911237915','郭','13422831278','代大芬','','18583070756','四川省泸县天心镇龙凤村七社217号','M','39','普高','11#531#2','','','','','',''),
(1418,'王洋龙','男','','','','2020-09-18 00:00:00.000000','','','','','','','','','','','','','','','','511325200007075111','王志军','13438425429','王碧蓉','13458379602','13408223412','四川省资阳市安岳县岳阳镇凤山路北段92号二幢一单元302号','L','43','普高','','','','','','',''),
(1417,'杜鑫','男','','','','2020-09-18 00:00:00.000000','','','','','','','','','','','','','','','','511725200103080334','杜光映','18981483783','雍朝容','15892992062','18782874238','四川省渠县渠南乡大山村1组8号','L','40','普高','','','','','','',''),
(1416,'靳海','男','','','','2020-09-18 00:00:00.000000','','','','','','','','','','','','','','','','51052520001107789x','靳朝平','13982723818','王静','13989135526','15555547523','四川省古蔺县德耀镇福来村一组51号','M','40','职高','11#601#3','','','','','',''),
(1415,'刘苓江','男','','','','2020-09-18 00:00:00.000000','','','','','','','','','','','','','','','','510525200012247897','刘龙海','13982706386','谭翠娥','19915839482','18208357653','四川省古蔺县德耀镇福来村一组68号','M','40','职高','11#601#4','','','','','',''),
(1414,'田聪','男','','','','2020-09-18 00:00:00.000000','','','','','','','','','','','','','','','','510525200005120011','田贵方','13309080226','李小蔺','17381439950','18716112072','四川省古蔺县古蔺镇映月村7组31号','M','40','职高','11#601#5','','','','','',''),
(1413,'龚泽宇','男','','','','2020-09-18 00:00:00.000000','','','','','','','','','','','','','','','','511623200011286759','龚云成','13518391478','刘小英','18282601690','17345351697','四川省广安市邻水县石永镇建新街','XL','43','普高','11#536#5','','','','','',''),
(1412,'张宝平','男','','','','2020-09-18 00:00:00.000000','','','','','','','','','','','','','','','','513701200001224414','张云成','13568472328','马菊华','13698279703','18782957806','四川省巴中市恩阳区观音井真万寿村5组','M','40','职高','11#531#2','','','','','',''),
(1411,'卢琳松','男','','','','2020-09-18 00:00:00.000000','','','','','','','','','','','','','','','','513426200009155514','卢永任','18508129581','党美焕','15281213791','18508129581','四川省会东县鲁吉镇清洁村7组29号','L','41','普高','','','','','','',''),
(1410,'张子健','男','','','','2020-09-18 00:00:00.000000','','','','','','','','','','','','','','','','510411200109278119','张红','15328991853','李雪芹','15328992242','18583894504','四川省攀枝花市仁和区虹桥巷25号1栋1单元9号','L','40','普高','','','','','','',''),
(1409,'尹顺超','男','','','','2020-09-18 00:00:00.000000','','','','','','','','','','','','','','','','510603200108060979','尹玉刚','18990204116','黄艳','18909024115','18990246904','四川省德阳市旌阳区乐山街1号附11号','XXXL','42','普高','','','','','','',''),
(1408,'李小龙','男','','','','2020-09-18 00:00:00.000000','','','','','','','','','','','','','','','','513902200012052918','李宗华','15196830696','王华','13698323260','15183810380','四川省简阳市简城镇棉丰村10社 ','XXL','43','普高','11#537#5','','','','','',''),
(1407,'张丹璐','女','','','','2020-09-18 00:00:00.000000','','','','','','','','','','','','','','','','510682200106230028','钟刚全','13550639711','邓晓英','13981025439','15183810380','四川省什邡市方亭东顺城街91号3栋206室','L','39','职高','','','','','','',''),
(1406,'董利君','女','','','','2020-09-18 00:00:00.000000','','','','','','','','','','','','','','','','51052220000410028x','董家贵','15283009095','夏廷先','13550891276','18148495231','四川省合江县合江镇醒觉溪47号附3号','L','36','普高','9#206#2','','','','','','');

/*Table structure for table `student_info_column_mapper` */

DROP TABLE IF EXISTS `student_info_column_mapper`;

CREATE TABLE `student_info_column_mapper` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `excel_name` varchar(255) NOT NULL COMMENT 'excel字段名',
  `database_name` varchar(255) NOT NULL COMMENT '数据库字段名',
  `type` varchar(255) DEFAULT NULL COMMENT '对应的java数据类型全称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8;

/*Data for the table `student_info_column_mapper` */

insert  into `student_info_column_mapper`(`id`,`excel_name`,`database_name`,`type`) values 
(2,'姓名','studentName','java.lang.String'),
(3,'性别','gender','java.lang.String'),
(4,'系部','college','java.lang.String'),
(5,'班级','stuClass','java.lang.String'),
(6,'专业','major','java.lang.String'),
(7,'生日','birthday','java.util.Date'),
(8,'籍贯','nativePlace','java.lang.String'),
(9,'民族','nation','java.lang.String'),
(10,'家庭电话','familyTel','java.lang.String'),
(11,'政治面貌','politicCountenance','java.lang.String'),
(12,'入学年级','inGrade','java.lang.String'),
(13,'入学方式','inType','java.lang.String'),
(14,'邮箱','email','java.lang.String'),
(15,'学籍类别','studyCategory','java.lang.String'),
(16,'学籍状态','studyStatus','java.lang.String'),
(17,'户口性质','residentType','java.lang.String'),
(18,'开户银行','bank','java.lang.String'),
(19,'银行卡号','bankCardID','java.lang.String'),
(20,'是否贷款','isLoan','java.lang.String'),
(21,'生源地','studentPlace','java.lang.String'),
(22,'证件类型','identityType','java.lang.String'),
(23,'身份证','identityID','java.lang.String'),
(24,'学号','studentNum','java.lang.String'),
(25,'考号','examNum','java.lang.String'),
(26,'父亲姓名','fatherName','java.lang.String'),
(27,'父亲电话','fatherTel','java.lang.String'),
(28,'母亲姓名','motherName','java.lang.String'),
(29,'母亲电话','motherTel','java.lang.String'),
(30,'爷爷电话','gradeFatherTel','java.lang.String'),
(31,'本人电话','selfTel','java.lang.String'),
(32,'奶奶电话','gradeMotherTel','java.lang.String'),
(33,'家庭详细地址','address','java.lang.String'),
(34,'衣服尺码','clothesSize','java.lang.String'),
(35,'鞋码','shoeSize','java.lang.String'),
(36,'职高/普高','educationType','java.lang.String'),
(37,'寝室号','dormNum','java.lang.String'),
(38,'宗教信仰','religion','java.lang.String'),
(39,'相片路径','photo','java.lang.String');

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `Id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID主键',
  `Account` varchar(128) DEFAULT NULL COMMENT '账户',
  `Password` varchar(128) DEFAULT NULL COMMENT '密码',
  `RealName` varchar(128) DEFAULT NULL COMMENT '真名',
  `Gender` varchar(4) DEFAULT NULL COMMENT '性别',
  `Tel` varchar(128) DEFAULT NULL COMMENT '电话',
  `Email` varchar(128) DEFAULT NULL COMMENT '邮箱',
  `Department` varchar(128) DEFAULT NULL COMMENT '部门',
  `Description` text COMMENT '描述',
  `PreviousVisit` date DEFAULT NULL COMMENT '上次登录',
  `LastVisit` date DEFAULT NULL COMMENT '最后登录',
  `CreateDate` date DEFAULT NULL COMMENT '创建时间',
  `CreateUser` varchar(128) DEFAULT NULL COMMENT '创建用户',
  `ModifyDate` date DEFAULT NULL COMMENT '修改时间',
  `ModifyUser` varchar(128) DEFAULT NULL COMMENT '修改用户',
  PRIMARY KEY (`Id`) USING BTREE
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

/*Data for the table `users` */

insert  into `users`(`Id`,`Account`,`Password`,`RealName`,`Gender`,`Tel`,`Email`,`Department`,`Description`,`PreviousVisit`,`LastVisit`,`CreateDate`,`CreateUser`,`ModifyDate`,`ModifyUser`) values 
(1,'admin','c33367701511b4f6020ec61ded352059','测试修改','男',NULL,NULL,NULL,NULL,'2020-07-13',NULL,NULL,NULL,NULL,NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
