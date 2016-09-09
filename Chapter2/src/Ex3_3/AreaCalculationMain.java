package Ex3_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author Tran Ngoc Dan
 * @version 1.0
 * @since 09/09/2016
 */
public class AreaCalculationMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Nhap ban kinh: ");
            double r = Double.parseDouble(input.readLine());
            Area circle = (double x1, double x2) -> x1 * Math.pow(x2, 2);
            System.out.println("S = PI* (r*r) = " + circle.calArea(Math.PI, r));
            System.out.print("Nhap chieu dai: ");
            double H = Double.parseDouble(input.readLine());
            System.out.print("Nhap chieu rong: ");
            double W = Double.parseDouble(input.readLine());
            Area rectangle = (double x1,double x2) -> x1*x2;
            System.out.println("S = W x H = "+rectangle.calArea(W, H));
        } catch (Exception ex) {
            System.out.println("Err: " + ex.getMessage());
        }
    }

}
