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
import static vd10_workbook.AbilityManagement.db;

/**
 *
 * @author Tran Ngoc Dan
 * @since 30/09/2016
 */
public class AssignedVoteManagement {

    final int NUMBEROFROWS = 1338;
    static DatabaseConnection db = new DatabaseConnection();
    private List<AssignedVote> list;

    public AssignedVoteManagement() {
    }

    //load all records from table "phieu_phan_cong"
    public void loadDataBase() throws SQLException, ClassNotFoundException {
        this.list = new ArrayList<>();
        //connect database and load data
        try (Connection conn = db.connect()) {
            try (Statement statement = (Statement) conn.createStatement()) {
                //== load data from table phieu_phan_cong ==//
                String sql = "SELECT * FROM phieu_phan_cong";
                ResultSet resultSet = statement.executeQuery(sql);
                while (resultSet.next()) {
                    this.list.add(new AssignedVote(resultSet.getDate("Ngay_bat_dau"), resultSet.getInt("So_ngay"),
                            resultSet.getInt("ID_NHAN_VIEN"), resultSet.getInt("ID_LOAI_CONG_VIEC")));
                }
                statement.close();
            }
            conn.close();
        }
    }

    //load records from worksheet "phieu_phan_cong"
    public void loadWorkSheet(XSSFWorkbook workbook) throws ParseException {
        this.list = new ArrayList<>();
        //Get the sheet at index 0 (fist sheet)
        XSSFSheet spreadsheet = workbook.getSheet("phieu_phan_cong");
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
            String date_s = cell.getStringCellValue();
            SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
            Date date = dt.parse(date_s);
            cell = cellIterator.next();
            int numberOfday = (int) cell.getNumericCellValue();
            cell = cellIterator.next();
            int employeeID = (int) cell.getNumericCellValue();
            cell = cellIterator.next();
            int workTypeID = (int) cell.getNumericCellValue();
            this.list.add(new AssignedVote(date, numberOfday, employeeID, workTypeID));
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
                String sql = "INSERT INTO phieu_phan_cong VALUES (NULL,'"
                        + fm.format(this.list.get(i).getStartDate()) + "','"
                        + this.list.get(i).getNumberOfdate() + "','"
                        + this.list.get(i).getEmployeeID() + "','"
                        + this.list.get(i).getWorkTypeID() + "')";
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

    //create worksheet "phieu_phan_cong"
    public void createWorkSheet(XSSFWorkbook workbook) {
        XSSFSheet sheet = workbook.createSheet("phieu_phan_cong");
        int startRow = 0;
        XSSFRow row = sheet.createRow((short) startRow);

        //== THE TITLE ==//
        //SET HEIGHT OF ROW 2 (in excel)
        row.setHeight((short) 500);
        XSSFCell cell = (XSSFCell) row.createCell((short) 0);
        cell.setCellValue("Phiếu phân công");

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

        //Ngày bắt đầu
        sheet.setColumnWidth(1, 5000);
        cell = (XSSFCell) row.createCell((short) 1);
        cell.setCellValue("Ngày bắt đầu");
        AbilityManagement.setThickBorder(cell, workbook);

        //Số ngày
        sheet.setColumnWidth(2, 5000);
        cell = (XSSFCell) row.createCell((short) 2);
        cell.setCellValue("Số ngày");
        AbilityManagement.setThickBorder(cell, workbook);

        //ID nhân viên
        sheet.setColumnWidth(3, 5000);
        cell = (XSSFCell) row.createCell((short) 3);
        cell.setCellValue("ID nhân viên");
        AbilityManagement.setThickBorder(cell, workbook);

        //ID loại công việc
        sheet.setColumnWidth(4, 5000);
        cell = (XSSFCell) row.createCell((short) 4);
        cell.setCellValue("ID loại công việc");
        AbilityManagement.setThickBorder(cell, workbook);

        //fill out the rows
        for (int i = 0; i < this.list.size(); i++) {
            row = sheet.createRow((short) startRow + 2 + i);
            cell = (XSSFCell) row.createCell((short) 0);
            AbilityManagement.setThinBorder(cell, workbook);
            cell.setCellValue(i + 1);

            cell = (XSSFCell) row.createCell((short) 1);
            AbilityManagement.setThinBorder(cell, workbook);
            cell.setCellValue(this.list.get(i).getStartDate().toString());

            cell = (XSSFCell) row.createCell((short) 2);
            AbilityManagement.setThinBorder(cell, workbook);
            cell.setCellValue(this.list.get(i).getNumberOfdate());

            cell = (XSSFCell) row.createCell((short) 3);
            AbilityManagement.setThinBorder(cell, workbook);
            cell.setCellValue(this.list.get(i).getEmployeeID());

            cell = (XSSFCell) row.createCell((short) 4);
            AbilityManagement.setThinBorder(cell, workbook);
            cell.setCellValue(this.list.get(i).getWorkTypeID());
        }

        //== calculate sum of days ==//
        row = sheet.createRow((short) startRow + 2 + this.list.size());
        cell = (XSSFCell) row.createCell((short) 0);
        cell.setCellValue("Tổng");
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
        cell.setCellFormula("SUM(C" + (startRow + 1 + 2) + ":C" + (startRow + 2 + this.list.size()) + ")");
        AbilityManagement.setThickBorder(cell, workbook);
    }

    public void showInfo() {
        for (int i = 0; i < this.list.size(); i++) {
            this.list.get(i).showInfo();
        }
    }

}
