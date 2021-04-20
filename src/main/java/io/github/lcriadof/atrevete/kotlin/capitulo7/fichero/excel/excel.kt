package io.github.lcriadof.atrevete.kotlin.capitulo7.fichero.excel
import com.opencsv.CSVReader
import org.apache.poi.hssf.usermodel.HSSFCell
import org.apache.poi.hssf.usermodel.HSSFRow
import org.apache.poi.hssf.usermodel.HSSFSheet
import org.apache.poi.hssf.usermodel.HSSFWorkbook
import java.io.FileReader
import java.util.function.Consumer
import java.io.FileInputStream






fun main(){
    readCsv()
    readExcel()

}



/*  lectura extraido de
https://picodotdev.github.io/blog-bitix/2018/10/ejemplo-sencillo-de-como-leer-datos-de-un-archivo-excel-o-csv-en-java/
 */
fun readCsv() {
    val reader = CSVReader(FileReader("/tmp/kotlin/excel/201612_detalle.csv")) // urlmultas.csv
    val lines: List<Array<String?>> = reader.readAll()
    println()
    lines.forEach(Consumer { d: Array<String?> ->
        println(  d.joinToString() )
    })
    reader.close()
}

@Throws(Exception::class)
fun readExcel() {
    val wb = HSSFWorkbook(FileInputStream("/tmp/kotlin/excel/Urlmultas.xls"))
    val sheet: HSSFSheet = wb.getSheetAt(0)
    val rows: Int = sheet.getLastRowNum()
    for (i in 1 until rows) {
        val row: HSSFRow = sheet.getRow(i)
        val anio: HSSFCell = row.getCell(0)
        val mes: HSSFCell = row.getCell(1)
        val url: HSSFCell = row.getCell(2)
        val sUrl: String = url.getStringCellValue()
        println( "año: $anio, mes: $mes, URL: $url" )

    }
}




/*  escritura extraido de
https://picodotdev.github.io/blog-bitix/2016/05/ejemplo-sencillo-de-como-crear-un-excel-o-csv-en-java-con-apache-poi-y-opencsv/
 */
