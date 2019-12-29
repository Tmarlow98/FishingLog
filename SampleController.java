package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class SampleController {

	@FXML
	public TextField Tide;

	@FXML
	public TextField Time;

	@FXML
	public TextField Location;

	@FXML
	public TextField Wind;

	@FXML
	public TextField FishCaught;

	@FXML
	public TextField Bait;
	
	@FXML
	public TextArea FishLog;

	@FXML
	void saveValue(ActionEvent event) {

		try {

			FileWriter writeTo = new FileWriter("FishingDoc.txt", true);
			BufferedReader readTo = new BufferedReader(new FileReader("FishingDoc.txt"));
			
			writeTo.write("Tide: " + Tide.getText() + ", ");
			writeTo.write("Time: " + Time.getText() + ", ");
			writeTo.write("Location: " + Location.getText() + ", ");
			writeTo.write("Wind: " + Wind.getText() + ", ");
			writeTo.write("Fish caught: " + FishCaught.getText() + ", ");
			writeTo.write("Bait: " + Bait.getText() + ", " + "\n");
			writeTo.close();

			String allText = "";
			StringBuilder sb = new StringBuilder();
		    String line = readTo.readLine();
		    
		    while (line != null) {
		        sb.append(line);
		        sb.append(System.lineSeparator());
		        line = readTo.readLine();
		    }
		    allText = sb.toString();
			
			FishLog.setText(allText);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	void Refresh(ActionEvent event) throws IOException {
		
		@SuppressWarnings("resource")
		BufferedReader readTo = new BufferedReader(new FileReader("FishingDoc.txt"));
		String allText = "";
		StringBuilder sb = new StringBuilder();
	    String line = readTo.readLine();
	    
	    while (line != null) {
	        sb.append(line);
	        sb.append(System.lineSeparator());
	        line = readTo.readLine();
	    }
	    allText = sb.toString();
		
		FishLog.setText(allText);
	}
	
	@FXML
	void seeSnook(ActionEvent event) throws IOException {
		@SuppressWarnings("resource")
		BufferedReader readTo = new BufferedReader(new FileReader("FishingDoc.txt"));
		String allText = "";
		StringBuilder sb = new StringBuilder();
	    String line = readTo.readLine();
	    
	    while (line != null) {
	        sb.append(line);
	        sb.append(System.lineSeparator());
	        line = readTo.readLine();
	        
	        if(line.contains("snook")) {
	        	System.out.println("Found a snook");
	        }
	    }
	    allText = sb.toString();
		
		FishLog.setText(allText);
	}
	
	@FXML
	void seeTarpon() {
		
	}
	
	@FXML
	void seeRedFish() {
		
	}
}