/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vd10_workbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
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
import java.util.Map;
import java.util.TreeMap;
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

/**
 *
 * @author Tran Ngoc Dan
 * @since 30/09/2016
 */
public class Company {

    //Information
    private String name;
    private String phoneNumber;
    private String address;
    private int minAge;
    private int maxAge;
    //database
    static DatabaseConnection db = new DatabaseConnection();
    AbilityManagement ability;
    AssignedVoteManagement assignment;
    DepartmentManagement department;
    EmployeeManagement employee;
    ForeignLanguageManagement language;
    RequirementManagement requirement;
    UserManagement user;
    UserGroupManagement userGroup;
    WorkTypeManagement workType;
    //workbook
    XSSFWorkbook workbook;

    public Company() {
        
    }

    //require child department to load data from worksheet
    public void loadWorkBook() throws FileNotFoundException, IOException, ParseException {
        FileInputStream fis = new FileInputStream(
                new File("src\\vd10_workbook\\workbook.xlsx"));
        //Create blank workbook
        this.workbook = new XSSFWorkbook(fis);
        this.ability = new AbilityManagement();
        this.ability.loadWorkSheet(workbook);
        this.assignment = new AssignedVoteManagement();
        this.assignment.loadWorkSheet(workbook);
        this.department = new DepartmentManagement();
        this.department.loadWorkSheet(workbook);
        this.employee = new EmployeeManagement();
        this.employee.loadWorkSheet(workbook);
        this.language = new ForeignLanguageManagement();
        this.language.loadWorkSheet(workbook);
        this.requirement = new RequirementManagement();
        this.requirement.loadWorkSheet(workbook);
        this.user = new UserManagement();
        this.user.loadWorkSheet(workbook);
        this.userGroup = new UserGroupManagement();
        this.userGroup.loadWorkSheet(workbook);
        this.workType = new WorkTypeManagement();
        this.workType.loadWorkSheet(workbook);
        //load worksheet itself
        this.loadWorkSheet();
        fis.close();
    }

    //The company loads data from worksheet itself.
    private void loadWorkSheet() {
        //Get the sheet at index 0 (fist sheet)
        XSSFSheet spreadsheet = this.workbook.getSheet("cong_ty");
        //declare row
        XSSFRow row;
        //declare Iterator<Row> to browse row by row
        Iterator<Row> rowIterator = spreadsheet.iterator();
        row = (XSSFRow) rowIterator.next();
        row = (XSSFRow) rowIterator.next();
        row = (XSSFRow) rowIterator.next();
        Iterator<Cell> cellIterator = row.cellIterator();
        Cell cell = cellIterator.next();

        cell = cellIterator.next();
        this.name = cell.getStringCellValue();

        cell = cellIterator.next();
        this.phoneNumber = cell.getStringCellValue();

        cell = cellIterator.next();
        this.address = cell.getStringCellValue();

        cell = cellIterator.next();
        this.minAge = (int) cell.getNumericCellValue();

        cell = cellIterator.next();
        this.maxAge = (int) cell.getNumericCellValue();
    }

    //write data into database
    public void writeIntoDatabase() throws SQLException, ClassNotFoundException {
        this.ability.writeIntoDatabase();
        this.assignment.writeIntoDatabase();
        this.department.writeIntoDatabase();
        this.employee.writeIntoDatabase();
        this.language.writeIntoDatabase();
        this.requirement.writeIntoDatabase();
        this.user.writeIntoDatabase();
        this.userGroup.writeIntoDatabase();
        this.workType.writeIntoDatabase();
        this.writeDatabase();
    }

    //load data from database
    public void loadDataBase() throws SQLException, ClassNotFoundException {
        //load data from database
        try (Connection conn = db.connect()) {
            try (Statement statement = (Statement) conn.createStatement()) {
                //== load data from table cong_ty ==//
                String sql = "SELECT * FROM cong_ty";
                ResultSet resultSet = statement.executeQuery(sql);
                if (resultSet.next()) {//require thís condition
                    this.name = resultSet.getString("Ten");
                    this.phoneNumber = resultSet.getString("Dien_thoai");
                    this.address = resultSet.getString("Dia_chi");
                    this.minAge = resultSet.getInt("Tuoi_toi_thieu");
                    this.maxAge = resultSet.getInt("Tuoi_toi_da");
                }
                statement.close();
            }
            conn.close();
        }
        //load data from the other tables
        this.ability = new AbilityManagement();
        this.ability.loadDataBase();
        this.assignment = new AssignedVoteManagement();
        this.assignment.loadDataBase();
        this.department = new DepartmentManagement();
        this.department.loadDataBase();
        this.employee = new EmployeeManagement();
        this.employee.loadDataBase();
        this.language = new ForeignLanguageManagement();
        this.language.loadDataBase();
        this.requirement = new RequirementManagement();
        this.requirement.loadDataBase();
        this.user = new UserManagement();
        this.user.loadDataBase();
        this.userGroup = new UserGroupManagement();
        this.userGroup.loadDataBase();
        this.workType = new WorkTypeManagement();
        this.workType.loadDataBase();
        //create workbook
        //all of table in a workbook, it has 10 worksheet
        this.workbook = new XSSFWorkbook();
    }

