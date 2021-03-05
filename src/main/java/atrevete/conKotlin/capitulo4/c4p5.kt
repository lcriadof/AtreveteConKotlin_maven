/*
Atrévete con Kotlin ISBN: 9798596367164
Autor: http://luis.criado.online/index.html
 */
package atrevete.conKotlin.capitulo4

import java.io.File
import java.lang.Exception
// programa c4p5.kt: contar lineas de un fichero de texto y lo muestra por pantalla
fun main() {
    var contar=0
    try {
        File("/tmp/kotlin/f3.txt").forEachLine { contar++ }  // 1
        println("El fichero tiene $contar líneas")                    // 2
    } catch (e: Exception) {
        println(e)
    }
}