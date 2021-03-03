/*
Atrévete con Kotlin (libro en preparación) ISBN: 9798596367164
Autor: http://luis.criado.online/index.html
 */
package atrevete.conKotlin.capitulo5

fun main(){
    // programa c5p9.kt, función infix  extendida de String
    infix fun String.delString(cadena: String):String { //1
        var s:String=this                               // 2
        s=s.replace(cadena,"")                  // 3
        return s
    }
    var nombre:String="Luis Criado Fernández"     //4
    println(nombre)                               // 5
    nombre=nombre delString "Luis"   // 6
    println(nombre)                  // 7
}