/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex4;
import Ex3.*;

/**
 *
 * @author: Tran Ngoc Dan
 * @date:   19/08/2016
 * 
 */
public class Circle implements ICalculate{
    private Point center; //center of circle
    private double radius; //radius of circle

    public Circle(Point center) {
        this.center = center;
    }

    public void setRadius(Point p) {
        Distance d = new Distance(this.center,p);
        this.radius = d.calDistance();
    }

    //Calculate Perimeter of Circle
    @Override
    public double calPerimeter(){
        double perimeter = 2*this.radius*3.14;
        return perimeter;
    }
    
    //Calculate Area of Circle
    @Override
    public double calArea(){
        double area = Math.pow(this.radius,2)*3.14;
        return area;
    }
}
