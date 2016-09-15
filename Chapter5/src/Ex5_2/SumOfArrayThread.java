package Ex5_2;

import java.util.Random;
import java.util.Scanner;

/**
 * 
 * @author Tran Ngoc Dan
 * @version: 1.0
 * @since : 13/09/2016
 */
public class SumOfArrayThread {

	public static void main(String[] args) throws InterruptedException {
		Scanner input = new Scanner(System.in);
		System.out.println("Input n: ");
		int n = input.nextInt();
		int arr[] = new int[n];
		Random random = new Random();
		for(int i = 0; i < n; i++){
			arr[i] = random.nextInt(10);
		}
		System.out.println("Input num of threads: ");
		int numThreads = input.nextInt();
		int sum = sum(arr, numThreads);
		String strArr = "";
		for(int value: arr){
			strArr += value + " ";
		}
		System.out.println("Array: " + strArr);
		System.out.println("Sum: " + sum);
	}

	// sum of array
	public static int sum(int[] arr, int numThreads) throws InterruptedException{
		int len = arr.length;
		int sum = 0;
		SumThread[] ts = new SumThread[numThreads];
		for(int i = 0; i < numThreads; i++){
                        //A thread is charge of a sub-array...
			ts[i] = new SumThread((i * len) / numThreads, (((i + 1) * len) /numThreads), arr);
                        //0 - 1//1- 3//3 - 5//5-6
			ts[i].start();
		}
		
		for(int i = 0; i < numThreads; i++){
			ts[i].join();
			sum += ts[i].getSum();
		}
		return sum;
	}
}
