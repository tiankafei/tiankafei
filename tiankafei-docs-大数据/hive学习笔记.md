# Hive学习笔记

## Hive产生的原因

1. 方便对文件及数据的元数据进行管理，提供统一的元数据管理方式
2. 提供更加简单的方式来访问大规模的数据集，使用SQL语言进行数据分析

## hive是什么

<font color="red">**企业级数据仓库** </font>

Hive使用SQL语句来进行数据分析，由SQL语句到具体的任务执行还需要经过解释器，编译器，优化器，执行器四部分才能完成。

1. 解释器：调用语法解释器和语义分析器将SQL语句转换成对应的可执行的java代码或者业务代码
2. 编译器：将对应的java代码转换成字节码文件或者jar包
3. 优化器：从SQL语句到java代码的解析转化过程中需要调用优化器，进行相关策略的优化，实现最优的查询性能
4. 执行器：当业务代码转换完成之后，需要上传到MapReduce的集群中执行

## 数据仓库

​		数据处理大致可以分成两大类：联机事务处理OLTP（on-line transaction processing）、联机分析处理OLAP（On-Line Analytical Processing）。OLTP是传统的关系型数据库的主要应用，主要是基本的、日常的事务处理，例如银行交易。OLAP是数据仓库系统的主要应用，支持复杂的分析操作，侧重决策支持，并且提供直观易懂的查询结果。

### OLTP

​		OLTP，也叫联机事务处理（Online Transaction Processing），表示事务性非常高的系统，一般都是高可用的在线系统，以小的事务以及小的查询为主，评估其系统的时候，一般看其每秒执行的Transaction以及Execute SQL的数量。在这样的系统中，单个数据库每秒处理的Transaction往往超过几百个，或者是几千个，Select 语句的执行量每秒几千甚至几万个。典型的OLTP系统有电子商务系统、银行、证券等，如美国eBay的业务数据库，就是很典型的OLTP数据库。

### OLAP

​		OLAP（On-Line Analysis Processing）在线分析处理是一种共享多维信息的快速分析技术；OLAP利用多维数据库技术使用户从不同角度观察数据；OLAP用于支持复杂的分析操作，侧重于对管理人员的决策支持，可以满足分析人员快速、灵活地进行大数据复量的复杂查询的要求，并且以一种直观、易懂的形式呈现查询结果，辅助决策。

## 数据库与数据仓库的区别

1. 数据库是对业务系统的支撑，性能要求高，相应的时间短，而数据仓库则对响应时间没有太多的要求，当然也是越快越好
2. 数据库存储的是某一个产品线或者某个业务线的数据，数据仓库可以将多个数据源的数据经过统一的规则清洗之后进行集中统一管理
3. 数据库中存储的数据可以修改，无法保存各个历史时刻的数据，数据仓库可以保存各个时间点的数据，形成时间拉链表，可以对各个历史时刻的数据做分析
4. 数据库一次操作的数据量小，数据仓库操作的数据量大
5. 数据库使用的是实体-关系（E-R）模型，数据仓库使用的是星型模型或者雪花模型
6. 数据库是面向事务级别的操作，数据仓库是面向分析的操作

## Hive的架构图

![hive架构图](./images/hive架构图.png)

## Hive的服务（角色）

### 用户访问接口

1. CLI（Command Line Interface）：用户可以使用Hive自带的命令行接口执行Hive QL、设置参数等功能。
2. JDBC/ODBC：用户可以使用JDBC或者ODBC的方式在代码中操作Hive。
3. Web GUI：浏览器接口，用户可以在浏览器中对Hive进行操作（2.2之后淘汰）。

### Thrift Server:

> Thrift服务运行客户端使用Java、C++、Ruby等多种语言，通过编程的方式远程访问Hive。

### Driver

> Hive Driver是Hive的核心，其中包含解释器、编译器、优化器等各个组件，完成从SQL语句到MapReduce任务的解析优化执行过程。

### metastore

> Hive的元数据存储服务，一般将数据存储在关系型数据库中，为了实现Hive元数据的持久化操作，Hive的安装包中自带了Derby内存数据库，但是在实际的生产环境中一般使用mysql来存储元数据。

