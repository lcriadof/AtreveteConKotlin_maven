/*
Atrévete con Kotlin (libro en preparación) ISBN: 9798596367164
Autor: http://luis.criado.online/index.html
 */
package atrevete.conKotlin.capitulo6.autor_ver3

// c6p1b.kt
fun main() {
    val at: Autor = Autor("Luis","Criado","Fernandez")  // 1
    println(at.Nombre+" "+at.apellido1+" "+at.apellido2+": "+at.getIniciales())  // 2
    at.apellido1="Abad"  // 3
    println(at.Nombre+" "+at.apellido1+" "+at.apellido2+": "+at.getIniciales())  // 4

}

// c6p1b.kt
class Autor (var Nombre:String,var apellido1:String, var apellido2:String){
    constructor (nom: String, ape1:String): this(nom, ape1,""){ }  // 5
    constructor (nom: String): this(nom, "",""){ }           // 6
    fun getIniciales():String{     // 7
         return Nombre.subSequence(0,1).toString()+
                apellido1.subSequence(0,1).toString()+
                apellido2.subSequence(0,1).toString()
    }
}// fin de clase

