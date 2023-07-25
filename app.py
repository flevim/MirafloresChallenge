# import main Flask class and request object
from flask import Flask, render_template, request, redirect, flash
from flask_wtf import Form 
from wtforms.fields import DateField
from datetime import datetime
from statistics import mean
import json
import re
import controlador

# create the Flask app
app = Flask(__name__)

@app.route("/guardar_dato", methods=["POST"])
def guardar_dato():
    fecha = request.form["fecha"]
    hora = request.form["hora"]
    humedad = request.form["humedad"]
    luz = request.form["luz"]
    controlador.insertar_dato(fecha, hora, humedad, luz)
        
    return redirect("/")

@app.route('/')
@app.route('/mediciones', methods=["GET", "POST"]) 
def mediciones():
    form = FechaForm()
    if request.method == "POST":
        fecha_inicio = request.form["dt"]
        fecha_fin = request.form["dt2"]
        mediciones = controlador.obtener_data_por_fecha(fecha_inicio, fecha_fin)
        return render_template('mediciones.html', form = form, mediciones = mediciones)
    
    
    mediciones = controlador.obtener_data()
    return render_template('mediciones.html', form = form, mediciones = mediciones)


@app.route("/eliminar_dato", methods=["POST"])
def eliminar_dato():
    controlador.eliminar_dato(request.form["id"])
    return redirect("/mediciones")

def obtener_mediciones_sensor(num_sensor, mediciones):
    return [medicion[num_sensor] for medicion in mediciones]

def obtener_prom_mediciones(mediciones): 
    prom_luz = round(mean(medicion[4] for medicion in mediciones), 4)
    prom_humedad = round(mean(medicion[3] for medicion in mediciones), 4)

    return prom_luz, prom_humedad

def decimal_to_hora_oficial(dec):
    hora = int(dec)
    minutos = round((dec - hora) * 60)
    hora_formato = f"{hora}:{minutos}"
    return hora_formato

@app.route("/general")
def general():
    mediciones = controlador.obtener_data()
    mediciones_luz = obtener_mediciones_sensor(4, mediciones)
    mediciones_humedad = obtener_mediciones_sensor(3, mediciones)

    prom_luz = round(mean(mediciones_luz), 4)
    prom_humedad = round(mean(mediciones_humedad),4)
    
    datapoints = []
    hora_oficial = []
    for medicion in mediciones: 
        hora = medicion[2].total_seconds() / 3600
        hora_oficial = decimal_to_hora_oficial(hora) 
        print(hora_oficial)
        datapoints.append({"x": hora, "y": medicion[4] ,  "z": medicion[3], "hora_oficial": hora_oficial })
    
    return render_template('general.html', 
                           mediciones=mediciones[:8],
                           datapoints=datapoints,
                           prom_luz=prom_luz, 
                           prom_humedad=prom_humedad,
                           )

class FechaForm(Form):
    dt = DateField('DatePicker', format='%Y-%m-%d')
    dt2 = DateField('DatePicker', format='%Y-%m-%d')


@app.route("/index_graficos")
def graficos():
    form = FechaForm()
    return render_template("index_graficos.html", form=form)
    

@app.route("/consulta_por_fecha", methods=["POST"])
def consulta_por_fecha():
    fecha_inicio = request.form["dt"]
    fecha_fin = request.form["dt2"]
    mediciones_por_fecha = controlador.obtener_data_por_fecha(fecha_inicio, fecha_fin)

    datapoints = []
    for medicion in mediciones_por_fecha: 
        hora = medicion[2].total_seconds() / 3600
        hora_oficial = decimal_to_hora_oficial(hora)
        datapoints.append({"x": hora, "y": medicion[4] ,  "z": medicion[3], "hora_oficial": hora_oficial }) 
    
    return render_template("renderizar_graficos.html", 
                           mediciones=mediciones_por_fecha,
                           datapoints=datapoints,
                           hora_oficial=hora_oficial,
                           )

if __name__ == '__main__':
    # run app in debug mode on port 5000
    app.run(debug=True, port=5000)