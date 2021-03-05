/*
Atrévete con Kotlin ISBN: 9798596367164
Autor: http://luis.criado.online/index.html
 */
package atrevete.conKotlin.capitulo5

fun main(){
    // programa c5p10.kt, función extendida
    fun String.delSpace():String {               // 1
        var s:String=this                        // 2
        for (x in this){
            s=s.replace("  "," ") // 3
        }
        return s
    }
    var nombre:String="Luis     Criado    Fernández   Abad   "                // 4
    println("La cadena [$nombre] tiene una longitud de "+nombre.length+" caracteres")  // 5
    nombre=nombre.delSpace()                                                           // 6
    println(" y .... aplicando el método delSapce()")
    println("La cadena [$nombre] tiene una longitud de "+nombre.length+" caracteres")  // 7
}