package Ex5_1;

/**
 * 
 * @author Tran Ngoc Dan
 * @version: 1.0
 * @since : 13/09/2016
 */
public class ThreadTest {

	public static void main(String[] args) {
		ThreadDemo T1 = new ThreadDemo("Google");
		T1.start();
		
		ThreadDemo T2 = new ThreadDemo("Yahoo");
		T2.start();

		ThreadDemo T3 = new ThreadDemo("Facebook");
		T3.start();
	}

}
