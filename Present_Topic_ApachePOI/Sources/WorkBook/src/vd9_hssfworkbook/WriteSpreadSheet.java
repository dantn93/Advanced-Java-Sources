package vd9_hssfworkbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class WriteSpreadSheet {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        //Create blank workbook
        HSSFWorkbook workbook = new HSSFWorkbook();
        //Create a blank sheet
        HSSFSheet spreadsheet = workbook.createSheet("Employee Info");
        //Create row object
        HSSFRow row;
        //This data needs to be written (Object[])
        Map< String, Object[]> empinfo
                = new TreeMap< String, Object[]>();
        empinfo.put("1", new Object[]{
            "EMP ID", "EMP NAME", "DESIGNATION"});
        empinfo.put("2", new Object[]{
            "tp01", "Gopal", "Technical Manager"});
        empinfo.put("3", new Object[]{
            "tp02", "Manisha", "Proof Reader"});
        empinfo.put("4", new Object[]{
            "tp03", "Masthan", "Technical Writer"});
        empinfo.put("5", new Object[]{
            "tp04", "Satish", "Technical Writer"});
        empinfo.put("6", new Object[]{
            "tp05", "Krishna", "Technical Writer"});
        //Iterate over data and write to sheet
        Set< String> keyid = empinfo.keySet();
        int rowid = 0;
        for (String key : keyid) {
            //create one row
            row = spreadsheet.createRow(rowid++);
            Object[] objectArr = empinfo.get(key);
            int cellid = 0;
            for (Object obj : objectArr) {
                //create cells in a row
                HSSFCell cell = row.createCell(cellid++);
                //set cell's value
                cell.setCellValue((String) obj);
            }
        }
        try ( //Write the workbook in file system
                FileOutputStream out = new FileOutputStream(
                        new File("src\\vd9_hssfworkbook\\Writesheet.xls"))) {
            workbook.write(out);
        }
        System.out.println("Writesheet.xls written successfully");
    }
}
