/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 80018
Source Host           : localhost:3306
Source Database       : equipment

Target Server Type    : MYSQL
Target Server Version : 80018
File Encoding         : 65001

Date: 2022-03-31 20:57:41
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for bus_customer
-- ----------------------------
DROP TABLE IF EXISTS `bus_customer`;
CREATE TABLE `bus_customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `customername` varchar(255) DEFAULT NULL,
  `zip` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  `connectionpersion` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `bank` varchar(255) DEFAULT NULL,
  `account` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `fax` varchar(255) DEFAULT NULL,
  `available` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of bus_customer
-- ----------------------------
INSERT INTO `bus_customer` VALUES ('1', '小张', '111', '武汉', '027-9123131', '张大明', '15279230588', '中国银行', '654431331343413', '213123@sina.com', '430000', '1');
INSERT INTO `bus_customer` VALUES ('2', '小明', '222', '深圳', '0755-9123131', '张小明', '13064154936', '中国银行', '654431331343413', '213123@sina.com', '430000', '1');
INSERT INTO `bus_customer` VALUES ('3', '快七', '430000', '武汉', '027-11011011', '雷生', '13617020687', '招商银行', '6543123341334133', '6666@66.com', '545341', '1');
INSERT INTO `bus_customer` VALUES ('4', '丽云', '332005', '十里大道1039号', '0792-13658745', '射可可', '13648524759', '建设银行', '36245684125509', '13648524759@163.com', '152632', '1');
INSERT INTO `bus_customer` VALUES ('8', '寻鲁', '234234', '撒旦法', '234', '地方', '1234', '是否', '234234', '123123@23', '213', '1');
INSERT INTO `bus_customer` VALUES ('11', 'asdf', 'afs', 'afsd', '123', 'dfs', '123', 'd sfd', '35234', 'q21341', '123', '1');
INSERT INTO `bus_customer` VALUES ('12', '小明', '222', '深圳', '13064154936', '张小明', '13064154936', '中国银行', '123456789', '123456789@163.com', '123456', '1');

-- ----------------------------
-- Table structure for bus_goods
-- ----------------------------
DROP TABLE IF EXISTS `bus_goods`;
CREATE TABLE `bus_goods` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `goodsname` varchar(255) DEFAULT NULL,
  `providerid` int(11) DEFAULT NULL,
  `produceplace` varchar(255) DEFAULT NULL,
  `size` varchar(255) DEFAULT NULL,
  `goodspackage` varchar(255) DEFAULT NULL,
  `productcode` varchar(255) DEFAULT NULL,
  `promitcode` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `number` int(11) DEFAULT NULL,
  `dangernum` int(11) DEFAULT NULL,
  `goodsimg` varchar(255) DEFAULT NULL,
  `available` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `FK_sq0btr2v2lq8gt8b4gb8tlk0i` (`providerid`) USING BTREE,
  CONSTRAINT `bus_goods_ibfk_1` FOREIGN KEY (`providerid`) REFERENCES `bus_provider` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of bus_goods
-- ----------------------------
INSERT INTO `bus_goods` VALUES ('1', '樱桃', '3', '武汉', '120ML', '瓶', 'PH12345', 'PZ1234', '小孩子都爱的', '2', '473', '10', '2020-02-24/99F329D96E06449E9A5D613B1D3FA7DD.jpg', '1');
INSERT INTO `bus_goods` VALUES ('2', '车厘子', '1', '仙桃', '包', '袋', 'PH12312312', 'PZ12312', '好吃不上火', '4', '1090', '10', '2020-01-21/625C047E6A934D9FA5C611BB7D93CD8F.jpg', '1');
INSERT INTO `bus_goods` VALUES ('3', '跑步机', '1', '仙桃', '盒', '盒', '11', '11', '111', '28', '1271', '100', '2020-01-21/8F743D2038D747878B02C0E2183823A6.jpg', '1');
INSERT INTO `bus_goods` VALUES ('4', '娃哈哈', '3', '武汉', '200ML', '瓶', '11', '111', '12321', '3', '760', '10', '2020-01-21/B1B4C7D489EB43E5B662E8E92A6A5180.jpg', '1');
INSERT INTO `bus_goods` VALUES ('5', '花露水', '3', '武汉', '300ML', '瓶', '1234', '12321', '22221111', '3', '1000', '100', '2020-01-21/BAF8B804591942F2AEF43E6BE25934DD.jpg', '1');
INSERT INTO `bus_goods` VALUES ('6', '水杯', '4', '内蒙古', '件数', '件', 'SD13156146', '321651613', '密封件', '55', '100', '20', '2020-01-21/F0BC1EBC2BFA4497BDF8B9254BA59511.jpg', '1');
INSERT INTO `bus_goods` VALUES ('18', '热水壶', '3', '广州', '箱', '15', 'DFS234341231', 'DF123124324', '叉车', '4', '500', '100', '2020-11-26/594F0D97537B45309CC86ABB810AE228.jpg', '1');
INSERT INTO `bus_goods` VALUES ('19', '空调', '1', '11', '11', '11', '11', '11', '1111', '11', '22', '11', '2021-02-03/21E4E74273FF43BA8CD668E3FA05279C.jpg', '1');

-- ----------------------------
-- Table structure for bus_inport
-- ----------------------------
DROP TABLE IF EXISTS `bus_inport`;
CREATE TABLE `bus_inport` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `paytype` varchar(255) DEFAULT NULL,
  `inporttime` datetime DEFAULT NULL,
  `operateperson` varchar(255) DEFAULT NULL,
  `number` int(11) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `inportprice` double DEFAULT NULL,
  `providerid` int(11) DEFAULT NULL,
  `goodsid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `bus_inport_ibfk_1` (`providerid`) USING BTREE,
  KEY `bus_inport_ibfk_2` (`goodsid`) USING BTREE,
  CONSTRAINT `bus_inport_ibfk_1` FOREIGN KEY (`providerid`) REFERENCES `bus_provider` (`id`),
  CONSTRAINT `bus_inport_ibfk_2` FOREIGN KEY (`goodsid`) REFERENCES `bus_goods` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of bus_inport
