
package Ex3;

/**
 *
 * @author Tran Ngoc Dan
 * @version: 1.0
 * @day: 22/08/2016
 * 
 */
public class Distance {
    private double distance;
    private Point A;
    private Point B;

    public Distance(Point A, Point B) {
        this.A = A;
        this.B = B;
    }

    public double getDistance() {
        return this.distance;
    }
    
    //calculate distance between 2 point this.A and this.B
    public double calDistance(){
        this.distance = Math.sqrt(Math.pow(A.getX() - B.getX(),2) + Math.pow(A.getY() - B.getY(),2));
        return this.distance;
    }
}
