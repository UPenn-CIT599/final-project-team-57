import java.util.List;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
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
		Button Question7;
		Button Question8;
		Button Question9;
		Button Question10;
		
		
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
		
		Text textEnding	= new Text();
		textEnding.setText("");
		textEnding.setX(50);
		textEnding.setY(1100);
		

				
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
		Question7 = new Button();
		Question8 = new Button();
		Question9 = new Button();
		Question10 = new Button();
		
		Question1.setText("What is the maximum rate for a non-cancelled resort hotel room in USA over the years?");
		Question2.setText("What is the minimum rate for a non-cancelled resort hotel room in USA over the years?");
		Question3.setText("What percentage of the time are room reservations cancelled?");
		Question4.setText("What is the average number of days stayed?");
		Question5.setText("What is the average lead time for booking a hotel room?");
		Question6.setText("What is the busiest and least busiest time to book a hotel room?");
		Question7.setText("What is the average number of people per room?");
		Question8.setText("What is the average number of adults per room?");
		Question9.setText("What is the average number of children per room?");
		Question10.setText("What is the average number of babies per room?");
		
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
		Question7.setTranslateX(50);
		Question7.setTranslateY(700);
		Question8.setTranslateX(50);
		Question8.setTranslateY(800);
		Question9.setTranslateX(50);
		Question9.setTranslateY(900);
		Question10.setTranslateX(50);
		Question10.setTranslateY(1000);
		
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
		
		Question7.setOnAction(event -> {
			
			HotelBookingReader hbr = new HotelBookingReader();
			List<HotelBooking> hotelBookingList = hbr.readCSVFile("hotel_bookings.csv");
			DataAnalysis da = new DataAnalysis(hotelBookingList);
			
			String toStringAnswer7 = String.valueOf(da.getAnswer7(hotelBookingList, "person"));
			Text answer7 = new Text();
			answer7.setText("The average person per room is " + toStringAnswer7);
			answer7.setTranslateX(50);
			answer7.setTranslateY(750);
			layout.getChildren().add(answer7);
		});
		
		Question8.setOnAction(event -> {
			
			HotelBookingReader hbr = new HotelBookingReader();
			List<HotelBooking> hotelBookingList = hbr.readCSVFile("hotel_bookings.csv");
			DataAnalysis da = new DataAnalysis(hotelBookingList);
			
			String toStringAnswer8 = String.valueOf(da.getAnswer7(hotelBookingList, "adult"));
			Text answer8 = new Text();
			answer8.setText("The average adult per room is " + toStringAnswer8);
			answer8.setTranslateX(50);
			answer8.setTranslateY(850);
			layout.getChildren().add(answer8);
		});
		Question9.setOnAction(event -> {
			
			HotelBookingReader hbr = new HotelBookingReader();
			List<HotelBooking> hotelBookingList = hbr.readCSVFile("hotel_bookings.csv");
			DataAnalysis da = new DataAnalysis(hotelBookingList);
			
			String toStringAnswer9 = String.valueOf(da.getAnswer7(hotelBookingList, "children"));
			Text answer9 = new Text();
			answer9.setText("The average child per room is " + toStringAnswer9);
			answer9.setTranslateX(50);
			answer9.setTranslateY(950);
			layout.getChildren().add(answer9);
		});
		
		Question10.setOnAction(event -> {
			
			HotelBookingReader hbr = new HotelBookingReader();
			List<HotelBooking> hotelBookingList = hbr.readCSVFile("hotel_bookings.csv");
			DataAnalysis da = new DataAnalysis(hotelBookingList);
			
			String toStringAnswer10 = String.valueOf(da.getAnswer7(hotelBookingList, "babies"));
			Text answer10 = new Text();
			answer10.setText("The average baby per room is " + toStringAnswer10);
			answer10.setTranslateX(50);
			answer10.setTranslateY(1050);
			layout.getChildren().add(answer10);
		});
		
		/**
		 * Adds scroll bar
		 */
        
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(layout);
        scrollPane.setPrefSize(1000, 1000);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);

	        
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
		layout.getChildren().add(Question7);
		layout.getChildren().add(Question8);
		layout.getChildren().add(Question9);
		layout.getChildren().add(Question10);
		layout.getChildren().add(textEnding);
		
		
		/**
		 * Creates the Scene
		 */ 
	        
		Scene scene = new Scene(scrollPane, 900, 900);
		primaryStage.setScene(scene);
		
	        
		primaryStage.show();
	}

}
