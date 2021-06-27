import javafx.application.Platform;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;





/**
 * This panel is the basic panel, inside which other panels are placed.  
 * Before beginning to implement, design the structure of your GUI in order to 
 * understand what panels go inside which ones, and what buttons or other components
 * go in which panels.  
 * @author ralexander
 *
 */
//make the main panel's layout be a VBox
public class FXMainPane extends VBox {

	//student Task #2:
	//  declare five buttons, a label, and a textfield
	Button Hello, Howdy, Chinese, French, Clear, Exit;
	Label Feedback;
	TextField textField;
	//  declare two HBoxes
	HBox hbox1, hbox2;
	//student Task #4:
	//  declare an instance of DataManager
	/**
	 * The MainPanel constructor sets up the entire GUI in this approach.  Remember to
	 * wait to add a component to its containing component until the container has
	 * been created.  This is the only constraint on the order in which the following 
	 * statements appear.
	 */
	FXMainPane() {
		//student Task #2:
		//  instantiate the buttons, label, and textfield
		Hello = new Button("Hello");
		Howdy = new Button("Howdy");
		Chinese = new Button("Chinese");
		French = new Button("French");
		Clear = new Button("Clear");
		Exit = new Button("Exit");
		Feedback = new Label("Feedback:");
		textField = new TextField();
		//  instantiate the HBoxes
		hbox1 = new HBox();
		hbox2 = new HBox();
		final int marTop = 45; 
		final int magBottom = 3;
		final int marLeft = 5;
		final int marRight = 5;
		
		//student Task #4:
		//  instantiate the DataManager instance
		DataManager datamanager = new DataManager();
		//  set margins and set alignment of the components
		HBox.setMargin(Feedback, new Insets(marTop, magBottom, marLeft, marRight));
		HBox.setMargin(textField, new Insets(marTop, magBottom, marLeft, marRight));
		HBox.setMargin(Hello, new Insets(marTop, magBottom, marLeft, marRight));
		HBox.setMargin(Howdy, new Insets(marTop, magBottom, marLeft, marRight));
		HBox.setMargin(Chinese, new Insets(marTop, magBottom, marLeft, marRight));
		HBox.setMargin(French, new Insets(marTop, magBottom, marLeft, marRight));
		HBox.setMargin(Clear, new Insets(marTop, magBottom, marLeft, marRight));
		HBox.setMargin(Exit, new Insets(marTop, magBottom, marLeft, marRight));
		hbox1.setAlignment(Pos.CENTER); 
		hbox2.setAlignment(Pos.CENTER); 
		//this.setMargin(hbox1, new Insets(20, 2, 5, 5)); 

		
		//student Task #3:
		//  add the label and textfield to one of the HBoxes
		hbox1.getChildren().addAll(Feedback, textField);
		//  add the buttons to the other HBox
		hbox2.getChildren().addAll(Hello, Howdy, Chinese, French, Clear, Exit);
		//  add the HBoxes to this FXMainPanel (a VBox)
		this.getChildren().addAll(hbox1, hbox2);
		

		//Task #4:
		//  create a private inner class to handle the button clicks
		Hello.setOnAction(new EventHandler<ActionEvent>() {
	        @Override
	        public void handle(ActionEvent event) {
	        	textField.setText(datamanager.getHello());
	        }
	    });
		Howdy.setOnAction(new EventHandler<ActionEvent>() {
	        @Override
	        public void handle(ActionEvent event) {
	        	textField.setText(datamanager.getHowdy());
	        }
	    });
		Chinese.setOnAction(new EventHandler<ActionEvent>() {
	        @Override
	        public void handle(ActionEvent event) {
	        	textField.setText(datamanager.getChinese());
	        }
	    });
		French.setOnAction(new EventHandler<ActionEvent>() {
	        @Override
	        public void handle(ActionEvent event) {
	        	textField.setText(datamanager.getFrench());
	        }
	    });
		Clear.setOnAction(new EventHandler<ActionEvent>() {
	        @Override
	        public void handle(ActionEvent event) {
	        	textField.setText("");
	        }
	    });
		Exit.setOnAction(new EventHandler<ActionEvent>() {
	        @Override
	        public void handle(ActionEvent event) {
	        	Platform.exit();
	        	System.exit(0);
	        }
	    });

	}
	
	/*
	Hello.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent e) {
        	//Hello.setEffect(shadow);
        }
    });*/

}
	