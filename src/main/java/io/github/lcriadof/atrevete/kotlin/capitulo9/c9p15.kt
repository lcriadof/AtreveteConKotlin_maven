package io.github.lcriadof.atrevete.kotlin.capitulo9

import com.github.psambit9791.jdsp.transform.DiscreteFourier
import com.github.psambit9791.jdsp.transform.InverseDiscreteFourier
import com.github.psambit9791.jdsp.io.Csv

fun main(){

    val signal= DoubleArray(9, { i -> i+1.0 })
    println("Señal original")
    println(signal.joinToString())

    val fft = DiscreteFourier(signal)
    fft.dft()

    val onlyPositive = false
    val out = fft.returnFull(onlyPositive) //Full Complex


    println()
    println("procesamos la señal original con la FFT")
    // El resultado FFT tiene números complejos
    for (i in 0..out.size-1){
        for (j in 0..1){
            print("\t"+out[i][j])
            if (j==1){
                print("i")
            }
        }
        println()
    }


    println()
    println("Recuperamos la señal original con la transformada inversa IFFT")
    val transformer = InverseDiscreteFourier(out,false)
    transformer.idft()
    val out2 = transformer.absoluteSignal
    println(out2.joinToString())



    // redondeamos los números
    for (i in 0..out2.size-1){
        out2[i] = (Math.round(out2[i] * 100) / 100).toDouble()
    }
    println()
    println("Recuperamos la señal original con la transformada inversa IFFT (redondeado)")
    println(out2.joinToString())


}