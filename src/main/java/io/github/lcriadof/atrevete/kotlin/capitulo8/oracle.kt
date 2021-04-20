/*
Atrévete con Kotlin (libro en preparación) ISBN: 9798596367164
Autor: http://luis.criado.online/index.html
 */
package io.github.lcriadof.atrevete.kotlin.capitulo8



import io.github.lcriadof.atrevete.conKotlin.capitulo8.basedatos
import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.SQLException
import java.sql.Statement


fun main() {
    var sql = oracle("TARIFAS","TARIFAS2019")
    var url: String
    var insert: String


    url = "jdbc:oracle:thin:@192.168.56.101:1521:xe"  //  this.connectionURL="jdbc:oracle:thin:@"+ipmaquina+":"+puerto+":"+instancia;

    sql.conectar(url)
    sql.campos("ait_ctipostitulo")
    println(sql.gCampos())
    sql.leer("ait_ctipostitulo")
}



// clase Sqlite hereda del Interface bbdd
class oracle(var userName:String, var passwd:String): basedatos() {
    //var stmt: Statement? = null


    override fun conectar(url:String){
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conexion = DriverManager.getConnection(url, userName, passwd);
            stmt=conexion?.createStatement()
            if (conexion != null) {
                println("Conectado: " + conexion?.metaData)
            } // fin de if
        } catch (ex: SQLException) {
            println("Problemas al acceder a disco")
        }
    }



    override fun campos(tabla:String){
       // this.estructura("select column_name, data_length, data_type from all_tab_columns where table_name = '"+tabla+"';","column_name","data_type")
        val consulta="SELECT * FROM ALL_TAB_COLUMNS where OWNER='TARIFAS' and TABLE_NAME='AIT_CTIPOSTITULO'"

             //   "where TABLE_NAME = UPPER('"+tabla+"');"
        var name:String=""
        var type:String=""
        var resultado: ResultSet? = null

        println(consulta)
       // resultado = stmt?.executeQuery("SELECT * FROM AIT_CTIPOSTITULO");
        resultado = stmt?.executeQuery(consulta);

        var n=0
        while (resultado?.next()!!) {
            n++

            name = resultado?.getString("column_name")
            type = resultado?.getString("data_type")
            println(name+": "+type)

        }

        }




    private fun estructura(consulta: String,vararg buscarCampo:String) = try {

        var name:String=""
        var type:String=""
        var resultado: ResultSet? = null

        // si hubiese campos previos de otras tablas las borramos para evitar errores
        deleteCampos()

        //stmt = conexion?.createStatement()
        resultado = stmt?.executeQuery(consulta);

        var n=0
        while (resultado?.next()!!) {
            n++
            println(n)
            name = resultado?.getString("column_name")
            type = resultado?.getString("data_type")

            if (type.contains("NUMBER") ){
                type="NUM"
            }
            if (type.contains("VARCHAR") || type.contains("CHAR")){
                type="TEX"
            }
            items.set( name,type)
            campos.add(name)
        } /* fin de while */

    } catch (ex: SQLException) {
        println("Problemas al acceder a disco")
    } // fin de metodo



    // nombre_tabla_buscada
}