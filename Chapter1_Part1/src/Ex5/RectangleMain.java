/**
 * This code calculates perimeter & area of rectangle
 */
package Ex5;

import Ex3.Point;
import Ex4.Circle;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author Tran Ngoc Dan
 * @version: 1.0
 * @day: 22/08/2016
 */
public class RectangleMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        try {
            while (true) {
                System.out.println("==CALCULATE AREA AND PERIMETER OF A RECTANGLE==");
                System.out.println("Set coordinate of point A");
                System.out.print("x_A = ");
                double xA = Double.parseDouble(input.readLine());
                System.out.print("y_A = ");
                double yA = Double.parseDouble(input.readLine());
                Point A = new Point(xA, yA);

                System.out.println("Set coordinate of point C");
                System.out.print("x_C = ");
                double xC = Double.parseDouble(input.readLine());
                System.out.print("y_C = ");
                double yC = Double.parseDouble(input.readLine());
                Point C = new Point(xC, yC);
                if(xA == xC ||yA == yC){
                    System.out.println("Khong the tao ra hinh chu nhat \n(co cac canh song song voi truc toa do)");
                    continue;
                }
                Rectangle obj = new Rectangle(A, C);

                System.out.println("Perimeter of Rectangle: " + obj.calPerimeter());
                System.out.println("Area of Rectangle: " + obj.calArea());

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
