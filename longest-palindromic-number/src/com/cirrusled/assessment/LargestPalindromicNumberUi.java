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
 * The program provides a User Interface where the user can find the largest
 * palindromic number within the given input range.
 * 
 * @author vhineshravi
 *
 */
public class LargestPalindromicNumberUi extends Application {
	Stage window;
	long minValue, maxValue;

	/**
	 * The main function
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);

	}

	/**
	 * Function to setup the grid layout's properties
	 * 
	 * @param grid
	 *            the grid object argument
	 * @return grid object
	 */
	public GridPane setUpGrid(GridPane grid) {
		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setVgap(15);
		grid.setHgap(10);
		return grid;
	}

	/**
	 * The function creates the label widget.
	 * 
	 * @param widgetName
	 *            Name of the label widget
	 * @param grid
	 *            the grid layout object
	 * @param col
	 *            column position
	 * @param row
	 *            row position
	 * @return label created
	 */
	public Label createLabelWidget(String widgetName, GridPane grid, int col,
			int row) {
		Label label = new Label(widgetName);
		grid.setConstraints(label, col, row); //positioning the label widget in layout.
		return label;
	}

	/**
	 * The function creates the text widget.
	 * 
	 * @param grid
	 *            the grid layout object
	 * @param col
	 *            column position
	 * @param row
	 *            row position
	 * @return textfield created
	 */
	public TextField createTextWidget(GridPane grid, int col, int row) {
		TextField text = new TextField();
		grid.setConstraints(text, col, row); //positioning the text widget in layout.
		return text;
	}

	/**
	 * The function creates button widget.
	 * 
	 * @param widgetName
	 *            Name of button the
	 * @param grid
	 *            the grid object
	 * @param col
	 *            column position
	 * @param row
	 *            row position
	 * @return
	 */
	public Button createButtonWidget(String widgetName, GridPane grid, int col,
			int row) {
		Button findButton = new Button(widgetName);
		grid.setConstraints(findButton, col, row); //positioning the button widget in layout.
		return findButton;
	}

	/**
	 * The function adds individual elements to grid layout.
	 * 
	 * @param nodes
	 *            The List to store the individual objects.
	 * @param grid
	 *            The grid object
	 * @return The List with UI components
	 */
	public List<Node> addElementsToGrid(List<Node> nodes, GridPane grid) {
		//Creating label widget
		Label lowerLimitLabel = createLabelWidget("Lower Bound", grid, 0, 0);
		nodes.add(lowerLimitLabel);
		
		//creating textbox widget
		TextField minValueInput = createTextWidget(grid, 1, 0);
		nodes.add(minValueInput);
		
		//Creating label widget
		Label upperLimitLabel = createLabelWidget("Upper Bound", grid, 0, 1);
		nodes.add(upperLimitLabel);
		
		//creating textbox widget
		TextField maxValueInput = createTextWidget(grid, 1, 1);
		nodes.add(maxValueInput);
		
		//Creating label widget
		Label answerLabel = createLabelWidget("Answer", grid, 0, 2);
		nodes.add(answerLabel);
		
		//creating textbox widget
		TextField answerInput = createTextWidget(grid, 1, 2);
		nodes.add(answerInput);
		
		//creating button widget
		Button findButton = createButtonWidget("Search", grid, 1, 3);
		nodes.add(findButton);

		return nodes;
	}

	/**
	 * This function validates the input ranges.
	 * 
	 * @param minValueInput
	 *            lower bound value.
	 * @param maxValueInput
	 *            higher bound value.
	 * @return boolean indicating if range is valid.
	 */
	public boolean validateInputs(TextField minValueInput,
			TextField maxValueInput) {
		int check = 0;
		
		//Validating the lower bound value entered
		try {
			minValueInput.setStyle(null);
			double min = Double.parseDouble(minValueInput.getText());
			minValue = (long) min;
			minValueInput.setText(minValue + "");
		} catch (NumberFormatException nfe) {
			minValueInput.setStyle("-fx-border-color:red");
			check = 1;
		}
		
		//Validating the upper bound value entered
		try {
			maxValueInput.setStyle(null);
			double max = Double.parseDouble(maxValueInput.getText());
			maxValue = (long) max;
			maxValueInput.setText(maxValue + "");
		} catch (NumberFormatException nfe) {
			maxValueInput.setStyle("-fx-border-color:red");
			check = 1;
		}
		
		/*if upper bound value entered is less than lower bound value
		then swap upper and lower bound values*/ 
		if (maxValue < minValue) {
			minValueInput.setText(maxValue + "");
			maxValueInput.setText(minValue + "");
			long temp = maxValue;
			maxValue = minValue;
			minValue = temp;

		}
		if (check == 1) {
			return false;
		}
		return true;
	}

	/**
	 * This function safely close the program
	 */
	private void closeProgram() {
		Boolean answer = ConfirmBox.display(
				"Largest-Palindromic-Number-Finder", "Sure you want to close?");
		if (answer) {
			window.close(); //closing the window
		}
	}
	/**
	 * The function finds the largest palindromic number by using the 
	 * LargestPalindromicSearch service.
	 * @return the largest palindromic number
	 */
	public String searchLongestPalindromicNumber() {
		LargestPalindromeSearch lp = new LargestPalindromeSearch(minValue,
				maxValue);
		return (lp.searchPalindrome());
	}

	/**
	 * The controller function
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage; // Stage variable
		// setting title of UI
		window.setTitle("Largest-Palindromic-Number-Finder"); 
		// handling close event
		window.setOnCloseRequest(closeEvent -> {
			closeEvent.consume();
			closeProgram();
		});

		List<Node> nodes = new ArrayList<Node>(); // list to hold UI components

		GridPane grid = new GridPane(); // grid layout

		grid = setUpGrid(grid);

		nodes = addElementsToGrid(nodes, grid);
		
		// Input value extraction from UI and validation 
		try {
			Button findButton = (Button) nodes.get(6);
			TextField minValueInput = (TextField) nodes.get(1);
			TextField maxValueInput = (TextField) nodes.get(3);
			TextField Answer = (TextField) nodes.get(5);
			findButton.setOnAction(clickEvent -> {
				if (validateInputs(minValueInput, maxValueInput)) {
					Answer.setText("");
					Answer.setText(searchLongestPalindromicNumber());
				} else {
					Answer.setText("Invalid Input Range");
				}
			});
		} catch (ClassCastException except) {
			System.out.println("incorrect type casting");
		}
		// adding the UI components to the grid layout.
		grid.getChildren().addAll(nodes); 
		
		// setting dimensions of UI window
		Scene scene = new Scene(grid, 350, 200); 
		
		window.setScene(scene);// hosting scene on stage
		window.show();// displaying the UI.

	}

}
