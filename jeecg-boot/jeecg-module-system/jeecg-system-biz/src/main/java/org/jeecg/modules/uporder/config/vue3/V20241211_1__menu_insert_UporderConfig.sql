-- 注意：该页面对应的前台目录为views/config文件夹下
-- 如果你想更改到其他目录，请修改sql中component字段对应的值


INSERT INTO sys_permission(id, parent_id, name, url, component, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_route, is_leaf, keep_alive, hidden, hide_tab, description, status, del_flag, rule_flag, create_by, create_time, update_by, update_time, internal_or_external) 
VALUES ('2024121110307290520', NULL, '上级配置', '/config/uporderConfigList', 'config/UporderConfigList', NULL, NULL, 0, NULL, '1', 0.00, 0, NULL, 1, 0, 0, 0, 0, NULL, '1', 0, 0, 'admin', '2024-12-11 22:30:52', NULL, NULL, 0);

-- 权限控制sql
-- 新增
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024121110307290521', '2024121110307290520', '添加上级配置', NULL, NULL, 0, NULL, NULL, 2, 'config:uporder_config:add', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-12-11 22:30:52', NULL, NULL, 0, 0, '1', 0);
-- 编辑
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024121110307290522', '2024121110307290520', '编辑上级配置', NULL, NULL, 0, NULL, NULL, 2, 'config:uporder_config:edit', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-12-11 22:30:52', NULL, NULL, 0, 0, '1', 0);
-- 删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024121110307290523', '2024121110307290520', '删除上级配置', NULL, NULL, 0, NULL, NULL, 2, 'config:uporder_config:delete', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-12-11 22:30:52', NULL, NULL, 0, 0, '1', 0);
-- 批量删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024121110307290524', '2024121110307290520', '批量删除上级配置', NULL, NULL, 0, NULL, NULL, 2, 'config:uporder_config:deleteBatch', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-12-11 22:30:52', NULL, NULL, 0, 0, '1', 0);
-- 导出excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024121110307290525', '2024121110307290520', '导出excel_上级配置', NULL, NULL, 0, NULL, NULL, 2, 'config:uporder_config:exportXls', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-12-11 22:30:52', NULL, NULL, 0, 0, '1', 0);
-- 导入excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024121110307290526', '2024121110307290520', '导入excel_上级配置', NULL, NULL, 0, NULL, NULL, 2, 'config:uporder_config:importExcel', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-12-11 22:30:52', NULL, NULL, 0, 0, '1', 0);