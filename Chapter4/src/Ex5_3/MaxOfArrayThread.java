package Ex5_3;

import java.util.Random;
import java.util.Scanner;

import Ex5_2.SumThread;

/**
 * 
 * @author Tran Ngoc Dan
 * @version: 1.0
 * @since : 13/09/2016
 */
public class MaxOfArrayThread {

    public static void main(String[] args) throws InterruptedException {
        Scanner input = new Scanner(System.in);
        System.out.println("Input n: ");
        int n = input.nextInt();
        int arr[] = new int[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(101);
        }
        System.out.println("Input num of threads: ");
        int numThreads = input.nextInt();
        int sum = max(arr, numThreads);
        String strArr = "";
        for (int value : arr) {
            strArr += value + " ";
        }
        System.out.println("Array: " + strArr);
        System.out.println("Max: " + sum);
    }

    // max of array
    public static int max(int[] arr, int numThreads)
            throws InterruptedException {
        int len = arr.length;
        int max = 0;
        MaxThread[] ts = new MaxThread[numThreads];
        for (int i = 0; i < numThreads; i++) {
            ts[i] = new MaxThread((i * len) / numThreads, ((i+1)*len)/numThreads, arr);
            ts[i].start();
        }

        for (int i = 0; i < numThreads; i++) {
            //join all threads
            ts[i].join();
            if (ts[i].getMax() > max) {
                max = ts[i].getMax();
            }
        }
        return max;
    }
}
