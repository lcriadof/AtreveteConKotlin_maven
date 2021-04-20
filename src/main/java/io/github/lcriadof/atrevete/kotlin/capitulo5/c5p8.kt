/*
Atrévete con Kotlin ISBN: 9798596367164
Autor: http://luis.criado.online/index.html
 */
package io.github.lcriadof.atrevete.kotlin.capitulo5

fun main(){
    // programa c5p8.kt, función infix extendida de Int
    infix fun Int.multiplicado(x: Int): Int { return this*x}  //1
    println(7 multiplicado 2)  // 2
    println(7.multiplicado(2)) // 3
}