/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vd2_openworkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class OpenWorkBook {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        File file = new File("src\\vd2_openworkbook\\openworkbook.xlsx");
        FileInputStream fIP = new FileInputStream(file);
        //Get the workbook instance for XLSX file 
        XSSFWorkbook workbook = new XSSFWorkbook(fIP);
        if (file.isFile() && file.exists()) {
            System.out.println(
                    "openworkbook.xlsx file open successfully.");
        } else {
            System.out.println("Error to open openworkbook.xlsx file.");
        }
    }
}
