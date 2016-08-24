package Ex14;
/**
 * @author: Tran Ngoc Dan
 * @version: 1.0
 * @day: 23/08/2016
 */
public abstract class Shape {

    public abstract double perimeter();

    public abstract double area();

    //Show information
    public void showInfo() {
        System.out.println("Perimeter: " + this.perimeter());
        System.out.println("Area: " + this.area());
    }
}
