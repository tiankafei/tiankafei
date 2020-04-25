# Mybatis的介绍和基本使用

## 数据库操作框架的历程

### JDBC

​		JDBC(Java Data Base Connection,java数据库连接)是一种用于执行SQL语句的Java API,可以为多种关系数据库提供统一访问,它由一组用Java语言编写的类和接口组成.JDBC提供了一种基准,据此可以构建更高级的工具和接口,使数据库开发人员能够编写数据库应用程序

- 优点：运行期：快捷、高效
- 缺点：编辑期：代码量大、繁琐异常处理、不支持数据库跨平台

![img](images\jdbc.jpg)

### DBUtils

DBUtils是Java编程中的数据库操作实用工具，小巧简单实用。

DBUtils封装了对JDBC的操作，简化了JDBC操作，可以少写代码。

DBUtils三个核心功能介绍

- QueryRunner中提供对sql语句操作的API
- ResultSetHandler接口，用于定义select操作后，怎样封装结果集
- DBUtils类，它就是一个工具类，定义了关闭资源与事务处理的方法

### Hibernate

> Hibernate 是由 Gavin King 于 2001 年创建的开放源代码的对象关系框架。它强大且高效的构建具有关系对象持久性和查询服务的 Java 应用程序。

​		Hibernate 将 Java 类映射到数据库表中，从 Java 数据类型中映射到 SQL 数据类型中，并把开发人员从 95% 的公共数据持续性编程工作中解放出来。

​		Hibernate 是传统 Java 对象和数据库服务器之间的桥梁，用来处理基于 O/R 映射机制和模式的那些对象。

![image](images\hibernate.jpg)

**Hibernate 优势**

- Hibernate 使用 XML 文件来处理映射 Java 类别到数据库表格中，并且不用编写任何代码。
- 为在数据库中直接储存和检索 Java 对象提供简单的 APIs。
- 如果在数据库中或任何其它表格中出现变化，那么仅需要改变 XML 文件属性。
- 抽象不熟悉的 SQL 类型，并为我们提供工作中所熟悉的 Java 对象。
- Hibernate 不需要应用程序服务器来操作。
- 操控你数据库中对象复杂的关联。
- 最小化与访问数据库的智能提取策略。
- 提供简单的数据询问。


**Hibernate劣势**

- hibernate的完全封装导致无法使用数据的一些功能。
- Hibernate的缓存问题。
- Hibernate对于代码的耦合度太高。
- Hibernate寻找bug困难。
- Hibernate批量数据操作需要大量的内存空间而且执行过程中需要的对象太多


### JdbcTemplate

​       JdbcTemplate针对数据查询提供了多个重载的模板方法,你可以根据需要选用不同的模板方法.如果你的查询很简单，仅仅是传入相应SQL或者相关参数，然后取得一个单一的结果，那么你可以选择如下一组便利的模板方法。

​		优点：运行期：高效、内嵌Spring框架中、支持基于AOP的声明式事务
​		缺点：必须于Spring框架结合在一起使用、不支持数据库跨平台、默认没有缓存

## 什么是Mybatis？

​		MyBatis 是一款优秀的持久层框架，它支持自定义 SQL、存储过程以及高级映射。MyBatis 免除了几乎所有的 JDBC 代码以及设置参数和获取结果集的工作。MyBatis 可以通过简单的 XML 或注解来配置和映射原始类型、接口和 Java POJO（Plain Old Java Objects，普通老式 Java 对象）为数据库中的记录。

**优点：**

1. 与JDBC相比，减少了50%的代码量
2. 最简单的持久化框架，简单易学
3. SQL代码从程序代码中彻底分离出来，可以重用
4. 提供XML标签，支持编写动态SQL
5. 提供映射标签，支持对象与数据库的ORM字段关系映射

**缺点：**

	1. SQL语句编写工作量大，熟练度要高
 	2. 数据库移植性比较差，如果需要切换数据库的话，SQL语句会有很大的差异

## 第一个Mybatis项目

### 创建普通的maven项目：导入相关的依赖

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.mashibing</groupId>
    <artifactId>mybatis_helloworld</artifactId>
    <version>1.0-SNAPSHOT</version>

    <dependencies>
        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis</artifactId>
            <version>3.5.4</version>
        </dependency>
        <!-- https://mvnrepository.com/artifact/mysql/mysql-connector-java -->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>8.0.16</version>
        </dependency>
        <!-- https://mvnrepository.com/artifact/log4j/log4j -->
        <dependency>
            <groupId>log4j</groupId>
            <artifactId>log4j</artifactId>
            <version>1.2.17</version>
        </dependency>
        <!--lombok简写get\set方法注解-->
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <version>1.18.8</version>
        </dependency>
    </dependencies>

</project>
```

### 创建对应的数据表

> 数据表我们使用之前的demo数据库，脚本文件在群里，大家自行去下载安装

### 创建与表对应的实体类对象

```java
package com.mashibing.bean;

import java.util.Date;

@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class Emp {

    private Integer empno;
    private String ename;
    private String job;
    private Integer mgr;
    private Date hiredate;
    private Double sal;
    private Double common;
    private Integer deptno;

    public Emp() {
    }

    public Emp(Integer empno, String ename, String job, Integer mgr, Date hiredate, Double sal, Double common, Integer deptno) {
        this.empno = empno;
        this.ename = ename;
        this.job = job;
        this.mgr = mgr;
        this.hiredate = hiredate;
        this.sal = sal;
        this.common = common;
        this.deptno = deptno;
    }
}
```

### 创建对应的dao类

```java
package com.mashibing.dao;

import com.mashibing.bean.Emp;

public interface EmpDao {

    public Emp findEmpByEmpno(Integer empno);
    
}
```

### 编写配置文件

log4j.properties

```properties
# 全局日志配置
log4j.rootLogger=ERROR, stdout
# MyBatis 日志配置
log4j.logger.com.mashibing=TRACE
# 控制台输出
log4j.appender.stdout=org.apache.log4j.ConsoleAppender
log4j.appender.stdout.layout=org.apache.log4j.PatternLayout
log4j.appender.stdout.layout.ConversionPattern=%5p [%t] - %m%n
```

mybatis-config.xml

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
    <environments default="development">
        <environment id="development">
            <transactionManager type="JDBC"/>
            <!--配置数据库连接-->
            <dataSource type="POOLED">
                <property name="driver" value="com.mysql.cj.jdbc.Driver"/>
                <property name="url" value="jdbc:mysql://localhost:3306/demo?serverTimezone=UTC"/>
                <property name="username" value="root"/>
                <property name="password" value="123456"/>
            </dataSource>
        </environment>
    </environments>
    <!--引入每一个接口对应点xml文件-->
    <mappers>
        <mapper resource="EmpDao.xml"/>
    </mappers>
</configuration>
```

EmpDao.xml

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<!--namespace:编写接口的全类名，就是告诉要实现该配置文件是哪个接口的具体实现-->
<mapper namespace="com.mashibing.dao.EmpDao">
    <!--
    select:表示这个操作是一个查询操作
    id表示的是要匹配的方法的名称
    resultType:表示返回值的类型，查询操作必须要包含返回值的类型
    #{属性名}：表示要传递的参数的名称
    -->
    <select id="findEmpByEmpno" resultType="com.mashibing.bean.Emp">
        select * from emp where empno = #{empno}
  </select>
</mapper>
```

### 编写测试类

MyTest.java

```java
package com.mashibing.test;

