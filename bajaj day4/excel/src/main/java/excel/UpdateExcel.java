package excel;


import org.apache.poi.ss.usermodel.*;
import java.io.*;

public class UpdateExcel {
    public static void main(String[] args) throws Exception {

        FileInputStream fis = new FileInputStream("employees.xlsx");
        Workbook wb = WorkbookFactory.create(fis);
        Sheet sheet = wb.getSheetAt(0);

        Row row = sheet.getRow(1);
        row.getCell(2).setCellValue(60000); // update salary

        FileOutputStream fos = new FileOutputStream("employees.xlsx");
        wb.write(fos);

        wb.close();
        fis.close();
        fos.close();

        System.out.println("Excel updated!");
    }
}

