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

##### Hive分区表：一张表拆分成多个目录

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

##### Hive动态分区

> hive的静态分区需要用户在插入数据的时候必须手动指定hive的分区字段值，但是这样的话会导致用户的操作复杂度提高，而且在使用的时候会导致数据只能插入到某一个指定分区，无法让数据散列分布，因此更好的方式是当数据在进行插入的时候，根据数据的某一个字段或某几个字段值动态的将数据插入到不同的目录中，此时，引入动态分区。

###### hive的动态分区配置

```sql
-- hive设置hive动态分区开启
set hive.exec.dynamic.partition=true;
默认：true
-- hive的动态分区模式
set hive.exec.dynamic.partition.mode=nostrict;
默认：strict（至少有一个分区列是静态分区）
-- 每一个执行mr节点上，允许创建的动态分区的最大数量(100)
set hive.exec.max.dynamic.partitions.pernode;
-- 所有执行mr节点上，允许创建的所有动态分区的最大数量(1000)	
set hive.exec.max.dynamic.partitions;
-- 所有的mr job允许创建的文件的最大数量(100000)	
set hive.exec.max.created.files;
```

###### 案例：加载数据

```sql
-- 从psn21表加载数据到psn22
from psn21
insert overwrite table psn22 partition(age, sex)
select id, name, age, sex, likes, address distribute by age, sex;
```

###### hive动态分区语法

```sql
--Hive extension (dynamic partition inserts):
INSERT OVERWRITE TABLE tablename PARTITION (partcol1[=val1], partcol2[=val2] ...) 		select_statement FROM from_statement;
INSERT INTO TABLE tablename PARTITION (partcol1[=val1], partcol2[=val2] ...) 			select_statement FROM from_statement;
```

##### Hive分桶：可以把一个文件拆分成多个文件

> ​	Bucketed tables are fantastic in that they allow much more efficient sampling than do non-bucketed tables, and they may later allow for time saving operations such as mapside joins. However, the bucketing specified at table creation is not enforced when the table is written to, and so it is possible for the table's metadata to advertise properties which are not upheld by the table's actual layout. This should obviously be avoided. Here's how to do it right。

**注意：**

1. Hive分桶表是对列值取hash值得方式，将不同数据放到不同文件中存储
2. 对于hive中每一个表、分区都可以进一步进行分桶
3. 由列的hash值除以桶的个数来决定每条数据划分在哪个桶中

**适用场景：**数据抽样（ sampling )

###### Hive分桶的配置

```sql
-- 设置hive支持分桶
set hive.enforce.bucketing=true;
-- 默认：false；设置为true之后，mr运行时会根据bucket的个数自动分配reduce task个数。（用户也可以通过mapred.reduce.tasks自己设置reduce任务个数，但分桶时不推荐使用）
-- 注意：一次作业产生的桶（文件数量）和reduce task个数一致。
```

###### 往分桶中加载数据

```sql
insert into table bucket_table select columns from tbl;

insert overwrite table bucket_table select columns from tbl;
```

###### Hive分桶的抽样查询

```sql
-- 案例
select * from bucket_table tablesample(bucket 1 out of 4 on columns)
-- TABLESAMPLE语法：
TABLESAMPLE(BUCKET x OUT OF y)
	x：表示从哪个bucket开始抽取数据
	y：必须为该表总bucket数的倍数或因子
```

###### 案例

>当表的总bucket数为32时
>TABLESAMPLE(BUCKET 3 OUT OF 8)，抽取哪些数据？
>32/8=4个桶（抽取的是桶的个数/y）
>3、11、19、27（跳的是y的值）
>共抽取4个bucket的数据，抽取第3、11、19、27个bucket的数据

