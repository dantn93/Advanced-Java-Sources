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
public class PersonalActiveMark {

    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    private ArrayList<Double> mark;

    public PersonalActiveMark() {
        this.mark = new ArrayList<Double>();
    }

    //Nhập điểm tích cực (điểm xung phong)
    public void setActiveMark(ArrayList<Student> students) throws IOException {
        System.out.println("Bạn hãy nhập điểm TÍCH CỰC cho từng học viên");
        for (int i = 0; i < students.size(); i++) {
            double score = 0;
            while (true) {
                System.out.print("[Học viên] " + students.get(i).getName()+": ");
                score = Double.parseDouble(input.readLine());
                if (score >= 0) {
                    break;
                }
            }
            this.mark.add(score);
        }
        System.out.println("Hoàn thành việc nhập điểm!");
    }

    public ArrayList<Double> getPersonalActiveMark() {
        return this.mark;
    }
}
