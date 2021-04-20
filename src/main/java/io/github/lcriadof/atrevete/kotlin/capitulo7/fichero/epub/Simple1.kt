package io.github.lcriadof.atrevete.kotlin.capitulo7.fichero.epub

import nl.siegmann.epublib.domain.Author
import nl.siegmann.epublib.domain.Book
import nl.siegmann.epublib.domain.Resource
import nl.siegmann.epublib.epub.EpubWriter
import java.io.FileOutputStream

object Simple1 {
    @JvmStatic
    fun main(args: Array<String>) {
        try {
// Create new Book
            val book = Book()

// Set the title
            book.metadata.addTitle("Epublib test book 1")

// Add an Author
            book.metadata.addAuthor(Author("Joe", "Tester"))

// Add Chapter 1                              D:/tmp/kotlin/resources/book1/
            book.addSection("Introduction", Resource(Simple1::class.java.getResourceAsStream("/book1/chapter1.html"), "chapter1.html"))


// Add css file
            book.resources.add(Resource(Simple1::class.java.getResourceAsStream("/book1/book1.css"), "book1.css"))

// Add Chapter 2
            val chapter2 = book.addSection("Second Chapter", Resource(Simple1::class.java.getResourceAsStream("/book1/chapter2.html"), "chapter2.html"))

// Add image used by Chapter 2
            book.resources.add(Resource(Simple1::class.java.getResourceAsStream("/book1/flowers_320x240.jpg"), "flowers.jpg"))

// Add Chapter2, Section 1
            book.addSection(chapter2, "Chapter 2, section 1", Resource(Simple1::class.java.getResourceAsStream("/book1/chapter2_1.html"), "chapter2_1.html"))

// Add Chapter 3
            book.addSection("Conclusion", Resource(Simple1::class.java.getResourceAsStream("/book1/chapter3.html"), "chapter3.html"))

// Create EpubWriter
            val epubWriter = EpubWriter()

// Write the Book as Epub
            println(book.toString())
            epubWriter.write(book, FileOutputStream("prueba2.epub"))
/*
            val directorioRaiz:String="/book1/"
            var url:String= recursos::class.java.getResource(directorioRaiz).path
            url=url+"prueba3.epub"
            println("url: $url")
            epubWriter.write(book, FileOutputStream(url))

 */


        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}