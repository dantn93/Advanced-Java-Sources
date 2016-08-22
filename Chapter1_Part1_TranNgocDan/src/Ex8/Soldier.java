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
public class Soldier {

    String name;
    int power;
    String weapon;

    public Soldier(String name, int power, String weapon) {
        this.name = name;
        this.power = power;
        this.weapon = weapon;
    }

    public Soldier() {
        this.name = "";
        this.power = 0;
        this.weapon = "";
    }

    //Get Power of Soldier
    public int getPower() {
        return this.power;
    }

    //If fight, 1 point would be subtracted from the competitor’s score
    public int fight() {
        return 1;
    }
    
    //If Soldier is fighted, he will be subtracted power(reference) point himself. 
    public void subPower(int power) {
        this.power = this.power - power;
    }

    public void showInfo() {
        System.out.println("Name: " + this.name);
        System.out.println("Power: " + this.power);
        System.out.println("Weapon: " + this.weapon);
    }
}
