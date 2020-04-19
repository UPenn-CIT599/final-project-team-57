import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HotelBookingReader {

	/**
	 * Reads in Hotel Booking data row by row from CSV
	 * 
	 * @return ArrayList of objects created using the CSV
	 */

	public List<HotelBooking> readCSVFile(String inputFileName) {
		List<HotelBooking> hotelBookingList = new ArrayList<>();
		File file = new File(inputFileName);
		try (Scanner scan = new Scanner(file)) {
			scan.nextLine();
			while (scan.hasNextLine()) {
				String flightRow = scan.nextLine();
				String[] rowData = flightRow.split(",");
				HotelBooking hotelBooking = new HotelBooking();
				hotelBooking.setHotel(rowData[0]);
				hotelBooking.setCanceled(convertToBoolean(rowData[1]));
				hotelBooking.setLeadTime(convertToInt(rowData[2]));
				hotelBooking.setArrivalDateYear(convertToInt(rowData[3]));
				hotelBooking.setArrivalDateMonth(rowData[4]);
				hotelBooking.setArrivalDateWeekNum(convertToInt(rowData[5]));
				hotelBooking.setArrivalDateDayOfMonth(convertToInt(rowData[6]));
				hotelBooking.setStaysInWeekendNights(convertToInt(rowData[7]));
				hotelBooking.setStaysInWeekNights(convertToInt(rowData[8]));
				hotelBooking.setAdults(convertToInt(rowData[9]));
				hotelBooking.setChildren(convertToInt(rowData[10]));
				hotelBooking.setBabies(convertToInt(rowData[11]));
				hotelBooking.setMeal(rowData[12]);
				hotelBooking.setCountry(rowData[13]);
				hotelBooking.setMarketSegment(rowData[14]);
				hotelBooking.setDistributionChannel(rowData[15]);
				hotelBooking.setRepeatedGuest(convertToBoolean(rowData[16]));
				hotelBooking.setPreviousCancellations(convertToInt(rowData[17]));
				hotelBooking.setPreviousBookingsNotCanceled(convertToInt(rowData[18]));
				hotelBooking.setReservedRoomType(rowData[19]);
				hotelBooking.setAssignedRoomType(rowData[20]);
				hotelBooking.setBookingChanges(convertToInt(rowData[21]));
				hotelBooking.setDepositType(rowData[22]);
				hotelBooking.setAgent(convertToInt(rowData[23]));
				hotelBooking.setCompany(convertToInt(rowData[24]));
				hotelBooking.setDaysInWaitingList(convertToInt(rowData[25]));
				hotelBooking.setCustomerType(rowData[26]);
				hotelBooking.setAdr(Double.valueOf(rowData[27]));
				hotelBooking.setRequiredCarParkingSpaces(convertToInt(rowData[28]));
				hotelBooking.setTotalOfSpecialRequests(convertToInt(rowData[29]));
				hotelBooking.setReservationStatus(rowData[30]);
				hotelBooking.setReservationStatusDate(parseDate(rowData[31]));
				hotelBookingList.add(hotelBooking);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return hotelBookingList;
	}

	private static int convertToInt(String inputValue) {
		if (inputValue == null || inputValue.length() == 0 || inputValue.equalsIgnoreCase("NULL")
				|| inputValue.equalsIgnoreCase("NA")) {
			return -1;
		}
		return Integer.valueOf(inputValue);
	}

	private static boolean convertToBoolean(String inputValue) {
		return convertToInt(inputValue) == 0 ? false : true;
	}

	private static LocalDate parseDate(String date) {
		try {
			return LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		} catch (Exception e) {
			return LocalDate.parse(date, DateTimeFormatter.ofPattern("MM/d/yy"));
		}
	}
}
