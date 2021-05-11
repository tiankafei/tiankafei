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
file_directory = 'D:\data\catalogs'


# 获取url的dom对象
def get_request_dom(url):
    try:
        # 请求头和目标网址
        headers = {
            'user-agent': 'Mozilla/5.0 (Windows NT 6.1; WOW64) '
                          'AppleWebKit/537.36 (KHTML, like Gecko) '
                          'Chrome/58.0.3029.110 Safari/537.36 SE 2.X MetaSr 1.0'
        }
        time.sleep(interval)
        # 获取和解析网页
        print(url)
        r = requests.get(url, headers=headers)
        r.encoding = r.apparent_encoding
        return etree.HTML(r.text)
    except:
        # 如果抛出异常，休眠5秒继续
        time.sleep(5)
        get_request_dom(url)


def get_catalog_item3_data(url):
    city_dom = get_request_dom(url)

    xpath_village = '//table[@class="villagetable"]/tr[@class="villagetr"]'

    villages = city_dom.xpath(xpath_village)

    data = []
    for index in range(len(villages)):
        village = villages[index]

        jc_data = dict()

        childs = village.getchildren()
        jc_data['code'] = childs[0].text
        jc_data['name'] = childs[1].text
        if len(childs) > 2:
            jc_data['description'] = childs[2].text
        data.append(jc_data)
    return data


def get_catalog_item2_data(url, suffix):
    tmp_data = get_catalog_item3_data(url)
    if tmp_data:
        return tmp_data

    city_dom = get_request_dom(url)

    xpath_town = '//table[@class="towntable"]/tr[@class="towntr"]'

    towns = city_dom.xpath(xpath_town)

    data = []
    for index in range(len(towns)):
        town = towns[index]

        xz_data = dict()

        childs = town.getchildren()
        if childs[0].getchildren():
            xz_data['code'] = childs[0].getchildren()[0].text
            xz_data['name'] = childs[1].getchildren()[0].text
            if len(childs) > 2:
                xz_data['description'] = childs[2].getchildren()[0].text
            href = childs[0].getchildren()[0].get("href")
            tmp_url = url.replace(suffix.split('/')[-1], '')
            xz_url = tmp_url + href
            xz_data['sub'] = get_catalog_item3_data(xz_url)
        else:
            xz_data['code'] = childs[0].text
            xz_data['name'] = childs[1].text
            if len(childs) > 2:
                xz_data['description'] = childs[2].text
        data.append(xz_data)
    return data


def get_catalog_item1_data(url, suffix):
    tmp_data = get_catalog_item3_data(url)
    if tmp_data:
        return tmp_data

    city_dom = get_request_dom(url)

    xpath_county = '//table[@class="countytable"]/tr[@class="countytr"]'

    countys = city_dom.xpath(xpath_county)

    data = []
    for index in range(len(countys)):
        county = countys[index]

        qx_data = dict()

        childs = county.getchildren()
        if childs[0].getchildren():
            qx_data['code'] = childs[0].getchildren()[0].text
            qx_data['name'] = childs[1].getchildren()[0].text
            if len(childs) > 2:
                qx_data['description'] = childs[2].getchildren()[0].text
            href = childs[0].getchildren()[0].get("href")
            tmp_url = url.replace(suffix.split('/')[-1], '')
            xz_url = tmp_url + href
            qx_data['sub'] = get_catalog_item2_data(xz_url, href)
        else:
            qx_data['code'] = childs[0].text
            qx_data['name'] = childs[1].text
            if len(childs) > 2:
                qx_data['description'] = childs[2].text
        data.append(qx_data)
    return data


def write_path(file_path, data):
    f = open(file_path, 'w', encoding='utf-8')
    f.write(json.dumps(data, indent=2, ensure_ascii=False))
    f.close()


def get_catalog_item_data(url):
    tmp_data = get_catalog_item3_data(url)
    if tmp_data:
        return tmp_data

    city_dom = get_request_dom(url)

    xpath_city = '//table[@class="citytable"]/tr[@class="citytr"]'

    citys = city_dom.xpath(xpath_city)

    data = []
    for index in range(len(citys)):
        city = citys[index]

        catalog_item_data = dict()

        childs = city.getchildren()
        if childs[0].getchildren():
            catalog_item_data['code'] = childs[0].getchildren()[0].text
            catalog_item_data['name'] = childs[1].getchildren()[0].text
            if len(childs) > 2:
                catalog_item_data['description'] = childs[2].getchildren()[0].text
            href = childs[0].getchildren()[0].get("href")
            tmp_url = url.replace(url.split('/')[-1], '')
            sub_url = tmp_url + href
            sub_data = get_catalog_item1_data(sub_url, href)
            catalog_item_data['sub'] = sub_data
        else:
            catalog_item_data['code'] = childs[0].text
            catalog_item_data['name'] = childs[1].text
            if len(childs) > 2:
                catalog_item_data['description'] = childs[2].text
        data.append(catalog_item_data)
    return data


def get_catalog_list():
    urls = []
    urls.append('http://www.stats.gov.cn/tjsj/tjbz/tjypflml/')
    urls.append('http://www.stats.gov.cn/tjsj/tjbz/tjypflml/index_1.html')
    urls.append('http://www.stats.gov.cn/tjsj/tjbz/tjypflml/index_2.html')
    urls.append('http://www.stats.gov.cn/tjsj/tjbz/tjypflml/index_3.html')
    urls.append('http://www.stats.gov.cn/tjsj/tjbz/tjypflml/index_4.html')

    catalogs = []

    for url in urls:
        xpath_text = '//div[@class="center_list"]/ul[@class="center_list_contlist"]/li/a/span/font[@class="cont_tit03"]/text()'
        xpath_release_year = '//div[@class="center_list"]/ul[@class="center_list_contlist"]/li/a/span/font[@class="cont_tit02"]/text()'
        xpath_link = '//div[@class="center_list"]/ul[@class="center_list_contlist"]/li/a/@href'

        dom = get_request_dom(url)

        texts = dom.xpath(xpath_text)
        release_years = dom.xpath(xpath_release_year)
        links = dom.xpath(xpath_link)

        for index in range(len(texts)):
            text = texts[index]
            release_year = release_years[index]
            link = links[index]

            catalog_url = link
            if link.startswith('/'):
                catalog_url = domain + link

            data = dict()
            data['text'] = text
            data['release_year'] = release_year
            data['link'] = catalog_url
            catalogs.append(data)
    return catalogs


if __name__ == '__main__':
    catalgos = get_catalog_list()
    for catalog in catalgos:
        catalog_path = os.path.join(file_directory, catalog['text'])
        if os.path.exists(catalog_path):
            pass
        else:
            os.makedirs(catalog_path)

        file_path = os.path.join(catalog_path, (catalog['text'] + '.json'))
        if os.path.exists(file_path):
            continue

        catalog_item_data = get_catalog_item_data(catalog['link'])
        write_path(file_path, catalog_item_data)
