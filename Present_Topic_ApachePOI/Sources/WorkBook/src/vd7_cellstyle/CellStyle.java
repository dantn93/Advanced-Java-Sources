/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vd7_cellstyle;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CellStyle {

    public static void main(String[] args) throws FileNotFoundException, 
            IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet spreadsheet = workbook.createSheet("cellstyle");
        XSSFRow row = spreadsheet.createRow((short) 1); //row 2 in excel

        //SET HEIGHT OF ROW 2 (in excel)
        row.setHeight((short) 800);
        XSSFCell cell = (XSSFCell) row.createCell((short) 1);
        
        cell.setCellValue("test of merging");
        //MEARGING CELLS 
        //this statement for merging cells
        spreadsheet.addMergedRegion(new CellRangeAddress(
                1, //first row (0-based)
                1, //last row (0-based)
                1, //first column (0-based)
                4 //last column (0-based)
        ));

        //CELL Alignment
        row = spreadsheet.createRow(5); //row 6 (in excel)
        cell = (XSSFCell) row.createCell(0);
        row.setHeight((short) 800);
        // Top Left alignment 
        XSSFCellStyle style1 = workbook.createCellStyle();
        spreadsheet.setColumnWidth(0, 8000);
        style1.setAlignment(XSSFCellStyle.ALIGN_LEFT);
        style1.setVerticalAlignment(XSSFCellStyle.VERTICAL_TOP);
        cell.setCellValue("Top Left");
        //apply the style
        cell.setCellStyle(style1);

        row = spreadsheet.createRow(6);//row 7 in excel
        cell = (XSSFCell) row.createCell(1);
        row.setHeight((short) 800);
        // Center Align Cell Contents 
        XSSFCellStyle style2 = workbook.createCellStyle();
        style2.setAlignment(XSSFCellStyle.ALIGN_CENTER);
        style2.setVerticalAlignment(
                XSSFCellStyle.VERTICAL_CENTER);
        cell.setCellValue("Center Aligned");
        //apply the style
        cell.setCellStyle(style2);

        row = spreadsheet.createRow(7); //row 8 in excel
        cell = (XSSFCell) row.createCell(2);
        row.setHeight((short) 800);
        // Bottom Right alignment 
        XSSFCellStyle style3 = workbook.createCellStyle();
        style3.setAlignment(XSSFCellStyle.ALIGN_RIGHT);
        style3.setVerticalAlignment(
                XSSFCellStyle.VERTICAL_BOTTOM);
        cell.setCellValue("Bottom Right");
        //apply the style
        cell.setCellStyle(style3);

        row = spreadsheet.createRow(8);//row 9 in excel
        cell = (XSSFCell) row.createCell(3);
        // Justified Alignment (căn đều trong ô)
        XSSFCellStyle style4 = workbook.createCellStyle();
        style4.setAlignment(XSSFCellStyle.ALIGN_JUSTIFY);
        style4.setVerticalAlignment(
                XSSFCellStyle.VERTICAL_JUSTIFY);
        cell.setCellValue("Contents are Justified in Alignment");
        cell.setCellStyle(style4);

        //CELL BORDER
        row = spreadsheet.createRow((short) 9); //row 10 in excel
        row.setHeight((short) 800);
        cell = (XSSFCell) row.createCell((short) 0);
        cell.setCellValue("BORDER");
        XSSFCellStyle style5 = workbook.createCellStyle();
        //set bottom border which is thick line
        style5.setBorderBottom(XSSFCellStyle.BORDER_THICK);
        //set color of bottom border
        style5.setBottomBorderColor(
                IndexedColors.BLUE.getIndex());
        style5.setBorderLeft(XSSFCellStyle.BORDER_DOUBLE);
        style5.setLeftBorderColor(
                IndexedColors.GREEN.getIndex());
        style5.setBorderRight(XSSFCellStyle.BORDER_HAIR);
        style5.setRightBorderColor(
                IndexedColors.RED.getIndex());
        style5.setBorderTop(XSSFCellStyle.BIG_SPOTS);
        style5.setTopBorderColor(
                IndexedColors.CORAL.getIndex());
        cell.setCellStyle(style5);

        //Fill Colors
        //background color
        row = spreadsheet.createRow((short) 10);
        cell = (XSSFCell) row.createCell((short) 1);
        XSSFCellStyle style6 = workbook.createCellStyle();
        style6.setFillBackgroundColor(
                HSSFColor.LEMON_CHIFFON.index);
        style6.setFillPattern(XSSFCellStyle.LESS_DOTS);
        spreadsheet.setColumnWidth(1, 8000);
        cell.setCellValue("FILL BACKGROUNG/FILL PATTERN");
        cell.setCellStyle(style6);

        FileOutputStream out = new FileOutputStream(
                new File("src\\vd7_cellstyle\\cellstyle.xlsx"));
        workbook.write(out);
        out.close();
        System.out.println("cellstyle.xlsx written successfully");
    }

}
