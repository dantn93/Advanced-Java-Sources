/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex4;

import Ex3.Distance;
import Ex3.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author snow
 */
public class Run {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        try {
            while (true) {
                System.out.println("==CALCULATE AREA AND PERIMETER OF A CIRCLE==");
                System.out.println("Set coordinate of center point");
                System.out.print("x_center = ");
                double x = Double.parseDouble(input.readLine());
                System.out.print("y_center = ");
                double y = Double.parseDouble(input.readLine());
                Point A = new Point(x,y);
                
                System.out.println("Set coordinate of point which on circle");
                System.out.print("x = ");
                x = Double.parseDouble(input.readLine());
                System.out.print("y = ");
                y = Double.parseDouble(input.readLine());
                Point B = new Point(x,y);
                
                Circle c = new Circle(A);
                c.setRadius(B);
                System.out.println("Perimeter of Circle: "+c.calPerimeter());
                System.out.println("Area of Circle: "+c.calArea());
                               
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
