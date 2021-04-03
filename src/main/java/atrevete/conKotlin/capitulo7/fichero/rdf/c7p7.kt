/*
Atrévete con Kotlin (libro en preparación) ISBN: 9798596367164
Autor: http://luis.criado.online/index.html
 */
package atrevete.conKotlin.capitulo7.fichero.rdf

import org.apache.jena.rdf.model.Model
import org.apache.jena.rdf.model.ModelFactory
import org.apache.jena.rdf.model.RDFNode
import org.apache.jena.rdf.model.Resource
import org.apache.jena.vocabulary.VCARD
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream


fun main(){

    // Creamos un modelo vacio
    val model = ModelFactory.createDefaultModel()


    // Creamos el recurso
    val personURI = "http://www.luis.criado.online"
    val johnSmith = model.createResource(personURI)

    // Añadimos una propiedad
    /*
    val fullName:String="Luis Criado"
    johnSmith.addProperty(VCARD.FN, fullName);
     */
    val fullName:String="luis.criado.fernandez@gmail.com"
    johnSmith.addProperty(VCARD.EMAIL, fullName);


    // escribimos el modelo
    var salida=File("/tmp/kotlin/modelo2.txt")
     model.write(salida.outputStream())

    // alternativamente
       model.write(FileOutputStream("/tmp/kotlin/modelo2.rdf"));


//***************hasta aqui generamos

    // leemos

    val model2 = ModelFactory.createDefaultModel() // Creamos un modelo vacio
       model2.read(FileInputStream("/tmp/kotlin/modelo2.txt"), ""); // importamos datos

    val iter = model2.listStatements()
    val stmt = iter.nextStatement() // get next statement
    val subject = stmt.getSubject() // get the subject
    val predicate = stmt.getPredicate() // get the predicate
    val `object`: RDFNode = stmt.getObject() // get the object

    println("sujeto [" + subject.toString() + "]");
    println("predicado[" + predicate.toString() + "] ");
    if (`object` is Resource) {
        print("recurso [$`object` ]")
    } else {         // object is a literal
        print("recurso_literal[$`object`]")
    }





    // unimos dos modelos

    val modelA = ModelFactory.createDefaultModel() // Creamos un modelo vacio
    val modelB = ModelFactory.createDefaultModel() // Creamos un modelo vacio


    // read the RDF/XML files
    modelA.read(FileInputStream("/tmp/kotlin/modelo1.rdf"), "");
    modelB.read(FileInputStream("/tmp/kotlin/modelo2.rdf"), "");



    // merge the Models
    val modeloUnido: Model = modelA.union(modelB)


    modeloUnido.write(FileOutputStream("/tmp/kotlin/modeloUnido.rdf"), "RDF/XML-ABBREV");


}