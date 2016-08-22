/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex11;

/**
 * @author Tran Ngoc Dan
 * @Date: 22/08/2016
 * @Version: 1.0
 */
public class Transaction {
    protected String ID;
    protected String date;
    protected int number;

    public Transaction() {
        
    }

    public Transaction(String ID, String date, int number) {
        this.ID = ID;
        this.date = date;
        this.number = number;
    }
    
    
}