-- ----------------------------
INSERT INTO `bus_inport` VALUES ('1', '微信', '2022-03-26 09:33:41', '张三', '100', '备注', '3.5', '1', '1');
INSERT INTO `bus_inport` VALUES ('2', '支付宝', '2022-03-26 09:33:41', '张三', '1000', '无', '2.5', '3', '3');
INSERT INTO `bus_inport` VALUES ('3', '银联', '2022-03-26 09:33:41', '张三', '100', '1231', '111', '3', '3');
INSERT INTO `bus_inport` VALUES ('4', '银联', '2022-03-26 09:33:41', '张三', '1000', '无', '2', '3', '1');
INSERT INTO `bus_inport` VALUES ('5', '银联', '2022-03-26 09:33:41', '张三', '100', '无', '1', '3', '1');
INSERT INTO `bus_inport` VALUES ('6', '银联', '2022-03-26 09:33:41', '张三', '100', '1231', '2.5', '1', '2');
INSERT INTO `bus_inport` VALUES ('8', '支付宝', '2022-03-26 09:33:41', '张三', '100', '', '1', '3', '1');
INSERT INTO `bus_inport` VALUES ('10', '支付宝', '2022-03-26 09:33:41', '超级管理员', '100', 'sadfasfdsa', '1.5', '3', '1');
INSERT INTO `bus_inport` VALUES ('11', '支付宝', '2022-03-26 09:33:41', '超级管理员', '21', '21', '21', '1', '3');
INSERT INTO `bus_inport` VALUES ('12', '微信', '2022-03-26 09:33:41', '超级管理员', '100', '123213213', '12321321', '3', '1');
INSERT INTO `bus_inport` VALUES ('13', '微信', '2022-03-26 09:33:41', '超级管理员', '11', '11111', '190', '1', '19');
INSERT INTO `bus_inport` VALUES ('14', '支付宝', '2022-03-26 09:33:41', '超级管理员', '250', '250', '3.5', '1', '3');

-- ----------------------------
-- Table structure for bus_outport
-- ----------------------------
DROP TABLE IF EXISTS `bus_outport`;
CREATE TABLE `bus_outport` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `providerid` int(11) DEFAULT NULL,
  `paytype` varchar(255) DEFAULT NULL,
  `outputtime` datetime DEFAULT NULL,
  `operateperson` varchar(255) DEFAULT NULL,
  `outportprice` double(10,2) DEFAULT NULL,
  `number` int(11) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `goodsid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of bus_outport
-- ----------------------------
INSERT INTO `bus_outport` VALUES ('2', '3', '微信', '2022-03-26 09:33:41', '超级管理员', '12321321.00', '11', '11', '1');

-- ----------------------------
-- Table structure for bus_provider
-- ----------------------------
DROP TABLE IF EXISTS `bus_provider`;
CREATE TABLE `bus_provider` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `providername` varchar(255) DEFAULT NULL,
  `zip` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  `connectionperson` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `bank` varchar(255) DEFAULT NULL,
  `account` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `fax` varchar(255) DEFAULT NULL,
  `available` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of bus_provider
-- ----------------------------
INSERT INTO `bus_provider` VALUES ('1', '厂商A', '434000', '仙桃', '0728-4124312', '小明', '13413441141', '中国农业银行', '654124345131', '12312321@sina.com', '5123123', '1');
INSERT INTO `bus_provider` VALUES ('2', '厂商B', '430000', '汉川', '0728-4124312', '大明', '13413441141', '中国农业银行', '654124345131', '12312321@sina.com', '5123123', '1');
INSERT INTO `bus_provider` VALUES ('3', '厂商C', '513131', '杭州', '21312', '小晨', '12312', '建设银行', '512314141541', '123131', '312312', '1');
INSERT INTO `bus_provider` VALUES ('4', '厂商D', '332005', '内蒙古', '0790-362514856', '姿态', '13617252689', '中国银行', '36214587962509', '13617252689@163.com', '364145', '1');
INSERT INTO `bus_provider` VALUES ('5', '厂商E', '562115', '内蒙古', '0792-36548569', 'Rita', '13698560566', '建设银行', '3621458963596509', '13698560566@163.com', '362514', '1');
INSERT INTO `bus_provider` VALUES ('12', '厂商F', '123', 'sdf', '123', 'sda', '123', '123', '123', '132', '213', '1');

-- ----------------------------
-- Table structure for bus_sales
-- ----------------------------
DROP TABLE IF EXISTS `bus_sales`;
CREATE TABLE `bus_sales` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `customerid` int(11) DEFAULT NULL,
  `paytype` varchar(255) DEFAULT NULL,
  `salestime` datetime DEFAULT NULL,
  `operateperson` varchar(255) DEFAULT NULL,
  `number` int(11) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `saleprice` decimal(10,2) DEFAULT NULL,
  `goodsid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of bus_sales
