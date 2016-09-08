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
import java.util.Date;

/**
 *
 * @author snow
 */
public class Subject {

    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    private String name;
    private Teacher teacher;//teacher is charge of the subject
    private int numberOfLesson;//number of lesson in this subject
    private String startDate;
    private String endDate;
    private Management management;

    public Subject(String name, Teacher teacher, int numberOfLesson, String startDate, String endDate) {
        this.name = name;
        this.teacher = teacher;
        this.numberOfLesson = numberOfLesson;
        this.startDate = startDate;
        this.endDate = endDate;
        this.management = new Management();
    }

    public String getName() {
        return name;
    }

    public int getNumberOfLesson() {
        return numberOfLesson;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void updateInfoInSubject(ArrayList<Student> students) throws IOException {
        while (true) {
            System.out.println("\n1. Điểm danh");
            System.out.println("2. Cập nhật điểm danh");
            System.out.println("3. Nhập điểm cá nhân (bài tập về nhà, điểm tích cực)");
            System.out.println("4. Nhập điểm cuối môn (bài tập lớn, trắc nghiệm)");
            System.out.println("5. Nhập nhận xét của giáo viên phụ trách môn");
            System.out.println("6. Nhập nhận xét của giáo viên chủ nhiệm");
            System.out.println("7. Xuất thông tin điểm cho học viên");
            System.out.println("8. Thoát");
            int ans = 0;
            while (true) {
                System.out.print("Chọn: ");
                ans = Integer.parseInt(input.readLine());
                if (ans >= 1 && ans <= 8) {
                    break;
                }
            }
            //1. Điểm danh
            //2...
            switch (ans) {
                case 1:
                    this.management.setInfoStatus(students);
                    break;
                case 2:
                    this.management.updateInfoStatus(students);
                    break;
                case 3:
                    this.management.setPersonalMark(students);
                    break;
                case 4:
                    this.management.setBigExMark(students);
                    break;
                case 5:
                    this.management.setCommentOfTeacher(students);
                    break;
                case 6:
                    this.management.setCommentOfHomeRoomTeacher(students);
                    break;
                case 7:
                    this.management.showInfo(students);
            }
            if (ans == 8) {
                break;
            }
        }
    }
    public ArrayList<Double> calFinalMark(ArrayList<Student> students) throws IOException {
        return this.management.calFinalMark(students);
    }
}
