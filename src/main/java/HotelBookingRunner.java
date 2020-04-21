import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HotelBookingRunner extends Application{	
	
	/**
	 * Variables 
	 */
		Button Question1;
		Button Question2;
		Button Question3;
		Button Question4;
		Button Question5;
		
		
	public static void main(String[] args) {
		
		launch(args);	
	}

	@Override

	public void start(Stage primaryStage) throws Exception {
		
		/**
		 * Writes the text for what the user should do
		 */
		
		Text text = new Text();
		text.setText("Click the question below you would like to know the answer to:");
		text.setX(50);
		text.setY(50);
		
		
		/**
		 * Makes the buttons to push with the question that can be answered
		 */
		
		primaryStage.setTitle("Hotel Booking Information");
		Question1 = new Button();
		Question2 = new Button();
		Question3 = new Button();
		Question4 = new Button();
		Question5 = new Button();
		
		Question1.setText("What is the maximum rate for a non-cancelled resort hotel room in USA over the years?");
		Question2.setText("What is the minimum rate for a non-cancelled resort hotel room in USA over the years?");
		Question3.setText("What percentage of the time are room reservations cancelled?");
		Question4.setText("What is the average number of days stayed?");
		Question5.setText("What is the average lead time for booking a hotel room?");
		
		/**
		 * Sets the location for the buttons
		 */

		Pane layout = new Pane();
		Question1.setTranslateX(50);
		Question1.setTranslateY(80);
		Question2.setTranslateX(50);
		Question2.setTranslateY(110);
		Question3.setTranslateX(50);
		Question3.setTranslateY(140);
		Question4.setTranslateX(50);
		Question4.setTranslateY(170);
		Question5.setTranslateX(50);
		Question5.setTranslateY(200);
		
		
		/**
		 * Action for what happens when the button is pushed
		 */
		
		Question1.setOnAction(event -> {
			
			HotelBookingReader hbr = new HotelBookingReader();
			List<HotelBooking> hotelBookingList = hbr.readCSVFile("hotel_bookings.csv");

			DataAnalysis da = new DataAnalysis(hotelBookingList);
			da.getAnswer1();
		});
		
		Question2.setOnAction(event -> {
			
			HotelBookingReader hbr = new HotelBookingReader();
			List<HotelBooking> hotelBookingList = hbr.readCSVFile("hotel_bookings.csv");

			DataAnalysis da = new DataAnalysis(hotelBookingList);
			da.getAnswer2();
		});
		
		Question3.setOnAction(event -> {
			
			HotelBookingReader hbr = new HotelBookingReader();
			List<HotelBooking> hotelBookingList = hbr.readCSVFile("hotel_bookings.csv");

			DataAnalysis da = new DataAnalysis(hotelBookingList);
			ArrayList<HotelBooking> canceledRooms = da.isCanceled();
			
			da.getAnswer3(canceledRooms);
		});
		
		Question4.setOnAction(event -> {
			
			HotelBookingReader hbr = new HotelBookingReader();
			List<HotelBooking> hotelBookingList = hbr.readCSVFile("hotel_bookings.csv");

			DataAnalysis da = new DataAnalysis(hotelBookingList);
			List<HotelBooking> hotelBooking = da.getHotelBooking();
			
			da.getAnswer4(hotelBooking);
		});
		
		Question5.setOnAction(event -> {
			
			HotelBookingReader hbr = new HotelBookingReader();
			List<HotelBooking> hotelBookingList = hbr.readCSVFile("hotel_bookings.csv");

			DataAnalysis da = new DataAnalysis(hotelBookingList);
			List<HotelBooking> hotelBooking = da.getHotelBooking();
			
			da.getAnswer5(hotelBooking);
		});

		
		/**
		 * Adds the text and buttons
		 */
		
		layout.getChildren().add(text);
		layout.getChildren().add(Question1);
		layout.getChildren().add(Question2);
		layout.getChildren().add(Question3);
		layout.getChildren().add(Question4);
		layout.getChildren().add(Question5);
		
		/**
		 * Creates the Scene
		 */
		
		Scene scene = new Scene(layout, 600, 300);
		primaryStage.setScene(scene);
		primaryStage.show();
		

	}
}
