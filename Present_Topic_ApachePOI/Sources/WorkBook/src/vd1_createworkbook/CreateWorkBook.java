package vd1_createworkbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CreateWorkBook {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
        //Create Blank workbook (Tạo workbook trống)
        XSSFWorkbook workbook = new XSSFWorkbook();
        //Create file system using specific name (Tạo file).
        FileOutputStream out = new FileOutputStream(
                new File("src\\vd1_createworkbook\\createworkbook.xlsx"));
        //write operation workbook using file out object
        //** Viết những thao tác trong workbook vào file.
        workbook.write(out);
        out.close();
        System.out.println("createworkbook.xlsx written successfully");
    }
}
