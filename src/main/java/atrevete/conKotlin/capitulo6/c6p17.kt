/*
Atrévete con Kotlin (libro en preparación) ISBN: 9798596367164
Autor: http://luis.criado.online/index.html
 */
package atrevete.conKotlin.capitulo6

// alias de una clase
typealias inicializarVal = RetrasarInicializacionParametrosVal


fun main() {
    println("Valor para inicializar: ")
    val num = readLine()?.toInt() as Int  // 3

    var o=inicializarVal(num) // 4
    println("[numero] es "+o.numero) // 5
    o.numero=num*2 // 6
    println("[numero] es "+o.numero) // 7
    println("[cte1] es "+o.cte1+" (inicializada tardiamente con lazy)") // 8

}