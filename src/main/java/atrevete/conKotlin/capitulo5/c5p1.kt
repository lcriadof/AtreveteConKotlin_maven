/*
Atrévete con Kotlin (libro en preparación) ISBN: 9798596367164
Autor: http://luis.criado.online/index.html
 */
package atrevete.conKotlin.capitulo5

fun main(){
  // programa c5p1.kt
    fun FraseDelDia():Unit{          //1
      val frase:String="Cada día es una nueva oportunidad para cambiar tu vida"
      val numLetras=frase.length
          println("La frase [$frase] tiene $numLetras letras")
    }
    FraseDelDia()               //2
    FraseDelDia()
}