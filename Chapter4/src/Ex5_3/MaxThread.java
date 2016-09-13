package Ex5_3;
/**
 * 
 * @author Tran Ngoc Dan
 * @version: 1.0
 * @since : 13/09/2016
 */
public class MaxThread extends Thread {

    private int low;
    private int high;
    private int[] arr;
    private int max = 0;

    public MaxThread(int low, int high, int[] arr) {
        super();
        this.low = low;
        this.high = high;
        this.arr = arr;
    }

    public int[] getArr() {
        return arr;
    }

    public void setArr(int[] arr) {
        this.arr = arr;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    @Override
    public void run() {
        for (int i = this.low; i < this.high; i++) {
            this.max = Math.max(arr[i], this.max);
        }
    }
}
