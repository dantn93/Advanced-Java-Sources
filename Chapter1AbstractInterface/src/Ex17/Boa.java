/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex17;

/**
 * @author: Tran Ngoc Dan
 * @version: 1.0
 * @day: 23/08/2016
 */
public class Boa extends Animal implements ISwimming, IMolt, IBurrowing {

    public Boa(String name, String food) {
        super(name, food);
    }

    @Override
    public void swim() {
        System.out.print(" swims above water\n");
    }

    @Override
    public void molting() {
        System.out.print(" grows by molting\n");
    }

    @Override
    public void burrowing() {
        System.out.print(" lives in snake cave\n");
    }

    public void showInfo(){
        System.out.println("Name: "+this.name);
        System.out.println("Food: "+this.food);
        System.out.print(this.name);
        this.swim();
        System.out.print(this.name);
        this.molting();
        System.out.print(this.name);
        this.burrowing();
    }
}