### Hive的访问流程图

![访问流程图](./images/访问流程图.png)

## Hive的基本SQL操作

### Hive DDL（数据库定义语言）

#### 数据库的基本操作

> 注意：当进入hive的命令行开始编写SQL语句的时候，如果没有任何相关的数据库操作，那么默认情况下，所有的表存在于default数据库，在hdfs上的展示形式是将此数据库的表保存在hive的默认路径下，如果创建了数据库，那么会在hive的默认路径下生成一个database_name.db的文件夹，此数据库的所有表会保存在database_name.db的目录下。

##### 展示所有数据库

```sql
--展示所有数据库
show databases;
```

##### 切换数据库

```sql
--切换数据库
use database_name;
```

##### 创建数据库

```sql
/*创建数据库		
CREATE (DATABASE|SCHEMA) [IF NOT EXISTS] database_name
  [COMMENT database_comment]
  [LOCATION hdfs_path]
  [WITH DBPROPERTIES (property_name=property_value, ...)];
*/
create database test;
```

##### 删除数据库

```sql
/*
删除数据库	
DROP (DATABASE|SCHEMA) [IF EXISTS] database_name [RESTRICT|CASCADE];	
*/
drop database database_name;
```

#### 数据库表的基本操作

##### 创建表的语法

```sql
/*
	创建表的操作
		基本语法：
		CREATE [TEMPORARY] [EXTERNAL] TABLE [IF NOT EXISTS] [db_name.]table_name    -- 			(Note: TEMPORARY available in Hive 0.14.0 and later)
  		[(col_name data_type [COMMENT col_comment], ... [constraint_specification])]
  		[COMMENT table_comment]
  		[PARTITIONED BY (col_name data_type [COMMENT col_comment], ...)]
  		[CLUSTERED BY (col_name, col_name, ...) [SORTED BY (col_name [ASC|DESC], ...)] 				INTO num_buckets BUCKETS]
  		[SKEWED BY (col_name, col_name, ...)                  -- (Note: Available in Hive 			0.10.0 and later)]
     	ON ((col_value, col_value, ...), (col_value, col_value, ...), ...)
     	[STORED AS DIRECTORIES]
  		[
   			[ROW FORMAT row_format] 
   			[STORED AS file_format]
     		| STORED BY 'storage.handler.class.name' [WITH SERDEPROPERTIES (...)]  -- 				(Note: Available in Hive 0.6.0 and later)
  		]
  		[LOCATION hdfs_path]
  		[TBLPROPERTIES (property_name=property_value, ...)]   -- (Note: Available in Hive 			0.6.0 and later)
  		[AS select_statement];   -- (Note: Available in Hive 0.5.0 and later; not 					supported for external tables)
 
		CREATE [TEMPORARY] [EXTERNAL] TABLE [IF NOT EXISTS] [db_name.]table_name
  			LIKE existing_table_or_view_name
  		[LOCATION hdfs_path];
 		复杂数据类型
		data_type
  		 : primitive_type
  		 | array_type
  		 | map_type
  		 | struct_type
  		 | union_type  -- (Note: Available in Hive 0.7.0 and later)
 		基本数据类型
		primitive_type
 		 : TINYINT
 		 | SMALLINT
 		 | INT
 		 | BIGINT
 		 | BOOLEAN
 		 | FLOAT
 		 | DOUBLE
  		 | DOUBLE PRECISION -- (Note: Available in Hive 2.2.0 and later)
 		 | STRING
 		 | BINARY      -- (Note: Available in Hive 0.8.0 and later)
 		 | TIMESTAMP   -- (Note: Available in Hive 0.8.0 and later)
 		 | DECIMAL     -- (Note: Available in Hive 0.11.0 and later)
 		 | DECIMAL(precision, scale)  -- (Note: Available in Hive 0.13.0 and later)
 		 | DATE        -- (Note: Available in Hive 0.12.0 and later)
 		 | VARCHAR     -- (Note: Available in Hive 0.12.0 and later)
 		 | CHAR        -- (Note: Available in Hive 0.13.0 and later)
 
		array_type
 		 : ARRAY < data_type >
 
		map_type
 		 : MAP < primitive_type, data_type >
 
		struct_type
 		 : STRUCT < col_name : data_type [COMMENT col_comment], ...>
 
		union_type
  		 : UNIONTYPE < data_type, data_type, ... >  -- (Note: Available in Hive 0.7.0 and 			later)
 		行格式规范
		row_format
 		 : DELIMITED [FIELDS TERMINATED BY char [ESCAPED BY char]] [COLLECTION ITEMS 				TERMINATED BY char]
 	       [MAP KEYS TERMINATED BY char] [LINES TERMINATED BY char]
	       [NULL DEFINED AS char]   -- (Note: Available in Hive 0.13 and later)
  			| SERDE serde_name [WITH SERDEPROPERTIES (property_name=property_value, 				property_name=property_value, ...)]
 		文件基本类型
		file_format:
 		 : SEQUENCEFILE
 		 | TEXTFILE    -- (Default, depending on hive.default.fileformat configuration)
 		 | RCFILE      -- (Note: Available in Hive 0.6.0 and later)
 		 | ORC         -- (Note: Available in Hive 0.11.0 and later)
 		 | PARQUET     -- (Note: Available in Hive 0.13.0 and later)
 		 | AVRO        -- (Note: Available in Hive 0.14.0 and later)
 		 | JSONFILE    -- (Note: Available in Hive 4.0.0 and later)
 		 | INPUTFORMAT input_format_classname OUTPUTFORMAT output_format_classname
 		表约束
		constraint_specification:
 		 : [, PRIMARY KEY (col_name, ...) DISABLE NOVALIDATE ]
 		   [, CONSTRAINT constraint_name FOREIGN KEY (col_name, ...) REFERENCES 					table_name(col_name, ...) DISABLE NOVALIDATE 
*/
```

