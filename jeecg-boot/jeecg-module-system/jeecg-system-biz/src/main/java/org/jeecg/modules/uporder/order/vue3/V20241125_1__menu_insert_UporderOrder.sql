-- 注意：该页面对应的前台目录为views/order文件夹下
-- 如果你想更改到其他目录，请修改sql中component字段对应的值


INSERT INTO sys_permission(id, parent_id, name, url, component, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_route, is_leaf, keep_alive, hidden, hide_tab, description, status, del_flag, rule_flag, create_by, create_time, update_by, update_time, internal_or_external) 
VALUES ('2024112505258540480', NULL, '订单表', '/order/uporderOrderList', 'order/UporderOrderList', NULL, NULL, 0, NULL, '1', 0.00, 0, NULL, 1, 0, 0, 0, 0, NULL, '1', 0, 0, 'admin', '2024-11-25 17:25:48', NULL, NULL, 0);

-- 权限控制sql
-- 新增
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024112505258540481', '2024112505258540480', '添加订单表', NULL, NULL, 0, NULL, NULL, 2, 'order:uporder_order:add', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-11-25 17:25:48', NULL, NULL, 0, 0, '1', 0);
-- 编辑
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024112505258540482', '2024112505258540480', '编辑订单表', NULL, NULL, 0, NULL, NULL, 2, 'order:uporder_order:edit', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-11-25 17:25:48', NULL, NULL, 0, 0, '1', 0);
-- 删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024112505258540483', '2024112505258540480', '删除订单表', NULL, NULL, 0, NULL, NULL, 2, 'order:uporder_order:delete', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-11-25 17:25:48', NULL, NULL, 0, 0, '1', 0);
-- 批量删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024112505258540484', '2024112505258540480', '批量删除订单表', NULL, NULL, 0, NULL, NULL, 2, 'order:uporder_order:deleteBatch', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-11-25 17:25:48', NULL, NULL, 0, 0, '1', 0);
-- 导出excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024112505258540485', '2024112505258540480', '导出excel_订单表', NULL, NULL, 0, NULL, NULL, 2, 'order:uporder_order:exportXls', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-11-25 17:25:48', NULL, NULL, 0, 0, '1', 0);
-- 导入excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024112505258540486', '2024112505258540480', '导入excel_订单表', NULL, NULL, 0, NULL, NULL, 2, 'order:uporder_order:importExcel', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-11-25 17:25:48', NULL, NULL, 0, 0, '1', 0);