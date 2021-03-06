/*
Atrévete con Kotlin ISBN: 9798596367164
Autor: http://luis.criado.online/index.html
 */
package io.github.lcriadof.atrevete.kotlin.capitulo4

import java.io.File
import java.net.URL

// c4p8.kt - descargar un fichero desde una URL
fun main() {
    // variables para definir el nombre del fichero local y el directorio
    var directorioBase:String="/tmp/kotlin/"
    var nombreFicheroOut:String="portada_segundos.jpg"

    // proceso de descarga
    val fuente = URL("http://luis.criado.online/cv/imagenes/segundos.jpg")  // 1
    val destino = File(directorioBase, nombreFicheroOut)  // 2
    destino.writeBytes(fuente.readBytes()) // 3

}// fin de cap4.cap4.cap5.cap6.cap7.cap8.atrevete.conKotlin.capitulo8.bdr.mysql.atrevete.conKotlin.capitulo8.nosql.redis.atrevete.conKotlin.capitulo8.bdr.sqlite.main
