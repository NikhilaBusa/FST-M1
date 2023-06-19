package activities;
import org.apache.poi.common.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Activity15 {
    private static final String FILE_NAME = "src/main/resources/datasheet.xlsx";
    public static void main(String[] args)
    {
        XSSFWorkbook newWorkbook = new XSSFWorkbook();
        XSSFSheet newSheet = newWorkbook.createSheet("Datatypes");
        Object[][] datatypes = {
                {"Datatype", "Type", "Size(in bytes)"},
                {"int", "Primitive", 2},
                {"float", "Primitive", 4},
                {"double", "Primitive", 8},
                {"char", "Primitive", 1},
                {"String", "Non-Primitive", "No fixed size"}
        };
        int rowIndex = 0;
        for (Object[] obj : datatypes)
        {
            Row row = newSheet.createRow(rowIndex++);
            int colIndex = 0;
            for (Object field : obj)
            {
                Cell cell = row.createCell(colIndex++);
                if (field instanceof String) {
                    cell.setCellValue((String) field);
                } else if (field instanceof Integer) {
                    cell.setCellValue((Integer) field);
                }
            }
        }
        try {
            FileOutputStream fos = new FileOutputStream(FILE_NAME);
            newWorkbook.write(fos);
            newWorkbook.close();
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        System.out.println("Complete");
    }
}
