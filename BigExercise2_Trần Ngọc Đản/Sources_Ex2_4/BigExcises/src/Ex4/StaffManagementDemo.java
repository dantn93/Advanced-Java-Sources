/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;

/**
 * @author Tran Ngoc Dan
 * @since 19/09/2016
 * @version 1.0
 */
public class StaffManagementDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            List<Employee> list = new ArrayList<>();
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
            //load current employee
            loadEmployee(list);
            while (true) {
                System.out.println("1. Show all of employee");
                System.out.println("2. Employee whose salary is greater than 3000000");
                System.out.println("3. Employee whose name includes string \"Anh\"");
                System.out.println("4. Average age");
                System.out.println("5. Statistics");
                System.out.println("6. Quit");
                int ans = 0;
                while (true) {
                    System.out.print("Choose: ");
                    ans = Integer.parseInt(input.readLine());
                    if (ans >= 1 && ans <= 6) {
                        break;
                    }
                }

                switch (ans) {
                    case 1://show all of employee
                        list.stream().forEach(e -> e.showInfo());
                        break;
                    case 2://2. Employee whose salary greater than 3000000
                        double salary = 3000000;
                        checkSalary(salary, list);
                        break;
                    case 3://3. Employee whose name includes string "Anh"
                        String name = "Anh";
                        checkName(name, list);
                        break;
                    case 4://4. Average age
                        double avAge = calAverageAge(list);
                        System.out.println("Average age: " + avAge);
                        break;
                    case 5://5. Statistics
                        salaryStatistic(list);
                        break;
                    default:
                }
                if (ans == 6) {//break out while loop
                    break;
                }
            }
        } catch (IOException | NumberFormatException ex) {
            System.out.println("Err: " + ex.getMessage());
        }
    }

    /**
     * load all of employee from enum Estaff.
     *
     * @param list
     */
    public static void loadEmployee(List<Employee> list) {
        for (EStaff value : EStaff.values()) {
            list.add(new Employee(value.getName(), value.getAge(), value.getSalary()));
        }
    }

    /**
     * check salary satisfy the conditional.
     *
     * @param salary
     * @param list
     */
    public static void checkSalary(double salary, List<Employee> list) {
        //count number of employee has his/her salary > 3000000;
        int count = (int) list.stream().filter(e -> e.getSalary() > salary).count();
        System.out.println("[quantity]: " + count);
        System.out.println("");
        list.stream().filter(e -> e.getSalary() > salary).forEach(e -> e.showInfo());
    }

    /**
     * check name satisfy the condition.
     *
     * @param name
     * @param list
     */
    public static void checkName(String name, List<Employee> list) {
        int count = (int) list.stream().filter(e -> e.getName().contains(name)).count();
        System.out.println("[quantity]: " + count);
        list.stream().filter(e -> e.getName().contains(name)).forEach(e -> e.showInfo());
        System.out.println("");
    }

    /**
     * calculate average age of all employee.
     *
     * @param list
     * @return
     */
    public static double calAverageAge(List<Employee> list) {
        int sumAge = 0;
        sumAge = list.stream().map(e -> e.getAge()).reduce(0, Integer::sum);
        if (list.size() > 0) {
            return (double) sumAge / list.size();
        }
        return sumAge;
    }

    /**
     * salary satistics.
     *
     * @param list
     */
    public static void salaryStatistic(List<Employee> list) {
        DoubleSummaryStatistics stats = list.stream().mapToDouble(e -> e.getSalary()).summaryStatistics();
        System.out.println("Maximum salary: " + String.format("%.2f", stats.getMax()));
        System.out.println("Minimum salary: " + String.format("%.2f", stats.getMin()));
        System.out.println("Average salary: " + String.format("%.2f", stats.getAverage()));
    }
}
