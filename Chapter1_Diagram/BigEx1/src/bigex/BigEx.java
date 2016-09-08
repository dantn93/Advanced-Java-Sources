/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bigex;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BigEx {

    public static void main(String[] args) {
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            //Create Center
            Center center = new Center();
            //Add a Class
            while (true) {
                int ans1 = 0;
                while (true) {
                    introGuide();
                    System.out.print("Chọn: ");
                    ans1 = Integer.parseInt(input.readLine());
                    if (ans1 >= 1 && ans1 <= 3) {
                        break;
                    }
                }
                //1. Thêm một lớp mới"
                if (ans1 == 1) {
                    int ans2 = 0;
                    while (true) {
                        System.out.println("1. Nhập thông tin (một số thông tin phụ đã được thiết lập)");
                        System.out.println("2. Tự động tạo thông tin (chưa có chức năng này)");
                        System.out.println("3. Thoát");
                        System.out.print("Chọn: ");
                        ans2 = Integer.parseInt(input.readLine());
                        if (ans2 >= 1 && ans2 <= 3) {
                            break;
                        }
                    }
                    //1. Tự điền thông tin
                    if (ans2 == 1) {
                        //fill in information
                        System.out.print("[Nhập] Mã số hợp đồng: ");
                        //String contrastNumber = input.readLine();
                        String contrastNumber = "ABC";
                        System.out.println("");
                        
                        
                        System.out.print("[Nhập] Tên lớp: ");
                        String className = input.readLine();
                        //String className = "anh van";
                        System.out.print("[Nhập] Ngày bắt đầu: ");
                        //String startDate = input.readLine();
                        String startDate = "10";
                        System.out.println("");
                        
                        
                        System.out.print("[Nhập] Ngày kết thúc: ");
                        //String endDate = input.readLine();
                        String endDate = "10";
                        System.out.println("");
                        
                        
                        System.out.print("[Nhập] Tổng số tiết đào tạo: ");
                        //int numberOfLesson = Integer.parseInt(input.readLine()); //number of lesson in all of subjects
                        int numberOfLesson = 10;
                        System.out.println("");
                        
                        
                        System.out.println("Thông tin giáo viên chủ nhiệm");
                        System.out.print("[Nhập] Tên giáo viên: ");
                        //String name = input.readLine();
                        String name = "Khuat Thuy Phuong";
                        System.out.println("");
                        
                        
                        System.out.print("[Nhập] Số điên thoại: ");
                        //String numberPhone = input.readLine();
                        String numberPhone = "12345";
                        System.out.println("");
                        
                        
                        System.out.print("[Nhập] email: ");
                        //String email = input.readLine();
                        String email = "123@gmail.com";
                        System.out.println("");
                        
                        
                        System.out.print("[Nhập] Khả năng giảng dạy của giáo viên: ");
                        //String potentiality = input.readLine();
                        String potentiality = "Môn gì cũng biết dạy cả";
                        System.out.println("");
                        
                        
                        Teacher teacher = new Teacher(name, numberPhone, email, potentiality);//homeroomTeacherg
                        //Thêm Class vào Center
                        center.addClass(contrastNumber, className, startDate, endDate, numberOfLesson, teacher);
                    }
                    //2. Để máy tạo thông tin giúp (đề nghị ^_^)
                    if (ans2 == 2) {
                        //Chưa thiết lập
                    }
                }
                //2. Chỉ thao tác với dữ liệu
                if (ans1 == 2) {
                    //Thêm học sinh, điểm, hay mọi thông tin thì vào trong từng class thao tác
                    center.updateInfoInClass();
                    break;
                }
                if (ans1 == 3) {
                    break;
                }
            }

        } catch (Exception ex) {
            System.out.println("Err: " + ex.getMessage());
        }
    }

    private static void introGuide() {
        System.out.println("1. Thêm một lớp mới");
        System.out.println("2. Chỉ thao tác với dữ liệu");
        System.out.println("3. Thoát");
    }
}
