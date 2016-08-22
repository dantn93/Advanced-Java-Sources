/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex12;

import java.util.ArrayList;
/**
 * @author Tran Ngoc Dan
 * @Date: 22/08/2016
 * @Version: 1.0
 */
public class BookCollection {

    private ArrayList<TextBook> txtb;
    private ArrayList<ReferenceBook> refb;

    public BookCollection() {
        this.txtb = new ArrayList<TextBook>();
        this.refb = new ArrayList<ReferenceBook>();
    }

    //Add TextBook into Collection
    public void addTextBook(TextBook tb) {
        this.txtb.add(tb);
    }

    //Add ReferenceBook into Collection
    public void addRefBook(ReferenceBook refb) {
        this.refb.add(refb);
    }

    //Calculate total price of all textbook
    public double calTotalTextBookPrice() {
        double sum = 0;
        for (int i = 0; i < txtb.size(); i++) {
            sum += this.txtb.get(i).getTotalPrice();
        }
        return sum;
    }

    //Calculate average price of all textbooks
    public double avgTextBookPrice() {
        if (this.txtb.size() > 0) {
            return calTotalTextBookPrice() / this.txtb.size();
        } else {
            return 0;
        }
    }

    //Calculate total price of all reference book
    public double calTotalRefBookPrice() {
        double sum = 0;
        for (int i = 0; i < refb.size(); i++) {
            sum += this.refb.get(i).getTotalPrice();
        }
        return sum;
    }

    //Calculate average price of all reference books
    public double avgRefBookPrice() {
        if (this.refb.size() > 0) {
            return calTotalRefBookPrice() / this.refb.size();
        } else {
            return 0;
        }
    }

    public void showInfo() {
        System.out.println("\n\n== SHOW ALL INFORMATION IN THE LIBRARY ==");
        System.out.println("-- TextBook --");
        for (int i = 0; i < this.txtb.size(); i++) {
            System.out.println("TextBook [" + (i + 1) + "]:");
            this.txtb.get(i).showInfo();
            System.out.println("");
        }
        System.out.println("Total Price of TextBook: " + this.calTotalTextBookPrice());
        System.out.println("\n\n-- Reference Book --");
        for (int i = 0; i < this.refb.size(); i++) {
            System.out.println("ReferenceBook [" + (i + 1) + "]:");
            this.refb.get(i).showInfo();
            System.out.println("");
        }
        System.out.println("Total Price of ReferenceBook: " + this.calTotalRefBookPrice());
        System.out.println("Average Price of ReferenceBook: " + this.avgRefBookPrice());
    }
}
