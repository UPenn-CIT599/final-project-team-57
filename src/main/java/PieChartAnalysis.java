import java.security.acl.Group;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.stage.Stage;

public class PieChartAnalysis extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// Create a PieChart using data from file
		ObservableList<PieChart.Data> mealPieData=FXCollections.observableArrayList(
				new PieChart.Data("Bed and Breakfast", 92310),
				new PieChart.Data("Full board", 798),
				new PieChart.Data("Breakfast and dinner", 14463),
				new PieChart.Data("No Meal", 10650),
				new PieChart.Data("Undefined", 1169)
				);
		
		//Create the chart and assign the value to it
		PieChart pChart= new PieChart(mealPieData);
		
		//Set the title of mealPieData
		pChart.setTitle("Hotel Meal Booking");
		
		Scene scene=new Scene(pChart, 600, 400);
		primaryStage.setTitle("Hotel Meal Booking");
		primaryStage.setScene(scene);
		primaryStage.show();
		

	}
	
	public static void main(String[] args) {
		launch(args);
		
	}

}
