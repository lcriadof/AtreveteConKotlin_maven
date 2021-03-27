/*
Atrévete con Kotlin (libro en preparación) ISBN: 9798596367164
Autor: http://luis.criado.online/index.html
 */
package atrevete.conKotlin.capitulo7.fichero.properties

import java.io.FileOutputStream
import java.lang.Exception
import java.util.*

fun main(){


    try {
        val directorioRaiz:String="/tmp/kotlin/"

        val prop = Properties()
        val f= FileOutputStream(directorioRaiz+"oracleBITver2.properties")

        prop.put("instancia.ip","192.168.1.101")
        prop.store(f,"config acceso a BBDD")


    }catch (e: Exception) {
        println(e)
    }

}
