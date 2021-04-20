package io.github.lcriadof.atrevete.kotlin.capitulo9

import com.github.psambit9791.jdsp.misc.Plotting
import com.github.psambit9791.jdsp.transform.DiscreteFourier
import com.github.psambit9791.jdsp.misc.UtilMethods
import com.github.psambit9791.jdsp.signal.Generate


    fun main(args: Array<String>) {
        val Fs = 100
        val gp = Generate(0, 1, Fs)
        val f1 = 5
        val out_reg_sawtooth = gp.generateSawtooth(f1, 1.0) //Regular Sawtooth
        val out_tri_sawtooth = gp.generateSawtooth(f1, 0.5) //Triangular Sawtooth
        val out_inv_sawtooth = gp.generateSawtooth(f1, 0.0) //Inverse Sawtooth
        val ejeX = gp.timeArray
        println(out_reg_sawtooth.size)
        println(out_tri_sawtooth.size)
        println(out_inv_sawtooth.size)
        val fig = Plotting(600, 300, "Sample Figure", "Time", "Signal")
        fig.initialisePlot()

        // fig.addSignal("Signal 1", ejeX, out_tri_sawtooth, false);
        // fig.addSignal("Signal 2", ejeX, out_tri_sawtooth, true);
        // fig.addSignal("Signal 3", ejeX, out_inv_sawtooth, true);


        //  fig.plot();


        //
        val fft = DiscreteFourier(out_tri_sawtooth)
        fft.dft()
        val onlyPositive = true
        val out = fft.returnAbsolute(onlyPositive) //Positive Absolute
        println(out.size)
        val start = 1
        val stop = 10
        val samples = out.size
        val includeEnd = true
        val x = UtilMethods.linspace(start, stop, samples, includeEnd)
        fig.addSignal("Signal 2", x, out, false)
        fig.plot()

        // TO save as an image
        val outputFileName = "signal.png"
        fig.saveAsPNG(outputFileName)
    }
