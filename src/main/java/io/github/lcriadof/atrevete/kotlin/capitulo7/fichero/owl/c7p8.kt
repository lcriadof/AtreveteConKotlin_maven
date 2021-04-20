package io.github.lcriadof.atrevete.kotlin.capitulo7.fichero.owl

import io.github.lcriadof.atrevete.kotlin.capitulo7.fichero.recursos
import org.apache.jena.ontology.OntModelSpec

import org.apache.jena.ontology.OntModel
import org.apache.jena.rdf.model.ModelFactory
import org.apache.jena.vocabulary.XSD

import java.io.File
import java.io.PrintWriter














// ejemplo extraido de https://rekkeb.wordpress.com/2010/05/10/gestiona-ontologias-con-jena/

fun main(){

    //Creamos nuestro modelo
    val model: OntModel = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM)

    //Establecemos el NameSpace por defecto para nuestra ontología
    val NS = "animales"
    model.setNsPrefix(NS, "http://www.owl-ontologies.com/OntologyAnimals.owl")

    //creamos clases de ejemplo
    //hay que crearlas con el NameSpace definido
    val animales = model.createClass("$NS:Animales")
    val vertebrados = model.createClass("$NS:Vertebrados")
    val invertebrados = model.createClass("$NS:Invertebrados")

    vertebrados.setDisjointWith(invertebrados)
    animales.addSubClass(vertebrados)
    animales.addSubClass(invertebrados)

    //Creamos propiedad de ejemplo
    val peso = model.createDatatypeProperty("$NS:Peso")
    peso.addDomain(animales) //Clase a la que pertenece
    peso.addRange(XSD.xint) //Tipo de la propiedad
    peso.convertToFunctionalProperty() //Para que solo acepte un valor.


    //Ejemplos de instancias
    //Creamos las instancias y damos valor a la propiedad
    val leon = model.createIndividual("$NS:Leon", vertebrados)
    leon.setPropertyValue(peso, model.createTypedLiteral(250))

    val leopardo = model.createIndividual("$NS:Leopardo", vertebrados)
    leopardo.setPropertyValue(peso, model.createTypedLiteral(200))

    val pulpo = model.createIndividual("$NS:Pulpo", invertebrados)
    pulpo.setPropertyValue(peso, model.createTypedLiteral(10))

    val sepia = model.createIndividual("$NS:Sepia", invertebrados)
    sepia.setPropertyValue(peso, model.createTypedLiteral(1))



//Almacenamos la ontología en un fichero OWL (Opcional)
    val directorioRaiz:String="/owl/"
    var url:String= recursos::class.java.getResource(directorioRaiz).path  // 4 definimos el path de trabajo
    println("url: $url")  // 5 atencion el resultado se obtiene en la salida: target/classes/rdf/

    val file = File(url+"animales.owl")

    if (!file.exists()) { //Hay que capturar las Excepciones
        file.createNewFile()
    }
    model.write(PrintWriter(file))

}