/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Order;

import java.util.ArrayList;

/**
 * 
 * @author Tran Ngoc Dan
 * @version 1.0
 * @date 29/08/2016
 */
public class Order {

    final static double tax = 0.1;
    private String orderDate;
    private boolean printOrder;
    private String status;
    private ArrayList<OrderDetail> order;

    public Order(String orderDate, boolean printOrder) {
        this.orderDate = orderDate;
        this.printOrder = printOrder;
        this.status = status;
        this.order = new ArrayList<OrderDetail>();
    }

    //Add order detail (one line) into the order
    public void addOrderDetail(OrderDetail orderDT) {
        this.order.add(orderDT);
    }

    //calculate total amount in the order
    public double getTotalAmount() {
        double sum = 0;
        for (int i = 0; i < this.order.size(); i++) {
            sum += this.order.get(i).getTotalAmount();
        }
        if (this.printOrder) {
            return sum * (1 + tax);
        } else {
            return sum;
        }
    }
    public void setPrintOrder(boolean print){
        this.printOrder = print;
    }
    public void setStatus(String status){
        this.status = status;
    }
    public String getStatus(){
        return this.status;
    }
}
