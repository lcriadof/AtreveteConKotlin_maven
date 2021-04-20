/*
Atrévete con Kotlin (libro en preparación) ISBN: 9798596367164
Autor: http://luis.criado.online/index.html
 */
package io.github.lcriadof.atrevete.kotlin.capitulo8

import java.sql.Connection
import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.SQLException
import io.github.lcriadof.atrevete.conKotlin.capitulo8.*
import kotlin.collections.HashMap

fun main(){
    var sql=sqlite()
    var url:String
    var insert:String

/*
    url = "/tmp/kotlin/estrellas.db"
    sql.conectar(url)
    sql.campos("clasificacion_harvard")
    println(sql.gCampos())

    println("lanzando select...")
    sql.leer("clasificacion_harvard","Clase=\"B\"")
    println(sql.leer("clasificacion_harvard"))

    insert="INSERT INTO clasificacion_harvard (Clase, Temperatura, Color_convencional, Color_aparente)\n" +
            "VALUES (\"K\", 3700, \"naranja\", \"anaranjado\");"
    sql.escribir(insert)
    sql.desconectar()
*/

    println("\n\n---- SIN filtrando")
    url = "/tmp/kotlin/base_7.db"
    sql.conectar(url)
    sql.campos("dictionary")
    println(sql.gCampos())
    println(sql.leer("dictionary"))
    sql.desconectar()




}





// clase Sqlite hereda del Interface bbdd
class sqlite(): basedatos() {

    override fun conectar(url:String){
        try {
            conexion = DriverManager.getConnection("jdbc:sqlite:$url") // si no existe la bd la crea
            if (conexion != null) {
                println("Conectado: " + conexion?.metaData)
            } // fin de if
        } catch (ex: SQLException) {
            println("Problemas al acceder a disco")
        }
    }


    override fun campos(tabla:String){
        this.estructura("pragma table_info("+tabla+");","name","type")
    }


    private fun estructura(consulta: String,vararg buscarCampo:String) = try {
         val st = conexion?.prepareStatement(consulta)
         var name:String=""
         var type:String=""
         var resultado: ResultSet? = null

         // si hubiese campos previos de otras tablas las borramos para evitar errores
           deleteCampos()

         resultado = st?.executeQuery()
         var n=0
         while (resultado?.next()!!) {
             n++
             name = resultado?.getString("name").toString()
             type=resultado?.getString("type").toString()

             if (type.contains("INT") || type.contains("NUMERIC") ){
                 type="NUM"
             }
             if (type.contains("VARCHAR") || type.contains("TEXT")){
                 type="TEX"
             }
             items.set( name,type)
             campos.add(name)
        } /* fin de while */

     } catch (ex: SQLException) {
         println("Problemas al acceder a disco")
     } // fin de metodo


} // fin de clase sqlite

