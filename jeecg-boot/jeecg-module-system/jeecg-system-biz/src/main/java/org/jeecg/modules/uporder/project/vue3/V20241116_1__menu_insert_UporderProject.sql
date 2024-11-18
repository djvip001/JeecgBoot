-- 注意：该页面对应的前台目录为views/uporderProject文件夹下
-- 如果你想更改到其他目录，请修改sql中component字段对应的值


INSERT INTO sys_permission(id, parent_id, name, url, component, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_route, is_leaf, keep_alive, hidden, hide_tab, description, status, del_flag, rule_flag, create_by, create_time, update_by, update_time, internal_or_external) 
VALUES ('2024111603246740370', NULL, '报单项目', '/uporderProject/uporderProjectList', 'uporderProject/UporderProjectList', NULL, NULL, 0, NULL, '1', 0.00, 0, NULL, 1, 0, 0, 0, 0, NULL, '1', 0, 0, 'admin', '2024-11-16 15:24:37', NULL, NULL, 0);

-- 权限控制sql
-- 新增
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024111603246740371', '2024111603246740370', '添加报单项目', NULL, NULL, 0, NULL, NULL, 2, 'uporderProject:uporder_project:add', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-11-16 15:24:37', NULL, NULL, 0, 0, '1', 0);
-- 编辑
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024111603246740372', '2024111603246740370', '编辑报单项目', NULL, NULL, 0, NULL, NULL, 2, 'uporderProject:uporder_project:edit', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-11-16 15:24:37', NULL, NULL, 0, 0, '1', 0);
-- 删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024111603246740373', '2024111603246740370', '删除报单项目', NULL, NULL, 0, NULL, NULL, 2, 'uporderProject:uporder_project:delete', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-11-16 15:24:37', NULL, NULL, 0, 0, '1', 0);
-- 批量删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024111603246750374', '2024111603246740370', '批量删除报单项目', NULL, NULL, 0, NULL, NULL, 2, 'uporderProject:uporder_project:deleteBatch', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-11-16 15:24:37', NULL, NULL, 0, 0, '1', 0);
-- 导出excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024111603246750375', '2024111603246740370', '导出excel_报单项目', NULL, NULL, 0, NULL, NULL, 2, 'uporderProject:uporder_project:exportXls', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-11-16 15:24:37', NULL, NULL, 0, 0, '1', 0);
-- 导入excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024111603246750376', '2024111603246740370', '导入excel_报单项目', NULL, NULL, 0, NULL, NULL, 2, 'uporderProject:uporder_project:importExcel', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-11-16 15:24:37', NULL, NULL, 0, 0, '1', 0);