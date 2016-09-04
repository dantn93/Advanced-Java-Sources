/**
 * This code calculates distance between 2 points.
 */
package Ex3;

import Ex2.Equation;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author Tran Ngoc Dan
 * @version: 1.0
 * @day: 22/08/2016
 * 
 */
public class DistanceMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        try {
            while (true) {
                System.out.println("==DISTANCE BETWEEN 2 POINTS==");
                System.out.println("Set coordinate of point A");
                System.out.print("x_A = ");
                double x = Double.parseDouble(input.readLine());
                System.out.print("y_A = ");
                double y = Double.parseDouble(input.readLine());
                Point A = new Point(x,y);
                
                System.out.println("Set coordinate of point B");
                System.out.print("x_A = ");
                x = Double.parseDouble(input.readLine());
                System.out.print("y_A = ");
                y = Double.parseDouble(input.readLine());
                Point B = new Point(x,y);
                
                //Distance between point A and B
                Distance d = new Distance(A,B);
                System.out.println("Distance between A and B: "+d.calDistance());
                
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
