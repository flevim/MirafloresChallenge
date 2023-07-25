import pymysql

def obtener_conexion():
    return pymysql.connect(host='localhost',
                                user='root',
                                password='Rkrpi3swyZ?',
                                db='mirch_db')

                        