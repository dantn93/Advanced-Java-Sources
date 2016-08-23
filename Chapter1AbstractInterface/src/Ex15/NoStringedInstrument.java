/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex15;

/**
 * @author: Tran Ngoc Dan
 * @version: 1.0
 * @day: 23/08/2016
 */
public class NoStringedInstrument extends Instrument {

    private String howToPlay;

    public NoStringedInstrument(String howToPlay, String name, String publisher) {
        super(name, publisher);
        this.howToPlay = howToPlay;
    }

    //How to play instrument
    @Override
    public void play() {
        System.out.println("How to play: " + this.howToPlay);
    }

    @Override
    public void showInfo() {
        System.out.println("== SHOW INFORMATION == ");
        System.out.println("- Name: " + this.name);
        System.out.println("- Publisher: " + this.publisher);
        System.out.println("- How to play: " + this.howToPlay);
    }
}