##### 创建普通hive表（不包含行定义格式）

```sql
-- 创建普通hive表（不包含行定义格式）
create table psn
(
	id int,
	name string,
	likes array<string>,
	address map<string,string>
)
```

##### 创建自定义行格式的hive表

```sql
-- 创建自定义行格式的hive表
create table psn2
	(
	id int,
	name string,
	likes array<string>,
	address map<string,string>
)
row format delimited
fields terminated by ','
collection items terminated by '-'
map keys terminated by ':';
```

##### 创建默认分隔符的hive表（^A、^B、^C）

```sql
-- 创建默认分隔符的hive表（^A、^B、^C）
create table psn3
(
	id int,
	name string,
	likes array<string>,
	address map<string,string>
)
row format delimited
fields terminated by '\001'
collection items terminated by '\002'
map keys terminated by '\003';
-- 或者
create table psn3
(
	id int,
	name string,
	likes array<string>,
	address map<string,string>
)
```

##### 创建hive的外部表

```sql
-- 创建hive的外部表(需要添加external和location的关键字)
create external table psn4
(
	id int,
	name string,
	likes array<string>,
	address map<string,string>
)
row format delimited
fields terminated by ','
collection items terminated by '-'
map keys terminated by ':'
location '/data';
/*
在之前创建的表都属于hive的内部表（psn,psn2,psn3）,而psn4属于hive的外部表，
内部表跟外部表的区别：
	1、hive内部表创建的时候数据存储在hive的默认存储目录中，外部表在创建的时候需要制定额外的目录
	2、hive内部表删除的时候，会将元数据和数据都删除，而外部表只会删除元数据，不会删除数据
应用场景:
	内部表:需要先创建表，然后向表中添加数据，适合做中间表的存储
	外部表：可以先创建表，再添加数据，也可以先有数据，再创建表，本质上是将hdfs的某一个目录的数据跟				hive的表关联映射起来，因此适合原始数据的存储，不会因为误操作将数据给删除掉
*/	
```

##### Hive分区表

