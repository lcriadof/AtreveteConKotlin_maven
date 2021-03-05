/*
Atrévete con Kotlin ISBN: 9798596367164
Autor: http://luis.criado.online/index.html
 */
package atrevete.conKotlin.capitulo5

fun main(){
    // programa c5p4.kt
    fun cuadrado(x:Int):Int{
        return x*x
    }
    var antes:Int=2   // 1
    var despues:Int  // 2
    for(x in 1..5){       // 3
        despues=cuadrado(antes)                         // 4
        println( "el cuadrado de "+antes+" es "+despues )  // 5
        antes=despues
    }
    /* numero máximo Int
     despues=2147483647
     println( "el cuadrado de "+antes+" es "+despues )  */

}