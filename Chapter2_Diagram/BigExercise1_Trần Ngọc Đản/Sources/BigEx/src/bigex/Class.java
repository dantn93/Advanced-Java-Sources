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
public class Class {

    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    private String contrastNumber;
    private String className;
    private String startDate;
    private String endDate;
    private int numberOfLesson; //number of lesson in all of subjects
    private Teacher teacher;//homeroomTeacher
    private ArrayList<Subject> subjects;
    private ArrayList<Student> students;
    private ArrayList<String> generalComment;

    public Class(String contrastNumber, String className, String startDate, String endDate, int numberOfLesson, Teacher teacher) {
        this.contrastNumber = contrastNumber;
        this.className = className;
        this.startDate = startDate;
        this.endDate = endDate;
        this.numberOfLesson = numberOfLesson;
        this.teacher = teacher;
        this.subjects = new ArrayList<Subject>();
        this.students = new ArrayList<Student>();
        this.generalComment = new ArrayList<String>();
    }

    public String getContrastNumber() {
        return contrastNumber;
    }

    public String getClassName() {
        return className;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public int getNumberOfLesson() {
        return numberOfLesson;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void updateInfoInClass() throws IOException {
        while (true) {
            //Hướng dẫn
            guide();

            int ans = 0;
            //Kiểm tra nhập
            while (true) {
                System.out.print("Chọn: ");
                ans = Integer.parseInt(input.readLine());
                if (ans >= 1 && ans <= 5) {
                    break;
                }
            }
            //Thêm học sinh
            if (ans == 1) {
                System.out.print("[Nhập] Tên học viên: ");
                String name = input.readLine();
                System.out.print("[Nhập] Số điên thoại: ");
                //String numberPhone = input.readLine();
                String numberPhone = "123";
                System.out.println("");
                
                
                System.out.print("[Nhập] Email: ");
                //String email = input.readLine();
                String email = "123";
                System.out.println("");
                
                
                System.out.print("[Nhập] Ngày sinh: ");
                //String dOb = input.readLine();
                String dOb = "123";
                System.out.println("");
                
                
                students.add(new Student(name, numberPhone, email, dOb));
            }
            if (ans == 2) {
                System.out.print("[Nhập] Tên môn học: ");
                String name = input.readLine();
                System.out.println("Thông tin giáo viên đứng lớp");
                System.out.print("[Nhập] Tên giáo viên: ");
                //String nameofTeacher = input.readLine();
                String nameofTeacher = "nhu";
                System.out.println("");
                
                
                System.out.print("[Nhập] Số điên thoại: ");
                //String numberPhone = input.readLine();
                String numberPhone = "123";
                System.out.println("");
                
                
                System.out.print("[Nhập] email: ");
                //String email = input.readLine();
                String email = "123";
                System.out.println("");
                
                
                System.out.print("[Nhập] Khả năng giảng dạy của giáo viên: ");
                //String potentiality = input.readLine();
                String potentiality = "Môn gì cũng biết dạy ^_^";
                System.out.println("");
                
                
                Teacher teacher = new Teacher(nameofTeacher, numberPhone, email, potentiality);
                System.out.print("[Nhập] Số tiết học: ");
                int numberOfLesson = 10;//number of lesson in this subject
                while (true) {
                    //numberOfLesson = Integer.parseInt(input.readLine());
                    numberOfLesson = 10;
                    if (numberOfLesson > 0) {
                        break;
                    }
                }
                System.out.println("");
                
                
                System.out.print("[Nhập] Ngày bắt đầu: ");
                //String startDate = input.readLine();
                String startDate = "1";
                System.out.println("");
                
                
                System.out.print("[Nhập] Ngày kết thúc: ");
                //String endDate = input.readLine();
                String endDate = "10";
                System.out.println("");
                
                
                subjects.add(new Subject(name, teacher, numberOfLesson, startDate, endDate));
            }
            if (ans == 3) {
                for (int i = 0; i < this.students.size(); i++) {
                    System.out.println("[Học viên] " + this.students.get(i).getName());
                    System.out.print("[Nhận xét]: ");
                    this.generalComment.add(input.readLine());
                }
            }
            if (ans == 4) {
                for (int i = 0; i < this.students.size(); i++) {
                    System.out.println("-----------------------------------------");
                    System.out.println("[Học viên] " + this.students.get(i).getName());
                    for (int j = 0; j < this.subjects.size(); j++) {
                        System.out.println("[Môn] " + this.subjects.get(j).getName());
                        ArrayList<Double> finalmark = this.subjects.get(j).calFinalMark(students);
                        System.out.print("Điểm tổng kết: ");
                        System.out.println(finalmark.get(i) + "\n");
                    }
                }
            }
            if (ans == 5) {
                //Thoát ra khỏi lớp thì in thông tin 
                break;
            }
        }
        //Tính điểm cho học sinh, thì mỗi học Subject sẽ có một bộ phận quản lý
        //Hỏi người dùng muốn thao tác trong subject nào
        String ans1 = "";
        int ans2 = 0;
        while (true) {
            while (true) {
                System.out.print("Bạn muốn cập nhật điểm cho từng môn không (y/n): ");
                ans1 = input.readLine();
                if (ans1.equalsIgnoreCase("y") || ans1.equalsIgnoreCase("n")) {
                    break;
                }
            }
            if (ans1.equalsIgnoreCase("y") && subjects.size() > 0) {
                //Kiểm tra nhập
                while (true) {
                    System.out.println("Bạn muốn thao tác trên môn học nào?");
                    for (int i = 0; i < subjects.size(); i++) {
                        System.out.println((i + 1) + ". " + subjects.get(i).getName());
                    }
                    System.out.println((subjects.size() + 1) + ". Thoát");
                    System.out.print("Chọn: ");
                    ans2 = Integer.parseInt(input.readLine());
                    if (ans2 >= 1 && ans2 <= subjects.size() + 1) {
                        break;
                    }
                }
                if (ans2 == subjects.size() + 1) {
                    break;
                } else {
                    subjects.get(ans2 - 1).updateInfoInSubject(students);
                }
            }
            if (subjects.size() <= 0) {
                System.out.println("Không có môn học nào. Cần tạo môn học trước khi cập nhật điểm");
                break;
            }
            if (ans1.equalsIgnoreCase("n")) {
                break;
            }
        }
    }

    private void guide() {
        System.out.println("1. Thêm học sinh vào lớp");
        System.out.println("2. Thêm môn học");
        System.out.println("3. [Nhập] Nhận xét chung của giáo viên (sau khi đã học xong các lớp)");
        System.out.println("4. In thông tin của lớp học (sau khi đã tạo môn học và vào học)");
        System.out.println("5. Thoát");
    }
}
