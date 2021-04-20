/*
Atrévete con Kotlin (libro en preparación) ISBN: 9798596367164
Autor: http://luis.criado.online/index.html
 */
package io.github.lcriadof.atrevete.kotlin.capitulo7.fichero.properties
import java.io.FileInputStream
import java.lang.Exception
import java.util.*

fun main(){


    try {
        val directorioRaiz:String="/tmp/kotlin/"

        val prop = Properties()
        val f=FileInputStream(directorioRaiz+"oracleBITver2.properties")
        prop.load(f)  // cargamos el fichero de propiedades
       
        val ip:String?=prop.getProperty("instancia.ip")
        val puerto:String?=prop.getProperty("instancia.puerto")
        val nombre:String?=prop.getProperty("instancia.nombre")
        val usuario:String?=prop.getProperty("usuario.nombre")
        val clave:String?=prop.getProperty("usuario.clave")

        println("Instancia a BBDD: $nombre    $ip:$puerto")
        println("  usuariao: $usuario clave:$clave")
    }catch (e: Exception) {
        println(e)
    }

}