```sql
CREATE TABLE psn31( id INT, name STRING, age INT)
ROW FORMAT DELIMITED FIELDS TERMINATED BY ',';
-- 测试数据
1,tom,11
2,cat,22
3,dog,33
4,hive,44
5,hbase,55
6,mr,66
7,alice,77
8,scala,88

-- 创建分桶表
CREATE TABLE psnbucket( id INT, name STRING, age INT)CLUSTERED BY (age) INTO 4 BUCKETSROW FORMAT DELIMITED FIELDS TERMINATED BY ',';
-- 加载数据：
insert into table psnbucket select id, name, age from psn31;
-- 抽样
select id, name, age from psnbucket tablesample(bucket 2 out of 4 on age);
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

> 官方地址：
>
> ```http
> https://cwiki.apache.org/confluence/display/Hive/LanguageManual+UDF
> ```

Hive中提供了非常丰富的运算符和内置函数支撑，具体操作如下：

### 内置运算符

#### 关系运算符

| 运算符        | 类型         | 说明                                                         |
| ------------- | ------------ | ------------------------------------------------------------ |
| A = B         | 所有原始类型 | 如果A与B相等,返回TRUE,否则返回FALSE                          |
| A == B        | 无           | 失败，因为无效的语法。 SQL使用”=”，不使用”==”。              |
| A <> B        | 所有原始类型 | 如果A不等于B返回TRUE,否则返回FALSE。<br/>如果A或B值为”NULL”，结果返回”NULL”。 |
| A < B         | 所有原始类型 | 如果A小于B返回TRUE,否则返回FALSE。<br/>如果A或B值为”NULL”，结果返回”NULL”。 |
| A <= B        | 所有原始类型 | 如果A小于等于B返回TRUE,否则返回FALSE。<br/>如果A或B值为”NULL”，结果返回”NULL”。 |
| A > B         | 所有原始类型 | 如果A大于B返回TRUE,否则返回FALSE。<br/>如果A或B值为”NULL”，结果返回”NULL”。 |
| A >= B        | 所有原始类型 | 如果A大于等于B返回TRUE,否则返回FALSE。<br/>如果A或B值为”NULL”，结果返回”NULL”。 |
| A IS NULL     | 所有类型     | 如果A值为”NULL”，返回TRUE,否则返回FALSE                      |
| A IS NOT NULL | 所有类型     | 如果A值不为”NULL”，返回TRUE,否则返回FALSE                    |
| A LIKE B      | 字符串       | 如果A或B值为”NULL”，结果返回”NULL”。<br/>字符串A与B通过sql进行匹配，<br/>如果相符返回TRUE，不符返回FALSE。<br/>B字符串中的”_”代表任一字符，”%”则代表多个任意字符。<br/>例如：<br/>(‘foobar’ like ‘foo’)返回FALSE，<br/>(‘foobar’ like ‘foo_ _ _’或者 ‘foobar’ like ‘foo%’)则返回TURE |
| A RLIKE B     | 字符串       | 如果A或B值为”NULL”，结果返回”NULL”。<br/>字符串A与B通过java进行匹配，<br/>如果相符返回TRUE，不符返回FALSE。<br/>例如：<br/>(‘foobar’ rlike ‘foo’)返回FALSE，<br/>(’foobar’ rlike ‘^f.*r$’)返回TRUE。 |
| A REGEXP B    | 字符串       | 与RLIKE相同。                                                |

#### 算数运算符

| 运算符 | 类型         | 说明                                                         |
| ------ | ------------ | ------------------------------------------------------------ |
| A + B  | 所有数字类型 | A和B相加。结果的与操作数值有共同类型。<br/>例如每一个整数是一个浮点数，浮点数包含整数。<br/>所以，一个浮点数和一个整数相加结果也是一个浮点数。 |
| A – B  | 所有数字类型 | A和B相减。结果的与操作数值有共同类型。                       |
| A * B  | 所有数字类型 | A和B相乘，结果的与操作数值有共同类型。<br/>需要说明的是，如果乘法造成溢出，将选择更高的类型。 |
| A / B  | 所有数字类型 | A和B相除，结果是一个double（双精度）类型的结果。             |
| A % B  | 所有数字类型 | A除以B余数与操作数值有共同类型。                             |
| A & B  | 所有数字类型 | 运算符查看两个参数的二进制表示法的值，并执行按位”与”操作。<br/>两个表达式的一位均为1时，则结果的该位为 1。否则，结果的该位为 0。 |
| A\|B   | 所有数字类型 | 运算符查看两个参数的二进制表示法的值，并执行按位”或”操作。<br/>只要任一表达式的一位为 1，则结果的该位为 1。否则，结果的该位为 0。 |
| A ^ B  | 所有数字类型 | 运算符查看两个参数的二进制表示法的值，并执行按位”异或”操作。<br/>当且仅当只有一个表达式的某位上为 1 时，结果的该位才为 1。否则结果的该位为 0。 |
| ~A     | 所有数字类型 | 对一个表达式执行按位”非”（取反）。                           |

#### 逻辑运算符

| 运算符  | 类型   | 说明                                                         |
| ------- | ------ | ------------------------------------------------------------ |
| A AND B | 布尔值 | A和B同时正确时,返回TRUE,否则FALSE。如果A或B值为NULL，返回NULL。 |
| A && B  | 布尔值 | 与”A AND B”相同                                              |
| A OR B  | 布尔值 | A或B正确,或两者同时正确返返回TRUE,否则FALSE。如果A和B值同时为NULL，返回NULL。 |
| A \| B  | 布尔值 | 与”A OR B”相同                                               |
| NOT A   | 布尔值 | 如果A为NULL或错误的时候返回TURE，否则返回FALSE。             |
| ! A     | 布尔值 | 与”NOT A”相同                                                |

#### 复杂类型函数

| 函数   | 类型                            | 说明                                                        |
| ------ | ------------------------------- | ----------------------------------------------------------- |
| map    | (key1, value1, key2, value2, …) | 通过指定的键/值对，创建一个map。                            |
| struct | (val1, val2, val3, …)           | 通过指定的字段值，创建一个结构。结构字段名称将COL1，COL2，… |
| array  | (val1, val2, …)                 | 通过指定的元素，创建一个数组。                              |

#### 对复杂函数的操作

| 函数   | 类型                  | 说明                                                         |
| ------ | --------------------- | ------------------------------------------------------------ |
| A[n]   | A是一个数组，n为int型 | 返回数组A的第n个元素，第一个元素的索引为0。<br/>如果A数组为['foo','bar']，则A[0]返回’foo’和A[1]返回”bar”。 |
| M[key] | M是Map<K, V>，关键K型 | 返回关键值对应的值，<br/>例如<br/>mapM为 {‘f’ -> ‘foo’, ‘b’ -> ‘bar’, ‘all’ -> ‘foobar’}，<br/>则M['all'] 返回’foobar’。 |
| S.x    | S为struct             | 返回结构x字符串在结构S中的存储位置。<br/>如 <br/>foobar {int foo, int bar} foobar.foo的领域中存储的整数。 |

### 内置函数

#### 数学函数

| 返回类型   | 函数                                              | 说明                                                         |
| ---------- | ------------------------------------------------- | ------------------------------------------------------------ |
| BIGINT     | round(double a)                                   | 四舍五入                                                     |
| DOUBLE     | round(double a, int d)                            | 小数部分d位之后数字四舍五入，例如round(21.263,2),返回21.26   |
| BIGINT     | floor(double a)                                   | 对给定数据进行向下舍入最接近的整数。例如floor(21.2),返回21。 |
| BIGINT     | ceil(double a), ceiling(double a)                 | 将参数向上舍入为最接近的整数。例如ceil(21.2),返回23.         |
| double     | rand(), rand(int seed)                            | 返回大于或等于0且小于1的平均分布随机数（依重新计算而变）     |
| double     | exp(double a)                                     | 返回e的n次方                                                 |
| double     | ln(double a)                                      | 返回给定数值的自然对数                                       |
| double     | log10(double a)                                   | 返回给定数值的以10为底自然对数                               |
| double     | log2(double a)                                    | 返回给定数值的以2为底自然对数                                |
| double     | log(double base, double a)                        | 返回给定底数及指数返回自然对数                               |
| double     | pow(double a, double p) power(double a, double p) | 返回某数的乘幂                                               |
| double     | sqrt(double a)                                    | 返回数值的平方根                                             |
| string     | bin(BIGINT a)                                     | 返回二进制格式                                               |
| string     | hex(BIGINT a) hex(string a)                       | 将整数或字符转换为十六进制格式                               |
| string     | unhex(string a)                                   | 十六进制字符转换由数字表示的字符。                           |
| string     | conv(BIGINT num, int from_base, int to_base)      | 将 指定数值，由原来的度量体系转换为指定的试题体系。<br/>例如CONV(‘a’,16,2),返回。<br/>参考：’1010′ http://dev.mysql.com/doc/refman/5.0/en/mathematical-functions.html#function_conv |
| double     | abs(double a)                                     | 取绝对值                                                     |
| int double | pmod(int a, int b) pmod(double a, double b)       | 返回a除b的余数的绝对值                                       |
| double     | sin(double a)                                     | 返回给定角度的正弦值                                         |
| double     | asin(double a)                                    | 返回x的反正弦，即是X。如果X是在-1到1的正弦值，返回NULL。     |
| double     | cos(double a)                                     | 返回余弦                                                     |
| double     | acos(double a)                                    | 返回X的反余弦，即余弦是X，，如果-1<= A <= 1，否则返回null.   |
| int double | positive(int a) positive(double a)                | 返回A的值，例如positive(2)，返回2。                          |
| int double | negative(int a) negative(double a)                | 返回A的相反数，例如negative(2),返回-2。                      |

#### 收集函数

| 返回类型 | 函数           | 说明                      |
| -------- | -------------- | ------------------------- |
| int      | size(Map<K.V>) | 返回的map类型的元素的数量 |
| int      | size(Array<T>) | 返回数组类型的元素数量    |

#### 类型转换函数

| 返回类型    | 函数                 | 说明                                                         |
| ----------- | -------------------- | ------------------------------------------------------------ |
| 指定 “type” | cast(expr as <type>) | 类型转换。例如将字符”1″转换为整数:cast(’1′ as bigint)，如果转换失败返回NULL。 |

#### 日期函数

| 返回类型 | 函数                                            | 说明                                                         |
| -------- | ----------------------------------------------- | ------------------------------------------------------------ |
| string   | from_unixtime(bigint unixtime[, string format]) | UNIX_TIMESTAMP参数表示返回一个值’YYYY- MM – DD HH：MM：SS’或YYYYMMDDHHMMSS.uuuuuu格式，这取决于是否是在一个字符串或数字语境中使用的功能。该值表示在当前的时区。 |
| bigint   | unix_timestamp()                                | 如果不带参数的调用，返回一个Unix时间戳（从’1970- 01 – 0100:00:00′到现在的UTC秒数）为无符号整数。 |
| bigint   | unix_timestamp(string date)                     | 指定日期参数调用UNIX_TIMESTAMP（），它返回参数值’1970- 01 – 0100:00:00′到指定日期的秒数。 |
| bigint   | unix_timestamp(string date, string pattern)     | 指定时间输入格式，返回到1970年秒数：unix_timestamp(’2009-03-20′, ‘yyyy-MM-dd’) = 1237532400 |
| string   | to_date(string timestamp)                       | 返回时间中的年月日： to_date(“1970-01-01 00:00:00″) = “1970-01-01″ |
| string   | to_dates(string date)                           | 给定一个日期date，返回一个天数（0年以来的天数）              |
| int      | year(string date)                               | 返回指定时间的年份，范围在1000到9999，或为”零”日期的0。      |
| int      | month(string date)                              | 返回指定时间的月份，范围为1至12月，或0一个月的一部分，如’0000-00-00′或’2008-00-00′的日期。 |
| int      | day(string date) dayofmonth(date)               | 返回指定时间的日期                                           |
| int      | hour(string date)                               | 返回指定时间的小时，范围为0到23。                            |
| int      | minute(string date)                             | 返回指定时间的分钟，范围为0到59。                            |
| int      | second(string date)                             | 返回指定时间的秒，范围为0到59。                              |
| int      | weekofyear(string date)                         | 返回指定日期所在一年中的星期号，范围为0到53。                |
| int      | datediff(string enddate, string startdate)      | 两个时间参数的日期之差。                                     |
| int      | date_add(string startdate, int days)            | 给定时间，在此基础上加上指定的时间段。                       |
| int      | date_sub(string startdate, int days)            | 给定时间，在此基础上减去指定的时间段。                       |

#### 条件函数

| 返回类型 | 函数                                                       | 说明                                                         |
| -------- | ---------------------------------------------------------- | ------------------------------------------------------------ |
| T        | if(boolean testCondition, T valueTrue, T valueFalseOrNull) | 判断是否满足条件，如果满足返回一个值，如果不满足则返回另一个值。 |
| T        | COALESCE(T v1, T v2, …)                                    | 返回一组数据中，第一个不为NULL的值，如果均为NULL,返回NULL。  |
| T        | CASE a WHEN b THEN c [WHEN d THEN e]* [ELSE f] END         | 当a=b时,返回c；当a=d时，返回e，否则返回f。                   |
| T        | CASE WHEN a THEN b [WHEN c THEN d]* [ELSE e] END           | 当值为a时返回b,当值为c时返回d。否则返回e。                   |

#### 字符函数

| 返回类型                     | 函数                                                         | 说明                                                         |
| ---------------------------- | ------------------------------------------------------------ | ------------------------------------------------------------ |
| int                          | length(string A)                                             | 返回字符串的长度                                             |
| string                       | reverse(string A)                                            | 返回倒序字符串                                               |
| string                       | concat(string A, string B…)                                  | 连接多个字符串，合并为一个字符串，可以接受任意数量的输入字符串 |
| string                       | concat_ws(string SEP, string A, string B…)                   | 链接多个字符串，字符串之间以指定的分隔符分开。               |
| string                       | substr(string A, int start) substring(string A, int start)   | 从文本字符串中指定的起始位置后的字符。                       |
| string                       | substr(string A, int start, int len) substring(string A, int start, int len) | 从文本字符串中指定的位置指定长度的字符。                     |
| string                       | upper(string A) ucase(string A)                              | 将文本字符串转换成字母全部大写形式                           |
| string                       | lower(string A) lcase(string A)                              | 将文本字符串转换成字母全部小写形式                           |
| string                       | trim(string A)                                               | 删除字符串两端的空格，字符之间的空格保留                     |
| string                       | ltrim(string A)                                              | 删除字符串左边的空格，其他的空格保留                         |
| string                       | rtrim(string A)                                              | 删除字符串右边的空格，其他的空格保留                         |
| string                       | regexp_replace(string A, string B, string C)                 | 字符串A中的B字符被C字符替代                                  |
| string                       | regexp_extract(string subject, string pattern, int index)    | 通过下标返回正则表达式指定的部分。regexp_extract(‘foothebar’, ‘foo(.*?)(bar)’, 2) returns ‘bar.’ |
| string                       | parse_url(string urlString, string partToExtract [, string keyToExtract]) | 返回URL指定的部分。parse_url(‘http://facebook.com/path1/p.php?k1=v1&k2=v2#Ref1′, ‘HOST’) 返回：’facebook.com’ |
| string                       | get_json_object(string json_string, string path)             | select a.timestamp, get_json_object(a.appevents, ‘$.eventid’), get_json_object(a.appenvets, ‘$.eventname’) from log a; |
| string                       | space(int n)                                                 | 返回指定数量的空格                                           |
| string                       | repeat(string str, int n)                                    | 重复N次字符串                                                |
| int                          | ascii(string str)                                            | 返回字符串中首字符的数字值                                   |
| string                       | lpad(string str, int len, string pad)                        | 返回指定长度的字符串，给定字符串长度小于指定长度时，由指定字符从左侧填补。 |
| string                       | rpad(string str, int len, string pad)                        | 返回指定长度的字符串，给定字符串长度小于指定长度时，由指定字符从右侧填补。 |
| array                        | split(string str, string pat)                                | 将字符串转换为数组。                                         |
| int                          | find_in_set(string str, string strList)                      | 返回字符串str第一次在strlist出现的位置。如果任一参数为NULL,返回NULL；如果第一个参数包含逗号，返回0。 |
| array<array<string>>         | sentences(string str, string lang, string locale)            | 将字符串中内容按语句分组，每个单词间以逗号分隔，最后返回数组。 例如sentences(‘Hello there! How are you?’) 返回：( (“Hello”, “there”), (“How”, “are”, “you”) ) |
| array<struct<string,double>> | ngrams(array<array<string>>, int N, int K, int pf)           | SELECT ngrams(sentences(lower(tweet)), 2, 100 [, 1000]) FROM twitter; |
| array<struct<string,double>> | context_ngrams(array<array<string>>, array<string>, int K, int pf) | SELECT context_ngrams(sentences(lower(tweet)), array(null,null), 100, [, 1000]) FROM twitter; |

### 内置的聚合函数（UDAF）

| 返回类型                 | 函数                                                         | 说明                                                         |
| ------------------------ | ------------------------------------------------------------ | ------------------------------------------------------------ |
| bigint                   | count(*) , count(expr), count(DISTINCT expr[, expr_., expr_.]) | 返回记录条数。                                               |
| double                   | sum(col), sum(DISTINCT col)                                  | 求和                                                         |
| double                   | avg(col), avg(DISTINCT col)                                  | 求平均值                                                     |
| double                   | min(col)                                                     | 返回指定列中最小值                                           |
| double                   | max(col)                                                     | 返回指定列中最大值                                           |
| double                   | var_pop(col)                                                 | 返回指定列的方差                                             |
| double                   | var_samp(col)                                                | 返回指定列的样本方差                                         |
| double                   | stddev_pop(col)                                              | 返回指定列的偏差                                             |
| double                   | stddev_samp(col)                                             | 返回指定列的样本偏差                                         |
| double                   | covar_pop(col1, col2)                                        | 两列数值协方差                                               |
| double                   | covar_samp(col1, col2)                                       | 两列数值样本协方差                                           |
| double                   | corr(col1, col2)                                             | 返回两列数值的相关系数                                       |
| double                   | percentile(col, p)                                           | 返回数值区域的百分比数值点。0<=P<=1,否则返回NULL,不支持浮点型数值。 |
| array<double>            | percentile(col, array(p~1,,\ [, p,,2,,]…))                   | 返回数值区域的一组百分比值分别对应的数值点。0<=P<=1,否则返回NULL,不支持浮点型数值。 |
| double                   | percentile_approx(col, p[, B])                               | Returns an approximate p^th^ percentile of a numeric column (including floating point types) in the group. The B parameter controls approximation accuracy at the cost of memory. Higher values yield better approximations, and the default is 10,000. When the number of distinct values in col is smaller than B, this gives an exact percentile value. |
| array<double>            | percentile_approx(col, array(p~1,, [, p,,2_]…) [, B])        | Same as above, but accepts and returns an array of percentile values instead of a single one. |
| array<struct\{‘x’,'y’\}> | histogram_numeric(col, b)                                    | Computes a histogram of a numeric column in the group using b non-uniformly spaced bins. The output is an array of size b of double-valued (x,y) coordinates that represent the bin centers and heights |
| array                    | collect_set(col)                                             | 返回无重复记录                                               |

### 内置表生成函数（UDTF）

| 返回类型 | 函数                   | 说明                                                         |
| -------- | ---------------------- | ------------------------------------------------------------ |
| 数组     | explode(array<TYPE> a) | 数组一条记录中有多个参数，将参数拆分，每个参数生成一列。     |
|          | json_tuple             | get_json_object 语句：<br/>select a.timestamp, get_json_object(a.appevents, ‘$.eventid’), get_json_object(a.appenvets, ‘$.eventname’) from log a; <br/>json_tuple语句: <br/>select a.timestamp, b.* from log a lateral view json_tuple(a.appevent, ‘eventid’, ‘eventname’) b as f1, f2 |

### 自定义函数

**自定义函数包括三种UDF、UDAF、UDTF**

1. UDF(User-Defined-Function) ：一进一出
2. UDAF(User- Defined Aggregation Funcation) ：聚集函数，多进一出。Count/max/min
3. UDTF(User-Defined Table-Generating Functions) :一进多出，如explore()

#### UDF 开发

1. UDF函数可以直接应用于select语句，对查询结构做格式化处理后，再输出内容。
2. 编写UDF函数的时候需要注意一下几点：
   - 自定义UDF需要继承org.apache.hadoop.hive.ql.UDF。
   - 需要实现evaluate函数，evaluate函数支持重载。

#### 将jar包上传到虚拟机中

> 注意：此种方式创建的函数属于临时函数，当关闭了当前会话之后，函数会无法使用，因为jar的引用没有了，无法找到对应的java文件进行处理，因此不推荐使用。

1. 把程序打包放到目标机器上去；

2. 进入hive客户端，添加jar包：add jar /run/jar/udf_test.jar;

3. 创建临时函数：CREATE TEMPORARY FUNCTION add_example AS 'hive.udf.Add';

4. 查询HQL语句：

   ```sql
   SELECT add_example(8, 9) FROM scores;
   SELECT add_example(scores.math, scores.art) FROM scores;
   SELECT add_example(6, 7, 8, 6.8) FROM scores;
   ```

5. 销毁临时函数：DROP TEMPORARY FUNCTION add_example;

#### 将jar包上传到hdfs集群中

1. 把程序打包上传到hdfs的某个目录下

2. 创建函数：CREATE FUNCTION add_example AS 'hive.udf.Add' using jar "hdfs://mycluster/jar/udf_test.jar";

3. 查询HQL语句：

   ```sql
   SELECT add_example(8, 9) FROM scores;
   SELECT add_example(scores.math, scores.art) FROM scores;
   SELECT add_example(6, 7, 8, 6.8) FROM scores;
   ```

4. 销毁临时函数：DROP  FUNCTION add_example;

### hive使用sql计算word count

```sql
from (select explode(split(要计算的列名, ' ')) word from 表名) t
insert into 结果表名 select word, count(word) group by t.word
```

### hive - sql解析工具

```
calcite
```

> [Apache Calcite](https://links.jianshu.com/go?to=https%3A%2F%2Fcalcite.apache.org%2F) 是一款开源SQL解析工具, 可以将各种SQL语句解析成抽象语法术AST(Abstract Syntax Tree), 之后通过操作AST就可以把SQL中所要表达的算法与关系体现在具体代码之中。

## Hive参数操作

### hive参数介绍

hive当中的参数、变量都是以命名空间开头的，详情如下表所示：

| **命名空间** | **读写权限** | **含义**                                                     |
| ------------ | ------------ | ------------------------------------------------------------ |
| hiveconf     | 可读写       | hive-site.xml当中的各配置变量例：hive --hiveconf hive.cli.print.header=true |
| system       | 可读写       | 系统变量，包含JVM运行参数等例：system:user.name=root         |
| env          | 只读         | 环境变量例：env：JAVA_HOME                                   |
| hivevar      | 可读写       | 例：hive -d val=key                                          |

hive的变量可以通过${}方式进行引用，其中system、env下的变量必须以前缀开头

### hive参数的设置方式

1. 在${HIVE_HOME}/conf/hive-site.xml文件中添加参数设置

   **注意：永久生效，所有的hive会话都会加载对应的配置**

2. 在启动hive cli时，通过--hiveconf key=value的方式进行设置

   例如：hive --hiveconf hive.cli.print.header=true

   **注意：只在当前会话有效，退出会话之后参数失效**

3. 在进入到cli之后，通过set命令设置

   例如：set hive.cli.print.header=true;

   ```sql
   -- 在hive cli控制台可以通过set对hive中的参数进行查询设置
   -- set设置
   set hive.cli.print.header=true;
   -- set查看
   set hive.cli.print.header
   -- set查看全部属性
   set
   ```

   **注意：只在当前会话有效，退出会话之后参数失效**

4. hive参数初始化设置

   在当前用户的家目录下创建**.hiverc**文件，在当前文件中设置hive参数的命令，每次进入hive cli的时候，都会加载.hiverc的文件，执行文件中的命令。

   **注意：在当前用户的家目录下还会存在.hivehistory文件，此文件中保存了hive cli中执行的所有命令**

## Hive运行方式

### 命令行方式或者控制台模式

1. 在命令行中可以直接输入SQL语句，例如：select * from table_name

2. 在命令行中可以与HDFS交互，例如：dfs ls /

3. 在命令行中可以与linux交互，例如：! pwd或者! ls /

   **注意：与linux交互的时候必须要加!**

### 脚本运行方式（实际生产环境中用最多）

```sql
-- hive直接执行sql命令，可以写一个sql语句，也可以使用;分割写多个sql语句
hive -e ""
-- hive执行sql命令，将sql语句执行的结果重定向到某一个文件中
hive -e "">aaa
-- hive静默输出模式(-S)，输出的结果中不包含ok，time token等关键字
hive -S -e "">aaa
-- hive可以直接读取文件中的sql命令，进行执行
hive -f file
-- hive可以从文件中读取命令，并且执行初始化操作
hive -i /home/my/hive-init.sql
-- 在hive的命令行中也可以执行外部文件中的命令
source file (在hive cli中运行)
```

### JDBC方式：hiveserver2

程序开发通过jdbc方式进行访问。

### web GUI接口（hwi、hue等）

hwi在2.2版本以后，已经删除了，

#### 搭建Hue

## Hive视图

### Hive Lateral View

> 1. Lateral View用于和UDTF函数（explode、split）结合来使用。
> 2. 首先通过UDTF函数拆分成多行，再将多行结果组合成一个支持别名的虚拟表。
> 3. 主要解决在select使用UDTF做查询过程中，查询只能包含单个UDTF，不能包含其他字段、以及多个UDTF的问题。

#### 语法

```sql
LATERAL VIEW udtf(expression) tableAlias AS columnAlias (',' columnAlias)
```

#### 案例

统计人员表中共有多少种爱好、多少个城市?

![Hive-Lateral-View案例](./images/Hive-Lateral-View案例.png)

```sql
select count(distinct(myCol1)), count(distinct(myCol2)) from psn2 
LATERAL VIEW explode(likes) myTable1 AS myCol1 
LATERAL VIEW explode(address) myTable2 AS myCol2, myCol3;
```

### Hive普通视图

> Hive 中的视图和RDBMS中视图的概念一致，都是一组数据的逻辑表示，本质上就是一条SELECT语句的结果集。视图是纯粹的逻辑对象，没有关联的存储(Hive 3.0.0引入的物化视图除外)，当查询引用视图时，Hive可以将视图的定义与查询结合起来，例如将查询中的过滤器推送到视图中。

#### Hive视图特点

1. 不支持物化视图
2. 只能查询，不能做加载数据操作
3. 视图的创建，只是保存一份元数据，查询视图时才执行对应的子查询
4. view定义中若包含了ORDER BY/LIMIT语句，当查询视图时也进行ORDER BY/LIMIT语句操作，view当中			  定义的优先级更高
5. view支持迭代视图

#### Hive视图语法

```sql
-- 创建视图：
CREATE VIEW [IF NOT EXISTS] [db_name.]view_name 
  [(column_name [COMMENT column_comment], ...) ]
  [COMMENT view_comment]
  [TBLPROPERTIES (property_name = property_value, ...)]
  AS SELECT ... ;
