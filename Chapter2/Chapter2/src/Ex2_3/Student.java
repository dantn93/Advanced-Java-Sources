/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex2_3;

/**
 *
 * @author snow
 */
public class Student {
    private String name;
    private int age;
    private String placeOfBirth;

    public Student(String name, int age, String placeOfBirth) {
        this.name = name;
        this.age = age;
        this.placeOfBirth = placeOfBirth;
    }
    
    public void showInfo(){
        System.out.println("[Name]: "+this.name);
        System.out.println("[Age]: "+this.age);
        System.out.println("[Place of birth]: "+this.placeOfBirth);
    }
}
