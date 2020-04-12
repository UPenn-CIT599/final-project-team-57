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

}


/*
 * get the average lead time 
 */
	public static double getAvgLeadTime(ArrayList<HotelBooking> leadTime) {
	double sum=0;
	int count=0;
	for (HotelBooking booking: leadTime) {
		if(hoteBooking.getLeadTime()>=0) {//not void
			sum+=hotelBooking.getLeadTime();
			count++;
		}
	}
	return sum/count;
} 
