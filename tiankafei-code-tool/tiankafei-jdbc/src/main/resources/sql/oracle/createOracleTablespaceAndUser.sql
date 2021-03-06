--创建临时表空间
CREATE TEMPORARY TABLESPACE TIANKAFEI_TEMP TEMPFILE 'D:\software\Oracle\oradata\master\TIANKAFEI_TEMP.DBF' SIZE 1024 M AUTOEXTEND ON NEXT 128 M MAXSIZE UNLIMITED EXTENT MANAGEMENT LOCAL;

--创建表空间
CREATE TABLESPACE TIANKAFEI DATAFILE 'D:\software\Oracle\oradata\master\TIANKAFEI.DBF' SIZE 1024 M AUTOEXTEND ON NEXT 128 M MAXSIZE UNLIMITED EXTENT MANAGEMENT LOCAL;

--创建用户并指定表空间
CREATE USER tiankafei IDENTIFIED BY tiankafei DEFAULT TABLESPACE TIANKAFEI TEMPORARY TABLESPACE TIANKAFEI_TEMP;
--授权用户登陆数据库权限(system名下)
GRANT CONNECT TO tiankafei;
--授予tiankafei用户创建session的权限，即登陆权限
GRANT CREATE SESSION TO tiankafei;
--授权用户创建表权限(system名下)
GRANT RESOURCE TO tiankafei;
--授权用户DBA权限
GRANT DBA TO tiankafei;

--清空回收站
purge recyclebin;
SELECT *
FROM tab t;


--查询临时表空间(名字，路径，大小，是否自增)
SELECT TABLESPACE_NAME, FILE_NAME, BYTES / 1024 / 1024 FILE_SIZE, AUTOEXTENSIBLE
FROM DBA_TEMP_FILES;

--查询表空间(名字，路经，总大小，实际可用大小，使用百分比)
SELECT TV.TABLESPACE_NAME                           "TABLESPACE_NAME",
       TV.FILE_NAME,
       TOTALSPACE                                   "TOTALSPACE/M",
       FREESPACE                                    "FREESPACE/M",
       ROUND((1 - FREESPACE / TOTALSPACE) * 100, 2) "USED%"
FROM (SELECT TABLESPACE_NAME, FILE_NAME, ROUND(SUM(BYTES) / 1024 / 1024) TOTALSPACE
      FROM DBA_DATA_FILES
      GROUP BY TABLESPACE_NAME, FILE_NAME) TV,
     (SELECT TABLESPACE_NAME, ROUND(SUM(BYTES) / 1024 / 1024) FREESPACE
      FROM DBA_FREE_SPACE
      GROUP BY TABLESPACE_NAME) FS
WHERE TV.TABLESPACE_NAME = FS.TABLESPACE_NAME;

--查看当前用户所有权限
SELECT *
FROM USER_SYS_PRIVS;
