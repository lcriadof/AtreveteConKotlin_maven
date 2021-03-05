/*
Atrévete con Kotlin ISBN: 9798596367164
Autor: http://luis.criado.online/index.html
 */
package atrevete.conKotlin.capitulo5

fun main(){
    // programa c5p11.kt, función extendida
    fun Int.elevado(potencia:Int):Int {  // 1
        var salida:Int=1
        for (x in 1..potencia){         // 2
            salida =salida*this         // 3
        }
        return salida
    }
    var num:Int=8; var elev:Int=5       // 4
    println( "$num elevado a $elev es: "+num.elevado(elev) )  // 5
    num=3; elev=4
    println( "$num elevado a $elev es: "+num.elevado(elev) )  // 6
}