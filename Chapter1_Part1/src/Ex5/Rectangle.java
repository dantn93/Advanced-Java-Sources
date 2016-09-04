package Ex5;
import Ex3.*;
import Ex4.ICalculate;
/**
 * @author Tran Ngoc Dan
 * @version: 1.0
 * @day: 22/08/2016
 */
public class Rectangle implements ICalculate {
    private Point A;
    private Point C;

    public Rectangle(Point A, Point C) {
        this.A = A;
        this.C = C;
    }
    
    @Override
    public double calPerimeter(){
        Distance len = new Distance(A, new Point(C.getX(),A.getY()));//length
        Distance wid = new Distance(new Point(C.getX(),A.getY()), C);//width
        double perimeter = 2*(len.calDistance()+wid.calDistance());
        return perimeter;
    }
    
    @Override
    public double calArea(){
        Distance len = new Distance(A, new Point(C.getX(),A.getY()));//length
        Distance wid = new Distance(new Point(C.getX(),A.getY()), C);//width
        double area = len.calDistance()*wid.calDistance();
        return area;
    }
}
