/*
Atrévete con Kotlin ISBN: 9798596367164
Autor: http://luis.criado.online/index.html
 */
// c6p9.kt
package io.github.lcriadof.atrevete.kotlin.capitulo6

interface ficheros { // 1
    fun usar()
    fun leer():String
    fun <T>agregar(vararg cadena:T):Boolean // 2
    fun borrarFichero():Boolean
    fun borrarTodoElContenido():Boolean
}