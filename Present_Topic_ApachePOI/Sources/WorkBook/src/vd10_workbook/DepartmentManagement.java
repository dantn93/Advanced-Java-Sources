/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vd10_workbook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
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
import static vd10_workbook.AssignedVoteManagement.db;

/**
 *
 * @author Tran Ngoc Dan
 * @since 30/09/2016
 */
public class DepartmentManagement {

    static DatabaseConnection db = new DatabaseConnection();
    private List<Department> list;

    public DepartmentManagement() {
    }

    //load data from table don_vi
    public void loadDataBase() throws SQLException, ClassNotFoundException {
        this.list = new ArrayList<>();
        //connect database and load data
        try (Connection conn = db.connect()) {
            try (Statement statement = (Statement) conn.createStatement()) {
                //== load data from table don_vi ==//
                String sql = "SELECT * FROM don_vi";
                ResultSet resultSet = statement.executeQuery(sql);
                while (resultSet.next()) {//require thís condition
                    this.list.add(new Department(resultSet.getString("Ten")));
                }
                statement.close();
            }
            conn.close();
        }
    }

    //load data from worksheet don_vi
    public void loadWorkSheet(XSSFWorkbook workbook) throws ParseException {
        this.list = new ArrayList<>();
        //Get the sheet at index 0 (fist sheet)
        XSSFSheet spreadsheet = workbook.getSheet("don_vi");
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
            this.list.add(new Department(cell.getStringCellValue()));
        }
    }

    //write data from worksheet don_vi into database
    public void writeIntoDatabase() throws SQLException, ClassNotFoundException {
        try (Connection conn = db.connect()) {
            //== load data from table kha_nang ==//
            PreparedStatement statement = null;
            for (int i = 0; i < this.list.size(); i++) {
                String sql = "INSERT INTO don_vi VALUES (NULL,'"
                        + this.list.get(i).getName() + "')";
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

    //create worksheet don_vi and fill out the information
    public void createWorkSheet(XSSFWorkbook workbook) {
        XSSFSheet sheet = workbook.createSheet("don_vi");
        int startRow = 0;
        XSSFRow row = sheet.createRow((short) startRow);

        //== THE TITLE ==//
        //SET HEIGHT OF ROW 2 (in excel)
        row.setHeight((short) 500);
        XSSFCell cell = (XSSFCell) row.createCell((short) 0);
        cell.setCellValue("Đơn vị");

        //MEARGING CELLS 
        //this statement for merging cells
        CellRangeAddress cellRangeAddress = new CellRangeAddress(
                startRow, //first row (0-based)
                startRow, //last row (0-based)
                0, //first column (0-based)
                1 //last column (0-based)
        );
        sheet.addMergedRegion(cellRangeAddress);
        // Center Align Cell Contents 
        XSSFCellStyle align = workbook.createCellStyle();
        align.setAlignment(XSSFCellStyle.ALIGN_CENTER);
        align.setVerticalAlignment(
                XSSFCellStyle.VERTICAL_CENTER);
        cell.setCellStyle(align);

        //set border
        AbilityManagement.setRegionBoder(cellRangeAddress, workbook, sheet);

        //==THE LABELS ==//
        //STT
        row = sheet.createRow((short) startRow + 1);
        row.setHeight((short) 400);
        cell = (XSSFCell) row.createCell((short) 0);

        cell.setCellValue("STT");
        AbilityManagement.setThickBorder(cell, workbook);

        //Tên đơn vị
        sheet.setColumnWidth(1, 5000);
        cell = (XSSFCell) row.createCell((short) 1);
        cell.setCellValue("Tên đơn vị");
        AbilityManagement.setThickBorder(cell, workbook);

        //fill out the rows
        for (int i = 0; i < this.list.size(); i++) {
            row = sheet.createRow((short) startRow + 2 + i);
            cell = (XSSFCell) row.createCell((short) 0);
            AbilityManagement.setThinBorder(cell, workbook);
            cell.setCellValue(i + 1);

            cell = (XSSFCell) row.createCell((short) 1);
            AbilityManagement.setThinBorder(cell, workbook);
            cell.setCellValue(this.list.get(i).getName().toString());

        }
    }

    //set border
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

    public void showInfo() {
        for (int i = 0; i < this.list.size(); i++) {
            this.list.get(i).showInfo();
        }
    }

}
