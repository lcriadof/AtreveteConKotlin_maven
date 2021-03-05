/*
Atrévete con Kotlin ISBN: 9798596367164
Autor: http://luis.criado.online/index.html
 */
package atrevete.conKotlin.capitulo5

fun main() {
    val cubo:(Int) -> Int = { num:Int -> num*num*num } // 1
    val cubo2:(Int) -> Int = { num -> num*num*num }    // 2
    val cubo3 = { num:Int -> num*num*num }    // 3
//  val cubo4 = { num -> num*num*num  }                // 4
    println(cubo(3))
    println(cubo2(3))
    println(cubo3(3))
}






