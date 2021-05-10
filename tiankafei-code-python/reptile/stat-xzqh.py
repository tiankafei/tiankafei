# -*- coding: utf-8 -*
# 作者：甜咖啡
# 新建时间：2021/4/11 18:48
import requests
from lxml import etree
import time
import os
import json

interval = 0.1
file_path = 'D:\data'


def get_jc_url(url):
    # 请求头和目标网址
    headers = {
        'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.117 Safari/537.36'
    }

    # 第一种写法的 xpath
    xpath_title = '//table[@class="villagetable"]/tr[@class="villagetr"]/td/text()'

    # 获取和解析网页
    print(url)
    r = requests.get(url, headers=headers)
    r.encoding = r.apparent_encoding
    dom = etree.HTML(r.text)

    # 所有的 链接 标题 评论数 点赞数
    titles = dom.xpath(xpath_title)

    # 将每篇文章的链接 标题 评论数 点赞数放到一个字典里
    data = []
    cur_index = 0
    code = ''
    name = ''
    for i in range(len(titles)):
        t = {}
        if (cur_index % 3) == 0:
            code = titles[i]
        elif (cur_index % 3) == 1:
            cxsx = titles[i]
        elif (cur_index % 3) == 2:
            name = titles[i]

            t['cxsx'] = cxsx
            t['code'] = code
            t['name'] = name
            data.append(t)

            print(t)
            f = open(os.path.join('D:\data', 't.json'), 'w', encoding='utf-8')
            f.write(json.dumps(t))
            f.close()
            break

        cur_index += 1
    return data


def get_xz_url(url, suffix):
    # 请求头和目标网址
    headers = {
        'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.117 Safari/537.36'
    }

    # 第一种写法的 xpath
    xpath_link = '//table[@class="towntable"]/tr[@class="towntr"]/td/a/@href'
    xpath_title = '//table[@class="towntable"]/tr[@class="towntr"]/td/a/text()'

    # 获取和解析网页
    print(url)
    r = requests.get(url, headers=headers)
    r.encoding = r.apparent_encoding
    dom = etree.HTML(r.text)

    # 所有的 链接 标题 评论数 点赞数
    links = dom.xpath(xpath_link)
    titles = dom.xpath(xpath_title)

    # 将每篇文章的链接 标题 评论数 点赞数放到一个字典里
    data = []
    cur_index = 0
    code = ''
    for i in range(len(links)):
        t = {}
        if (cur_index % 2):
            t['link'] = links[i]
            t['code'] = code
            t['name'] = titles[i]

            jc_url = url.replace(suffix.split('/')[-1], t['link'])

            time.sleep(interval)
            sub_data = get_jc_url(jc_url)
            t['sub'] = sub_data
            data.append(t)

            break
        else:
            code = titles[i]

        cur_index += 1
    return data


def get_qx_url(url, suffix):
    # 请求头和目标网址
    headers = {
        'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.117 Safari/537.36'
    }

    # 第一种写法的 xpath
    xpath_link = '//table[@class="countytable"]/tr[@class="countytr"]/td/a/@href'
    xpath_title = '//table[@class="countytable"]/tr[@class="countytr"]/td/a/text()'

    # 获取和解析网页
    print(url)
    r = requests.get(url, headers=headers)
    r.encoding = r.apparent_encoding
    dom = etree.HTML(r.text)

    # 所有的 链接 标题 评论数 点赞数
    links = dom.xpath(xpath_link)
    titles = dom.xpath(xpath_title)

    # 将每篇文章的链接 标题 评论数 点赞数放到一个字典里
    data = []
    cur_index = 0
    code = ''
    for i in range(len(links)):
        t = {}
        if (cur_index % 2):
            t['link'] = links[i]
            t['code'] = code
            t['name'] = titles[i]

            xz_url = url.replace(suffix.split('/')[-1], t['link'])

            time.sleep(interval)
            sub_data = get_xz_url(xz_url, t['link'])
            t['sub'] = sub_data
            data.append(t)

            break
        else:
            code = titles[i]

        cur_index += 1

    return data


def get_shi_url(url, suffix, sheng_path):
    # 请求头和目标网址
    headers = {
        'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.117 Safari/537.36'
    }

    # 第一种写法的 xpath
    xpath_link = '//table[@class="citytable"]/tr[@class="citytr"]/td/a/@href'
    xpath_title = '//table[@class="citytable"]/tr[@class="citytr"]/td/a/text()'

    # 获取和解析网页
    print(url)
    r = requests.get(url, headers=headers)
    r.encoding = r.apparent_encoding
    dom = etree.HTML(r.text)

    # 所有的 链接 标题 评论数 点赞数
    links = dom.xpath(xpath_link)
    titles = dom.xpath(xpath_title)

    # 将每篇文章的链接 标题 评论数 点赞数放到一个字典里
    data = []
    cur_index = 0
    code = ''
    for i in range(len(links)):
        t = {}
        if (cur_index % 2):
            t['link'] = links[i]
            t['code'] = code
            t['name'] = titles[i]

            qx_url = url.replace(suffix, t['link'])
            data.append(t)

            shi_path = os.path.join(sheng_path, t['code'])
            if os.path.exists(shi_path):
                pass
            else:
                os.makedirs(shi_path)

            sub_data = get_qx_url(qx_url, t['link'])
            t['sub'] = sub_data
            shi = json.dumps(data)

            f = open(os.path.join(shi_path, 't.json'), 'w', encoding='utf-8')
            f.write(shi)
            f.close()
            break
        else:
            code = titles[i]

        cur_index += 1
    return data


def get_sheng_url(url, path):
    # 请求头和目标网址
    headers = {
        'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.117 Safari/537.36'
    }

    # 第一种写法的 xpath
    xpath_link = '//table[@class="provincetable"]/tr[@class="provincetr"]/td/a/@href'
    xpath_title = '//table[@class="provincetable"]/tr[@class="provincetr"]/td/a/text()'

    # 获取和解析网页
    print(url)
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
        data.append(t)
        sheng_path = os.path.join(path, t['code'])
        if os.path.exists(sheng_path):
            pass
        else:
            os.makedirs(sheng_path)

        time.sleep(interval * 10)
        print(sheng_path)
        print(t)
        get_shi_url(shi_url, t['link'], sheng_path)



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
    print(url)
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

        if (t['link'].startswith('/')):
            t['link'] = domain + t['link']

        data.append(t)
        time.sleep(interval * 10)

        path = os.path.join(file_path, t['title'])
        if os.path.exists(path):
            pass
        else:
            os.makedirs(path)
        get_sheng_url(t['link'], path)
        break
