
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.stage.Stage;

public class PieChartMeal extends Application {

	
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		// Create a PieChart for meal booking using data from file
		ObservableList<PieChart.Data> mealPieData=FXCollections.observableArrayList(
				new PieChart.Data("Bed and Breakfast_77.32%", 92310),
				new PieChart.Data("Full board_0.67%", 798),
				new PieChart.Data("Breakfast and dinner_12.11%", 14463),
				new PieChart.Data("No Meal_8.92%", 10650),
				new PieChart.Data("Undefined_0.98%", 1169)
				);
		
		

		
	
		
		//Create the chart and assign the value to it
		PieChart pChart= new PieChart(mealPieData);
		
		
		//Set the properties of mealPieData
			
	
		Scene scene=new Scene(pChart, 600, 500);
		
		
		pChart.setTitle("Hotel Meal Booking");
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
