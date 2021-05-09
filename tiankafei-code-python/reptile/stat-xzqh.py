# -*- coding: utf-8 -*
# 作者：甜咖啡
# 新建时间：2021/4/11 18:48
import requests
from lxml import etree

def get_shi_url(url, suffix):
    # 请求头和目标网址
    headers = {
        'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.117 Safari/537.36'
    }

    # 第一种写法的 xpath
    xpath_link = '//table[@class="citytable"]/tr[@class="citytr"]/td/a/@href'
    xpath_title = '//table[@class="citytable"]/tr[@class="citytr"]/td/a/text()'

    # 获取和解析网页
    r = requests.get(url, headers=headers)
    r.encoding = r.apparent_encoding
    dom = etree.HTML(r.text)

    # 所有的 链接 标题 评论数 点赞数
    links = dom.xpath(xpath_link)
    titles = dom.xpath(xpath_title)

    # 将每篇文章的链接 标题 评论数 点赞数放到一个字典里
    data = []
    for i in range(len(links)):
        t = {}
        t['link'] = links[i]
        t['title'] = titles[i]
        qx_url = url.replace(suffix, t['link'])
        print(qx_url)
        data.append(t)

    # 打印结果
    for t in data:
        print(t)

def get_sheng_url(url):
    # 请求头和目标网址
    headers = {
        'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.117 Safari/537.36'
    }

    # 第一种写法的 xpath
    xpath_link = '//table[@class="provincetable"]/tr[@class="provincetr"]/td/a/@href'
    xpath_title = '//table[@class="provincetable"]/tr[@class="provincetr"]/td/a/text()'

    # 获取和解析网页
    r = requests.get(url, headers=headers)
    r.encoding = r.apparent_encoding
    dom = etree.HTML(r.text)

    # 所有的 链接 标题 评论数 点赞数
    links = dom.xpath(xpath_link)
    titles = dom.xpath(xpath_title)

    # 将每篇文章的链接 标题 评论数 点赞数放到一个字典里
    data = []
    for i in range(len(links)):
        t = {}
        t['link'] = links[i]
        t['title'] = titles[i]

        t['code'] = t['link'].replace('.html', '')
        shi_url = url.replace('index.html', t['link'])
        get_shi_url(shi_url, t['link'])
        data.append(t)
        break

    # 打印结果
    for t in data:
        print(t)


if __name__ == '__main__':

    domain = 'http://www.stats.gov.cn'

    # 请求头和目标网址
    headers = {
        'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.117 Safari/537.36'
    }
    url = 'http://www.stats.gov.cn/tjsj/tjbz/tjyqhdmhcxhfdm/'

    # 获取年份 xpath
    # xpath_link = '//ul[@class="note-list"]/li/div/a/@href'
    xpath_year = '//div[@class="center_list"]/ul[@class="center_list_contlist"]/li/a/span/font[@class="cont_tit03"]/text()'
    xpath_link = '//div[@class="center_list"]/ul[@class="center_list_contlist"]/li/a/@href'

    # 获取和解析网页
    r = requests.get(url, headers=headers)
    r.encoding = r.apparent_encoding
    dom = etree.HTML(r.text)

    # 所有的 链接 标题 评论数 点赞数
    links = dom.xpath(xpath_link)
    years = dom.xpath(xpath_year)

    # 将每篇文章的链接 标题 评论数 点赞数放到一个字典里
    data = []
    for i in range(len(links)):
        t = {}
        t['link'] = links[i]
        t['title'] = years[i]

        if(t['link'].startswith('/')):
            t['link'] = domain + t['link']

        get_sheng_url(t['link'])

        print("=======================", t['title'])
        data.append(t)
        break

    # 打印结果
    for t in data:
        print(t)