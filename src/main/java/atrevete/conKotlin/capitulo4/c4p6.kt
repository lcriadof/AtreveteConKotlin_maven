/*
Atrévete con Kotlin (libro en preparación) ISBN: 9798596367164
Autor: http://luis.criado.online/index.html
 */
package atrevete.conKotlin.capitulo4

import java.io.*
import java.lang.Exception
// ejemplo inspirado en
//   https://jamie.mccrindle.org/posts/exploring-kotlin-standard-library-part-2/
fun main() {
    try {
     if (File("/tmp/kotlin/f6.txt").exists()) {  // 1
         File("/tmp/kotlin/f6.txt").delete()     // 2
     }
     File("/tmp/kotlin/f3.txt").copyTo(File("/tmp/kotlin/f6.txt"))
    }
    catch (e: Exception) {
        println(e)
    }
}