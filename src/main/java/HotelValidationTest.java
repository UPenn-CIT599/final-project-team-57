import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;


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
	public void questionOneMaxRateNeg() {
		DataAnalysis Junit = new DataAnalysis(hotelBookingList);
		double answer = Junit.getAnswer1();
		Assert.assertNotEquals(328.34, answer);
	}

	@Test
	public void questionOneMaxRateNeg2() {
		DataAnalysis Junit = new DataAnalysis(hotelBookingList);
		double answer = Junit.getAnswer1();
		Assert.assertNotEquals(328, answer);
	}
	
	@Test
	public void questionTwoMinRate() {
		DataAnalysis Junit = new DataAnalysis(hotelBookingList);
		String answer = Junit.getAnswer2();
		assertEquals("4.00",answer);
	}

	@Test
	public void questionTwoMinRateNeg() {
		DataAnalysis Junit = new DataAnalysis(hotelBookingList);
		String answer = Junit.getAnswer2();
		Assert.assertNotEquals("4.01",answer);
	}

	@Test
	public void questionTwoMinRateNeg2() {
		DataAnalysis Junit = new DataAnalysis(hotelBookingList);
		String answer = Junit.getAnswer2();
		Assert.assertNotEquals(4.00,answer);
	}
	
	@Test
	public void questionThreeCanceledRooms() {
		DataAnalysis Junit = new DataAnalysis(hotelBookingList);
		double answer = Junit.getAnswer3(canceledRooms);
		assertEquals(37.04, answer);	
	}
	
	@Test
	public void questionThreeCanceledRoomsNeg() {
		DataAnalysis Junit = new DataAnalysis(hotelBookingList);
		double answer = Junit.getAnswer3(canceledRooms);
		Assert.assertNotEquals(37.00, answer);	
	}
	
	@Test
	public void questionThreeCanceledRoomsNeg2() {
		DataAnalysis Junit = new DataAnalysis(hotelBookingList);
		double answer = Junit.getAnswer3(canceledRooms);
		Assert.assertNotEquals(37, answer);	
	}
	
	@Test
	public void questionFourAverageDaysStayed() {
		DataAnalysis Junit = new DataAnalysis(hotelBookingList);
		double answer = Junit.getAnswer4(hotelBooking);
		assertEquals(3.43, answer);	
	}
	
	@Test
	public void questionFourAverageDaysStayedNeg() {
		DataAnalysis Junit = new DataAnalysis(hotelBookingList);
		double answer = Junit.getAnswer4(hotelBooking);
		Assert.assertNotEquals(3.44, answer);	
	}
	
	@Test
	public void questionFourAverageDaysStayedNeg2() {
		DataAnalysis Junit = new DataAnalysis(hotelBookingList);
		double answer = Junit.getAnswer4(hotelBooking);
		Assert.assertNotEquals(3.00, answer);	
	}
	
	@Test
	public void questionFiveAverageLeadTime() {
		DataAnalysis Junit = new DataAnalysis(hotelBookingList);
		double answer = Junit.getAnswer5(hotelBooking);
		assertEquals(104.0, answer);	
	}
	
	@Test
	public void questionFiveLeadTimeNeg() {
		DataAnalysis Junit = new DataAnalysis(hotelBookingList);
		double answer = Junit.getAnswer5(hotelBooking);
		Assert.assertNotEquals(200.0, answer);	
	}
	
	
	@Test
	public void questionFiveLeadTimeNeg2() {
		DataAnalysis Junit = new DataAnalysis(hotelBookingList);
		double answer = Junit.getAnswer5(hotelBooking);
		Assert.assertNotEquals(104, answer);	
	}
	
	@Test
	public void questionSixBookingTime() {
		DataAnalysis Junit = new DataAnalysis(hotelBookingList);
		String answer = Junit.getAnswer6();
		assertEquals("Hotels lowest number of bookings is made for February 29th. Hotel highest number of bookings is made for August 29th.", answer);
	}
	
	@Test
	public void questionSixBookingTimeNeg() {
		DataAnalysis Junit = new DataAnalysis(hotelBookingList);
		String answer = Junit.getAnswer6();
		Assert.assertNotEquals("Hotels lowest number of bookings is made for January 29th. Hotel highest number of bookings is made for December 29th.", answer);
	}
	
	//Tests the number endings annotations
	@Test
	public void questionSixBookingTimeNeg2() {
		DataAnalysis Junit = new DataAnalysis(hotelBookingList);
		String answer = Junit.getAnswer6();
		Assert.assertNotEquals("Hotels lowest number of bookings is made for January 29rd. Hotel highest number of bookings is made for December 29st.", answer);
	}
}
