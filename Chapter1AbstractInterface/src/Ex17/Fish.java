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
public class Fish extends Animal implements ISwimming, INonMolt, IWater{

    public Fish(String name, String food) {
        super(name, food);
    }

    @Override
    public void swim() {
        System.out.print(" swims below water\n");
    }

    @Override
    public void grownNormal() {
        System.out.print(" grows itself\n");
    }

    @Override
    public void liveInWater() {
        System.out.print(" lives in water\n");
    }
    
    public void showInfo(){
        System.out.println("Name: "+this.name);
        System.out.println("Food: "+this.food);
        System.out.print(this.name);
        this.swim();
        System.out.print(this.name);
        this.grownNormal();
        System.out.print(this.name);
        this.liveInWater();
    }
}