-- 查询视图：
select colums from view;
-- 删除视图：
DROP VIEW [IF EXISTS] [db_name.]view_name;
```

## Hive索引

> 为了提高数据的检索效率，可以使用hive的索引

```sql
--创建索引：
create index t1_index on table psn2(name) as 'org.apache.hadoop.hive.ql.index.compact.CompactIndexHandler' with deferred rebuild in table    t1_index_table;
--as：指定索引器；
--in table：指定索引表，若不指定默认生成在default__psn2_t1_index__表中
create index t1_index on table psn2(name) as 'org.apache.hadoop.hive.ql.index.compact.CompactIndexHandler' with deferred rebuild;
--查询索引
show index on psn2;
--重建索引（建立索引之后必须重建索引才能生效）
ALTER INDEX t1_index ON psn2 REBUILD;
--删除索引
DROP INDEX IF EXISTS t1_index ON psn2;
```

## Hive权限管理

### hive授权模型介绍

1. Storage Based Authorization in the Metastore Server

   基于存储的授权 - 可以对Metastore中的元数据进行保护，但是没有提供更加细粒度的访问控制（例如：列级别、行级别）

2. SQL Standards Based Authorization in HiveServer2

   基于SQL标准的Hive授权 - 完全兼容SQL的授权模型，推荐使用该模式。

3. Default Hive Authorization (Legacy Mode)

   hive默认授权 - 设计目的仅仅只是为了防止用户产生误操作，而不是防止恶意用户访问未经授权的数据。

### 基于SQL标准的Hive授权 	

1. 完全兼容SQL的授权模型
2. 除支持对于用户的授权认证，还支持角色role的授权认证
   - role可理解为是一组权限的集合，通过role为用户授权
   - 一个用户可以具有一个或多个角色
   - 默认包含另种角色：public、admin

**限制：**

1. 启用当前认证方式之后，dfs, add, delete, compile, and reset等命令被禁用。

2. 通过set命令设置hive configuration的方式被限制某些用户使用。

   (可通过修改配置文件hive-site.xml中hive.security.authorization.sqlstd.confwhitelist进行配置)

3. 添加、删除函数以及宏的操作，仅为具有admin的用户开放。

4. 用户自定义函数（开放支持永久的自定义函数），可通过具有admin角色的用户创建，其他用户都可以使用。

5. Transform功能被禁用。

### Hive权限配置

cd $HIVE_HOME/conf

vim hive-site.xml

```xml
<property>
  <name>hive.security.authorization.enabled</name>
  <value>true</value>
