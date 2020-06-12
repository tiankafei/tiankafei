const {fs, path} = require('@vuepress/shared-utils')

module.exports = {
  title: 'tiankafei - java相关技术栈',
  description: '自己写的一些东西的记录，包括代码与笔记，jdk最低支持1.8',
  base: '/',
  dest: './ROOT',
  head: [],
  plugins: [],
  themeConfig: {
    nav: [
      {text: '首页', link: '/'},
      {text: '指南', link: '/guide/'},
      {text: '配置', link: '/xuexibiji/'},
      {
        text: '更多文档',
        items: [
          {text: '词性语法学习', link: '/tiankafei-docs-en/词性语法学习/'},
          {text: '第1阶段单词记忆', link: '/tiankafei-docs-en/第1阶段单词记忆/'},
        ]
      }
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
    sidebarDepth: 2,
    lastUpdated: 'Last Updated'
  }
};

const tiankafeiDocs = fs
  .readdirSync(path.resolve(__dirname, '../'))
  .filter(filename => filename.includes('tiankafei-docs-')
).
sort()


