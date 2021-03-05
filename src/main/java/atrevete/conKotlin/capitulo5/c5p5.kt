/*
Atrévete con Kotlin ISBN: 9798596367164
Autor: http://luis.criado.online/index.html
 */
package atrevete.conKotlin.capitulo5

fun main(){
    // programa c5p5.kt, función con parámetro por defecto
    fun cuadrado(x:Int=2):Int{   // 1
        return x*x
    }
    var num:Int=9
    var calculo:Int
    println( "el cuadrado de "+num+" es "+cuadrado(num) )
    println( "el cuadrado del valor por defecto es "+cuadrado() )
}