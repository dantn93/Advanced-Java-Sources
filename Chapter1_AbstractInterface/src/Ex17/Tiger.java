package Ex17;

/**
 * @author: Tran Ngoc Dan
 * @version: 1.0
 * @day: 23/08/2016
 */
public class Tiger extends Animal implements ISwimming, IRunning, INonMolt, IBurrowing {

    public Tiger(String name, String food) {
        super(name, food);
    }

    @Override
    public void swim() {
        System.out.print(" swim above water\n");
    }

    @Override
    public void run() {
        System.out.print(" run so fast\n");
    }

    @Override
    public void grownNormal() {
        System.out.print(" loses feathers\n");
    }

    @Override
    public void burrowing() {
        System.out.print(" lives in a tiger cave\n");
    }

    public void showInfo(){
        System.out.println("Name: "+this.name);
        System.out.println("Food: "+this.food);
        System.out.print(this.name);
        this.swim();
        System.out.print(this.name);
        this.run();
        System.out.print(this.name);
        this.grownNormal();
        System.out.print(this.name);
        this.burrowing();
    }
}
