/**
 * This code runs equation + - * /
 */
package Ex2;

import Ex1.LinearEquation;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author Tran Ngoc Dan
 * @version 1.0
 * @date 22/08/2016
 */
public class EquationMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        try {
            while (true) {
                System.out.println("==EQUATION==");
                System.out.print("a = ");
                double a = Double.parseDouble(input.readLine());

                System.out.print("b = ");
                double b = Double.parseDouble(input.readLine());

                System.out.println("Operator:");
                System.out.println("1. +");
                System.out.println("2. -");
                System.out.println("3. *");
                System.out.println("4. /");

                System.out.print("Choose: ");
                int operator = Integer.parseInt(input.readLine());

                String opt = "";
                switch (operator) {
                    case 1:
                        opt = "+";
                        break;
                    case 2:
                        opt = "-";
                        break;
                    case 3:
                        opt = "*";
                        break;
                    case 4:
                        opt = "/";
                }

                Equation obj = new Equation(a, b, opt);
                obj.printOut(obj.calculate());

                System.out.print("Do you want to continue (y/n)? ");
                String ans;
                while (true) {
                    ans = input.readLine();
                    if (ans.equalsIgnoreCase("y")) {
                        break;
                    } else {
                        System.exit(0);
                    }
                }

            }
        } catch (Exception ex) {
            System.out.println("Err: ");
        }
    }

}
