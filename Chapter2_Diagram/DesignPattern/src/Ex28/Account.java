/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex28;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author snow
 */
public class Account {

    private List<Observer> observers = new ArrayList<>();
    private double state;//The balance

    public Account(double state){
        this.state = state;
    }
    public double getState() {
        return state;
    }

    public void setState(double state) {
        this.state = state;
        //If state > balance, it show the notif.
        notifyAllObservers();
    }

    public void attach(Observer observer) {
        observers.add(observer);

    }

    public void notifyAllObservers() {
        for (Observer observer : observers) {
            System.out.println(observer.update());
        }
    }
}
