import pymysql

def obtener_conexion():
    return pymysql.connect(host='localhost',
                                user='root',
                                password='fib0nacci',
                                db='mirch_db')

                        