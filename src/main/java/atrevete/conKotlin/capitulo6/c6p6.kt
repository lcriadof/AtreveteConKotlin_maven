/*
Atrévete con Kotlin (libro en preparación) ISBN: 9798596367164
Autor: http://luis.criado.online/index.html
 */
package atrevete.conKotlin.capitulo6

// c6p6.kt
enum class Numero(val ValorDeLaconstante: Double) { //1
    pi( 3.1416), // 2
    e(2.7182818284)  // 3
}

fun main() {
    val num_pi= Numero.pi //4
    val num_e= Numero.e
    println(num_pi.ValorDeLaconstante) //5
    println(num_e.ValorDeLaconstante)

    // area del circulo es pi*r^2
    var num: Int
    println("Radio del circulo: ")
    num = readLine()?.toInt() as Int // 6
    var areaCirculo=num*num*num_pi.ValorDeLaconstante // 7
    println("El area de un círculo con radio "+num+" es "+areaCirculo)
}