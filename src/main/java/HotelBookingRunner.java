
import javafx.geometry.Insets;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HotelBookingRunner extends Application{	
	

		Button Question1;
		Button Question2;
		Button Question3;
		Button Question4;
		Button Question5;
		
		
	public static void main(String[] args) {
		System.out.println("Click the question below you would like to know the answer to:");
		
		launch(args);
		
		HotelBookingReader hbr = new HotelBookingReader();
		List<HotelBooking> hotelBookingList = hbr.readCSVFile("hotel_bookings.csv");

		System.out.println("Number of rows " +hotelBookingList.size());
		DataAnalysis da = new DataAnalysis(hotelBookingList);
		List<HotelBooking> hotelBooking = da.getHotelBooking();
		ArrayList<HotelBooking> canceledRooms = da.isCanceled();
		
		
		da.getAnswer1();
		da.getAnswer2();
		da.getAnswer3(canceledRooms);
		da.getAnswer4(hotelBooking);
		da.getAnswer5(hotelBooking);
		

		//FormattedOutput fo = new FormattedOutput();
	}

	@Override

	public void start(Stage primaryStage) throws Exception {
		Text text = new Text();
		text.setText("Click the question below you would like to know the answer to:");
		text.setX(50);
		text.setY(50);
		
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
		

		
		layout.getChildren().add(text);
		layout.getChildren().add(Question1);
		layout.getChildren().add(Question2);
		layout.getChildren().add(Question3);
		layout.getChildren().add(Question4);
		layout.getChildren().add(Question5);
		
		Scene scene = new Scene(layout, 600, 300);
		primaryStage.setScene(scene);
		primaryStage.show();
		

	}
}
