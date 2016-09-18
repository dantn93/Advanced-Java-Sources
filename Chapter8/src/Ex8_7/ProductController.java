/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex8_7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Tran Ngoc Dan
 * @since 19/09/2016
 * @version 1.0
 */
public class ProductController {

    static DatabaseConnection db = new DatabaseConnection();

    
    public void transaction1() throws SQLException, ClassNotFoundException {
        try (Connection conn = db.connect()) {
            try {
                conn.setAutoCommit(false);
                //add product
                String name = "Strawberry Cookies";
                double price = 45000;
                int amount = 50;
                String image = "strawberrycookies.jpg";
                int category = 4;
                Date d = new Date();
                SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
                String createDate = fm.format(d.getTime());
                int display = 1;
                String sql = "INSERT INTO product VALUES(NULL,'" + name + "', '" + price + "', '"
                        + amount + "','" + image + "', '" + category + "','"
                        + createDate + "','" + display + "')";
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.executeUpdate();

                //update
                amount = 55;
                price = 6000;
                int updateId = 1;
                String sq2 = "UPDATE PRODUCT SET price = '" + price + "', amount = '" + amount + "' WHERE id = '" + updateId + "'";
                statement = conn.prepareStatement(sq2);
                statement.executeUpdate();

                //delete product id = 19
                int deleteId = 19;
                String sq3 = "DELETE FROM PRODUCT WHERE id = '" + deleteId + "'";
                statement = conn.prepareStatement(sq3);
                statement.executeUpdate();

                conn.commit();
                System.out.println("Transaction is successful !");
            } catch (SQLException ex) {
                System.out.println("Err: " + ex.getMessage());
                conn.rollback();
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Transaction is failed");
        }
    }

    public void transaction2() throws SQLException, ClassNotFoundException {
        try (Connection conn = db.connect()) {
            try {
                conn.setAutoCommit(false);
                //add product
                //length of name is 160 letter
                String name = "10kytuTTTT";
                for (int i = 0; i < 16; i++) {
                    name += name;
                }
                double price = 45000;
                int amount = 50;
                String image = "strawberrycookies.jpg";
                int category = 4;
                Date d = new Date();
                SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
                String createDate = fm.format(d.getTime());
                int display = 1;
                String sql = "INSERT INTO product VALUES(NULL,'" + name + "', '" + price + "', '"
                        + amount + "','" + image + "', '" + category + "','"
                        + createDate + "','" + display + "')";
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.executeUpdate();

                //update
                amount = 45;
                price = 125000;
                int updateId = 13;
                String sq2 = "UPDATE PRODUCT SET price = '" + price + "', amount = '" + amount + "' WHERE id = '" + updateId + "'";
                statement = conn.prepareStatement(sq2);
                statement.executeUpdate();

                //delete product id = 23
                int deleteId = 23;
                String sq3 = "DELETE FROM PRODUCT WHERE id = '" + deleteId + "'";
                statement = conn.prepareStatement(sq3);
                statement.executeUpdate();

                conn.commit();
                System.out.println("Transaction is successful !");
            } catch (SQLException ex) {
                System.out.println("Err: " + ex.getMessage());
                conn.rollback();
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Transaction is failed");
        }
    }

    public void transaction3() throws SQLException, ClassNotFoundException {
        try (Connection conn = db.connect()) {
            try {
                conn.setAutoCommit(false);
                //add product
                //length of name is 160 letter
                String name = "Strawberry Cookies";
                double price = 45000;
                int amount = 50;
                String image = "strawberrycookies.jpg";
                int category = 4;

                String createDate = "2016-09-10";
                int display = 0;
                String sql = "INSERT INTO product VALUES(NULL,'" + name + "', '" + price + "', '"
                        + amount + "','" + image + "', '" + category + "','"
                        + createDate + "','" + display + "')";
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.executeUpdate();

                //delete product id = 10
                int deleteId = 10;
                String sq3 = "DELETE FROM PRODUCT WHERE id = '" + deleteId + "'";
                statement = conn.prepareStatement(sq3);
                statement.executeUpdate();

                //update
                amount = 10;
                price = 50000;
                int updateId = 10;
                String sq2 = "UPDATE PRODUCT SET price = '" + price + "', amount = '" + amount + "' WHERE id = '" + updateId + "'";
                statement = conn.prepareStatement(sq2);
                statement.executeUpdate();

                conn.commit();
                System.out.println("Transaction is successful !");
            } catch (SQLException ex) {
                System.out.println("Err: " + ex.getMessage());
                conn.rollback();
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Transaction is failed");
        }
    }

}
