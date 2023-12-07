package com.example.education

import android.content.Context
import com.example.education.base.BaseViewModel
import com.example.education.bean.StudentBean
import org.apache.poi.ss.usermodel.Sheet
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import java.io.InputStream


/**
 * @author fengerzhang
 * @date 2023/12/6 09:28
 */
class MainViewModel : BaseViewModel() {
    /**
     * 读取Excel数据，获取全部学生信息
     *
     * @return List<StudentBean></StudentBean> */
    fun readExcel(context: Context): List<StudentBean> {
        val studentList: MutableList<StudentBean> = ArrayList()

        val input: InputStream = context.assets.open("test_excel.xlsx")
        // 获取表格对象
        val sheet: Sheet = XSSFWorkbook(input).getSheetAt(0)

        // 循环读取表格数据
        for (row in sheet) {
            // 首行（即表头）不读取,后面可以校验表头
            if (row.rowNum == 0) {
                continue
            }
            // 读取当前行中单元格数据，索引从0开始
            val name = row.getCell(0).stringCellValue
            val id = row.getCell(1).numericCellValue.toLong()
            val gender = row.getCell(2).stringCellValue == "男"
            val grade = row.getCell(3).numericCellValue.toInt()
            val classID = row.getCell(4).numericCellValue.toInt()
            studentList.add(row.rowNum - 1, StudentBean(name, id, gender, grade, classID, 1))
        }

        // 关闭数据流
        input.close()
        return studentList
    }
}