-- ----------------------------
INSERT INTO `bus_sales` VALUES ('1', '4', '支付宝', '2022-03-26 08:19:50', '落亦-', '15', '士大夫士大夫', '60.00', '1');
INSERT INTO `bus_sales` VALUES ('2', '8', '支付宝', '2022-03-26 08:19:50', '落亦-', '10', '萨的发生地方', '100.00', '2');

-- ----------------------------
-- Table structure for bus_salesback
-- ----------------------------
DROP TABLE IF EXISTS `bus_salesback`;
CREATE TABLE `bus_salesback` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `customerid` int(11) DEFAULT NULL,
  `paytype` varchar(255) DEFAULT NULL,
  `salesbacktime` datetime DEFAULT NULL,
  `salebackprice` double(10,2) DEFAULT NULL,
  `operateperson` varchar(255) DEFAULT NULL,
  `number` int(11) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `goodsid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of bus_salesback
-- ----------------------------
INSERT INTO `bus_salesback` VALUES ('1', '8', '支付宝', '2022-03-26 08:19:50', '100.00', '落亦-', '20', '过期了', '2');
INSERT INTO `bus_salesback` VALUES ('4', '4', '支付宝', '2022-03-26 08:19:50', '60.00', '落亦-', '5', 'sdf', '1');

-- ----------------------------
-- Table structure for sys_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pid` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `open` int(11) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `available` int(11) DEFAULT NULL COMMENT '状态【0不可用1可用】',
  `ordernum` int(11) DEFAULT NULL COMMENT '排序码【为了调试显示顺序】',
  `createtime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of sys_dept
-- ----------------------------
INSERT INTO `sys_dept` VALUES ('1', '0', '总经办', '1', '大BOSS', '深圳', '1', '1', '2022-03-26 08:19:50');
INSERT INTO `sys_dept` VALUES ('2', '1', '销售部', '0', '程序员', '武汉', '1', '2', '2022-03-26 08:19:50');
INSERT INTO `sys_dept` VALUES ('3', '1', '运营部', '0', '无', '武汉', '1', '3', '2022-03-26 08:19:50');
INSERT INTO `sys_dept` VALUES ('4', '1', '生产部', '0', '无', '武汉', '1', '4', '2022-03-26 08:19:50');
INSERT INTO `sys_dept` VALUES ('5', '2', '销售一部', '0', '销售一部', '武汉', '1', '5', '2022-03-26 08:19:50');

-- ----------------------------
-- Table structure for sys_loginfo
-- ----------------------------
DROP TABLE IF EXISTS `sys_loginfo`;
CREATE TABLE `sys_loginfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `loginname` varchar(255) DEFAULT NULL,
  `loginip` varchar(255) DEFAULT NULL,
  `logintime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=325 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of sys_loginfo
-- ----------------------------
INSERT INTO `sys_loginfo` VALUES ('322', '超级管理员-admin', '0:0:0:0:0:0:0:1', '2022-03-30 13:28:48');
INSERT INTO `sys_loginfo` VALUES ('323', '超级管理员-admin', '0:0:0:0:0:0:0:1', '2022-03-30 13:36:16');
INSERT INTO `sys_loginfo` VALUES ('324', '超级管理员-admin', '0:0:0:0:0:0:0:1', '2022-03-30 14:02:44');

-- ----------------------------
-- Table structure for sys_notice
-- ----------------------------
DROP TABLE IF EXISTS `sys_notice`;
CREATE TABLE `sys_notice` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `content` text,
  `createtime` datetime DEFAULT NULL,
  `opername` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of sys_notice
-- ----------------------------
INSERT INTO `sys_notice` VALUES ('57', '111', '1111', '2022-03-26 08:19:50', '超级管理员');

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pid` int(11) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL COMMENT '权限类型[menu/permission]',
  `title` varchar(255) DEFAULT NULL,
  `percode` varchar(255) DEFAULT NULL COMMENT '权限编码[只有type= permission才有  user:view]',
  `icon` varchar(255) DEFAULT NULL,
  `href` varchar(255) DEFAULT NULL,
  `target` varchar(255) DEFAULT NULL,
  `open` int(11) DEFAULT NULL,
  `ordernum` int(11) DEFAULT NULL,
  `available` int(11) DEFAULT NULL COMMENT '状态【0不可用1可用】',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=130 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of sys_permission
