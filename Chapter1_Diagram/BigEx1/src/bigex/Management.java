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
public class Management {

    //A date is mapped from an attendance
    /**
     * Mỗi ngày sẽ điểm danh 1 lần 1 attendance là một danh sách chứa các trạng
     * thái nghỉ học mà chỉ số của nó tương ứng với chỉ số (số thứ tự) của danh
     * sách học sinh do đó không cần thiết phải làm trung lặp thông tin ở đây,
     * tức là class PersonalStatusMark chỉ cần lưu thông tin trạng thái, không
     * cần phải lưu thêm thông tin của học viên.
     */
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    //Personal score
    private ArrayList<String> halfDates;//ngày (có nhiều ngày trong môn học)
    private ArrayList<PersonalStatusMark> attendances;//điểm chuyên cần của cả lớp trong ngày
    private ArrayList<PersonalExerciseMark> exMark;//điểm bài tập cá nhân
    private ArrayList<PersonalActiveMark> activeMark;//điểm tích cực (xung phong)

    //Big Exercise
    private ArrayList<Double> mulChoiceTestMark;//multiple-choice Test (bài thi trắc nghiệm cho tất cả học viên)
    private ArrayList<Double> pEMark;//big pracice exercise; (Điểm bài tập lớn cho tất cả học viên)

    //comments of teacher who is charge of subject
    private ArrayList<String> cmtOfTeacher;
    private ArrayList<String> cmtOfHomeoomTeacher;

    public Management() {
        this.halfDates = new ArrayList<String>();
        this.attendances = new ArrayList<PersonalStatusMark>();
        this.exMark = new ArrayList<PersonalExerciseMark>();//exercise
        this.activeMark = new ArrayList<PersonalActiveMark>();//raise student's hand
        this.mulChoiceTestMark = new ArrayList<Double>();
        this.pEMark = new ArrayList<Double>();
        this.cmtOfTeacher = new ArrayList<String>();
        this.cmtOfHomeoomTeacher = new ArrayList<String>();
    }

    //Thêm ngày muốn điểm danh
    public void addDate(String date) {
        this.halfDates.add(date);
    }

    //Thêm một dánh sách các trạng thái nghỉ học cho từng ngày
    public void addAttendance(PersonalStatusMark status) {
        this.attendances.add(status);
    }

    //Điểm danh đầu buổi
    public void setInfoStatus(ArrayList<Student> students) throws IOException {
        while (true) {
            System.out.print("Nhập buổi: ");
            halfDates.add(input.readLine());
            //Diểm danh từng đứa
            System.out.println("Điểm danh");
            PersonalStatusMark status = new PersonalStatusMark();
            //Điểm danh cho tất cả học viên trong lớp
            for (int i = 0; i < students.size(); i++) {
                System.out.println("[Học viên]: " + students.get(i).getName());
                int ans = 0;
                while (true) {
                    for (int j = 0; j < STATUSES.values().length; j++) {
                        System.out.println((j + 1) + ". " + STATUSES.values()[j].getStatus());
                    }
                    System.out.print("Chọn: ");
                    ans = Integer.parseInt(input.readLine());
                    if (ans > 0 && ans <= STATUSES.values().length) {
                        break;
                    }
                }
                //Cập nhật trạng thái đi học của học viên
                for (int j = 0; j < STATUSES.values().length; j++) {
                    if (ans == STATUSES.values()[j].getID()) {
                        status.updateHalfDayStatus(STATUSES.values()[j].getMark(), i);
                    }
                }

            }
            //Điểm danh xong thì ghi nhận
            this.attendances.add(status);
            //Điểm danh xong, chắc chắn sẽ có điểm cuối buổi ^_^
            //...Khởi tạo ban đầu. Sau này sẽ cập nhật điểm
            this.exMark.add(new PersonalExerciseMark());
            this.activeMark.add(new PersonalActiveMark());
            //Điểm cuối môn cũng được khởi tạo bằng 0, sau này sửa lại
            for(int i=0;i<students.size();i++){
                this.mulChoiceTestMark.add(0.0);
                this.pEMark.add(0.0);
            }

            //Bạn muốn tiếp tục làm không
            boolean flag = false;
            while (true) {
                System.out.print("Bạn muốn điểm danh nữa không (y/n): ");
                String agr = input.readLine();
                if (agr.equalsIgnoreCase("y")) {
                    break;
                } else if (agr.equalsIgnoreCase("n")) {
                    flag = true;
                    break;
                }
            }
            if (flag == true) {
                break;
            }
        }
    }

