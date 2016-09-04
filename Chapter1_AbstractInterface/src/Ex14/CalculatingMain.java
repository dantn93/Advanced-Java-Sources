/**
 * This code calculate perimeter & area of circle, rectangle, square
 */
package Ex14;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author: Tran Ngoc Dan
 * @version: 1.0
 * @day: 23/08/2016
 */
public class CalculatingMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("== Calculating Perimeter & Area ==");
            while (true) {
                while (true) {
                    System.out.println("1. Circle");
                    System.out.println("2. Rectangle");
                    System.out.println("3. Square");
                    System.out.print("Choose: ");
                    int ans = Integer.parseInt(input.readLine());
                    if (ans == 1) {//If choose Circle
                        double r = 0;
                        while (true) {//Input radius <= 0
                            System.out.print("Radius: ");
                            r = Double.parseDouble(input.readLine());
                            if (r > 0) {
                                break;
                            }
                        }
                        Circle obj = new Circle(r);
                        obj.showInfo();
                        break;
                    }
                    if (ans == 2) {//Choose Rectangle
                        double h = 0;
                        double w = 0;
                        while (true) {//if height <= 0
                            System.out.print("Height: ");
                            h = Double.parseDouble(input.readLine());
                            if (h > 0) {
                                break;
                            }
                        }
                        while (true) {//if width <= 0
                            System.out.print("Width: ");
                            w = Double.parseDouble(input.readLine());
                            if (w > 0) {
                                break;
                            }
                        }
                        Rectangle obj = new Rectangle(h, w);
                        obj.showInfo();
                        break;
                    }
                    if (ans == 3) {//Choose Square
                        double edge = 0;

                        while (true) {//if edge <= 0
                            System.out.print("Edge: ");
                            edge = Double.parseDouble(input.readLine());
                            if (edge > 0) {
                                break;
                            }
                        }
                        Square obj = new Square(edge);
                        obj.showInfo();
                        break;
                    }
                }

                //Ask continue
                boolean flag = false;
                while (true) {
                    System.out.print("Do you want another operation (y/n): ");
                    String agr = input.readLine();
                    if (agr.equalsIgnoreCase("y")) {
                        break;
                    } else if (agr.equalsIgnoreCase("n")) {
                        flag = true;
                        break;
                    }
                }
                if (flag == true) {
                    break;
                }

            }

        } catch (Exception ex) {
            System.out.println("Err: " + ex.getMessage());
        }
    }

}
