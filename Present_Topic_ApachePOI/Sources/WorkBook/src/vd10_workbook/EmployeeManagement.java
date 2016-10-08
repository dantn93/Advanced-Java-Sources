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
import java.util.Date;
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
import static vd10_workbook.AssignedVoteManagement.db;
import static vd10_workbook.DepartmentManagement.db;

/**
 *
 * @author Tran Ngoc Dan
 * @since 30/09/2016
 */
public class EmployeeManagement {

    final int NUMBEROFROWS = 140;
    static DatabaseConnection db = new DatabaseConnection();
    private List<Employee> list;

    public EmployeeManagement() {
        
    }
    //load data from table nhan_vien
    public void loadDataBase() throws SQLException, ClassNotFoundException {
        this.list = new ArrayList<>();
        //connect database and load data
        try (Connection conn = db.connect()) {
            try (Statement statement = (Statement) conn.createStatement()) {
                //== load data from table nhan_vien ==//
                String sql = "SELECT * FROM nhan_vien";
                ResultSet resultSet = statement.executeQuery(sql);
                while (resultSet.next()) {
                    this.list.add(new Employee(resultSet.getString("Ho_ten"),
                            resultSet.getInt("Gioi_tinh"), resultSet.getDate("Ngay_sinh"),
                            resultSet.getString("CMND"), resultSet.getDouble("Muc_luong"),
                            resultSet.getString("Dia_chi"), resultSet.getInt("ID_DON_VI")));
                }
                statement.close();
            }
            conn.close();
        }
    }

    //load data from worksheet ds_nhan_vien
    public void loadWorkSheet(XSSFWorkbook workbook) throws ParseException {
        this.list = new ArrayList<>();
        //Get the sheet at index 0 (fist sheet)
        XSSFSheet spreadsheet = workbook.getSheet("ds_nhan_vien");
        //declare row
        XSSFRow row;
        //declare Iterator<Row> to browse row by row
        Iterator<Row> rowIterator = spreadsheet.iterator();
        row = (XSSFRow) rowIterator.next();
        row = (XSSFRow) rowIterator.next();
        int count = 1;
        while (rowIterator.hasNext()) {
            row = (XSSFRow) rowIterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            Cell cell = cellIterator.next();
            cell = cellIterator.next();
            String name = cell.getStringCellValue();
            int sex = -1;
            cell = cellIterator.next();
            if (cell.getStringCellValue().equalsIgnoreCase("nam")) {
                sex = 1;
            } else {
                sex = 0;
            }
            cell = cellIterator.next();
            String date_s = cell.getStringCellValue();
            SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
            Date date = dt.parse(date_s);
            cell = cellIterator.next();
            String cmnd = cell.getStringCellValue();
            cell = cellIterator.next();
            double salary = cell.getNumericCellValue();
            cell = cellIterator.next();
            String address = cell.getStringCellValue();
            cell = cellIterator.next();
            int department = (int) cell.getNumericCellValue();
            this.list.add(new Employee(name, sex, date, cmnd, salary, address, department));
            if (count == NUMBEROFROWS) {
                break;
            } else {
                count++;
            }
        }
    }

