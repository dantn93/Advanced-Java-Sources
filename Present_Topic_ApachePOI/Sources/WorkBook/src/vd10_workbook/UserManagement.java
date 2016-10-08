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
import static vd10_workbook.UserGroupManagement.db;

/**
 *
 * @author Tran Ngoc Dan
 * @since 30/09/2016
 */
public class UserManagement {

    static DatabaseConnection db = new DatabaseConnection();
    private List<User> list;

    public UserManagement() {
    }

    //load data form table nguoi_dung
    public void loadDataBase() throws SQLException, ClassNotFoundException {
        this.list = new ArrayList<>();
        try (Connection conn = db.connect()) {
            try (Statement statement = (Statement) conn.createStatement()) {
                //== load data from table nguoi_dung ==//
                String sql = "SELECT * FROM nguoi_dung";
                ResultSet resultSet = statement.executeQuery(sql);
                while (resultSet.next()) {
                    this.list.add(new User(resultSet.getString("Ten"), resultSet.getString("Mat_khau"),
                            resultSet.getString("Mo_rong"), resultSet.getInt("ID_NHOM_NGUOI_DUNG")));
                }
                statement.close();
            }
            conn.close();
        }
    }

    //load data from worksheet nguoi_dung
    public void loadWorkSheet(XSSFWorkbook workbook) throws ParseException {
        this.list = new ArrayList<>();
        //Get the sheet at index 0 (fist sheet)
        XSSFSheet spreadsheet = workbook.getSheet("nguoi_dung");
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
            String password = cell.getStringCellValue();
            cell = cellIterator.next();
            String expansion = cell.getStringCellValue();
            cell = cellIterator.next();
            int userGroupID = (int) cell.getNumericCellValue();
            this.list.add(new User(name, password, expansion, userGroupID));
        }
    }

    //write data into database
    public void writeIntoDatabase() throws SQLException, ClassNotFoundException {
        try (Connection conn = db.connect()) {
            //== load data from table kha_nang ==//
            PreparedStatement statement = null;
            for (int i = 0; i < this.list.size(); i++) {
                String sql = "INSERT INTO nguoi_dung VALUES (NULL,'"
                        + this.list.get(i).getName() + "','"
                        + this.list.get(i).getPassword() + "','"
                        + this.list.get(i).getExpansion() + "','"
                        + this.list.get(i).getGroupID() + "')";
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

    //create worksheet nguoi_dung
    public void createWorkSheet(XSSFWorkbook workbook) {
        XSSFSheet sheet = workbook.createSheet("nguoi_dung");
        int startRow = 0;
        XSSFRow row = sheet.createRow((short) startRow);

        //== THE TITLE ==//
        //SET HEIGHT OF ROW 2 (in excel)
        row.setHeight((short) 500);
        XSSFCell cell = (XSSFCell) row.createCell((short) 0);
        cell.setCellValue("Danh sách người dùng");

        //MEARGING CELLS 
        //this statement for merging cells
        CellRangeAddress cellRangeAddress = new CellRangeAddress(
                startRow, //first row (0-based)
                startRow, //last row (0-based)
                0, //first column (0-based)
                4 //last column (0-based)
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

        //Tên người dùng
        sheet.setColumnWidth(1, 5000);
        cell = (XSSFCell) row.createCell((short) 1);
        cell.setCellValue("Tên");
        AbilityManagement.setThickBorder(cell, workbook);

        //Mật khẩu
        sheet.setColumnWidth(2, 5000);
        cell = (XSSFCell) row.createCell((short) 2);
        cell.setCellValue("Mật khẩu");
        AbilityManagement.setThickBorder(cell, workbook);

        //Mở rộng
        sheet.setColumnWidth(3, 5000);
        cell = (XSSFCell) row.createCell((short) 3);
        cell.setCellValue("Mở rộng");
        AbilityManagement.setThickBorder(cell, workbook);

        //ID_NHOM_NGUOI_DUNG
        sheet.setColumnWidth(4, 5000);
        cell = (XSSFCell) row.createCell((short) 4);
        cell.setCellValue("ID Nhóm người dùng");
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

            cell = (XSSFCell) row.createCell((short) 2);
            AbilityManagement.setThinBorder(cell, workbook);
            cell.setCellValue(this.list.get(i).getPassword());

            cell = (XSSFCell) row.createCell((short) 3);
            AbilityManagement.setThinBorder(cell, workbook);
            cell.setCellValue(this.list.get(i).getExpansion());

            cell = (XSSFCell) row.createCell((short) 4);
            AbilityManagement.setThinBorder(cell, workbook);
            cell.setCellValue(this.list.get(i).getGroupID());
        }
    }

    public void showInfo() {
        for (int i = 0; i < this.list.size(); i++) {
            this.list.get(i).showInfo();
        }
    }

}
