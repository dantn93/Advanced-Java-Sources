/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bigex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author snow
 */
public class PersonalExerciseMark {

    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    private ArrayList<Double> mark;

    public PersonalExerciseMark() {
        this.mark = new ArrayList<Double>();
    }

    public void setExMark(ArrayList<Student> students) throws IOException {
        System.out.println("Bạn hãy nhập điểm BÀI TẬP cá nhân cho từng học viên");
        for (int i = 0; i < students.size(); i++) {
            double score = 0;
            while (true) {
                System.out.print("[Học viên] " + students.get(i).getName() + ": ");
                score = Double.parseDouble(input.readLine());
                if (score >= 0) {
                    break;
                }
            }
            this.mark.add(score);
        }
        System.out.println("Hoàn thành việc nhập điểm!");
    }
    
    public ArrayList<Double> getPersonalExerciseMark(){
        return this.mark;
    }
    public int getSize(){
        return this.mark.size();
    }
}
