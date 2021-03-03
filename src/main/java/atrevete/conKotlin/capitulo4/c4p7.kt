/*
Atrévete con Kotlin (libro en preparación) ISBN: 9798596367164
Autor: http://luis.criado.online/index.html
 */
package atrevete.conKotlin.capitulo4

import java.io.*
import java.lang.Exception
// c4p7.kt: copiar un fichero en otro
//   orden copy
fun main( args: Array<String>  ) {                    // 1
    val origen:String="/tmp/kotlin/"+args[0]  // 2
    val destino:String="/tmp/kotlin/"+args[1]  // 3
    if (File(destino).exists()) {                     // 4
        File(destino).delete()                        // 5
    }

    try {
        File(origen).copyTo(File(destino))
        println("Se ha copiado $origen en $destino")
    } catch (e: Exception) {
        println(e)
    }
}