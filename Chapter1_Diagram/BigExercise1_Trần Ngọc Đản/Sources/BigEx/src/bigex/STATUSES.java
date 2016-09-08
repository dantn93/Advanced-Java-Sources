/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bigex;

/**
 *
 * @author snow
 */
public enum STATUSES {
    dihoc(1, "đi học", 10),
    vanghoc(2, "vắng học", 0),
    ditre(3, "đi trễ", 5),
    vesom(4, "về sớm", 5);
    private String status;
    private double mark;
    private int id;
    
    private STATUSES(int id, String status, double mark){
        this.status = status;
        this.mark = mark;
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public double getMark() {
        return mark;
    }
    
    public int getID(){
        return this.id;
    }
    
}
