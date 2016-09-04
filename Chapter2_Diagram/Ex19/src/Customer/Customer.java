/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Customer;

import Card.ATM;
import Card.Card;
import Card.CreditCard;
import Order.Order;
import java.util.ArrayList;

/**
 * 
 * @author Tran Ngoc Dan
 * @version 1.0
 * @date 29/08/2016
 */
public class Customer {

    private String customerID;
    private Information info;
    private ArrayList<CreditCard> creditCard;
    private ArrayList<ATM> atmCard;
    private ArrayList<Order> order;

    public Customer(String customerID, String address, String email, String idCardNum, String name, String phoneNum) {
        this.customerID = customerID;
        this.info = new Information(address, email, idCardNum, name, phoneNum);
        this.creditCard = new ArrayList<CreditCard>();
        this.atmCard = new ArrayList<ATM>();
        this.order = new ArrayList<Order>();
    }

    //Add a credit card
    public void addCreditCard(CreditCard crd){
        this.creditCard.add(crd);
    }
    //Add an ATM card
    public void addATMCard(ATM crd){
        this.atmCard.add(crd);
    }
    
    //customer buy something which is the same as placing an order
    public void addOrder(Order ord){
        this.order.add(ord);
    }
    
    public String getCustomerID() {
        return customerID;
    }
    
    //After the customer buy something, he can whether pay or not,
    //so the status will be written on receipt
    public void setOrderStatus(String status){
        this.order.get(0).setStatus(status);
    }


    public ArrayList<CreditCard> getCreditCard() {
        return this.creditCard;
    }

    public ArrayList<ATM> getAtmCard() {
        return this.atmCard;
    }
    public String getStatus(){
        return this.order.get(0).getStatus();
    }

    public ArrayList<Order> getOrder() {
        return order;
    }


}
