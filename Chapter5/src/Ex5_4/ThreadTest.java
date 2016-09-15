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
public class ThreadTest {

    public static void main(String[] args) throws InterruptedException {
        Thread[] thread = new Thread[10];
        for (int i = 0; i < 10; i++) {
            thread[i] = new Thread(new ThreadCounter());
            String name = String.valueOf(i + 1);
            thread[i].setName(name);
            thread[i].start();
            thread[i].join();
            Thread.sleep(1000L);
        }
    }// main ends here
}
