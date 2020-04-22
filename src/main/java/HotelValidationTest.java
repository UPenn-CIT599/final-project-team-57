//import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

/**
 * Validation tests for Group Project
 */

public class HotelValidationTest {

	HotelBookingReader hbr = new HotelBookingReader();
	List<HotelBooking> hotelBookingList = hbr.readCSVFile("hotel_bookings.csv");

	DataAnalysis da = new DataAnalysis(hotelBookingList);
	List<HotelBooking> canceledRooms = da.getHotelBooking();
	List<HotelBooking> hotelBooking = da.getHotelBooking();

	@Test
	public void questionOneMaxRate() {
		DataAnalysis Junit = new DataAnalysis(hotelBookingList);
		double answer = Junit.getAnswer1();
		assertEquals(328.33, answer);
	}

	@Test
	public void questionTwoMinRate() {
		DataAnalysis Junit = new DataAnalysis(hotelBookingList);
		double answer = Junit.getAnswer1();
		assertEquals(4.00, answer);
	}
	
	@Test
	public void questionThreeCanceledRooms() {
		DataAnalysis Junit = new DataAnalysis(hotelBookingList);
		double answer = Junit.getAnswer3(canceledRooms);
		assertEquals(37.04, answer);	
	}
	
	@Test
	public void questionFourAverageDaysStayed() {
		DataAnalysis Junit = new DataAnalysis(hotelBookingList);
		double answer = Junit.getAnswer4(hotelBooking);
		assertEquals(3.43, answer);	
	}
	
	@Test
	public void questionFiveAverageLeadTime() {
		DataAnalysis Junit = new DataAnalysis(hotelBookingList);
		double answer = Junit.getAnswer5(hotelBooking);
		assertEquals(104.0, answer);	
	}
	
	
}
