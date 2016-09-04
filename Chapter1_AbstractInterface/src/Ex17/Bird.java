package Ex17;

/**
 * @author: Tran Ngoc Dan
 * @version: 1.0
 * @day: 23/08/2016
 */
public class Bird extends Animal implements IFlying, INonMolt, INest {

    public Bird(String name, String food) {
        super(name, food);
    }

    
    @Override
    public void fly() {
        System.out.print(" flys in the sky\n");
    }

    @Override
    public void grownNormal() {
        System.out.print(" loses feathers\n");
    }

    @Override
    public void nesting() {
        System.out.print(" makes a bird nest\n");
    }
    
    public void showInfo(){
        System.out.println("Name: "+this.name);
        System.out.println("Food: "+this.food);
        System.out.print(this.name);
        this.fly();
        System.out.print(this.name);
        this.grownNormal();
        System.out.print(this.name);
        this.nesting();
    }
}
