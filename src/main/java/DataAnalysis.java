import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class DataAnalysis {

	List<HotelBooking> hotelBookings = new ArrayList<HotelBooking>();

	public DataAnalysis (List<HotelBooking> hotelBookingList) {
		this.hotelBookings = hotelBookingList;
	}
	
	/**
	 * Returns all hotel booking objects read from CSV
	 * @return
	 */
	public List<HotelBooking> getHotelBooking() {
		return hotelBookings;
	}
	
	
	/**
	 * Finds all cancelled rooms
	 * @return
	 */
	public ArrayList<HotelBooking> isCanceled() {
		ArrayList<HotelBooking> results = new ArrayList<HotelBooking>();
		for (HotelBooking canceled : hotelBookings) {
			if (canceled.isCanceled()) {
				results.add(canceled);
			}
		}
		return results;
	}
	
	
	/**
	 * Question 1: What is the maximum rate for a non-cancelled resort hotel room in USA over the years?
	 * @return
	 */

	public double getAnswer1() {

		double maxRate = this.hotelBookings.stream()
				.filter(booking -> booking.getCountry().equalsIgnoreCase("USA"))
				.filter(booking -> booking.getHotel().equalsIgnoreCase("Resort Hotel"))
				.filter(booking -> !booking.isCanceled())
				.mapToDouble(booking -> booking.getAdr())
				.max()
				.getAsDouble();
		System.out.println("Maximum rate = " +maxRate);
		return maxRate;
	}

	/**
	 * Question 2: What is the minimum rate for a non-cancelled resort hotel room in USA over the years?
	 * @return
	 */

	public double getAnswer2() {

		double minRate = this.hotelBookings.stream()
				.filter(booking -> booking.getCountry().equalsIgnoreCase("USA"))
				.filter(booking -> booking.getHotel().equalsIgnoreCase("Resort Hotel"))
				.filter(booking -> !booking.isCanceled())
				.filter(booking -> !((booking.getStaysInWeekNights() == 0) && (booking.getStaysInWeekendNights() == 0)))
				.mapToDouble(booking -> booking.getAdr())
				.min()
				.getAsDouble();
		
		System.out.println("Minimum rate = " +minRate);
		
		return minRate;
	}

	/**
	 * Question 3: What percentage of the time are room reservations cancelled?
	 * @param cancelled
	 * @return
	 */
	public double getAnswer3(List<HotelBooking> canceledRooms) {
		double percentage = 0.0;
		double roundedPercentage = 0.0;
		double totalReservations = 0.0;
		int count = 0;
	
		for (HotelBooking canceled : canceledRooms) {
			if (canceled.isCanceled() == true) { 
				totalReservations++;
				count++;
			}
			else  { 
				totalReservations++;
			}
		}
		
		percentage = ((count / totalReservations) * 100); // converting to percentage 
		BigDecimal bd = new BigDecimal(percentage);
		bd = bd.round(new MathContext(4));
		roundedPercentage = bd.doubleValue();
				
		
		System.out.println("Percentage of rooms canceled = " + roundedPercentage + "%");
		return roundedPercentage;
	}

	/**
	 * Question 4: What is the average number of days stayed?
	 * @param hotelBooking2
	 * @return
	 */

	public double getAnswer4(List<HotelBooking> hotelBooking2) {
		double sum = 0;
		int count = 0;
		double average = 0;
		double roundedAverage = 0;
		
		for (HotelBooking hotelBooking: hotelBooking2) {
			if(hotelBooking.getStaysInWeekNights()>=0 || hotelBooking.getStaysInWeekendNights()>=0 ) { //Rooms without rate info have a value  = -1 and are not included
				sum += hotelBooking.getStaysInWeekNights();
				sum += hotelBooking.getStaysInWeekendNights();
				count++;
			}
		
		}
		average = sum / count;
		BigDecimal bd = new BigDecimal(average);
		bd = bd.round(new MathContext(3));
		roundedAverage = bd.doubleValue();
		
		System.out.println("The average number of days stayed at a hotel = " + roundedAverage);
		
		return roundedAverage;
	}


	/**
	 * Question 5: What is the average lead time for booking a hotel room?
	 * @return
	 */

	public double getAnswer5(List<HotelBooking> hotelBooking) {
		double sum = 0;
		int count = 0;
		double average = 0;
		double roundedAverage = 0;
		
		for (HotelBooking booking: hotelBooking) {
			if(booking.getLeadTime()>=0) {//not void
				sum += booking.getLeadTime();
				count++;
			}
		}
		average = sum / count;
		BigDecimal bd = new BigDecimal(average);
		bd = bd.round(new MathContext(3));
		roundedAverage = bd.doubleValue();
		
		average = sum / count; 
		System.out.println("The average days of lead time for booking a hotel room = " + roundedAverage);
		
		return roundedAverage;
	}
	
	/**
	 * Question 6
	 * 	Finds the most and least busy time to book a hotel room
	 * @return
	 */
	
	public String getAnswer6(){
		HashMap<String, Integer> BestTimeToBook = new HashMap<>();
		for  (HotelBooking hotelBooking : hotelBookings) {
			if  (!hotelBooking.getArrivalDateMonth().equals("")  && hotelBooking.getArrivalDateDayOfMonth() > 0) {
				
				//converts the int (day) to a string minus comma and back to the int
				String day = Integer.toBinaryString(hotelBooking.getArrivalDateDayOfMonth());
				String dayString = day.substring(0, day.length() -1);
				int arrivialDateDayOfMonth = Integer.parseInt(dayString);
				
				// count starts at one due to the else statement being the first instance 
				int count = 1;
				if (BestTimeToBook.containsKey(hotelBooking.getArrivalDateMonth()) && BestTimeToBook.containsValue(arrivialDateDayOfMonth)) {
					count++;
				}
				else {
					BestTimeToBook.put(hotelBooking.getArrivalDateMonth(), arrivialDateDayOfMonth);
				}
			}
			
		}
	
		String BestBookingTime = "";
		String WorstBookingTime = "";

		ArrayList<Integer> numberOfBookings = new ArrayList<>();
		for (String ArrivalDateMonth : BestTimeToBook.keySet()) {
			numberOfBookings.add(BestTimeToBook.get(ArrivalDateMonth));
		}
		

		//sort low to high, then iterate to see what item matches lowest number of bookings
		Collections.sort(numberOfBookings);
		for (String ArrivalDateMonth : BestTimeToBook.keySet()) {
			if (BestTimeToBook.get(ArrivalDateMonth) == numberOfBookings.get(0)) {
				BestBookingTime = ArrivalDateMonth;
			}
		}
		for (String ArrivalDateMonth : BestTimeToBook.keySet()) {
			if (BestTimeToBook.get(ArrivalDateMonth) == numberOfBookings.get(numberOfBookings.size() - 1)) {
				WorstBookingTime = ArrivalDateMonth;
			}
		}
		
		
		String answer6 =  "Best time to book is " + BestBookingTime + "Worst time to book is " + WorstBookingTime;

		return answer6;
	}
}
