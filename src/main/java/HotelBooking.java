import java.time.LocalDate;

/**
 * Represents each line from the CSV
 * 
 */
public class HotelBooking {

	// Instance variables to represent information in each row

	private String hotel;
	private boolean isCanceled;
	private int leadTime;
	private int arrivalDateYear;
	private String arrivalDateMonth;
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
	private double adr;
	private int requiredCarParkingSpaces;
	private int totalOfSpecialRequests;
	private String reservationStatus;
	private LocalDate reservationStatusDate;

	public String getHotel() {
		return hotel;
	}

	public void setHotel(String hotel) {
		this.hotel = hotel;
	}

	public boolean isCanceled() {
		return isCanceled;
	}

	public void setCanceled(boolean isCanceled) {
		this.isCanceled = isCanceled;
	}

	public int getLeadTime() {
		return leadTime;
	}

	public void setLeadTime(int leadTime) {
		this.leadTime = leadTime;
	}

	public int getArrivalDateYear() {
		return arrivalDateYear;
	}

	public void setArrivalDateYear(int arrivalDateYear) {
		this.arrivalDateYear = arrivalDateYear;
	}

	public String getArrivalDateMonth() {
		return arrivalDateMonth;
	}

	public void setArrivalDateMonth(String arrivalDateMonth) {
		this.arrivalDateMonth = arrivalDateMonth;
	}

	public int getArrivalDateWeekNum() {
		return arrivalDateWeekNum;
	}

	public void setArrivalDateWeekNum(int arrivalDateWeekNum) {
		this.arrivalDateWeekNum = arrivalDateWeekNum;
	}

	public int getArrivalDateDayOfMonth() {
		return arrivalDateDayOfMonth;
	}

	public void setArrivalDateDayOfMonth(int arrivalDateDayOfMonth) {
		this.arrivalDateDayOfMonth = arrivalDateDayOfMonth;
	}

	public int getStaysInWeekendNights() {
		return staysInWeekendNights;
	}

	public void setStaysInWeekendNights(int staysInWeekendNights) {
		this.staysInWeekendNights = staysInWeekendNights;
	}

	public int getStaysInWeekNights() {
		return staysInWeekNights;
	}

	public void setStaysInWeekNights(int staysInWeekNights) {
		this.staysInWeekNights = staysInWeekNights;
	}

	public int getAdults() {
		return adults;
	}

	public void setAdults(int adults) {
		this.adults = adults;
	}

	public int getChildren() {
		return children;
	}

	public void setChildren(int children) {
		this.children = children;
	}

	public int getBabies() {
		return babies;
	}

	public void setBabies(int babies) {
		this.babies = babies;
	}

	public String getMeal() {
		return meal;
	}

	public void setMeal(String meal) {
		this.meal = meal;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getMarketSegment() {
		return marketSegment;
	}

	public void setMarketSegment(String marketSegment) {
		this.marketSegment = marketSegment;
	}

	public String getDistributionChannel() {
		return distributionChannel;
	}

	public void setDistributionChannel(String distributionChannel) {
		this.distributionChannel = distributionChannel;
	}

	public boolean isRepeatedGuest() {
		return repeatedGuest;
	}

	public void setRepeatedGuest(boolean repeatedGuest) {
		this.repeatedGuest = repeatedGuest;
	}

	public int getPreviousCancellations() {
		return previousCancellations;
	}

	public void setPreviousCancellations(int previousCancellations) {
		this.previousCancellations = previousCancellations;
	}

	public int getPreviousBookingsNotCanceled() {
		return previousBookingsNotCanceled;
	}

	public void setPreviousBookingsNotCanceled(int previousBookingsNotCanceled) {
		this.previousBookingsNotCanceled = previousBookingsNotCanceled;
	}

	public String getReservedRoomType() {
		return reservedRoomType;
	}

	public void setReservedRoomType(String reservedRoomType) {
		this.reservedRoomType = reservedRoomType;
	}

	public String getAssignedRoomType() {
		return assignedRoomType;
	}

	public void setAssignedRoomType(String assignedRoomType) {
		this.assignedRoomType = assignedRoomType;
	}

	public int getBookingChanges() {
		return bookingChanges;
	}

	public void setBookingChanges(int bookingChanges) {
		this.bookingChanges = bookingChanges;
	}

	public String getDepositType() {
		return depositType;
	}

	public void setDepositType(String depositType) {
		this.depositType = depositType;
	}

	public int getAgent() {
		return agent;
	}

	public void setAgent(int agent) {
		this.agent = agent;
	}

	public int getCompany() {
		return company;
	}

	public void setCompany(int company) {
		this.company = company;
	}

	public int getDaysInWaitingList() {
		return daysInWaitingList;
	}

	public void setDaysInWaitingList(int daysInWaitingList) {
		this.daysInWaitingList = daysInWaitingList;
	}

	public String getCustomerType() {
		return customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}

	public double getAdr() {
		return adr;
	}

	public void setAdr(double adr) {
		this.adr = adr;
	}

	public int getRequiredCarParkingSpaces() {
		return requiredCarParkingSpaces;
	}

	public void setRequiredCarParkingSpaces(int requiredCarParkingSpaces) {
		this.requiredCarParkingSpaces = requiredCarParkingSpaces;
	}

	public int getTotalOfSpecialRequests() {
		return totalOfSpecialRequests;
	}

	public void setTotalOfSpecialRequests(int totalOfSpecialRequests) {
		this.totalOfSpecialRequests = totalOfSpecialRequests;
	}

	public String getReservationStatus() {
		return reservationStatus;
	}

	public void setReservationStatus(String reservationStatus) {
		this.reservationStatus = reservationStatus;
	}

	public LocalDate getReservationStatusDate() {
		return reservationStatusDate;
	}

	public void setReservationStatusDate(LocalDate reservationStatusDate) {
		this.reservationStatusDate = reservationStatusDate;
	}

}
