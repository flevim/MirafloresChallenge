from bd_connection import obtener_conexion


def insertar_dato(fecha, hora, humedad, luz):
    conexion = obtener_conexion()
    with conexion.cursor() as cursor:
        cursor.execute("INSERT INTO mirch(fecha, hora, humedad, luz) VALUES (%s, %s, %s, %s)",
                       (fecha, hora, humedad, luz))
    conexion.commit()
    conexion.close()


def obtener_data():
    conexion = obtener_conexion()
    mediciones = []
    with conexion.cursor() as cursor:
        cursor.execute("SELECT id_dato, fecha, hora, humedad, luz FROM mirch ORDER BY fecha DESC")
        mediciones = cursor.fetchall()
    conexion.close()
    return mediciones


def eliminar_dato(id):
    conexion = obtener_conexion()
    with conexion.cursor() as cursor:
        cursor.execute("DELETE FROM mirch WHERE id_dato = %s", (id,))
    conexion.commit()
    conexion.close()


def obtener_data_por_fecha(fecha_inicio, fecha_fin):
    conexion = obtener_conexion()
    with conexion.cursor() as cursor:
        cursor.execute(
            "SELECT id_dato, fecha, hora, humedad, luz FROM mirch WHERE fecha BETWEEN %s AND %s", (fecha_inicio, fecha_fin))
        
        mediciones = cursor.fetchall()
    conexion.close()
    return mediciones

""""
def actualizar_juego(nombre, descripcion, precio, id):
    conexion = obtener_conexion()
    with conexion.cursor() as cursor:
        cursor.execute("UPDATE juegos SET nombre = %s, descripcion = %s, precio = %s WHERE id = %s",
                       (nombre, descripcion, precio, id))
    conexion.commit()
    conexion.close()
"""