</property>
<property>
  <name>hive.server2.enable.doAs</name>
  <value>false</value>
</property>
<property>
  <name>hive.users.in.admin.role</name>
  <value>root</value>
</property>
<property>
  <name>hive.security.authorization.manager</name>  <value>org.apache.hadoop.hive.ql.security.authorization.plugin.sqlstd.SQLStdHiveAuthorizerFactory</value>
</property>
<property>
  <name>hive.security.authenticator.manager</name>
  <value>org.apache.hadoop.hive.ql.security.SessionStateUserAuthenticator</value>
</property>
```

### Hive权限管理命令

```sql
-- 角色的添加、删除、查看、设置：
-- 创建角色
create role role_name;  
-- 删除角色
drop role role_name; 
-- 设置角色
set role (role_name|all|none); 
-- 查看当前具有的角色
show current roles;
-- 查看所有存在的角色  
show roles;
-- 把admin角色授权给test用户
-- show 角色名 to (role rolename|user username) with admin option;
-- with admin option;让其他角色也有admin的能力
show admin to role test with admin option;
-- 查看角色的授权
-- show role grant (user|role) 角色名称;
show role grant role test;
-- 权限回收
-- 把admin角色从test角色中收回来
revoke admin from role test;
```

### Hive权限分配图

| Action                                          | Select       | Insert     | Update | Delete            | Owership        | Admin | URL Privilege(RWX Permission + Ownership)     |
| ----------------------------------------------- | ------------ | ---------- | ------ | ----------------- | --------------- | ----- | --------------------------------------------- |
| ALTER DATABASE                                  |              |            |        |                   |                 | Y     |                                               |
| ALTER INDEX PROPERTIES                          |              |            |        |                   | Y               |       |                                               |
| ALTER INDEX REBUILD                             |              |            |        |                   | Y               |       |                                               |
| ALTER PARTITION LOCATION                        |              |            |        |                   | Y               |       | Y (for new partition location)                |
| ALTER TABLE (all of them except the ones above) |              |            |        |                   | Y               |       |                                               |
| ALTER TABLE ADD PARTITION                       |              | Y          |        |                   |                 |       | Y (for partition location)                    |
| ALTER TABLE DROP PARTITION                      |              |            |        | Y                 |                 |       |                                               |
| ALTER TABLE LOCATION                            |              |            |        |                   | Y               |       | Y (for new location)                          |
| ALTER VIEW PROPERTIES                           |              |            |        |                   | Y               |       |                                               |
| ALTER VIEW RENAME                               |              |            |        |                   | Y               |       |                                               |
| ANALYZE TABLE                                   | Y            | Y          |        |                   |                 |       |                                               |
| CREATE DATABASE                                 |              |            |        |                   |                 |       | Y (if custom location specified)              |
| CREATE FUNCTION                                 |              |            |        |                   |                 | Y     |                                               |
| CREATE INDEX                                    |              |            |        |                   | Y (of table)    |       |                                               |
| CREATE MACRO                                    |              |            |        |                   |                 | Y     |                                               |
| CREATE TABLE                                    |              |            |        |                   | Y (of database) |       | Y  (for create external table – the location) |
| CREATE TABLE AS SELECT                          | Y (of input) |            |        |                   | Y (of database) |       |                                               |
| CREATE VIEW                                     | Y + G        |            |        |                   |                 |       |                                               |
| DELETE                                          |              |            |        | Y                 |                 |       |                                               |
| DESCRIBE TABLE                                  | Y            |            |        |                   |                 |       |                                               |
| DROP DATABASE                                   |              |            |        |                   | Y               |       |                                               |
| DROP FUNCTION                                   |              |            |        |                   |                 | Y     |                                               |
| DROP INDEX                                      |              |            |        |                   | Y               |       |                                               |
| DROP MACRO                                      |              |            |        |                   |                 | Y     |                                               |
| DROP TABLE                                      |              |            |        |                   | Y               |       |                                               |
| DROP VIEW                                       |              |            |        |                   | Y               |       |                                               |
| DROP VIEW PROPERTIES                            |              |            |        |                   | Y               |       |                                               |
| EXPLAIN                                         | Y            |            |        |                   |                 |       |                                               |
| INSERT                                          |              | Y          |        | Y (for OVERWRITE) |                 |       |                                               |
| LOAD                                            |              | Y (output) |        | Y (output)        |                 |       | Y (input location)                            |
| MSCK (metastore check)                          |              |            |        |                   |                 | Y     |                                               |
| SELECT                                          | Y            |            |        |                   |                 |       |                                               |
| SHOW COLUMNS                                    | Y            |            |        |                   |                 |       |                                               |
| SHOW CREATE TABLE                               | Y+G          |            |        |                   |                 |       |                                               |
| SHOW PARTITIONS                                 | Y            |            |        |                   |                 |       |                                               |
| SHOW TABLE PROPERTIES                           | Y            |            |        |                   |                 |       |                                               |
| SHOW TABLE STATUS                               | Y            |            |        |                   |                 |       |                                               |
| TRUNCATE TABLE                                  |              |            |        |                   | Y               |       |                                               |
| UPDATE                                          |              |            | Y      |                   |                 |       |                                               |

```sql
-- 给用户赋权
-- grant select on 表名 to user 用户名 with grant option;
-- with grant option;让其他用户也有授权的能力
grant select on psn to user abcd with grant option;
-- 查看用户有哪些权限
-- show grant user 用户名 on 表名;
show grant user abds on psm;
--回收权限
-- revoke update on 表名 from user 用户名;
revoke update on psn from user abdc;
```

## Hive优化

> Hive的存储层依托于HDFS，Hive的计算层依托于MapReduce，一般Hive的执行效率主要取决于SQL语句的执行效率，因此，Hive的优化的核心思想是MapReduce的优化。
>
> hive的sql转mr任务经历的5个步骤：
>
> 1. 抽象语法树
> 2. 查新块
> 3. 逻辑查询计划
> 4. 物理查询计划
> 5. 优化执行

### 查看Hive执行计划（小白慎用）

> Hive的SQL语句在执行之前需要将SQL语句转换成MapReduce任务，因此需要了解具体的转换过程，可以在SQL语句中输入如下命令查看具体的执行计划。

```sql
-- 查看执行计划，添加extended关键字可以查看更加详细的执行计划
explain [extended] query
```

### Hive的抓取策略

> Hive的某些SQL语句需要转换成MapReduce的操作，某些SQL语句就不需要转换成MapReduce操作，但是同学们需要注意，理论上来说，所有的SQL语句都需要转换成MapReduce操作，只不过Hive在转换SQL语句的过程中会做部分优化，使某些简单的操作不再需要转换成MapReduce，例如：
>
> 1. select 仅支持本表字段
> 2. where仅对本表字段做条件过滤

```sql
-- 查看Hive的数据抓取策略（优化部分情况不用转换mr任务）
Set hive.fetch.task.conversion=none/more;
```

### Hive本地模式

> 类似于MapReduce的操作，Hive的运行也分为本地模式和集群模式，在开发阶段可以选择使用本地执行，提高SQL语句的执行效率，验证SQL语句是否正确。

```sql
-- 设置本地模式
set hive.exec.mode.local.auto=true;
```

**需要注意的是：**

> 要想使用Hive的本地模式，加载数据文件大小不能超过128M，或者文件个数不能超过4个，如果超过128M或者文件个数超过了4个，就算设置了本地模式，也会按照集群模式运行。

```sql
-- 设置读取数据量的大小限制
set hive.exec.mode.local.auto.inputbytes.max=128M
```

### Hive并行模式

> 在SQL语句足够复杂的情况下，可能在一个SQL语句中包含多个子查询语句，且多个子查询语句之间没有任何依赖关系，此时，可以Hive运行的并行度

```sql
-- 设置Hive SQL的并行度
set hive.exec.parallel=true;
```

**需要注意的是：**

> Hive的并行度并不是无限增加的，在一次SQL计算中，可以通过以下参数来设置并行的job的个数

```sql
-- 设置一次SQL计算允许并行执行的job个数的最大值，默认值8
set hive.exec.parallel.thread.number
```

### Hive严格模式

> Hive中为了提高SQL语句的执行效率，可以设置严格模式，充分利用Hive的某些特点。

```sql
-- 设置Hive的严格模式
set hive.mapred.mode=strict;
```

**需要注意的是：**

当设置严格模式之后，对于查询会有如下限制：

1. 对于分区表，必须添加where对于分区字段的条件过滤
2. order by语句必须包含limit输出限制
3. 限制执行笛卡尔积的查询

### Hive排序

> 在编写SQL语句的过程中，很多情况下需要对数据进行排序操作，Hive中支持多种排序操作适合不同的应用场景。

1. Order By - 对于查询结果做全排序，只允许有一个reduce处理

   **（当数据量较大时，应慎用。严格模式下，必须结合limit来使用）**

2. Sort By - 对于单个reduce的数据进行排序

3. Distribute By - 分区排序，经常和Sort By结合使用

4. Cluster By - 相当于 Sort By + Distribute By

   **Cluster By不能通过asc、desc的方式指定排序规则；可通过 distribute by column sort by column asc|desc 的方式**

### Hive join

> Hive 在多个表的join操作时尽可能多的使用相同的连接键，这样在转换MR任务时会转换成少的MR的任务。

#### 手动Map join:在map端完成join操作

```sql
-- SQL方式，在SQL语句中添加MapJoin标记（mapjoin hint）
SELECT  /*+ MAPJOIN(smallTable) */  smallTable.key,  bigTable.value 
FROM  smallTable  JOIN  bigTable  ON  smallTable.key  =  bigTable.key;
```

#### 开启自动的Map Join

```sql
-- 通过修改以下配置启用自动的mapjoin：
-- 该参数为true时，Hive自动对左边的表统计量，如果是小表就加入内存，即对小表使用Map join（放入内存中）
set hive.auto.convert.join = true;
-- 大表小表判断的阈值，如果表的大小小于该值则会被加载到内存中运行，默认25000000，如果调大会占用map端很大内存
hive.mapjoin.smalltable.filesize = 25000000;
--（默认值：true，如果手动自动都有，自动优先；如果为false，手动优先）
hive.ignore.mapjoin.hint = true;
```

#### 大表join大表

1. 空key过滤：有时join超时是因为某些key对应的数据太多，而相同key对应的数据都会发送到相同的reducer上，从而导致内存不够。此时我们应该仔细分析这些异常的key，很多情况下，这些key对应的数据是异常数据，我们需要在SQL语句中进行过滤。
2. 空key转换：有时虽然某个key为空对应的数据很多，但是相应的数据不是异常数据，必须要包含在join的结果中，此时我们可以表a中key为空的字段赋一个随机的值，使得数据随机均匀地分不到不同的reducer上

### Map-Side聚合	

> Hive的某些SQL操作可以实现map端的聚合，类似于MR的combine操作

```sql
-- 通过设置以下参数开启在Map端的聚合：
set hive.map.aggr=true;
-- 相关配置参数：
-- map端group by执行聚合时处理的多少行数据（默认：100000）
hive.groupby.mapaggr.checkinterval： 
-- 进行聚合的最小比例（预先对100000条数据做聚合，若聚合之后的数据量/100000的值大于该配置0.5，则不会聚合）
hive.map.aggr.hash.min.reduction： 
--m ap端聚合使用的内存的最大值
hive.map.aggr.hash.percentmemory： 
-- 是否对GroupBy产生的数据倾斜做优化，默认为false
hive.groupby.skewindata
```

### 合并小文件

> Hive在操作的时候，如果文件数目小，容易在文件存储端造成压力，给hdfs造成压力，影响效率

```sql
-- 设置合并属性
-- 是否合并map输出文件：
set hive.merge.mapfiles=true
-- 是否合并reduce输出文件：
set hive.merge.mapredfiles=true;
-- 合并文件的大小：
set hive.merge.size.per.task=256*1000*1000
```

### 合理设置Map以及Reduce的数量

```sql
-- Map数量相关的参数
-- 一个split的最大值，即每个map处理文件的最大值
set mapred.max.split.size
-- 一个节点上split的最小值
set mapred.min.split.size.per.node
-- 一个机架上split的最小值
set mapred.min.split.size.per.rack
-- Reduce数量相关的参数
-- 强制指定reduce任务的数量
set mapred.reduce.tasks
-- 每个reduce任务处理的数据量
set hive.exec.reducers.bytes.per.reducer
-- 每个任务最大的reduce数
set hive.exec.reducers.max
```

### JVM重用

```sql
/*
适用场景：
	1、小文件个数过多
	2、task个数过多
缺点：
	设置开启之后，task插槽会一直占用资源，不论是否有task运行，直到所有的task即整个job全部执行完成时，才会释放所有的task插槽资源！
*/
set mapred.job.reuse.jvm.num.tasks=n;--（n为task插槽个数）
```

## Hadoop压缩配置

###  MR支持的压缩编码

| 压缩格式 | 工具  | 算法    | 文件扩展名 | 是否可切分 |
| -------- | ----- | ------- | ---------- | ---------- |
| DEFAULT  | 无    | DEFAULT | .deflate   | 否         |
| Gzip     | gzip  | DEFAULT | .gz        | 否         |
| bzip2    | bzip2 | bzip2   | .bz2       | 是         |
| LZO      | lzop  | LZO     | .lzo       | 否         |
| LZ4      | 无    | LZ4     | .lz4       | 否         |
| Snappy   | 无    | Snappy  | .snappy    | 否         |

**为了支持多种压缩/解压缩算法，Hadoop引入了编码/解码器，如下表所示：**

| 压缩格式 | 对应的编码/解码器                          |
| -------- | ------------------------------------------ |
| DEFLATE  | org.apache.hadoop.io.compress.DefaultCodec |
| gzip     | org.apache.hadoop.io.compress.GzipCodec    |
| bzip2    | org.apache.hadoop.io.compress.BZip2Codec   |
| LZO      | com.hadoop.compression.lzo.LzopCodec       |
| LZ4      | org.apache.hadoop.io.compress.Lz4Codec     |
| Snappy   | org.apache.hadoop.io.compress.SnappyCodec  |

### 压缩配置参数

> 要在Hadoop中启用压缩，可以配置如下参数（mapred-site.xml文件中）：

| 参数                                                 | 默认值                                                       | 阶段        | 建议                                         |
| ---------------------------------------------------- | ------------------------------------------------------------ | ----------- | -------------------------------------------- |
| io.compression.codecs   <br/>(在core-site.xml中配置) | org.apache.hadoop.io.compress.DefaultCodec, <br/>org.apache.hadoop.io.compress.GzipCodec, <br/>org.apache.hadoop.io.compress.BZip2Codec,<br/>org.apache.hadoop.io.compress.Lz4Codec | 输入压缩    | Hadoop使用文件扩展名判断是否支持某种编解码器 |
| mapreduce.map.output.compress                        | false                                                        | mapper输出  | 这个参数设为true启用压缩                     |
| mapreduce.map.output.compress.codec                  | org.apache.hadoop.io.compress.DefaultCodec                   | mapper输出  | 使用LZO、LZ4或snappy编解码器在此阶段压缩数据 |
| mapreduce.output.fileoutputformat.compress           | false                                                        | reducer输出 | 这个参数设为true启用压缩                     |
| mapreduce.output.fileoutputformat.compress.codec     | org.apache.hadoop.io.compress. DefaultCodec                  | reducer输出 | 使用标准工具或者编解码器，如gzip和bzip2      |
| mapreduce.output.fileoutputformat.compress.type      | RECORD                                                       | reducer输出 | SequenceFile输出使用的压缩类型：NONE和BLOCK  |

### 开启Map输出阶段压缩

> 开启map输出阶段压缩可以减少job中map和Reduce task间数据传输量。具体配置如下：

```sql
-- 1）开启hive中间传输数据压缩功能
hive (default)>set hive.exec.compress.intermediate=true;
-- 2）开启mapreduce中map输出压缩功能
hive (default)>set mapreduce.map.output.compress=true;
-- 3）设置mapreduce中map输出数据的压缩方式
hive (default)>set mapreduce.map.output.compress.codec= org.apache.hadoop.io.compress.SnappyCodec;
-- 4）执行查询语句
hive (default)> select count(*) from aaaa;
```

### 开启Reduce输出阶段压缩

> 当Hive将输出写入到表中时，输出内容同样可以进行压缩。属性hive.exec.compress.output控制着这个功能。用户可能需要保持默认设置文件中的默认值false，这样默认的输出就是非压缩的纯文本文件了。用户可以通过在查询语句或执行脚本中设置这个值为true，来开启输出结果压缩功能。

```sql
-- 1）开启hive最终输出数据压缩功能
hive (default)>set hive.exec.compress.output=true;
-- 2）开启mapreduce最终输出数据压缩
hive (default)>set mapreduce.output.fileoutputformat.compress=true;
-- 3）设置mapreduce最终数据输出压缩方式
hive (default)> set mapreduce.output.fileoutputformat.compress.codec = org.apache.hadoop.io.compress.SnappyCodec;
-- 4）设置mapreduce最终数据输出压缩为块压缩
hive (default)> set mapreduce.output.fileoutputformat.compress.type=BLOCK;
-- 5）测试一下输出结果是否是压缩文件
hive (default)> insert overwrite local directory '/root/data' select * from aaaa;
```

## 文件存储格式

> Hive支持的存储数的格式主要有：TEXTFILE 、SEQUENCEFILE、ORC、PARQUET。

### 列式存储和行式存储

**行存储的特点：** 查询满足条件的一整行数据的时候，列存储则需要去每个聚集的字段找到对应的每个列的值，行存储只需要找到其中一个值，其余的值都在相邻地方，所以此时行存储查询的速度更快。

**列存储的特点：** 因为每个字段的数据聚集存储，在查询只需要少数几个字段的时候，能大大减少读取的数据量；每个字段的数据类型一定是相同的，列式存储可以针对性的设计更好的设计压缩算法。

TEXTFILE 和 SEQUENCEFILE 的存储格式都是基于行存储的；

ORC 和 PARQUET 是基于列式存储的。

### TEXTFILE格式

> 默认格式，数据不做压缩，磁盘开销大，数据解析开销大。可结合Gzip、Bzip2使用(系统自动检查，执行查询时自动解压)，但使用这种方式，hive不会对数据进行切分，从而无法对数据进行并行操作。

### ORC格式

> Orc (Optimized Row Columnar)是hive 0.11版里引入的新的存储格式。

​		每个Orc文件由1个或多个stripe组成，每个stripe250MB大小，这个Stripe实际相当于RowGroup概念，不过大小由4MB->250MB，这样应该能提升顺序读的吞吐率。每个Stripe里有三部分组成，分别是Index Data,Row Data,Stripe Footer：

![orc文件格式](./images/orc文件格式.png)

1. Index Data：一个轻量级的index，默认是每隔1W行做一个索引。这里做的索引应该只是记录某行的各字段在Row Data中的offset。
2. Row Data：存的是具体的数据，先取部分行，然后对这些行按列进行存储。对每个列进行了编码，分成多个Stream来存储。
3. Stripe Footer：存的是各个Stream的类型，长度等信息。

> 每个文件有一个File Footer，这里面存的是每个Stripe的行数，每个Column的数据类型信息等；每个文件的尾部是一个PostScript，这里面记录了整个文件的压缩类型以及FileFooter的长度信息等。在读取文件时，会seek到文件尾部读PostScript，从里面解析到File Footer长度，再读FileFooter，从里面解析到各个Stripe信息，再读各个Stripe，即从后往前读。

### PARQUET格式

> Parquet是面向分析型业务的列式存储格式，由Twitter和Cloudera合作开发，2015年5月从Apache的孵化器里毕业成为Apache顶级项目。

​		Parquet文件是以二进制方式存储的，所以是不可以直接读取的，文件中包括该文件的数据和元数据，因此Parquet格式文件是自解析的。

​		通常情况下，在存储Parquet数据的时候会按照Block大小设置行组的大小，由于一般情况下每一个Mapper任务处理数据的最小单位是一个Block，这样可以把每一个行组由一个Mapper任务处理，增大任务执行并行度。Parquet文件的格式如下图所示。

![parquet文件格式](./images/parquet文件格式.png)

​		上图展示了一个Parquet文件的内容，一个文件中可以存储多个行组，文件的首位都是该文件的Magic Code，用于校验它是否是一个Parquet文件，Footer length记录了文件元数据的大小，通过该值和文件长度可以计算出元数据的偏移量，文件的元数据中包括每一个行组的元数据信息和该文件存储数据的Schema信息。除了文件中每一个行组的元数据，每一页的开始都会存储该页的元数据，在Parquet中，有三种类型的页：数据页、字典页和索引页。数据页用于存储当前行组中该列的值，字典页存储该列值的编码字典，每一个列块中最多包含一个字典页，索引页用来存储当前行组下该列的索引，目前Parquet中还不支持索引页。

### 主流文件存储格式对比实验

从存储文件的压缩比和查询速度两个角度对比。存储文件的压缩比测试：

```sql
-- 1）TextFile
--（1）创建表，存储数据格式为TEXTFILE
create table log_text (track_time string,url string,session_id string,referer string,ip string,end_user_id string,city_id string)row format delimited fields terminated by '\t'stored as textfile ;
--（2）向表中加载数据
hive (default)> load data local inpath '/root/log' into table log_text ;
--（3）查看表中数据大小
dfs -du -h /user/hive/warehouse/log_text;
18.1 M  /user/hive/warehouse/log_text/log.data
-- 2）ORC
--（1）创建表，存储数据格式为ORC
create table log_orc(track_time string,url string,session_id string,referer string,ip string,end_user_id string,city_id string)row format delimited fields terminated by '\t'stored as orc ;
--（2）向表中加载数据
insert into table log_orc select * from log_text ;
--（3）查看表中数据大小
dfs -du -h /user/hive/warehouse/log_orc/ ;
2.8 M  /user/hive/warehouse/log_orc/000000_0
-- 3）Parquet
--（1）创建表，存储数据格式为parquet
create table log_parquet(track_time string,url string,session_id string,referer string,ip string,end_user_id string,city_id string)row format delimited fields terminated by '\t'stored as parquet ;	
--（2）向表中加载数据
insert into table log_parquet select * from log_text ;
--（3）查看表中数据大小
dfs -du -h /user/hive/warehouse/log_parquet/ ;
13.1 M  /user/hive/warehouse/log_parquet/000000_0
-- 存储文件的压缩比总结：
ORC >  Parquet >  textFile
```

## 存储和压缩结合

> 官网：https://cwiki.apache.org/confluence/display/Hive/LanguageManual+ORC

ORC存储方式的压缩：

| Key                      | Default    | Notes                                                        |
| ------------------------ | ---------- | ------------------------------------------------------------ |
| orc.compress             | ZLIB       | high level compression (one of NONE, ZLIB, SNAPPY)           |
| orc.compress.size        | 262,144    | number of bytes in each compression chunk                    |
| orc.stripe.size          | 67,108,864 | number of bytes in each stripe                               |
| orc.row.index.stride     | 10,000     | number of rows between index entries (must be >= 1000)       |
| orc.create.index         | true       | whether to create row indexes                                |
| orc.bloom.filter.columns | ""         | comma separated list of column names for which bloom filter should be created |
| orc.bloom.filter.fpp     | 0.05       | false positive probability for bloom filter (must >0.0 and <1.0) |

```sql
-- 1）创建一个非压缩的的ORC存储方式
--（1）建表语句
create table log_orc_none(track_time string,url string,session_id string,referer string,ip string,end_user_id string,city_id string)row format delimited fields terminated by '\t'stored as orc tblproperties ("orc.compress"="NONE");
--（2）插入数据
insert into table log_orc_none select * from log_text ;
--（3）查看插入后数据
dfs -du -h /user/hive/warehouse/log_orc_none/ ;
7.7 M  /user/hive/warehouse/log_orc_none/000000_0
-- 2）创建一个SNAPPY压缩的ORC存储方式
--（1）建表语句
create table log_orc_snappy(track_time string,url string,session_id string,referer string,ip string,end_user_id string,city_id string)row format delimited fields terminated by '\t'stored as orc tblproperties ("orc.compress"="SNAPPY");
--（2）插入数据
insert into table log_orc_snappy select * from log_text ;
--（3）查看插入后数据
dfs -du -h /user/hive/warehouse/log_orc_snappy/ ;
3.8 M  /user/hive/warehouse/log_orc_snappy/000000_0
-- 3）上一节中默认创建的ORC存储方式，导入数据后的大小为
2.8 M  /user/hive/warehouse/log_orc/000000_0
--总结
比Snappy压缩的还小。原因是orc存储文件默认采用ZLIB压缩。比snappy压缩的小。
```

## hive—high Avaliable

> 使用hiveserver2的优点如下
>
> 1. 在应用端不需要部署hadoop和hive的客户端
> 2. hiveserver2不用直接将hdfs和metastore暴露给用户
> 3. 有HA机制，解决应用端的并发和负载问题
> 4. jdbc的连接方式，可以使用任何语言，方便与应用进行数据交互

**本文主要介绍如何进行hive的HA的搭建：**

如何进行搭建，参照之前hadoop的HA，使用zookeeper完成HA

### 执行配置

需要做HA的机器做如下配置

```xml
<property>  
  <name>hive.metastore.warehouse.dir</name>  
  <value>/var/bigdata/hive-ha/warehouse</value>  
