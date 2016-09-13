package Ex3_1;

import java.util.Arrays;
import java.util.List;

/**
 * @author Tran Ngoc Dan
 * @version 1.0
 * @since 09/09/2016
 */
public class ListMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
            list.forEach(n -> System.out.println(n));
        } catch (Exception ex) {
            System.out.println("Err: " + ex.getMessage());
        }
    }
}
