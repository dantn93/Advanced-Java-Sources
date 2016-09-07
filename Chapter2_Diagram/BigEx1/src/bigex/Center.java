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
public class Center {

    private BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    private ArrayList<Class> classes;

    public Center() {
        classes = new ArrayList<Class>();
    }

    public int getNumberOfClass() {
        return classes.size();
    }

    public void addClass(String contrastNumber, String className, String startDate, String endDate, int numberOfLesson, Teacher teacher) {
        this.classes.add(new Class(contrastNumber, className, startDate, endDate, numberOfLesson, teacher));
    }

    public void updateInfoInClass() throws IOException {

        if (classes.size() == 0) {
            System.out.println("Không có lớp nào được tạo ra. Bạn không thể thao tác được");
        }
        int ans = 0;
        //Kiểm tra nhập
        while (true) {
            if (classes.size() > 0) {
                while (true) {

                    System.out.println("Bạn muốn thao tác với dữ liệu ở lớp nào");
                    for (int i = 0; i < classes.size(); i++) {
                        System.out.println((i + 1) + ". " + classes.get(i).getClassName());
                    }
                    System.out.println((classes.size() + 1) + ". Thoát");
                    System.out.print("Chọn: ");
                    ans = Integer.parseInt(input.readLine());
                    if (ans >= 1 && ans <= classes.size() + 1) {
                        break;
                    }
                }

                if (ans == classes.size() + 1) {
                    System.out.println("Cảm ơn bạn vì đã sử dụng phần mềm của tôi");
                    break;
                } else //Bắt đầu thao tác ở Lớp thứ ans
                {
                    classes.get(ans - 1).updateInfoInClass();
                }
            }
        }
    }
}
