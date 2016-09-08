package Main;

import Card.ATM;
import Card.Card;
import Card.CreditCard;
import Customer.Customer;
import Item.Item;
import Order.Order;
import Order.OrderDetail;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author Tran Ngoc Dan
 * @version 1.0
 * @date 29/08/2016
 */
public class Supermarket {

    public static void main(String[] args) {
        // TODO code application logic here
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            //Set initial information for CreditCard and ATMCard
            //Personal Information
            String name = "Nguyen Hoang Nam";
            String address = "No 20, Nguyen Kiem St, Ward 6, District 3, HCM City";
            String email = "hoangnam@gmail.com";
            String idCardNum = "197856345";//Identify Card Number
            String phoneNum = "+84 1635 789 345";//phone number
            String customerID = "IDK567";
            //general Information
            String cardID = "AGRI1567347";
            String confirmationMethod = "Mobile Phone";
            //CreditCard information
            String expirationDate = "01/10/2020";
            double maxDebt = 100000000;
            String type = "Platinum";
            //ATM information
            double balances = 30000000;

            //Print initial information
            System.out.println("== Customer's information == ");
            System.out.println("Full name: " + name);
            System.out.println("Address: " + address);
            System.out.println("Email: " + email);
            System.out.println("Identify Card Number: " + idCardNum);
            System.out.println("Phone Number: " + phoneNum);
            System.out.println("Card ID: " + cardID);
            System.out.println("Confirmation Method: " + confirmationMethod);

            //Create Credit Card
            CreditCard creditCard = new CreditCard(expirationDate, type, cardID, confirmationMethod);
            System.out.println("Maximum Debt in CreditCard: " + String.format("%.2f", maxDebt));
            //Create ATM Card
            ATM atm = new ATM(balances, cardID, confirmationMethod);
            System.out.println("Balances in ATM card: " + String.format("%.2f", balances));

            //Customer
            Customer customer = new Customer(customerID, address, email, idCardNum, name, phoneNum);
            //The customer has 2 card (ATM & Credit Card)
            customer.addATMCard(atm);
            customer.addCreditCard(creditCard);
            //The customer go to the market ^_^
            String orderDate = "12/01/2016";
            boolean printOrder = true;
            Order order = new Order(orderDate, printOrder);
            //The customer buys items *_*
            System.out.println("\nLet's purchase ^_^");
            while (true) {
                int item = 1;
                while (true) {
                    System.out.println("WHAT item do you want to purchase? ");
                    for (int i = 0; i < Item.values().length; i++) {
                        System.out.println((i + 1) + ". " + Item.values()[i].name() + "  " + Item.values()[i].getPrice());
                    }
                    System.out.print("Choose: ");
                    item = Integer.parseInt(input.readLine());
                    if (item > 0 && item <= Item.values().length) {
                        break;
                    }
                }

                int quantity = 0;
                while (true) {
                    System.out.print("HOW MANY items do you want to purchase? ");
                    quantity = Integer.parseInt(input.readLine());
                    if (quantity > 0) {
                        break;
                    }
                }
                OrderDetail orderDetail = new OrderDetail(quantity, Item.values()[item - 1].name(), Item.values()[item - 1].getPrice());
                order.addOrderDetail(orderDetail);
                customer.addOrder(order);
                //Ask continue
                boolean flag = false;
                while (true) {
                    System.out.print("Do you want to purchase another item (y/n): ");
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
            //calculate tax if you want to
            boolean printingReceipt = false;
            while (true) {
                System.out.print("Do you want to print receipt(y/n): ");
                String agr = input.readLine();
                if (agr.equalsIgnoreCase("y")) {
                    printingReceipt = true;
                    break;
                } else if (agr.equalsIgnoreCase("n")) {
                    printingReceipt = false;
                    break;
                }
            }
            order.setPrintOrder(printingReceipt);
            //calculate total price
            double totalAmount = order.getTotalAmount();
            //Pay by using ATM or Credit Card
            int ans = 0;
            while (true) {
                System.out.print("Do you want to pay by using ATM(1) or Credit Card(2): ");
                ans = Integer.parseInt(input.readLine());
                if (ans == 1 || ans == 2) {
                    break;
                }
            }

            //Afterthat, I will show all information of your order
            customer.getOrder().get(0).showInfo();
            //Show information about payment
            if (ans == 1) {
                if (customer.getAtmCard().get(0).subBalances(totalAmount) == 0) {
                    if (customer.getCreditCard().get(0).debit(totalAmount) == 0) {
                        customer.setOrderStatus("You haven't yet paid");
                    } else {
                        customer.setOrderStatus("You have already paid");
                    }
                } else {
                    customer.setOrderStatus("You have already paid");
                }
            }
            if (ans == 2) {
                if (customer.getCreditCard().get(0).debit(totalAmount) == 0) {
                    if (customer.getAtmCard().get(0).subBalances(totalAmount) == 0) {
                        customer.setOrderStatus("You haven't yet paid");
                    } else {
                        customer.setOrderStatus("You have already paid");
                    }
                } else {
                    customer.setOrderStatus("You have already paid");
                }
            }

            //Print balance and debit
            System.out.print("ATM - ");
            customer.getAtmCard().get(0).showInfo();
            System.out.print("Credit Card - ");
            customer.getCreditCard().get(0).showInfo();
            System.out.println("Payment Status: " + customer.getStatus());

        } catch (Exception ex) {
            System.out.println("Err: " + ex.getMessage());
        }
    }
}
