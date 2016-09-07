package Ex32;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Tran Ngoc Dan date: 5/9/2016
 * @version : 1.0
 *
 */
public class BookingMain {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        try {
            int ans = 0;
            while (true) {
                System.out.println("1: hotel");
                System.out.println("2: fight");
                System.out.println("3: train");
                ans = Integer.parseInt(input.readLine());
                if (ans >= 1 && ans <= 3) {
                    break;
                }
            }
            System.out.print("Fill in date: ");
            String date = input.readLine();
            System.out.print("Fill in hour: ");
            String hour = input.readLine();
            System.out.print("Fill in place: ");
            String place = input.readLine();
            BookingFacade booking = new BookingFacade();
            switch (ans) {
                case 1:
                    System.out.println(booking.bookHotel(date, hour, place));
                    break;
                case 2:
                    System.out.println(booking.bookFlight(date, hour, place));
                    break;
                case 3:
                    System.out.println(booking.bookTrain(date, hour, place));
            }
        } catch (NumberFormatException ex) {
            System.out.println("Err: " + ex.getMessage());
        }
    }
}
