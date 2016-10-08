/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vd6_celltype;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author snow
 */
public class Celltype {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet spreadsheet = workbook.createSheet("cell types");
        XSSFRow row = spreadsheet.createRow((short) 2);
        row.createCell(0).setCellValue("Type of Cell");
        row.createCell(1).setCellValue("cell value");
        row = spreadsheet.createRow((short) 3);
        row.createCell(0).setCellValue("set cell type BLANK");
        row.createCell(1);
        row = spreadsheet.createRow((short) 4);
        row.createCell(0).setCellValue("set cell type BOOLEAN");
        row.createCell(1).setCellValue(true);
        row = spreadsheet.createRow((short) 5);
        row.createCell(0).setCellValue("set cell type ERROR");
        row.createCell(1).setCellValue(XSSFCell.CELL_TYPE_ERROR);//default = 5
        row = spreadsheet.createRow((short) 6);
        row.createCell(0).setCellValue("set cell type date");
        row.createCell(1).setCellValue(new Date());
        row = spreadsheet.createRow((short) 7);
        row.createCell(0).setCellValue("set cell type numeric");
        row.createCell(1).setCellValue(20);
        row = spreadsheet.createRow((short) 8);
        row.createCell(0).setCellValue("set cell type string");
        row.createCell(1).setCellValue("A String");
        FileOutputStream out = new FileOutputStream(
                new File("src\\vd6_celltype\\typesofcells.xlsx"));
        workbook.write(out);
        out.close();
        System.out.println("typesofcells.xlsx written successfully");
    }
    
    

}
