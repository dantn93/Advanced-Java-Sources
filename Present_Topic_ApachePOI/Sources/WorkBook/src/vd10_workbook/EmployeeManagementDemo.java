/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vd10_workbook;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
/**
 *
 * @author Tran Ngoc Dan
 * @since 30/09/2016
 */
public class EmployeeManagementDemo {

    public static void main(String[] args) {
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in, "UTF-8"));
            Company company = new Company();
            while (true) {
                System.out.println("1. Load database and write into excel file");
                System.out.println("2. Read excel file and write into database");
                System.out.println("0. Quit");
                int ans = -1;
                while (true) {
                    System.out.print("Choose: ");
                    ans = Integer.parseInt(input.readLine());
                    if (ans >= 0 && ans <= 2) {
                        break;
                    }
                }
                switch (ans) {
                    case 1:
                        company.loadDataBase();
                        company.exportToExcel();
                        break;
                    case 2:
                        company.loadWorkBook();
                        company.writeIntoDatabase();
                }
                if (ans == 0) {
                    break;
                }
            }
        } catch (Exception ex) {
            System.out.println("Err: " + ex.getMessage());
        }
    }
}
