package Ex8;
/**
 * @author Tran Ngoc Dan
 * @version: 1.0
 * @day: 22/08/2016
 */
public class Trooper extends Soldier {

    public Trooper(String name, int power, String weapon) {
        super(name, power, weapon);
    }

    public Trooper() {
    }

    //If fight, 3 point would be subtracted from the competitor’s score
    @Override
    public int fight() {
        return 3;
    }

    //Show all information
    @Override
    public void showInfo() {
        System.out.println("==Trooper==");
        super.showInfo();
    }
}
