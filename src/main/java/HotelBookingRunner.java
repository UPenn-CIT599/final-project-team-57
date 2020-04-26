import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBase;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
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
		Button Question6;
		
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
		Question6 = new Button();
		
		Question1.setText("What is the maximum rate for a non-cancelled resort hotel room in USA over the years?");
		Question2.setText("What is the minimum rate for a non-cancelled resort hotel room in USA over the years?");
		Question3.setText("What percentage of the time are room reservations cancelled?");
		Question4.setText("What is the average number of days stayed?");
		Question5.setText("What is the average lead time for booking a hotel room?");
		Question6.setText("What is the busiest and least busiest time to book a hotel room?");
		
		
		
		/**
		 * Sets the location for the buttons
		 */

		Pane layout = new Pane();
		Question1.setTranslateX(50);
		Question1.setTranslateY(100);
		Question2.setTranslateX(50);
		Question2.setTranslateY(200);
		Question3.setTranslateX(50);
		Question3.setTranslateY(300);
		Question4.setTranslateX(50);
		Question4.setTranslateY(400);
		Question5.setTranslateX(50);
		Question5.setTranslateY(500);
		Question6.setTranslateX(50);
		Question6.setTranslateY(600);
		
		/**
		 * Action for what happens when the button is pushed
		 */
		
		
		Question1.setOnAction(event -> {
			
			HotelBookingReader hbr = new HotelBookingReader();
			List<HotelBooking> hotelBookingList = hbr.readCSVFile("hotel_bookings.csv");
			DataAnalysis da = new DataAnalysis(hotelBookingList);
		
			
			String toStringAnswer1 = String.valueOf(da.getAnswer1());
			Text answer1 = new Text();
			answer1.setText("Maximum rate = $" + toStringAnswer1);
			answer1.setTranslateX(50);
			answer1.setTranslateY(150);
			layout.getChildren().add(answer1);

		});
		
		Question2.setOnAction(event -> {
			
			HotelBookingReader hbr = new HotelBookingReader();
			List<HotelBooking> hotelBookingList = hbr.readCSVFile("hotel_bookings.csv");

			DataAnalysis da = new DataAnalysis(hotelBookingList);

			String toStringAnswer2 = String.valueOf(da.getAnswer2());
			Text answer2 = new Text();
			answer2.setText("Minimum rate = $" + toStringAnswer2);
			answer2.setTranslateX(50);
			answer2.setTranslateY(250);
			layout.getChildren().add(answer2);
		});
		
		Question3.setOnAction(event -> {
			
			HotelBookingReader hbr = new HotelBookingReader();
			List<HotelBooking> hotelBookingList = hbr.readCSVFile("hotel_bookings.csv");
			DataAnalysis da = new DataAnalysis(hotelBookingList);
			List<HotelBooking> canceledRooms = da.getHotelBooking();
			
			String toStringAnswer3 = String.valueOf(da.getAnswer3(canceledRooms));
			Text answer3 = new Text();
			answer3.setText("Percentage of rooms canceled = " + toStringAnswer3 + "%");
			answer3.setTranslateX(50);
			answer3.setTranslateY(350);
			layout.getChildren().add(answer3);
		});
		
		Question4.setOnAction(event -> {
			
			HotelBookingReader hbr = new HotelBookingReader();
			List<HotelBooking> hotelBookingList = hbr.readCSVFile("hotel_bookings.csv");

			DataAnalysis da = new DataAnalysis(hotelBookingList);
			List<HotelBooking> hotelBooking = da.getHotelBooking();
			
			String toStringAnswer4 = String.valueOf(da.getAnswer4(hotelBooking));
			Text answer4 = new Text();
			answer4.setText("The average number of days stayed at a hotel = " + toStringAnswer4);
			answer4.setTranslateX(50);
			answer4.setTranslateY(450);
			layout.getChildren().add(answer4);
		});
		
		Question5.setOnAction(event -> {
			
			HotelBookingReader hbr = new HotelBookingReader();
			List<HotelBooking> hotelBookingList = hbr.readCSVFile("hotel_bookings.csv");
			DataAnalysis da = new DataAnalysis(hotelBookingList);
			List<HotelBooking> hotelBooking = da.getHotelBooking();
			
			String toStringAnswer5 = String.valueOf(da.getAnswer5(hotelBooking));
			Text answer5 = new Text();
			answer5.setText("The average days of lead time for booking a hotel room = " + toStringAnswer5);
			answer5.setTranslateX(50);
			answer5.setTranslateY(550);
			layout.getChildren().add(answer5);
		});
		
		Question6.setOnAction(event -> {
			
			HotelBookingReader hbr = new HotelBookingReader();
			List<HotelBooking> hotelBookingList = hbr.readCSVFile("hotel_bookings.csv");
			DataAnalysis da = new DataAnalysis(hotelBookingList);
			
			String toStringAnswer6 = String.valueOf(da.getAnswer6());
			Text answer6 = new Text();
			answer6.setText(toStringAnswer6);
			answer6.setTranslateX(50);
			answer6.setTranslateY(650);
			layout.getChildren().add(answer6);
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
		layout.getChildren().add(Question6);
		
		
		/**
		 * Creates the Scene
		 */
		
		Scene scene = new Scene(layout, 750, 700);
		primaryStage.setScene(scene);
		primaryStage.show();
		

	}

}
