package com.cirrusled.assessment;

import java.util.ArrayList;
import java.util.List;

import javax.security.auth.callback.ConfirmationCallback;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Scene;

/**
 * The program provides a User Interface where the user can find the
 * largest palindromic number within the given input range.
 * @author vhineshravi
 *
 */
public class LongestPalindromicNumberUi extends Application
{
	Stage window;
	long minValue, maxValue;
	/**
	 * The main function
	 * @param args
	 */
	public static void main(String[] args) 
	{
		launch(args);

	}
	
	/**
	 * Function to setup the grid layout's properties
	 * 
	 * @param grid the grid object argument
	 * @return grid object
	 */
	public GridPane setUpGrid(GridPane grid)
	{
		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setVgap(15);
		grid.setHgap(10);
		return grid;
	}
	
	/**
	 * The function creates the label widget.
	 * 
	 * @param widgetName Name of the label widget
	 * @param grid the grid layout object
	 * @param col column position
	 * @param row row position
	 * @return label created
	 */
	public Label createLabelWidget(String widgetName,GridPane grid, int col, int row)
	{
		Label label = new Label(widgetName);
		grid.setConstraints(label, col, row);
		return label;
	}
	
	/**
	 * The function creates the text widget.
	 * 
	 * @param grid the grid layout object
	 * @param col column position
	 * @param row row position
	 * @return textfield created
	 */
	public TextField createTextWidget(GridPane grid, int col, int row)
	{
		TextField text = new TextField();
		grid.setConstraints(text, col, row);
		return text;
	}
	
	/**
	 * The function creates button widget.
	 * 
	 * @param widgetName Name of button the 
	 * @param grid the grid object
	 * @param col column position
	 * @param row row position
	 * @return
	 */
	public Button createButtonWidget(String widgetName,GridPane grid, int col, int row)
	{
		Button findButton = new Button(widgetName);
		grid.setConstraints(findButton, col, row);
		return findButton;
	}
	
	/**
	 * The function adds individual elements to grid layout.
	 * 
	 * @param nodes The List to store the individual objects.
	 * @param grid The grid object 
	 * @return The List with UI components
	 */
	public List<Node> addElementsToGrid(List<Node> nodes, GridPane grid)
	{
		Label lowerLimitLabel = createLabelWidget("Lower Bound", grid, 0, 0);
		nodes.add(lowerLimitLabel);
		
		TextField minValueInput = createTextWidget(grid,1,0);
		nodes.add(minValueInput);
		
		Label upperLimitLabel = createLabelWidget("Upper Bound", grid, 0, 1);
		nodes.add(upperLimitLabel);
		
		TextField maxValueInput = createTextWidget(grid,1,1);
		nodes.add(maxValueInput);
		
		Label answerLabel = createLabelWidget("Answer", grid, 0, 2);
		nodes.add(answerLabel);
		
		TextField answerInput = createTextWidget(grid,1,2);
		nodes.add(answerInput);
		
		Button findButton = createButtonWidget("Search", grid, 1, 3);
		nodes.add(findButton);
		
		return nodes;
	}
	/**
	 * This function validates the input ranges.
	 * @param minValueInput lower bound value.
	 * @param maxValueInput higher bound value.
	 * @return boolean indicating if range is valid.
	 */
	public boolean validateInputs(TextField minValueInput,TextField maxValueInput )
	{
		boolean answer;
		
		try
		{
			minValueInput.setStyle(null);
			double min= Double.parseDouble(minValueInput.getText());
			minValue = (long) min;
			minValueInput.setText(minValue+"");
		}
		catch(NumberFormatException nfe)
		{
			minValueInput.setStyle("-fx-border-color:red");
			return false;
		}
		
		try
		{
			maxValueInput.setStyle(null);
			double max= Double.parseDouble(maxValueInput.getText());
			maxValue = (long) max;
			maxValueInput.setText(maxValue+"");
		}
		catch(NumberFormatException nfe)
		{
			maxValueInput.setStyle("-fx-border-color:red");
			return false;
		}
		
		if(maxValue<minValue)
		{
			minValueInput.setText(maxValue+"");
			maxValueInput.setText(minValue+"");

		}
		
		return true;
	}
	
	/**
	 * This function safely close the program
	 */
	private void closeProgram()
	{
		Boolean answer = ConfirmBox.display("Largest-Palindromic-Number-Finder",
				"Sure you want to close?");
		if(answer)
		{
			window.close();
		}
	}
	
	/**
	 * The controller function
	 */
	@Override
	public void start(Stage primaryStage) throws Exception 
	{
		window = primaryStage; //Stage variable
		window.setTitle("Largest-Palindromic-Number-Finder"); //setting title of UI
		//handling close event
		window.setOnCloseRequest(closeEvent -> {
			closeEvent.consume();
			closeProgram();
		});
		
		List<Node> nodes = new ArrayList<Node>(); //list to hold UI components
		
		GridPane grid = new GridPane(); //grid layout
		
		grid = setUpGrid(grid);
		
		nodes = addElementsToGrid(nodes, grid);
		
		try
		{
		Button findButton = (Button) nodes.get(6);
		TextField minValueInput = (TextField) nodes.get(1);
		TextField maxValueInput = (TextField) nodes.get(3);
		TextField Answer = (TextField) nodes.get(5);
		findButton.setOnAction( clickEvent -> 
		{
			if(validateInputs(minValueInput,maxValueInput))
			{
				Answer.setText("");
				
				
			}
			else
			{
				Answer.setText("Invalid Input Range");
			}
		}) ;
		}
		catch(ClassCastException except)
		{
			System.out.println("incorrect button cast");
		}
		
		grid.getChildren().addAll(nodes); //adding the UI components to the grid layout.
		
		Scene scene = new Scene(grid, 350, 200); //setting dimensions of UI window
		window.setScene(scene);//hosting scene on stage 
		window.show();// displaying the UI.
		
	}


}
