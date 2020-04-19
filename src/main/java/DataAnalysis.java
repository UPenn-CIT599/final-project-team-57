import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class DataAnalysis {
	
	List<HotelBooking> hotelBookings = new ArrayList<HotelBooking>();
	
	public DataAnalysis (List<HotelBooking> hotelBookings) {
		this.hotelBookings = hotelBookings;
	}

	/**
	 * Question 2: What is the average rate for a hotel room?
	 * @param cost
	 * @return
	 */

	public static double getRoomRates(ArrayList<HotelBooking> cost) {
		double sum = 0;
		int count = 0;
		for (HotelBooking hotelBooking : cost) {
			if (hotelBooking.getAdr() >= 0) { // Rooms without rate info have a value  = -1 and are not included
				sum += hotelBooking.getAdr();
				count++;
			}
		}
		return sum / count;
	}
	
	/**
	 * Question 3: What percentage of the time are room reservations cancelled?
	 * @param cancelled
	 * @return
	 */
	
	public static double getCancelledPercentage(ArrayList<HotelBooking> cancelled) {
		double totalReservations = 0;
		int count = 0;
		for (HotelBooking hotelBooking : cancelled) {
			if (hotelBooking.isCanceled()) { // Rooms without cancellation info have a value  = -1 and are not included
				totalReservations++;
				count++;
			}
			else {
				totalReservations++;
			}
		}
		return (count / totalReservations) * 100;
	}
	
	/**
	 * Question 4: What is the average number of days stayed?
	 * @param nightsStayed
	 * @return
	 */
	
	public static double getAvgNightsStayed(ArrayList<HotelBooking> nightsStayed) {
	double sum=0;
	int count=0;
	for (HotelBooking hotelBooking: nightsStayed) {
		if(hotelBooking.getStaysInWeekNights()>=0 || hotelBooking.getStaysInWeekendNights()>=0 ) { //Rooms without rate info have a value  = -1 and are not included
			sum += hotelBooking.getStaysInWeekNights();
			sum += hotelBooking.getStaysInWeekendNights();
			count++;
		}
	}
		return sum/count;
	}
	

	/**
	 * Question 5: What is the average lead time for booking a hotel room?
	 * @return
	 */
	
	public static double getAvgLeadTime(ArrayList<HotelBooking> leadTime) {
	double sum=0;
	int count=0;
	for (HotelBooking booking: leadTime) {
		if(booking.getLeadTime()>=0) {//not void
			sum += booking.getLeadTime();
			count++;
		}
	}
		return sum/count;
		}
	} 
}

	