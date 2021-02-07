-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('功能管理', '2000', '1', 'features', 'business/features/index', 1, 0, 'C', '0', '0', 'sys:features:info:pageList', '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '功能管理菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('功能管理查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'sys:features:info:info',        '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('功能管理新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'sys:features:info:add',          '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('功能管理修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'sys:features:info:update',         '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('功能管理删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'sys:features:info:batchDelete',       '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');