> hive的分区表：
>
> **hive默认将表的数据保存在某一个hdfs的存储目录下，当需要检索符合条件的某一部分数据的时候，需要全量遍历数据，io量比较大，效率比较低，因此可以采用分而治之的思想，将符合某些条件的数据放置在某一个目录，此时检索的时候只需要搜索指定目录即可，不需要全量遍历数据。**

##### 创建单分区表

```sql
-- 创建单分区表
create table psn5
(
	id int,
	name string,
	likes array<string>,
	address map<string,string>
)
partitioned by(gender string)
row format delimited
fields terminated by ','
collection items terminated by '-'
map keys terminated by ':';
```

##### 创建多分区表

```sql
-- 创建多分区表
create table psn6
(
	id int,
	name string,
	likes array<string>,
	address map<string,string>
)
partitioned by(gender string,age int)
row format delimited
fields terminated by ','
collection items terminated by '-'
map keys terminated by ':';	
/*
注意：
	1、当创建完分区表之后，在保存数据的时候，会在hdfs目录中看到分区列会成为一个目录，以多级目录的形式存在
	2、当创建多分区表之后，插入数据的时候不可以只添加一个分区列，需要将所有的分区列都添加值
	3、多分区表在添加分区列的值得时候，与顺序无关，与分区表的分区列的名称相关，按照名称就行匹配
*/	
```

##### 给分区表添加分区列的值

```sql
-- 给分区表添加分区列的值
alter table table_name add partition(col_name=col_value)

-- 注意：添加分区列的值的时候，如果定义的是多分区表，那么必须给所有的分区列都赋值
```

##### 删除分区列的值

```sql
-- 删除分区列的值
alter table table_name drop partition(col_name=col_value)

-- 注意：删除分区列的值的时候，无论是单分区表还是多分区表，都可以将指定的分区进行删除
```

##### 修复分区

```sql
/*
修复分区:
	在使用hive外部表的时候，可以先将数据上传到hdfs的某一个目录中，然后再创建外部表建立映射关系，如果在上传数据的时候，参考分区表的形式也创建了多级目录，那么此时创建完表之后，是查询不到数据的，原因是分区的元数据没有保存在mysql中，因此需要修复分区，将元数据同步更新到mysql中，此时才可以查询到元数据。具体操作如下：
*/

-- 在hdfs创建目录并上传文件
hdfs dfs -mkdir /msb
hdfs dfs -mkdir /msb/age=10
hdfs dfs -mkdir /msb/age=20
hdfs dfs -put /root/data/data /msb/age=10
hdfs dfs -put /root/data/data /msb/age=20

-- 创建外部表
create external table psn7
(
	id int,
	name string,
	likes array<string>,
	address map<string,string>
)
partitioned by(age int)
row format delimited
fields terminated by ','
collection items terminated by '-'
map keys terminated by ':'
location '/msb';
-- 查询结果（没有数据）
select * from psn7;
-- 修复分区
msck repair table psn7;
-- 查询结果（有数据）
select * from psn7;

/*
问题：
	以上面的方式创建hive的分区表会存在问题，每次插入的数据都是人为指定分区列的值，我们更加希望能够根据记录中的某一个字段来判断将数据插入到哪一个分区目录下，此时利用我们上面的分区方式是无法完成操作的，需要使用动态分区来完成相关操作。
*/
```

### Hive DML

#### 加载文件到表中

**Loading files into tables**

```sql
/*
记载数据文件到某一张表中
语法：
	LOAD DATA [LOCAL] INPATH 'filepath' [OVERWRITE] INTO TABLE tablename [PARTITION 		(partcol1=val1, partcol2=val2 ...)]
 
	LOAD DATA [LOCAL] INPATH 'filepath' [OVERWRITE] INTO TABLE tablename [PARTITION 		(partcol1=val1, partcol2=val2 ...)] [INPUTFORMAT 'inputformat' SERDE 'serde']  (3.0 or later)
*/
-- 加载本地数据到hive表
load data local inpath '/root/data/data' into table psn;--(/root/data/data指的是本地		linux目录)
-- 加载hdfs数据文件到hive表
load data inpath '/data/data' into table psn;--(/data/data指的是hdfs的目录)
/*
注意：
	1、load操作不会对数据做任何的转换修改操作
	2、从本地linux load数据文件是复制文件的过程
	3、从hdfs load数据文件是移动文件的过程
	4、load操作也支持向分区表中load数据，只不过需要添加分区列的值
*/
```

