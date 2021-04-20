/*
Atrévete con Kotlin ISBN: 9798596367164
Autor: http://luis.criado.online/index.html
 */
package io.github.lcriadof.atrevete.kotlin.capitulo5

// c5p13.kt  algunos ejemplos de funciones lambda
fun main() {
    val sum = {a: Int , b: Int -> a + b}   //1
    val sumProgAritmetica = {a1:Int, an: Int , n: Int -> (a1+an)*(n/2)}  //2
    val siguienteProgAritmetica = {aj:Int, ak: Int -> (ak-aj)+(ak)}   //3
    println(sum(3,4))                       //4
    println(sumProgAritmetica(1,100,100))   //5
    println(siguienteProgAritmetica(7,21))  // 6
}