    //write data into database
    public void writeIntoDatabase() throws SQLException, ClassNotFoundException {
        try (Connection conn = db.connect()) {
            //== load data from table kha_nang ==//
            PreparedStatement statement = null;
            SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
            for (int i = 0; i < this.list.size(); i++) {
                String sql = "INSERT INTO nhan_vien VALUES (NULL,'"
                        + this.list.get(i).getName() + "','"
                        + this.list.get(i).getSex() + "','"
                        + fm.format(this.list.get(i).getDateOfbirth()) + "','"
                        + this.list.get(i).getIdentityNumber() + "','"
                        + this.list.get(i).getSalary() + "','"
                        + this.list.get(i).getAddress() + "','"
                        + this.list.get(i).getDepartmentID() + "')";
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

    //create worksheet ds_nhan_vien
    public void createWorkSheet(XSSFWorkbook workbook) {
        XSSFSheet sheet = workbook.createSheet("ds_nhan_vien");
        int startRow = 0;
        XSSFRow row = sheet.createRow((short) startRow);

        //== THE TITLE ==//
        //SET HEIGHT OF ROW 2 (in excel)
        row.setHeight((short) 500);
        XSSFCell cell = (XSSFCell) row.createCell((short) 0);
        cell.setCellValue("Danh sách nhân viên");

        //MEARGING CELLS 
        //this statement for merging cells
        CellRangeAddress cellRangeAddress = new CellRangeAddress(
                startRow, //first row (0-based)
                startRow, //last row (0-based)
                0, //first column (0-based)
                7 //last column (0-based)
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

        //Họ tên
        sheet.setColumnWidth(1, 5000);
        cell = (XSSFCell) row.createCell((short) 1);
        cell.setCellValue("Họ tên");
        AbilityManagement.setThickBorder(cell, workbook);

        //Giới tính
        sheet.setColumnWidth(2, 5000);
        cell = (XSSFCell) row.createCell((short) 2);
        cell.setCellValue("Giới tính");
        AbilityManagement.setThickBorder(cell, workbook);

        //Ngày sinh
        sheet.setColumnWidth(3, 5000);
        cell = (XSSFCell) row.createCell((short) 3);
        cell.setCellValue("Ngày sinh");
        AbilityManagement.setThickBorder(cell, workbook);

        //CMND
        sheet.setColumnWidth(4, 5000);
        cell = (XSSFCell) row.createCell((short) 4);
        cell.setCellValue("CMND");
        AbilityManagement.setThickBorder(cell, workbook);

        //Mức lương
        sheet.setColumnWidth(5, 5000);
        cell = (XSSFCell) row.createCell((short) 5);
        cell.setCellValue("Mức lương");
        AbilityManagement.setThickBorder(cell, workbook);

        //Địa chỉ
        sheet.setColumnWidth(6, 10000);
        cell = (XSSFCell) row.createCell((short) 6);
        cell.setCellValue("Địa chỉ");
        AbilityManagement.setThickBorder(cell, workbook);

        //Đơn vị
        sheet.setColumnWidth(7, 2000);
        cell = (XSSFCell) row.createCell((short) 7);
        cell.setCellValue("Đơn vị");
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
            if (this.list.get(i).getSex() == 1) {
                cell.setCellValue("Nam");
            } else {
                cell.setCellValue("Nữ");
            }

            cell = (XSSFCell) row.createCell((short) 3);
            AbilityManagement.setThinBorder(cell, workbook);
            cell.setCellValue(this.list.get(i).getDateOfbirth().toString());

            cell = (XSSFCell) row.createCell((short) 4);
            AbilityManagement.setThinBorder(cell, workbook);
            cell.setCellValue(this.list.get(i).getIdentityNumber().toString());

            cell = (XSSFCell) row.createCell((short) 5);
            AbilityManagement.setThinBorder(cell, workbook);
            cell.setCellValue(this.list.get(i).getSalary());

            cell = (XSSFCell) row.createCell((short) 6);
            AbilityManagement.setThinBorder(cell, workbook);
            cell.setCellValue(this.list.get(i).getAddress());

            cell = (XSSFCell) row.createCell((short) 7);
            AbilityManagement.setThinBorder(cell, workbook);
            cell.setCellValue(this.list.get(i).getDepartmentID());
        }
        //== calculate sum of days ==//
        row = sheet.createRow((short) startRow + 2 + this.list.size());
        cell = (XSSFCell) row.createCell((short) 0);
        cell.setCellValue("Số nhân viên có lương >= 6tr ");
        //merge cells at column 1 & 2
        cellRangeAddress = new CellRangeAddress(
                startRow + 2 + this.list.size(), //first row (0-based)
                startRow + 2 + this.list.size(), //last row (0-based)
                0, //first column (0-based)
                1 //last column (0-based)
        );
        sheet.addMergedRegion(cellRangeAddress);
        //set border
        RegionUtil.setBorderBottom(XSSFCellStyle.BORDER_MEDIUM, cellRangeAddress, sheet, workbook);
        RegionUtil.setBorderRight(XSSFCellStyle.BORDER_MEDIUM, cellRangeAddress, sheet, workbook);
        RegionUtil.setBorderTop(XSSFCellStyle.BORDER_MEDIUM, cellRangeAddress, sheet, workbook);
        RegionUtil.setBorderLeft(XSSFCellStyle.BORDER_MEDIUM, cellRangeAddress, sheet, workbook);
        cell = row.createCell((short) 2);
        cell.setCellFormula("COUNTIF(F" + (startRow + 1 + 2) + ":F" + (startRow + 2 + this.list.size()) + ",\">= 6000000\")");
        AbilityManagement.setThickBorder(cell, workbook);
    }

    public void showInfo() {
        for (int i = 0; i < this.list.size(); i++) {
            this.list.get(i).showInfo();
        }
    }

}
