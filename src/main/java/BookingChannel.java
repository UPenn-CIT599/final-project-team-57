
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.stage.Stage;

public class BookingChannel extends Application {

	
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		// Create a PieChart for meal booking using data from file
		ObservableList<PieChart.Data> channelPieChart=FXCollections.observableArrayList(
				new PieChart.Data("Travel Agents&Tour Operators_81.98%", 97870),
				new PieChart.Data("Direct Booking_12.27%", 14645),
				new PieChart.Data("Corporate Booking_5.59%", 6677),
				new PieChart.Data("Global Distribution System(GDS)_0.16%", 193)
				);
		
		

		
	
		
		//Create the chart and assign the value to it
		PieChart pChart= new PieChart(channelPieChart);
		
		
		//Set the properties of channelBooking chart
			
	
		Scene scene=new Scene(pChart, 800, 700);
		
		
		pChart.setTitle("Hotel Booking Channel");
		pChart.setLegendSide(Side.BOTTOM);
		pChart.setLabelsVisible(true);
		pChart.setClockwise(false);
		
	
		
		
		primaryStage.setScene(scene);
		primaryStage.show();
		
	
		

	}
	
	public static void main(String[] args) {
		launch(args);
		
	}

}
