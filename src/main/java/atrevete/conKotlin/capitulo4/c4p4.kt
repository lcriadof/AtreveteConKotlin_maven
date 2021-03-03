/*
Atrévete con Kotlin (libro en preparación) ISBN: 9798596367164
Autor: http://luis.criado.online/index.html
 */
package atrevete.conKotlin.capitulo4

import java.io.File

// programa c4p4.kt: lee un fichero de texto y lo muestra por pantalla
fun main() {


    // primera versión
    val lines = File("/tmp/kotlin/f3.txt").readLines()  // 2 codigo equivalente

    for (item in lines) {
        println("linea: $item")
    }
/*
    // segunda versión
    val lines = File("/tmp/kotlin/f3.txt").readLines()  // 2 codigo equivalente
    lines.forEach { println(it) }

    // tercera versión
    File("/tmp/kotlin/f3.txt").forEachLine { println(it) }  //1

    // cuarta versión
    try {
        File("/tmp/kotlin/f3.txt").forEachLine { println(it) }  //1
    }catch (e: Exception){
        println(e)
    }
*/


} // fin del programa