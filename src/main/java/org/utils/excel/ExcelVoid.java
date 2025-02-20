package org.utils.excel;

import org.apache.poi.ss.usermodel.*;
import java.io.File;
import java.util.Arrays;
public class ExcelVoid {
    public Object[][] read(String path ,int startRow ,int endRow , int startColumn ,int endColumn){
        Object[][] datas = new Object[endRow - startRow + 1][endColumn - startColumn +1];
        try {
            Workbook workbook = WorkbookFactory.create(new File(path));
            //根据表单索引找到表单
            Sheet sheetAt = workbook.getSheetAt(0);
            for (int i = startRow; i <= endRow; i++) {
            //循环取出行区间每一行
                Row row = sheetAt.getRow( i -1);//因为从0 开始，索引减一
                for (int j = startColumn; j <= endColumn; j++) {
            //取出列中的每一列
            // Row.MissingCellPolicy.CREATE_NULL_AS_BLANK,为防止有空白报错空指针异常
                    Cell cell =row.getCell(j-1 ,Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
            //转换excel表内取出的数据类型，不然会报错
                    cell.setCellType(CellType.STRING);
                    String stringCellValue = cell.getStringCellValue();
                    datas[i - startRow][j - startColumn]=stringCellValue;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return datas;
    }
    //验证excel方法的正确性
/*    public static void main(String[] args) {
        ExcelVoid excel = new ExcelVoid();
        System.out.println(Arrays.deepToString(excel.read("C:\\Users\\ASUS\\Desktop\\测试数据.xls",1,2,1,2)));
    }*/

}
