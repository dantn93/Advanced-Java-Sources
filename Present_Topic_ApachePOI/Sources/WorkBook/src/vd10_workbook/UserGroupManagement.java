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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.RegionUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import static vd10_workbook.EmployeeManagement.db;
import static vd10_workbook.RequirementManagement.db;

/**
 *
 * @author Tran Ngoc Dan
 * @since 30/09/2016
 */
public class UserGroupManagement {

    static DatabaseConnection db = new DatabaseConnection();
    private List<UserGroup> list;

    public UserGroupManagement() {
    }

    //load data from table nhom_nguoi_dung
    public void loadDataBase() throws SQLException, ClassNotFoundException {
        this.list = new ArrayList<>();
        //connect database and load data
        try (Connection conn = db.connect()) {
            try (Statement statement = (Statement) conn.createStatement()) {
                //== load data from table nhom_nguoi_dung ==//
                String sql = "SELECT * FROM nhom_nguoi_dung";
                ResultSet resultSet = statement.executeQuery(sql);
                while (resultSet.next()) {
                    this.list.add(new UserGroup(resultSet.getString("Ma_so"), resultSet.getString("Ten")));
                }
                statement.close();
            }
            conn.close();
        }
    }

    //load data from worksheet nhom_nguoi_dung
    public void loadWorkSheet(XSSFWorkbook workbook) throws ParseException {
        this.list = new ArrayList<>();
        //Get the sheet at index 0 (fist sheet)
        XSSFSheet spreadsheet = workbook.getSheet("nhom_nguoi_dung");
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
            String name = cell.getStringCellValue();
            cell = cellIterator.next();
            String id = cell.getStringCellValue();
            this.list.add(new UserGroup(id, name));
        }
    }

    //write data into database
    public void writeIntoDatabase() throws SQLException, ClassNotFoundException {
        try (Connection conn = db.connect()) {
            //== load data from table kha_nang ==//
            PreparedStatement statement = null;
            SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
            for (int i = 0; i < this.list.size(); i++) {
                String sql = "INSERT INTO nhom_nguoi_dung VALUES (NULL,'"
                        + this.list.get(i).getName() + "','"
                        + this.list.get(i).getId() + "')";
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

    //create worksheet nhom_nguoi_dung
    public void createWorkSheet(XSSFWorkbook workbook) {
        XSSFSheet sheet = workbook.createSheet("nhom_nguoi_dung");
        int startRow = 0;
        XSSFRow row = sheet.createRow((short) startRow);

        //== THE TITLE ==//
        //SET HEIGHT OF ROW 2 (in excel)
        row.setHeight((short) 500);
        XSSFCell cell = (XSSFCell) row.createCell((short) 0);
        cell.setCellValue("Nhóm người dùng");

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
        AbilityManagement.setRegionBoder(cellRangeAddress, workbook, sheet);

        //==THE LABELS ==//
        //STT
        row = sheet.createRow((short) startRow + 1);
        row.setHeight((short) 400);
        cell = (XSSFCell) row.createCell((short) 0);

        cell.setCellValue("STT");
        AbilityManagement.setThickBorder(cell, workbook);
        AbilityManagement.setBackGroundColor(cell, workbook);

        //Tên nhân viên
        sheet.setColumnWidth(1, 5000);
        cell = (XSSFCell) row.createCell((short) 1);
        cell.setCellValue("Tên nhân viên");
        AbilityManagement.setThickBorder(cell, workbook);
        AbilityManagement.setBackGroundColor(cell, workbook);

        //mã số
        sheet.setColumnWidth(2, 5000);
        cell = (XSSFCell) row.createCell((short) 2);
        cell.setCellValue("Mã số nhóm");
        AbilityManagement.setThickBorder(cell, workbook);
        AbilityManagement.setBackGroundColor(cell, workbook);

        //fill out the rows
        for (int i = 0; i < this.list.size(); i++) {
            row = sheet.createRow((short) startRow + 2 + i);
            cell = (XSSFCell) row.createCell((short) 0);
            AbilityManagement.setThinBorder(cell, workbook);
            cell.setCellValue(i + 1);

            cell = (XSSFCell) row.createCell((short) 1);
            AbilityManagement.setThinBorder(cell, workbook);
            cell.setCellValue(this.list.get(i).getName());

            cell = (XSSFCell) row.createCell((short) 2);
            AbilityManagement.setThinBorder(cell, workbook);
            cell.setCellValue(this.list.get(i).getId());
        }
    }

    public void showInfo() {
        for (int i = 0; i < this.list.size(); i++) {
            this.list.get(i).showInfo();
        }
    }

}
