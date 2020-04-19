import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class DataAnalysis {
	
	ArrayList<HotelBooking> hotelBookings = new ArrayList<HotelBooking>();
	
	public DataAnalysis (ArrayList<HotelBooking> hotelBookings) {
		this.hotelBookings = hotelBookings;
	}


	/**
	 * Returns all hotel booking objects read from CSV
	 * @return
	 */
	public ArrayList<HotelBooking> getHotelBooking() {
		return hotelBookings;
	}

	/**
	 * Question 1
	 * 	Finds the most and least busy time to book a hotel room
	 * @return
	 */
	
	public String getAnswer1(){
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
		
		
		String answer1 =  "Best time to book is " + BestBookingTime + "Worst time to book is " + WorstBookingTime;

		return answer1;
	}
	
	/**
	 * Question 2: What is the cheapest and most expensive rates for hotel rooms?
	 * @return
	 */
	
	public static double getRoomRates(ArrayList<HotelBooking> adr) {
		double sum=0;
		int count=0;
		for (HotelBooking roomRates: adr) {
			if(roomRates.getAdr()>=0) {
				sum += roomRates.getAdr();
				count++;
			}
		}
		return sum/count;
		}
		
		
//		String answer2 =  "The lowest hotel room rate is " + BestBookingTime +  ". The most expensive hotel room rate is" + WorstBookingTime;
//
//		return answer2;
//	}


	/**
	 * Question 3: What is the average lead time for booking a hotel room?
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
	