    //write company's data into database
    private void writeDatabase() {
        try (Connection conn = db.connect()) {
            //== load data from table kha_nang ==//
            PreparedStatement statement = null;
            String sql = "INSERT INTO cong_ty VALUES (NULL,'"
                    + this.name + "','"
                    + this.phoneNumber + "','"
                    + this.address + "','"
                    + this.minAge + "','"
                    + this.maxAge + "')";
            statement = conn.prepareStatement(sql);
            statement.execute();
            statement.close();
            System.out.println("Successfully!");
            conn.close();
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Can not add new product");
        }
    }

    public void showInfo() {
        System.out.println("[Name]: " + this.name);
        System.out.println("[NumberPhone]: " + this.phoneNumber);
        System.out.println("[Address]: " + this.address);
        System.out.println("[Minimum Age]: " + this.minAge);
        System.out.println("[Maximum Age]: " + this.maxAge);
    }

    //write data into excel file.
    public void exportToExcel() throws IOException {
        this.ability.createWorkSheet(this.workbook);
        this.assignment.createWorkSheet(this.workbook);
        this.department.createWorkSheet(this.workbook);
        this.employee.createWorkSheet(this.workbook);
        this.language.createWorkSheet(this.workbook);
        this.requirement.createWorkSheet(this.workbook);
        this.userGroup.createWorkSheet(this.workbook);
        this.user.createWorkSheet(this.workbook);
        this.workType.createWorkSheet(this.workbook);
        this.createWorkSheet(this.workbook);
        this.workbook.getCreationHelper()
                .createFormulaEvaluator()
                .evaluateAll();

        try (FileOutputStream out = new FileOutputStream(
                new File("src\\vd10_workbook\\workbook.xlsx"))) {
            this.workbook.write(out);
            out.close();
        }
    }

    //create company's worksheet itself
    public void createWorkSheet(XSSFWorkbook workbook) {
        XSSFSheet sheet = workbook.createSheet("cong_ty");
        int startRow = 0;
        XSSFRow row = sheet.createRow((short) startRow);

        //== THE TITLE ==//
        //SET HEIGHT OF ROW 2 (in excel)
        row.setHeight((short) 500);
        XSSFCell cell = (XSSFCell) row.createCell((short) 0);
        cell.setCellValue("Thông tin công ty");

        //MEARGING CELLS 
        //this statement for merging cells
        CellRangeAddress cellRangeAddress = new CellRangeAddress(
                startRow, //first row (0-based)
                startRow, //last row (0-based)
                0, //first column (0-based)
                5 //last column (0-based)
        );
        sheet.addMergedRegion(cellRangeAddress);
        // Center Align Cell Contents 
        XSSFCellStyle align = workbook.createCellStyle();
        align.setAlignment(XSSFCellStyle.ALIGN_CENTER);
        align.setVerticalAlignment(
                XSSFCellStyle.VERTICAL_CENTER);
        cell.setCellStyle(align);

        //set border
//        AbilityManagement.setRegionBoder(cellRangeAddress, workbook, sheet);

        //==THE LABELS ==//
        //STT
        row = sheet.createRow((short) startRow + 1);
        row.setHeight((short) 400);
        cell = (XSSFCell) row.createCell((short) 0);

        cell.setCellValue("STT");
        AbilityManagement.setThickBorder(cell, workbook);

        //Tên công ty
        sheet.setColumnWidth(1, 5000);
        cell = (XSSFCell) row.createCell((short) 1);
        cell.setCellValue("Tên");
        AbilityManagement.setThickBorder(cell, workbook);

        //Điện thoại
        sheet.setColumnWidth(2, 5000);
        cell = (XSSFCell) row.createCell((short) 2);
        cell.setCellValue("Điện thoại");
        AbilityManagement.setThickBorder(cell, workbook);

        //Địa chỉ
        sheet.setColumnWidth(3, 10000);
        cell = (XSSFCell) row.createCell((short) 3);
        cell.setCellValue("Địa chỉ");
        AbilityManagement.setThickBorder(cell, workbook);

        //Tuổi tối thiểu
        sheet.setColumnWidth(4, 5000);
        cell = (XSSFCell) row.createCell((short) 4);
        cell.setCellValue("Tuổi tối thiểu");
        AbilityManagement.setThickBorder(cell, workbook);

        //Tuổi tối đa
        sheet.setColumnWidth(5, 5000);
        cell = (XSSFCell) row.createCell((short) 5);
        cell.setCellValue("Tuổi tối đa");
        AbilityManagement.setThickBorder(cell, workbook);

        //== fill out the information ==//
        row = sheet.createRow((short) startRow + 2);
        cell = (XSSFCell) row.createCell((short) 0);
        AbilityManagement.setThinBorder(cell, workbook);
        cell.setCellValue(1);

        //== content ==//
        //Tên
        cell = (XSSFCell) row.createCell((short) 1);
        AbilityManagement.setThinBorder(cell, workbook);
        cell.setCellValue(this.name);

        //Điện thoại
        cell = (XSSFCell) row.createCell((short) 2);
        AbilityManagement.setThinBorder(cell, workbook);
        cell.setCellValue(this.phoneNumber);

        //Địa chỉ
        cell = (XSSFCell) row.createCell((short) 3);
        AbilityManagement.setThinBorder(cell, workbook);
        cell.setCellValue(this.address);

        //Tuổi tối thiểu
        cell = (XSSFCell) row.createCell((short) 4);
        AbilityManagement.setThinBorder(cell, workbook);
        cell.setCellValue(this.minAge);

        //Tuổi tối đa
        cell = (XSSFCell) row.createCell((short) 5);
        AbilityManagement.setThinBorder(cell, workbook);
        cell.setCellValue(this.maxAge);
    }
}
