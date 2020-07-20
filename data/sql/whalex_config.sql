    /*
     Navicat Premium Data Transfer

     Source Server         : localhost
     Source Server Type    : MySQL
     Source Server Version : 50729
     Source Host           : localhost:3306
     Source Schema         : whalex-config

     Target Server Type    : MySQL
     Target Server Version : 50729
     File Encoding         : 65001

     Date: 19/07/2020 20:58:04
    */

    SET NAMES utf8mb4;
    SET FOREIGN_KEY_CHECKS = 0;

    -- ----------------------------
    -- Table structure for config_info
    -- ----------------------------
    DROP TABLE IF EXISTS `config_info`;
    CREATE TABLE `config_info`  (
      `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
      `data_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'data_id',
      `group_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
      `content` longtext CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'content',
      `md5` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'md5',
      `gmt_create` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
      `gmt_modified` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
      `src_user` text CHARACTER SET utf8 COLLATE utf8_bin NULL COMMENT 'source user',
      `src_ip` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'source ip',
      `app_name` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
      `tenant_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT '' COMMENT '租户字段',
      `c_desc` varchar(256) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
      `c_use` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
      `effect` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
      `type` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
      `c_schema` text CHARACTER SET utf8 COLLATE utf8_bin NULL,
      PRIMARY KEY (`id`) USING BTREE,
      UNIQUE INDEX `uk_configinfo_datagrouptenant`(`data_id`, `group_id`, `tenant_id`) USING BTREE
    ) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = 'config_info' ROW_FORMAT = Dynamic;

    -- ----------------------------
    -- Records of config_info
    -- ----------------------------
    INSERT INTO `config_info` VALUES (1, 'application-dev.yml', 'DEFAULT_GROUP', 'spring:\r\n  redis:\r\n    host: whalex-redis\r\n  servlet:\r\n    multipart:\r\n      max-file-size: 100MB\r\n      max-request-size: 100MB\r\n  cloud:\r\n    sentinel:\r\n      eager: true\r\n      filter:\r\n        url-patterns: /** \r\n      transport:\r\n        dashboard: whalex-sentinel:5020\r\nmanagement:\r\n  endpoints:\r\n    web:\r\n      exposure:\r\n        include: \'*\'\r\n  endpoint:\r\n    health:\r\n      show-details: ALWAYS\r\n\r\nfeign:\r\n  sentinel:\r\n    enabled: true\r\n  okhttp:\r\n    enabled: true\r\n  httpclient:\r\n    enabled: false\r\n  client:\r\n    config:\r\n      default:\r\n        connectTimeout: 10000\r\n        readTimeout: 10000\r\n  compression:\r\n    request:\r\n      enabled: true\r\n    response:\r\n      enabled: true\r\nmybatis-plus:\r\n  tenant-enable: ture\r\n  mapper-locations: classpath:/mapper/*Mapper.xml\r\n  global-config:\r\n    banner: false\r\n    db-config:\r\n      id-type: auto\r\n      field-strategy: NOT_EMPTY\r\n#  type-handlers-package:  com.pig4cloud.pigx.common.data.handler', 'cf0e21a390c2226ed1eaa26cfdb14cf8', '2020-07-05 13:36:42', '2020-07-12 00:21:59', NULL, '127.0.0.1', '', '', 'null', 'null', 'null', 'yaml', 'null');
    INSERT INTO `config_info` VALUES (2, 'whale-auth-dev.yml', 'DEFAULT_GROUP', 'security:\r\n  oauth2:\r\n    client:\r\n      ignore-urls:\r\n        - /druid/**\r\n        - /actuator/**\r\n        - /v2/api-docs\r\n# 数据源\r\nspring:\r\n  datasource:\r\n    type: com.alibaba.druid.pool.DruidDataSource\r\n    druid:\r\n      driver-class-name: com.mysql.cj.jdbc.Driver\r\n      username: ${MYSQL_USER:root}\r\n      password: ${MYSQL_PWD:123456789}\r\n      url: jdbc:mysql://${MYSQL_HOST:whalex-mysql}:${MYSQL_PORT:3306}/${MYSQL_DB:whalex-customer}?characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=GMT%2B8&allowMultiQueries=true&allowPublicKeyRetrieval=true\r\n      stat-view-servlet:\r\n        enabled: true\r\n        url-pattern: /druid/*\r\n        #login-username: admin\r\n        #login-password: admin\r\n      filter:\r\n        stat:\r\n          enabled: true\r\n          log-slow-sql: true\r\n          slow-sql-millis: 10000\r\n          merge-sql: false\r\n        wall:\r\n          config:\r\n            multi-statement-allow: true\r\n  freemarker:\r\n    allow-request-override: false\r\n    allow-session-override: false\r\n    cache: true\r\n    charset: UTF-8\r\n    check-template-location: true\r\n    content-type: text/html\r\n    enabled: true\r\n    expose-request-attributes: false\r\n    expose-session-attributes: false\r\n    expose-spring-macro-helpers: true\r\n    prefer-file-system-access: true\r\n    suffix: .ftl\r\n    template-loader-path: classpath:/templates/\r\n\r\n# Logger Config\r\nlogging:\r\n  level:\r\n    com.whalex.usercentre.mapper: debug', '6830c462a30696ad0587fdd89433e4eb', '2020-07-05 14:02:57', '2020-07-12 10:57:55', NULL, '127.0.0.1', '', '', 'null', 'null', 'null', 'yaml', 'null');
    INSERT INTO `config_info` VALUES (4, 'whale-user-centre-dev.yml', 'DEFAULT_GROUP', 'security:\r\n  oauth2:\r\n    client:\r\n      ignore-urls:\r\n        - /druid/**\r\n        - /actuator/**\r\n        - /v2/api-docs\r\n# 数据源\r\nspring:\r\n  datasource:\r\n    type: com.alibaba.druid.pool.DruidDataSource\r\n    druid:\r\n      driver-class-name: com.mysql.cj.jdbc.Driver\r\n      username: ${MYSQL_USER:root}\r\n      password: ${MYSQL_PWD:123456789}\r\n      url: jdbc:mysql://${MYSQL_HOST:whalex-mysql}:${MYSQL_PORT:3306}/${MYSQL_DB:whalex-customer}?characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=GMT%2B8&allowMultiQueries=true&allowPublicKeyRetrieval=true\r\n      stat-view-servlet:\r\n        enabled: true\r\n        url-pattern: /druid/*\r\n        #login-username: admin\r\n        #login-password: admin\r\n      filter:\r\n        stat:\r\n          enabled: true\r\n          log-slow-sql: true\r\n          slow-sql-millis: 1\r\n          merge-sql: false\r\n        wall:\r\n          config:\r\n            multi-statement-allow: true\r\n  freemarker:\r\n    allow-request-override: false\r\n    allow-session-override: false\r\n    cache: true\r\n    charset: UTF-8\r\n    check-template-location: true\r\n    content-type: text/html\r\n    enabled: true\r\n    expose-request-attributes: false\r\n    expose-session-attributes: false\r\n    expose-spring-macro-helpers: true\r\n    prefer-file-system-access: true\r\n    suffix: .ftl\r\n    template-loader-path: classpath:/templates/\r\n\r\n# Logger Config\r\nlogging:\r\n  level:\r\n    com.whalex.usercentre.mapper: debug', '66a885c102f21e909f7bb27a4bca01b2', '2020-07-05 14:18:58', '2020-07-12 13:32:03', NULL, '127.0.0.1', '', '', 'null', 'null', 'null', 'yaml', 'null');
    INSERT INTO `config_info` VALUES (15, 'whale-system-centre-dev.yml', 'DEFAULT_GROUP', '# 数据源\r\nspring:\r\n  datasource:\r\n    type: com.alibaba.druid.pool.DruidDataSource\r\n    druid:\r\n      driver-class-name: com.mysql.cj.jdbc.Driver\r\n      username: ${MYSQL_USER:root}\r\n      password: ${MYSQL_PWD:123456789}\r\n      url: jdbc:mysql://${MYSQL_HOST:whalex-mysql}:${MYSQL_PORT:3306}/${MYSQL_DB:whalex-sys}?characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=GMT%2B8&allowMultiQueries=true&allowPublicKeyRetrieval=true\r\n  freemarker:\r\n    allow-request-override: false\r\n    allow-session-override: false\r\n    cache: true\r\n    charset: UTF-8\r\n    check-template-location: true\r\n    content-type: text/html\r\n    enabled: true\r\n    expose-request-attributes: false\r\n    expose-session-attributes: false\r\n    expose-spring-macro-helpers: true\r\n    prefer-file-system-access: true\r\n    suffix: .ftl\r\n    template-loader-path: classpath:/templates/', '8173deb795c8222e47c8c246e7452842', '2020-07-07 21:00:46', '2020-07-07 21:01:40', NULL, '0:0:0:0:0:0:0:1', '', '', 'null', 'null', 'null', 'yaml', 'null');

    -- ----------------------------
    -- Table structure for config_info_aggr
    -- ----------------------------
    DROP TABLE IF EXISTS `config_info_aggr`;
    CREATE TABLE `config_info_aggr`  (
      `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
      `data_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'data_id',
      `group_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'group_id',
      `datum_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'datum_id',
      `content` longtext CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '内容',
      `gmt_modified` datetime(0) NOT NULL COMMENT '修改时间',
      `app_name` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
      `tenant_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT '' COMMENT '租户字段',
      PRIMARY KEY (`id`) USING BTREE,
      UNIQUE INDEX `uk_configinfoaggr_datagrouptenantdatum`(`data_id`, `group_id`, `tenant_id`, `datum_id`) USING BTREE
    ) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '增加租户字段' ROW_FORMAT = Dynamic;

    -- ----------------------------
    -- Table structure for config_info_beta
    -- ----------------------------
    DROP TABLE IF EXISTS `config_info_beta`;
    CREATE TABLE `config_info_beta`  (
      `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
      `data_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'data_id',
      `group_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'group_id',
      `app_name` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'app_name',
      `content` longtext CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'content',
      `beta_ips` varchar(1024) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'betaIps',
      `md5` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'md5',
      `gmt_create` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
      `gmt_modified` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
      `src_user` text CHARACTER SET utf8 COLLATE utf8_bin NULL COMMENT 'source user',
      `src_ip` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'source ip',
      `tenant_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT '' COMMENT '租户字段',
      PRIMARY KEY (`id`) USING BTREE,
      UNIQUE INDEX `uk_configinfobeta_datagrouptenant`(`data_id`, `group_id`, `tenant_id`) USING BTREE
    ) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = 'config_info_beta' ROW_FORMAT = Dynamic;

    -- ----------------------------
    -- Table structure for config_info_tag
    -- ----------------------------
    DROP TABLE IF EXISTS `config_info_tag`;
    CREATE TABLE `config_info_tag`  (
      `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
      `data_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'data_id',
      `group_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'group_id',
      `tenant_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT '' COMMENT 'tenant_id',
      `tag_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'tag_id',
      `app_name` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'app_name',
      `content` longtext CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'content',
      `md5` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'md5',
      `gmt_create` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
      `gmt_modified` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
      `src_user` text CHARACTER SET utf8 COLLATE utf8_bin NULL COMMENT 'source user',
      `src_ip` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'source ip',
      PRIMARY KEY (`id`) USING BTREE,
      UNIQUE INDEX `uk_configinfotag_datagrouptenanttag`(`data_id`, `group_id`, `tenant_id`, `tag_id`) USING BTREE
    ) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = 'config_info_tag' ROW_FORMAT = Dynamic;

    -- ----------------------------
    -- Table structure for config_tags_relation
    -- ----------------------------
    DROP TABLE IF EXISTS `config_tags_relation`;
    CREATE TABLE `config_tags_relation`  (
      `id` bigint(20) NOT NULL COMMENT 'id',
      `tag_name` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'tag_name',
      `tag_type` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'tag_type',
      `data_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'data_id',
      `group_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'group_id',
      `tenant_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT '' COMMENT 'tenant_id',
      `nid` bigint(20) NOT NULL AUTO_INCREMENT,
      PRIMARY KEY (`nid`) USING BTREE,
      UNIQUE INDEX `uk_configtagrelation_configidtag`(`id`, `tag_name`, `tag_type`) USING BTREE,
      INDEX `idx_tenant_id`(`tenant_id`) USING BTREE
    ) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = 'config_tag_relation' ROW_FORMAT = Dynamic;

    -- ----------------------------
    -- Table structure for group_capacity
    -- ----------------------------
    DROP TABLE IF EXISTS `group_capacity`;
    CREATE TABLE `group_capacity`  (
      `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键ID',
      `group_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT 'Group ID，空字符表示整个集群',
      `quota` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '配额，0表示使用默认值',
      `usage` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '使用量',
      `max_size` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '单个配置大小上限，单位为字节，0表示使用默认值',
      `max_aggr_count` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '聚合子配置最大个数，，0表示使用默认值',
      `max_aggr_size` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '单个聚合数据的子配置大小上限，单位为字节，0表示使用默认值',
      `max_history_count` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '最大变更历史数量',
      `gmt_create` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
      `gmt_modified` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
      PRIMARY KEY (`id`) USING BTREE,
      UNIQUE INDEX `uk_group_id`(`group_id`) USING BTREE
    ) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '集群、各Group容量信息表' ROW_FORMAT = Dynamic;

    -- ----------------------------
    -- Table structure for his_config_info
    -- ----------------------------
    DROP TABLE IF EXISTS `his_config_info`;
    CREATE TABLE `his_config_info`  (
      `id` bigint(64) UNSIGNED NOT NULL,
      `nid` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
      `data_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
      `group_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
      `app_name` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'app_name',
      `content` longtext CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
      `md5` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
      `gmt_create` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP,
      `gmt_modified` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP,
      `src_user` text CHARACTER SET utf8 COLLATE utf8_bin NULL,
      `src_ip` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
      `op_type` char(10) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
      `tenant_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT '' COMMENT '租户字段',
      PRIMARY KEY (`nid`) USING BTREE,
      INDEX `idx_gmt_create`(`gmt_create`) USING BTREE,
      INDEX `idx_gmt_modified`(`gmt_modified`) USING BTREE,
      INDEX `idx_did`(`data_id`) USING BTREE
    ) ENGINE = InnoDB AUTO_INCREMENT = 27 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '多租户改造' ROW_FORMAT = Dynamic;

    -- ----------------------------
    -- Records of his_config_info
    -- ----------------------------
    INSERT INTO `his_config_info` VALUES (0, 1, 'application-dev.yml', 'DEFAULT_GROUP', '', 'management:\r\n  endpoints:\r\n    web:\r\n      exposure:\r\n        include: \'*\'\r\n  endpoint:\r\n    health:\r\n      show-details: ALWAYS\r\n\r\nfeign:\r\n  sentinel:\r\n    enabled: true\r\n  okhttp:\r\n    enabled: true\r\n  httpclient:\r\n    enabled: false\r\n  client:\r\n    config:\r\n      default:\r\n        connectTimeout: 10000\r\n        readTimeout: 10000\r\n  compression:\r\n    request:\r\n      enabled: true\r\n    response:\r\n      enabled: true\r\n', '2201a677d309269174a5ecc8001a30bd', '2020-07-05 13:36:41', '2020-07-05 13:36:42', NULL, '0:0:0:0:0:0:0:1', 'I', '');
    INSERT INTO `his_config_info` VALUES (0, 2, 'whale-auth-dev.yml', 'DEFAULT_GROUP', '', '# 数据源\r\nspring:\r\n  datasource:\r\n    type: com.alibaba.druid.pool.DruidDataSource\r\n    druid:\r\n      driver-class-name: com.mysql.cj.jdbc.Driver\r\n      username: ${MYSQL_USER:root}\r\n      password: ${MYSQL_PWD:123456789}\r\n      url: jdbc:mysql://${MYSQL_HOST:whalex-mysql}:${MYSQL_PORT:3306}/${MYSQL_DB:whalex-customer}?characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=GMT%2B8&allowMultiQueries=true&allowPublicKeyRetrieval=true\r\n  freemarker:\r\n    allow-request-override: false\r\n    allow-session-override: false\r\n    cache: true\r\n    charset: UTF-8\r\n    check-template-location: true\r\n    content-type: text/html\r\n    enabled: true\r\n    expose-request-attributes: false\r\n    expose-session-attributes: false\r\n    expose-spring-macro-helpers: true\r\n    prefer-file-system-access: true\r\n    suffix: .ftl\r\n    template-loader-path: classpath:/templates/', '00406a5bac65685015b6c87b00201d11', '2020-07-05 14:02:57', '2020-07-05 14:02:57', NULL, '0:0:0:0:0:0:0:1', 'I', '');
    INSERT INTO `his_config_info` VALUES (0, 3, 'whale-user-centre.yml', 'DEFAULT_GROUP', '', '1', 'c4ca4238a0b923820dcc509a6f75849b', '2020-07-05 14:18:37', '2020-07-05 14:18:38', NULL, '0:0:0:0:0:0:0:1', 'I', '');
    INSERT INTO `his_config_info` VALUES (3, 4, 'whale-user-centre.yml', 'DEFAULT_GROUP', '', '1', 'c4ca4238a0b923820dcc509a6f75849b', '2020-07-05 14:18:48', '2020-07-05 14:18:48', NULL, '0:0:0:0:0:0:0:1', 'D', '');
    INSERT INTO `his_config_info` VALUES (0, 5, 'whale-user-centre-dev.yml', 'DEFAULT_GROUP', '', '1', 'c4ca4238a0b923820dcc509a6f75849b', '2020-07-05 14:18:58', '2020-07-05 14:18:58', NULL, '0:0:0:0:0:0:0:1', 'I', '');
    INSERT INTO `his_config_info` VALUES (4, 6, 'whale-user-centre-dev.yml', 'DEFAULT_GROUP', '', '1', 'c4ca4238a0b923820dcc509a6f75849b', '2020-07-05 14:19:14', '2020-07-05 14:19:14', NULL, '0:0:0:0:0:0:0:1', 'U', '');
    INSERT INTO `his_config_info` VALUES (1, 7, 'application-dev.yml', 'DEFAULT_GROUP', '', 'management:\r\n  endpoints:\r\n    web:\r\n      exposure:\r\n        include: \'*\'\r\n  endpoint:\r\n    health:\r\n      show-details: ALWAYS\r\n\r\nfeign:\r\n  sentinel:\r\n    enabled: true\r\n  okhttp:\r\n    enabled: true\r\n  httpclient:\r\n    enabled: false\r\n  client:\r\n    config:\r\n      default:\r\n        connectTimeout: 10000\r\n        readTimeout: 10000\r\n  compression:\r\n    request:\r\n      enabled: true\r\n    response:\r\n      enabled: true\r\n', '2201a677d309269174a5ecc8001a30bd', '2020-07-05 14:26:11', '2020-07-05 14:26:12', NULL, '0:0:0:0:0:0:0:1', 'U', '');
    INSERT INTO `his_config_info` VALUES (0, 8, 'application-whale-auth-dev.yml', 'DEFAULT_GROUP', '', '1', 'c4ca4238a0b923820dcc509a6f75849b', '2020-07-05 15:57:02', '2020-07-05 15:57:02', NULL, '0:0:0:0:0:0:0:1', 'I', '');
    INSERT INTO `his_config_info` VALUES (7, 9, 'application-whale-auth-dev.yml', 'DEFAULT_GROUP', '', '1', 'c4ca4238a0b923820dcc509a6f75849b', '2020-07-05 15:57:16', '2020-07-05 15:57:17', NULL, '0:0:0:0:0:0:0:1', 'U', '');
    INSERT INTO `his_config_info` VALUES (0, 10, 'whale-user-centre.yml', 'DEFAULT_GROUP', '', '1', 'c4ca4238a0b923820dcc509a6f75849b', '2020-07-05 16:29:36', '2020-07-05 16:29:36', NULL, '0:0:0:0:0:0:0:1', 'I', '');
    INSERT INTO `his_config_info` VALUES (9, 11, 'whale-user-centre.yml', 'DEFAULT_GROUP', '', '1', 'c4ca4238a0b923820dcc509a6f75849b', '2020-07-05 16:29:49', '2020-07-05 16:29:50', NULL, '0:0:0:0:0:0:0:1', 'U', '');
    INSERT INTO `his_config_info` VALUES (9, 12, 'whale-user-centre.yml', 'DEFAULT_GROUP', '', '# 数据源\r\nspring:\r\n  datasource:\r\n    type: com.alibaba.druid.pool.DruidDataSource\r\n    druid:\r\n      driver-class-name: com.mysql.cj.jdbc.Driver\r\n      username: ${MYSQL_USER:root}\r\n      password: ${MYSQL_PWD:123456789}\r\n      url: jdbc:mysql://${MYSQL_HOST:whalex-mysql}:${MYSQL_PORT:3306}/${MYSQL_DB:whalex-customer}?characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=GMT%2B8&allowMultiQueries=true&allowPublicKeyRetrieval=true\r\n  freemarker:\r\n    allow-request-override: false\r\n    allow-session-override: false\r\n    cache: true\r\n    charset: UTF-8\r\n    check-template-location: true\r\n    content-type: text/html\r\n    enabled: true\r\n    expose-request-attributes: false\r\n    expose-session-attributes: false\r\n    expose-spring-macro-helpers: true\r\n    prefer-file-system-access: true\r\n    suffix: .ftl\r\n    template-loader-path: classpath:/templates/', '00406a5bac65685015b6c87b00201d11', '2020-07-05 16:33:14', '2020-07-05 16:33:14', NULL, '0:0:0:0:0:0:0:1', 'D', '');
    INSERT INTO `his_config_info` VALUES (0, 13, 'whale-auth.yml', 'DEFAULT_GROUP', '', '123', '202cb962ac59075b964b07152d234b70', '2020-07-05 16:33:28', '2020-07-05 16:33:28', NULL, '0:0:0:0:0:0:0:1', 'I', '');
    INSERT INTO `his_config_info` VALUES (11, 14, 'whale-auth.yml', 'DEFAULT_GROUP', '', '123', '202cb962ac59075b964b07152d234b70', '2020-07-05 16:33:41', '2020-07-05 16:33:42', NULL, '0:0:0:0:0:0:0:1', 'U', '');
    INSERT INTO `his_config_info` VALUES (2, 15, 'whale-auth-dev.yml', 'DEFAULT_GROUP', '', '# 数据源\r\nspring:\r\n  datasource:\r\n    type: com.alibaba.druid.pool.DruidDataSource\r\n    druid:\r\n      driver-class-name: com.mysql.cj.jdbc.Driver\r\n      username: ${MYSQL_USER:root}\r\n      password: ${MYSQL_PWD:123456789}\r\n      url: jdbc:mysql://${MYSQL_HOST:whalex-mysql}:${MYSQL_PORT:3306}/${MYSQL_DB:whalex-customer}?characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=GMT%2B8&allowMultiQueries=true&allowPublicKeyRetrieval=true\r\n  freemarker:\r\n    allow-request-override: false\r\n    allow-session-override: false\r\n    cache: true\r\n    charset: UTF-8\r\n    check-template-location: true\r\n    content-type: text/html\r\n    enabled: true\r\n    expose-request-attributes: false\r\n    expose-session-attributes: false\r\n    expose-spring-macro-helpers: true\r\n    prefer-file-system-access: true\r\n    suffix: .ftl\r\n    template-loader-path: classpath:/templates/', '00406a5bac65685015b6c87b00201d11', '2020-07-05 18:27:58', '2020-07-05 18:27:58', NULL, '0:0:0:0:0:0:0:1', 'U', '');
    INSERT INTO `his_config_info` VALUES (2, 16, 'whale-auth-dev.yml', 'DEFAULT_GROUP', '', '# 数据源\r\nspring:\r\n  datasource:\r\n    type: com.alibaba.druid.pool.DruidDataSource\r\n    druid:\r\n      driver-class-name: com.mysql.cj.jdbc.Driver\r\n      username: ${MYSQL_USER:root}\r\n      password: ${MYSQL_PWD:123456789}\r\n      url: jdbc:mysql://${MYSQL_HOST:whalex-mysql}:${MYSQL_PORT:3306}/${MYSQL_DB:whalex-customer}?characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=GMT%2B8&allowMultiQueries=true&allowPublicKeyRetrieval=true\r\n  freemarker:\r\n    allow-request-override: false\r\n    allow-session-override: false\r\n    cache: true\r\n    charset: UTF-8\r\n    check-template-location: true\r\n    content-type: text/html\r\n    enabled: true\r\n    expose-request-attributes: false\r\n    expose-session-attributes: false\r\n    expose-spring-macro-helpers: true\r\n    prefer-file-system-access: true\r\n    suffix: .ftl\r\n    template-loader-path: classpath:/templates/\r\n    1', 'e76cd9a0f782e89ca96ca87fe31fbebc', '2020-07-05 18:28:10', '2020-07-05 18:28:10', NULL, '0:0:0:0:0:0:0:1', 'U', '');
    INSERT INTO `his_config_info` VALUES (0, 17, 'whale-system-centre-dev.yml', 'DEFAULT_GROUP', '', '12', 'c20ad4d76fe97759aa27a0c99bff6710', '2020-07-07 21:00:46', '2020-07-07 21:00:46', NULL, '0:0:0:0:0:0:0:1', 'I', '');
    INSERT INTO `his_config_info` VALUES (15, 18, 'whale-system-centre-dev.yml', 'DEFAULT_GROUP', '', '12', 'c20ad4d76fe97759aa27a0c99bff6710', '2020-07-07 21:01:40', '2020-07-07 21:01:40', NULL, '0:0:0:0:0:0:0:1', 'U', '');
    INSERT INTO `his_config_info` VALUES (1, 19, 'application-dev.yml', 'DEFAULT_GROUP', '', 'spring:\r\n  redis:\r\n    host: whalex-redis\r\n  servlet:\r\n    multipart:\r\n      max-file-size: 100MB\r\n      max-request-size: 100MB\r\n  cloud:\r\n    sentinel:\r\n      eager: true\r\n      filter:\r\n        url-patterns: /** \r\n      transport:\r\n        dashboard: whalex-sentinel:5020\r\nmanagement:\r\n  endpoints:\r\n    web:\r\n      exposure:\r\n        include: \'*\'\r\n  endpoint:\r\n    health:\r\n      show-details: ALWAYS\r\n\r\nfeign:\r\n  sentinel:\r\n    enabled: true\r\n  okhttp:\r\n    enabled: true\r\n  httpclient:\r\n    enabled: false\r\n  client:\r\n    config:\r\n      default:\r\n        connectTimeout: 10000\r\n        readTimeout: 10000\r\n  compression:\r\n    request:\r\n      enabled: true\r\n    response:\r\n      enabled: true\r\n', '1b9e2ca5050f252a56c8ff820a61f087', '2020-07-12 00:21:58', '2020-07-12 00:21:59', NULL, '127.0.0.1', 'U', '');
    INSERT INTO `his_config_info` VALUES (7, 20, 'application-whale-auth-dev.yml', 'DEFAULT_GROUP', '', '# 数据源\r\nspring:\r\n  datasource:\r\n    type: com.alibaba.druid.pool.DruidDataSource\r\n    druid:\r\n      driver-class-name: com.mysql.cj.jdbc.Driver\r\n      username: ${MYSQL_USER:root}\r\n      password: ${MYSQL_PWD:123456789}\r\n      url: jdbc:mysql://${MYSQL_HOST:whalex-mysql}:${MYSQL_PORT:3306}/${MYSQL_DB:whalex-customer}?characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=GMT%2B8&allowMultiQueries=true&allowPublicKeyRetrieval=true\r\n  freemarker:\r\n    allow-request-override: false\r\n    allow-session-override: false\r\n    cache: true\r\n    charset: UTF-8\r\n    check-template-location: true\r\n    content-type: text/html\r\n    enabled: true\r\n    expose-request-attributes: false\r\n    expose-session-attributes: false\r\n    expose-spring-macro-helpers: true\r\n    prefer-file-system-access: true\r\n    suffix: .ftl\r\n    template-loader-path: classpath:/templates/', '00406a5bac65685015b6c87b00201d11', '2020-07-12 10:04:16', '2020-07-12 10:04:17', NULL, '127.0.0.1', 'D', '');
    INSERT INTO `his_config_info` VALUES (11, 21, 'whale-auth.yml', 'DEFAULT_GROUP', '', '# 数据源\r\nspring:\r\n  datasource:\r\n    type: com.alibaba.druid.pool.DruidDataSource\r\n    druid:\r\n      driver-class-name: com.mysql.cj.jdbc.Driver\r\n      username: ${MYSQL_USER:root}\r\n      password: ${MYSQL_PWD:123456789}\r\n      url: jdbc:mysql://${MYSQL_HOST:whalex-mysql}:${MYSQL_PORT:3306}/${MYSQL_DB:whalex-customer}?characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=GMT%2B8&allowMultiQueries=true&allowPublicKeyRetrieval=true\r\n  freemarker:\r\n    allow-request-override: false\r\n    allow-session-override: false\r\n    cache: true\r\n    charset: UTF-8\r\n    check-template-location: true\r\n    content-type: text/html\r\n    enabled: true\r\n    expose-request-attributes: false\r\n    expose-session-attributes: false\r\n    expose-spring-macro-helpers: true\r\n    prefer-file-system-access: true\r\n    suffix: .ftl\r\n    template-loader-path: classpath:/templates/', '00406a5bac65685015b6c87b00201d11', '2020-07-12 10:04:20', '2020-07-12 10:04:20', NULL, '127.0.0.1', 'D', '');
    INSERT INTO `his_config_info` VALUES (4, 22, 'whale-user-centre-dev.yml', 'DEFAULT_GROUP', '', '# 数据源\r\nspring:\r\n  datasource:\r\n    type: com.alibaba.druid.pool.DruidDataSource\r\n    druid:\r\n      driver-class-name: com.mysql.cj.jdbc.Driver\r\n      username: ${MYSQL_USER:root}\r\n      password: ${MYSQL_PWD:123456789}\r\n      url: jdbc:mysql://${MYSQL_HOST:whalex-mysql}:${MYSQL_PORT:3306}/${MYSQL_DB:whalex-customer}?characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=GMT%2B8&allowMultiQueries=true&allowPublicKeyRetrieval=true\r\n  freemarker:\r\n    allow-request-override: false\r\n    allow-session-override: false\r\n    cache: true\r\n    charset: UTF-8\r\n    check-template-location: true\r\n    content-type: text/html\r\n    enabled: true\r\n    expose-request-attributes: false\r\n    expose-session-attributes: false\r\n    expose-spring-macro-helpers: true\r\n    prefer-file-system-access: true\r\n    suffix: .ftl\r\n    template-loader-path: classpath:/templates/', '00406a5bac65685015b6c87b00201d11', '2020-07-12 10:05:04', '2020-07-12 10:05:05', NULL, '127.0.0.1', 'U', '');
    INSERT INTO `his_config_info` VALUES (4, 23, 'whale-user-centre-dev.yml', 'DEFAULT_GROUP', '', '# 数据源\r\nspring:\r\n  datasource:\r\n    type: com.alibaba.druid.pool.DruidDataSource\r\n    druid:\r\n      driver-class-name: com.mysql.cj.jdbc.Driver\r\n      username: ${MYSQL_USER:root}\r\n      password: ${MYSQL_PWD:123456789}\r\n      url: jdbc:mysql://${MYSQL_HOST:whalex-mysql}:${MYSQL_PORT:3306}/${MYSQL_DB:whalex-customer}?characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=GMT%2B8&allowMultiQueries=true&allowPublicKeyRetrieval=true\r\n      stat-view-servlet:\r\n        enabled: true\r\n        url-pattern: /druid/*\r\n        #login-username: admin\r\n        #login-password: admin\r\n      filter:\r\n        stat:\r\n          enabled: true\r\n          log-slow-sql: true\r\n          slow-sql-millis: 10000\r\n          merge-sql: false\r\n        wall:\r\n          config:\r\n            multi-statement-allow: true\r\n  freemarker:\r\n    allow-request-override: false\r\n    allow-session-override: false\r\n    cache: true\r\n    charset: UTF-8\r\n    check-template-location: true\r\n    content-type: text/html\r\n    enabled: true\r\n    expose-request-attributes: false\r\n    expose-session-attributes: false\r\n    expose-spring-macro-helpers: true\r\n    prefer-file-system-access: true\r\n    suffix: .ftl\r\n    template-loader-path: classpath:/templates/', '157f6a7bbd7c57ab54794f21db1b38a1', '2020-07-12 10:08:47', '2020-07-12 10:08:48', NULL, '127.0.0.1', 'U', '');
    INSERT INTO `his_config_info` VALUES (4, 24, 'whale-user-centre-dev.yml', 'DEFAULT_GROUP', '', 'security:\r\n  oauth2:\r\n    client:\r\n      ignore-urls:\r\n        - /druid/**\r\n        - /actuator/**\r\n        - /v2/api-docs\r\n# 数据源\r\nspring:\r\n  datasource:\r\n    type: com.alibaba.druid.pool.DruidDataSource\r\n    druid:\r\n      driver-class-name: com.mysql.cj.jdbc.Driver\r\n      username: ${MYSQL_USER:root}\r\n      password: ${MYSQL_PWD:123456789}\r\n      url: jdbc:mysql://${MYSQL_HOST:whalex-mysql}:${MYSQL_PORT:3306}/${MYSQL_DB:whalex-customer}?characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=GMT%2B8&allowMultiQueries=true&allowPublicKeyRetrieval=true\r\n      stat-view-servlet:\r\n        enabled: true\r\n        url-pattern: /druid/*\r\n        #login-username: admin\r\n        #login-password: admin\r\n      filter:\r\n        stat:\r\n          enabled: true\r\n          log-slow-sql: true\r\n          slow-sql-millis: 10000\r\n          merge-sql: false\r\n        wall:\r\n          config:\r\n            multi-statement-allow: true\r\n  freemarker:\r\n    allow-request-override: false\r\n    allow-session-override: false\r\n    cache: true\r\n    charset: UTF-8\r\n    check-template-location: true\r\n    content-type: text/html\r\n    enabled: true\r\n    expose-request-attributes: false\r\n    expose-session-attributes: false\r\n    expose-spring-macro-helpers: true\r\n    prefer-file-system-access: true\r\n    suffix: .ftl\r\n    template-loader-path: classpath:/templates/', '72120d166fa612c3335f51df5bb59656', '2020-07-12 10:11:44', '2020-07-12 10:11:45', NULL, '127.0.0.1', 'U', '');
    INSERT INTO `his_config_info` VALUES (2, 25, 'whale-auth-dev.yml', 'DEFAULT_GROUP', '', '# 数据源\r\nspring:\r\n  datasource:\r\n    type: com.alibaba.druid.pool.DruidDataSource\r\n    druid:\r\n      driver-class-name: com.mysql.cj.jdbc.Driver\r\n      username: ${MYSQL_USER:root}\r\n      password: ${MYSQL_PWD:123456789}\r\n      url: jdbc:mysql://${MYSQL_HOST:whalex-mysql}:${MYSQL_PORT:3306}/${MYSQL_DB:whalex-customer}?characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=GMT%2B8&allowMultiQueries=true&allowPublicKeyRetrieval=true\r\n  freemarker:\r\n    allow-request-override: false\r\n    allow-session-override: false\r\n    cache: true\r\n    charset: UTF-8\r\n    check-template-location: true\r\n    content-type: text/html\r\n    enabled: true\r\n    expose-request-attributes: false\r\n    expose-session-attributes: false\r\n    expose-spring-macro-helpers: true\r\n    prefer-file-system-access: true\r\n    suffix: .ftl\r\n    template-loader-path: classpath:/templates/\r\n    ', 'a9ecb96ea94233ecbbc8a309409f63c4', '2020-07-12 10:57:55', '2020-07-12 10:57:55', NULL, '127.0.0.1', 'U', '');
    INSERT INTO `his_config_info` VALUES (4, 26, 'whale-user-centre-dev.yml', 'DEFAULT_GROUP', '', 'security:\r\n  oauth2:\r\n    client:\r\n      ignore-urls:\r\n        - /druid/**\r\n        - /actuator/**\r\n        - /v2/api-docs\r\n# 数据源\r\nspring:\r\n  datasource:\r\n    type: com.alibaba.druid.pool.DruidDataSource\r\n    druid:\r\n      driver-class-name: com.mysql.cj.jdbc.Driver\r\n      username: ${MYSQL_USER:root}\r\n      password: ${MYSQL_PWD:123456789}\r\n      url: jdbc:mysql://${MYSQL_HOST:whalex-mysql}:${MYSQL_PORT:3306}/${MYSQL_DB:whalex-customer}?characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=GMT%2B8&allowMultiQueries=true&allowPublicKeyRetrieval=true\r\n      stat-view-servlet:\r\n        enabled: true\r\n        url-pattern: /druid/*\r\n        #login-username: admin\r\n        #login-password: admin\r\n      filter:\r\n        stat:\r\n          enabled: true\r\n          log-slow-sql: true\r\n          slow-sql-millis: 10000\r\n          merge-sql: false\r\n        wall:\r\n          config:\r\n            multi-statement-allow: true\r\n  freemarker:\r\n    allow-request-override: false\r\n    allow-session-override: false\r\n    cache: true\r\n    charset: UTF-8\r\n    check-template-location: true\r\n    content-type: text/html\r\n    enabled: true\r\n    expose-request-attributes: false\r\n    expose-session-attributes: false\r\n    expose-spring-macro-helpers: true\r\n    prefer-file-system-access: true\r\n    suffix: .ftl\r\n    template-loader-path: classpath:/templates/\r\n\r\n# Logger Config\r\nlogging:\r\n  level:\r\n    com.whalex.usercentre.mapper: debug', '6830c462a30696ad0587fdd89433e4eb', '2020-07-12 13:32:03', '2020-07-12 13:32:03', NULL, '127.0.0.1', 'U', '');

    -- ----------------------------
    -- Table structure for permissions
    -- ----------------------------
    DROP TABLE IF EXISTS `permissions`;
    CREATE TABLE `permissions`  (
      `role` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
      `resource` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
      `action` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
      UNIQUE INDEX `uk_role_permission`(`role`, `resource`, `action`) USING BTREE
    ) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

    -- ----------------------------
    -- Table structure for roles
    -- ----------------------------
    DROP TABLE IF EXISTS `roles`;
    CREATE TABLE `roles`  (
      `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
      `role` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
      UNIQUE INDEX `idx_user_role`(`username`, `role`) USING BTREE
    ) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

    -- ----------------------------
    -- Records of roles
    -- ----------------------------
    INSERT INTO `roles` VALUES ('nacos', 'ROLE_ADMIN');

    -- ----------------------------
    -- Table structure for tenant_capacity
    -- ----------------------------
    DROP TABLE IF EXISTS `tenant_capacity`;
    CREATE TABLE `tenant_capacity`  (
      `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键ID',
      `tenant_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT 'Tenant ID',
      `quota` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '配额，0表示使用默认值',
      `usage` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '使用量',
      `max_size` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '单个配置大小上限，单位为字节，0表示使用默认值',
      `max_aggr_count` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '聚合子配置最大个数',
      `max_aggr_size` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '单个聚合数据的子配置大小上限，单位为字节，0表示使用默认值',
      `max_history_count` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '最大变更历史数量',
      `gmt_create` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
      `gmt_modified` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
      PRIMARY KEY (`id`) USING BTREE,
      UNIQUE INDEX `uk_tenant_id`(`tenant_id`) USING BTREE
    ) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '租户容量信息表' ROW_FORMAT = Dynamic;

    -- ----------------------------
    -- Table structure for tenant_info
    -- ----------------------------
    DROP TABLE IF EXISTS `tenant_info`;
    CREATE TABLE `tenant_info`  (
      `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
      `kp` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'kp',
      `tenant_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT '' COMMENT 'tenant_id',
      `tenant_name` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT '' COMMENT 'tenant_name',
      `tenant_desc` varchar(256) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'tenant_desc',
      `create_source` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'create_source',
      `gmt_create` bigint(20) NOT NULL COMMENT '创建时间',
      `gmt_modified` bigint(20) NOT NULL COMMENT '修改时间',
      PRIMARY KEY (`id`) USING BTREE,
      UNIQUE INDEX `uk_tenant_info_kptenantid`(`kp`, `tenant_id`) USING BTREE,
      INDEX `idx_tenant_id`(`tenant_id`) USING BTREE
    ) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = 'tenant_info' ROW_FORMAT = Dynamic;

    -- ----------------------------
    -- Table structure for users
    -- ----------------------------
    DROP TABLE IF EXISTS `users`;
    CREATE TABLE `users`  (
      `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
      `password` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
      `enabled` tinyint(1) NOT NULL,
      PRIMARY KEY (`username`) USING BTREE
    ) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

    -- ----------------------------
    -- Records of users
    -- ----------------------------
    INSERT INTO `users` VALUES ('nacos', '$2a$10$EuWPZHzz32dJN7jexM34MOeYirDdFAZm2kuWj7VEOJhhZkDrxfvUu', 1);

    SET FOREIGN_KEY_CHECKS = 1;
