/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vd10_workbook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.naming.spi.DirStateFactory.Result;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.RegionUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import static vd10_workbook.Company.db;

/**
 *
 * @author Tran Ngoc Dan
 * @since 30/09/2016
 */
public class AbilityManagement {

    private List<Ability> list;
    static DatabaseConnection db = new DatabaseConnection();

    public AbilityManagement() {
    }

    //load all record from table "kha_nang"
    public void loadDataBase() throws SQLException, ClassNotFoundException {
        this.list = new ArrayList<>();
        //connect database and load data
        try (Connection conn = db.connect()) {
            try (Statement statement = (Statement) conn.createStatement()) {
                //== load data from table kha_nang ==//
                String sql = "SELECT * FROM kha_nang";
                ResultSet resultSet = statement.executeQuery(sql);
                while (resultSet.next()) {
                    list.add(new Ability(resultSet.getInt("ID_NHAN_VIEN"), resultSet.getInt("ID_NGOAI_NGU")));
                }
                statement.close();
            }
            conn.close();
        }
    }

    public void addAbility(Ability ability) {
        this.list.add(ability);

    }

    public void showInfo() {
        System.out.println(this.list.size());
        for (int i = 0; i < this.list.size(); i++) {
            this.list.get(i).showInfo();
        }
    }

    //create worksheet kha_nang
    public void createWorkSheet(XSSFWorkbook workbook) {
        XSSFSheet sheet = workbook.createSheet("kha_nang");
        int startRow = 0;
        XSSFRow row = sheet.createRow((short) startRow);

        //== THE TITLE ==//
        //SET HEIGHT OF ROW 2 (in excel)
        row.setHeight((short) 500);
        XSSFCell cell = (XSSFCell) row.createCell((short) 0);
        cell.setCellValue("Khả năng làm việc");

        //MEARGING CELLS 
        //this statement for merging cells
        CellRangeAddress cellRangeAddress = new CellRangeAddress(
                startRow, //first row (0-based)
                startRow, //last row (0-based)
                0, //first column (0-based)
                2 //last column (0-based)
        );
        sheet.addMergedRegion(cellRangeAddress);

        // Center Align Cell Contents 
        XSSFCellStyle align = workbook.createCellStyle();
        align.setAlignment(XSSFCellStyle.ALIGN_CENTER);
        align.setVerticalAlignment(
                XSSFCellStyle.VERTICAL_CENTER);
        cell.setCellStyle(align);

        //set border
        this.setRegionBoder(cellRangeAddress, workbook, sheet);

        //==THE LABELS ==//
        //STT
        row = sheet.createRow((short) startRow + 1);
        row.setHeight((short) 400);
        cell = (XSSFCell) row.createCell((short) 0);

        cell.setCellValue("STT");
        this.setThickBorder(cell, workbook);
        this.setBackGroundColor(cell, workbook);

        //ID_NHAN_VIEN
        sheet.setColumnWidth(1, 5000);
        cell = (XSSFCell) row.createCell((short) 1);
        cell.setCellValue("ID Nhân viên");
        this.setThickBorder(cell, workbook);
        this.setBackGroundColor(cell, workbook);

        //ID_NGOAI_NGU
        sheet.setColumnWidth(2, 5000);
        cell = (XSSFCell) row.createCell((short) 2);
        cell.setCellValue("ID Ngoại ngữ");
        this.setThickBorder(cell, workbook);
        this.setBackGroundColor(cell, workbook);

        //fill out the rows
        for (int i = 0; i < this.list.size(); i++) {
            row = sheet.createRow((short) startRow + 2 + i);
            cell = (XSSFCell) row.createCell((short) 0);
            this.setThinBorder(cell, workbook);
            cell.setCellValue(i + 1);

            cell = (XSSFCell) row.createCell((short) 1);
            this.setThinBorder(cell, workbook);
            cell.setCellValue(this.list.get(i).getEmployeeID());

            cell = (XSSFCell) row.createCell((short) 2);
            this.setThinBorder(cell, workbook);
            cell.setCellValue(this.list.get(i).getLanguageID());

        }
    }

