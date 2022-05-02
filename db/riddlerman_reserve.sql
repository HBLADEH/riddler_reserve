/*
 Navicat Premium Data Transfer

 Source Server         : 本地
 Source Server Type    : MySQL
 Source Server Version : 80012
 Source Host           : localhost:3306
 Source Schema         : riddlerman_reserve

 Target Server Type    : MySQL
 Target Server Version : 80012
 File Encoding         : 65001

 Date: 01/12/2021 13:12:57
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for rm_admin
-- ----------------------------
DROP TABLE IF EXISTS `rm_admin`;
CREATE TABLE `rm_admin`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `username` varchar(24) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户名，唯一',
  `nickname` varchar(24) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户昵称',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码',
  `avatar` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '头像url',
  `email` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `create_time` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT '创建时间',
  `update_time` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `username`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of rm_admin
-- ----------------------------
INSERT INTO `rm_admin` VALUES (1, 'blade', '泡椒', '$2a$10$zn5uog7ttsH9VKSuHpj0mu8Lj.dlVC82iuMYIYTY3TnV4GgOqE6wK', NULL, '1012582116@qq.com', '2021-04-05 23:49:47.953', '2021-12-01 01:27:55.950');

-- ----------------------------
-- Table structure for rm_admin_permissions
-- ----------------------------
DROP TABLE IF EXISTS `rm_admin_permissions`;
CREATE TABLE `rm_admin_permissions`  (
  `admin_id` int(11) NOT NULL COMMENT '管理员ID',
  `permissions_id` int(11) NOT NULL COMMENT '权限ID',
  INDEX `rm_admin_permissions_ibfk_1`(`permissions_id`) USING BTREE,
  INDEX `admin_id`(`admin_id`) USING BTREE,
  CONSTRAINT `rm_admin_permissions_ibfk_1` FOREIGN KEY (`permissions_id`) REFERENCES `rm_permissions` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `rm_admin_permissions_ibfk_2` FOREIGN KEY (`admin_id`) REFERENCES `rm_admin` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of rm_admin_permissions
-- ----------------------------
INSERT INTO `rm_admin_permissions` VALUES (1, 1);
INSERT INTO `rm_admin_permissions` VALUES (1, 2);
INSERT INTO `rm_admin_permissions` VALUES (1, 3);
INSERT INTO `rm_admin_permissions` VALUES (1, 4);
INSERT INTO `rm_admin_permissions` VALUES (1, 5);
INSERT INTO `rm_admin_permissions` VALUES (1, 6);
INSERT INTO `rm_admin_permissions` VALUES (1, 7);
INSERT INTO `rm_admin_permissions` VALUES (1, 8);
INSERT INTO `rm_admin_permissions` VALUES (1, 9);
INSERT INTO `rm_admin_permissions` VALUES (1, 10);
INSERT INTO `rm_admin_permissions` VALUES (1, 11);
INSERT INTO `rm_admin_permissions` VALUES (1, 12);
INSERT INTO `rm_admin_permissions` VALUES (1, 13);
INSERT INTO `rm_admin_permissions` VALUES (1, 14);

-- ----------------------------
-- Table structure for rm_goods
-- ----------------------------
DROP TABLE IF EXISTS `rm_goods`;
CREATE TABLE `rm_goods`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `cover_img` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '商品图片',
  `play_num` int(11) NOT NULL COMMENT '游玩人数',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '商品名称',
  `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '描述',
  `create_time` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT '创建时间',
  `update_time` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 72 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of rm_goods
-- ----------------------------
INSERT INTO `rm_goods` VALUES (3, '/goods/coverImage/1636291482330宿醉.jpg', 6, '宿醉', '几个青年男女在宿醉中醒来,发现大家都和往常有些不太一样,有人身上带伤,有人换上了奇怪的发型,还有人心里有些奇异的感觉。\r\n但相同的是,大家都晕晕沉沉的记得一些片段性的记忆。\r\n昨晚,到底发生了什么事情?', '2021-04-07 01:49:08.000', '2021-11-16 19:57:37.000');
INSERT INTO `rm_goods` VALUES (9, '/goods/coverImage/1636291438306舍离2.jpg', 6, '舍离2断念', '一世一缘，一期一会，一生一执念，一念一花开。\n你曾恨过谁？爱过谁亦或者负过谁？苦海无涯，百转千回。\n天劫难度终须度，心劫非劫不可生。\n千劫过后，是否还有忘川彼岸可回首，情深一人共白头。', '2021-04-10 00:59:16.000', '2021-11-15 16:38:12.000');
INSERT INTO `rm_goods` VALUES (10, '/goods/coverImage/1636291357584星火号.png', 5, '星火号', '2116年,“拓宇计划”第一批远征星海的26艘飞船按计划全数返航,满载有关地外行星的科考成果踏上归途。相比其它飞船,“星火号”的返航更加令人期待。地球在大肆开发中已变得无比脆弱,难以负担人类的生存所需。而这艘以探寻宜居星球为己任的飞船带给了人类无限的遐想—它所到达的RU24431b,也就是人们俗称的“绿星”,很可能就是适合人类生存的第二家园。9月9日凌晨01:42,地球和星火号的通讯重新建立。全球的实时直播同步开启,在近百亿人热切的目光里,一场异变陡然而生…', '2021-04-10 00:59:18.000', '2021-11-15 16:38:22.000');
INSERT INTO `rm_goods` VALUES (11, '/goods/coverImage/1636291225274爱幼.jpg', 8, '爱幼妇产医院', '安静祥和的玉湖村四面环山，原本一切正常的村庄突发 5 天 5 夜洪水，村民无一人生还。\n\n后经高人指点，在玉湖村旧址修建寺庙超度村民，却不曾想到寺庙被人为破坏修建了《爱幼妇产医院》，医院营业期间一切正常，可不知道为何医院的老板跳楼自杀，从此医院便有了各种诡异的传闻。\n\n有传闻说修建寺庙是为了镇压亡魂，寺庙被破坏后玉湖村的亡魂四处游荡寻找机会附身，让自己“活过来”。\n\n有传闻说<爱幼妇产医院》出生的婴儿大部分都会死亡，死后的婴儿不愿意离去跟随在自己母亲身边。\n\n有传闻说医院的老板是一个修道之人，修建医院是想利用婴儿的出生化解玉湖村村民的怨气。\n\n传闻越来越多，越来越诡异，今天是 2019 年的七月半，医院大门口来了一群人。', '2021-04-10 00:59:21.000', '2021-11-15 16:38:24.000');
INSERT INTO `rm_goods` VALUES (18, '/goods/coverImage/1636291088569校规.jpg', 7, '二十二条校规', '现在是深夜凌晨2：00，往日人声鼎沸的学校里此刻充满寂静，阴冷的月光照在一个个无人的教室中，给黑夜平添上了一分诡异感。教学楼一共有6层，此时5楼某个教室中，一个人影悄悄的打开了教室的门，然后小心翼翼的观察着周围的走廊，良久，这个人影似乎松了口气，轻轻的走出去并关上教室的门似是在极力避免发出声音，突然，“他”浑身一抖似乎感应到了什么一样，立刻朝着走廊的边狂奔，看到楼梯后“他”飞速向下跑，正想口气冲下一楼时“他”突然在楼梯口停了下来，接着头也不回的转身朝二楼跑去，似乎楼梯下面有什么非常恐怖的东西在等着“他”一样，终于“他”累了跑不动了，“他”在走廊尽头找到了一间教室便赶忙冲了进去想要躲躲，但是打开门的瞬间，“他”的脸色瞬间变得惨白，眼睛直勾勾的看着眼前难以置信的一幕，随后，死寂的校园中传出了一声凄厉的怡叫。', '2021-04-15 04:28:04.000', '2021-11-15 16:38:27.687');
INSERT INTO `rm_goods` VALUES (50, '/goods/coverImage/1637336004583雾鸦馆.jpg', 6, '雾鸦馆', '千万不要在雾天做梦，梦中有种名为雾魔的冤魂，会将你拖入地狱之中。\n——摘录自《雾鸦市都市传说》\n海因纪134年，一份来自雾鸦馆的邀请函打碎了夜空的沉寂，唤醒了乌鸦们的噩梦。\n在那被胶带层层包裹的别墅中，恐惧化为枷锁，将七名罪人囚禁在这密不透风的牢笼之中。\n谁能找到通往生的出口?谁又会是那潜藏在幕后，低吟浅笑的真凶?\n是蚕茧中的公鸡?是这水中窒息的人偶?还是那被肢解的蜡像?\n死亡乐章伴奏着胶带密室的疯狂艺术，踏碎逻辑的真凶就在眼前，而证据却消失得无影无踪。\n这是一份来自雾鸦馆的邀请函，这是一场杀人狂的宴会，这是一声来自地狱的丧钟。', '2021-11-19 23:34:56.482', '2021-11-19 23:34:56.482');
INSERT INTO `rm_goods` VALUES (51, '/goods/coverImage/1637336172561一点半.jpg', 6, '一点半', '这个世界上有各种各样的人。有些人信佛，有些人信道。\n\n还有些人没有信仰，但他们怕鬼。你呢?你怕什么?\n\n都市传奇组织:怪谈协会，诚挚邀请所有寂寞的，孤独的，怕鬼的你们，在每月农历初一，看不见月亮的\"朔\"日里，一起相聚并分享您在这个月内搜集来的都市怪谈故事，让我们一起抱团取暖，不再害怕。欢迎来到，怪谈协会......', '2021-11-19 23:36:59.518', '2021-11-19 23:36:59.518');
INSERT INTO `rm_goods` VALUES (52, '/goods/coverImage/1637338427106校规2.jpg', 6, '第二十二条校规2—返校', '漆黑的夜，一轮弯弯的新月在乌云中慢慢显现，冰冷的月光洒落在杂乱的操场上，稍远处，砌着白墙的教学楼静静的伫立着，月光照射在无人的教室中，伴随着陡然出现的交谈声，欢笑声，一个个黑影开始显现，走廊上、教室中、楼梯上，整栋教学楼都挤满了黑影，他们或是嬉笑打闹或是喝骂交谈,短短的瞬间，无人的学校中犹如白天一般热闹非凡，只是发出这些声音的人却是一个个没有五官令人毛骨悚然的黑影。随着乌云再度将弯月遮蔽，黑影也好交谈声也罢都在一瞬间定格并缓缓消失，漆黑的校园重新归于寂静与黑暗......', '2021-11-20 00:15:16.731', '2021-11-20 00:15:16.731');
INSERT INTO `rm_goods` VALUES (53, '/goods/coverImage/1637338574741七个密室.jpg', 6, '七个密室', '“看来你们已经醒来了。”一个怪异诡谲的声音从荧幕中传出，一听就知道，这个声音被人用软件加工过，根本听不出是男是女。\n\n“大家好，我是审判者，欢迎来到Inside,这次的主题是密室杀人。\n\n你们所在的密室里，有六个房间，它们分别代表一桩密室杀人案。这六桩案件分别是：【血字的留言】【无死角的密室】【瞬间消失的行凶者】【三重门】【最后的烛光晚餐】【爱洛斯的分尸诅咒】你们七人之中，有六人与这六桩案件一一对应，只有唯一一名无罪之人。\n\n不过我使了些手段，让你们忘记了自己的过往。有罪者如果能找到每件凶案的凶手，并将无罪之人关进审判之室，则有罪者胜利，六名有罪者将会得到释放并拿回属于你们自己的记忆，而无罪者将会接受“审判之火”的惩罚。反之，若无罪之人没有被找到，我将会向大众公布你们的所有罪行。\n\n游戏已经开始了，做出你们的选择吧，没有人是无辜的。', '2021-11-20 00:17:29.027', '2021-11-20 00:17:29.027');
INSERT INTO `rm_goods` VALUES (54, '/goods/coverImage/1637338767581年轮.jpg', 5, '年轮', '位于T市郊外160多公里一座山谷内的废墟,原先是一个仅有数十户人口的小村。一天夜里突发大火,由于谷内山路崎岖且没有外接水源导致救火工作极其困难。好在深凹的地形致使火势并没有向外蔓延,天蒙蒙亮时火势才渐渐熄灭。那次大火对山谷内的石壁树木造成了破坏,后来每每有风吹过时总能听到呜呜的哭声;仿佛是当年那些冤魂在为自己哭诉。外面通往山谷的地势险峻再加上村子位置较为隐蔽使得这些年政府并没有对这片废墟进行修缮。\n今天,一群人聚集到了这里...', '2021-11-20 00:19:39.186', '2021-11-20 00:19:39.186');
INSERT INTO `rm_goods` VALUES (55, '/goods/coverImage/1637338977342前男友的一百种死法.jpg', 5, '前男友的一百种死法', '方氏集团，在全国企业中排行靠前十，家大业大。其千金大小姐据说是交往了一个男朋友，不到一年时间却要闪婚，千金大小姐脾气挺大，方总只能妥协办成了订婚宴，并且邀请了自己几位好友到别墅做客。\n俗话说，三个女生一台戏，五个女生会擦出什么样的火花呢...而这一切并不简单..还未开始的婚礼...房门紧闭的房间.....身份成谜的男友.....这一切，到底是怎么回事？', '2021-11-20 00:23:08.000', '2021-11-20 01:15:51.000');
INSERT INTO `rm_goods` VALUES (56, '/goods/coverImage/1637341476239孤城.jpg', 7, '孤城', '内有国共争锋，军阀混乱，还有土匪称霸一方，外有日军侵犯，这就是孤城所处的年代。\n\n在这样的时代中，每个人都有自己的信仰和追求。每个人也有自己的组织，完成自己的任务。\n\n在这里你会体验到一掷千金的豪气，也会体验到队友的猜忌，步步为营，拿下最后的胜利。', '2021-11-20 01:04:49.731', '2021-11-20 01:04:49.731');
INSERT INTO `rm_goods` VALUES (57, '/goods/coverImage/1637341579031拆迁.jpg', 10, '拆迁', '哟，拆啦！北京爱民胡同为了配合景区建设，在政府要求下进行拆迁，只要按时离开，就能分得北京郊区一间大房子，每个人还能得补偿款500万元。而拆迁的最后期限渐渐临近，却还有10个人没有迁走，他们在一个名叫“周广播‘的妇女号召下，组成了“钉子户联盟”，集体要求增加补偿款，500万元增加到600万元。在周广播的领导下，10个人都拍着胸脯保证：一定会签“不同意”，大家团结起来，一起拿到600万元。可是在信誓旦旦的言语中，每个人都各有心思，他们真的能团结一致、熬到最后一刻吗？眼看投票的时间越来越近，似乎，有些人不那么坚定了。有拆迁这么大的事，感情啊，人命啊，竟然都显得不疼不痒了。', '2021-11-20 01:06:26.233', '2021-11-20 01:06:26.233');
INSERT INTO `rm_goods` VALUES (58, '/goods/coverImage/1637382591330鸢飞戾天.jpg', 6, '鸢飞戾天', '北宋宣和二年（公元1120年），宋与刚刚兴起的金缔结联盟，南北夹击，共同灭辽。\n灭辽后，逐渐强大起来的金国开始南望中原，并于靖康二年攻下宋都城汴京（今开封），俘虏徽钦二帝和一众皇室贵族北上。以宋徽宗为首的宋国皇室在金国为奴为婢，贵族女子更是沦为金人的玩物……后世人称之“靖康之耻”。\n南逃的宋徽宗第九子赵构在临安（今杭州）登基，改元建炎，重建大宋王朝，史称“南宋”。\n自此，宋金两国沿秦岭——淮河一线分治。\n南宋自建朝以来，以岳飞为首的主战派将领便数度北伐，但均以失败告终。倏忽然近百年光阴过去，开禧二年（公元1206年），宋丞相韩胃领兵北伐，却因军中出现叛将而功亏一簧。\n两年后的嘉定元年，北伐彻底失败，宋金签订“嘉定和议”。宋上国书称金为伯父，缴纳岁币银绢各三十万，又以三百万钱赎回了淮、陕两地.…\n如今已是嘉定七年（公元1214年），北方蒙古对中原沃土虎视耽眈，金不堪其扰。在这一年的秋天，宋太子赵询带领使团来到宋金交界的光州，预备与金的使者商讨是否继续履行“嘉定和议”的职责.…', '2021-11-20 12:30:12.636', '2021-11-20 12:30:12.636');
INSERT INTO `rm_goods` VALUES (59, '/goods/coverImage/1637384511515那时的我们.jpg', 8, '那时的我们', '是否还记得那年夏天，那群傻瓜，说的那句傻话——要一辈子做最好的朋友。\n可是分别十年，当初那么要好的一群人，现在为什么就不联系了呢？\n很多年不联系，那些曾经存在过的感情就消失不见了吗？\n穿上那身高中校服，佩戴上那一块校牌，听着《同桌的你》，十年同学会上的你为什么痛哭流涕？ \n彩云一中的八位同班同学十年后首次聚会，那些曾经被深埋在心底的故事被一幕幕揭开……', '2021-11-20 13:02:21.250', '2021-11-20 13:02:21.250');
INSERT INTO `rm_goods` VALUES (60, '/goods/coverImage/1637384921687别来无恙.jpg', 6, '别来无恙', '那时没有说再见，是因为，我以为不见，你便无恙。\n\n以前总认为人生中最难能可贵的是相遇，后来意外重逢我才明白其实最美好的是，\n\n久别重逢，别来无恙。\n\n这是一段发生在她和他之间的故事，可能也发生在你和他/她之间。\n\n一样平淡无奇的生活，却充满遗憾的过去。\n\n毕竞世界上爱而不得是常态，兰因絮果是缘尽。\n\n如果再给你一次机会见到那个人，你会想对他说什么呢?', '2021-11-20 13:08:58.663', '2021-11-20 13:08:58.663');
INSERT INTO `rm_goods` VALUES (61, '/goods/coverImage/1637385043941瘆.jpg', 7, '瘆', '2020年7月17日凌晨1点，在一座荒废了20年的死城里，七位年轻人即将要进行一场通灵直播……\n古宅，河边，教堂，小学天台，黄仙庙，十字路口，未完工的大厦……说不出缘由的寒意，早已准备好的通灵道具…一张张诡异的照片，走不出的迷雾……\n这价值百万的游戏他们能否完成？等待他们的会是什么？not end just d……', '2021-11-20 13:11:02.604', '2021-11-20 13:11:02.604');
INSERT INTO `rm_goods` VALUES (62, '/goods/coverImage/1637385168851古木吟.jpg', 6, '古木吟', '羌镇，地处岷江西岸，有上千年的古文化的美丽小镇，国家旅游文化圣地。自古流传炎帝在此尝百草，镇中银杏皆有灵性的传说。小镇至今保有“火舞祭”的仪式，在朗歌坪中燃烧灵木，让镇民对银杏古木的树灵表示敬畏。\n　　20世纪末，连续3年在火舞祭当天发生了居民举家失踪的谜案，祭暂时搁浅。数年后，火舞祭的习俗得以恢复，镇上的春晖中学的六名学生却在火舞祭当天突然失去意识，醒来后在校舍看到了不可思议的景象……\n　　这个校舍，已经疯了……\n　　晦暗的阴云压在头顶，校门口被断木封死，围栏外被乱石掩埋。\n　　树林白发老妇、篝火大头娃娃……装在盒中的断头女、抵住栅门的血手印……明明没有老师在的教室，学生却纷纷望着讲台记起了笔记；明明没有管理员的宿舍，一颗颗头颅与头发在回廊中滚动……操场附近，幼童尖笑声回荡；教学大楼，学生接连的消失；保健室内，陈放许久的尸体突然动了起来。幽暗的走廊灯如亡灵叹息，将幸存者的影子指向校园中庭的古木。\n　　仅有6名幸存的学生，如何逃离这所亡灵校舍。银杏古木娓娓道来的，是怎样催人泪下的秘密。', '2021-11-20 13:13:33.339', '2021-11-20 13:13:33.339');
INSERT INTO `rm_goods` VALUES (63, '/goods/coverImage/1637385295202野の蔷薇.jpg', 6, '野の蔷薇', '1999年8月，报纸上铺天盖地的宣传着一则新闻： “重金破案，探寻15年前小野 家主小野隆一在家训练离奇死亡的真相。”小野隆一是被誉为日本体操之父的奥运会冠军，退役后经营着一家体操俱乐部，培养日本青少年体操选手，受人敬仰，1984年8月15日被发现死在家中，嫌疑人之一失踪不久后，警察最终以意外结案。据说小野裕太不满当年爷爷死亡的案件调查结果，所以重金悬赏知情者和侦探来还原当时的案情真相，奖励甚至还包含了俱乐部1%的股份。8月15日下午，小野庄园，众人聚集，各有心思，一连串的问题不由自主地浮上脑海：为何时至今日小野家才重启案件?当年的嫌疑人为何突然失踪?而小野隆一的死究竟是意外还是伪装成意外的谋杀?', '2021-11-20 13:15:17.542', '2021-11-20 13:15:17.542');
INSERT INTO `rm_goods` VALUES (64, '/goods/coverImage/1637385464853青楼.jpg', 7, '青楼', '隋末天下群雄并起。\n公元617年唐国公于晋阳起兵，凭借一方至宝“混元石”的力量，打败了高丽、打败突厥、定了吐蕃，并继开拓西戒，直到中亚，可谓万国来朝。\n次年，唐国公帝建立大唐王朝。以长安为京师，响名——“长安城“\n说起这“混元石“，它乃这世间极凶之物。\n同时也是一把双刃剑.拥有强大力量的同时，也会香主人的心血，轻则丧命，重则七瑰破。\n不过自从大唐王朝建立从后，这“混元石”也再没有现过世，本该遭其反噬的唐国公如今也是依然建好。似平是利用了某种神奇之力将体内的板恶之气散去。\n这事在如今大唐宫中乃是口禁，这“混元石“如今到底去了哪里，世人们都是面面皆问。\n再到后来唐朝也是歌舞盛华之朝，乐文取得了辉煌成就，同时也将女伎们的身价向了巅峰。\n青楼之市火爆，歌舞伎成了热门之业。\n虽然沦落为青楼女子并不光彩，但依然有很多人选择这一职业。在这些女子中琴棋书画兼备的也大有人在……\n在长安城内，其一等之青楼玉满楼，别名“玉月满花”。\n此中之女子皆是琴棋书画兼备。相传呐，那都是卖艺不卖身的存在。\n我们的故事就要从这玉满楼开始说起……', '2021-11-20 13:20:16.076', '2021-11-20 13:20:16.076');
INSERT INTO `rm_goods` VALUES (65, '/goods/coverImage/1637385757406艺妓回忆录.jpg', 8, '艺伎回忆录', '大正时代，是日本最短暂的一个时代。\n平和，浪漫，繁盛。\n在东京祗园生活的艺伎们卖艺不卖身。但也有传言说，有人在一个叫华枝茶屋的地方，早早地埋下了阴谋与罪恶的种子。\n据说，进出华枝茶屋的非富即贵，客人们都戴着面具，不以真面容示人……\n1923年，天皇要在祗园选出日本第一艺伎，而当时在现场的八个人，命运就此改变。', '2021-11-20 13:22:45.072', '2021-11-20 13:22:45.072');
INSERT INTO `rm_goods` VALUES (66, '/goods/coverImage/1637385936689窗边的女人.jpg', 6, '窗边的女人', '夜深，电脑响起了提示音。\n我已习惯性正要关闭，却发现是我一直关注的某个论坛的新消息。本能的好奇让我打开这个很久没更新的论坛，却发现今天气氛异常活跃。\n我看了看日历。\n噢，原来十年了。\n那起未结的分尸案到今天已经十年了。\n越过水墨江南的青砖瓦墙。\n她，在地下还好吗？', '2021-11-20 13:26:25.081', '2021-11-20 13:26:25.081');
INSERT INTO `rm_goods` VALUES (67, '/goods/coverImage/1637386118044来自乡下的你.jpg', 6, '来自乡下的你', '1993年正是社会建设如火如荼的奋斗时代。\n来自外地的年轻人们，在富阳棉纺厂，用汗水书写着青春之歌。\n辛勤的劳动，换来了比在老家更高的收入，但是城市的五光十色，也让某些人逐渐迷失。\n啊，最好的时代，也是最坏的时代！\n厂长蒋赶超，在这个剧变的时代，让棉纺厂办得有声有色。他追赶潮流，制作新款衣服和棉纺用品，从下游制作，成功转型为有自厂产销品牌的厂子。下一步，就是要打出品牌啦，走出新阳市，走向全国，走向世界！\n可是呢，哎呀呀，偏偏在厂子要扩大的节骨眼上，他出事了！\n棉纺厂何去何从呢？厂里的职工们何去何从呢？', '2021-11-20 13:29:12.799', '2021-11-20 13:29:12.799');
INSERT INTO `rm_goods` VALUES (68, '/goods/coverImage/1637386209822金玉良缘.jpg', 8, '金玉良缘', '公元690年，武则天称帝，随后在其主张下，洛阳修建了第一座专供女子的书院——西君书院！\n\n民间很快掀起一股“女尊男卑”的风潮，年轻女子进书院习文，而年轻男子则成为伴读书童，研习各式技艺，只盼某日能攀上高枝。\n\n今天，第一届女子科举考试终于拉开了帷幕。\n\n正可谓武周太平盛世，女子亦可为学做官！\n\n读四书五经，志修齐治平，力争当朝女状元！', '2021-11-20 13:30:36.902', '2021-11-20 13:30:36.902');
INSERT INTO `rm_goods` VALUES (69, '/goods/coverImage/1637388205843望雀.jpg', 4, '望雀', '江湖帮派霜天阁声明鹊起，其阁主夫人罗雀虽为当世神医，却因病移居望雀楼，不能自医；同月，阁主胡桓为一女子大肆操办生辰宴，广宴群侠。当夜，望雀楼突发大火，罗雀殒命其中，在场四人，究竟谁是杀害罗雀的凶手，一切真相，取决于你……', '2021-11-20 14:04:17.087', '2021-11-20 14:04:17.087');
INSERT INTO `rm_goods` VALUES (70, '/goods/coverImage/1637391286220迷影邮轮.jpg', 6, '迷影邮轮', '民国时期，上海滩名流纷纷受邀参加一场豪华游轮舞会，豪门少爷、神秘男子、留洋美少女、全能管家、当红影星、报社记者，不想，一场突如其来的谋杀案打破了粉饰的平静，谁才是真凶？你又将成为谁？周围是一片茫茫大海，凶手就在船上的乘客之中。层层阴谋之下的众人，各自隐藏了什么秘密？我们能找到真正的凶手，顺利抵达终点吗？', '2021-11-20 14:54:48.726', '2021-11-20 14:54:48.726');
INSERT INTO `rm_goods` VALUES (71, '/goods/coverImage/1637500208205孤城.jpg', 7, '商品1', '这是一段描述', '2021-11-21 21:10:36.132', '2021-11-21 21:10:36.132');

-- ----------------------------
-- Table structure for rm_goods_package
-- ----------------------------
DROP TABLE IF EXISTS `rm_goods_package`;
CREATE TABLE `rm_goods_package`  (
  `goods_id` int(11) NOT NULL COMMENT '商品ID',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '套餐名称',
  `price` decimal(10, 2) NOT NULL COMMENT '价格',
  INDEX `rm_goods_package_ibfk_1`(`goods_id`) USING BTREE,
  CONSTRAINT `rm_goods_package_ibfk_1` FOREIGN KEY (`goods_id`) REFERENCES `rm_goods` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of rm_goods_package
-- ----------------------------
INSERT INTO `rm_goods_package` VALUES (18, '基本套餐', 55.00);
INSERT INTO `rm_goods_package` VALUES (50, '基本套餐（小时）', 12.00);
INSERT INTO `rm_goods_package` VALUES (51, '基本套餐', 55.00);
INSERT INTO `rm_goods_package` VALUES (52, '基本套餐', 60.00);
INSERT INTO `rm_goods_package` VALUES (53, '基本套餐（小时）', 12.00);
INSERT INTO `rm_goods_package` VALUES (54, '基本套餐', 65.00);
INSERT INTO `rm_goods_package` VALUES (56, '基本套餐', 55.00);
INSERT INTO `rm_goods_package` VALUES (57, '基本套餐', 55.00);
INSERT INTO `rm_goods_package` VALUES (55, '基本套餐', 45.00);
INSERT INTO `rm_goods_package` VALUES (58, '基本套餐', 55.00);
INSERT INTO `rm_goods_package` VALUES (59, '基本套餐', 49.00);
INSERT INTO `rm_goods_package` VALUES (60, '基本套餐', 49.00);
INSERT INTO `rm_goods_package` VALUES (61, '基本套餐', 55.00);
INSERT INTO `rm_goods_package` VALUES (62, '基本套餐', 55.00);
INSERT INTO `rm_goods_package` VALUES (63, '基本套餐', 65.00);
INSERT INTO `rm_goods_package` VALUES (64, '基本套餐', 55.00);
INSERT INTO `rm_goods_package` VALUES (65, '基本套餐', 55.00);
INSERT INTO `rm_goods_package` VALUES (66, '基本套餐', 49.00);
INSERT INTO `rm_goods_package` VALUES (67, '基本套餐', 45.00);
INSERT INTO `rm_goods_package` VALUES (68, '基本套餐', 55.00);
INSERT INTO `rm_goods_package` VALUES (69, '基本套餐', 20.00);
INSERT INTO `rm_goods_package` VALUES (70, '基本套餐', 20.00);
INSERT INTO `rm_goods_package` VALUES (9, '基本套餐', 55.00);
INSERT INTO `rm_goods_package` VALUES (10, '基本套餐', 20.00);
INSERT INTO `rm_goods_package` VALUES (11, '基本套餐', 55.00);
INSERT INTO `rm_goods_package` VALUES (71, '基本套餐', 20.00);
INSERT INTO `rm_goods_package` VALUES (71, 'VIP套餐', 50.00);
INSERT INTO `rm_goods_package` VALUES (3, '基本套餐', 45.00);

-- ----------------------------
-- Table structure for rm_order
-- ----------------------------
DROP TABLE IF EXISTS `rm_order`;
CREATE TABLE `rm_order`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `order_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '订单号',
  `order_group` int(11) NOT NULL COMMENT '组局 ID',
  `order_time` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT '预约时间 ( YYYY-MM-dd )',
  `order_price` decimal(10, 2) NOT NULL DEFAULT 0.00 COMMENT '预约金额',
  `order_state` int(2) NOT NULL COMMENT '订单状态(0=未付款,1=已付款,2=已退款,3=已取消)',
  `user_id` int(11) NOT NULL COMMENT '对应的下单用户 ID',
  `create_time` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT '创建时间',
  `update_time` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of rm_order
-- ----------------------------
INSERT INTO `rm_order` VALUES (1, '123123123124124124', 1, '2021-04-29 00:00:00.000', 11.00, 0, 1, '2021-04-29 23:41:26.474', '2021-11-13 20:23:42.757');
INSERT INTO `rm_order` VALUES (2, '123123123124124124', 5, '2021-05-30 00:00:01.000', 11.00, 0, 2, '2021-04-29 23:41:26.474', '2021-11-19 20:51:11.946');
INSERT INTO `rm_order` VALUES (3, '123123123124124124', 5, '2021-05-10 00:00:00.000', 11.00, 0, 3, '2021-04-29 23:41:26.474', '2021-11-19 20:51:13.035');
INSERT INTO `rm_order` VALUES (4, '123123123124124124', 8, '2021-05-30 00:00:00.000', 11.00, 0, 4, '2021-10-29 23:41:26.474', '2021-11-22 21:36:32.172');
INSERT INTO `rm_order` VALUES (5, '657060406648647680', 9, '2021-11-14 00:44:34.179', 55.67, 0, 1, '2021-11-14 00:44:34.179', '2021-11-19 01:18:01.167');
INSERT INTO `rm_order` VALUES (9, '657073706191040512', 10, '2021-11-14 01:37:25.038', 55.67, 0, 1, '2021-11-14 01:37:25.038', '2021-11-19 01:18:03.129');
INSERT INTO `rm_order` VALUES (10, '659209274102394880', 2, '2021-11-19 23:03:24.102', 55.00, 0, 1, '2021-11-19 23:03:24.102', '2021-11-19 23:03:24.102');
INSERT INTO `rm_order` VALUES (11, '659805407174471680', 11, '2021-11-21 14:32:13.301', 20.00, 0, 1, '2021-11-21 14:32:13.301', '2021-11-21 14:32:13.301');
INSERT INTO `rm_order` VALUES (12, '659906348271808512', 15, '2021-11-21 21:13:19.528', 50.00, 0, 1, '2021-11-21 21:13:19.528', '2021-11-21 21:13:19.528');
INSERT INTO `rm_order` VALUES (13, '662028098619060224', 14, '2021-11-27 17:44:24.242', 55.00, 0, 1, '2021-11-27 17:44:24.242', '2021-11-27 17:44:24.242');

-- ----------------------------
-- Table structure for rm_order_group
-- ----------------------------
DROP TABLE IF EXISTS `rm_order_group`;
CREATE TABLE `rm_order_group`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `goods_id` int(11) NOT NULL,
  `room_id` int(11) NOT NULL,
  `round_id` int(11) NOT NULL,
  `package_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '套餐名称',
  `package_price` decimal(10, 2) NOT NULL COMMENT '套餐价格',
  `play_time` date NOT NULL COMMENT '预约时间',
  `create_time` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of rm_order_group
-- ----------------------------
INSERT INTO `rm_order_group` VALUES (1, 18, 1, 1, '套餐123', 55.67, '2021-10-11', '2021-10-18 23:21:58.000');
INSERT INTO `rm_order_group` VALUES (2, 3, 1, 2, '套餐1', 55.00, '2021-11-19', '2021-10-19 00:59:36.574');
INSERT INTO `rm_order_group` VALUES (5, 3, 2, 2, '基本套餐', 55.00, '2021-10-25', '2021-10-25 18:49:48.045');
INSERT INTO `rm_order_group` VALUES (8, 18, 8, 2, '套餐123', 55.67, '2021-10-11', '2021-10-27 00:13:59.211');
INSERT INTO `rm_order_group` VALUES (9, 9, 8, 4, '套餐123', 55.67, '2021-10-11', '2021-10-27 00:20:58.996');
INSERT INTO `rm_order_group` VALUES (10, 9, 2, 4, '套餐123', 55.67, '2021-10-11', '2021-10-27 00:21:20.320');
INSERT INTO `rm_order_group` VALUES (11, 69, 8, 1, '基本套餐', 20.00, '2021-11-21', '2021-11-21 14:20:07.841');
INSERT INTO `rm_order_group` VALUES (12, 59, 2, 2, '基本套餐', 49.00, '2021-11-21', '2021-11-21 14:20:25.659');
INSERT INTO `rm_order_group` VALUES (13, 51, 1, 2, '基本套餐', 55.00, '2021-11-21', '2021-11-21 14:20:38.505');
INSERT INTO `rm_order_group` VALUES (14, 57, 1, 1, '基本套餐', 55.00, '2021-11-27', '2021-11-21 15:30:59.392');
INSERT INTO `rm_order_group` VALUES (15, 71, 1, 1, 'VIP套餐', 50.00, '2021-11-24', '2021-11-21 21:12:02.640');

-- ----------------------------
-- Table structure for rm_permissions
-- ----------------------------
DROP TABLE IF EXISTS `rm_permissions`;
CREATE TABLE `rm_permissions`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `label` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '权限名称',
  `value` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '权限值',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of rm_permissions
-- ----------------------------
INSERT INTO `rm_permissions` VALUES (1, '主控台', 'dashboard_console');
INSERT INTO `rm_permissions` VALUES (2, '商品列表', 'goods_list');
INSERT INTO `rm_permissions` VALUES (3, '商品列表添加', 'goods_add');
INSERT INTO `rm_permissions` VALUES (4, '商品列表修改', 'goods_edit');
INSERT INTO `rm_permissions` VALUES (5, '商列表删除', 'goods_delete');
INSERT INTO `rm_permissions` VALUES (6, '组局列表添加', 'order_group_add');
INSERT INTO `rm_permissions` VALUES (7, '组列表修改', 'order_group_edit');
INSERT INTO `rm_permissions` VALUES (8, '组列表删除', 'order_group_delete');
INSERT INTO `rm_permissions` VALUES (9, '房间列表添加', 'room_add');
INSERT INTO `rm_permissions` VALUES (10, '房间列表修改', 'room_edit');
INSERT INTO `rm_permissions` VALUES (11, '房间列表删除', 'room_delete');
INSERT INTO `rm_permissions` VALUES (12, '场次列表添加', 'round_add');
INSERT INTO `rm_permissions` VALUES (13, '场次列表修改', 'round_edit');
INSERT INTO `rm_permissions` VALUES (14, '场次列表删除', 'round_delete');

-- ----------------------------
-- Table structure for rm_resource
-- ----------------------------
DROP TABLE IF EXISTS `rm_resource`;
CREATE TABLE `rm_resource`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '地址',
  `target_type` int(11) NOT NULL COMMENT '类型',
  `target_id` int(11) NULL DEFAULT NULL COMMENT '类型对应ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 63 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of rm_resource
-- ----------------------------
INSERT INTO `rm_resource` VALUES (29, '1635673043048c7fac52864.jpg', 1, NULL);
INSERT INTO `rm_resource` VALUES (33, '1636291088569校规.jpg', 1, 18);
INSERT INTO `rm_resource` VALUES (34, '1636291225274爱幼.jpg', 1, 11);
INSERT INTO `rm_resource` VALUES (35, '1636291357584星火号.png', 1, 10);
INSERT INTO `rm_resource` VALUES (36, '1636291438306舍离2.jpg', 1, 9);
INSERT INTO `rm_resource` VALUES (37, '1636291482330宿醉.jpg', 1, 3);
INSERT INTO `rm_resource` VALUES (38, '16373354789161624621546129.jpg', 1, NULL);
INSERT INTO `rm_resource` VALUES (39, '1637335553846pj80x80.jpg', 1, NULL);
INSERT INTO `rm_resource` VALUES (40, '1637336004583雾鸦馆.jpg', 1, 50);
INSERT INTO `rm_resource` VALUES (41, '1637336172561一点半.jpg', 1, 51);
INSERT INTO `rm_resource` VALUES (42, '1637338427106校规2.jpg', 1, 52);
INSERT INTO `rm_resource` VALUES (43, '1637338574741七个密室.jpg', 1, 53);
INSERT INTO `rm_resource` VALUES (44, '1637338767581年轮.jpg', 1, 54);
INSERT INTO `rm_resource` VALUES (45, '1637338977342前男友的一百种死法.jpg', 1, 55);
INSERT INTO `rm_resource` VALUES (46, '1637339651581舍离2.jpg', 1, NULL);
INSERT INTO `rm_resource` VALUES (47, '1637339765019舍离2.jpg', 1, NULL);
INSERT INTO `rm_resource` VALUES (48, '1637341476239孤城.jpg', 1, 56);
INSERT INTO `rm_resource` VALUES (49, '1637341579031拆迁.jpg', 1, 57);
INSERT INTO `rm_resource` VALUES (50, '1637382591330鸢飞戾天.jpg', 1, 58);
INSERT INTO `rm_resource` VALUES (51, '1637384511515那时的我们.jpg', 1, 59);
INSERT INTO `rm_resource` VALUES (52, '1637384921687别来无恙.jpg', 1, 60);
INSERT INTO `rm_resource` VALUES (53, '1637385043941瘆.jpg', 1, 61);
INSERT INTO `rm_resource` VALUES (54, '1637385168851古木吟.jpg', 1, 62);
INSERT INTO `rm_resource` VALUES (55, '1637385295202野の蔷薇.jpg', 1, 63);
INSERT INTO `rm_resource` VALUES (56, '1637385464853青楼.jpg', 1, 64);
INSERT INTO `rm_resource` VALUES (57, '1637385757406艺妓回忆录.jpg', 1, 65);
INSERT INTO `rm_resource` VALUES (58, '1637385936689窗边的女人.jpg', 1, 66);
INSERT INTO `rm_resource` VALUES (59, '1637386118044来自乡下的你.jpg', 1, 67);
INSERT INTO `rm_resource` VALUES (60, '1637386209822金玉良缘.jpg', 1, 68);
INSERT INTO `rm_resource` VALUES (61, '1637388205843望雀.jpg', 1, 69);
INSERT INTO `rm_resource` VALUES (62, '1637391286220迷影邮轮.jpg', 1, 70);
INSERT INTO `rm_resource` VALUES (63, '1637500208205孤城.jpg', 1, 71);

-- ----------------------------
-- Table structure for rm_role
-- ----------------------------
DROP TABLE IF EXISTS `rm_role`;
CREATE TABLE `rm_role`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `rolename` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '角色名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of rm_role
-- ----------------------------
INSERT INTO `rm_role` VALUES (1, 'user');
INSERT INTO `rm_role` VALUES (2, 'admin');

-- ----------------------------
-- Table structure for rm_room
-- ----------------------------
DROP TABLE IF EXISTS `rm_room`;
CREATE TABLE `rm_room`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '房间名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of rm_room
-- ----------------------------
INSERT INTO `rm_room` VALUES (1, '二楼');
INSERT INTO `rm_room` VALUES (2, '三楼');
INSERT INTO `rm_room` VALUES (8, '四楼');

-- ----------------------------
-- Table structure for rm_round
-- ----------------------------
DROP TABLE IF EXISTS `rm_round`;
CREATE TABLE `rm_round`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '场次名称',
  `start_time` time NULL DEFAULT NULL COMMENT '开始时间',
  `end_time` time NULL DEFAULT NULL COMMENT '结束时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of rm_round
-- ----------------------------
INSERT INTO `rm_round` VALUES (1, '下午场', '14:00:00', '18:00:00');
INSERT INTO `rm_round` VALUES (2, '晚上场', '19:00:00', '22:00:00');
INSERT INTO `rm_round` VALUES (4, '深夜场', '00:00:00', '04:00:00');
INSERT INTO `rm_round` VALUES (11, '上午场', '07:00:00', '12:00:00');

-- ----------------------------
-- Table structure for rm_user
-- ----------------------------
DROP TABLE IF EXISTS `rm_user`;
CREATE TABLE `rm_user`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `username` varchar(24) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户名，唯一',
  `nickname` varchar(24) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户昵称',
  `avatar` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '头像url',
  `email` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `create_time` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT '创建时间',
  `update_time` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '更新时间',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of rm_user
-- ----------------------------
INSERT INTO `rm_user` VALUES (1, 'pj', 'Blade', NULL, NULL, '2021-04-05 02:47:14.985', '2021-11-18 00:49:14.260', '$2a$10$Y0JdXzx.D6Go2XVIlj48N.XIxzUdySvxIGMaapqTqgVhALcE.KxVK');
INSERT INTO `rm_user` VALUES (2, 'pj1', 'Blade1', NULL, NULL, '2021-11-15 00:13:58.138', '2021-11-15 00:13:58.138', '$2a$10$Mx86Ze4w3ccRPW2UhCT4webrXvkBb4p4gw3grVOeN6QSJlgVUvX.q');
INSERT INTO `rm_user` VALUES (3, 'pj2', 'Blade2s', NULL, NULL, '2021-11-15 00:14:09.901', '2021-11-15 00:14:09.901', '$2a$10$wc/ahFY/DklE.bI9luEHU.udiDndJSpi0G2EzpZ5390a6.Fcm6nBu');
INSERT INTO `rm_user` VALUES (4, 'user', 'users', NULL, NULL, '2021-11-18 00:24:16.556', '2021-11-18 00:24:16.556', '$2a$10$0bLuhwDDjSjrSou0RgQ2eecUU128fTwXgCqyQ9BkjMHlcIEKtT0wK');

-- ----------------------------
-- Table structure for rm_views
-- ----------------------------
DROP TABLE IF EXISTS `rm_views`;
CREATE TABLE `rm_views`  (
  `views` bigint(20) NULL DEFAULT 0 COMMENT '浏览量',
  `view_date` date NULL DEFAULT NULL COMMENT '浏览日'
) ENGINE = MyISAM AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Fixed;

-- ----------------------------
-- Records of rm_views
-- ----------------------------
INSERT INTO `rm_views` VALUES (10, '2021-11-20');
INSERT INTO `rm_views` VALUES (0, '2021-11-19');
INSERT INTO `rm_views` VALUES (0, '2021-11-18');
INSERT INTO `rm_views` VALUES (1, '2021-11-21');
INSERT INTO `rm_views` VALUES (30, '2021-11-22');
INSERT INTO `rm_views` VALUES (0, '2021-11-23');
INSERT INTO `rm_views` VALUES (26, '2021-11-27');
INSERT INTO `rm_views` VALUES (13, '2021-11-26');
INSERT INTO `rm_views` VALUES (1, '2021-11-30');
INSERT INTO `rm_views` VALUES (1, '2021-11-29');

-- ----------------------------
-- View structure for rm_order_group_player
-- ----------------------------
DROP VIEW IF EXISTS `rm_order_group_player`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `rm_order_group_player` AS select `og`.`id` AS `id`,`g`.`name` AS `goods_name`,`g`.`cover_img` AS `cover_img`,`g`.`play_num` AS `play_num`,`rm`.`name` AS `room_name`,`rd`.`name` AS `round_name`,`og`.`package_name` AS `package_name`,`og`.`package_price` AS `package_price`,`og`.`play_time` AS `play_time`,`og`.`create_time` AS `create_time`,ifnull(`player`.`player_num`,0) AS `players` from ((((`rm_order_group` `og` left join (select `o`.`order_group` AS `order_group`,count(`o`.`order_group`) AS `player_num` from `rm_order` `o` group by `o`.`order_group`) `player` on((`player`.`order_group` = `og`.`id`))) join `rm_goods` `g`) join `rm_room` `rm`) join `rm_round` `rd`) where ((`og`.`goods_id` = `g`.`id`) and (`og`.`room_id` = `rm`.`id`) and (`og`.`round_id` = `rd`.`id`));

SET FOREIGN_KEY_CHECKS = 1;