-- ----------------------------
INSERT INTO `sys_permission` VALUES ('1', '0', 'menu', '零售配送中心MIS', null, '&#xe68e;', '', '', '1', '1', '1');
INSERT INTO `sys_permission` VALUES ('2', '1', 'menu', '配送客户管理', null, '&#xe857;', '', '', '0', '1', '1');
INSERT INTO `sys_permission` VALUES ('3', '1', 'menu', '供应商管理', null, '&#xe645;', '', '', '0', '3', '1');
INSERT INTO `sys_permission` VALUES ('4', '1', 'menu', '配送管理', null, '&#xe611;', '', '', '0', '4', '1');
INSERT INTO `sys_permission` VALUES ('7', '2', 'menu', '配送客户管理', null, '&#xe651;', '/bus/toCustomerManager', '', '0', '7', '1');
INSERT INTO `sys_permission` VALUES ('8', '3', 'menu', '供应商管理', null, '&#xe658;', '/bus/toProviderManager', '', '0', '8', '1');
INSERT INTO `sys_permission` VALUES ('9', '125', 'menu', '商品管理', null, '&#xe657;', '/bus/toGoodsManager', '', '0', '2', '1');
INSERT INTO `sys_permission` VALUES ('10', '125', 'menu', '商品进货', null, '&#xe756;', '/bus/toInportManager', '', '0', '10', '1');
INSERT INTO `sys_permission` VALUES ('11', '125', 'menu', '配送退货查询', null, '&#xe65a;', '/bus/toOutportManager', '', '0', '11', '1');
INSERT INTO `sys_permission` VALUES ('12', '4', 'menu', '商品配送', null, '&#xe65b;', '/bus/toSalesManager', '', '0', '12', '1');
INSERT INTO `sys_permission` VALUES ('13', '4', 'menu', '配送退货查询', null, '&#xe770;', '/bus/toSalesbackManager', '', '0', '13', '1');
INSERT INTO `sys_permission` VALUES ('14', '126', 'menu', '部门管理', null, '&#xe770;', '/sys/toDeptManager', '', '0', '14', '1');
INSERT INTO `sys_permission` VALUES ('15', '127', 'menu', '菜单管理', null, '&#xe663;', '/sys/toMenuManager', '', '0', '15', '1');
INSERT INTO `sys_permission` VALUES ('16', '127', 'menu', '权限管理', '', '&#xe857;', '/sys/toPermissionManager', '', '0', '16', '1');
INSERT INTO `sys_permission` VALUES ('17', '127', 'menu', '角色管理', '', '&#xe650;', '/sys/toRoleManager', '', '0', '17', '1');
INSERT INTO `sys_permission` VALUES ('18', '127', 'menu', '用户管理', '', '&#xe612;', '/sys/toUserManager', '', '0', '18', '1');
INSERT INTO `sys_permission` VALUES ('21', '127', 'menu', '登陆日志', null, '&#xe675;', '/sys/toLoginfoManager', '', '0', '21', '1');
INSERT INTO `sys_permission` VALUES ('22', '127', 'menu', '系统公告', null, '&#xe756;', '/sys/toNoticeManager', '', '0', '22', '1');
INSERT INTO `sys_permission` VALUES ('23', '127', 'menu', '图标管理', null, '&#xe670;', '../resources/page/icon.html', '', '0', '23', '1');
INSERT INTO `sys_permission` VALUES ('30', '14', 'permission', '添加部门', 'dept:create', '', null, null, '0', '24', '1');
INSERT INTO `sys_permission` VALUES ('31', '14', 'permission', '修改部门', 'dept:update', '', null, null, '0', '26', '1');
INSERT INTO `sys_permission` VALUES ('32', '14', 'permission', '删除部门', 'dept:delete', '', null, null, '0', '27', '1');
INSERT INTO `sys_permission` VALUES ('34', '15', 'permission', '添加菜单', 'menu:create', '', '', '', '0', '29', '1');
INSERT INTO `sys_permission` VALUES ('35', '15', 'permission', '修改菜单', 'menu:update', '', null, null, '0', '30', '1');
INSERT INTO `sys_permission` VALUES ('36', '15', 'permission', '删除菜单', 'menu:delete', '', null, null, '0', '31', '1');
INSERT INTO `sys_permission` VALUES ('38', '16', 'permission', '添加权限', 'permission:create', '', null, null, '0', '33', '1');
INSERT INTO `sys_permission` VALUES ('39', '16', 'permission', '修改权限', 'permission:update', '', null, null, '0', '34', '1');
INSERT INTO `sys_permission` VALUES ('40', '16', 'permission', '删除权限', 'permission:delete', '', null, null, '0', '35', '1');
INSERT INTO `sys_permission` VALUES ('42', '17', 'permission', '添加角色', 'role:create', '', null, null, '0', '37', '1');
INSERT INTO `sys_permission` VALUES ('43', '17', 'permission', '修改角色', 'role:update', '', null, null, '0', '38', '1');
INSERT INTO `sys_permission` VALUES ('44', '17', 'permission', '删除角色', 'role:delete', '', null, null, '0', '39', '1');
INSERT INTO `sys_permission` VALUES ('46', '17', 'permission', '分配权限', 'role:selectPermission', '', null, null, '0', '41', '1');
INSERT INTO `sys_permission` VALUES ('47', '18', 'permission', '添加用户', 'user:create', '', null, null, '0', '42', '1');
INSERT INTO `sys_permission` VALUES ('48', '18', 'permission', '修改用户', 'user:update', '', null, null, '0', '43', '1');
INSERT INTO `sys_permission` VALUES ('49', '18', 'permission', '删除用户', 'user:delete', '', null, null, '0', '44', '1');
INSERT INTO `sys_permission` VALUES ('51', '18', 'permission', '用户分配角色', 'user:selectRole', '', null, null, '0', '46', '1');
INSERT INTO `sys_permission` VALUES ('52', '18', 'permission', '重置密码', 'user:resetPwd', null, null, null, '0', '47', '1');
INSERT INTO `sys_permission` VALUES ('53', '14', 'permission', '部门查询', 'dept:view', null, null, null, '0', '48', '1');
INSERT INTO `sys_permission` VALUES ('54', '15', 'permission', '菜单查询', 'menu:view', null, null, null, '0', '49', '1');
INSERT INTO `sys_permission` VALUES ('55', '16', 'permission', '权限查询', 'permission:view', null, null, null, '0', '50', '1');
INSERT INTO `sys_permission` VALUES ('56', '17', 'permission', '角色查询', 'role:view', null, null, null, '0', '51', '1');
INSERT INTO `sys_permission` VALUES ('57', '18', 'permission', '用户查询', 'user:view', null, null, null, '0', '52', '1');
INSERT INTO `sys_permission` VALUES ('68', '7', 'permission', '客户查询', 'customer:view', null, null, null, null, '60', '1');
INSERT INTO `sys_permission` VALUES ('69', '7', 'permission', '客户添加', 'customer:create', null, null, null, null, '61', '1');
INSERT INTO `sys_permission` VALUES ('70', '7', 'permission', '客户修改', 'customer:update', null, null, null, null, '62', '1');
INSERT INTO `sys_permission` VALUES ('71', '7', 'permission', '客户删除', 'customer:delete', null, null, null, null, '63', '1');
INSERT INTO `sys_permission` VALUES ('73', '21', 'permission', '日志查询', 'info:view', null, null, null, null, '65', '1');
INSERT INTO `sys_permission` VALUES ('74', '21', 'permission', '日志删除', 'info:delete', null, null, null, null, '66', '1');
INSERT INTO `sys_permission` VALUES ('75', '21', 'permission', '日志批量删除', 'info:batchdelete', null, null, null, null, '67', '1');
INSERT INTO `sys_permission` VALUES ('76', '22', 'permission', '公告查询', 'notice:view', null, null, null, null, '68', '1');
INSERT INTO `sys_permission` VALUES ('77', '22', 'permission', '公告添加', 'notice:create', null, null, null, null, '69', '1');
INSERT INTO `sys_permission` VALUES ('78', '22', 'permission', '公告修改', 'notice:update', null, null, null, null, '70', '1');
INSERT INTO `sys_permission` VALUES ('79', '22', 'permission', '公告删除', 'notice:delete', null, null, null, null, '71', '1');
INSERT INTO `sys_permission` VALUES ('81', '8', 'permission', '供应商查询', 'provider:view', null, null, null, null, '73', '1');
INSERT INTO `sys_permission` VALUES ('82', '8', 'permission', '供应商添加', 'provider:create', null, null, null, null, '74', '1');
INSERT INTO `sys_permission` VALUES ('83', '8', 'permission', '供应商修改', 'provider:update', null, null, null, null, '75', '1');
INSERT INTO `sys_permission` VALUES ('84', '8', 'permission', '供应商删除', 'provider:delete', null, null, null, null, '76', '1');
INSERT INTO `sys_permission` VALUES ('86', '22', 'permission', '公告查看', 'notice:viewnotice', null, null, null, null, '78', '1');
INSERT INTO `sys_permission` VALUES ('91', '9', 'permission', '商品查询', 'goods:view', null, null, null, '0', '79', '1');
INSERT INTO `sys_permission` VALUES ('92', '9', 'permission', '商品添加', 'goods:create', null, null, null, '0', '80', '1');
INSERT INTO `sys_permission` VALUES ('116', '9', 'permission', '商品删除', 'goods:delete', null, null, null, '0', '84', '1');
INSERT INTO `sys_permission` VALUES ('117', '9', 'permission', '商品修改', 'goods:update', null, null, null, '0', '85', '1');
INSERT INTO `sys_permission` VALUES ('118', '9', 'permission', '商品查询', 'goods:view', null, null, null, '0', '86', '1');
INSERT INTO `sys_permission` VALUES ('119', '22', 'permission', '公告批量删除', 'notice:batchdelete', null, null, null, '0', '87', '1');
INSERT INTO `sys_permission` VALUES ('122', '127', 'menu', '缓存管理', null, '&#xe630', '/sys/toCacheManager', '_black', '0', '88', '1');
INSERT INTO `sys_permission` VALUES ('123', '122', 'permission', '同步缓存', 'cache:syncCache', null, null, null, '0', '89', '1');
INSERT INTO `sys_permission` VALUES ('124', '122', 'permission', '清空缓存', 'cache:removeAllCache', null, null, null, '0', '90', '1');
INSERT INTO `sys_permission` VALUES ('125', '1', 'menu', '商品管理', null, '&#xe657;', '', '', '0', '91', '1');
INSERT INTO `sys_permission` VALUES ('126', '1', 'menu', '部门管理', null, '&#xe663;', '', '', '0', '92', '1');
INSERT INTO `sys_permission` VALUES ('127', '1', 'menu', '系统管理', null, '&#xe612;', '', '', '0', '93', '1');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `available` int(11) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '超级管理员', '拥有所有菜单权限', '1', '2022-03-26 08:19:50');
INSERT INTO `sys_role` VALUES ('4', '基础数据管理员', '基础数据管理员', '1', '2022-03-26 08:19:50');
INSERT INTO `sys_role` VALUES ('6', '销售管理员', '销售管理员', '1', '2022-03-26 08:19:50');
INSERT INTO `sys_role` VALUES ('8', '系统管理员', '管理所有的系统设置', '1', '2022-03-26 08:19:50');
INSERT INTO `sys_role` VALUES ('10', '测试', '测试', '1', '2022-03-26 08:19:50');
INSERT INTO `sys_role` VALUES ('11', '设备管理人员', '设备管理人员', '1', '2022-03-26 08:19:50');

