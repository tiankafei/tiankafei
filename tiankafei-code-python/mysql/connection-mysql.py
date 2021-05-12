import pymysql.cursors

# Connect to the database
connection = pymysql.connect(host='127.0.0.1',
                             user='root',
                             password='tiankafei',
                             database='db-ry-cloud',
                             cursorclass=pymysql.cursors.DictCursor)

print(connection)
print(type(connection))
print(dir(connection))

with connection:
    # 增删改操作demo
    with connection.cursor() as cursor:
        # Create a new record
        sql = "INSERT INTO `users` (`email`, `password`) VALUES (%s, %s)"
        cursor.execute(sql, ('webmaster@python.org', 'very-secret'))

    # connection is not autocommit by default. So you must commit to save
    # your changes.
    connection.commit()

    # 查询操作demo
    with connection.cursor() as cursor:
        # Read a single record
        sql = "SELECT `id`, `password` FROM `users` WHERE `email`=%s"
        cursor.execute(sql, ('webmaster@python.org',))
        result = cursor.fetchone()
        print(result)