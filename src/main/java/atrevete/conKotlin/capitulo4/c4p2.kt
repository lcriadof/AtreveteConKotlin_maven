/*
Atrévete con Kotlin ISBN: 9798596367164
Autor: http://luis.criado.online/index.html
 */
package atrevete.conKotlin.capitulo4

import java.io.*

// programa p2.kt: guarda un fichero de texto
fun main() {
  File("/tmp/kotlin/f2.txt").writeText("¡Hola Mundo!")
}
