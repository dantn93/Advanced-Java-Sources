/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex10;

/**
 *
 * @author snow
 */
public class Teacher extends Human {

    private String beChargOfClass;
    private double coefficient;
    private double bonus;

    public Teacher(String beChargOfClass, double coefficient, double bonus, String name, String dateOfbirth, String address, String numberPhone) {
        super(name, dateOfbirth, address, numberPhone);
        this.beChargOfClass = beChargOfClass;
        this.coefficient = coefficient;
        this.bonus = bonus;

        this.name = name;
        this.dateOfbirth = dateOfbirth;
        this.address = address;
        this.numberPhone = numberPhone;
    }

    public double getSalary() {
        return this.coefficient * 1260000 + this.bonus;
    }

    @Override
    public void showInfo() {
        System.out.println("Name: " + this.name);
        System.out.println("Date of Birth: " + this.dateOfbirth);
        System.out.println("Address: " + this.address);
        System.out.println("Phone number: " + this.numberPhone);
        System.out.println("Be charge of: " + this.beChargOfClass);
        System.out.println("Coefficient of Salary: " + this.coefficient);
        System.out.println("Bonus: " + this.bonus);
        System.out.println("Salary: " + this.getSalary());
    }

}
