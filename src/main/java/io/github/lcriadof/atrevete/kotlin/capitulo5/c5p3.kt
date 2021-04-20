/*
Atrévete con Kotlin ISBN: 9798596367164
Autor: http://luis.criado.online/index.html
 */
package io.github.lcriadof.atrevete.kotlin.capitulo5

fun main(){
    // programa c5p3.kt
    fun cuadrado(x:Int):Int{          //1
        return x*x                    //2
    }
    println( cuadrado(2).toString() )            // 3
    println( cuadrado(3).toString() )            // 4
    println( cuadrado(cuadrado(2)).toString() )  // 5
}