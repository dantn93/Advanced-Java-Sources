package vd4_readspreadsheet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class readspreadsheet {

    public static void main(String[] args) throws
            FileNotFoundException, IOException {
        FileInputStream fis = new FileInputStream(
                new File("src\\vd4_readspreadsheet\\WriteSheet.xlsx"));
        //Create blank workbook
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        //Get the sheet at index 0 (fist sheet)
        XSSFSheet spreadsheet = workbook.getSheetAt(0);
        //declare row
        XSSFRow row;
        //declare Iterator<Row> to browse row by row
        Iterator<Row> rowIterator = spreadsheet.iterator();
        while (rowIterator.hasNext()) {
            row = (XSSFRow) rowIterator.next();
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
        fis.close();
    }
}

