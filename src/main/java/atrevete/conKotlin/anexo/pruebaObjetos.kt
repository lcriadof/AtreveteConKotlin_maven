/*
Atrévete con Kotlin (libro en preparación) ISBN: 9798596367164
Autor: http://luis.criado.online/index.html
 */
package atrevete.conKotlin.anexo

object Singleton {
    var contador:Int=0
    init{ println("objeto creado")  }
}

fun main(){

    var o= Singleton
    o.contador=5
    println(o.contador)
    var o2= Singleton
    println(o2.contador)
    o.contador=6
    var o3= Singleton
    println(o3.contador)

}