    //Cập nhật tình trạng điểm danh lúc đầu
    public void updateInfoStatus(ArrayList<Student> students) throws IOException {
        while (true) {
            if (this.halfDates.size() > 0) {
                int d = 0;
                while (true) {
                    System.out.println("Bạn muốn thao tác với dữ liệu buổi nào");
                    for (int i = 0; i < this.halfDates.size(); i++) {
                        System.out.println((i + 1) + ". " + this.halfDates.get(i));

                    }
                    System.out.print("Chọn: ");
                    d = Integer.parseInt(input.readLine());
                    if (d > 0 && d <= this.halfDates.size()) {
                        break;
                    }
                }
                //Vào buổi có thứ tự d - 1 để cập nhật thông tin
                //Bước 1: hiển thị thông tin tên học viên cho người dùng chọn
                int idxStd = 0;
                System.out.println("Chọn học viên muốn thao tác");
                for (int i = 0; i < students.size(); i++) {
                    System.out.println((i + 1) + ". " + students.get(i).getName());
                }
                while (true) {
                    System.out.print("Chọn: ");
                    idxStd = Integer.parseInt(input.readLine());
                    if (idxStd > 0 && idxStd <= students.size()) {
                        break;
                    }
                }
                //Bước 2: Lấy thông tin điểm danh ngày hôm đó (d-1)
                PersonalStatusMark status = this.attendances.get(d - 1);
                //Bước 3: Điểm danh lại
                int ans = 0;
                while (true) {
                    for (int j = 0; j < STATUSES.values().length; j++) {
                        System.out.println((j + 1) + ". " + STATUSES.values()[j].getStatus());
                    }
                    System.out.print("Chọn: ");
                    ans = Integer.parseInt(input.readLine());
                    if (ans > 0 && ans <= STATUSES.values().length) {
                        break;
                    }
                }
                //Bước 4: Cập nhật trạng thái đi học của học viên (buổi sáng)
                for (int j = 0; j < STATUSES.values().length; j++) {
                    if (ans == STATUSES.values()[j].getID()) {
                        status.updateHalfDayStatus(STATUSES.values()[j].getMark(), idxStd - 1);
                    }
                }

                //Bước 6. Sau khi thay đổi phải ghi nhận lại
                this.attendances.set(d - 1, status);

                //Bạn muốn tiếp tục thao tác không
                boolean flag = false;
                while (true) {
                    System.out.print("Bạn muốn cập nhật tình trạng điểm danh nữa không (y/n): ");
                    String agr = input.readLine();
                    if (agr.equalsIgnoreCase("y")) {
                        break;
                    } else if (agr.equalsIgnoreCase("n")) {
                        flag = true;
                        break;
                    }
                }
                if (flag == true) {
                    break;
                }
            } else {
                System.out.println("Bạn chưa học ngày nào, nên không thể cập nhật điểm danh được");
                break;
            }
        }
    }