</property>  
<property>  
  <name>javax.jdo.option.ConnectionURL</name>  
  <value>jdbc:mysql://software:3306/hive-ha?createDatabaseIfNotExist=true</value>  
</property>  
<property>  
  <name>javax.jdo.option.ConnectionDriverName</name>  
  <value>com.mysql.cj.jdbc.Driver</value>  
</property>     
<property>  
  <name>javax.jdo.option.ConnectionUserName</name>  
  <value>root</value>  
</property>  
<property>  
  <name>javax.jdo.option.ConnectionPassword</name>  
  <value>tiankafei</value>  
</property>
<property>
  <name>hive.server2.support.dynamic.service.discovery</name>
  <value>true</value>
</property>
<property>
  <name>hive.server2.zookeeper.namespace</name>
  <value>hiveserver2_ha</value>
</property>
<property>
  <name>hive.zookeeper.quorum</name>
  <value>bigdata01:2181,bigdata02:2181,bigdata03:2181,bigdata04:2181</value>
</property>
<property>
  <name>hive.zookeeper.client.port</name>
  <value>2181</value>
</property>
<property>
  <name>hive.server2.thrift.bind.host</name>
  <value>当前主机名</value>
</property>
<property>
  <name>hive.server2.thrift.port</name>
  <value>10001</value> 
</property>
```

### 使用jdbc或者beeline两种方式进行访问

1. beeline

   ```shell
   !connect jdbc:hive2://bigdata01,bigdata02,bigdata03,bigdata04/;serviceDiscoveryMode=zooKeeper;zooKeeperNamespace=hiveserver2_ha root tiankafei
   ```

2. jdbc

   ```java
   try {
       Class.forName("org.apache.hive.jdbc.HiveDriver");
   } catch (ClassNotFoundException e) {
       e.printStackTrace();
   }
   
   Connection conn = DriverManager.getConnection("jdbc:hive2://bigdata01,bigdata02,bigdata03,bigdata04/;serviceDiscoveryMode=zooKeeper;zooKeeperNamespace=hiveserver2_ha", "root", "tiankafei");
   Statement stmt = conn.createStatement();
   String sql = "select * from psn limit 5";
   ResultSet res = stmt.executeQuery(sql);
   while (res.next()) {
       System.out.println(res.getString(1));
   }
   ```

   