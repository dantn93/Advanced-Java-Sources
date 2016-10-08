package vd9_hssfworkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class readspreadsheet {

    public static void main(String[] args) throws
            FileNotFoundException, IOException {
        //Create blank workbook
        try (FileInputStream fis = new FileInputStream(
                new File("src\\vd9_hssfworkbook\\WriteSheet.xls"))) {
            //Create blank workbook
            HSSFWorkbook workbook = new HSSFWorkbook(fis);
            //Get the sheet at index 0 (fist sheet)
            HSSFSheet spreadsheet = workbook.getSheetAt(0);
            //declare row
            HSSFRow row;
            //declare Iterator<Row> to browse row by row
            Iterator<Row> rowIterator = spreadsheet.iterator();
            while (rowIterator.hasNext()) {
                row = (HSSFRow) rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    switch (cell.getCellType()) {
                        case Cell.CELL_TYPE_NUMERIC:
                            System.out.print(
                                    cell.getNumericCellValue() + " \t\t ");
                            System.out.println("ABC");
                            break;
                        case Cell.CELL_TYPE_STRING:
                            System.out.print(
                                    cell.getStringCellValue() + " \t\t ");
                            break;
                    }
                }
                System.out.println();
            }
            //close file
        }
    }
}

