import tabula

pdfPath = '/Users/weishuangshuang/Downloads/国民经济行业分类.pdf'

df = tabula.read_pdf(pdfPath, pages='all', multiple_tables=True)
print(df)
# for indexs in df.index:
#     print(df.loc[indexs].values[1])