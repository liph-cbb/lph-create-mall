
-- 拦截策略表
DROP TABLE IF EXISTS `t_firewall_trigger_strategy`;
CREATE TABLE `t_firewall_trigger_strategy` (
`id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
`name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
`label` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
`is_active` tinyint(1) NULL DEFAULT NULL,
`crt_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP,
PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = 'sql的操作类型' ROW_FORMAT = Dynamic;
