package Ex3_4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author Tran Ngoc Dan
 * @version 1.0
 * @since 09/09/2016
 */
public class IntegerCalculationMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Nhap so thu nhat: ");
            int operand1 = Integer.parseInt(input.readLine());
            System.out.print("Nhapso thu hai: ");
            int operand2 = Integer.parseInt(input.readLine());
            while (true) {
                System.out.println("1. Tong");
                System.out.println("2. Hieu");
                System.out.println("3. Tich");
                System.out.println("4. Thuong");
                System.out.println("5. Thoat");
                int ans = 0;
                while (true) {
                    System.out.print("Chon: ");
                    ans = Integer.parseInt(input.readLine());
                    if (ans >= 1 && ans <= 5) {
                        break;
                    }
                }
                switch (ans) {
                    case 1:
                        Operator op1 = (x1, x2) -> x1 + x2;
                        int sum = op1.operator(operand1, operand2);
                        System.out.println("Tong: " + sum);
                        break;
                    case 2:
                        Operator op2 = (x1, x2) -> x1 - x2;
                        int sub = op2.operator(operand1, operand2);
                        System.out.println("Hieu: " + sub);
                        break;
                    case 3:
                        Operator op3 = (x1, x2) -> x1 * x2;
                        int mul = op3.operator(operand1, operand2);
                        System.out.println("Tich: " + mul);
                        break;
                    case 4:
                        if (operand2 == 0) {
                            System.out.println("Khong the chia");
                        } else {
                            Operator op4 = (x1, x2) -> x1 / x2;
                            int div = op4.operator(operand1, operand2);
                            System.out.println("Tong: " + div);
                        }
                }
                if (ans == 5) {
                    break;
                }
            }

        } catch (Exception ex) {
            System.out.println("Err: " + ex.getMessage());
        }
    }

}
