/*
Atrévete con Kotlin ISBN: 9798596367164
Autor: http://luis.criado.online/index.html
 */
// c6p9.kt
package atrevete.conKotlin.capitulo6
import kotlin.collections.HashMap

interface ficheros { // 1
    fun usar()
    fun leer():String
    fun <T>agregar(vararg cadena:T):Boolean // 2
    fun borrarFichero():Boolean
    fun borrarTodoElContenido():Boolean
}