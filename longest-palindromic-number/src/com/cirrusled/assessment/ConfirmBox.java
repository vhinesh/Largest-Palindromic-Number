package com.cirrusled.assessment;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
/**
 * The program implements a confirm box window
 * @author vhineshravi
 *
 */
public class ConfirmBox 
{
	static boolean answer;
	/**
	 * The function creates a confirm dialog box.
	 * @param title title of the box
	 * @param message message to be shown
	 * @return user response
	 */
	public static boolean display(String title, String message)
	{
		Stage window = new Stage(); //Stage Variable
		window.initModality(Modality.APPLICATION_MODAL); //Making the user deal with current window
		window.setTitle(title); //Setting title of window
		window.setWidth(250);
		window.setHeight(250);
		Label label = new Label();
		label.setText(message);
		
		Button yesButton =  new Button("Yes");
		Button noButton =  new Button("No");
		//Capturing user input
		yesButton.setOnAction(clickEvent ->{
			answer = true;
			window.close();
		});
		
		noButton.setOnAction(clickEvent ->{
			answer = false;
			window.close();
		});
		
		VBox layout = new VBox(10);
		layout.getChildren().addAll(label,yesButton,noButton);
		layout.setAlignment(Pos.CENTER);
		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.showAndWait();
		
		return answer;
	}
}