#### 把查询到的数据插入数据到Hive的表中

**Inserting data into Hive Tables from queries**

```sql
/*
从查询语句中获取数据插入某张表
语法：
	Standard syntax:
	INSERT OVERWRITE TABLE tablename1 [PARTITION (partcol1=val1, partcol2=val2 ...) 			[IF NOT EXISTS]] select_statement1 FROM from_statement;
	INSERT INTO TABLE tablename1 [PARTITION (partcol1=val1, partcol2=val2 ...)] 				select_statement1 FROM from_statement;

	Hive extension (multiple inserts):
	FROM from_statement
	INSERT OVERWRITE TABLE tablename1 [PARTITION (partcol1=val1, partcol2=val2 ...) 			[IF NOT EXISTS]] select_statement1
	[INSERT OVERWRITE TABLE tablename2 [PARTITION ... [IF NOT EXISTS]] 							select_statement2]
	[INSERT INTO TABLE tablename2 [PARTITION ...] select_statement2] ...;
		FROM from_statement
	INSERT INTO TABLE tablename1 [PARTITION (partcol1=val1, partcol2=val2 ...)] 				select_statement1
	[INSERT INTO TABLE tablename2 [PARTITION ...] select_statement2]
	[INSERT OVERWRITE TABLE tablename2 [PARTITION ... [IF NOT EXISTS]] 							select_statement2] ...;

	Hive extension (dynamic partition inserts):
		INSERT OVERWRITE TABLE tablename PARTITION (partcol1[=val1], partcol2[=val2] 				...) select_statement FROM from_statement;
		INSERT INTO TABLE tablename PARTITION (partcol1[=val1], partcol2[=val2] ...) 				select_statement FROM from_statement;
*/
-- 注意：这种方式插入数据的时候需要预先创建好结果表
-- 从表中查询数据插入结果表
INSERT OVERWRITE TABLE psn9 SELECT id,name FROM psn
-- 从表中获取部分列插入到新表中
from psn
insert overwrite table psn9
select id,name 
insert into table psn10
select id
```

#### 把查询出的数据写到本地文件系统

**Writing data into the filesystem from queries**

```sql
/*
将查询到的结果插入到文件系统中
语法：	
Standard syntax:
	INSERT OVERWRITE [LOCAL] DIRECTORY directory1
	[ROW FORMAT row_format] [STORED AS file_format] (Note: Only available starting 			with Hive 0.11.0)
	SELECT ... FROM ...

Hive extension (multiple inserts):
	FROM from_statement
	INSERT OVERWRITE [LOCAL] DIRECTORY directory1 select_statement1
	[INSERT OVERWRITE [LOCAL] DIRECTORY directory2 select_statement2] ... 
	row_format
	: DELIMITED [FIELDS TERMINATED BY char [ESCAPED BY char]] [COLLECTION ITEMS 			TERMINATED BY char]
	[MAP KEYS TERMINATED BY char] [LINES TERMINATED BY char]
	[NULL DEFINED AS char] (Note: Only available starting with Hive 0.13)
*/
-- 注意：路径千万不要填写根目录，会把所有的数据文件都覆盖
-- 将查询到的结果导入到hdfs文件系统中
insert overwrite directory '/result' select * from psn;
-- 将查询的结果导入到本地文件系统中
insert overwrite local directory '/result' select * from psn;
```

#### 使用insert into 语句插入数据

**Inserting values into tables from SQL**

```sql
/*
使用传统关系型数据库的方式插入数据，效率较低
语法：
Standard Syntax:
	INSERT INTO TABLE tablename [PARTITION (partcol1[=val1], partcol2[=val2] ...)] 			VALUES values_row [, values_row ...]

Where values_row is:
	( value [, value ...] )
	where a value is either null or any valid SQL literal
*/
-- 插入数据
insert into psn values(1,'zhangsan')
```

