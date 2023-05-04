CREATE TABLE `sys_user` (
                            `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
                            `is_deleted` tinyint NOT NULL DEFAULT '0' COMMENT '是否删除',
                            `version` int NOT NULL DEFAULT '1' COMMENT '版本',
                            `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                            `modified_time` datetime DEFAULT NULL COMMENT '修改时间',
                            `username` varchar(16) COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户名',
                            `password` varchar(60) COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码',
                            PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


CREATE TABLE `sys_log` (
                           `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
                           `is_deleted` tinyint NOT NULL DEFAULT '0' COMMENT '是否删除',
                           `version` int NOT NULL DEFAULT '1' COMMENT '版本',
                           `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                           `modified_time` datetime DEFAULT NULL COMMENT '修改时间',
                           `operator` varchar(16) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '操作人',
                           `execution_time` bigint DEFAULT NULL COMMENT '执行所用时间（毫秒）',
                           `request_method` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '请求方法',
                           `param` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '入参',
                           `result` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '返回结果',
                           `ip` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT 'ip',
                           `description` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '描述',
                           `module` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '模块',
                           `request_uri` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT 'uri',
                           PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `test_student` (
                                `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
                                `is_deleted` tinyint NOT NULL DEFAULT '0' COMMENT '是否删除',
                                `version` int NOT NULL DEFAULT '1' COMMENT '版本',
                                `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                                `modified_time` datetime DEFAULT NULL COMMENT '修改时间',
                                `name` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '姓名',
                                `age` int DEFAULT NULL COMMENT '年龄',
                                PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;




INSERT INTO ashitaka.sys_user (is_deleted,version,create_time,modified_time,username,password) VALUES
    (0,1,'2023-05-04 10:52:15','2023-05-04 10:52:15','admin','$2a$10$EAE5QidZxmzqQT68eCHDnuhIQ421W2XKFz/Mdz7vexW.mcuBXZd3S');
