package Ex8_7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @author Tran Ngoc Dan
 * @since 19/09/2016
 * @version 1.0
 */
public class ProductManagementDemo {

    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            ProductController productControler = new ProductController();

            //run 3 transaction, after each transaction, I commit. 
            productControler.transaction1();
            productControler.transaction2();
            productControler.transaction3();

        } catch (Exception ex) {
            System.out.println("Err: " + ex.getMessage());
        }

    }
}
