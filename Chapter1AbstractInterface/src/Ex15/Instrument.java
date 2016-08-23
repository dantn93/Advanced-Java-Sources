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
public abstract class Instrument {

    protected String name;
    protected String publisher;

    public Instrument(String name, String publisher) {
        this.name = name;
        this.publisher = publisher;
    }

    //how to play instrument
    public abstract void play();

    //show all information of instrument
    public abstract void showInfo();
}
