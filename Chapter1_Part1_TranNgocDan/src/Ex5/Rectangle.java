/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex5;
import Ex3.*;
import Ex4.ICalculate;

/**
 *
 * @author Tran Ngoc Dan
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