    //Nhập điểm cá nhân cho từng buổi học (điểm bài tập và điểm tích cực)
    public void setPersonalMark(ArrayList<Student> students) throws IOException {
        while (true) {
            if (this.halfDates.size() > 0) {
                int d = 0;
                while (true) {
                    System.out.println("Bạn muốn thao tác với dữ liệu buổi nào");
                    for (int i = 0; i < this.halfDates.size(); i++) {
                        System.out.println((i + 1) + ". " + this.halfDates.get(i));

                    }
                    System.out.print("Chọn: ");
                    d = Integer.parseInt(input.readLine());
                    if (d > 0 && d <= this.halfDates.size()) {
                        break;
                    }
                }
                //Vào buổi có thứ tự d - 1 để điền điểm bài tập cho học viên
                PersonalExerciseMark exmark = new PersonalExerciseMark();
                exmark.setExMark(students);
                System.out.println("Kich thuoc mang diem ca nhan mac dinh (số buổi): " + this.exMark.size());
                System.out.println("Kich thuoc diem ca nhan " + exmark.getSize());
                //Thêm điểm vào ngày hiện tại
                this.exMark.set(d - 1, exmark);
                //Điền điểm tích cực cho học viên
                PersonalActiveMark actmark = new PersonalActiveMark();
                actmark.setActiveMark(students);
                this.activeMark.set(d - 1, actmark);

                //Bạn muốn tiếp tục thao tác không
                boolean flag = false;
                while (true) {
                    System.out.print("Bạn muốn nhập điểm nữa không (y/n): ");
                    String agr = input.readLine();
                    if (agr.equalsIgnoreCase("y")) {
                        break;
                    } else if (agr.equalsIgnoreCase("n")) {
                        flag = true;
                        break;
                    }
                }
                if (flag == true) {
                    break;
                }
            } else {
                System.out.println("Học viên cần điểm danh trước khi nhập điểm");
                break;
            }
        }

    }

    //Nhập điểm thi cuối kỳ
    public void setBigExMark(ArrayList<Student> students) throws IOException {
        //Nhập điểm bài tập lớn
        if (this.halfDates.size() > 0) {
            System.out.println("Bạn hãy nhập điểm BÀI TẬP LỚN cho từng học viên");
            for (int i = 0; i < students.size(); i++) {
                double mark = 0;
                while (true) {
                    System.out.print("[Học viên] " + students.get(i).getName() + ": ");
                    mark = Double.parseDouble(input.readLine());
                    if (mark >= 0) {
                        break;
                    }
                }
                this.pEMark.add(mark);
            }
            System.out.println("Hoàn thành việc nhập điểm!");

            //Nhập điểm bài trắc nghiệm
            System.out.println("Bạn hãy nhập điểm BÀI TRẮC NGHIỆM  cho từng học viên");
            for (int i = 0; i < students.size(); i++) {
                double mark = 0;
                while (true) {
                    System.out.print("[Học viên] " + students.get(i).getName() + ": ");
                    mark = Double.parseDouble(input.readLine());
                    if (mark >= 0) {
                        break;
                    }
                }
                this.mulChoiceTestMark.add(mark);
            }
            System.out.println("Hoàn thành việc nhập điểm!");
        } else {
            System.out.println("Cần đi học, điểm danh mới có điểm cuối môn");
        }
    }

    //Tính điểm tổng kết CUỐI MÔN (danh sách chứa mỗi phần tử là 1 học viên)
    public ArrayList<Double> calFinalMark(ArrayList<Student> students) throws IOException {
        ArrayList<Double> finalMark = new ArrayList<Double>();
        for (int i = 0; i < students.size(); i++) {
            double totalMark = 0;
            double personalMark = calPersonalMarkInSubject(i, students);
            totalMark += personalMark * 0.3;
            totalMark += this.mulChoiceTestMark.get(i) * 0.4;
            totalMark += this.pEMark.get(i) * 0.3;
            finalMark.add(totalMark);
        }
        return finalMark;
    }

    //Tính điểm tổng kết CÁ NHÂN của TẤT CẢ CÁC BUỔI HỌC cho học viên thứ index
    //Mỗi phần tử trong mảng trả về là điểm của MỖI BUỔI
    public ArrayList<Double> calPersonalMarkPerHalfDay(int index, ArrayList<Student> students) throws IOException {
        ArrayList<Double> personalMark = new ArrayList<Double>();
        for (int i = 0; i < this.halfDates.size(); i++) {
            double temp = 0;
            temp += this.attendances.get(i).getPersonalStatusMark().get(index) * 0.3;
            temp += this.activeMark.get(i).getPersonalActiveMark().get(index) * 0.1;
            temp += this.exMark.get(i).getPersonalExerciseMark().get(index) * 0.6;
            personalMark.add(temp);
        }
        return personalMark;
    }

