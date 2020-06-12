const {fs, path} = require('@vuepress/shared-utils')

module.exports = {
  title: 'tiankafei - java相关技术栈',
  description: '自己写的一些东西的记录，包括代码与笔记，jdk最低支持1.8',
  base: '/',
  dest: 'docs',
  head: [],
  plugins: [],
  themeConfig: {
    nav: [
      {text: '首页', link: '/'},
      {text: '导航', link: '/guide/'},
      {text: '架构', link: '/tiankafei-docs-架构/MySQL调优/'},
      {text: '大数据', link: '/tiankafei-docs-大数据/centos7安装配置Hadoop/'},
      {text: 'WEB', link: '/tiankafei-docs-web/spring学习笔记/'},
      {text: 'IO', link: '/tiankafei-docs-io/IO详情介绍/'},
      {text: '数据结构与算法', link: '/tiankafei-docs-数据结构与算法/java集合/'},
      {text: '云', link: '/tiankafei-docs-云/Centos7安装Docker并配置使用/'},
      {text: 'linux', link: '/tiankafei-docs-linux/centos常用命令/'},
      {text: '程序员的数学', link: '/tiankafei-docs-程序员的数学/距离度量/'},
      {text: '其他', link: '/tiankafei-docs-other/git上fork后再更新/'},
      {text: '英语', link: '/tiankafei-docs-en/词性语法学习/'},
      {
        text: '更多文档',
        items: [
          {text: '词性语法学习', link: '/tiankafei-docs-en/词性语法学习/'},
          {text: '第1阶段单词记忆', link: '/tiankafei-docs-en/第1阶段单词记忆/'},
        ]
      },
      {text: 'GitHub', link: 'https://github.com/tiankafei/tiankafei'},
    ],
    sidebar: {
      '/guide/': [
        {
          title: '指南',
          collapsable: false,
          children: [
            ''
          ]
        }
      ],
      '/tiankafei-docs-架构/': [
        {
          title: '架构',
          collapsable: false,
          children: [
            'MySQL调优',
            'mysql主从复制安装配置',
            '使用amoeba实现mysql读写分离',
            'redis学习笔记',
            'zookeeper学习笔记',
            'elasticsearch学习笔记',
          ]
        }
      ],
      '/tiankafei-docs-大数据/': [
        {
          title: '大数据',
          collapsable: false,
          children: [
            'centos7安装配置Hadoop',
            'hadoop学习笔记',
            'Hadoop程序运行的三种方式',
            'hive学习笔记',
            'centos7安装配置HBase',
            'hbase学习笔记',
            '大数据项目-日志收集分析',
            'flume学习笔记',
            'sqoop学习笔记',
            'centos7安装配置Spark',
            'scala学习笔记',
            'centos7安装配置Flink',
            'Kafka学习笔记',
          ]
        }
      ],
      '/tiankafei-docs-web/': [
        {
          title: 'WEB',
          collapsable: false,
          children: [
            'spring学习笔记',
            'springMVC学习笔记',
            'mybatis学习笔记',
            'springBoot学习笔记',
            'springCloud学习笔记',
            '特别注意的点',
            'filter-servlet-inteceptor-controller执行顺序图',
            'sharding-jdbc基于springboot的配置',
            '分布式事务',
            '分布式锁',
          ]
        }
      ],
      '/tiankafei-docs-io/': [
        {
          title: 'IO',
          collapsable: false,
          children: [
            'IO详情介绍',
          ]
        }
      ],
      '/tiankafei-docs-数据结构与算法/': [
        {
          title: '数据结构与算法',
          collapsable: false,
          children: [
            'java集合',
            'Lambda表达式和StreamAPI用法',
            '多线程与高并发-JUC',
            '设计模式',
            '树结构',
            '位运算',
            'JVM从入门到精通',
          ]
        }
      ],
      '/tiankafei-docs-云/': [
        {
          title: '云',
          collapsable: false,
          children: [
            'Centos7安装Docker并配置使用',
            'Centos7安装Gitlab并汉化',
            'Centos7安装Jenkins并配置使用',
            'k8s-nfs文件共享安装及使用',
            'k8s最新版安装过程',
            'k8s脚本部署',
            'k8s常用命令',
          ]
        }
      ],
      '/tiankafei-docs-linux/': [
        {
          title: 'linux',
          collapsable: false,
          children: [
            'centos常用命令',
            'centos7安装JDK',
            'centos6安装MySQL8',
            'centos7安装MySQL8',
            'centos7安装Mongodb并设置开机启动',
            'centos7安装Consul并设置开机启动',
            'centos7安装Nacos并设置开机启动',
            'centos7安装Neo4j并设置开机启动',
            'centos7安装Nexus私服并设置开机启动',
            'centos7安装Nexus私服及maven的配置',
            'centos7安装NodeJS',
            'centos7安装禅道并开机启动',
            'centos7安装RabbitMQ并设置开机启动',
            'centos7安装Sentinel-dashboard并设置开机启动',
            'centos7安装Easy-Mock并设置开机启动',
          ]
        }
      ],
      '/tiankafei-docs-程序员的数学/': [
        {
          title: '程序员的数学',
          collapsable: false,
          children: [
            '距离度量',
            '导数',
            '概率',
            '概率',
            '逻辑',
            '线性代数',
          ]
        }
      ],
      '/tiankafei-docs-other/': [
        {
          title: '其他',
          collapsable: false,
          children: [
            'git上fork后再更新',
            'git同时连接多个远程仓库',
            'Java基础',
            '常用正则表达式',
          ]
        }
      ],
      '/tiankafei-docs-en/': [
        {
          title: '英语学习',
          collapsable: false,
          children: [
            '词性语法学习',
            '第1阶段单词记忆',
          ]
        }
      ]
    },
    sidebarDepth: 3,
    lastUpdated: 'Last Updated'
  }
};

const tiankafeiDocs = fs
  .readdirSync(path.resolve(__dirname, '../'))
  .filter(filename => filename.includes('tiankafei-docs-')
).
sort()


