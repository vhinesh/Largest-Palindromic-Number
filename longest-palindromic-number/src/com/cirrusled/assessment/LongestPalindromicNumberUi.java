package com.cirrusled.assessment;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.geometry.Insets;
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
	 * The function adds individual elements to grid layout.
	 * 
	 * @param nodes The List to store the individual objects.
	 * @param grid The grid object 
	 * @return The List with UI components
	 */
	public List<Node> addElementsToGrid(List<Node> nodes, GridPane grid)
	{
	
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
