/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bigex;

import java.util.ArrayList;

/**
 *
 * @author snow
 */
public class PersonalStatusMark {

    private ArrayList<Double> halfday;//mỗi thành phần là sự chuyên cần của một đứa (điểm số)

    public PersonalStatusMark() {
        this.halfday = new ArrayList<Double>();
    }

    public void addStatus(Double status) {
        halfday.add(status);
    }

    //Cập nhật điểm trạng thái cho học viên thứ index
    public void updateHalfDayStatus(double status, int index) {
        while (this.halfday.size() < index) {
            this.halfday.add(new Double(0));
        }
        if (this.halfday.size() == index) {
            this.halfday.add(new Double(status));
        }
        if (this.halfday.size() > index) {
            this.halfday.set(index, status);
        }
    }

    public Double getStatus(int index) {
        return this.halfday.get(index);
    }

    public int getSizeStatus() {
        return halfday.size();
    }

    public ArrayList<Double> getPersonalStatusMark() {
        return this.halfday;
    }
}
