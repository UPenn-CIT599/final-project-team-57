import java.util.ArrayList;
import java.util.List;

public class HotelBookingRunner {
	

	public static void main(String[] args) {
		HotelBookingReader hbr = new HotelBookingReader();
		List<HotelBooking> hotelBookingList = hbr.readCSVFile("hotel_bookings.csv");

		System.out.println("Number of rows " +hotelBookingList.size());
		DataAnalysis da = new DataAnalysis(hotelBookingList);
		List<HotelBooking> hotelBooking = da.getHotelBooking();
		ArrayList<HotelBooking> canceledRooms = da.isCanceled();
		
		
		da.getAnswer1();
		da.getAnswer2();
		da.getAnswer3(canceledRooms);
		da.getAnswer4(hotelBooking);
		da.getAnswer5(hotelBooking);
		

		//FormattedOutput fo = new FormattedOutput();
	}
}