#### 数据更新和删除

> 在官网中我们明确看到hive中是支持Update和Delete操作的，但是实际上，是需要事务的支持的，Hive对于事务的支持有很多的限制。因此，在使用hive的过程中，我们一般不会产生删除和更新的操作，如果你需要测试的话，参考下面如下配置：

![transaction_limitations](./images/transaction_limitations.png)

![update](./images/update.png)

```xml
<!-- 在hive的hive-site.xml中添加如下配置：-->
<property>
    <name>hive.support.concurrency</name>
    <value>true</value>
</property>
<property>
    <name>hive.enforce.bucketing</name>
    <value>true</value>
</property>
<property>
    <name>hive.exec.dynamic.partition.mode</name>
    <value>nonstrict</value>
</property>
<property>
    <name>hive.txn.manager</name>
    <value>org.apache.hadoop.hive.ql.lockmgr.DbTxnManager</value>
</property>
<property>
    <name>hive.compactor.initiator.on</name>
    <value>true</value>
</property>
<property>
    <name>hive.compactor.worker.threads</name>
    <value>1</value>
</property>
```

**执行测试**

```sql
-- 操作语句
create table test_trancaction (user_id Int,name String) clustered by (user_id) into 3 			buckets stored as orc TBLPROPERTIES ('transactional'='true');
create table test_insert_test(id int,name string) row format delimited fields 				  TERMINATED BY ',';
insert into test_trancaction select * from test_insert_test;
update test_trancaction set name='jerrick_up' where id=1;

-- 数据文件
1,jerrick
2,tom
3,jerry
4,lily
5,hanmei
6,limlei
7,lucky
```

### Hive Serde

> Hive Serde用来做序列化和反序列化，构建在数据存储和执行引擎之间，对两者实现解耦

#### 应用场景

1. hive主要用来存储结构化数据，如果结构化数据存储的格式嵌套比较复杂的时候，可以使用serde的方式，利用正则表达式匹配的方法来读取数据，例如，表字段如下：id,name,map<string,array<map<string,string>>>

2. 当读取数据的时候，数据的某些特殊格式不希望显示在数据中，如：

   192.168.57.4 - - [29/Feb/2019:18:14:35 +0800] "GET /bg-upper.png HTTP/1.1" 304 -

   不希望数据显示的时候包含[]或者"",此时可以考虑使用serde的方式

#### 语法规则

```sql
row_format
: DELIMITED 
  [FIELDS TERMINATED BY char [ESCAPED BY char]] 
  [COLLECTION ITEMS TERMINATED BY char] 
  [MAP KEYS TERMINATED BY char] 
  [LINES TERMINATED BY char] 
: SERDE serde_name [WITH SERDEPROPERTIES (property_name=property_value, property_name=property_value, ...)]
```

#### 应用案例

##### 数据文件