    //Tính điểm tổng kết CÁ NHÂN của MÔN HỌC cho học viên thứ index
    public double calPersonalMarkInSubject(int index, ArrayList<Student> students) throws IOException {
        ArrayList<Double> personalMark = calPersonalMarkPerHalfDay(index, students);
        double temp = 0;
        for (int i = 0; i < personalMark.size(); i++) {
            temp += personalMark.get(i);
        }
        return temp / personalMark.size();
    }

    //Nhận xét của giáo viên phụ trách môn
    public void setCommentOfTeacher(ArrayList<Student> students) throws IOException {
        ArrayList<String> temp = new ArrayList<String>();
        System.out.println("Nhận xét của giáo viên phụ trách môn");
        if (this.cmtOfTeacher.size() == 0) {
            for (int i = 0; i < students.size(); i++) {
                System.out.println("[Học viên] " + students.get(i).getName() + ": ");
                temp.add(input.readLine());
            }
            this.cmtOfTeacher = temp;
        } else {
            System.out.println("Giáo viên phụ trách môn nhận xét lại");
            for (int i = 0; i < students.size(); i++) {
                System.out.println("[Học viên] " + students.get(i).getName() + ": ");
                this.cmtOfTeacher.set(i, input.readLine());
            }
        }
    }

    //Nhận xét của giáo viên chủ nhiệm
    public void setCommentOfHomeRoomTeacher(ArrayList<Student> students) throws IOException {
        ArrayList<String> temp = new ArrayList<String>();
        System.out.println("Nhận xét của giáo viên chủ nhiệm");
        if (this.cmtOfHomeoomTeacher.size() == 0) {
            for (int i = 0; i < students.size(); i++) {
                System.out.println("[Học viên] " + students.get(i).getName() + ": ");
                temp.add(input.readLine());
            }
            this.cmtOfHomeoomTeacher = temp;
        } else {
            System.out.println("Giáo viên chủ nhiệm đánh giá lại");
            for (int i = 0; i < students.size(); i++) {
                System.out.println("[Học viên] " + students.get(i).getName() + ": ");
                this.cmtOfHomeoomTeacher.set(i, input.readLine());
            }
        }
    }

    //Xuất thông tin điểm cho học viên
    public void showInfo(ArrayList<Student> students) throws IOException {
        for (int i = 0; i < this.exMark.size(); i++) {
            System.out.println(this.exMark.get(i).getSize());
        }
        ArrayList<Double> finalMark = calFinalMark(students);
        for (int i = 0; i < students.size(); i++) {
            System.out.println("---------------------------------------");
            System.out.println("[Học viên] " + students.get(i).getName());
            System.out.println("[Điểm cá nhân của mỗi buổi học]");
            //Điểm TẤT CẢ CÁC BUỔI HỌC của học viên thứ i
            ArrayList<Double> temp = calPersonalMarkPerHalfDay(i, students);
            for (int j = 0; j < temp.size(); j++) {
                System.out.println("\t[Buổi " + (j + 1) + "] " + temp.get(j));
            }

            //Điểm CÁ NHÂN tổng kết
            System.out.println("[Điểm cá nhân (tổng kết) theo môn]");
            System.out.println("\t"+calPersonalMarkInSubject(i, students));
            
            //Điểm tổng kết của môn học
            System.out.println("[Điểm tổng kết của môn học]");
            System.out.println("Chú ý: có khả năng bạn chưa nhập hết tất cả các loại điểm");
            System.out.println("\t"+finalMark.get(i));
            //Nhận xét của giáo viên phụ trách môn
            System.out.println("[Nhận xét của giáo viên phụ trách môn]");
            if (this.cmtOfTeacher.size() == 0) {
                System.out.println("Chưa có nhận xét của giáo viên. Hãy cập nhật nhận xét");
                break;
            } else {
                System.out.println("\t"+this.cmtOfTeacher.get(i));
            }

            //Nhận xét của giáo viên chủ nhiệm
            System.out.println("[Nhận xét của giáo viên chủ nhiệm]");
            if (this.cmtOfHomeoomTeacher.size() == 0) {
                System.out.println("Chưa có nhận xét của giáo viên. Hãy cập nhật nhận xét");
                break;
            } else {
                System.out.println("\t"+this.cmtOfHomeoomTeacher.get(i));
            }
            
            System.out.println("");
        }
    }
}
