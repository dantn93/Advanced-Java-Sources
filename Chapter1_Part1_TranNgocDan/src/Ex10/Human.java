/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex10;

/**
 * @author Tran Ngoc Dan
 * @Date: 22/08/2016
 * @Version: 1.0
 */
public class Human {
    protected String name;
    protected String dateOfbirth;
    protected String address;
    protected String numberPhone;

    public Human() {
        this.name = "";
        this.dateOfbirth = "";
        this.address = "";
        this.numberPhone = "";
    }

    public Human(String name, String dateOfbirth, String address, String numberPhone) {
        this.name = name;
        this.dateOfbirth = dateOfbirth;
        this.address = address;
        this.numberPhone = numberPhone;
    }
    
    public void showInfo(){
        
    }
    
}
