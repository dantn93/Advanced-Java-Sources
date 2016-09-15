/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex5_4;

/**
 *
 * @author Tran Ngoc Dan
 * @version: 1.0
 * @since : 13/09/2016
 */
public class ThreadCounter implements Runnable {

    private static int count = 0;

    @Override
    public void run() {
        try {
            counter(); // call synchronized counter function 

        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }//end of run()

    public synchronized void counter() throws InterruptedException {
        int temp = 0;
        while (true) {
            System.out.println("[Thread] " + Thread.currentThread().getName());
            count++;
            System.out.println("count is " + count + "\n");
            temp++;
            if (temp == 10) {
                break;
            }
        }// while loop ends here
    }// end of counter()
}// end of class ThreadCounter
