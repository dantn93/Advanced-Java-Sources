/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex7_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author Tran Ngoc Dan
 * @version 1.0
 * @since 16/09/2016
 */
public class StaffManagementDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            //this manages employee and department
            Management management = new Management();
            //load data
            management.loadDepartment();
            management.loadEmployee();
            while (true) {
                System.out.println("1. Show all employee in a department");
                System.out.println("2. Add new employee");
                System.out.println("3. Exit");

                int ans = 0;
                while (true) {
                    System.out.print("Choose: ");
                    ans = Integer.parseInt(input.readLine());
                    if (ans >= 1 && ans <= 6) {
                        break;
                    }
                }
                switch (ans) {
                    case 1://show all employee in a department
                        System.out.println("== Show all employee in a department ==");
                        int size = management.getSizeDepartment();
                        if (size > 0) {
                            int choose;
                            while (true) {//choose department
                                management.showAllDeparment();
                                System.out.print("Choose: ");
                                choose = Integer.parseInt(input.readLine());
                                if (choose > 0 && choose <= size) {
                                    break;
                                }
                            }
                            //show all employee in department "choose - 1"
                            management.showAllEmployeeInADepartment(choose - 1);
                        } else {
                            System.out.println("Don't have any department");
                        }
                        break;
                    case 2://add new employee into a department
                        System.out.println("== Add new employee into a department ==");
                        size = management.getSizeDepartment();
                        if (size > 0) {
                            int choose;
                            while (true) {//choose department
                                management.showAllDeparment();
                                System.out.print("Choose: ");
                                choose = Integer.parseInt(input.readLine());
                                if (choose > 0 && choose <= size) {
                                    break;
                                }
                            }
                            int idIndex = choose - 1;
                            System.out.println("== Fill information ==");
                            System.out.print("[id]: ");
                            String id = input.readLine();
                            System.out.print("[name]: ");
                            String name = input.readLine();
                            System.out.print("[sex](1-male/0-female/others-Undefined): ");
                            String sex = input.readLine();
                            System.out.print("[day of birth]: ");
                            String dOb = input.readLine();
                            System.out.print("[salary]: ");
                            double salary;
                            while (true) {
                                salary = Double.parseDouble(input.readLine());
                                if (salary > 0) {
                                    break;
                                }
                            }
                            System.out.print("[address]: ");
                            String address = input.readLine();
                            management.addNewEmployee(id, name, sex, dOb, salary, address, idIndex);

                        } else {
                            System.out.println("Don't have any department");
                        }
                }
                if (ans == 3) {
                    //when you quit the process, don_vi.xml & nhan_vien.xml file will update
                    management.updateFileData();
                    break;
                }
            }

        } catch (Exception ex) {
            System.out.println("Err: " + ex.getMessage());
        }
    }

}