-- ----------------------------
-- Table structure for sys_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_permission`;
CREATE TABLE `sys_role_permission` (
  `rid` int(11) NOT NULL,
  `pid` int(11) NOT NULL,
  PRIMARY KEY (`pid`,`rid`) USING BTREE,
  KEY `sys_role_permission_ibfk_1` (`pid`) USING BTREE,
  KEY `sys_role_permission_ibfk_2` (`rid`) USING BTREE,
  CONSTRAINT `sys_role_permission_ibfk_1` FOREIGN KEY (`pid`) REFERENCES `sys_permission` (`id`) ON DELETE CASCADE,
  CONSTRAINT `sys_role_permission_ibfk_2` FOREIGN KEY (`rid`) REFERENCES `sys_role` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of sys_role_permission
-- ----------------------------
INSERT INTO `sys_role_permission` VALUES ('1', '1');
INSERT INTO `sys_role_permission` VALUES ('4', '1');
INSERT INTO `sys_role_permission` VALUES ('6', '1');
INSERT INTO `sys_role_permission` VALUES ('8', '1');
INSERT INTO `sys_role_permission` VALUES ('10', '1');
INSERT INTO `sys_role_permission` VALUES ('11', '1');
INSERT INTO `sys_role_permission` VALUES ('1', '2');
INSERT INTO `sys_role_permission` VALUES ('4', '2');
INSERT INTO `sys_role_permission` VALUES ('6', '2');
INSERT INTO `sys_role_permission` VALUES ('1', '3');
INSERT INTO `sys_role_permission` VALUES ('4', '3');
INSERT INTO `sys_role_permission` VALUES ('6', '3');
INSERT INTO `sys_role_permission` VALUES ('11', '3');
INSERT INTO `sys_role_permission` VALUES ('1', '4');
INSERT INTO `sys_role_permission` VALUES ('4', '4');
INSERT INTO `sys_role_permission` VALUES ('6', '4');
INSERT INTO `sys_role_permission` VALUES ('1', '7');
INSERT INTO `sys_role_permission` VALUES ('4', '7');
INSERT INTO `sys_role_permission` VALUES ('6', '7');
INSERT INTO `sys_role_permission` VALUES ('1', '8');
INSERT INTO `sys_role_permission` VALUES ('4', '8');
INSERT INTO `sys_role_permission` VALUES ('6', '8');
INSERT INTO `sys_role_permission` VALUES ('11', '8');
INSERT INTO `sys_role_permission` VALUES ('1', '9');
INSERT INTO `sys_role_permission` VALUES ('4', '9');
INSERT INTO `sys_role_permission` VALUES ('6', '9');
INSERT INTO `sys_role_permission` VALUES ('11', '9');
INSERT INTO `sys_role_permission` VALUES ('1', '10');
INSERT INTO `sys_role_permission` VALUES ('4', '10');
INSERT INTO `sys_role_permission` VALUES ('11', '10');
INSERT INTO `sys_role_permission` VALUES ('1', '11');
INSERT INTO `sys_role_permission` VALUES ('4', '11');
INSERT INTO `sys_role_permission` VALUES ('11', '11');
INSERT INTO `sys_role_permission` VALUES ('1', '12');
INSERT INTO `sys_role_permission` VALUES ('4', '12');
INSERT INTO `sys_role_permission` VALUES ('6', '12');
INSERT INTO `sys_role_permission` VALUES ('1', '13');
INSERT INTO `sys_role_permission` VALUES ('4', '13');
INSERT INTO `sys_role_permission` VALUES ('6', '13');
INSERT INTO `sys_role_permission` VALUES ('1', '14');
INSERT INTO `sys_role_permission` VALUES ('4', '14');
INSERT INTO `sys_role_permission` VALUES ('8', '14');
INSERT INTO `sys_role_permission` VALUES ('1', '15');
INSERT INTO `sys_role_permission` VALUES ('8', '15');
INSERT INTO `sys_role_permission` VALUES ('1', '16');
INSERT INTO `sys_role_permission` VALUES ('8', '16');
INSERT INTO `sys_role_permission` VALUES ('1', '17');
INSERT INTO `sys_role_permission` VALUES ('8', '17');
INSERT INTO `sys_role_permission` VALUES ('1', '18');
INSERT INTO `sys_role_permission` VALUES ('8', '18');
INSERT INTO `sys_role_permission` VALUES ('1', '21');
INSERT INTO `sys_role_permission` VALUES ('1', '22');
INSERT INTO `sys_role_permission` VALUES ('1', '23');
INSERT INTO `sys_role_permission` VALUES ('1', '30');
INSERT INTO `sys_role_permission` VALUES ('4', '30');
INSERT INTO `sys_role_permission` VALUES ('8', '30');
INSERT INTO `sys_role_permission` VALUES ('1', '31');
INSERT INTO `sys_role_permission` VALUES ('4', '31');
INSERT INTO `sys_role_permission` VALUES ('8', '31');
INSERT INTO `sys_role_permission` VALUES ('1', '32');
INSERT INTO `sys_role_permission` VALUES ('4', '32');
INSERT INTO `sys_role_permission` VALUES ('8', '32');
INSERT INTO `sys_role_permission` VALUES ('1', '34');
INSERT INTO `sys_role_permission` VALUES ('8', '34');
INSERT INTO `sys_role_permission` VALUES ('1', '35');
INSERT INTO `sys_role_permission` VALUES ('8', '35');
INSERT INTO `sys_role_permission` VALUES ('1', '36');
INSERT INTO `sys_role_permission` VALUES ('8', '36');
INSERT INTO `sys_role_permission` VALUES ('1', '38');
INSERT INTO `sys_role_permission` VALUES ('8', '38');
INSERT INTO `sys_role_permission` VALUES ('1', '39');
INSERT INTO `sys_role_permission` VALUES ('8', '39');
INSERT INTO `sys_role_permission` VALUES ('1', '40');
INSERT INTO `sys_role_permission` VALUES ('8', '40');
INSERT INTO `sys_role_permission` VALUES ('1', '42');
INSERT INTO `sys_role_permission` VALUES ('8', '42');
INSERT INTO `sys_role_permission` VALUES ('1', '43');
INSERT INTO `sys_role_permission` VALUES ('8', '43');
INSERT INTO `sys_role_permission` VALUES ('1', '44');
INSERT INTO `sys_role_permission` VALUES ('8', '44');
INSERT INTO `sys_role_permission` VALUES ('1', '46');
INSERT INTO `sys_role_permission` VALUES ('8', '46');
INSERT INTO `sys_role_permission` VALUES ('1', '47');
INSERT INTO `sys_role_permission` VALUES ('8', '47');
INSERT INTO `sys_role_permission` VALUES ('1', '48');
INSERT INTO `sys_role_permission` VALUES ('8', '48');
INSERT INTO `sys_role_permission` VALUES ('1', '49');
INSERT INTO `sys_role_permission` VALUES ('8', '49');
INSERT INTO `sys_role_permission` VALUES ('1', '51');
INSERT INTO `sys_role_permission` VALUES ('8', '51');
INSERT INTO `sys_role_permission` VALUES ('1', '52');
INSERT INTO `sys_role_permission` VALUES ('8', '52');
INSERT INTO `sys_role_permission` VALUES ('1', '53');
INSERT INTO `sys_role_permission` VALUES ('4', '53');
INSERT INTO `sys_role_permission` VALUES ('8', '53');
INSERT INTO `sys_role_permission` VALUES ('1', '54');
INSERT INTO `sys_role_permission` VALUES ('8', '54');
INSERT INTO `sys_role_permission` VALUES ('1', '55');
INSERT INTO `sys_role_permission` VALUES ('8', '55');
INSERT INTO `sys_role_permission` VALUES ('1', '56');
INSERT INTO `sys_role_permission` VALUES ('8', '56');
INSERT INTO `sys_role_permission` VALUES ('1', '57');
INSERT INTO `sys_role_permission` VALUES ('8', '57');
INSERT INTO `sys_role_permission` VALUES ('1', '68');
INSERT INTO `sys_role_permission` VALUES ('4', '68');
INSERT INTO `sys_role_permission` VALUES ('6', '68');
INSERT INTO `sys_role_permission` VALUES ('1', '69');
INSERT INTO `sys_role_permission` VALUES ('6', '69');
INSERT INTO `sys_role_permission` VALUES ('1', '70');
INSERT INTO `sys_role_permission` VALUES ('6', '70');
INSERT INTO `sys_role_permission` VALUES ('1', '71');
INSERT INTO `sys_role_permission` VALUES ('6', '71');
INSERT INTO `sys_role_permission` VALUES ('1', '73');
INSERT INTO `sys_role_permission` VALUES ('1', '74');
INSERT INTO `sys_role_permission` VALUES ('1', '75');
INSERT INTO `sys_role_permission` VALUES ('1', '76');
INSERT INTO `sys_role_permission` VALUES ('1', '77');
INSERT INTO `sys_role_permission` VALUES ('1', '78');
INSERT INTO `sys_role_permission` VALUES ('1', '79');
INSERT INTO `sys_role_permission` VALUES ('1', '81');
INSERT INTO `sys_role_permission` VALUES ('4', '81');
INSERT INTO `sys_role_permission` VALUES ('6', '81');
INSERT INTO `sys_role_permission` VALUES ('11', '81');
INSERT INTO `sys_role_permission` VALUES ('1', '82');
INSERT INTO `sys_role_permission` VALUES ('4', '82');
INSERT INTO `sys_role_permission` VALUES ('11', '82');
INSERT INTO `sys_role_permission` VALUES ('1', '83');
INSERT INTO `sys_role_permission` VALUES ('4', '83');
INSERT INTO `sys_role_permission` VALUES ('11', '83');
INSERT INTO `sys_role_permission` VALUES ('1', '84');
INSERT INTO `sys_role_permission` VALUES ('4', '84');
INSERT INTO `sys_role_permission` VALUES ('11', '84');
INSERT INTO `sys_role_permission` VALUES ('1', '86');
INSERT INTO `sys_role_permission` VALUES ('1', '91');
INSERT INTO `sys_role_permission` VALUES ('4', '91');
INSERT INTO `sys_role_permission` VALUES ('6', '91');
INSERT INTO `sys_role_permission` VALUES ('11', '91');
INSERT INTO `sys_role_permission` VALUES ('1', '92');
INSERT INTO `sys_role_permission` VALUES ('4', '92');
INSERT INTO `sys_role_permission` VALUES ('6', '92');
INSERT INTO `sys_role_permission` VALUES ('11', '92');
INSERT INTO `sys_role_permission` VALUES ('1', '116');
INSERT INTO `sys_role_permission` VALUES ('4', '116');
INSERT INTO `sys_role_permission` VALUES ('6', '116');
INSERT INTO `sys_role_permission` VALUES ('11', '116');
INSERT INTO `sys_role_permission` VALUES ('1', '117');
INSERT INTO `sys_role_permission` VALUES ('4', '117');
INSERT INTO `sys_role_permission` VALUES ('6', '117');
INSERT INTO `sys_role_permission` VALUES ('11', '117');
INSERT INTO `sys_role_permission` VALUES ('1', '118');
INSERT INTO `sys_role_permission` VALUES ('4', '118');
INSERT INTO `sys_role_permission` VALUES ('6', '118');
INSERT INTO `sys_role_permission` VALUES ('11', '118');
INSERT INTO `sys_role_permission` VALUES ('1', '119');
INSERT INTO `sys_role_permission` VALUES ('1', '122');
INSERT INTO `sys_role_permission` VALUES ('10', '122');
INSERT INTO `sys_role_permission` VALUES ('1', '123');
INSERT INTO `sys_role_permission` VALUES ('1', '124');
INSERT INTO `sys_role_permission` VALUES ('1', '125');
INSERT INTO `sys_role_permission` VALUES ('4', '125');
INSERT INTO `sys_role_permission` VALUES ('6', '125');
INSERT INTO `sys_role_permission` VALUES ('11', '125');
INSERT INTO `sys_role_permission` VALUES ('1', '126');
INSERT INTO `sys_role_permission` VALUES ('4', '126');
INSERT INTO `sys_role_permission` VALUES ('1', '127');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `loginname` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `pwd` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `sex` int(11) DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `deptid` int(11) DEFAULT NULL,
  `hiredate` datetime DEFAULT NULL,
  `mgr` int(11) DEFAULT NULL COMMENT '上级领导id',
  `available` int(11) DEFAULT '1' COMMENT '是否可用，0不可用，1可用',
  `ordernum` int(11) DEFAULT NULL COMMENT '排序码',
  `type` int(255) DEFAULT NULL COMMENT '用户类型[0超级管理员，1管理员，2普通用户]',
  `imgpath` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '用户头像地址',
  `salt` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '盐',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `sys_user_loginname` (`loginname`) USING BTREE COMMENT '登陆名称唯一',
  KEY `FK_sys_dept_sys_user` (`deptid`) USING BTREE,
  CONSTRAINT `FK_sys_dept_sys_user` FOREIGN KEY (`deptid`) REFERENCES `sys_dept` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', '超级管理员', 'admin', '532ac00e86893901af5f0be6b704dbc7', '系统超级管理员', '1', '超级管理员', '1', '2022-03-26 08:19:50', null, '1', '1', '0', '2020-02-24/8258FCECC0D64A1DB3B457E7D51D6AB5.jpg', '04A93C74C8294AA09A8B974FD1F4ECBB');
INSERT INTO `sys_user` VALUES ('2', '超级管理员1234', 'admin1234', '532ac00e86893901af5f0be6b704dbc7', '超级管理员1234', '1', '超级管理员', '1', '2022-03-26 08:19:50', null, '1', '2', '0', '2020-03-08/0F8C9E01C1DF4A60BB0E2747F67D03BF.jpg', '04A93C74C8294AA09A8B974FD1F4ECBB');
INSERT INTO `sys_user` VALUES ('3', '用户一', 'yonghu1', '532ac00e86893901af5f0be6b704dbc7', '用户一', '1', '否', '2', '2022-03-16 16:13:37', '5', '1', '3', '1', '2020-02-24/BF25CC186DA14E89BDA0FB061404E527.jpg', '04A93C74C8294AA09A8B974FD1F4ECBB');
INSERT INTO `sys_user` VALUES ('4', '李四', 'lisi', '29b6ea7f9e1fb22a85d112b881e917fa', '李四', '1', '普通用户', '3', '2022-03-18 08:19:50', '3', '1', '4', '1', '2020-02-24/795D8302F654489C8FA3E06F0DA8C141.jpg', '32BB4EB8696D4F0A9A51F9196AA6A8CB');
INSERT INTO `sys_user` VALUES ('5', '王五', 'wangwu', '532ac00e86893901af5f0be6b704dbc7', '王五', '1', '普通用户', '5', '2022-03-18 08:19:50', '4', '1', '5', '1', '2020-02-24/014938189D454F95BAEB3AC439CD6703.jpg', '04A93C74C8294AA09A8B974FD1F4ECBB');
INSERT INTO `sys_user` VALUES ('10', '张三', 'zhangsan', '532ac00e86893901af5f0be6b704dbc7', '张三', '0', '将军', '3', '2022-03-18 08:19:50', '3', '1', '9', '1', '2020-02-24/8258FCECC0D64A1DB3B457E7D51D6AB5.jpg', '950289EBDBA24C7789E392E1D0254635');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `uid` int(11) NOT NULL,
  `rid` int(11) NOT NULL,
  PRIMARY KEY (`uid`,`rid`) USING BTREE,
  KEY `FK_sys_user_role_1` (`rid`) USING BTREE,
  CONSTRAINT `FK_sys_user_role_1` FOREIGN KEY (`rid`) REFERENCES `sys_role` (`id`),
  CONSTRAINT `FK_sys_user_role_2` FOREIGN KEY (`uid`) REFERENCES `sys_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('1', '1');
INSERT INTO `sys_user_role` VALUES ('4', '4');
INSERT INTO `sys_user_role` VALUES ('3', '6');
INSERT INTO `sys_user_role` VALUES ('5', '6');
