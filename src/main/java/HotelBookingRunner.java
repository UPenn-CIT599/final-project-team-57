import java.util.List;

public class HotelBookingRunner {
	public static void main(String[] args) {
		HotelBookingReader hbr = new HotelBookingReader();
		List<HotelBooking> hotelBookingList = hbr.readCSVFile("hotel_bookings.csv");
		System.out.println("Number of rows " +hotelBookingList.size());
		DataAnalysis da = new DataAnalysis(hotelBookingList);
		da.getAnswer1();
		
		
		//FormattedOutput fo = new FormattedOutput();
	}
}
