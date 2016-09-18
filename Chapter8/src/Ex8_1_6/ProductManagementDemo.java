package Ex8_1_6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.List;
/**
 * @author Tran Ngoc Dan
 * @since 17/09/2016
 * @version 1.0
 */
public class ProductManagementDemo {

    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            UserController userController = new UserController();
            CategoryController categoryControler = new CategoryController();
            ProductController productControler = new ProductController();
            while (true) {
                int ans = 0;
                while (true) {
                    System.out.println("1. Check login");
                    System.out.println("2. Add user");
                    System.out.println("3. Add product");
                    System.out.println("4. Search product");
                    System.out.println("5. Update product");
                    System.out.println("6. Delete product");
                    System.out.println("7. Quit");
                    System.out.print("Choose: ");
                    ans = Integer.parseInt(input.readLine());
                    if (ans >= 1 && ans <= 7) {
                        break;
                    }
                }

                if (ans == 1) {//check login
                    userController.checkLogin();
                }
                if (ans == 2) {//add user
                    userController.addUser();
                }
                if (ans == 3) {//add product
                    addProduct(productControler, categoryControler);
                }
                if (ans == 4) {//search product
                    System.out.print("[name]: ");
                    List<Product> ls = productControler.searchProduct(input.readLine());
                    System.out.println("== result ==");
                    ls.forEach(e -> e.showInfo());
                }
                if (ans == 5) {//update product
                    updateProduct(productControler);
                }
                if (ans == 6) {//delete product
                    deleteProduct(productControler);
                }
                if (ans == 7) {//quit
                    break;
                }
            }
        } catch (Exception ex) {
            System.out.println("Err: " + ex.getMessage());
        }

    }

    //add product
    public static void addProduct(ProductController productControler, CategoryController categoryControler) throws SQLException, ClassNotFoundException, IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int ans1 = 0;
        while (true) {
            categoryControler.getAllCategory();
            categoryControler.showInfo();
            System.out.println("Choose the category which you want to add product");
            System.out.print("Choose: ");
            ans1 = Integer.parseInt(input.readLine());
            if (ans1 >= 1 && ans1 <= categoryControler.getSize()) {
                break;
            }

        }
        int categoryid = ans1;
        System.out.println("Fill product's information");
        System.out.print("[name]: ");
        String name = input.readLine();
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
            if (amount > 0) {
                break;
            }
        }
        Product product = new Product(0, name, price, amount, categoryid);
        productControler.addProduct(product);
    }

    //update product
    public static void updateProduct(ProductController productControler) throws IOException, SQLException, ClassNotFoundException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        productControler.showInfo();
        int ans = 0;
        while (true) {
            System.out.println("if press -1 you can quit!");
            System.out.print("Choose: ");
            ans = Integer.parseInt(input.readLine());
            if ((ans >= 1 && ans <= productControler.getSize()) || ans == -1) {
                break;
            }
        }
        if (ans != -1) {
            productControler.updateProduct(ans - 1);
        }
    }

    //delete product
    public static void deleteProduct(ProductController productControler) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        productControler.showInfo();
        int ans = 0;
        while (true) {
            System.out.println("if press -1 you can quit!");
            System.out.print("Choose: ");
            
            ans = Integer.parseInt(input.readLine());
            if ((ans >= 1 && ans <= productControler.getSize()) || ans == -1) {
                break;
            }
        }
        if (ans != -1) {
            productControler.deleteProduct(ans - 1);
        }
    }
}
