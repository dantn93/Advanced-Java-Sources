/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vd10_workbook;

import java.util.Date;

/**
 *
 * @author Tran Ngoc Dan
 * @since 30/09/2016
 */
public class AssignedVote{
    private Date startDate;
    private int numberOfdate;
    private int employeeID;
    private int workTypeID;

    public AssignedVote(Date startDate, int numberOfdate, int employeeID, int workTypeID) {
        this.startDate = startDate;
        this.numberOfdate = numberOfdate;
        this.employeeID = employeeID;
        this.workTypeID = workTypeID;
    }

    public void showInfo() {
        System.out.println("[Start date]: "+this.startDate.toString());
        System.out.println("[Number of date]: "+this.numberOfdate);
        System.out.println("[Employee ID]: "+this.employeeID);
        System.out.println("[Work Type ID]: "+this.workTypeID);
        System.out.println("");
    }

    public Date getStartDate() {
        return startDate;
    }

    public int getNumberOfdate() {
        return numberOfdate;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public int getWorkTypeID() {
        return workTypeID;
    }
    
    
    
}
