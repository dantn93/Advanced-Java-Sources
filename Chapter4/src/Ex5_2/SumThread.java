package Ex5_2;
/**
 * 
 * @author Tran Ngoc Dan
 * @version: 1.0
 * @since : 13/09/2016
 */
public class SumThread extends Thread{
	private int low, high;//
	private int[] arr;
	private int sum = 0;
	
	public SumThread(int low, int high, int[] arr) {
		super();
		this.low = low;
		this.high = high;
		this.arr = arr;
	}
        @Override
	public void run(){
		for(int i = this.low; i < this.high; i++){
			this.sum += this.arr[i];
		}
	}
	public int getLo() {
		return low;
	}
	public void setLo(int low) {
		this.low = low;
	}
	public int getHi() {
		return high;
	}
	public void setHi(int high) {
		this.high = high;
	}
	public int[] getArr() {
		return arr;
	}
	public void setArr(int[] arr) {
		this.arr = arr;
	}
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
}
