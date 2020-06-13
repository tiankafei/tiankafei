(window.webpackJsonp=window.webpackJsonp||[]).push([[62],{409:function(s,a,t){"use strict";t.r(a);var e=t(42),o=Object(e.a)({},(function(){var s=this,a=s.$createElement,t=s._self._c||a;return t("ContentSlotsDistributor",{attrs:{"slot-key":s.$parent.slotKey}},[t("h1",{attrs:{id:"sqoop的简单概论"}},[t("a",{staticClass:"header-anchor",attrs:{href:"#sqoop的简单概论"}},[s._v("#")]),s._v(" sqoop的简单概论")]),s._v(" "),t("h2",{attrs:{id:"sqoop产生的原因"}},[t("a",{staticClass:"header-anchor",attrs:{href:"#sqoop产生的原因"}},[s._v("#")]),s._v(" sqoop产生的原因")]),s._v(" "),t("ol",[t("li",[s._v("多数使用hadoop技术的处理大数据业务的企业，有大量的数据存储在关系型数据中。")]),s._v(" "),t("li",[s._v("由于没有工具支持，对hadoop和关系型数据库之间数据传输是一个很困难的事。")])]),s._v(" "),t("blockquote",[t("p",[s._v("依据以上的原因，sqoop应运而生。")])]),s._v(" "),t("h2",{attrs:{id:"sqoop的介绍"}},[t("a",{staticClass:"header-anchor",attrs:{href:"#sqoop的介绍"}},[s._v("#")]),s._v(" sqoop的介绍")]),s._v(" "),t("p",[s._v("sqoop是连接关系型数据库和hadoop的桥梁，主要有两个方面(导入和导出)：")]),s._v(" "),t("ol",[t("li",[s._v("将关系型数据库的数据导入到Hadoop 及其相关的系统中，如 Hive和HBase")]),s._v(" "),t("li",[s._v("将数据从Hadoop 系统里抽取并导出到关系型数据库")])]),s._v(" "),t("p",[t("img",{attrs:{src:"/images/sqoop-%E5%AF%BC%E5%87%BA%E5%92%8C%E5%AF%BC%E5%85%A5.jpg",alt:"sqoop-导出和导入"}})]),s._v(" "),t("h2",{attrs:{id:"sqoop的优点"}},[t("a",{staticClass:"header-anchor",attrs:{href:"#sqoop的优点"}},[s._v("#")]),s._v(" Sqoop的优点")]),s._v(" "),t("ol",[t("li",[s._v("可以高效、可控的利用资源，可以通过调整任务数来控制任务的并发度。")]),s._v(" "),t("li",[s._v("可以自动的完成数据映射和转换。由于导入数据库是有类型的，它可以自动根据数据库中的类型转换到Hadoop 中，当然用户也可以自定义它们之间的映射关系。")]),s._v(" "),t("li",[s._v("支持多种数据库，如mysql，orcale等数据库")])]),s._v(" "),t("h2",{attrs:{id:"sqoop工作的机制"}},[t("a",{staticClass:"header-anchor",attrs:{href:"#sqoop工作的机制"}},[s._v("#")]),s._v(" sqoop工作的机制")]),s._v(" "),t("blockquote",[t("p",[s._v("将导入或导出命令翻译成MapReduce程序来实现在翻译出的,MapReduce 中主要是对InputFormat和OutputFormat进行定制")])]),s._v(" "),t("h2",{attrs:{id:"sqoop版本介绍：sqoop1和sqoop2"}},[t("a",{staticClass:"header-anchor",attrs:{href:"#sqoop版本介绍：sqoop1和sqoop2"}},[s._v("#")]),s._v(" sqoop版本介绍：sqoop1和sqoop2")]),s._v(" "),t("ol",[t("li",[t("p",[s._v("sqoop的版本sqoop1和sqoop2是两个不同的版本，它们是完全不兼容的")])]),s._v(" "),t("li",[t("p",[s._v("版本划分方式: apache1.4.X之后的版本是1，1.99.0之上的版本是2")])]),s._v(" "),t("li",[t("p",[s._v("Sqoop2相比sqoop1的优势有：")]),s._v(" "),t("ul",[t("li",[s._v("它引入的sqoop Server，便于集中化的管理Connector或者其它的第三方插件；")]),s._v(" "),t("li",[s._v("多种访问方式：CLI、Web UI、REST API；")]),s._v(" "),t("li",[s._v("它引入了基于角色的安全机制，管理员可以在sqoop Server上配置不同的角色。")])])]),s._v(" "),t("li",[t("p",[s._v("Sqoop2和sqoop1的功能性对比：")]),s._v(" "),t("p",[t("img",{attrs:{src:"/images/sqoop%E5%8A%9F%E8%83%BD%E6%80%A7%E5%AF%B9%E6%AF%94.jpg",alt:"sqoop功能性对比"}})])])]),s._v(" "),t("h2",{attrs:{id:"sqoop1和sqoop2的架构区别"}},[t("a",{staticClass:"header-anchor",attrs:{href:"#sqoop1和sqoop2的架构区别"}},[s._v("#")]),s._v(" sqoop1和sqoop2的架构区别")]),s._v(" "),t("h3",{attrs:{id:"sqoop1的架构图"}},[t("a",{staticClass:"header-anchor",attrs:{href:"#sqoop1的架构图"}},[s._v("#")]),s._v(" sqoop1的架构图")]),s._v(" "),t("p",[t("img",{attrs:{src:"/images/sqoop1%E7%9A%84%E6%9E%B6%E6%9E%84%E5%9B%BE.jpg",alt:"sqoop1的架构图"}})]),s._v(" "),t("ol",[t("li",[s._v("版本号：1.4.X以后的sqoop1")]),s._v(" "),t("li",[s._v("在架构上：sqoop1使用sqoop客户端直接提交代码方式")]),s._v(" "),t("li",[s._v("访问方式：CLI命令行控制台方式访问")]),s._v(" "),t("li",[s._v("安全性：命令或者脚本指定用户数据库名和密码")])]),s._v(" "),t("blockquote",[t("p",[s._v("原理：Sqoop工具接收到客户端的shell命令或者Java api命令后，通过Sqoop中的任务翻译器(Task Translator)将命令转换为对应的MapReduce任务，而后将关系型数据库和Hadoop中的数据进行相互转移，进而完成数据的拷贝。")])]),s._v(" "),t("h3",{attrs:{id:"sqoop2架构图"}},[t("a",{staticClass:"header-anchor",attrs:{href:"#sqoop2架构图"}},[s._v("#")]),s._v(" sqoop2架构图")]),s._v(" "),t("p",[t("img",{attrs:{src:"/images/sqoop2%E6%9E%B6%E6%9E%84%E5%9B%BE.jpg",alt:"sqoop2架构图"}})]),s._v(" "),t("ol",[t("li",[s._v("版本号：1.99.X以上的版本sqoop2")]),s._v(" "),t("li",[s._v("在架构上：sqoop2引入了 sqoop server,对对connector实现了集中的管理访问方式：REST API、 JAVA API、 WEB UI以及CLI控制台方式进行访问")]),s._v(" "),t("li",[s._v("CLI方式访问，会通过交互过程"),t("a",{attrs:{href:"https://links.jianshu.com/go?to=https%3A%2F%2Fwww.baidu.com%2Fs%3Fwd%3D%E7%95%8C%E9%9D%A2%26tn%3D24004469_oem_dg%26rsv_dl%3Dgh_pl_sl_csd",target:"_blank",rel:"noopener noreferrer"}},[s._v("界面"),t("OutboundLink")],1),s._v("，输入的密码信息会被看到，同时Sqoop2引入基亍角色的安全机制，Sqoop2比Sqoop多了一个Server端。")])]),s._v(" "),t("h2",{attrs:{id:"sqoop1和sqoop2优缺点"}},[t("a",{staticClass:"header-anchor",attrs:{href:"#sqoop1和sqoop2优缺点"}},[s._v("#")]),s._v(" Sqoop1和sqoop2优缺点")]),s._v(" "),t("h3",{attrs:{id:"sqoop1优点"}},[t("a",{staticClass:"header-anchor",attrs:{href:"#sqoop1优点"}},[s._v("#")]),s._v(" sqoop1优点")]),s._v(" "),t("blockquote",[t("p",[s._v("架构部署简单")])]),s._v(" "),t("h3",{attrs:{id:"sqoop1缺点"}},[t("a",{staticClass:"header-anchor",attrs:{href:"#sqoop1缺点"}},[s._v("#")]),s._v(" sqoop1缺点")]),s._v(" "),t("blockquote",[t("p",[s._v("命令行方式容易出错，格式紧耦合，无法支持所有数据类型，安全机制不够完善，例如密码暴漏，安装需要root权限，connector必须符合JDBC模型")])]),s._v(" "),t("h3",{attrs:{id:"sqoop2优点"}},[t("a",{staticClass:"header-anchor",attrs:{href:"#sqoop2优点"}},[s._v("#")]),s._v(" sqoop2优点")]),s._v(" "),t("blockquote",[t("p",[s._v("多种交互方式，命令行，web UI，rest API，conncetor集中化管理，所有的链接安装在sqoop server上，完善权限管理机制，connector规范化，仅仅负责数据的读写")])]),s._v(" "),t("h3",{attrs:{id:"sqoop2缺点"}},[t("a",{staticClass:"header-anchor",attrs:{href:"#sqoop2缺点"}},[s._v("#")]),s._v(" sqoop2缺点")]),s._v(" "),t("blockquote",[t("p",[s._v("sqoop2的缺点，架构稍复杂，配置部署更繁琐")])]),s._v(" "),t("h2",{attrs:{id:"安装sqoop1"}},[t("a",{staticClass:"header-anchor",attrs:{href:"#安装sqoop1"}},[s._v("#")]),s._v(" 安装sqoop1")]),s._v(" "),t("h3",{attrs:{id:"安装前提"}},[t("a",{staticClass:"header-anchor",attrs:{href:"#安装前提"}},[s._v("#")]),s._v(" 安装前提")]),s._v(" "),t("p",[s._v("Sqoop需要安装在hive，hbase的服务器上，linux环境中必须有java和hadoop环境")]),s._v(" "),t("p",[s._v("Java 1.8.0_161")]),s._v(" "),t("p",[s._v("Hadoop  2.8.5")]),s._v(" "),t("h3",{attrs:{id:"下载软件"}},[t("a",{staticClass:"header-anchor",attrs:{href:"#下载软件"}},[s._v("#")]),s._v(" 下载软件")]),s._v(" "),t("div",{staticClass:"language-http extra-class"},[t("pre",{pre:!0,attrs:{class:"language-http"}},[t("code",[s._v("# 软件下载地址：\n"),t("span",{pre:!0,attrs:{class:"token header-name keyword"}},[s._v("http:")]),s._v("//mirrors.hust.edu.cn/apache/sqoop\n")])])]),t("blockquote",[t("p",[s._v("此处下载的软件是sqoop1的软件包：sqoop-1.4.7.bin__hadoop-2.6.0.tar.gz")])]),s._v(" "),t("h3",{attrs:{id:"安装sqoop"}},[t("a",{staticClass:"header-anchor",attrs:{href:"#安装sqoop"}},[s._v("#")]),s._v(" 安装sqoop")]),s._v(" "),t("div",{staticClass:"language-shell extra-class"},[t("pre",{pre:!0,attrs:{class:"language-shell"}},[t("code",[t("span",{pre:!0,attrs:{class:"token function"}},[s._v("tar")]),s._v(" -zvxf sqoop-1.4.7.bin__hadoop-2.6.0.tar.gz\n"),t("span",{pre:!0,attrs:{class:"token function"}},[s._v("mv")]),s._v(" sqoop-1.4.7.bin__hadoop-2.6.0 /opt/bigdata/\n"),t("span",{pre:!0,attrs:{class:"token builtin class-name"}},[s._v("cd")]),s._v(" /opt/bigdata/\n"),t("span",{pre:!0,attrs:{class:"token function"}},[s._v("mv")]),s._v(" sqoop-1.4.7.bin__hadoop-2.6.0 sqoop-1.4.7\n")])])]),t("h3",{attrs:{id:"修改配置文件"}},[t("a",{staticClass:"header-anchor",attrs:{href:"#修改配置文件"}},[s._v("#")]),s._v(" 修改配置文件")]),s._v(" "),t("div",{staticClass:"language-shell extra-class"},[t("pre",{pre:!0,attrs:{class:"language-shell"}},[t("code",[t("span",{pre:!0,attrs:{class:"token builtin class-name"}},[s._v("cd")]),s._v(" /opt/bigdata/sqoop-1.4.7/conf\n"),t("span",{pre:!0,attrs:{class:"token function"}},[s._v("cp")]),s._v(" sqoop-env-template.sh  sqoop-env.sh\n"),t("span",{pre:!0,attrs:{class:"token function"}},[s._v("vim")]),s._v("  sqoop-env.sh\n")])])]),t("div",{staticClass:"language-shell extra-class"},[t("pre",{pre:!0,attrs:{class:"language-shell"}},[t("code",[t("span",{pre:!0,attrs:{class:"token builtin class-name"}},[s._v("export")]),s._v(" "),t("span",{pre:!0,attrs:{class:"token assign-left variable"}},[s._v("HADOOP_COMMON_HOME")]),t("span",{pre:!0,attrs:{class:"token operator"}},[s._v("=")]),s._v("/opt/bigdata/hadoop-2.8.3-ha/hadoop-2.8.3\n"),t("span",{pre:!0,attrs:{class:"token builtin class-name"}},[s._v("export")]),s._v(" "),t("span",{pre:!0,attrs:{class:"token assign-left variable"}},[s._v("HADOOP_MAPRED_HOME")]),t("span",{pre:!0,attrs:{class:"token operator"}},[s._v("=")]),s._v("/opt/bigdata/hadoop-2.8.3-ha/hadoop-2.8.3\n"),t("span",{pre:!0,attrs:{class:"token builtin class-name"}},[s._v("export")]),s._v(" "),t("span",{pre:!0,attrs:{class:"token assign-left variable"}},[s._v("HIVE_HOME")]),t("span",{pre:!0,attrs:{class:"token operator"}},[s._v("=")]),s._v("/opt/bigdata/apache-hive-2.3.6\n")])])]),t("blockquote",[t("p",[s._v("如果环境变量已经配置过hadoop和hive的配置，这里可以不用进行配置。")]),s._v(" "),t("p",[s._v("在apache的hadoop的安装中四大组件都是安装在同一个hadoop_home中的，但是在CDH, HDP中， 这些组件都是可选的。在安装hadoop的时候，可以选择性的只安装HDFS或者YARN。CDH,HDP在安装hadoop的时候，会把HDFS和MapReduce有可能分别安装在不同的地方。")]),s._v(" "),t("blockquote",[t("p",[s._v("CDH(Cloudera’s Distribution, including Apache Hadoop)，是Hadoop众多分支中的一种，由Cloudera维护，基于稳定版本的Apache Hadoop构建，并集成了很多补丁，可直接用于生产环境。")]),s._v(" "),t("p",[s._v("HDP(Hortonworks Data Platform)是hortworks推出的100%开源的hadoop发行版本,以YARN 作为其架构中心，包含pig、hive、phoniex、hbase、storm、spark等大量组件，在最新的2.4版本，监控UI实现与grafana集成。")])])]),s._v(" "),t("h3",{attrs:{id:"将mysql的驱动包放到sqoop的lib目录下"}},[t("a",{staticClass:"header-anchor",attrs:{href:"#将mysql的驱动包放到sqoop的lib目录下"}},[s._v("#")]),s._v(" 将mysql的驱动包放到sqoop的lib目录下")]),s._v(" "),t("div",{staticClass:"language-shell extra-class"},[t("pre",{pre:!0,attrs:{class:"language-shell"}},[t("code",[t("span",{pre:!0,attrs:{class:"token function"}},[s._v("cp")]),s._v("  mysql-connector-java-5.1.48.jar /opt/bigdata/sqoop-1.4.7/lib\n")])])]),t("h3",{attrs:{id:"修改环境变量"}},[t("a",{staticClass:"header-anchor",attrs:{href:"#修改环境变量"}},[s._v("#")]),s._v(" 修改环境变量")]),s._v(" "),t("div",{staticClass:"language-shell extra-class"},[t("pre",{pre:!0,attrs:{class:"language-shell"}},[t("code",[t("span",{pre:!0,attrs:{class:"token function"}},[s._v("vim")]),s._v(" /etc/profile\n")])])]),t("div",{staticClass:"language-shell extra-class"},[t("pre",{pre:!0,attrs:{class:"language-shell"}},[t("code",[t("span",{pre:!0,attrs:{class:"token builtin class-name"}},[s._v("export")]),s._v(" "),t("span",{pre:!0,attrs:{class:"token assign-left variable"}},[s._v("SQOOP_HOME")]),t("span",{pre:!0,attrs:{class:"token operator"}},[s._v("=")]),s._v("/opt/bigdata/sqoop-1.4.7\n"),t("span",{pre:!0,attrs:{class:"token builtin class-name"}},[s._v("export")]),s._v(" "),t("span",{pre:!0,attrs:{class:"token assign-left variable"}},[t("span",{pre:!0,attrs:{class:"token environment constant"}},[s._v("PATH")])]),t("span",{pre:!0,attrs:{class:"token operator"}},[s._v("=")]),t("span",{pre:!0,attrs:{class:"token environment constant"}},[s._v("$PATH")]),t("span",{pre:!0,attrs:{class:"token builtin class-name"}},[s._v(":")]),t("span",{pre:!0,attrs:{class:"token variable"}},[s._v("$SQOOP_HOME")]),s._v("/bin\n")])])]),t("div",{staticClass:"language-shell extra-class"},[t("pre",{pre:!0,attrs:{class:"language-shell"}},[t("code",[t("span",{pre:!0,attrs:{class:"token builtin class-name"}},[s._v("source")]),s._v(" /etc/profile\n")])])]),t("h3",{attrs:{id:"安装显示"}},[t("a",{staticClass:"header-anchor",attrs:{href:"#安装显示"}},[s._v("#")]),s._v(" 安装显示")]),s._v(" "),t("h2",{attrs:{id:"sqoop的使用"}},[t("a",{staticClass:"header-anchor",attrs:{href:"#sqoop的使用"}},[s._v("#")]),s._v(" Sqoop的使用")]),s._v(" "),t("h3",{attrs:{id:"查看数据库的名称"}},[t("a",{staticClass:"header-anchor",attrs:{href:"#查看数据库的名称"}},[s._v("#")]),s._v(" 查看数据库的名称")]),s._v(" "),t("div",{staticClass:"language-shell extra-class"},[t("pre",{pre:!0,attrs:{class:"language-shell"}},[t("code",[s._v("sqoop list-databases --connect jdbc:mysql://ip:3306/ --username 用户名--password 密码\n")])])]),t("h3",{attrs:{id:"列举出数据库中的表名"}},[t("a",{staticClass:"header-anchor",attrs:{href:"#列举出数据库中的表名"}},[s._v("#")]),s._v(" 列举出数据库中的表名")]),s._v(" "),t("div",{staticClass:"language-shell extra-class"},[t("pre",{pre:!0,attrs:{class:"language-shell"}},[t("code",[s._v("sqoop list-tables --connect jdbc:mysql://ip:3306/数据库名称 --username 用户名 --password 密码\n")])])]),t("h3",{attrs:{id:"导入"}},[t("a",{staticClass:"header-anchor",attrs:{href:"#导入"}},[s._v("#")]),s._v(" 导入")]),s._v(" "),t("div",{staticClass:"language-shell extra-class"},[t("pre",{pre:!0,attrs:{class:"language-shell"}},[t("code",[s._v("sqoop "),t("span",{pre:!0,attrs:{class:"token function"}},[s._v("import")]),s._v("  \n--connect jdbc:mysql://ip:3306/databasename "),t("span",{pre:!0,attrs:{class:"token comment"}},[s._v("#指定JDBC的URL其中database指的是(Mysql或者Oracle)中的数据库名")]),s._v("\n--table  tablename  "),t("span",{pre:!0,attrs:{class:"token comment"}},[s._v("#要读取数据库database中的表名")]),s._v("\n--username root      "),t("span",{pre:!0,attrs:{class:"token comment"}},[s._v("#用户名")]),s._v("\n--password  "),t("span",{pre:!0,attrs:{class:"token number"}},[s._v("123456")]),s._v("  "),t("span",{pre:!0,attrs:{class:"token comment"}},[s._v("#密码")]),s._v("\n--target-dir   /path  "),t("span",{pre:!0,attrs:{class:"token comment"}},[s._v("#指的是HDFS中导入表的存放目录(注意：是目录)")]),s._v("\n--fields-terminated-by "),t("span",{pre:!0,attrs:{class:"token string"}},[s._v("'"),t("span",{pre:!0,attrs:{class:"token entity",title:"\\t"}},[s._v("\\t")]),s._v("'")]),s._v("   "),t("span",{pre:!0,attrs:{class:"token comment"}},[s._v("#设定导入数据后每个字段的分隔符，默认；分隔")]),s._v("\n--lines-terminated-by "),t("span",{pre:!0,attrs:{class:"token string"}},[s._v("'"),t("span",{pre:!0,attrs:{class:"token entity",title:"\\n"}},[s._v("\\n")]),s._v("'")]),s._v("    "),t("span",{pre:!0,attrs:{class:"token comment"}},[s._v("#设定导入数据后每行的分隔符")]),s._v("\n--m "),t("span",{pre:!0,attrs:{class:"token number"}},[s._v("1")]),s._v("  "),t("span",{pre:!0,attrs:{class:"token comment"}},[s._v("#并发的map数量1,如果不设置默认启动4个map task执行数据导入，则需要指定一个列来作为划分map task任务的依据")]),s._v("\n-- where "),t("span",{pre:!0,attrs:{class:"token string"}},[s._v("'查询条件'")]),s._v("   "),t("span",{pre:!0,attrs:{class:"token comment"}},[s._v("#导入查询出来的内容，表的子集")]),s._v("\n--incremental  append  "),t("span",{pre:!0,attrs:{class:"token comment"}},[s._v("#增量导入")]),s._v("\n--check-column：column_id   "),t("span",{pre:!0,attrs:{class:"token comment"}},[s._v("#指定增量导入时的参考列")]),s._v("\n--last-value：num   "),t("span",{pre:!0,attrs:{class:"token comment"}},[s._v("#上一次导入column_id的最后一个值")]),s._v("\n--null-string "),t("span",{pre:!0,attrs:{class:"token string"}},[s._v("''")]),s._v("   "),t("span",{pre:!0,attrs:{class:"token comment"}},[s._v("#导入的字段为空时，用指定的字符进行替换")]),s._v("\n"),t("span",{pre:!0,attrs:{class:"token comment"}},[s._v("# 以上导入到hdfs中")]),s._v("\n--hive-import    "),t("span",{pre:!0,attrs:{class:"token comment"}},[s._v("#导入到hive")]),s._v("\n--hive-overwrite   "),t("span",{pre:!0,attrs:{class:"token comment"}},[s._v("#可以多次写入")]),s._v("\n--hive-database  databasename   "),t("span",{pre:!0,attrs:{class:"token comment"}},[s._v("#创建数据库，如果数据库不存在的必须写，默认存放在default中")]),s._v("\n--create-hive-table   "),t("span",{pre:!0,attrs:{class:"token comment"}},[s._v("#sqoop默认自动创建hive表")]),s._v("\n--delete-target-dir  "),t("span",{pre:!0,attrs:{class:"token comment"}},[s._v("#删除中间结果数据目录")]),s._v("\n--hive-table tablename   "),t("span",{pre:!0,attrs:{class:"token comment"}},[s._v("#创建表名")]),s._v("\n")])])]),t("h3",{attrs:{id:"导入所有的表放到hdfs中"}},[t("a",{staticClass:"header-anchor",attrs:{href:"#导入所有的表放到hdfs中"}},[s._v("#")]),s._v(" 导入所有的表放到hdfs中")]),s._v(" "),t("div",{staticClass:"language-shell extra-class"},[t("pre",{pre:!0,attrs:{class:"language-shell"}},[t("code",[s._v("sqoop import-all-tables  --connect jdbc:mysql://ip:3306/库名 --username 用户名  --password  密码  --target-dir 导入存放的目录\n")])])]),t("h3",{attrs:{id:"导出-目标表必须在mysql数据库中已经建好，数据存放在hdfs中"}},[t("a",{staticClass:"header-anchor",attrs:{href:"#导出-目标表必须在mysql数据库中已经建好，数据存放在hdfs中"}},[s._v("#")]),s._v(" 导出(目标表必须在mysql数据库中已经建好，数据存放在hdfs中)")]),s._v(" "),t("div",{staticClass:"language-shell extra-class"},[t("pre",{pre:!0,attrs:{class:"language-shell"}},[t("code",[s._v("sqoop "),t("span",{pre:!0,attrs:{class:"token builtin class-name"}},[s._v("export")]),s._v("\n--connect jdbs:mysql://ip:3600/库名 "),t("span",{pre:!0,attrs:{class:"token comment"}},[s._v("#指定JDBC的URL 其中database指的是(Mysql或者Oracle)中的数据库名")]),s._v("\n--username用户名  "),t("span",{pre:!0,attrs:{class:"token comment"}},[s._v("#数据库的用户名")]),s._v("\n--password密码     "),t("span",{pre:!0,attrs:{class:"token comment"}},[s._v("#数据库的密码")]),s._v("\n--table表名        "),t("span",{pre:!0,attrs:{class:"token comment"}},[s._v("#需要导入到数据库中的表名")]),s._v("\n--export-dir导入数据的名称    "),t("span",{pre:!0,attrs:{class:"token comment"}},[s._v("#hdfs上的数据文件")]),s._v("\n--fields-terminated-by ‘"),t("span",{pre:!0,attrs:{class:"token punctuation"}},[s._v("\\")]),s._v("t’       "),t("span",{pre:!0,attrs:{class:"token comment"}},[s._v("#HDFS中被导出的文件字段之间的分隔符")]),s._v("\n--lines-terminated-by "),t("span",{pre:!0,attrs:{class:"token string"}},[s._v("'"),t("span",{pre:!0,attrs:{class:"token entity",title:"\\n"}},[s._v("\\n")]),s._v("'")]),s._v("    "),t("span",{pre:!0,attrs:{class:"token comment"}},[s._v("#设定导入数据后每行的分隔符")]),s._v("\n--m "),t("span",{pre:!0,attrs:{class:"token number"}},[s._v("1")]),s._v("  "),t("span",{pre:!0,attrs:{class:"token comment"}},[s._v("#并发的map数量1,如果不设置默认启动4个map task执行数据导入，则需要指定一个列来作为划分map task任务的依据")]),s._v("\n--incremental  append  "),t("span",{pre:!0,attrs:{class:"token comment"}},[s._v("#增量导入")]),s._v("\n--check-column：column_id   "),t("span",{pre:!0,attrs:{class:"token comment"}},[s._v("#指定增量导入时的参考列")]),s._v("\n--last-value：num   "),t("span",{pre:!0,attrs:{class:"token comment"}},[s._v("#上一次导入column_id的最后一个值")]),s._v("\n--null-string "),t("span",{pre:!0,attrs:{class:"token string"}},[s._v("''")]),s._v("   "),t("span",{pre:!0,attrs:{class:"token comment"}},[s._v("#导出的字段为空时，用指定的字符进行替换")]),s._v("\n")])])]),t("h3",{attrs:{id:"创建和维护sqoop作业：sqoop作业创建并保存导入和导出命令"}},[t("a",{staticClass:"header-anchor",attrs:{href:"#创建和维护sqoop作业：sqoop作业创建并保存导入和导出命令"}},[s._v("#")]),s._v(" 创建和维护sqoop作业：sqoop作业创建并保存导入和导出命令")]),s._v(" "),t("h4",{attrs:{id:"创建作业"}},[t("a",{staticClass:"header-anchor",attrs:{href:"#创建作业"}},[s._v("#")]),s._v(" 创建作业")]),s._v(" "),t("div",{staticClass:"language-shell extra-class"},[t("pre",{pre:!0,attrs:{class:"language-shell"}},[t("code",[s._v("sqoop job --create作业名 -- "),t("span",{pre:!0,attrs:{class:"token function"}},[s._v("import")]),s._v("　--connect jdbc:mysql://ip:3306/数据库 --username 用户名 --table 表名 --password 密码 --m "),t("span",{pre:!0,attrs:{class:"token number"}},[s._v("1")]),s._v(" --target-dir  存放目录\n")])])]),t("h4",{attrs:{id:"验证作业（显示已经保存的作业）"}},[t("a",{staticClass:"header-anchor",attrs:{href:"#验证作业（显示已经保存的作业）"}},[s._v("#")]),s._v(" 验证作业（显示已经保存的作业）")]),s._v(" "),t("div",{staticClass:"language-shell extra-class"},[t("pre",{pre:!0,attrs:{class:"language-shell"}},[t("code",[s._v("sqoop job  --list\n")])])]),t("h4",{attrs:{id:"显示作业详细信息"}},[t("a",{staticClass:"header-anchor",attrs:{href:"#显示作业详细信息"}},[s._v("#")]),s._v(" 显示作业详细信息")]),s._v(" "),t("div",{staticClass:"language-shell extra-class"},[t("pre",{pre:!0,attrs:{class:"language-shell"}},[t("code",[s._v("sqoop  job --show作业名称\n")])])]),t("h4",{attrs:{id:"删除作业"}},[t("a",{staticClass:"header-anchor",attrs:{href:"#删除作业"}},[s._v("#")]),s._v(" 删除作业")]),s._v(" "),t("div",{staticClass:"language-shell extra-class"},[t("pre",{pre:!0,attrs:{class:"language-shell"}},[t("code",[s._v("sqoop  job  --delete作业名\n")])])]),t("h4",{attrs:{id:"执行作业"}},[t("a",{staticClass:"header-anchor",attrs:{href:"#执行作业"}},[s._v("#")]),s._v(" 执行作业")]),s._v(" "),t("div",{staticClass:"language-shell extra-class"},[t("pre",{pre:!0,attrs:{class:"language-shell"}},[t("code",[s._v("sqoop  job --exec作业\n")])])]),t("h3",{attrs:{id:"eval"}},[t("a",{staticClass:"header-anchor",attrs:{href:"#eval"}},[s._v("#")]),s._v(" eval")]),s._v(" "),t("blockquote",[t("p",[s._v("它允许用户针对各自的数据库服务器执行用户定义的查询，并在控制台中预览结果，可以使用期望导入结果数据。")])]),s._v(" "),t("ul",[t("li",[t("p",[s._v("选择查询:")]),s._v(" "),t("p",[s._v('sqoop eval -connect jdbc:mysql://ip:3306/数据库 --username 用户名  --password 密码 --query "select * from emp limit 1" $CONDITIONS\'')])]),s._v(" "),t("li",[t("p",[s._v("插入查询")]),s._v(" "),t("p",[s._v("sqoop eval  jdbc:mysql://ip:3306/数据库 --username 用户名  --password 密码 --query \"insert into emp values(4,'ceshi','hebei')\" $CONDITIONS'")])])]),s._v(" "),t("h3",{attrs:{id:"codegen"}},[t("a",{staticClass:"header-anchor",attrs:{href:"#codegen"}},[s._v("#")]),s._v(" codegen")]),s._v(" "),t("blockquote",[t("p",[s._v("从面向对象的应用程序的角度来看，每个数据库表都有一个DAO类，它包含用于初始化对象的'getter'和'setter'方法。该工具（-codegen）自动生成DAO类。")])]),s._v(" "),t("p",[s._v("​\t\t它根据表模式结构在Java中生成DAO类。Java定义被实例化为导入过程的一部分。这个工具的主要用途是检查Java是否丢失了Java代码。如果是这样，它将使用字段之间的默认分隔符创建Java的新版本,其实就是生成表名.java。")]),s._v(" "),t("div",{staticClass:"language-shell extra-class"},[t("pre",{pre:!0,attrs:{class:"language-shell"}},[t("code",[t("span",{pre:!0,attrs:{class:"token comment"}},[s._v("# 语法：sqoop codegen --connectjdbc:mysql://ip:3306/数据库 --username 用户名 --table 表名 --m 1 --password 密码")]),s._v("\n")])])])])}),[],!1,null,null,null);a.default=o.exports}}]);