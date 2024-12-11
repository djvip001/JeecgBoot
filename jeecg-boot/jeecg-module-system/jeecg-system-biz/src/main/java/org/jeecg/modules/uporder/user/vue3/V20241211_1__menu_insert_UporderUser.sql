-- 注意：该页面对应的前台目录为views/user文件夹下
-- 如果你想更改到其他目录，请修改sql中component字段对应的值


INSERT INTO sys_permission(id, parent_id, name, url, component, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_route, is_leaf, keep_alive, hidden, hide_tab, description, status, del_flag, rule_flag, create_by, create_time, update_by, update_time, internal_or_external) 
VALUES ('2024121110192190080', NULL, '用户管理', '/user/uporderUserList', 'user/UporderUserList', NULL, NULL, 0, NULL, '1', 0.00, 0, NULL, 1, 0, 0, 0, 0, NULL, '1', 0, 0, 'admin', '2024-12-11 22:19:08', NULL, NULL, 0);

-- 权限控制sql
-- 新增
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024121110192200081', '2024121110192190080', '添加用户管理', NULL, NULL, 0, NULL, NULL, 2, 'user:uporder_user:add', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-12-11 22:19:08', NULL, NULL, 0, 0, '1', 0);
-- 编辑
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024121110192200082', '2024121110192190080', '编辑用户管理', NULL, NULL, 0, NULL, NULL, 2, 'user:uporder_user:edit', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-12-11 22:19:08', NULL, NULL, 0, 0, '1', 0);
-- 删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024121110192200083', '2024121110192190080', '删除用户管理', NULL, NULL, 0, NULL, NULL, 2, 'user:uporder_user:delete', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-12-11 22:19:08', NULL, NULL, 0, 0, '1', 0);
-- 批量删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024121110192200084', '2024121110192190080', '批量删除用户管理', NULL, NULL, 0, NULL, NULL, 2, 'user:uporder_user:deleteBatch', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-12-11 22:19:08', NULL, NULL, 0, 0, '1', 0);
-- 导出excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024121110192200085', '2024121110192190080', '导出excel_用户管理', NULL, NULL, 0, NULL, NULL, 2, 'user:uporder_user:exportXls', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-12-11 22:19:08', NULL, NULL, 0, 0, '1', 0);
-- 导入excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024121110192200086', '2024121110192190080', '导入excel_用户管理', NULL, NULL, 0, NULL, NULL, 2, 'user:uporder_user:importExcel', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-12-11 22:19:08', NULL, NULL, 0, 0, '1', 0);