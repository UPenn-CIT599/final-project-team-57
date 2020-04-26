import java.math.BigDecimal;
import java.math.MathContext;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

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
		System.out.println("Maximum rate = $" +maxRate);
		return maxRate;
	}

	/**
	 * Question 2: What is the minimum rate for a non-cancelled resort hotel room in USA over the years?
	 * @return
	 */

	public String getAnswer2() {

		double minRate = this.hotelBookings.stream()
				.filter(booking -> booking.getCountry().equalsIgnoreCase("USA"))
				.filter(booking -> booking.getHotel().equalsIgnoreCase("Resort Hotel"))
				.filter(booking -> !booking.isCanceled())
				.filter(booking -> !((booking.getStaysInWeekNights() == 0) && (booking.getStaysInWeekendNights() == 0)))
				.mapToDouble(booking -> booking.getAdr())
				.min()
				.getAsDouble();
		
		NumberFormat nf = NumberFormat.getInstance();
		nf.setMinimumFractionDigits(2);
		
		System.out.println("Minimum rate = $" + nf.format(minRate));
		String roundedMinRate = nf.format(minRate);
		return roundedMinRate;
	}

	/**
	 * Question 3: What percentage of the time are room reservations cancelled?
	 * @param cancelled
	 * @return
	 */
	public double getAnswer3(List<HotelBooking> canceledRooms) {
		double percentage = 0.0;
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
		Double roundedPercentage = bd.doubleValue();
				
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
		Double roundedAverage = bd.doubleValue();
		
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
		
		for (HotelBooking booking: hotelBooking) {
			if(booking.getLeadTime()>=0) {//not void
				sum += booking.getLeadTime();
				count++;
			}
		}
		average = sum / count;
		BigDecimal bd = new BigDecimal(average);
		bd = bd.round(new MathContext(3));
		Double roundedAverage = bd.doubleValue();
		
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
		int count = 0; 
		for  (HotelBooking hotelBooking : hotelBookings) {
			
			if  (!hotelBooking.getArrivalDateMonth().equals("")  && hotelBooking.getArrivalDateDayOfMonth() > 0) {
				
				String day = Integer.toString(hotelBooking.getArrivalDateDayOfMonth());
				String date = hotelBooking.getArrivalDateMonth() + " " + day;
				
	
				if (BestTimeToBook.containsKey(date)) {
					 BestTimeToBook.put(date, count++);
				}
				else {
					BestTimeToBook.put(date, count++);
				}
			}
			
		}
	
		String BestBookingTime = "";
		String WorstBookingTime = "";

		ArrayList<Integer> numberOfBookings = new ArrayList<>();
		for (String date : BestTimeToBook.keySet()) {
			numberOfBookings.add(BestTimeToBook.get(date));
		}
		

		//sort low to high, then iterate to see what item matches lowest number of bookings
		Collections.sort(numberOfBookings);
		for (String date : BestTimeToBook.keySet()) {
			if (BestTimeToBook.get(date) == numberOfBookings.get(0)) {
				
				if (date.endsWith("1") || date.endsWith("21") || date.endsWith("31"));
					BestBookingTime = date + "st";
				if (date.endsWith("2") || date.endsWith("22"));
					BestBookingTime = date + "nd";
				if (date.endsWith("3") || date.endsWith("23"));
					BestBookingTime = date + "rd";
				if (date.endsWith("4") || date.endsWith("5") || date.endsWith("6") || date.endsWith("7") || date.endsWith("8") || date.endsWith("9")||
						date.endsWith("10") || date.endsWith("11") || date.endsWith("12") || date.endsWith("13") || date.endsWith("14") || date.endsWith("15")
						|| date.endsWith("16") || date.endsWith("17") || date.endsWith("18") || date.endsWith("19") || date.endsWith("20") || date.endsWith("24")
						|| date.endsWith("25") || date.endsWith("26") || date.endsWith("27") || date.endsWith("28") || date.endsWith("29") || date.endsWith("30"));
					BestBookingTime = date + "th";
			}
		
		}
		for (String date : BestTimeToBook.keySet()) {
			if (BestTimeToBook.get(date) == numberOfBookings.get(numberOfBookings.size() - 1)) {
			
				if (date.endsWith("1") || date.endsWith("21") || date.endsWith("31"));
				WorstBookingTime = date + "st";
				if (date.endsWith("2") || date.endsWith("22"));
				WorstBookingTime = date + "nd";
				if (date.endsWith("3") || date.endsWith("23"));
				WorstBookingTime = date + "rd";
				if (date.endsWith("4") || date.endsWith("5") || date.endsWith("6") || date.endsWith("7") || date.endsWith("8") || date.endsWith("9")||
					date.endsWith("10") || date.endsWith("11") || date.endsWith("12") || date.endsWith("13") || date.endsWith("14") || date.endsWith("15")
					|| date.endsWith("16") || date.endsWith("17") || date.endsWith("18") || date.endsWith("19") || date.endsWith("20") || date.endsWith("24")
					|| date.endsWith("25") || date.endsWith("26") || date.endsWith("27") || date.endsWith("28") || date.endsWith("29") || date.endsWith("30"));
				WorstBookingTime = date + "th";
			}
			
		}
		
		String answer6 =  "Hotels lowest number of bookings is made for " + BestBookingTime + ". " + 
		"Hotel highest number of bookings is made for " + WorstBookingTime+ ".";
		
		System.out.println(answer6);
		return answer6;
	}

}
