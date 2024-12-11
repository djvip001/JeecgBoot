-- 注意：该页面对应的前台目录为views/usertype文件夹下
-- 如果你想更改到其他目录，请修改sql中component字段对应的值


INSERT INTO sys_permission(id, parent_id, name, url, component, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_route, is_leaf, keep_alive, hidden, hide_tab, description, status, del_flag, rule_flag, create_by, create_time, update_by, update_time, internal_or_external) 
VALUES ('202412111006490520', NULL, '用户类型', '/usertype/uporderUserTypeList', 'usertype/UporderUserTypeList', NULL, NULL, 0, NULL, '1', 0.00, 0, NULL, 1, 0, 0, 0, 0, NULL, '1', 0, 0, 'admin', '2024-12-11 22:06:52', NULL, NULL, 0);

-- 权限控制sql
-- 新增
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('202412111006490521', '202412111006490520', '添加用户类型', NULL, NULL, 0, NULL, NULL, 2, 'usertype:uporder_user_type:add', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-12-11 22:06:52', NULL, NULL, 0, 0, '1', 0);
-- 编辑
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('202412111006490522', '202412111006490520', '编辑用户类型', NULL, NULL, 0, NULL, NULL, 2, 'usertype:uporder_user_type:edit', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-12-11 22:06:52', NULL, NULL, 0, 0, '1', 0);
-- 删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('202412111006490523', '202412111006490520', '删除用户类型', NULL, NULL, 0, NULL, NULL, 2, 'usertype:uporder_user_type:delete', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-12-11 22:06:52', NULL, NULL, 0, 0, '1', 0);
-- 批量删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('202412111006490524', '202412111006490520', '批量删除用户类型', NULL, NULL, 0, NULL, NULL, 2, 'usertype:uporder_user_type:deleteBatch', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-12-11 22:06:52', NULL, NULL, 0, 0, '1', 0);
-- 导出excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('202412111006490525', '202412111006490520', '导出excel_用户类型', NULL, NULL, 0, NULL, NULL, 2, 'usertype:uporder_user_type:exportXls', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-12-11 22:06:52', NULL, NULL, 0, 0, '1', 0);
-- 导入excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('202412111006490526', '202412111006490520', '导入excel_用户类型', NULL, NULL, 0, NULL, NULL, 2, 'usertype:uporder_user_type:importExcel', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-12-11 22:06:52', NULL, NULL, 0, 0, '1', 0);