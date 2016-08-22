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
