
package Ex2;

/**
 *
 * @author Tran Ngoc Dan
 * @version: 1.0
 * @day: 22/08/2016
 * 
 */
public class Equation {

    private double a;
    private double b;
    private String operator;

    public Equation() {
        this.a = 0;
        this.b = 0;
        this.operator = "";
    }

    public Equation(double a, double b, String operator) {
        this.a = a;
        this.b = b;
        this.operator = operator;
    }

    public void setA(double a) {
        this.a = a;
    }

    public void setB(double b) {
        this.b = b;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }
    
    //Calculate the equation
    //Output: return result of equation
    public double calculate() {
        double result = 0;
        if(this.operator.equals("+")){
            result = this.a + this.b;
        }
        if(this.operator.equals("-")){
            result = this.a - this.b;
        }
        if(this.operator.equals("*")){
            result = this.a * this.b;
        }
        if(this.operator.equals("/")){
            result = this.a / this.b;
        }
        return result;
    }
    
    //Print Result
    public void printOut(double result){
        System.out.println("Result: "+result);
    }
}
