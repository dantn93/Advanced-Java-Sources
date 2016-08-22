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
public class Student extends Human {

    private String cls;
    private double avgSem1;
    private double avgSem2;

    public Student(String cls, double avgSem1, double avgSem2, String name,
            String dateOfbirth, String address, String numberPhone) {
        this.cls = cls;
        this.avgSem1 = avgSem1;
        this.avgSem2 = avgSem2;

        this.name = name;
        this.dateOfbirth = dateOfbirth;
        this.address = address;
        this.numberPhone = numberPhone;
    }
    
    public double calAVG(){
        return (this.avgSem1 + this.avgSem2)/2;
    }

    @Override
    public void showInfo() {
        System.out.println("Name: " + this.name);
        System.out.println("Date of Birth: " + this.dateOfbirth);
        System.out.println("Address: " + this.address);
        System.out.println("Phone number: " + this.numberPhone);
        System.out.println("Class: " + this.cls);
        System.out.println("Mark in Semester I: " + this.avgSem1);
        System.out.println("Mark in Semester II: " + this.avgSem2);
        System.out.println("Average mark: " + this.calAVG());
    }
}
