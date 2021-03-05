/*
Atrévete con Kotlin ISBN: 9798596367164
Autor: http://luis.criado.online/index.html
 */
package atrevete.conKotlin.capitulo5

fun main(){
    // programa c5p6.kt, función varargs
    fun suma(vararg numerosEntrada:Int):Int{   // 1
        var acumunlador:Int=0                  // 2
        for (i in numerosEntrada){             // 3
            acumunlador= i + acumunlador       // 4
        }
        return acumunlador
    }

    println( "La suma es "+suma(2,4,6,20) )   // 5
}