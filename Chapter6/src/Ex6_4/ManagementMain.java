/**
 * This code manages staff in a company
 */
package Ex6_4;

import Ex6_3.Student;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import static java.lang.System.in;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Tran Ngoc Dan
 * @version: 1.0
 * @day: 22/08/2016
 */
public class ManagementMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            List<Employee> list = new ArrayList<>();
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

                    Employee person = new Employee(name, coeff, num, bonus);
                    ObjectOutputStream out;
                    try {
                        out = new ObjectOutputStream(new FileOutputStream("src\\Ex6_4\\employee.txt", true)) {
                            @Override
                            protected void writeStreamHeader() throws IOException {
                                reset();
                            }
                        };
                        out.writeObject(person);
                        out.close();

                    } catch (FileNotFoundException ex) {
                    } catch (IOException ex) {

                    }
                }

                //load and show employee's info
                if (ans == 2) {
                    try (ObjectInputStream in = new ObjectInputStream(
                            new BufferedInputStream(new FileInputStream("src\\Ex6_4\\employee.txt")))) {

                        while (true) {
                            Employee em = (Employee) in.readObject();
                            list.add(em);
                        }
                    } catch (ClassNotFoundException | IOException ex) {
                        //    JOptionPane.showMessageDialog(rootPane, ex.getMessage());
                    }

                    //show list of employee
                    for (int i = 0; i < list.size(); i++) {
                        list.get(i).showInfo();
                    }
                }
                //search employee
                if (ans == 3) {

                }
                //quit
                if (ans == 4) {
                    break;
                }
            }

        } catch (Exception ex) {
            System.out.println("Err: " + ex.getMessage());

        }
    }

}