```
192.168.57.4 - - [29/Feb/2019:18:14:35 +0800] "GET /bg-upper.png HTTP/1.1" 304 -
192.168.57.4 - - [29/Feb/2019:18:14:35 +0800] "GET /bg-nav.png HTTP/1.1" 304 -
192.168.57.4 - - [29/Feb/2019:18:14:35 +0800] "GET /asf-logo.png HTTP/1.1" 304 -
192.168.57.4 - - [29/Feb/2019:18:14:35 +0800] "GET /bg-button.png HTTP/1.1" 304 -
192.168.57.4 - - [29/Feb/2019:18:14:35 +0800] "GET /bg-middle.png HTTP/1.1" 304 -
192.168.57.4 - - [29/Feb/2019:18:14:36 +0800] "GET / HTTP/1.1" 200 11217
192.168.57.4 - - [29/Feb/2019:18:14:36 +0800] "GET / HTTP/1.1" 200 11217
192.168.57.4 - - [29/Feb/2019:18:14:36 +0800] "GET /tomcat.css HTTP/1.1" 304 -
192.168.57.4 - - [29/Feb/2019:18:14:36 +0800] "GET /tomcat.png HTTP/1.1" 304 -
192.168.57.4 - - [29/Feb/2019:18:14:36 +0800] "GET /asf-logo.png HTTP/1.1" 304 -
192.168.57.4 - - [29/Feb/2019:18:14:36 +0800] "GET /bg-middle.png HTTP/1.1" 304 -
192.168.57.4 - - [29/Feb/2019:18:14:36 +0800] "GET /bg-button.png HTTP/1.1" 304 -
192.168.57.4 - - [29/Feb/2019:18:14:36 +0800] "GET /bg-nav.png HTTP/1.1" 304 -
192.168.57.4 - - [29/Feb/2019:18:14:36 +0800] "GET /bg-upper.png HTTP/1.1" 304 -
192.168.57.4 - - [29/Feb/2019:18:14:36 +0800] "GET / HTTP/1.1" 200 11217
192.168.57.4 - - [29/Feb/2019:18:14:36 +0800] "GET /tomcat.css HTTP/1.1" 304 -
192.168.57.4 - - [29/Feb/2019:18:14:36 +0800] "GET /tomcat.png HTTP/1.1" 304 -
192.168.57.4 - - [29/Feb/2019:18:14:36 +0800] "GET / HTTP/1.1" 200 11217
192.168.57.4 - - [29/Feb/2019:18:14:36 +0800] "GET /tomcat.css HTTP/1.1" 304 -
192.168.57.4 - - [29/Feb/2019:18:14:36 +0800] "GET /tomcat.png HTTP/1.1" 304 -
192.168.57.4 - - [29/Feb/2019:18:14:36 +0800] "GET /bg-button.png HTTP/1.1" 304 -
192.168.57.4 - - [29/Feb/2019:18:14:36 +0800] "GET /bg-upper.png HTTP/1.1" 304 -
```

##### 基本操作

```sql
-- 创建表
CREATE TABLE logtbl (
	host STRING,
	identity STRING,
	t_user STRING,
	time STRING,
	request STRING,
	referer STRING,
	agent STRING)
  ROW FORMAT SERDE 'org.apache.hadoop.hive.serde2.RegexSerDe'
  WITH SERDEPROPERTIES (
	"input.regex" = "([^ ]*) ([^ ]*) ([^ ]*) \\[(.*)\\] \"(.*)\" (-|[0-9]*) (-|[0-		9]*)"
  )
  STORED AS TEXTFILE;
-- 加载数据
load data local inpath '/root/data/log' into table logtbl;
-- 查询操作
select * from logtbl;
-- 数据显示如下（不包含[]和"）
192.168.57.4	-	-	29/Feb/2019:18:14:35 +0800	GET /bg-upper.png HTTP/1.1	304	-
192.168.57.4	-	-	29/Feb/2019:18:14:35 +0800	GET /bg-nav.png HTTP/1.1	304	-
192.168.57.4	-	-	29/Feb/2019:18:14:35 +0800	GET /asf-logo.png HTTP/1.1	304	-
192.168.57.4	-	-	29/Feb/2019:18:14:35 +0800	GET /bg-button.png HTTP/1.1	304	-
192.168.57.4	-	-	29/Feb/2019:18:14:35 +0800	GET /bg-middle.png HTTP/1.1	304	-
```

## HiveServer2

### pom依赖

```xml
<!-- https://mvnrepository.com/artifact/org.apache.hive/hive-jdbc -->
<dependency>
    <groupId>org.apache.hive</groupId>
    <artifactId>hive-jdbc</artifactId>
    <version>2.3.6</version>
</dependency>
```

### jdbc访问

```java
try {
    Class.forName("org.apache.hive.jdbc.HiveDriver");
} catch (ClassNotFoundException e) {
    e.printStackTrace();
}
Connection conn = DriverManager.getConnection("jdbc:hive2://node04:10000/default", "root", "");
Statement stmt = conn.createStatement();
String sql = "select * from psn limit 5";
ResultSet res = stmt.executeQuery(sql);
while (res.next()) {
    System.out.println(res.getString(1) + "-" + res.getString("name"));
}
```

## Hive函数



