/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex9_2;

/**
 * @author Tran Ngoc Dan
 * @version 1.0
 * @since 08/09/2016
 */
public class CD implements Comparable<CD>{
    private String ID;
    private String name;
    private String singer;
    private int numberOfSong;
    private double price;

    public CD(String ID, String name, String singer, int numberOfSong, double price) {
        this.ID = ID;
        this.name = name;
        this.singer = singer;
        this.numberOfSong = numberOfSong;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
    
    
    //Get information
    public void showInfo(){
        System.out.println("ID: "+this.ID);
        System.out.println("Name: "+this.name);
        System.out.println("Singer: "+this.singer);
        System.out.println("NumberOfSongs: "+this.numberOfSong);
        System.out.println("Price: "+this.price);
        
    }

    @Override
    public int compareTo(CD o) {
        return this.name.compareTo(o.name);
    }
}
