package Ex14;
/**
 * @author: Tran Ngoc Dan
 * @version: 1.0
 * @day: 23/08/2016
 */
public class Square extends Shape {

    private double edge;

    public Square(double edge) {
        this.edge = edge;
    }

    //Calculate perimeter
    @Override
    public double perimeter() {
        return 4 * this.edge;
    }

    //Calculate area
    @Override
    public double area() {
        return this.edge * this.edge;
    }

}
