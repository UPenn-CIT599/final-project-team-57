	/**
	 * Represents each passenger from the CSV
	 
	 */
public class HotelBooking {

		// Instance variables to represent information in each row
	
		private String hotel;
		private boolean isCanceled;
		private int leadTime;
		private int arrivalDateYear;
		private int arrivalDateMonth;
		private int arrivalDateWeekNum;
		private int arrivalDateDayOfMonth;
		private int staysInWeekendNights;
		private int staysInWeekNights;
		private int adults;
		private int children;
		private int babies;
		private String meal;
		private String country;
		private String marketSegment;
		private String distributionChannel;
		private boolean repeatedGuest;
		private int previousCancellations;
		private int previousBookingsNotCanceled;
		private String reservedRoomType;
		private String assignedRoomType;
		private int bookingChanges;
		private String depositType;
		private int agent;
		private int company;
		private int daysInWaitingList;
		private String customerType;
		private int adr;
		private int requiredCarParkingSpaces;
		private int totalOfSpecialRequests;
		private String reservationStatus;
		private String reservationStatusDate;
		


		/**
		 * 
		 * @param hotel
		 * @param isCanceled
		 * @param leadTime
		 * @param arrivalDateYear
		 * @param arrivalDateMonth
		 * @param arrivalDateWeekNum
		 * @param arrivalDateDayOfMonth
		 * @param staysInWeekendNights
		 * @param staysInWeekNights
		 * @param adults
		 * @param children
		 * @param babies
		 * @param meal
		 * @param country
		 * @param marketSegment
		 * @param distributionChannel
		 * @param repeatedGuest
		 * @param previousCancellations
		 * @param previousBookingsNotCanceled
		 * @param reservedRoomType
		 * @param assignedRoomType
		 * @param bookingChanges
		 * @param depositType
		 * @param agent
		 * @param company
		 * @param daysInWaitingList
		 * @param customerType
		 * @param adr
		 * @param requiredCarParkingSpaces
		 * @param totalOfSpecialRequests
		 * @param reservationStatus
		 * @param reservationStatusDate
		 */

		public HotelBooking(String hotel, boolean isCanceled, int leadTime, int arrivalDateYear, int arrivalDateMonth, int arrivalDateWeekNum, int arrivalDateDayOfMonth,
		int staysInWeekendNights, int staysInWeekNights, int adults, int children, int babies, String meal, String country, String marketSegment, String distributionChannel,
		boolean repeatedGuest, int previousCancellations, int previousBookingsNotCanceled, String reservedRoomType,	String assignedRoomType, int bookingChanges,
		String depositType, int agent, int company, int daysInWaitingList, String customerType, int adr, int requiredCarParkingSpaces, int totalOfSpecialRequests,
		String reservationStatus, String reservationStatusDate) {
			
			this.hotel = hotel;
			this.isCanceled = isCanceled;
			this.leadTime = leadTime;
			this.arrivalDateYear = arrivalDateYear;
			this.arrivalDateMonth = arrivalDateMonth;
			this.arrivalDateWeekNum = arrivalDateWeekNum;
			this.arrivalDateDayOfMonth = arrivalDateDayOfMonth;
			this.staysInWeekendNights = staysInWeekendNights;
			this.staysInWeekNights = staysInWeekNights;
			this.adults = adults;
			this.children = children;
			this.babies = babies;
			this.meal = meal;
			this.country = country;
			this.marketSegment = marketSegment;
			this.distributionChannel = distributionChannel;
			this.repeatedGuest = repeatedGuest;
			this.previousCancellations = previousCancellations;
			this.previousBookingsNotCanceled =previousBookingsNotCanceled;
			this.reservedRoomType = reservedRoomType;
			this.assignedRoomType =assignedRoomType;
			this.bookingChanges = bookingChanges;
			this.depositType = depositType;
			this.agent = agent;
			this.company = company;
			this.daysInWaitingList = daysInWaitingList;
			this.customerType = customerType;
			this.adr = adr;
			this.requiredCarParkingSpaces = requiredCarParkingSpaces;
			this.totalOfSpecialRequests = totalOfSpecialRequests;
			this.reservationStatus = reservationStatus;
			this.reservationStatusDate = reservationStatusDate;
		}



		public String getHotel() {
			return hotel;
		}



		public boolean isCanceled() {
			return isCanceled;
		}



		public int getLeadTime() {
			return leadTime;
		}



		public int getArrivalDateYear() {
			return arrivalDateYear;
		}



		public int getArrivalDateMonth() {
			return arrivalDateMonth;
		}



		public int getArrivalDateWeekNum() {
			return arrivalDateWeekNum;
		}



		public int getArrivalDateDayOfMonth() {
			return arrivalDateDayOfMonth;
		}



		public int getStaysInWeekendNights() {
			return staysInWeekendNights;
		}



		public int getStaysInWeekNights() {
			return staysInWeekNights;
		}



		public int getAdults() {
			return adults;
		}



		public int getChildren() {
			return children;
		}



		public int getBabies() {
			return babies;
		}



		public String getMeal() {
			return meal;
		}



		public String getCountry() {
			return country;
		}



		public String getMarketSegment() {
			return marketSegment;
		}



		public String getDistributionChannel() {
			return distributionChannel;
		}



		public boolean isRepeatedGuest() {
			return repeatedGuest;
		}



		public int getPreviousCancellations() {
			return previousCancellations;
		}



		public int getPreviousBookingsNotCanceled() {
			return previousBookingsNotCanceled;
		}



		public String getReservedRoomType() {
			return reservedRoomType;
		}



		public String getAssignedRoomType() {
			return assignedRoomType;
		}



		public int getBookingChanges() {
			return bookingChanges;
		}



		public String getDepositType() {
			return depositType;
		}



		public int getAgent() {
			return agent;
		}



		public int getCompany() {
			return company;
		}



		public int getDaysInWaitingList() {
			return daysInWaitingList;
		}



		public String getCustomerType() {
			return customerType;
		}



		public int getAdr() {
			return adr;
		}



		public int getRequiredCarParkingSpaces() {
			return requiredCarParkingSpaces;
		}



		public int getTotalOfSpecialRequests() {
			return totalOfSpecialRequests;
		}



		public String getReservationStatus() {
			return reservationStatus;
		}



		public String getReservationStatusDate() {
			return reservationStatusDate;
		}
}