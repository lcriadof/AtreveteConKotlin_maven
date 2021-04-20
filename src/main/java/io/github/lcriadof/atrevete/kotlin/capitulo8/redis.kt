/*
Atrévete con Kotlin (libro en preparación) ISBN: 9798596367164
Autor: http://luis.criado.online/index.html
 */
package atrevete.conKotlin.capitulo8.nosql.redis

import redis.clients.jedis.Jedis
import redis.clients.jedis.JedisPool
import redis.clients.jedis.JedisPoolConfig

// ejemplo en java http://ualmtorres.github.io/howtos/RedisJava/
fun main(){

    val connect = Jedis("localhost", 6379) // conexión a Redis


        /*
        no se recomienda utilizar la misma instancia desde threads diferentes,
        ,tampoco es adecuado la creación de múltiples instancias de Jedis ya que acarrea la creación de múltiples sockets y conexiones, lo que también puede desencadenar errores.

        Esto se debe a que una instancia de Jedis no es threadsafe. La solución
           es utilizar JedisPool, un pool de conexiones threadsafe.
         */
    val pool = JedisPool(JedisPoolConfig(), "localhost") // pool de conexiones

/*
JedisPoolConfig incluye una serie de valores predeterminados útiles. Por ejemplo, si usamos Jedis con JedisPoolConfig se liberará la conexión tras 300 segundos (5 minutos) de inactividad.

La conexión a Redis la obtendremos con el método getResource() de JedisPoolConfig

Jedis jedis = pool.getResource();

Cuando no ya no necesitemos una conexión la cerraremos con close() y quedará liberada.

jedis.close();

Cuando hayamos finalizado el trabajo destruiremos el pool con destroy().

pool.destroy();
 */




    // SET and GET con conexion directa
   // connect.set("clave1", "Luis Criado")

    val value: String? = connect.get("clave2")
    println(value)



  //  HASHES
    /*
    Los hashes son listas de campo-valor asociados a una clave.

hset(key, field, value) asigna a la clave especificada el campo y valor propocionados.

hget(key, field) obtiene el valor asociado a la clave y campo especificados.

hkeys(key) obtiene un conjunto con la lista de campos de un clave.
     */
    // HSET
    connect.hset("user:lcriadof", "email", "lcriadof@yahoo.es");
    connect.hset("user:lcriadof", "name", "Luis");
    connect.hset("user:lcriadof", "surname", "Criado Fernández");
    connect.hset("user:lcriadof", "twitter", "@lcriadof");

    // HKEYS
    val keys: Set<String> = connect.hkeys("user:lcriadof")

    // Print the results

    // Print the results
    for (c in keys) {
        println(c + ": " + connect.hget("user:lcriadof", c))
    }

    connect.close() // cerramos conexion con redis

} // fin de atrevete.conKotlin.capitulo8.bdr.mysql.atrevete.conKotlin.capitulo8.nosql.redis.atrevete.conKotlin.capitulo8.bdr.sqlite.main()

