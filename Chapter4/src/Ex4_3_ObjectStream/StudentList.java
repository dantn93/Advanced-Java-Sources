/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex4_3_ObjectStream;
/**
 *
 * @author Tran Ngoc Dan
 * @version 1.0
 * @since 12/09/2016
 */
public enum StudentList {
    PHUONG("Phuong Khuat", 17, 8.0, 7.0),
    HANH("Hanh Nguyen", 19, 8.5, 7.5),
    HOA("Hoa Huynh", 18, 7.5, 6.5),
    DUYEN("Duyen Phan", 20, 7.5, 7.5),
    HIEN("Hien Pham", 23, 9, 9),
    ANH("Tinh Anh", 23, 9, 8.5),
    NGHIA("Nghia Le", 23, 8, 8),
    NAM("Nam Le", 17, 10, 10),
    HUNG("Hung Phan", 16, 8, 8),
    LE("Le Doan", 20, 7, 8.5);

    private String name;
    private int age;
    private double mark1;
    private double mark2;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getMark1() {
        return mark1;
    }

    public double getMark2() {
        return mark2;
    }

    private StudentList(String name, int age, double mark1, double mark2) {
        this.name = name;
        this.age = age;
        this.mark1 = mark1;
        this.mark2 = mark2;
    }

}
