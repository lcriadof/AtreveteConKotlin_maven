/*
Atrévete con Kotlin (libro en preparación) ISBN: 9798596367164
Autor: http://luis.criado.online/index.html
 */
package atrevete.conKotlin.capitulo4
// c4p9.kt

// esto es un objeto estático puente para permitir que desde kotlin
// se pueda acceder a los recursos del proyecto maven
object recursos { // 1
    fun main() {} // 2
}

fun main() {
    val fichero="/HolaMundo/hola.html" // 3
    val pathAbsoluto = recursos::class.java.getResource(fichero).toURI()  // 4
    println("Recurso en: "+pathAbsoluto)

    val fileContent = recursos::class.java.getResource(fichero).readText()  // 5
    println("\nContenido: \n"+fileContent)
}