import com.mashibing.bean.Emp;
import com.mashibing.dao.EmpDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class MyTest {

    @Test
    public void test01() {
        // 根据全局配置文件创建出SqlSessionFactory
        // SqlSessionFactory:负责创建SqlSession对象的工厂
        // SqlSession:表示跟数据库建议的一次会话
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 获取数据库的会话
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Emp empByEmpno = null;
        try {
            // 获取要调用的接口类
            EmpDao mapper = sqlSession.getMapper(EmpDao.class);
            // 调用方法开始执行
            empByEmpno = mapper.findEmpByEmpno(7369);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
        System.out.println(empByEmpno);
    }
}
```

## 增删改查的基本操作

EmpDao.java

```java
package com.mashibing.dao;

import com.mashibing.bean.Emp;

public interface EmpDao {

    public Emp findEmpByEmpno(Integer empno);

    public int updateEmp(Emp emp);

    public int deleteEmp(Integer empno);

    public int insertEmp(Emp emp);

}
```

EmpDao.xml

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<!--namespace:编写接口的全类名，就是告诉要实现该配置文件是哪个接口的具体实现-->
<mapper namespace="com.mashibing.dao.EmpDao">
    <!--
    select:表示这个操作是一个查询操作
    id表示的是要匹配的方法的名称
    resultType:表示返回值的类型，查询操作必须要包含返回值的类型
    #{属性名}：表示要传递的参数的名称
    -->
    <select id="findEmpByEmpno" resultType="com.mashibing.bean.Emp">
        select * from emp where empno = #{empno}
    </select>
    <!--增删改查操作不需要返回值，增删改返回的是影响的行数，mybatis会自动做判断-->
    <insert id="insertEmp">
        insert into emp(empno,ename) values(#{empno},#{ename})
    </insert>
    <update id="updateEmp">
        update emp set ename=#{ename} where empno = #{empno}
    </update>
    <delete id="deleteEmp">
        delete from emp where empno = #{empno}
    </delete>
</mapper>
```

MyTest.java

```java
package com.mashibing.test;

import com.mashibing.bean.Emp;
import com.mashibing.dao.EmpDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class MyTest {
    SqlSessionFactory sqlSessionFactory = null;
    @Before
    public void init(){
        // 根据全局配置文件创建出SqlSessionFactory
        // SqlSessionFactory:负责创建SqlSession对象的工厂
        // SqlSession:表示跟数据库建议的一次会话
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory= new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void test01() {

        // 获取数据库的会话
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Emp empByEmpno = null;
        try {
            // 获取要调用的接口类
            EmpDao mapper = sqlSession.getMapper(EmpDao.class);
            // 调用方法开始执行
            empByEmpno = mapper.findEmpByEmpno(7369);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
        System.out.println(empByEmpno);
    }

    @Test
    public void test02(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmpDao mapper = sqlSession.getMapper(EmpDao.class);
        int zhangsan = mapper.insertEmp(new Emp(1111, "zhangsan"));
        System.out.println(zhangsan);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test03(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmpDao mapper = sqlSession.getMapper(EmpDao.class);
        int zhangsan = mapper.updateEmp(new Emp(1111, "lisi"));
        System.out.println(zhangsan);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test04(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmpDao mapper = sqlSession.getMapper(EmpDao.class);
        int zhangsan = mapper.deleteEmp(1111);
        System.out.println(zhangsan);
        sqlSession.commit();
        sqlSession.close();
    }
}
```

## 配置文件详解

​		在mybatis的项目中，我们发现了有一个mybatis-config.xml的配置文件，这个配置文件是mybatis的全局配置文件，用来进行相关的全局配置，在任何操作下都生效的配置。下面我们要针对其中的属性做详细的解释，方便大家在后续使用的时候更加熟练。

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
    <!--引入外部配置文件，类似于Spring中的property-placeholder
    resource:从类路径引入
    url:从磁盘路径或者网络路径引入
    -->
    <properties resource="db.properties"></properties>
    <!--用来控制mybatis运行时的行为，是mybatis中的重要配置-->
    <settings>
        <!--设置列名映射的时候是否是驼峰标识-->
        <setting name="mapUnderscoreToCamelCase" value="true"/>
    </settings>
    <!--typeAliases表示为我们引用的实体类起别名，默认情况下我们需要写类的完全限定名
    如果在此处做了配置，那么可以直接写类的名称,在type中配置上类的完全限定名，在使用的时候可以忽略大小写
    还可以通过alias属性来表示类的别名
    -->
    <typeAliases>
<!--        <typeAlias type="com.mashibing.bean.Emp" alias="Emp"></typeAlias>-->
        <!--如果需要引用多个类，那么给每一个类起别名肯定会很麻烦，因此可以指定对应的包名，那么默认用的是类名-->
        <package name="com.mashibing.bean"/>
    </typeAliases>
    <!--
    在实际的开发过程中，我们可能分为开发环境，生产环境，测试环境等等，每个环境的配置可以是不一样的
    environment就用来表示不同环境的细节配置，每一个环境中都需要一个事务管理器以及数据源的配置
    我们在后续的项目开发中几乎都是使用spring中配置的数据源和事务管理器来配置，此处不需要研究
    -->
    <!--default:用来选择需要的环境-->
    <environments default="development">
        <!--id:表示不同环境的名称-->
        <environment id="development">
            <transactionManager type="JDBC"/>
            <!--配置数据库连接-->
            <dataSource type="POOLED">
                <!--使用${}来引入外部变量-->
                <property name="driver" value="${driverClassname}"/>
                <property name="url" value="${url}"/>
                <property name="username" value="${username}"/>
                <property name="password" value="${password}"/>
            </dataSource>
        </environment>
    </environments>
    <!--
    在不同的数据库中，可能sql语句的写法是不一样的，为了增强移植性，可以提供不同数据库的操作实现
    在编写不同的sql语句的时候，可以指定databaseId属性来标识当前sql语句可以运行在哪个数据库中
    -->
    <databaseIdProvider type="DB_VENDOR">
        <property name="MySQL" value="mysql"/>
        <property name="SQL Server" value="sqlserver"/>
        <property name="Oracle" value="orcl"/>
    </databaseIdProvider>
    
    <!--将sql的映射文件适用mappers进行映射-->
    <mappers>
        <!--
        指定具体的不同的配置文件
        class:直接引入接口的全类名，可以将xml文件放在dao的同级目录下，并且设置相同的文件名称，同时可以使用注解的方式来进行相关的配置
        url:可以从磁盘或者网络路径查找sql映射文件
        resource:在类路径下寻找sql映射文件
        -->
<!--        <mapper resource="EmpDao.xml"/>
        <mapper resource="UserDao.xml"/>
        <mapper class="com.mashibing.dao.EmpDaoAnnotation"></mapper>-->
        <!--
        当包含多个配置文件或者配置类的时候，可以使用批量注册的功能，也就是引入对应的包，而不是具体的配置文件或者类
        但是需要注意的是，
        1、如果使用的配置文件的形式，必须要将配置文件跟dao类放在一起，这样才能找到对应的配置文件.
            如果是maven的项目的话，还需要添加以下配置，原因是maven在编译的文件的时候只会编译java文件
                <build>
                    <resources>
                        <resource>
                            <directory>src/main/java</directory>
                        <includes>
                            <include>**/*.xml</include>
                        </includes>
                    </resource>
                    </resources>
                </build>

        2、将配置文件在resources资源路径下创建跟dao相同的包名
        -->
        <package name="com.mashibing.dao"/>
    </mappers>
</configuration>
```

EmpDaoAnnotation.java

```java
package com.mashibing.dao;

import com.mashibing.bean.Emp;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface EmpDaoAnnotation {

    @Select("select * from emp where empno = #{empno}")
    public Emp findEmpByEmpno(Integer empno);

    @Update("update emp set ename=#{ename} where empno = #{empno}")
    public int updateEmp(Emp emp);

    @Delete("delete from emp where empno = #{empno}")
    public int deleteEmp(Integer empno);

    @Insert("insert into emp(empno,ename) values(#{empno},#{ename})")
    public int insertEmp(Emp emp);

}
```

# Mybatis SQL映射文件详解

​		在之前我们学习了mybatis的全局配置文件，下面我们开始学习mybatis的映射文件，在映射文件中，可以编写以下的顶级元素标签：

```
cache – 该命名空间的缓存配置。
cache-ref – 引用其它命名空间的缓存配置。
resultMap – 描述如何从数据库结果集中加载对象，是最复杂也是最强大的元素。
parameterMap – 老式风格的参数映射。此元素已被废弃，并可能在将来被移除！请使用行内参数映射。文档中不会介绍此元素。
sql – 可被其它语句引用的可重用语句块。
insert – 映射插入语句。
update – 映射更新语句。
delete – 映射删除语句。
select – 映射查询语句。
```

​		在每个顶级元素标签中可以添加很多个属性，下面我们开始详细了解下具体的配置。

## insert、update、delete元素

| 属性               | 描述                                                         |
| :----------------- | :----------------------------------------------------------- |
| `id`               | 在命名空间中唯一的标识符，可以被用来引用这条语句。           |
| `parameterType`    | 将会传入这条语句的参数的类全限定名或别名。这个属性是可选的，因为 MyBatis 可以通过类型处理器（TypeHandler）推断出具体传入语句的参数，默认值为未设置（unset）。 |
| `parameterMap`     | 用于引用外部 parameterMap 的属性，目前已被废弃。请使用行内参数映射和 parameterType 属性。 |
| `flushCache`       | 将其设置为 true 后，只要语句被调用，都会导致本地缓存和二级缓存被清空，默认值：（对 insert、update 和 delete 语句）true。 |
| `timeout`          | 这个设置是在抛出异常之前，驱动程序等待数据库返回请求结果的秒数。默认值为未设置（unset）（依赖数据库驱动）。 |
| `statementType`    | 可选 STATEMENT，PREPARED 或 CALLABLE。这会让 MyBatis 分别使用 Statement，PreparedStatement 或 CallableStatement，默认值：PREPARED。 |
| `useGeneratedKeys` | （仅适用于 insert 和 update）这会令 MyBatis 使用 JDBC 的 getGeneratedKeys 方法来取出由数据库内部生成的主键（比如：像 MySQL 和 SQL Server 这样的关系型数据库管理系统的自动递增字段），默认值：false。 |
| `keyProperty`      | （仅适用于 insert 和 update）指定能够唯一识别对象的属性，MyBatis 会使用 getGeneratedKeys 的返回值或 insert 语句的 selectKey 子元素设置它的值，默认值：未设置（`unset`）。如果生成列不止一个，可以用逗号分隔多个属性名称。 |
| `keyColumn`        | （仅适用于 insert 和 update）设置生成键值在表中的列名，在某些数据库（像 PostgreSQL）中，当主键列不是表中的第一列的时候，是必须设置的。如果生成列不止一个，可以用逗号分隔多个属性名称。 |
| `databaseId`       | 如果配置了数据库厂商标识（databaseIdProvider），MyBatis 会加载所有不带 databaseId 或匹配当前 databaseId 的语句；如果带和不带的语句都有，则不带的会被忽略。 |

```xml
<!--如果数据库支持自增可以使用这样的方式-->
<insert id="insertUser" useGeneratedKeys="true" keyProperty="id">
    insert into user(user_name) values(#{userName})
</insert>
<!--如果数据库不支持自增的话，那么可以使用如下的方式进行赋值查询-->
<insert id="insertUser2" >
    <selectKey order="BEFORE" keyProperty="id" resultType="integer">
        select max(id)+1 from user
    </selectKey>
    insert into user(id,user_name) values(#{id},#{userName})
</insert>
```

## select元素

### select的参数传递

```xml
<!--
   当查询语句中包含多个参数的是，如果使用#{属性名称}就无法获取具体的值了，那么应该如何使用呢？
       下面就是mybatis的参数传递方式
       1、如果是单个参数，
           基本类型：使用#{随便写}
           引用类型：使用#{类的属性名称}
       2、多个参数：
           当查询的时候传入多个参数的时候，就无法简单的通过#{参数名}来获取值了，
           只能通过arg0,arg1...或者param1,param2等方式来获取值
           原因就在于，mybatis在传入多个参数的时候，会将这些参数封装到一个map中，此时map中的key就是
           arg0,arg1,param1,param2这些值，但是很明显，这样的传值方式不是很友好，没有办法根据参数的名称来
           获取具体的值，因此可以使用如下的方式来指定参数的key是什么
           Emp selectEmpByNoAndName(@Param("empno") Integer empno, @Param("ename") String ename);
               也就是通过@Param来指定存入map中的key值是什么
       3、使用map来传递参数：
               依然是直接使用#{key}来获取具体的属性值
-->
<select id="selectEmpByNoAndName" resultType="com.mashibing.bean.Emp">
    select * from emp where empno=#{empno} and ename=#{ename}
</select>

<select id="selectEmpByNoAndName2" resultType="com.mashibing.bean.Emp">
    select * from emp where empno=#{empno} and ename=#{ename}
</select>
```

### 参数的取值方式

在xml文件中编写sql语句的时候有两种取值的方式，分别是#{}和${}，下面来看一下他们之间的区别：

```xml
 <!--
        当使用#{}来获取值的时候会发现打印的sql语句如下：
            select * from emp where empno=? and ename=?
        当使用${}来获取值的时候会发现打印的sql语句如下：
            select * from emp where empno=7369 and ename='SMITH'
        通过刚刚的案例大家已经发现了存在的问题了，
        使用#{}方式进行取值：采用的是参数预编译的方式，参数的位置使用？进行替代，不会出现sql注入的问题
        使用${}方式进行取值：采用的是直接跟sql语句进行拼接的方式

		此处大家需要注意，如果我们的sql语句中的某些值不支持参数预编译，那么就必须要使用${}的方式来取值了
    -->
    <select id="selectEmpByNoAndName" resultType="com.mashibing.bean.Emp">
        select * from #{t} where empno=${empno} and ename=${ename}
    </select>
```

### 处理集合返回结果

EmpDao.xml

```xml
<!--当返回值的结果是集合的时候，返回值的类型依然写的是集合中具体的类型-->
<select id="selectAllEmp" resultType="com.mashibing.bean.Emp">
    select  * from emp
</select>
<!--在查询的时候可以设置返回值的类型为map，当mybatis查询完成之后会把列的名称作为key
    列的值作为value，转换到map中
    -->
<select id="selectEmpByEmpReturnMap" resultType="map">
    select * from emp where empno = #{empno}
</select>

<!--注意，当返回的结果是一个集合对象的是，返回值的类型一定要写集合具体value的类型
    同时在dao的方法上要添加@MapKey的注解，来设置key是什么结果
    @MapKey("empno")
    Map<Integer,Emp> getAllEmpReturnMap();-->
<select id="getAllEmpReturnMap" resultType="com.mashibing.bean.Emp">
    select * from emp
</select>
```

UserDao.java

```java
package com.mashibing.dao;

import com.mashibing.bean.Emp;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface EmpDao {

    public Emp findEmpByEmpno(Integer empno);

    public int updateEmp(Emp emp);

    public int deleteEmp(Integer empno);

    public int insertEmp(Emp emp);

    Emp selectEmpByNoAndName(@Param("empno") Integer empno, @Param("ename") String ename,@Param("t") String tablename);
    Emp selectEmpByNoAndName2(Map<String,Object> map);

    List<Emp> selectAllEmp();

    Map<String,Object> selectEmpByEmpReturnMap(Integer empno);

    @MapKey("empno")
    Map<Integer,Emp> getAllEmpReturnMap();
}
```

### 自定义结果集---resultMap

```java
package com.mashibing.bean;

@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class Dog {
    private Integer id;
    private String name;
    private Integer age;
    private String gender;
}
```

dog.sql

```sql
DROP TABLE IF EXISTS `dog`;
CREATE TABLE `dog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dname` varchar(255) DEFAULT NULL,
  `dage` int(11) DEFAULT NULL,
  `dgender` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

INSERT INTO dog VALUES ('1', '大黄', '1', '雄');
INSERT INTO dog VALUES ('2', '二黄', '2', '雌');
INSERT INTO dog VALUES ('3', '三黄', '3', '雄');
```

DogDao.java

```java
package com.mashibing.dao;

import com.mashibing.bean.Dog;

public interface DogDao {

    public Dog selectDogById(Integer id);
}
```

DogDao.xml

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.mashibing.dao.DogDao">
   <!--
   在使用mybatis进行查询的时候，mybatis默认会帮我们进行结果的封装，但是要求列名跟属性名称一一对应上
   在实际的使用过程中，我们会发现有时候数据库中的列名跟我们类中的属性名并不是一一对应的，此时就需要起别名
   起别名有两种实现方式：
      1、在编写sql语句的时候添加别名
      2、自定义封装结果集
   -->
   <!--根据查询的数据进行结果的封装要使用resultMap属性，表示使用自定义规则-->
   <select id="selectDogById" resultMap="myDog">
      select * from dog where id = #{id}
   </select>

   <!--自定义结果集，将每一个列的数据跟javaBean的对象属性对应起来
   type:表示为哪一个javaBean对象进行对应
   id:唯一标识，方便其他属性标签进行引用
   -->
   <resultMap id="myDog" type="com.mashibing.bean.Dog">
      <!--
      指定主键列的对应规则：
      column：表示表中的主键列
      property:指定javaBean的属性
      -->
      <id column="id" property="id"></id>
      <!--设置其他列的对应关系-->
      <result column="dname" property="name"></result>
      <result column="dage" property="age"></result>
      <result column="dgender" property="gender"></result>
   </resultMap>
   <!--可以在sql语句中写别名-->
 <!--  <select id="selectDogById" resultType="com.mashibing.bean.Dog">
      select id id,dname name,dage age,dgender gender from dog where id = #{id}
   </select>-->

   <!--这种方式是查询不到任何结果的，因为属性名跟列名并不是一一对应的-->
  <!-- <select id="selectDogById" resultType="com.mashibing.bean.Dog">
      select * from dog where id = #{id}
   </select>-->
</mapper>
```

### 联合查询

```java
package com.mashibing.bean;

import java.util.Date;

@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class Emp {

    private Integer empno;
    private String ename;
    private String job;
    private Integer mgr;
    private Date hiredate;
    private Double sal;
    private Double common;
    private Dept dept;

    public Emp() {
    }

    public Emp(Integer empno, String ename) {
        this.empno = empno;
        this.ename = ename;
    }

    public Emp(Integer empno, String ename, String job, Integer mgr, Date hiredate, Double sal, Double common, Dept dept) {
        this.empno = empno;
        this.ename = ename;
        this.job = job;
        this.mgr = mgr;
        this.hiredate = hiredate;
        this.sal = sal;
        this.common = common;
        this.dept = dept;
    }
}
```

Dept.java

```java
package com.mashibing.bean;

@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class Dept {
    private Integer deptno;
    private String dname;
    private String loc;

    public Dept() {
    }

    public Dept(Integer deptno, String dname, String loc) {
        this.deptno = deptno;
        this.dname = dname;
        this.loc = loc;
    }
}
```

EmpDao.xml

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<!--namespace:编写接口的全类名，就是告诉要实现该配置文件是哪个接口的具体实现-->
<mapper namespace="com.mashibing.dao.EmpDao">

    <!--再做查询的时候，有时候需要关联其他对象，因此需要使用关联查询
    可以通过下面自定义结果集的方式实现
    -->
    <select id="selectEmpAndDept" resultMap="empDept">
        select * from emp left join dept on emp.deptno = dept.deptno where empno = #{empno};
    </select>
    <resultMap id="empDept" type="com.mashibing.bean.Emp">
        <id column="empno" property="empno"></id>
        <result column="ename" property="ename"></result>
        <result column="job" property="job"></result>
        <result column="mgr" property="mgr"></result>
        <result column="hiredate" property="hiredate"></result>
        <result column="sal" property="sal"></result>
        <result column="comm" property="common"></result>
        <result column="deptno" property="dept.deptno"></result>
        <result column="dname" property="dept.dname"></result>
        <result column="loc" property="dept.loc"></result>
    </resultMap>
    <!--在mybatis中还提供了一种简单的形式，使用association标签可以搞定
    -->
    <resultMap id="empDept" type="com.mashibing.bean.Emp">
        <id column="empno" property="empno"></id>
        <result column="ename" property="ename"></result>
        <result column="job" property="job"></result>
        <result column="mgr" property="mgr"></result>
        <result column="hiredate" property="hiredate"></result>
        <result column="sal" property="sal"></result>
        <result column="comm" property="common"></result>
        <association property="dept" javaType="com.mashibing.bean.Dept">
            <id column="deptno" property="deptno"></id>
            <result column="dname" property="dname"></result>
            <result column="loc" property="loc"></result>
        </association>
    </resultMap>
</mapper>
```

测试方法

```java
@Test
public void test08() {
    // 获取数据库的会话
    SqlSession sqlSession = sqlSessionFactory.openSession();
    try {
        EmpDao mapper = sqlSession.getMapper(EmpDao.class);
        Emp emp = mapper.selectEmpAndDept(7369);
        System.out.println(emp);
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        sqlSession.close();
    }
}
```

### 获取集合元素

```java
package com.mashibing.bean;

import java.util.List;

@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class Dept {
    private Integer deptno;
    private String dname;
    private String loc;

    private List<Emp> emps;

    public Dept() {
    }

    public Dept(Integer deptno, String dname, String loc) {
        this.deptno = deptno;
        this.dname = dname;
        this.loc = loc;
    }
}
```

DeptDao.java

```java
package com.mashibing.dao;

import com.mashibing.bean.Dept;
import com.mashibing.bean.Emp;

import java.util.List;

public interface DeptDao {

    public Dept getDeptAndEmps(Integer deptno);
}

```

DeptDao.xml

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.mashibing.dao.DeptDao">
    <!--定义查询集合元素-->
    <select id="getDeptAndEmps" resultMap="deptEmp">
        select * from dept left join emp on dept.deptno = emp.deptno where dept.deptno=#{deptno}
    </select>
    <resultMap id="deptEmp" type="com.mashibing.bean.Dept">
        <id property="deptno" column="deptno"></id>
        <result property="dname" column="dname"></result>
        <result property="loc" column="loc"></result>
        <!--封装集合类的元素
            property：指定集合的属性
            ofType:指定集合中的元素类型
        -->
        <collection property="emps" ofType="com.mashibing.bean.Emp">
            <id property="empno" column="empno"></id>
            <result column="ename" property="ename"></result>
            <result column="job" property="job"></result>
            <result column="mgr" property="mgr"></result>
            <result column="hiredate" property="hiredate"></result>
            <result column="sal" property="sal"></result>
            <result column="comm" property="common"></result>
        </collection>
    </resultMap>
</mapper>
```

测试方法

```java
@Test
public void test09() {

    // 获取数据库的会话
    SqlSession sqlSession = sqlSessionFactory.openSession();
    try {
        DeptDao mapper = sqlSession.getMapper(DeptDao.class);
        Dept deptAndEmps = mapper.getDeptAndEmps(10);
        System.out.println(deptAndEmps);
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        sqlSession.close();
    }
}
```

### 分步查询

> 在上述逻辑的查询中，是由我们自己来完成sql语句的关联查询的，那么，我们能让mybatis帮我们实现自动的关联查询吗?
>

#### 关联查询的分步

DeptDao.java

```java
package com.mashibing.dao;

import com.mashibing.bean.Dept;
import com.mashibing.bean.Emp;

import java.util.List;

public interface DeptDao {

    public Dept getDeptAndEmps(Integer deptno);

    public Dept getDeptAndEmpsBySimple(Integer deptno);
}

```

EmpDao.java

```java
package com.mashibing.dao;

import com.mashibing.bean.Emp;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface EmpDao {

    Emp selectEmpAndDept(Integer empno);
    Emp selectEmpAndDeptBySimple(Integer empno);
}

```

DeptDao.xml

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.mashibing.dao.DeptDao">
    <select id="getDeptAndEmpsBySimple" resultType="com.mashibing.bean.Dept">
        select * from dept where deptno = #{deptno}
    </select>
</mapper>
```

EmpDao.xml

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.mashibing.dao.EmpDao">

    <select id="selectEmpAndDeptBySimple" resultMap="simpleEmpAndDept">
        select * from emp where empno = #{empno}
    </select>
    <resultMap id="simpleEmpAndDept" type="com.mashibing.bean.Emp">
        <id column="empno" property="empno"></id>
        <result column="ename" property="ename"></result>
        <result column="job" property="job"></result>
        <result column="mgr" property="mgr"></result>
        <result column="hiredate" property="hiredate"></result>
        <result column="sal" property="sal"></result>
        <result column="comm" property="common"></result>
        <association property="dept" select="com.mashibing.dao.DeptDao.getDeptAndEmpsBySimple" column="deptno">
        </association>
    </resultMap>
</mapper>
```

测试方法

```java
@Test
public void test08() {

    // 获取数据库的会话
    SqlSession sqlSession = sqlSessionFactory.openSession();
    try {
        EmpDao mapper = sqlSession.getMapper(EmpDao.class);
        //            Emp emp = mapper.selectEmpAndDept(7369);
        Emp emp = mapper.selectEmpAndDeptBySimple(7369);
        System.out.println(emp);
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        sqlSession.close();
    }
}
```

#### 集合的分步查询

EmpDao.java

```java
package com.mashibing.dao;

import com.mashibing.bean.Emp;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface EmpDao {
    Emp selectEmpAndDeptBySimple(Integer empno);
    Emp selectEmpByStep(Integer empno);
}

```

DeptDao.java

```java
package com.mashibing.dao;

import com.mashibing.bean.Dept;
import com.mashibing.bean.Emp;

import java.util.List;

public interface DeptDao {

    public Dept getDeptAndEmps(Integer deptno);

    public Dept getDeptAndEmpsBySimple(Integer deptno);

    public Dept getDeptAndEmpsByStep(Integer deptno);
}

```

EmpDao.xml

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.mashibing.dao.EmpDao">

    <select id="selectEmpByStep" resultType="com.mashibing.bean.Emp">
        select * from emp where deptno = #{deptno}
    </select>
</mapper>
```

DeptDao.xml

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.mashibing.dao.DeptDao">

    <select id="getDeptAndEmpsByStep" resultMap="deptEmpByStep">
        select * from dept where deptno = #{deptno}
    </select>
    <resultMap id="deptEmpByStep" type="com.mashibing.bean.Dept">
        <id property="deptno" column="deptno"></id>
        <result property="dname" column="dname"></result>
        <result property="loc" column="loc"></result>
        <!--封装集合类的元素
            property：指定集合的属性
            ofType:指定集合中的元素类型
        -->
        <collection property="emps" ofType="com.mashibing.bean.Emp" select="com.mashibing.dao.EmpDao.selectEmpByStep" column="deptno">
        </collection>
    </resultMap>
</mapper>
```

测试方法

```java
@Test
public void test09() {

    // 获取数据库的会话
    SqlSession sqlSession = sqlSessionFactory.openSession();
    try {
        DeptDao mapper = sqlSession.getMapper(DeptDao.class);
        //            Dept deptAndEmps = mapper.getDeptAndEmps(10);
        Dept deptAndEmpsByStep = mapper.getDeptAndEmpsByStep(10);
        System.out.println(deptAndEmpsByStep);
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        sqlSession.close();
    }
}
```

### 延迟查询

​		当我们在进行表关联的时候，有可能在查询结果的时候不需要关联对象的属性值，那么此时可以通过延迟加载来实现功能。在全局配置文件中添加如下属性

mybatis-config.xml

```xml
<settings>
    <!--开启延时加载-->
    <setting name="lazyLoadingEnabled" value="true"/>
</settings>
```

如果设置了全局加载，但是希望在某一个sql语句查询的时候不适用延时策略，可以添加如下属性：

```xml
<association property="dept" select="com.mashibing.dao.DeptDao.getDeptAndEmpsBySimple" column="deptno" fetchType="eager"/>
```

## 动态sql

​		动态 SQL 是 MyBatis 的强大特性之一。如果你使用过 JDBC 或其它类似的框架，你应该能理解根据不同条件拼接 SQL 语句有多痛苦，例如拼接时要确保不能忘记添加必要的空格，还要注意去掉列表最后一个列名的逗号。利用动态 SQL，可以彻底摆脱这种痛苦。

​		使用动态 SQL 并非一件易事，但借助可用于任何 SQL 映射语句中的强大的动态 SQL 语言，MyBatis 显著地提升了这一特性的易用性。

​		如果你之前用过 JSTL 或任何基于类 XML 语言的文本处理器，你对动态 SQL 元素可能会感觉似曾相识。在 MyBatis 之前的版本中，需要花时间了解大量的元素。借助功能强大的基于 OGNL 的表达式，MyBatis 3 替换了之前的大部分元素，大大精简了元素种类，现在要学习的元素种类比原来的一半还要少。

- if
- choose (when, otherwise)
- trim (where, set)
- foreach

### if	

EmpDao.xml

```xml
<select id="getEmpByCondition" resultType="com.mashibing.bean.Emp">
        select * from emp where 
        <if test="empno!=null">
            empno > #{empno} and
        </if>
        <if test="ename!=null">
            ename like #{ename} and
        </if>
        <if test="sal!=null">
            sal > #{sal}
        </if>
    </select>
```

EmpDao.java

```java
public List<Emp> getEmpByCondition(Emp emp);
```

Test.java

```java
@Test
public void test10() {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    try {
        EmpDao mapper = sqlSession.getMapper(EmpDao.class);
        Emp emp = new Emp();
        emp.setEmpno(6500);
        emp.setEname("%E%");
        emp.setSal(500.0);
        List<Emp> empByCondition = mapper.getEmpByCondition(emp);
        for (Emp emp1 : empByCondition) {
            System.out.println(emp1);
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        sqlSession.close();
    }
}
```

​		看起来测试是比较正常的，但是大家需要注意的是如果我们传入的参数值有缺失会怎么呢？这个时候拼接的sql语句就会变得有问题，例如不传参数或者丢失最后一个参数，那么语句中就会多一个where或者and的关键字，因此在mybatis中也给出了具体的解决方案：

​		*where* 元素只会在子元素返回任何内容的情况下才插入 “WHERE” 子句。而且，若子句的开头为 “AND” 或 “OR”，*where* 元素也会将它们去除。

```xml
<select id="getEmpByCondition" resultType="com.mashibing.bean.Emp">
    select * from emp
    <where>
        <if test="empno!=null">
            empno > #{empno}
        </if>
        <if test="ename!=null">
            and ename like #{ename}
        </if>
        <if test="sal!=null">
            and sal > #{sal}
        </if>
    </where>
</select>
```

现在看起来没有什么问题了，但是我们的条件添加到了拼接sql语句的前后，那么我们该如何处理呢？

```xml
<!--
    trim截取字符串：
    prefix：前缀，为sql整体添加一个前缀
    prefixOverrides:去除整体字符串前面多余的字符
    suffixOverrides:去除后面多余的字符串
    -->
<select id="getEmpByCondition" resultType="com.mashibing.bean.Emp">
    select * from emp

    <trim prefix="where" prefixOverrides="and" suffixOverrides="and">
        <if test="empno!=null">
            empno > #{empno} and
        </if>
        <if test="ename!=null">
            ename like #{ename} and
        </if>
        <if test="sal!=null">
            sal > #{sal} and
        </if>
    </trim>
</select>
```

### foreach

​		动态 SQL 的另一个常见使用场景是对集合进行遍历（尤其是在构建 IN 条件语句的时候）。

```xml
<!--foreach是对集合进行遍历
    collection="deptnos"  指定要遍历的集合
    close="" 表示以什么结束
    index="" 给定一个索引值
    item=""  遍历的每一个元素的值
    open=""  表示以什么开始
    separator="" 表示多个元素的分隔符
    -->
<select id="getEmpByDeptnos" resultType="Emp">
    select * from emp where deptno in 
    <foreach collection="deptnos" close=")" index="idx" item="deptno" open="(" separator=",">
        #{deptno}
    </foreach>
</select>
```

### choose

​		有时候，我们不想使用所有的条件，而只是想从多个条件中选择一个使用。针对这种情况，MyBatis 提供了 choose 元素，它有点像 Java 中的 switch 语句。

```xml
<select id="getEmpByConditionChoose" resultType="com.mashibing.bean.Emp">
    select * from emp
    <where>
        <choose>
            <when test="empno!=null">
                empno > #{empno}
            </when>
            <when test="ename!=null">
                ename like #{ename}
            </when>
            <when test="sal!=null">
                sal > #{sal}
            </when>
            <otherwise>
                1=1
            </otherwise>
        </choose>
    </where>
</select>
```

### set

​		用于动态更新语句的类似解决方案叫做 *set*。*set* 元素可以用于动态包含需要更新的列，忽略其它不更新的列。

```xml
<update id="updateEmpByEmpno">
    update emp
    <set>
        <if test="empno!=null">
            empno=#{empno},
        </if>
        <if test="ename!=null">
            ename = #{ename},
        </if>
        <if test="sal!=null">
            sal = #{sal}
        </if>
    </set>
    <where>
        empno = #{empno}
    </where>
</update>
```

## 缓存

​		MyBatis 内置了一个强大的事务性查询缓存机制，它可以非常方便地配置和定制。 为了使它更加强大而且易于配置，我们对 MyBatis 3 中的缓存实现进行了许多改进。

​		默认情况下，只启用了本地的会话缓存，它仅仅对一个会话中的数据进行缓存。 要启用全局的二级缓存，只需要在你的 SQL 映射文件中添加一行：

```
<cache/>
```

当添加上该标签之后，会有如下效果：

- 映射语句文件中的所有 select 语句的结果将会被缓存。
- 映射语句文件中的所有 insert、update 和 delete 语句会刷新缓存。
- 缓存会使用最近最少使用算法（LRU, Least Recently Used）算法来清除不需要的缓存。
- 缓存不会定时进行刷新（也就是说，没有刷新间隔）。
- 缓存会保存列表或对象（无论查询方法返回哪种）的 1024 个引用。
- 缓存会被视为读/写缓存，这意味着获取到的对象并不是共享的，可以安全地被调用者修改，而不干扰其他调用者或线程所做的潜在修改。

在进行配置的时候还会分为一级缓存和二级缓存：

1. 一级缓存：线程级别的缓存，是本地缓存，sqlSession级别的缓存
2. 二级缓存：全局范围的缓存，不止局限于当前会话

### 一级缓存的使用

​		一级缓存是sqlsession级别的缓存，默认是存在的。在下面的案例中，大家发现我发送了两个相同的请求，但是sql语句仅仅执行了一次，那么就意味着第一次查询的时候已经将结果进行了缓存。

```java
@Test
public void test01() {

    SqlSession sqlSession = sqlSessionFactory.openSession();
    try {
        EmpDao mapper = sqlSession.getMapper(EmpDao.class);
        List<Emp> list = mapper.selectAllEmp();
        for (Emp emp : list) {
            System.out.println(emp);
        }
        System.out.println("--------------------------------");
        List<Emp> list2 = mapper.selectAllEmp();
        for (Emp emp : list2) {
            System.out.println(emp);
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        sqlSession.close();
    }
}
```

在大部分的情况下一级缓存是可以的，但是有几种特殊的情况会造成一级缓存失效：

1. 一级缓存是sqlSession级别的缓存，如果在应用程序中只有开启了多个sqlsession，那么会造成缓存失效

   ```java
   @Test
   public void test02(){
       SqlSession sqlSession = sqlSessionFactory.openSession();
       EmpDao mapper = sqlSession.getMapper(EmpDao.class);
       List<Emp> list = mapper.selectAllEmp();
       for (Emp emp : list) {
           System.out.println(emp);
       }
       System.out.println("================================");
       SqlSession sqlSession2 = sqlSessionFactory.openSession();
       EmpDao mapper2 = sqlSession2.getMapper(EmpDao.class);
       List<Emp> list2 = mapper2.selectAllEmp();
       for (Emp emp : list2) {
           System.out.println(emp);
       }
       sqlSession.close();
       sqlSession2.close();
   }
   ```

2. 在编写查询的sql语句的时候，一定要注意传递的参数，如果参数不一致，那么也不会缓存结果

3. 如果在发送过程中发生了数据的修改，那么结果就不会缓存

   ```java
   @Test
   public void test03(){
       SqlSession sqlSession = sqlSessionFactory.openSession();
       EmpDao mapper = sqlSession.getMapper(EmpDao.class);
       Emp empByEmpno = mapper.findEmpByEmpno(1111);
       System.out.println(empByEmpno);
       System.out.println("================================");
       empByEmpno.setEname("zhangsan");
       int i = mapper.updateEmp(empByEmpno);
       System.out.println(i);
       System.out.println("================================");
       Emp empByEmpno1 = mapper.findEmpByEmpno(1111);
       System.out.println(empByEmpno1);
       sqlSession.close();
   }
   ```

4. 在两次查询期间，手动去清空缓存，也会让缓存失效

   ```java
   @Test
   public void test03(){
       SqlSession sqlSession = sqlSessionFactory.openSession();
       EmpDao mapper = sqlSession.getMapper(EmpDao.class);
       Emp empByEmpno = mapper.findEmpByEmpno(1111);
       System.out.println(empByEmpno);
       System.out.println("================================");
       System.out.println("手动清空缓存");
       sqlSession.clearCache();
       System.out.println("================================");
       Emp empByEmpno1 = mapper.findEmpByEmpno(1111);
       System.out.println(empByEmpno1);
       sqlSession.close();
   }
   ```

### 二级缓存

​		二级缓存是全局作用域缓存，默认是不开启的，需要手动进行配置。

​		Mybatis提供二级缓存的接口以及实现，缓存实现的时候要求实体类实现Serializable接口，二级缓存在sqlSession关闭或提交之后才会生效。

#### 缓存的使用

​		步骤：

  1. 全局配置文件中添加如下配置：

     ```xml
     <setting name="cacheEnabled" value="true"/>
     ```

  2. 需要在使用二级缓存的映射文件出使用<cache/>标签标注

  3. 实体类必须要实现Serializable接口

     ```java
     @Test
     public void test04(){
         SqlSession sqlSession = sqlSessionFactory.openSession();
         SqlSession sqlSession2 = sqlSessionFactory.openSession();
         EmpDao mapper = sqlSession.getMapper(EmpDao.class);
         EmpDao mapper2 = sqlSession2.getMapper(EmpDao.class);
         Emp empByEmpno = mapper.findEmpByEmpno(1111);
         System.out.println(empByEmpno);
         sqlSession.close();
     
         Emp empByEmpno1 = mapper2.findEmpByEmpno(1111);
         System.out.println(empByEmpno1);
         sqlSession2.close();
     }
     ```

#### 缓存的属性

1. eviction:表示缓存回收策略，默认是LRU
   - LRU：最近最少使用的，移除最长时间不被使用的对象
   - FIFO：先进先出，按照对象进入缓存的顺序来移除
   - SOFT：软引用，移除基于垃圾回收器状态和软引用规则的对象
   - WEAK：弱引用，更积极地移除基于垃圾收集器状态和弱引用规则的对象
2. flushInternal:刷新间隔，单位毫秒
   - 默认情况是不设置，也就是没有刷新间隔，缓存仅仅调用语句时刷新
3. size：引用数目，正整数
   - 代表缓存最多可以存储多少个对象，太大容易导致内存溢出
4. readonly：只读，true/false
   - true：只读缓存，会给所有调用这返回缓存对象的相同实例，因此这些对象不能被修改。
   - false：读写缓存，会返回缓存对象的拷贝（序列化实现），这种方式比较安全，默认值

```java
//可以看到会去二级缓存中查找数据，而且二级缓存跟一级缓存中不会同时存在数据，因为二级缓存中的数据是在sqlsession 关闭之后才生效的
@Test
public void test05(){
    SqlSession sqlSession = sqlSessionFactory.openSession();
    EmpDao mapper = sqlSession.getMapper(EmpDao.class);
    Emp empByEmpno = mapper.findEmpByEmpno(1111);
    System.out.println(empByEmpno);
    sqlSession.close();

    SqlSession sqlSession2 = sqlSessionFactory.openSession();
    EmpDao mapper2 = sqlSession2.getMapper(EmpDao.class);
    Emp empByEmpno2 = mapper2.findEmpByEmpno(1111);
    System.out.println(empByEmpno2);
    Emp empByEmpno3 = mapper2.findEmpByEmpno(1111);
    System.out.println(empByEmpno3);
    sqlSession2.close();
}

// 缓存查询的顺序是先查询二级缓存再查询一级缓存
@Test
public void test05(){
    SqlSession sqlSession = sqlSessionFactory.openSession();
    EmpDao mapper = sqlSession.getMapper(EmpDao.class);
    Emp empByEmpno = mapper.findEmpByEmpno(1111);
    System.out.println(empByEmpno);
    sqlSession.close();

    SqlSession sqlSession2 = sqlSessionFactory.openSession();
    EmpDao mapper2 = sqlSession2.getMapper(EmpDao.class);
    Emp empByEmpno2 = mapper2.findEmpByEmpno(1111);
    System.out.println(empByEmpno2);
    Emp empByEmpno3 = mapper2.findEmpByEmpno(1111);
    System.out.println(empByEmpno3);

    Emp empByEmpno4 = mapper2.findEmpByEmpno(7369);
    System.out.println(empByEmpno4);
    Emp empByEmpno5 = mapper2.findEmpByEmpno(7369);
    System.out.println(empByEmpno5);
    sqlSession2.close();
}
```

#### 二级缓存的作用范围

​		如果设置了全局的二级缓存配置，那么在使用的时候需要注意，在每一个单独的select语句中，可以设置将查询缓存关闭，以完成特殊的设置

1. 在setting中设置，是配置二级缓存开启，一级缓存默认一直开启

   ```xml
   <setting name="cacheEnabled" value="true"/>
   ```

2. select标签的useCache属性：

   - 在每一个select的查询中可以设置当前查询是否要使用二级缓存，只对二级缓存有效

3. sql标签的flushCache属性

   - 增删改操作默认值为true，sql执行之后会清空一级缓存和二级缓存，而查询操作默认是false

4. sqlSession.clearCache()

   - 只是用来清楚一级缓存 

### 整合第三方缓存

​		在某些情况下我们也可以自定义实现缓存，或为其他第三方缓存方案创建适配器，来完全覆盖缓存行为。

1. 导入对应的maven依赖

   ```xml
   <!-- https://mvnrepository.com/artifact/org.ehcache/ehcache -->
   <dependency>
       <groupId>org.ehcache</groupId>
       <artifactId>ehcache</artifactId>
       <version>3.8.1</version>
   </dependency>
   <!-- https://mvnrepository.com/artifact/org.mybatis.caches/mybatis-ehcache -->
   <dependency>
       <groupId>org.mybatis.caches</groupId>
       <artifactId>mybatis-ehcache</artifactId>
       <version>1.2.0</version>
   </dependency>
   <!-- https://mvnrepository.com/artifact/org.slf4j/slf4j-api -->
   <dependency>
       <groupId>org.slf4j</groupId>
       <artifactId>slf4j-api</artifactId>
       <version>2.0.0-alpha1</version>
   </dependency>
   <!-- https://mvnrepository.com/artifact/org.slf4j/slf4j-log4j12 -->
   <dependency>
       <groupId>org.slf4j</groupId>
       <artifactId>slf4j-log4j12</artifactId>
       <version>2.0.0-alpha1</version>
       <scope>test</scope>
   </dependency>
   ```

2. 导入ehcache配置文件

   ```xml
   <?xml version="1.0" encoding="UTF-8"?>
   <ehcache xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:noNamespaceSchemaLocation="http://ehcache.org/ehcache.xsd">
    <!-- 磁盘保存路径 -->
    <diskStore path="D:\ehcache" />
    
    <defaultCache 
      maxElementsInMemory="1" 
      maxElementsOnDisk="10000000"
      eternal="false" 
      overflowToDisk="true" 
      timeToIdleSeconds="120"
      timeToLiveSeconds="120" 
      diskExpiryThreadIntervalSeconds="120"
      memoryStoreEvictionPolicy="LRU">
    </defaultCache>
   </ehcache>
    
   <!-- 
   属性说明：
   l diskStore：指定数据在磁盘中的存储位置。
   l defaultCache：当借助CacheManager.add("demoCache")创建Cache时，EhCache便会采用<defalutCache/>指定的的管理策略
    
   以下属性是必须的：
   l maxElementsInMemory - 在内存中缓存的element的最大数目 
   l maxElementsOnDisk - 在磁盘上缓存的element的最大数目，若是0表示无穷大
   l eternal - 设定缓存的elements是否永远不过期。如果为true，则缓存的数据始终有效，如果为false那么还要根据timeToIdleSeconds，timeToLiveSeconds判断
   l overflowToDisk - 设定当内存缓存溢出的时候是否将过期的element缓存到磁盘上
    
   以下属性是可选的：
   l timeToIdleSeconds - 当缓存在EhCache中的数据前后两次访问的时间超过timeToIdleSeconds的属性取值时，这些数据便会删除，默认值是0,也就是可闲置时间无穷大
   l timeToLiveSeconds - 缓存element的有效生命期，默认是0.,也就是element存活时间无穷大
    diskSpoolBufferSizeMB 这个参数设置DiskStore(磁盘缓存)的缓存区大小.默认是30MB.每个Cache都应该有自己的一个缓冲区.
   l diskPersistent - 在VM重启的时候是否启用磁盘保存EhCache中的数据，默认是false。
   l diskExpiryThreadIntervalSeconds - 磁盘缓存的清理线程运行间隔，默认是120秒。每个120s，相应的线程会进行一次EhCache中数据的清理工作
   l memoryStoreEvictionPolicy - 当内存缓存达到最大，有新的element加入的时候， 移除缓存中element的策略。默认是LRU（最近最少使用），可选的有LFU（最不常使用）和FIFO（先进先出）
    -->
   ```

3. 在mapper文件中添加自定义缓存

   ```xml
       <cache type="org.mybatis.caches.ehcache.EhcacheCache"></cache>
   ```

# mybatis框架整合及逆向工厂

## 三大框架整合

​		在老期的项目中，一般都是使用ssm项目做开发的，虽然现在的主流开发是springboot来做开发，但是ssm的基本整合还是需要掌握的。

### 导入pom文件

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.mashibing</groupId>
    <artifactId>ssm</artifactId>
    <version>1.0-SNAPSHOT</version>

    <dependencies>
        <!-- https://mvnrepository.com/artifact/junit/junit -->
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.12</version>
            <scope>test</scope>
        </dependency>
        <!-- https://mvnrepository.com/artifact/org.springframework/spring-context -->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-context</artifactId>
            <version>5.2.3.RELEASE</version>
        </dependency>
        <!-- https://mvnrepository.com/artifact/cglib/cglib -->
        <dependency>
            <groupId>cglib</groupId>
            <artifactId>cglib</artifactId>
            <version>3.3.0</version>
        </dependency>
        <!-- https://mvnrepository.com/artifact/org.aspectj/aspectjweaver -->
        <dependency>
            <groupId>org.aspectj</groupId>
            <artifactId>aspectjweaver</artifactId>
            <version>1.9.5</version>
        </dependency>
        <!-- https://mvnrepository.com/artifact/aopalliance/aopalliance -->
        <dependency>
            <groupId>aopalliance</groupId>
            <artifactId>aopalliance</artifactId>
            <version>1.0</version>
        </dependency>
        <!-- https://mvnrepository.com/artifact/org.springframework/spring-aspects -->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-aspects</artifactId>
            <version>5.2.3.RELEASE</version>
        </dependency>
        <!-- https://mvnrepository.com/artifact/com.alibaba/druid -->
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>druid</artifactId>
            <version>1.1.21</version>
        </dependency>
        <!-- https://mvnrepository.com/artifact/mysql/mysql-connector-java -->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>5.1.48</version>
        </dependency>
        <!-- https://mvnrepository.com/artifact/org.springframework/spring-web -->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-web</artifactId>
            <version>5.2.3.RELEASE</version>
        </dependency>
        <!-- https://mvnrepository.com/artifact/org.springframework/spring-webmvc -->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-webmvc</artifactId>
            <version>5.2.3.RELEASE</version>
        </dependency>
        <dependency>
            <groupId>javax.servlet</groupId>
            <artifactId>servlet-api</artifactId>
            <version>2.5</version>
            <scope>provided</scope>
        </dependency>

        <dependency>
            <groupId>javax.servlet</groupId>
            <artifactId>jsp-api</artifactId>
            <version>2.0</version>
            <scope>provided</scope>
        </dependency>
        <!-- https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-core -->
        <dependency>
            <groupId>com.fasterxml.jackson.core</groupId>
            <artifactId>jackson-core</artifactId>
            <version>2.10.3</version>
        </dependency>
        <!-- https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind -->
        <dependency>
            <groupId>com.fasterxml.jackson.core</groupId>
            <artifactId>jackson-databind</artifactId>
            <version>2.10.3</version>
        </dependency>
        <!-- https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-annotations -->
        <dependency>
            <groupId>com.fasterxml.jackson.core</groupId>
            <artifactId>jackson-annotations</artifactId>
            <version>2.10.3</version>
        </dependency>
        <!-- https://mvnrepository.com/artifact/commons-io/commons-io -->
        <dependency>
            <groupId>commons-io</groupId>
            <artifactId>commons-io</artifactId>
            <version>2.6</version>
        </dependency>
        <!-- https://mvnrepository.com/artifact/commons-fileupload/commons-fileupload -->
        <dependency>
            <groupId>commons-fileupload</groupId>
            <artifactId>commons-fileupload</artifactId>
            <version>1.4</version>
        </dependency>
        <!-- https://mvnrepository.com/artifact/javax.servlet/jstl -->
        <dependency>
            <groupId>javax.servlet</groupId>
            <artifactId>jstl</artifactId>
            <version>1.2</version>
        </dependency>
        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis</artifactId>
            <version>3.5.4</version>
        </dependency>
        <!-- https://mvnrepository.com/artifact/mysql/mysql-connector-java -->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>8.0.16</version>
        </dependency>
        <!-- https://mvnrepository.com/artifact/log4j/log4j -->
        <dependency>
            <groupId>log4j</groupId>
            <artifactId>log4j</artifactId>
            <version>1.2.17</version>
        </dependency>
        <!-- https://mvnrepository.com/artifact/org.mybatis/mybatis-spring -->
        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis-spring</artifactId>
            <version>2.0.4</version>
        </dependency>

    </dependencies>
</project>
```

### 编写各个框架的配置文件

web.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd"
         version="4.0">
    <listener>
        <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
    </listener>
    <context-param>
        <param-name>contextConfigLocation</param-name>
        <param-value>classpath:spring.xml</param-value>
    </context-param>
    <!--springmvc的核心配置类-->
    <servlet>
        <servlet-name>springmvc</servlet-name>
        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
        <init-param>
            <param-name>contextConfigLocation</param-name>
            <param-value>classpath:springmvc.xml</param-value>
        </init-param>
        <load-on-startup>1</load-on-startup>
    </servlet>
    <servlet-mapping>
        <servlet-name>springmvc</servlet-name>
        <url-pattern>/</url-pattern>
    </servlet-mapping>
    <!--字符编码过滤器-->
    <filter>
        <filter-name>CharacterEncodingFilter</filter-name>
        <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
        <init-param>
            <param-name>encoding</param-name>
            <param-value>utf-8</param-value>
        </init-param>
        <init-param>
            <param-name>forceEncoding</param-name>
            <param-value>true</param-value>
        </init-param>
    </filter>
    <filter-mapping>
        <filter-name>CharacterEncodingFilter</filter-name>
        <url-pattern>/*</url-pattern>
    </filter-mapping>
    <!--支持rest风格的过滤器-->
    <filter>
        <filter-name>HiddenHttpMethodFilter</filter-name>
        <filter-class>org.springframework.web.filter.HiddenHttpMethodFilter</filter-class>
    </filter>
    <filter-mapping>
        <filter-name>HiddenHttpMethodFilter</filter-name>
        <url-pattern>/*</url-pattern>
    </filter-mapping>
</web-app>
```

springmvc.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:mvc="http://www.springframework.org/schema/mvc"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd http://www.springframework.org/schema/context https://www.springframework.org/schema/context/spring-context.xsd http://www.springframework.org/schema/mvc https://www.springframework.org/schema/mvc/spring-mvc.xsd">

    <!--springmvc只扫描控制器-->
    <context:component-scan base-package="com.mashibing" use-default-filters="false">
        <context:include-filter type="annotation" expression="org.springframework.stereotype.Controller"/>
    </context:component-scan>
    <!--静态资源的扫描-->
    <mvc:default-servlet-handler></mvc:default-servlet-handler>
    <!--动态资源的扫描-->
    <mvc:annotation-driven></mvc:annotation-driven>
    <!--配置视图管理器-->
    <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
        <property name="prefix" value="/WEB-INF/page/"></property>
        <property name="suffix" value=".jsp"></property>
    </bean>
</beans>
```

spring.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:tx="http://www.springframework.org/schema/tx"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans.xsd
       http://www.springframework.org/schema/context
       https://www.springframework.org/schema/context/spring-context.xsd
       http://www.springframework.org/schema/tx
       https://www.springframework.org/schema/tx/spring-tx.xsd
">

    <!--Spring除了控制器不扫描，其他的组件都扫描，包括service，component等-->
    <context:component-scan base-package="com.mashibing">
        <context:exclude-filter type="annotation" expression="org.springframework.stereotype.Controller"/>
    </context:component-scan>

    <!--引入外部配置文件-->
    <context:property-placeholder location="classpath:db.properties"></context:property-placeholder>
    <!--配置数据源-->
    <bean id="dataSource" class="com.alibaba.druid.pool.DruidDataSource">
        <property name="username" value="${jdbc.username}"></property>
        <property name="password" value="${jdbc.password}"></property>
        <property name="driverClassName" value="${jdbc.driverName}"></property>
        <property name="url" value="${jdbc.url}"></property>
    </bean>

    <!--配置事务管理器的bean对象-->
    <bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
        <property name="dataSource" ref="dataSource"></property>
    </bean>
    <!--开启基于注解的事务管理器的配置-->
    <tx:annotation-driven transaction-manager="transactionManager"></tx:annotation-driven>

    <!--添加mybatis的配置-->
    <bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
        <!--指定配置文件的位置-->
        <property name="configLocation" value="classpath:mybatis-config.xml"></property>
        <property name="dataSource" ref="dataSource"></property>
        <property name="mapperLocations" value="classpath:com/mashibing/dao/*.xml"></property>
    </bean>
    <!--创建mybatis扫描器，批量配置映射文件-->
    <bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
        <property name="basePackage" value="com.mashibing.dao"></property>
        <property name="sqlSessionFactoryBeanName" value="sqlSessionFactory"></property>
    </bean>
</beans>
```

mybatis-config.xml

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
    <settings>
        <setting name="mapUnderscoreToCamelCase" value="true"/>
    </settings>
    <typeAliases>
        <package name="com.mashibing.bean"/>
    </typeAliases>
</configuration>
```

db.properties

```properties
jdbc.username=root
jdbc.password=123456
jdbc.url=jdbc:mysql://192.168.85.111:3306/demo?serverTimezone=UTC
jdbc.driverName=com.mysql.jdbc.Driver
```

拷贝映射文件，还是位于com.mashibing.dao目录

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<!--namespace:编写接口的全类名，就是告诉要实现该配置文件是哪个接口的具体实现-->
<mapper namespace="com.mashibing.dao.EmpDao">
    <!--    <cache></cache>-->
    <!--    <cache type="org.mybatis.caches.ehcache.EhcacheCache"></cache>-->
    <!--
    select:表示这个操作是一个查询操作
    id表示的是要匹配的方法的名称
    resultType:表示返回值的类型，查询操作必须要包含返回值的类型
    #{属性名}：表示要传递的参数的名称
    -->
    <select id="findEmpByEmpno" resultType="emp">
        select * from emp where empno = #{empno}
    </select>
    <!--增删改查操作不需要返回值，增删改返回的是影响的行数，mybatis会自动做判断-->
    <insert id="insertEmp">
        insert into emp(empno,ename) values(#{empno},#{ename})
    </insert>
    <update id="updateEmp">
        update emp set ename=#{ename} where empno = #{empno}
    </update>

    <delete id="deleteEmp">
        delete from emp where empno = #{empno}
    </delete>

    <!--
    当查询语句中包含多个参数的是，如果使用#{属性名称}就无法获取具体的值了，那么应该如何使用呢？
        下面就是mybatis的参数传递方式
        1、如果是单个参数，
            基本类型：使用#{随便写}
            引用类型：使用#{类的属性名称}
        2、多个参数：
            当查询的时候传入多个参数的时候，就无法简单的通过#{参数名}来获取值了，
            只能通过arg0,arg1...或者param1,param2等方式来获取值
            原因就在于，mybatis在传入多个参数的时候，会将这些参数封装到一个map中，此时map中的key就是
            arg0,arg1,param1,param2这些值，但是很明显，这样的传值方式不是很友好，没有办法根据参数的名称来
            获取具体的值，因此可以使用如下的方式来指定参数的key是什么
            Emp selectEmpByNoAndName(@Param("empno") Integer empno, @Param("ename") String ename);
                也就是通过@Param来指定存入map中的key值是什么
        3、使用map来传递参数：
                依然是直接使用#{key}来获取具体的属性值
    -->

    <!--
        当使用#{}来获取值的时候会发现打印的sql语句如下：
            select * from emp where empno=? and ename=?
        当使用${}来获取值的时候会发现打印的sql语句如下：
            select * from emp where empno=7369 and ename='SMITH'
        通过刚刚的案例大家已经发现了存在的问题了，
        使用#{}方式进行取值：采用的是参数预编译的方式，参数的位置使用？进行替代，不会出现sql注入的问题
        使用${}方式进行取值：采用的是直接跟sql语句进行拼接的方式
    -->
    <select id="selectEmpByNoAndName" resultType="com.mashibing.bean.Emp">
        select * from ${t} where empno=${empno} and ename=${ename}
    </select>

    <select id="selectEmpByNoAndName2" resultType="com.mashibing.bean.Emp">
        select * from emp where empno=#{empno} and ename=#{ename}
    </select>

    <!--当返回值的结果是集合的时候，返回值的类型依然写的是集合中具体的类型-->
    <select id="selectAllEmp" resultType="com.mashibing.bean.Emp">
        select  * from emp
    </select>

    <!--在查询的时候可以设置返回值的类型为map，当mybatis查询完成之后会把列的名称作为key
    列的值作为value，转换到map中
    -->
    <select id="selectEmpByEmpReturnMap" resultType="map">
        select * from emp where empno = #{empno}
    </select>

    <!--注意，当返回的结果是一个集合对象的是，返回值的类型一定要写集合具体value的类型
    同时在dao的方法上要添加@MapKey的注解，来设置key是什么结果
    @MapKey("empno")
    Map<Integer,Emp> getAllEmpReturnMap();-->
    <select id="getAllEmpReturnMap" resultType="com.mashibing.bean.Emp">
        select * from emp
    </select>

    <!--再做查询的时候，有时候需要关联其他对象，因此需要使用关联查询
    可以通过下面自定义结果集的方式实现
    -->
    <select id="selectEmpAndDept" resultMap="empDept">
        select * from emp left join dept on emp.deptno = dept.deptno where empno = #{empno};
    </select>
    <!--<resultMap id="empDept" type="com.mashibing.bean.Emp">
        <id column="empno" property="empno"></id>
        <result column="ename" property="ename"></result>
        <result column="job" property="job"></result>
        <result column="mgr" property="mgr"></result>
        <result column="hiredate" property="hiredate"></result>
        <result column="sal" property="sal"></result>
        <result column="comm" property="common"></result>
        <result column="deptno" property="dept.deptno"></result>
        <result column="dname" property="dept.dname"></result>
        <result column="loc" property="dept.loc"></result>
    </resultMap>-->

    <!--在mybatis中还提供了一种简单的形式，使用association标签可以搞定
    -->
    <resultMap id="empDept" type="com.mashibing.bean.Emp">
        <id column="empno" property="empno"></id>
        <result column="ename" property="ename"></result>
        <result column="job" property="job"></result>
        <result column="mgr" property="mgr"></result>
        <result column="hiredate" property="hiredate"></result>
        <result column="sal" property="sal"></result>
        <result column="comm" property="common"></result>
        <association property="dept" javaType="com.mashibing.bean.Dept">
            <id column="deptno" property="deptno"></id>
            <result column="dname" property="dname"></result>
            <result column="loc" property="loc"></result>
        </association>
    </resultMap>

    <select id="selectEmpAndDeptBySimple" resultMap="simpleEmpAndDept">
        select * from emp where empno = #{empno}
    </select>
    <resultMap id="simpleEmpAndDept" type="com.mashibing.bean.Emp">
        <id column="empno" property="empno"></id>
        <result column="ename" property="ename"></result>
        <result column="job" property="job"></result>
        <result column="mgr" property="mgr"></result>
        <result column="hiredate" property="hiredate"></result>
        <result column="sal" property="sal"></result>
        <result column="comm" property="common"></result>
        <association property="dept" select="com.mashibing.dao.DeptDao.getDeptAndEmpsBySimple" column="deptno" fetchType="eager">
        </association>
    </resultMap>

    <select id="selectEmpByStep" resultType="com.mashibing.bean.Emp">
        select * from emp where deptno = #{deptno}
    </select>

    <!-- <select id="getEmpByCondition" resultType="com.mashibing.bean.Emp">
        select * from emp
        <where>
            <if test="empno!=null">
                empno > #{empno}
            </if>
            <if test="ename!=null">
                and ename like #{ename}
            </if>
            <if test="sal!=null">
                and sal > #{sal}
            </if>
        </where>-->
    <!--
    trim截取字符串：
    prefix：前缀，为sql整体添加一个前缀
    prefixOverrides:去除整体字符串前面多余的字符
    suffixOverrides:去除后面多余的字符串
    -->
    <select id="getEmpByCondition" resultType="com.mashibing.bean.Emp">
        select * from emp

        <trim prefix="where" prefixOverrides="and" suffixOverrides="and">
            <if test="empno!=null">
                empno > #{empno} and
            </if>
            <if test="ename!=null">
                ename like #{ename} and
            </if>
            <if test="sal!=null">
                sal > #{sal} and
            </if>
        </trim>
    </select>

    <!--foreach是对集合进行遍历
    collection="deptnos"  指定要遍历的集合
    close="" 表示以什么结束
    index="" 给定一个索引值
    item=""  遍历的每一个元素的值
    open=""  表示以什么开始
    separator="" 表示多个元素的分隔符
    -->
    <select id="getEmpByDeptnos" resultType="Emp">
        select * from emp where deptno in 
        <foreach collection="deptnos" close=")" index="idx" item="deptno" open="(" separator=",">
            #{deptno}
        </foreach>
    </select>

    <select id="getEmpByConditionChoose" resultType="com.mashibing.bean.Emp">
        select * from emp
        <where>
            <choose>
                <when test="empno!=null">
                    empno > #{empno}
                </when>
                <when test="ename!=null">
                    ename like #{ename}
                </when>
                <when test="sal!=null">
                    sal > #{sal}
                </when>
                <otherwise>
                    1=1
                </otherwise>
            </choose>
        </where>
    </select>
    <update id="updateEmpByEmpno">
        update emp
        <set>
            <if test="empno!=null">
                empno=#{empno},
            </if>
            <if test="ename!=null">
                ename = #{ename},
            </if>
            <if test="sal!=null">@
                sal = #{sal}
            </if>
        </set>
        <where>
            empno = #{empno}
        </where>
    </update>

</mapper>
```

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.mashibing.dao.DeptDao">
    <!--定义查询集合元素-->
    <select id="getDeptAndEmps" resultMap="deptEmp">
        select * from dept left join emp on dept.deptno = emp.deptno where dept.deptno=#{deptno}
    </select>
    <resultMap id="deptEmp" type="com.mashibing.bean.Dept">
        <id property="deptno" column="deptno"></id>
        <result property="dname" column="dname"></result>
        <result property="loc" column="loc"></result>
        <!--封装集合类的元素
            property：指定集合的属性
            ofType:指定集合中的元素类型
        -->
        <collection property="emps" ofType="com.mashibing.bean.Emp">
            <id property="empno" column="empno"></id>
            <result column="ename" property="ename"></result>
            <result column="job" property="job"></result>
            <result column="mgr" property="mgr"></result>
            <result column="hiredate" property="hiredate"></result>
            <result column="sal" property="sal"></result>
            <result column="comm" property="common"></result>
        </collection>
    </resultMap>

    <select id="getDeptAndEmpsBySimple" resultType="com.mashibing.bean.Dept">
        select * from dept where deptno = #{deptno}
    </select>

    <select id="getDeptAndEmpsByStep" resultMap="deptEmpByStep">
        select * from dept where deptno = #{deptno}
    </select>
    <resultMap id="deptEmpByStep" type="com.mashibing.bean.Dept">
        <id property="deptno" column="deptno"></id>
        <result property="dname" column="dname"></result>
        <result property="loc" column="loc"></result>
        <!--封装集合类的元素
            property：指定集合的属性
            ofType:指定集合中的元素类型
        -->
        <collection property="emps" ofType="com.mashibing.bean.Emp" select="com.mashibing.dao.EmpDao.selectEmpByStep" column="deptno" >
        </collection>
    </resultMap>
</mapper>
```

添加dao的接口

EmpDao.java

```java
package com.mashibing.dao;

import com.mashibing.bean.Emp;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface EmpDao {

    public Emp findEmpByEmpno(Integer empno);

    public int updateEmp(Emp emp);

    public int deleteEmp(Integer empno);

    public int insertEmp(Emp emp);

    Emp selectEmpByNoAndName(@Param("empno") Integer empno, @Param("ename") String ename, @Param("t") String tablename);
    Emp selectEmpByNoAndName2(Map<String, Object> map);

    List<Emp> selectAllEmp();

    Map<String,Object> selectEmpByEmpReturnMap(Integer empno);

    @MapKey("empno")
    Map<Integer,Emp> getAllEmpReturnMap();

    Emp selectEmpAndDept(Integer empno);
    Emp selectEmpAndDeptBySimple(Integer empno);
    List<Emp> selectEmpByStep(Integer deptno);

    public List<Emp> getEmpByCondition(Emp emp);
    public List<Emp> getEmpByConditionChoose(Emp emp);
    public List<Emp> getEmpByDeptnos(@Param("deptnos") List<Integer> deptnos);

    public int updateEmpByEmpno(Emp emp);

}

```

### 创建测试类

TestController.java

```java
package com.mashibing.controller;

import com.mashibing.bean.Emp;
import com.mashibing.dao.EmpDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

    @Autowired
    EmpDao empDao;

    @RequestMapping("/test")
    public String test(){
        System.out.println("test");
        Emp empByEmpno = empDao.findEmpByEmpno(7369);
        System.out.println(empByEmpno);
        return "success";
    }
}
```

## mybatis逆向工程

```xml
<!-- https://mvnrepository.com/artifact/org.mybatis.generator/mybatis-generator-core -->
<dependency>
    <groupId>org.mybatis.generator</groupId>
    <artifactId>mybatis-generator-core</artifactId>
    <version>1.4.0</version>
</dependency>
```

编写配置文件：mbg.xml

```xml
<!DOCTYPE generatorConfiguration PUBLIC
        "-//mybatis.org//DTD MyBatis Generator Configuration 1.0//EN"
        "http://mybatis.org/dtd/mybatis-generator-config_1_0.dtd">
<generatorConfiguration>
    <context id="simple" targetRuntime="MyBatis3">
        <!--指向数据库连接-->
        <jdbcConnection driverClass="com.mysql.cj.jdbc.Driver"
                        connectionURL="jdbc:mysql://192.168.85.111:3306/demo?serverTimezone=UTC"
                        userId="root"
                        password="123456"
                        />

        <!--生成对应的实体类
        targetPackage：指定生成java文件的目录
        targetProject：放在那个工程的哪个目录下
        -->
        <javaModelGenerator targetPackage="com.mashibing.bean" targetProject="src/main/java"/>

        <!--SQL映射文件生成器
        targetPackage：指定生成java文件的目录
        targetProject：放在那个工程的哪个目录下
        -->
        <sqlMapGenerator targetPackage="com.mashibing.dao" targetProject="src/main/resources"/>

        <!--dao接口生成器-->
        <javaClientGenerator type="XMLMAPPER" targetPackage="com.mashibing.dao" targetProject="src/main/java"/>

        <!--指定要逆向生成的数据表
        tableName:表名
        domainObjectName:对象名
        -->
        <table tableName="emp" domainObjectName="Emp" enableCountByExample="false" enableDeleteByExample="false" enableUpdateByExample="false" selectByExampleQueryId="false" enableSelectByExample="false"/>
        <table tableName="dept" domainObjectName="Dept" enableCountByExample="false" enableDeleteByExample="false" enableUpdateByExample="false" selectByExampleQueryId="false" enableSelectByExample="false"/>
    </context>
</generatorConfiguration>
```

编写测试类

```java
package com.mashibing;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) throws IOException, XMLParserException, InvalidConfigurationException, SQLException, InterruptedException {
        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        File configFile = new File("mbg.xml");
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);

    }
}
```

# mybatis-plus的使用

> MyBatis-Plus（简称 MP）是一个 MyBatis的增强工具，在 MyBatis 的基础上只做增强不做改变，为简化开发、提高效率而生。

**特性：**

- **无侵入**：只做增强不做改变，引入它不会对现有工程产生影响，如丝般顺滑
- **损耗小**：启动即会自动注入基本 CURD，性能基本无损耗，直接面向对象操作
- **强大的 CRUD 操作**：内置通用 Mapper、通用 Service，仅仅通过少量配置即可实现单表大部分 CRUD 操作，更有强大的条件构造器，满足各类使用需求
- **支持 Lambda 形式调用**：通过 Lambda 表达式，方便的编写各类查询条件，无需再担心字段写错
- **支持主键自动生成**：支持多达 4 种主键策略（内含分布式唯一 ID 生成器 - Sequence），可自由配置，完美解决主键问题
- **支持 ActiveRecord 模式**：支持 ActiveRecord 形式调用，实体类只需继承 Model 类即可进行强大的 CRUD 操作
- **支持自定义全局通用操作**：支持全局通用方法注入（ Write once, use anywhere ）
- **内置代码生成器**：采用代码或者 Maven 插件可快速生成 Mapper 、 Model 、 Service 、 Controller 层代码，支持模板引擎，更有超多自定义配置等您来使用
- **内置分页插件**：基于 MyBatis 物理分页，开发者无需关心具体操作，配置好插件之后，写分页等同于普通 List 查询
- **分页插件支持多种数据库**：支持 MySQL、MariaDB、Oracle、DB2、H2、HSQL、SQLite、Postgre、SQLServer 等多种数据库
- **内置性能分析插件**：可输出 Sql 语句以及其执行时间，建议开发测试时启用该功能，能快速揪出慢查询
- **内置全局拦截插件**：提供全表 delete 、 update 操作智能分析阻断，也可自定义拦截规则，预防误操作

## mybatis-plus环境搭建

Emp.java

```java
package com.mashibing.bean;

import java.util.Date;

@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class Emp {

    private Integer empno;
    private String eName;
    private String job;
    private Integer mgr;
    private Date hiredate;
    private Double sal;
    private Double comm;
    private Integer deptno;
}

```

数据库表sql语句

```sql
CREATE TABLE `tbl_emp` (
  `EMPNO` int(4) NOT NULL AUTO_INCREMENT,
  `E_NAME` varchar(10) DEFAULT NULL,
  `JOB` varchar(9) DEFAULT NULL,
  `MGR` int(4) DEFAULT NULL,
  `HIREDATE` date DEFAULT NULL,
  `SAL` double(7,2) DEFAULT NULL,
  `COMM` double(7,2) DEFAULT NULL,
  `DEPTNO` int(4) DEFAULT NULL,
  PRIMARY KEY (`EMPNO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
```

pom.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.mashibing</groupId>
    <artifactId>mybatis_plus</artifactId>
    <version>1.0-SNAPSHOT</version>
    <dependencies>
        <!-- https://mvnrepository.com/artifact/com.baomidou/mybatis-plus -->
        <dependency>
            <groupId>com.baomidou</groupId>
            <artifactId>mybatis-plus</artifactId>
            <version>3.3.1</version>
        </dependency>
        <!-- https://mvnrepository.com/artifact/junit/junit -->
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.13</version>
            <scope>test</scope>
        </dependency>
        <!-- https://mvnrepository.com/artifact/log4j/log4j -->
        <dependency>
            <groupId>log4j</groupId>
            <artifactId>log4j</artifactId>
            <version>1.2.17</version>
        </dependency>
        <!-- https://mvnrepository.com/artifact/com.alibaba/druid -->
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>druid</artifactId>
            <version>1.1.21</version>
        </dependency>
        <!-- https://mvnrepository.com/artifact/mysql/mysql-connector-java -->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>8.0.19</version>
        </dependency>

        <!-- https://mvnrepository.com/artifact/org.springframework/spring-context -->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-context</artifactId>
            <version>5.2.3.RELEASE</version>
        </dependency>
        <!-- https://mvnrepository.com/artifact/org.springframework/spring-orm -->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-orm</artifactId>
            <version>5.2.3.RELEASE</version>
        </dependency>

    </dependencies>

</project>
```

mybatis-config.xml

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
    <settings>
        <setting name="logImpl" value="LOG4J"/>
    </settings>
</configuration>
```

log4j.properties

```properties
# 全局日志配置
log4j.rootLogger=INFO, stdout
# MyBatis 日志配置
log4j.logger.com.mashibing=truce
# 控制台输出
log4j.appender.stdout=org.apache.log4j.ConsoleAppender
log4j.appender.stdout.layout=org.apache.log4j.PatternLayout
log4j.appender.stdout.layout.ConversionPattern=%5p [%t] - %m%n
```

db.properties

```properties
driverClassname=com.mysql.cj.jdbc.Driver
username=root
password=123456
url=jdbc:mysql://192.168.85.111:3306/demo?serverTimezone=UTC
```

spring.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context" xmlns:tx="http://www.springframework.org/schema/tx"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd http://www.springframework.org/schema/context https://www.springframework.org/schema/context/spring-context.xsd http://www.springframework.org/schema/tx http://www.springframework.org/schema/tx/spring-tx.xsd">
    <context:property-placeholder location="classpath:db.properties"></context:property-placeholder>
    <bean id="dataSource" class="com.alibaba.druid.pool.DruidDataSource">
        <property name="driverClassName" value="${driverClassname}"></property>
        <property name="url" value="${url}"></property>
        <property name="username" value="${username}"></property>
        <property name="password" value="${password}"></property>
    </bean>
    <bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
        <property name="dataSource" ref="dataSource"></property>
    </bean>

    <tx:annotation-driven transaction-manager="transactionManager"></tx:annotation-driven>
    <bean id="sqlSessionFactoryBean" class="org.mybatis.spring.SqlSessionFactoryBean">
        <property name="dataSource" ref="dataSource"></property>
        <property name="configLocation" value="classpath:mybatis-config.xml"></property>
    </bean>
    <bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
        <property name="basePackage" value="com.mashibing.dao"></property>
    </bean>
</beans>
```

MyTest.java

```java
package com.mashibing;


import com.alibaba.druid.pool.DruidDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

public class MyTest {

    ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

    @Test
    public void test01() throws SQLException {
        DruidDataSource dataSource = context.getBean("dataSource", DruidDataSource.class);
        System.out.println(dataSource.getConnection());
    }
}

```

​		在集成mybatis-plus的时候非常简单，只需要替换mybatis自己的sqlSessionFactoryBean对象即可

```xml
<bean id="sqlSessionFactoryBean" class="com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean">
    <property name="dataSource" ref="dataSource"></property>
    <property name="configLocation" value="classpath:mybatis-config.xml"></property>
    <property name="typeAliasesPackage" value="com.mashibing.bean"></property>
</bean>
```

## 简单的CRUD操作

​		如果我们下面要实现CRUD的基本操作，那么我们该如何实现呢？

​		在Mybatis中，我们需要编写对应的Dao接口，并在接口中定义相关的方法，然后提供与该接口相同名称的Dao.xml文件，在文件中填写对应的sql语句，才能完成对应的操作

​		在Mybatis-plus中，我们只需要定义接口，然后继承BaseMapper<T>类即可，此前做的所有操作都是由Mybatis-plus来帮我们完成，不需要创建sql映射文件

EmpDao.java

```java
package com.mashibing.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mashibing.bean.Emp;

/**
 * 在mybatis操作的时候，我们需要自己定义接口中实现的方法，并添加与之对应的EmpDao.xml文件，编写对应的sql语句
 * 在mybatis-plus操作的时候，我们只需要继承BaseMapper接口即可，其中的泛型T表示我们要实际操作的实体类对象
 */
public interface EmpDao extends BaseMapper<Emp> {
}

```

### 插入操作

MyTest.java

```java
package com.mashibing;


import com.alibaba.druid.pool.DruidDataSource;
import com.mashibing.bean.Emp;
import com.mashibing.dao.EmpDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;
import java.util.Date;

public class MyTest {

    ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

    private EmpDao empDao = context.getBean("empDao",EmpDao.class);

@Test
    public void testInsert(){
        Emp emp = new Emp();
        emp.seteName("zhangsan");
        emp.setJob("Teacher");
        emp.setMgr(100);
        emp.setSal(1000.0);
        emp.setComm(500.0);
        emp.setHiredate(new Date());
        emp.setDeptno(10);
        int insert = empDao.insert(emp);
        System.out.println(insert);
    }
}

```

​		当运行上述代码的时候，大家发现报错了，原因在于你写的实体类的名称跟表的名称不匹配，因此在实现的是需要添加@TableName注解，指定具体的表的名称

```java
@TableName("emp")
public class Emp {//省略内容}
```

上述代码运行通过之后，大家会发现结果能够正常的进行插入，但是在控制台会打印一个警告信息，说没有@TableId的注解，原因就在于定义实体类的时候并没有声明其中的主键是哪个列，以及使用什么样的主键生成策略，因此，可以在类的属性上添加如下注解，来消除此警告

```java
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class Emp {

    @TableId(value = "empno",type = IdType.AUTO)
    private Integer empno;
    private String eName;
    private String job;
    private Integer mgr;
    private Date hiredate;
    private Double sal;
    private Double comm;
    private Integer deptno;
}

```

​		但是大家会发现，我们在写属性的时候，实体类属性名称跟表的属性名称并没有一一对应上，那么为什么会完成对应的操作呢？

​		其实原因就在于mybatis-plus的全局配置

***

在进行数据插入的是，如果我们输入的时候用的是全字段，那么sql语句中就会执行如下sql语句：

 INSERT INTO tbl_emp ( e_name, job, mgr, hiredate, sal, comm, deptno ) VALUES ( ?, ?, ?, ?, ?, ?, ? )

但是如果我们在插入的时候，将对象中的某些属性值设置为空，那么会是什么效果呢？

```java
@Test
public void testInsert(){
    Emp emp = new Emp();
    emp.seteName("zhangsan");
    emp.setJob("Teacher");
    emp.setMgr(100);
    //        emp.setSal(1000.0);
    //        emp.setComm(500.0);
    //        emp.setHiredate(new Date());
    //        emp.setDeptno(10);
    int insert = empDao.insert(emp);
    System.out.println(insert);
    System.out.println(emp.getEmpno());
}
```

 INSERT INTO tbl_emp ( e_name, job, mgr ) VALUES ( ?, ?, ? ) 

大家其实可以看到我们在插入的时候，mybatis-plus会根据我会输入的对象的字段的个数来动态的调整我们的sql语句插入的字段，这是大家需要注意的mybatis-plus比较灵活的地方。

### 更新操作

```java
@Test
public void testUpdate(){
    Emp emp = new Emp();
    emp.setEmpno(1);
    emp.seteName("lisi");
    emp.setJob("student");
    emp.setMgr(100);
    emp.setSal(1000.0);
    emp.setComm(500.0);
    emp.setHiredate(new Date());
    emp.setDeptno(10);
    int update = empDao.updateById(emp);
    System.out.println(update);
}
```

### 删除操作

```java
@Test
public void testDelete(){
    // 1、根据id删除数据
    //        int i = empDao.deleteById(1);
    //        System.out.println(i);

    // 2、根据一组id删除数据
    //        int i = empDao.deleteBatchIds(Arrays.asList(2, 3, 4));
    //        System.out.println(i);

    // 3、根据条件删除数据
    //        QueryWrapper queryWrapper = new QueryWrapper();
    //        queryWrapper.in("empno",Arrays.asList(5,6,7));
    //        int delete = empDao.delete(queryWrapper);
    //        System.out.println(delete);

    // 4、条件封装map删除数据
    Map<String,Object> map = new HashMap<>();
    map.put("empno",9);
    int i = empDao.deleteByMap(map);
    System.out.println(i);
}
```

### 查询操作

```java
@Test
public void testselect(){

    // 1、根据id查询对象
    //        Emp emp = empDao.selectById(1);
    //        System.out.println(emp);

    // 2、根据实体包装类查询单个对象，返回的结果集有且仅能有一个对象
    //        QueryWrapper<Emp> emp = new QueryWrapper<Emp>();
    //        emp.eq("empno",2).eq("e_name","zhangsan");
    //        Emp emp1 = empDao.selectOne(emp);
    //        System.out.println(emp1);

    // 3、通过多个id值进行查询
    //        List<Emp> list = empDao.selectBatchIds(Arrays.asList(1, 2, 3));
    //        for (Emp emp : list) {
    //            System.out.println(emp);
    //        }

    // 4、通过map封装进行条件查询
    //        Map<String,Object> map = new HashMap<String, Object>();
    //        map.put("e_name","zhangsan");
    //        map.put("sal",1000.0);
    //        List<Emp> list = empDao.selectByMap(map);
    //        for (Emp emp : list) {
    //            System.out.println(emp);
    //        }

    // 5、分页查询,需要添加分页插件
    /**
         * <property name="plugins">
         *             <array>
         *                 <bean class="com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor"></bean>
         *             </array>
         *         </property>
         */

    // Page<Emp> empPage = empDao.selectPage(new Page<>(2, 5), null);
    // List<Emp> records = empPage.getRecords();
    // System.out.println(records);

    // 6、根据条件返回查询结果总数
    //        QueryWrapper<Emp> queryWrapper = new QueryWrapper<>();
    //        queryWrapper.eq("e_name","zhangsan");
    //        Integer integer = empDao.selectCount(queryWrapper);
    //        System.out.println(integer);

    // 7、根据条件查询所有结果返回list集合
    //        List<Emp> list = empDao.selectList(null);
    //        for (Emp emp : list) {
    //            System.out.println(emp);
    //        }

    // 8、根据条件查询结果封装成map的list结构
    //        List<Map<String, Object>> maps = empDao.selectMaps(null);
    //        System.out.println(maps);
}
```

## Mybatis-plus的相关配置

​		在mybatis中我们可以在mybatis-config配置文件中可以添加<settings>标签，设置全局的默认策略，在MP中也具备相同的功能，只不过配置方式有所不同，我们可以在spring.xml文件中添加配置。

https://mp.baomidou.com/config/

在此链接中包含了非常多的配置项，用户可以按照自己的需求添加需要的配置，配置方式如下：

spring.xml

```xml
<bean id="sqlSessionFactory" class="com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean">
    <property name="configuration" ref="configuration"/> <!--  非必须  -->
    <property name="globalConfig" ref="globalConfig"/> <!--  非必须  -->
    ......
</bean>

<bean id="configuration" class="com.baomidou.mybatisplus.core.MybatisConfiguration">
    ......
</bean>

<bean id="globalConfig" class="com.baomidou.mybatisplus.core.config.GlobalConfig">
    <property name="dbConfig" ref="dbConfig"/> <!--  非必须  -->
    ......
</bean>

<bean id="dbConfig" class="com.baomidou.mybatisplus.core.config.GlobalConfig.DbConfig">
    ......
</bean>
```

​		通过这个配置文件的配置，大家可以进行回想上述问题的出现，mybatis-plus是如何解决这个问题的呢？

​		在mybatis-plus中会引入写默认的配置，这个选项的默认配置为true，因此可以完成对应的实现。

我们可以通过如下配置来禁用驼峰标识的操作，如下所示：

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context" xmlns:tx="http://www.springframework.org/schema/tx"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd http://www.springframework.org/schema/context https://www.springframework.org/schema/context/spring-context.xsd http://www.springframework.org/schema/tx http://www.springframework.org/schema/tx/spring-tx.xsd">
    <context:property-placeholder location="classpath:db.properties"></context:property-placeholder>
    <bean id="dataSource" class="com.alibaba.druid.pool.DruidDataSource">
        <property name="driverClassName" value="${driverClassname}"></property>
        <property name="url" value="${url}"></property>
        <property name="username" value="${username}"></property>
        <property name="password" value="${password}"></property>
    </bean>
    <bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
        <property name="dataSource" ref="dataSource"></property>
    </bean>

    <tx:annotation-driven transaction-manager="transactionManager"></tx:annotation-driven>
    <bean id="sqlSessionFactoryBean" class="com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean">
        <property name="configLocation" value="classpath:mybatis-config.xml"></property>
        <property name="dataSource" ref="dataSource"></property>
        <property name="typeAliasesPackage" value="com.mashibing.bean"></property>
        <property name="globalConfig" ref="globalConfig"></property>
        <property name="configuration" ref="configuration"></property>
    </bean>
    <bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
        <property name="basePackage" value="com.mashibing.dao"></property>
    </bean>
    <bean id="configuration" class="com.baomidou.mybatisplus.core.MybatisConfiguration">
        <property name="mapUnderscoreToCamelCase" value="false"></property>
    </bean>

    <bean id="globalConfig" class="com.baomidou.mybatisplus.core.config.GlobalConfig">
        <property name="dbConfig" ref="dbConfig"></property>
    </bean>
    <bean id="dbConfig" class="com.baomidou.mybatisplus.core.config.GlobalConfig.DbConfig">
    </bean>
</beans>
```

**1、当添加上述配置之后，大家发现运行过程中报错，**

​		Property 'configuration' and 'configLocation' can not specified with together

​		表示这两个标签无法同时使用，因此我们可以选择将configLocation给禁用掉，就是不使用mybatis的配置，此时就能够正常使用了，但是放置属性的时候又报错了，原因就在于我们把驼峰标识给禁用了，重新开启即可。除此之外，我们还可以在属性的上面添加@TableField属性

```java
    @TableField(value = "e_name")
    private String eName;
```

**2、此时发现日志功能又无法使用了，只需要添加如下配置即可**

```xml
<bean id="configuration" class="com.baomidou.mybatisplus.core.MybatisConfiguration">
    <property name="mapUnderscoreToCamelCase" value="true"></property>
    <property name="logImpl" value="org.apache.ibatis.logging.log4j.Log4jImpl"></property>
</bean>
```

**3、我们在刚刚插入数据的时候发现每个类可能都需要写主键生成策略，这是比较麻烦的，因此可以选择将主键配置策略设置到全局配置中。**

```xml
<bean id="dbConfig" class="com.baomidou.mybatisplus.core.config.GlobalConfig.DbConfig">
        <property name="idType" ref="idType"></property>
    </bean>
    <util:constant id="idType" static-field="com.baomidou.mybatisplus.annotation.IdType.AUTO"></util:constant>
```

**4、如果你的表的名字都具备相同的前缀，那么可以设置默认的前缀配置策略，此时的话可以将实体类上的@TableName标签省略不写**

```xml
<bean id="dbConfig" class="com.baomidou.mybatisplus.core.config.GlobalConfig.DbConfig">
        <property name="idType" ref="idType"></property>
        <property name="tablePrefix" value="tbl_"></property>
    </bean>
    <util:constant id="idType" static-field="com.baomidou.mybatisplus.annotation.IdType.AUTO"></util:constant>
```

**5、在mybatis-plus中如果需要获取插入的数据的主键的值，那么直接获取即可，原因就在于配置文件中指定了默认的属性为true**

## 条件构造器Wrapper（看官网即可）

## 代码生成器

​		AutoGenerator 是 MyBatis-Plus 的代码生成器，通过 AutoGenerator 可以快速生成 Entity、Mapper、Mapper XML、Service、Controller 等各个模块的代码，极大的提升了开发效率。

​		其实在学习mybatis的时候我们就使用过逆向工程，根据我们的数据表来生成的对应的实体类，DAO接口和Mapper映射文件，而MyBatis-plus提供了更加完善的功能，下面来针对两种方式做一个基本的对比

​		1、MyBatis-plus是根据java代码开生成代码的，而Mybatis是根据XML文件的配置来生成的

​		2、MyBatis-plus能够生成实体类、Mapper接口、Mapper映射文件，Service层，Controller层，而Mybatis只能生成实体类，Mapper接口，Mapper映射文件

### 添加依赖

添加代码生成器依赖

```xml
<dependency>
    <groupId>com.baomidou</groupId>
    <artifactId>mybatis-plus-generator</artifactId>
    <version>3.3.1.tmp</version>
</dependency>
```

添加 模板引擎 依赖，MyBatis-Plus 支持 Velocity（默认）、Freemarker、Beetl，用户可以选择自己熟悉的模板引擎，如果都不满足您的要求，可以采用自定义模板引擎。

```xml
<dependency>
    <groupId>org.apache.velocity</groupId>
    <artifactId>velocity-engine-core</artifactId>
    <version>2.2</version>
</dependency>
<dependency>
    <groupId>org.freemarker</groupId>
    <artifactId>freemarker</artifactId>
    <version>2.3.30</version>
</dependency>
<dependency>
    <groupId>com.ibeetl</groupId>
    <artifactId>beetl</artifactId>
    <version>3.1.1.RELEASE</version>
</dependency>
```

### 编写生成类

```java
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.Test;

public class MyTest {
    @Test
    public void testGenerator(){
        //此处默认有两个对应的实现类，大家不要导错包
        GlobalConfig globalConfig = new GlobalConfig();
        //设置全局的配置
        globalConfig.setActiveRecord(true)//是否支持AR模式
            .setAuthor("lian")//设置作者
            .setOutputDir("e:\\self_project\\mybatisplus_generatorcode\\src\\main\\java")//设置生成路径
            .setFileOverride(true)//设置文件覆盖
            .setIdType(IdType.AUTO) //设置主键生成策略
            .setServiceName("%sService")//设置生成的serivce接口的名字
            .setBaseResultMap(true) //设置基本的结果集映射
            .setBaseColumnList(true);//设置基本的列集合

        //设置数据源的配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDriverName("com.mysql.cj.jdbc.Driver")
            .setUrl("jdbc:mysql://192.168.85.111:3306/mp?serverTimezone=UTC")
            .setUsername("root").setPassword("123456");

        // 进行策略配置
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setCapitalMode(true)//设置全局大写命名
            .setNaming(NamingStrategy.underline_to_camel)//数据库表映射到实体的命名策略
            .setTablePrefix("tbl_")//设置表名前缀
            .setInclude("tbl_emp");//生成的表

        // 进行包名的策略配置
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent("com.mashibing")
            .setMapper("mapper")
            .setService("service")
            .setController("controller")
            .setEntity("bean")
            .setXml("mapper");

        //整合配置
        AutoGenerator autoGenerator = new AutoGenerator();
        autoGenerator.setGlobalConfig(globalConfig).setDataSource(dataSourceConfig).setStrategy(strategyConfig)
            .setPackageInfo(packageConfig);

        autoGenerator.execute();
    }
}
```

​		注意，当通过上述代码实现之后，大家发现可以在Controller层可以直接实现调用，这些调用的实现最核心的功能就在于ServiceImpl类，这个类中自动完成mapper的注入，同时提供了一系列CRUD的方法。

## 插件扩展

MyBatis 允许你在映射语句执行过程中的某一点进行拦截调用。默认情况下，MyBatis 允许使用插件来拦截的方法调用包括：

- Executor (update, query, flushStatements, commit, rollback, getTransaction, close, isClosed)
- ParameterHandler (getParameterObject, setParameters)
- ResultSetHandler (handleResultSets, handleOutputParameters)
- StatementHandler (prepare, parameterize, batch, update, query)

### 分页插件

在spring.xml文件中添加如下配置引入插件

```xml
<property name="plugins">
    <array>
        <bean class="com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor"></bean>
    </array>
</property>
```

编写测试类

```java
@Test
public void TestPage(){
    Page page = new Page(2,2);
    Page page1 = empDao.selectPage(page, null);
    List records = page1.getRecords();
    for (Object record : records) {
        System.out.println(record);
    }
    System.out.println("==============");
    System.out.println("获取总条数："+page.getTotal());
    System.out.println("当前页码："+page.getCurrent());
    System.out.println("总页码："+page.getPages());
    System.out.println("每页显示的条数："+page.getSize());
    System.out.println("是否有上一页："+page.hasPrevious());
    System.out.println("是否有下一页："+page.hasNext());
}
```

### 乐观锁插件

当要更新一条记录的时候，希望这条记录没有被别人更新

乐观锁实现方式：

取出记录时，获取当前version
更新时，带上这个version
执行更新时， set version = newVersion where version = oldVersion
如果version不对，就更新失败

添加配置：

```xml
<bean class="com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor"></bean>
```

修改实体类添加version字段并在表中添加version字段

编写测试类

```java
@Test
public void testOptimisticLocker(){
    Emp emp = new Emp();
    emp.setEmpno(22);
    emp.seteName("zhang");
    emp.setSal(10000.0);
    emp.setComm(1000.0);
    emp.setVersion(2);
    empDao.updateById(emp);
}
```

### SQL执行分析插件，避免出现全表更新和删除

```xml
<bean class="com.baomidou.mybatisplus.extension.plugins.SqlExplainInterceptor">
    <property name="sqlParserList">
        <list>
            <bean class="com.baomidou.mybatisplus.extension.parsers.BlockAttackSqlParser"></bean>
        </list>
    </property>
</bean>
```

```
@Test
public void testSqlExplain(){
    int delete = empDao.delete(null);
    System.out.println(delete);
}
```

### 非法sql检查插件

```xml
<bean class="com.baomidou.mybatisplus.extension.plugins.IllegalSQLInterceptor">
</bean>
```

```java
@Test
public void testSqlIllegal(){
    QueryWrapper<Emp> queryWrapper = new QueryWrapper<>();
    queryWrapper.or();
    List<Emp> list = empDao.selectList(queryWrapper);
    for (Emp emp : list) {
        System.out.println(emp);
    }
}
```

## SQL注入器

​		全局配置 `sqlInjector` 用于注入 `ISqlInjector` 接口的子类，实现自定义方法注入。也就是说我们可以将配置在xml中的文件使用注入的方式注入到全局中，就不需要再编写sql语句

自定义注入器

```java
package com.mashibing.injector;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.injector.AbstractSqlInjector;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MyInjector extends  AbstractSqlInjector{

    @Override
    public List<AbstractMethod> getMethodList(Class<?> mapperClass) {
        return Stream.of(new DeleteAll()).collect(Collectors.toList());
    }
}

```

添加配置：

```xml
 <bean id="globalConfig" class="com.baomidou.mybatisplus.core.config.GlobalConfig">
        <property name="dbConfig" ref="dbConfig"></property>
        <property name="sqlInjector" ref="myinject"></property>
    </bean>
    <bean id="myinject" class="com.mashibing.injector.MyInjector"></bean>
```

```java
package com.mashibing.injector;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlSource;

public class DeleteAll extends AbstractMethod {
    @Override
    public MappedStatement injectMappedStatement(Class<?> mapperClass, Class<?> modelClass, TableInfo tableInfo) {
        String sql;
        MySqlMethod mySqlMethod = MySqlMethod.DELETE_ALL;
        if (tableInfo.isLogicDelete()) {
            sql = String.format(mySqlMethod.getSql(), tableInfo.getTableName(),  tableInfo,
                    sqlWhereEntityWrapper(true,tableInfo));
        } else {
            mySqlMethod = MySqlMethod.DELETE_ALL;
            sql = String.format(mySqlMethod.getSql(), tableInfo.getTableName(),
                    sqlWhereEntityWrapper(true,tableInfo));
        }
        SqlSource sqlSource = languageDriver.createSqlSource(configuration, sql, modelClass);
        return addUpdateMappedStatement(mapperClass, modelClass, mySqlMethod.getMethod(), sqlSource);
    }
}
```

```java
package com.mashibing.injector;
   /**
    * 自定义全局删除方法
    */
    public enum MySqlMethod {
    /**
     * 删除全部
     */
    DELETE_ALL("deleteAll", "根据 entity 条件删除记录", "<script>\nDELETE FROM %s %s\n</script>");
    private final String method;
    private final String desc;
    private final String sql;

    MySqlMethod(String method, String desc, String sql) {
        this.method = method;
        this.desc = desc;
        this.sql = sql;
    }

    public String getMethod() {
        return method;
    }

    public String getDesc() {
        return desc;
    }

    public String getSql() {
        return sql;
    }

}
```

```java
package com.mashibing.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mashibing.bean.Emp;

/**
 * 在mybatis操作的时候，我们需要自己定义接口中实现的方法，并添加与之对应的EmpDao.xml文件，编写对应的sql语句
 * 在mybatis-plus操作的时候，我们只需要继承BaseMapper接口即可，其中的泛型T表示我们要实际操作的实体类对象
 */
public interface EmpDao extends BaseMapper<Emp> {
    Integer deleteAll();
}
```

## 公共字段填充

- 实现元对象处理器接口：com.baomidou.mybatisplus.core.handlers.MetaObjectHandler

- 注解填充字段 `@TableField(.. fill = FieldFill.INSERT)` 生成器策略部分也可以配置！

  metaobject:元对象，是mybatis提供的一个用于更加方便，更加优雅的访问对象的属性，给对象的属性设置值的一个对象，还会用于包装对象，支持Object,Map,Collection等对象进行包装。本质上metaobject是给对象的属性设置值，最终还是要通过Reflect获取到属性的对应方法的invoker，最终执行。

编写自定义的公共字段填充

```java
package com.mashibing.fill;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;

import java.time.LocalDateTime;
import java.util.stream.Stream;

public class MyMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        this.strictInsertFill(metaObject, "eName", String.class, "lian"); // 起始版本 3.3.0(推荐使用)
//        this.fillStrategy(metaObject, "createTime", LocalDateTime.now()); // 也可以使用(3.3.0 该方法有bug请升级到之后的版本如`3.3.1.8-SNAPSHOT`)
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.strictUpdateFill(metaObject, "eName", String.class,"lian"); // 起始版本 3.3.0(推荐使用)
//        this.fillStrategy(metaObject, "updateTime", LocalDateTime.now()); // 也可以使用(3.3.0 该方法有bug请升级到之后的版本如`3.3.1.8-SNAPSHOT`)
    }
}
```

添加到对应的配置中：

```java
  <bean id="globalConfig" class="com.baomidou.mybatisplus.core.config.GlobalConfig">
        <property name="dbConfig" ref="dbConfig"></property>
        <property name="metaObjectHandler" ref="myMeta"></property>
    </bean>
    <bean id="myMeta" class="com.mashibing.fill.MyMetaObjectHandler"></bean>
```

测试：

```java
  @Test
    public void testMeta(){
        int insert = empDao.insert(new Emp());
        System.out.println(insert);
    }
```

