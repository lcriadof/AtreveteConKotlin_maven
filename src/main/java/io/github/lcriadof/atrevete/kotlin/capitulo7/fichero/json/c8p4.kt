/*
Atrévete con Kotlin (libro en preparación) ISBN: 9798596367164
Autor: http://luis.criado.online/index.html
 */
package io.github.lcriadof.atrevete.kotlin.capitulo7.fichero.json// https://es.ourcodeworld.com/articulos/leer/126/como-trabajar-con-json-facilmente-en-java
import org.json.JSONObject


// crear un JSON desde código kotlin
fun main() {
    val PRETTY_PRINT_INDENT_FACTOR = 2
    val myObject = JSONObject()

    // Cadenas de texto básicas
    myObject.put("nombre", "Luis")
    myObject.put("apellido", "Criado")
    myObject.put("nombre", "Belén")
    myObject.put("apellido", "Fernández")

    // Valores primitivos
    myObject.put("edad", 53)
    myObject.put("saldo", 20.2f);
    myObject.put("desarrollador", true);

      // Matrices
    val myList = doubleArrayOf(1.9, 2.9, 3.4, 3.5)
    myObject.put("numeros_list", myList)

    // otro tipo de matriz con diferentes tipos de datos
    val jo = JSONObject()
    jo.put("name", "jon doe")
    jo.put("age", 2)
    jo.put("saldo", 200f)
    jo.put("city", "chicago")
    myObject.put("submatriz", jo)

    // Objeto dentro de objeto
    val subdata = JSONObject()
    myObject.put("extra_data", subdata)

    // Generar cadena de texto JSON
    println(myObject);

    // ver por pantalla todo el JSON formateado
    val jsonPrettyPrintString = myObject.toString(PRETTY_PRINT_INDENT_FACTOR) // tabulamos JSON
    println(jsonPrettyPrintString);



    println(myObject.get("edad"))
    println(myObject.get("nombre"))
    


}