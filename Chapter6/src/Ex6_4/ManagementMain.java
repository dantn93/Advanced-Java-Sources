/**
 * This code manages staff in a company
 */
package Ex6_4;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Tran Ngoc Dan
 * @version: 1.0
 * @day: 15/09/2016
 */
public class ManagementMain {

    static List<Employee> lst = new ArrayList<>();

    public static void main(String[] args) throws IOException,
            ClassNotFoundException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        try {
            // setEmployee(); // add default employee to file
            readInformation();
            while (true) {
                System.out.println("1. Add an employee");
                System.out.println("2. Load and show list of employee");
                System.out.println("3. Search an employee");
                System.out.println("4. Quit");
                int ans = 0;
                while (true) {
                    System.out.print("Choose: ");
                    ans = Integer.parseInt(input.readLine());
                    if (ans >= 1 && ans <= 4) {
                        break;
                    }
                }

                //add employee
                if (ans == 1) {
                    System.out.print("Name: ");
                    String name = input.readLine();
                    System.out.print("Coefficient of Salary: ");
                    double coeff = Double.parseDouble(input.readLine());
                    System.out.print("The number of people who are subtracted: ");
                    int num = Integer.parseInt(input.readLine());
                    System.out.print("Mothly bonus: ");
                    double bonus = Double.parseDouble(input.readLine());

                    Employee emp = new Employee(name, coeff, num, bonus);
                    lst.add(emp);
                    addEmployee();
                }

                //load and show employee's info
                if (ans == 2) {
                    for (Object o : lst) {
                        Employee emp = (Employee) o;
                        emp.showInfo();
                    }
                }
                //search employee
                if (ans == 3) {
                    System.out.print("[Name]: ");
                    String name = input.readLine();
                    System.out.println("== Result ==");
                    searchEmployee(name);
                }
                //quit
                if (ans == 4) {
                    break;
                }
            }
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    // function add new employee
    public static void addEmployee() {
        ObjectOutputStream out;
        try {
            out = new ObjectOutputStream(new FileOutputStream("src/Ex6_4/employee.txt"));
            out.reset();
            for (Object o : lst) {
                Employee e = (Employee) o;
                out.writeObject(e);
            }
            System.out.println("completed !");
            out.flush();

            out.close();
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    // function read information of employee
    public static void readInformation() throws FileNotFoundException,
            IOException, ClassNotFoundException {
        ObjectInputStream in = null;
        FileInputStream file = new FileInputStream("src\\Ex6_4\\employee.txt");
        if (file.available() != 0) {
            try {
                in = new ObjectInputStream(file);
                while (true) {
                    lst.add((Employee) in.readObject());
                }
            } catch (EOFException e) {
                in.close();
            }
        }
    }

    //Search an employee
    public static void searchEmployee(String name) {
        int count = 0;
        for (int i = 0; i < lst.size(); i++) {
            if (lst.get(i).getName().equalsIgnoreCase(name)) {
                lst.get(i).showInfo();
            } else {
                count++;
            }
        }
        if(count == lst.size())
            System.out.println("Don't have that employee");
    }
}