    //load record from worksheet "kha_nang"
    public void loadWorkSheet(XSSFWorkbook workbook) {
        this.list = new ArrayList<>();
        //Get the sheet at index 0 (fist sheet)
        XSSFSheet spreadsheet = workbook.getSheet("kha_nang");
        //declare row
        XSSFRow row;
        //declare Iterator<Row> to browse row by row
        Iterator<Row> rowIterator = spreadsheet.iterator();
        row = (XSSFRow) rowIterator.next();
        row = (XSSFRow) rowIterator.next();
        while (rowIterator.hasNext()) {
            row = (XSSFRow) rowIterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            Cell cell = cellIterator.next();

            cell = cellIterator.next();
            int employeeID = (int) cell.getNumericCellValue();
            cell = cellIterator.next();
            int languageID = (int) cell.getNumericCellValue();
            this.list.add(new Ability(employeeID, languageID));
        }
    }

    //write datat into database
    public void writeIntoDatabase() throws SQLException, ClassNotFoundException {
        try (Connection conn = db.connect()) {
            //== load data from table kha_nang ==//
            PreparedStatement statement = null;
            for (int i = 0; i < this.list.size(); i++) {
                String sql = "INSERT INTO kha_nang VALUES (NULL,'" + this.list.get(i).getEmployeeID() + "','"
                        + this.list.get(i).getLanguageID() + "')";
                statement = conn.prepareStatement(sql);
                statement.execute();

            }
            statement.close();
            System.out.println("Successfully!");
            conn.close();
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Can not add new product");
        }
    }

    //set border of cell with thick border
    public static void setThickBorder(XSSFCell cell, XSSFWorkbook workbook) {
        XSSFCellStyle border = workbook.createCellStyle();
        border.setBorderTop(XSSFCellStyle.BORDER_MEDIUM);
        border.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        border.setBorderBottom(XSSFCellStyle.BORDER_MEDIUM);
        border.setRightBorderColor(IndexedColors.BLACK.getIndex());
        border.setBorderLeft(XSSFCellStyle.BORDER_MEDIUM);
        border.setTopBorderColor(IndexedColors.BLACK.getIndex());
        border.setBorderRight(XSSFCellStyle.BORDER_MEDIUM);
        border.setLeftBorderColor(IndexedColors.BLACK.getIndex());
        cell.setCellStyle(border);
    }

    //set border of cell with thin border
    public static void setThinBorder(XSSFCell cell, XSSFWorkbook workbook) {
        XSSFCellStyle border = workbook.createCellStyle();
        border.setBorderBottom(XSSFCellStyle.BORDER_THIN);
        border.setRightBorderColor(IndexedColors.BLACK.getIndex());
        border.setBorderLeft(XSSFCellStyle.BORDER_THIN);
        border.setTopBorderColor(IndexedColors.BLACK.getIndex());
        border.setBorderRight(XSSFCellStyle.BORDER_THIN);
        border.setLeftBorderColor(IndexedColors.BLACK.getIndex());
        cell.setCellStyle(border);
    }

    //set background of cell
    public static void setBackGroundColor(XSSFCell cell, XSSFWorkbook workbook) {
//        XSSFCellStyle color = workbook.createCellStyle();
//        color.setFillBackgroundColor(
//                HSSFColor.YELLOW.index);
//        color.setFillPattern(XSSFCellStyle.SPARSE_DOTS);
//        cell.setCellStyle(color);
    }

    //set border of a region
    public static void setRegionBoder(CellRangeAddress cellRangeAddress, XSSFWorkbook workbook, XSSFSheet sheet) {
        //set bottom border which is thick line
        RegionUtil.setBorderBottom(XSSFCellStyle.BORDER_MEDIUM, cellRangeAddress, sheet, workbook);

        //right
        RegionUtil.setBorderRight(XSSFCellStyle.BORDER_MEDIUM, cellRangeAddress, sheet, workbook);

        //top
        RegionUtil.setBorderTop(XSSFCellStyle.BORDER_MEDIUM, cellRangeAddress, sheet, workbook);

        //left
        RegionUtil.setBorderLeft(XSSFCellStyle.BORDER_MEDIUM, cellRangeAddress, sheet, workbook);
    }
}
