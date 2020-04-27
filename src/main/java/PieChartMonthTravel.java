
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.stage.Stage;

public class PieChartMonthTravel extends Application {

	
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
			
		// Create a PieChart for booking month using data from file
				ObservableList<PieChart.Data> travelMonthData=FXCollections.observableArrayList(
						new PieChart.Data("January_4.97%", 5929),
						new PieChart.Data("February_6.76%", 8068),
						new PieChart.Data("March_8.20%", 9794),
						new PieChart.Data("April_9.29%", 11089),
						new PieChart.Data("May_9.88%", 11791),
						new PieChart.Data("June_9.16%", 10939),
						new PieChart.Data("July_10.6%", 12661),
						new PieChart.Data("August_11.62%", 13877),
						new PieChart.Data("September_8.8%", 10508),
						new PieChart.Data("October_9.35%", 11160),
						new PieChart.Data("November_5.69%", 6794),
						new PieChart.Data("December_5.68%", 6780)
						);
		
		
		
	
		
		//Create the chart and assign the value to it
	
		PieChart pChartMonth=new PieChart(travelMonthData);
		
	
		//Set the properties of travelMonthBooking data
		Scene scene1=new Scene(pChartMonth, 600, 500);
		
		pChartMonth.setTitle("Hotel Month Booking");
		pChartMonth.setLegendSide(Side.BOTTOM);
		pChartMonth.setLabelsVisible(true);
		pChartMonth.setClockwise(false);
		
		
	
		
		primaryStage.setScene(scene1);
		primaryStage.show();
		

	}
	
	public static void main(String[] args) {
		launch(args);
		
	}

}

