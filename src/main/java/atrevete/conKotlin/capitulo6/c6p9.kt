/*
Atrévete con Kotlin (libro en preparación) ISBN: 9798596367164
Autor: http://luis.criado.online/index.html
 */
// c6p9.kt
package atrevete.conKotlin.capitulo6
import kotlin.collections.HashMap

interface ficheros { // 1
    fun abrir():Boolean
    fun leer():String
    fun <T>agregar(cadena: T):Boolean // 2
    fun borrarFichero():Boolean
    fun borrarTodoElContenido():Boolean
    fun cerrar():Boolean
}