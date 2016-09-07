package Ex32;

/**
 * 
 * @author Tran Ngoc Dan
 * date: 5/9/2016
 * @version : 1.0
 *
 */
public class TrainBooker implements Booker{
	
	public TrainBooker() {	
	}
	
	@Override
	public String getInformation(String date, String hour, String place) {
		return "date: " + date + ", hour: " + hour + ", place: " + place + " have train: A, B and C";
	}

}
