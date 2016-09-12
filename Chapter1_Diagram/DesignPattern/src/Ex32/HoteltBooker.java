package Ex32;

/**
 * 
 * @author Tran Ngoc Dan
 * date: 5/9/2016
 * @version : 1.0
 *
 */
public class HoteltBooker implements Booker{
	@Override
	public String getInformation(String date, String hour, String place) {
		return "date: " + date + ", hour: " + hour + ", place: " + place + " have hotel: A, B and C";
	}
}
