package ru.alexandra_incr.authorssupervision

import io.github.evanrupert.excelkt.Cell
import io.github.evanrupert.excelkt.Row
import io.github.evanrupert.excelkt.Sheet
import io.github.evanrupert.excelkt.workbook
import org.apache.poi.xssf.usermodel.XSSFCellStyle
import kotlin.reflect.full.memberProperties
import kotlin.reflect.jvm.isAccessible


sealed interface Colon {
    val name: String

    data class Value(override val name: String) : Colon
    data class ParentValue(override val name: String, val list: List<Colon>) : Colon
}

internal class Test {

    @org.junit.jupiter.api.Test
    fun one() {
        val list = listOf<Colon>(
            Colon.Value("№ п/п"),
            Colon.Value("Предприятие, цех"),
            Colon.Value("Участок  (ответственный)"),
            Colon.Value("Наименование работ (ООР)"),
            Colon.Value("ППР"),
            Colon.ParentValue("Дата производства работ",
                listOf(Colon.Value("начало"), Colon.Value("окончание"))),
            Colon.Value("Признак опасности"),
        )

        workbook {
            sheet {
                row {
                    list.forEachIndexed { ind,colon ->

                        when (colon) {
                            is Colon.Value -> {
                                cell(colon.name)
                            }
                            is Colon.ParentValue -> {
                                cell(colon.name)
                                (0 until colon.list.size-1).forEach {
                                    cell("")
                                }
                                this@sheet.row{
                                    (0 until  ind).forEach {
                                        cell("")
                                    }
                                    colon.list.forEach {
                                        cell(it.name)
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }.write("c://one.xlsx")
    }
}

fun Row.cell(content: Any,index:Int,style: XSSFCellStyle? = null) {
    val style2 = this::class.java.getDeclaredField("style")
    style2.isAccessible = true
    /*val style2 = this::class.memberProperties.first { it.name == "style" }
    style2.isAccessible = true*/
    Cell(
        xssfWorkbook = xssfWorkbook,
        style = style ?: style2.get(this) as XSSFCellStyle?,
        content = content,
        xssfRow = xssfRow,
        index = index
    )
}