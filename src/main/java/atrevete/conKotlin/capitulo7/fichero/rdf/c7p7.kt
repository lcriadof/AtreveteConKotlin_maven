/*
Atrévete con Kotlin (libro en preparación) ISBN: 9798596367164
Autor: http://luis.criado.online/index.html
 */
package atrevete.conKotlin.capitulo7.fichero.rdf

import atrevete.conKotlin.capitulo7.fichero.recursos
import com.hp.hpl.jena.vocabulary.DCTerms.subject
import org.apache.jena.rdf.model.*
import org.apache.jena.vocabulary.VCARD
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream


fun main(){
    val model = ModelFactory.createDefaultModel()  // [1] // Creamos un modelo vacio

    val personURI = "http://www.luis.criado.online"
    val luisCriado = model.createResource(personURI) // [2]  // Creamos el recurso

    val nombre:String="Luis"
    luisCriado.addProperty(VCARD.FN, nombre) // [3] Añadimos una propiedad

    val nombreComleto:String="luis.criado.fernandez@gmail.com"
    luisCriado.addProperty(VCARD.EMAIL, nombreComleto) // [4] Añadimos una propiedad

    val directorioRaiz:String="/rdf/"
    var url:String= recursos::class.java.getResource(directorioRaiz).path  // 4 definimos el path de trabajo
    println("url: $url")  // 5 atencion el resultado se obtiene en la salida: target/classes/rdf/

// --- escribimos
    println("\n\nEscribimos")
    var salida=File(url+"modelo2.rdf")
    model.write(salida.outputStream()) // 6 escribimos el modelo en un fichero rdf
    model.write(FileOutputStream(url+"modelo2otraforma.rdf")); // 7 alternativamente, de forma más compacta


// ---- leemos
    println("\n\nLeemos:")
    val model2 = ModelFactory.createDefaultModel() // 8  Creamos un modelo vacio
       model2.read(FileInputStream( url+"modelo2.rdf"), ""); // 9  importamos datos



/*
    var subject = stmt.getSubject() // 11 obtenemos el sujeto
    var predicate = stmt.getPredicate() //  12 obtenemos el predicado
    var `object`: RDFNode = stmt.getObject() // 13 obtenemos el objetot


 */



    var stmt:Statement
    var stmtbak:Statement
    while( true  ) {
        stmt = model2.listStatements().nextStatement() // 10 preparamos el modelo para lectura
         println("sujeto: " + stmt.getSubject().toString()) // 11 obtenemos el sujeto
        println("predicado: " + stmt.getPredicate().toString()) //  12 obtenemos el predicado
        println("objeto: " + stmt.getObject().toString()) // 13 obtenemos el objetot
        stmtbak=stmt
        if (stmt.getSubject().toString().equals( stmtbak.getSubject().toString()) and
                stmt.getPredicate().toString().equals( stmtbak.getPredicate().toString()) and
                stmt.getObject().toString().equals( stmtbak.getObject().toString())  ){
            break
        }
    }





    // unimos dos modelos

    val modeloA = ModelFactory.createDefaultModel() // Creamos un modelo vacio
    val modeloB = ModelFactory.createDefaultModel() // Creamos un modelo vacio

    // read the RDF/XML files
    modeloA.read(FileInputStream(url+"modelo1.rdf"), "");
    modeloB.read(FileInputStream(url+"modelo2.rdf"), "");

    // merge the Models
    val modeloUnido: Model = modeloA.union(modeloB) // unimos dos modelos
    modeloUnido.write(FileOutputStream(url+"modeloUnido.rdf"), "RDF/XML-ABBREV");



    val modeloOWL = ModelFactory.createDefaultModel() // Creamos un modelo vacio
    url= recursos::class.java.getResource("/owl/").path  // 4 definimos el path de trabajo
    modeloOWL.read(FileInputStream(url+"val1.owl"), "");
// ---- leemos
    println("\n\nLeemos modelo unido:")
    var stmt2:Statement=modeloOWL.listStatements().nextStatement() // 10 preparamos el modelo para lectura
    var sujeto:String=""
    var sujetoBak:String=""
    while( true  ) {
        sujeto=stmt2.getSubject().toString()
          println("sujeto: " +sujeto )
          println("predicado: " + stmt2.getPredicate().toString())
          println("objeto: " +stmt2.getObject().toString() )
        sujetoBak=sujeto
        println("objetoBak: $sujetoBak")
        stmt2 = modeloOWL.listStatements().nextStatement() // 10 preparamos el modelo para lectura
        sujeto=stmt2.getObject().toString()
        println("sujeto: $sujeto")

        if (sujeto.equals(sujetoBak)  ){
            break
        }


    }


}