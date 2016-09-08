package Ex32;
/**
 * 
 * @author Tran Ngoc Dan
 * date: 5/9/2016
 * @version : 1.0
 *
 */
public class BookingFacade {
	private Booker flightBooker;
	private Booker hotelBooker;
	private Booker trainBooker;
	
	public BookingFacade(){
		flightBooker = new FlightBooker();
		hotelBooker = new HoteltBooker();
		trainBooker = new TrainBooker();
	}
	
	public String bookFlight(String date, String hour, String place){
		return flightBooker.getInformation(date, hour, place);
	}
	
	public String bookHotel(String date, String hour, String place){
		return hotelBooker.getInformation(date, hour, place);
	}
	
	public String bookTrain(String date, String hour, String place){
		return trainBooker.getInformation(date, hour, place);
	}
	
}
