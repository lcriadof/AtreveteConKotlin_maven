/*
Atrévete con Kotlin (libro en preparación) ISBN: 9798596367164
Autor: http://luis.criado.online/index.html
 */
package io.github.lcriadof.atrevete.kotlin.capitulo7.fichero.xml// example from https://bezkoder.com/kotlin-xml-json/

import org.json.JSONTokener
import org.json.XML
import java.io.File


fun main() {
    val PRETTY_PRINT_INDENT_FACTOR = 2

    val xmlStr = """
  	<Author>
	   <address>
	      <street>Internet Broadline</street>
	      <postcode>123456</postcode>
	   </address>
	   <name>bezkoder</name>
	   <age>26</age>
	</Author>
  """
    // volcamos el fichero XML a disco
    File("/tmp/kotlin/f4.xml").writeText(xmlStr)  // escribimos XML en disco


    val jsonObj = XML.toJSONObject(xmlStr)  // Creamos un objeto JSON a partir de XML

    val jsonPrettyPrintString = jsonObj.toString(PRETTY_PRINT_INDENT_FACTOR) // tabulamos JSON
    println(jsonPrettyPrintString) // salida en JSON por pantalla
    File("/tmp/kotlin/f4.json").writeText(jsonPrettyPrintString)  // escribimos JSO en disco

    // tokenizamos, no se para que puyede servir
    val jt = JSONTokener(jsonObj.toString(PRETTY_PRINT_INDENT_FACTOR))
    while (jt.more()) {
        println(jt.next())
    }

    //
    println(jsonObj.get("Author"))

    val jsonMatriz = jsonObj.keys()


    println(jsonMatriz)
    for (i in jsonMatriz){
        println(jsonMatriz)
    }
    /*
    for (i in 0..jsonMatriz.length()-1){
        println(jsonMatriz[i])
    }*/

}

