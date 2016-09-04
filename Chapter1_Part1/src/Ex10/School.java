/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex10;

import java.util.ArrayList;

/**
 * @author Tran Ngoc Dan
 * @Date: 22/08/2016
 * @Version: 1.0
 */
public class School {
    private ArrayList<Student> std;
    private ArrayList<Teacher> tch;

    public School() {
        this.std = new ArrayList<Student>();
        this.tch = new ArrayList<Teacher>();
    }
    
    public void addTeacher(Teacher tch){
        this.tch.add(tch);
    }
    public void addStudent(Student std){
        this.std.add(std);
    }
    
    public void showAllTeachers(){
        System.out.println("== All Teachers ==");
        for(int i=0;i<tch.size();i++){
            System.out.println("-- Teacher["+(i+1)+"] --");
            tch.get(i).showInfo();
        }
    }
    
    public void showAllStudents(){
        System.out.println("== All Students ==");
        for(int i=0;i<std.size();i++){
            System.out.println("-- Student["+(i+1)+"] --");
            std.get(i).showInfo();
        }
    }
}
