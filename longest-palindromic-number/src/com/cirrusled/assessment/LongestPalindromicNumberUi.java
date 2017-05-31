package com.cirrusled.assessment;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Scene;
public class LongestPalindromicNumberUi extends Application
{
	Stage window;
	
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
	 * The controller function
	 */
	@Override
	public void start(Stage primaryStage) throws Exception 
	{
		window = primaryStage; //Stage variable
		window.setTitle("Largest-Palindromic-Number-Finder"); //setting title of UI
		
		List<Node> nodes = new ArrayList<Node>(); //list to hold UI components
		
		GridPane grid = new GridPane(); //grid layout
		
		grid = setUpGrid(grid);
		
		nodes = addElementsToGrid(nodes, grid);
		
		grid.getChildren().addAll(nodes); //adding the UI components to the grid layout.
		
		Scene scene = new Scene(grid, 350, 200); //setting dimensions of UI window
		window.setScene(scene);//hosting scene on stage 
		window.show();// displaying the UI.
		
	}


}
