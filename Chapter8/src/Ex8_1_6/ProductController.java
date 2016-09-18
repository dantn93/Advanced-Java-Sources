/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex8_1_6;

import static Ex8_1_6.UserController.db;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Tran Ngoc Dan
 * @since 17/09/2016
 * @version 1.0
 */
public class ProductController {

    static DatabaseConnection db = new DatabaseConnection();
    List<Product> list;

    public ProductController() throws SQLException, ClassNotFoundException {
        list = new ArrayList<>();
        try (Connection conn = db.connect()) {
            Statement statement = (Statement) conn.createStatement();
            String sql = "SELECT * FROM product";
            ResultSet resultSet = statement.executeQuery(sql);
            int i = 0;
            while (resultSet.next()) {
                Product product = new Product();
                product.setId(resultSet.getInt("id"));
                product.setName(resultSet.getString("name"));
                product.setPrice(resultSet.getDouble("price"));
                product.setAmount(resultSet.getInt("amount"));
                product.setCategoryid(resultSet.getInt("categoryid"));
                list.add(product);
            }
            conn.close();
        }
    }

    //add a product
    //input: a product
    public void addProduct(Product product) throws SQLException, ClassNotFoundException {
        try (Connection conn = db.connect()) {
            String sql = "INSERT INTO product VALUES(NULL,'" + product.getName() + "', '" + product.getPrice() + "', '"
                    + product.getAmount() + "', '" + product.getCategoryid() + "')";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.execute();
            list.add(product);
            System.out.println("Add product successfully!");
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Can not add new product");
        }
    }

    /**
     * search a product input: name of product output: list of products
     * satisfying
     */
    public List<Product> searchProduct(String name) {
        List<Product> ls = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getName().equalsIgnoreCase(name)) {
                ls.add(list.get(i));
            }
        }
        if (ls.size() == 0) {
            System.out.println("list of products don't have " + name + "!");
        } else {
            return ls;
        }
        return ls;
    }

    public void showInfo() {
        for (int i = 0; i < list.size(); i++) {
            System.out.print((i + 1) + ". ");
            list.get(i).showInfo();
        }
    }

    public int getSize() {
        return list.size();
    }

    public Product getProduct(int i) {
        return list.get(i);
    }

    /**
     * update price and amount of product at position idx
     */
    public void updateProduct(int idx) throws SQLException, ClassNotFoundException, IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        double price;
        while (true) {
            System.out.print("[price]: ");
            price = Double.parseDouble(input.readLine());
            if (price > 0) {
                break;
            }
        }
        int amount;
        while (true) {
            System.out.print("[amount]: ");
            amount = Integer.parseInt(input.readLine());
            if (amount >= 0) {
                break;
            }
        }
        list.get(idx).setAmount(amount);
        list.get(idx).setPrice(price);
        try (Connection conn = db.connect()) {
            String sql = "UPDATE PRODUCT SET price = '" + list.get(idx).getPrice() + "', amount = '" + list.get(idx).getAmount() + "' WHERE id = '" + list.get(idx).getId() + "'";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.execute();
            System.out.println("Update successfully!");
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Can not update");
        }
    }

    //delete product at position idx
    public void deleteProduct(int idx) {
        try (Connection conn = db.connect()) {
            String sql = "DELETE FROM PRODUCT WHERE id = '" + list.get(idx).getId() + "'";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.execute();
            System.out.println("Delete product successfully!");
            list.remove(idx);
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Can not delete product");
        }
    }

}
