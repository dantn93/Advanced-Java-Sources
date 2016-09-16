/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex27;

/**
 *
 * @author snow
 */
public class RedShapeDecorator extends ShapeDecorator{
    
    public RedShapeDecorator(Shape shape) {
        super(shape);
    }
    private String setRedBorder(){
        return "border color: Red";
    }
    @Override
    public String draw(){
        return this.shape.draw() + " and "+setRedBorder();
    }
    
}
