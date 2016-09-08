package Ex32;

/**
 * 
 * @author Tran Ngoc Dan
 * date: 5/9/2016
 * @version : 1.0
 *
 */
public class FlightBooker implements Booker{


	@Override
	public String getInformation(String date, String hour, String place) {
		return "date: " + date + ", hour: " + hour + ", place: " + place + " have fight A, B and C"; 
	}

	public FlightBooker() {
		super();
	}
	
	
	
}
