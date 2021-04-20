/*
Atrévete con Kotlin (libro en preparación) ISBN: 9798596367164
Autor: http://luis.criado.online/index.html
 */
package io.github.lcriadof.atrevete.kotlin.capitulo7.fichero.json

import com.google.gson.Gson
import java.io.File

// https://medium.com/@hissain.khan/parsing-with-google-gson-library-in-android-kotlin-7920e26f5520

fun main(){
    val s = Student("Alex", "Rome, 1500") // instance



     val s2 = Gson().toJson(s) // String con Json
    println(s2)
    File("/tmp/kotlin/f4.json").writeText(s2)


     val estudiante = Gson().fromJson(s2, Student::class.java) //volcamos el Json a un objeto de clase Studen

    println(estudiante.address)

}

data class Student (
        var name: String? = null,
        var address: String? = null) {
}
