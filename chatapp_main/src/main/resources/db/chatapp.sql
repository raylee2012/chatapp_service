#创建数据库chat
CREATE DATABASE IF NOT EXISTS chat;
USE chat;
SHOW TABLES;

#新建用户表
CREATE TABLE `user` (
  `user_id` VARCHAR(50) NOT NULL COMMENT '用户编号',
  `user_name` VARCHAR(50) NOT NULL COMMENT '用户名',
  `nick_name` VARCHAR(50) DEFAULT NULL COMMENT '昵称',
  `imgurl` VARCHAR(500) DEFAULT NULL COMMENT '用户头像地址',
  `password` VARCHAR(150) NOT NULL COMMENT '用户密码',
  `tel` VARCHAR(13) DEFAULT NULL COMMENT '电话号码',
  `address` VARCHAR(150) DEFAULT NULL COMMENT '地址',
  `create_time` TIMESTAMP NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `update_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_name` (`user_name`)
) ENGINE=INNODB  DEFAULT CHARSET=utf8

#新建联系人表
CREATE TABLE `contact` (
  `contact_id` VARCHAR(50) NOT NULL COMMENT '联系人编号',
  `applicant_id` VARCHAR(50) NOT NULL COMMENT '申请人id',
  `receiver_id` VARCHAR(50) DEFAULT NULL COMMENT '接收人id',
  `application_content` VARCHAR(500) DEFAULT NULL COMMENT '申请内容',
  `status` CHAR (1) DEFAULT NULL COMMENT '0未通过,1已通过,2已拒绝',
  `create_time` TIMESTAMP NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `update_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`contact_id`)
) ENGINE=INNODB  DEFAULT CHARSET=utf8

#新建群组表
CREATE TABLE `group` (
  `group_id` VARCHAR(50) NOT NULL COMMENT '群编号',
  `group_name` VARCHAR(50) DEFAULT NULL COMMENT '群名称',
  `group_notice` VARCHAR(500) DEFAULT NULL COMMENT '群公告',
  `create_user_id` VARCHAR(50) NOT NULL COMMENT '创建人id',
  `create_time` TIMESTAMP NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `update_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`group_id`)
) ENGINE=INNODB  DEFAULT CHARSET=utf8

#新建群成员表
CREATE TABLE `group_member` (
  `group_member_id` VARCHAR(50) NOT NULL COMMENT '群成员编号',
  `group_member_user_id` VARCHAR(50) DEFAULT NULL COMMENT '群成员用户编号',
  `group_note` VARCHAR(500) DEFAULT NULL COMMENT '群备注',
  `group_disturb` CHAR (1) not NULL DEFAULT '0' COMMENT '0未开启消息免打扰,1开启消息免打扰',
  `group_to_contact` CHAR (1) not NULL DEFAULT '0' COMMENT '0不保存到通讯录,1保存到通讯录',
  `group_top` CHAR (1)  not NULL DEFAULT '0' COMMENT '0消息未置顶,1消息置顶',
  `group_nick_name` VARCHAR(50) DEFAULT NULL COMMENT '个人设置的群昵称',
  `group_top_update_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '消息置顶状态更新时间',
  `create_time` TIMESTAMP NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `update_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`group_member_id`)
) ENGINE=INNODB  DEFAULT CHARSET=utf8

#消息表
CREATE TABLE `message` (
  `message_id` VARCHAR(50) NOT NULL COMMENT '消息编号',
  `message_group_id` VARCHAR(50) NOT NULL COMMENT '消息所属群编号',
  `message_create_user_id` VARCHAR(50) NOT NULL COMMENT '创建消息的用户编号',
  `message_content` VARCHAR(500) DEFAULT NULL COMMENT '消息内容',
  `message_attach_url` VARCHAR(1000) DEFAULT NULL COMMENT '附件消息文件地址',
  `message_attach_name` VARCHAR(200) DEFAULT NULL COMMENT '附件消息文件名',
  `message_attach_size` VARCHAR(200) DEFAULT NULL COMMENT '附件消息文件大小',
  `message_revocation` CHAR (1) not NULL DEFAULT '0' COMMENT '0非撤回消息,1撤回消息',
  `message_type` CHAR (1) not NULL DEFAULT '0' COMMENT '0文本消息,1图片消息,2语音消息,3视频消息,4位置消息',
  `create_time` TIMESTAMP NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `update_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`message_id`)
) ENGINE=INNODB  DEFAULT CHARSET=utf8

