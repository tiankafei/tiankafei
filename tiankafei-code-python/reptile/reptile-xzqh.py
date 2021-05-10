# -*- coding: utf-8 -*
# 作者：甜咖啡
# 新建时间：2021/5/10 23:00
import requests
from lxml import etree
import time
import os
import json

interval = 0.1
domain = 'http://www.stats.gov.cn'


# 获取url的dom对象
def get_request_dom(url):
    # 请求头和目标网址
    headers = {
        'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.117 Safari/537.36'
    }
    # 获取和解析网页
    print(url)
    r = requests.get(url, headers=headers)
    r.encoding = r.apparent_encoding
    return etree.HTML(r.text)


def get_shi_data(url, suffix):
    city_dom = get_request_dom(url)

    xpath_city = '//table[@class="citytable"]/tr[@class="citytr"]'

    citys = city_dom.xpath(xpath_city)

    for index in range(len(citys)):
        city = citys[index]

        shi_data = dict()

        childs = city.getchildren()
        shi_data['code'] = childs[0].getchildren()[0].text
        shi_data['name'] = childs[1].getchildren()[0].text

        print(shi_data)
        print(childs[0].getchildren()[0], type(childs[0].getchildren()[0]), dir(childs[0].getchildren()[0]))
        print(childs[0].getchildren()[0].xpath('a'))



def get_sheng_data(url, parent_data):
    province_dom = get_request_dom(url)

    xpath_province_link = '//table[@class="provincetable"]/tr[@class="provincetr"]/td/a/@href'
    xpath_province = '//table[@class="provincetable"]/tr[@class="provincetr"]/td/a/text()'

    province_links = province_dom.xpath(xpath_province_link)
    provinces = province_dom.xpath(xpath_province)

    for index in range(len(provinces)):
        province_link = province_links[index]
        province = provinces[index]

        sheng_data = dict()
        sheng_data['name'] = province
        sheng_data['code'] = province_link.split('.')[0] + '0000000000'
        print(sheng_data)
        shi_url = url.replace('index.html', province_link)
        get_shi_data(shi_url, province_link)
        break


if __name__ == '__main__':
    url = 'http://www.stats.gov.cn/tjsj/tjbz/tjyqhdmhcxhfdm/'
    dom = get_request_dom(url)

    xpath_year = '//div[@class="center_list"]/ul[@class="center_list_contlist"]/li/a/span/font[@class="cont_tit03"]/text()'
    xpath_release_year = '//div[@class="center_list"]/ul[@class="center_list_contlist"]/li/a/span/font[@class="cont_tit02"]/text()'
    xpath_link = '//div[@class="center_list"]/ul[@class="center_list_contlist"]/li/a/@href'

    years = dom.xpath(xpath_year)
    release_years = dom.xpath(xpath_release_year)
    links = dom.xpath(xpath_link)

    for index in range(len(years)):
        year = years[index]
        release_year = release_years[index]
        link = links[index]

        year_url = link
        if link.startswith('/'):
            year_url = domain + link

        data = dict()
        data['year'] = year
        data['release_year'] = release_year
        print(data)
        get_sheng_data(year_url, data)
        break
