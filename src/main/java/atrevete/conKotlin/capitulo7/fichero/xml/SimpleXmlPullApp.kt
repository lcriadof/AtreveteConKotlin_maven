package atrevete.conKotlin.capitulo7.fichero.xml.xml

import atrevete.conKotlin.capitulo7.fichero.txt.fichTexto
import org.xmlpull.v1.XmlPullParser
import org.xmlpull.v1.XmlPullParserException
import org.xmlpull.v1.XmlPullParserFactory
import java.io.File
import java.io.StringReader
import javax.xml.parsers.SAXParserFactory

import javax.xml.validation.SchemaFactory



    fun main() {

        val dir="/Datos/07_IDEA/AtreveteConKotlin_maven/src/main/resources/"
        val ficheroXml=dir+"xml/B3h_TRF_v1.0.xml"
        var f= fichTexto(ficheroXml)
        f.usar()
        println("abrimos: "+f.usar())
        println("leemos: "+f.leer())

        val factory = XmlPullParserFactory.newInstance()
        factory.isNamespaceAware = true
        val xpp = factory.newPullParser()
        xpp.setInput(StringReader(f.contenido))  // flujo que alimenta el parser
        var eventType = xpp.eventType

// buena documentacion en https://developer.android.com/training/basics/network-ops/xml?hl=es

//  ejemplo de recogido en la documentación android
      //  https://developer.android.com/reference/org/xmlpull/v1/XmlPullParser

        try {
        while (eventType != XmlPullParser.END_DOCUMENT) {
            if (eventType == XmlPullParser.START_DOCUMENT) {
                println("Inicio del documento")
            } else if (eventType == XmlPullParser.START_TAG) {
                println("Inicio TAG: " + xpp.name)
                println("  Num atributos: " + xpp.attributeCount)
                if (xpp.attributeCount==1) {
                    println("    atributo: " + xpp.getAttributeName(0))
                    println("    atributo valor: " + xpp.getAttributeValue(0))
                }
                println("profundidad: " + xpp.depth)
            } else if (eventType == XmlPullParser.END_TAG) {
                println("Fin TAG: " + xpp.name)
            } else if (eventType == XmlPullParser.TEXT) {
                println("Text " + xpp.text)
                println("profundidad: " + xpp.depth)
            }
            eventType = xpp.next()
        }
        println("Fin del documento")
        } catch (e: Exception) {
            println("XML mal formado")
        }
    }
