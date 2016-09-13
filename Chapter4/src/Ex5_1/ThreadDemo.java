package Ex5_1;
/**
 * 
 * @author Tran Ngoc Dan
 * @version: 1.0
 * @since : 13/09/2016
 */
public class ThreadDemo extends Thread{
	private Thread t;
	private String threadName;
	
	ThreadDemo(String name){
		threadName = name;
		System.out.println("Creating " + threadName);
	}
	
        @Override
	public void run(){
		System.out.println("Running " + threadName);
		try{
			for(int i = 3; i > 0; i--){
				System.out.println("Thread " + threadName + ", " + i);
				Thread.sleep(50);
			}
		}catch(Exception e){
			System.out.println("Thread " + threadName + " interupted.");
		}
		System.out.println("Thread " + threadName + " exiting.");
	}
	
	public void start(){
		System.out.println("Starting " + threadName);
		if(t == null){
			t = new Thread(this, threadName);
			t.start();
		}
	}
}
