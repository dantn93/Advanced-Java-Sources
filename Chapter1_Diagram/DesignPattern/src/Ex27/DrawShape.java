/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex27;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author snow
 */
public class DrawShape {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                int ans = 0;
                while (true) {
                    System.out.println("1. Circle with normal border");
                    System.out.println("2. Circle of red border");
                    System.out.println("3. Rectangle with normal border");
                    System.out.println("4. Rectangle of red border");
                    System.out.print("Choose: ");
                    ans = Integer.parseInt(input.readLine());
                    if (ans >= 1 && ans <= 4) {
                        break;
                    }
                }
                switch (ans) {
                    case 1:
                        Shape circle = new Circle();
                        System.out.println(circle.draw());
                        break;
                    case 2:
                        Shape redCircle = new RedShapeDecorator(new Circle());
                        System.out.println(redCircle.draw());
                        break;
                    case 3:
                        Shape rectangle = new Rectangle();
                        System.out.println(rectangle.draw());
                        break;
                    case 4:
                        Shape redRectangle = new RedShapeDecorator(new Rectangle());
                        System.out.println(redRectangle.draw());
                }
                //Ask continue
                boolean flag = false;
                while (true) {
                    System.out.print("\n\nDo you want another operation (y/n): ");
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
