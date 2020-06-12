module.exports = {
  title: 'java技术栈',
  description: '自己写的一些东西的记录，包括代码与笔记，jdk最低支持1.8',
  base: '/',
  dest: './ROOT',
  head: [],
  plugins: [],
  themeConfig: {
    nav: [
      { text: "首页", link: "/" },
      { text: "指南", link: "/guide/" },
      { text: "配置", link: "/xuexibiji/" },
      {
        text: "了解更加多",
        link: "/learnmore/",
        items: [
          { text: "初级篇", link: "/learnmore/part1/" },
          { text: "进阶篇", link: "/learnmore/part12/" },
          { text: "大神篇", link: "http://www.baidu.com" }
        ]
      }
    ],
    sidebar: [],
    sidebarDepth: 2,
    lastUpdated: 'Last Updated'
  }
};