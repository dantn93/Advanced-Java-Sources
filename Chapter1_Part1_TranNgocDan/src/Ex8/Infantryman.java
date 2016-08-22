/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex8;

/**
 *
 * @author snow
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
