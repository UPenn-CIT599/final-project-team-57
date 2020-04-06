	import java.io.File;
	import java.io.FileNotFoundException;
	import java.util.ArrayList;
	import java.util.Scanner;

	
public class HotelBookingReader {


		/**
		 * Reads in Hotel Booking data row by row from CSV
		 * @return ArrayList of objects created using the CSV
		 */
	
		public static ArrayList<HotelBooking> readCSV() {
			ArrayList<HotelBooking> hotelBooking = new ArrayList<HotelBooking>();
			File hotelBookingFile = new File("hotel_bookings.csv");
			try {
				Scanner fileReader = new Scanner(hotelBookingFile);
				fileReader.nextLine(); // skip title row
				while (fileReader.hasNextLine()) {
					String line = fileReader.nextLine();
					String[] lineComponents = line.split(",");
					
					
					int leadTime = -1;
					int arrivalDateYear = -1; 
					int arrivalDateWeekNum = -1;
					int arrivalDateDayOfMonth = -1;
					int staysInWeekendNights = -1;
					int staysInWeekNights = -1;
					int adults = -1;
					int children = -1; 
					int babies = -1; 
					int previousCancellations = -1; 
					int previousBookingsNotCanceled = -1; 
					int bookingChanges = -1;
					int agent = -1; 
					int company = -1; 
					int daysInWaitingList = -1; 
					int adr = -1; 
					int requiredCarParkingSpaces = -1; 
					int totalOfSpecialRequests = -1; 
					
					
					String hotel = lineComponents[0];
					
					boolean isCanceled = (lineComponents[1].equals("1"));
					
					
					try {
						leadTime = Integer.parseInt(lineComponents[2]);
					} catch (NumberFormatException e) {
						
					}
				
					try {
						arrivalDateYear = Integer.parseInt(lineComponents[3]);
					} catch (NumberFormatException e) {
						
					}
				
					String arrivalDateMonth = lineComponents[4];

					
					try {
						arrivalDateWeekNum = Integer.parseInt(lineComponents[5]);
					} catch (NumberFormatException e) {

					}
					
			
					try {
						arrivalDateDayOfMonth = Integer.parseInt(lineComponents[6]);
					} catch (NumberFormatException e) {

					}
					
					try {
						staysInWeekendNights  = Integer.parseInt(lineComponents[7]);
					} catch (NumberFormatException e) {

					}
					
					try {
						staysInWeekNights = Integer.parseInt(lineComponents[8]);
					} catch (NumberFormatException e) {

					}
					
					try {
						adults = Integer.parseInt(lineComponents[9]);
					} catch (NumberFormatException e) {

					}
					
					try {
						children = Integer.parseInt(lineComponents[10]);
					} catch (NumberFormatException e) {

					}
					
					try {
						babies = Integer.parseInt(lineComponents[11]);
					} catch (NumberFormatException e) {

					}
					
					String meal = lineComponents[12];
					
					String country = lineComponents[13];
					
					String marketSegment = lineComponents[14]; 
					
					String distributionChannel = lineComponents[15];
					
					boolean repeatedGuest = (lineComponents[16].equals("1"));
					
					try {
						previousCancellations = Integer.parseInt(lineComponents[17]);
					} catch (NumberFormatException e) {

					}
					try {
						previousBookingsNotCanceled = Integer.parseInt(lineComponents[18]);
					} catch (NumberFormatException e) {

					}

					String reservedRoomType = lineComponents[19];
					
					String assignedRoomType = lineComponents[20];
					
					try {
						bookingChanges = Integer.parseInt(lineComponents[21]);
						} catch (NumberFormatException e) {

						}
					
					String depositType = lineComponents[22];
					
					try {
						 agent = Integer.parseInt(lineComponents[23]);
						} catch (NumberFormatException e) {

						}
					
					try {
						company = Integer.parseInt(lineComponents[24]);
						} catch (NumberFormatException e) {

						}
					
					try {
						daysInWaitingList = Integer.parseInt(lineComponents[25]);
						} catch (NumberFormatException e) {

						}
					
					String customerType = lineComponents[26];
					
					try {
						adr = Integer.parseInt(lineComponents[27]);
					} catch (NumberFormatException e) {

					}
					
					try {
						requiredCarParkingSpaces = Integer.parseInt(lineComponents[28]);
					} catch (NumberFormatException e) {

					}
					
					try {
						totalOfSpecialRequests = Integer.parseInt(lineComponents[29]);
					} catch (NumberFormatException e) {

					}
					
					String reservationStatus = lineComponents[30];
					
					String reservationStatusDate = lineComponents[31];
				/**
				* Constructor for instance variables
				*/
					HotelBooking hotelBookings = new HotelBooking(hotel, isCanceled, leadTime, arrivalDateYear, arrivalDateMonth, arrivalDateWeekNum, arrivalDateDayOfMonth,
							staysInWeekendNights, staysInWeekNights, adults, children, babies, meal, country, marketSegment, distributionChannel,
							repeatedGuest, previousCancellations, previousBookingsNotCanceled, reservedRoomType,	assignedRoomType, bookingChanges,
							depositType, agent, company, daysInWaitingList, customerType, adr, requiredCarParkingSpaces, totalOfSpecialRequests,
							reservationStatus, reservationStatusDate);
					
					hotelBooking.add(hotelBookings);
				}
				fileReader.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return hotelBooking;
		}

}
