package Ex8;
/**
 * @author Tran Ngoc Dan
 * @version: 1.0
 * @day: 22/08/2016
 */
public class Infantryman extends Soldier {

    public Infantryman(String name, int power, String weapon) {
        super(name, power, weapon);
    }

    public Infantryman() {
    }

    //If fight, 2 point would be subtracted from the competitor’s score
    @Override
    public int fight() {
        return 2;
    }

    @Override
    public void showInfo() {
        System.out.println("==Infantryman==");
        super.showInfo();
    }
}
