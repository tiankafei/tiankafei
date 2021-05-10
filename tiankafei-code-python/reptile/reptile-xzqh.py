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
file_directory = 'D:\data'


# 获取url的dom对象
def get_request_dom(url):
    # 请求头和目标网址
    headers = {
        'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.117 Safari/537.36'
    }
    time.sleep(interval)
    # 获取和解析网页
    print(url)
    r = requests.get(url, headers=headers)
    r.encoding = r.apparent_encoding
    return etree.HTML(r.text)


def get_jc_data(url):
    city_dom = get_request_dom(url)

    xpath_village = '//table[@class="villagetable"]/tr[@class="villagetr"]'

    villages = city_dom.xpath(xpath_village)

    data = []
    for index in range(len(villages)):
        village = villages[index]

        jc_data = dict()

        childs = village.getchildren()
        jc_data['code'] = childs[0].text
        jc_data['cxfldm'] = childs[1].text
        jc_data['name'] = childs[2].text
        data.append(jc_data)
    return data


def get_xz_data(url, suffix):
    city_dom = get_request_dom(url)

    xpath_town = '//table[@class="towntable"]/tr[@class="towntr"]'

    towns = city_dom.xpath(xpath_town)

    data = []
    for index in range(len(towns)):
        town = towns[index]

        xz_data = dict()

        childs = town.getchildren()
        xz_data['code'] = childs[0].getchildren()[0].text
        xz_data['name'] = childs[1].getchildren()[0].text
        href = childs[0].getchildren()[0].get("href")
        tmp_url = url.replace(suffix.split('/')[-1], '')
        xz_url = tmp_url + href
        xz_data['sub'] = get_jc_data(xz_url)
        data.append(xz_data)
    return data


def get_qx_data(url, suffix):
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
            href = childs[0].getchildren()[0].get("href")
            tmp_url = url.replace(suffix.split('/')[-1], '')
            xz_url = tmp_url + href
            qx_data['sub'] = get_xz_data(xz_url, href)
            data.append(qx_data)
        else:
            qx_data['code'] = childs[0].text
            qx_data['name'] = childs[1].text
            data.append(qx_data)
    return data


def write_path(file_path, file_name, data):
    f = open(os.path.join(file_path, file_name), 'w', encoding='utf-8')
    f.write(json.dumps(data, indent=2, ensure_ascii=False))
    f.close()


def get_shi_data(url, suffix, year_data, sheng_data):
    city_dom = get_request_dom(url)
    time.sleep(interval * 5)

    xpath_city = '//table[@class="citytable"]/tr[@class="citytr"]'

    citys = city_dom.xpath(xpath_city)

    for index in range(len(citys)):
        city = citys[index]

        shi_data = dict()

        childs = city.getchildren()
        shi_data['code'] = childs[0].getchildren()[0].text
        shi_data['name'] = childs[1].getchildren()[0].text
        href = childs[0].getchildren()[0].get("href")
        qx_url = url.replace(suffix, href)

        year_name = year_data['year']
        year_path = os.path.join(file_directory, year_name)

        sheng_name = sheng_data['code'] + '(' + sheng_data['name'] + ')'
        sheng_path = os.path.join(year_path, sheng_name)

        shi_name = shi_data['code'] + '(' + shi_data['name'] + ')'
        shi_path = os.path.join(sheng_path, shi_name)
        if os.path.exists(shi_path):
            continue
        else:
            os.makedirs(shi_path)

        write_path(shi_path, (year_name + '.json'), year_data)
        write_path(shi_path, (sheng_name + '.json'), sheng_data)
        qx_data = get_qx_data(qx_url, href)
        write_path(shi_path, (shi_name + '.json'), qx_data)


def get_sheng_data(url, year_data):
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
        shi_url = url.replace('index.html', province_link)
        get_shi_data(shi_url, province_link, year_data, sheng_data)


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
        get_sheng_data(year_url, data)
        time.sleep(interval * 10)