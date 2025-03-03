import javafx.application.Platform;
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
    // Declare components
    private Button btnHello, btnHowdy, btnChinese, btnClear, btnExit;
    private Label lblFeedback;
    private TextField txtFeedback;
    private HBox hBoxButtons, hBoxFeedback;
    private DataManager dataManager;

    public FXMainPane() {
        // Instantiate DataManager
        dataManager = new DataManager();

        // Instantiate buttons
        btnHello = new Button("Hello");
        btnHowdy = new Button("Howdy");
        btnChinese = new Button("Chinese");
        btnClear = new Button("Clear");
        btnExit = new Button("Exit");

        // Instantiate label and text field
        lblFeedback = new Label("Feedback:");
        txtFeedback = new TextField();
        txtFeedback.setEditable(false); // Make the text field read-only

        // Instantiate HBox containers
        hBoxButtons = new HBox(10); // Spacing between buttons
        hBoxFeedback = new HBox(10); // Spacing between label and text field

        // Add buttons to the first HBox
        hBoxButtons.getChildren().addAll(btnHello, btnHowdy, btnChinese, btnClear, btnExit);

        // Add label and text field to the second HBox
        hBoxFeedback.getChildren().addAll(lblFeedback, txtFeedback);

        // Add HBoxes to the VBox (FXMainPane)
        this.getChildren().addAll(hBoxButtons, hBoxFeedback);

        // Set margins for buttons
        Insets inset = new Insets(10);
        HBox.setMargin(btnHello, inset);
        HBox.setMargin(btnHowdy, inset);
        HBox.setMargin(btnChinese, inset);
        HBox.setMargin(btnClear, inset);
        HBox.setMargin(btnExit, inset);

        // Center HBoxes
        hBoxButtons.setAlignment(Pos.CENTER);
        hBoxFeedback.setAlignment(Pos.CENTER);

        // Set event handlers for buttons
        ButtonHandler handler = new ButtonHandler();
        btnHello.setOnAction(handler);
        btnHowdy.setOnAction(handler);
        btnChinese.setOnAction(handler);
        btnClear.setOnAction(handler);
        btnExit.setOnAction(handler);
    }

    // Inner class for button event handling
    private class ButtonHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            if (event.getSource() == btnHello) {
                txtFeedback.setText(dataManager.getHello());
            } else if (event.getSource() == btnHowdy) {
                txtFeedback.setText(dataManager.getHowdy());
            } else if (event.getSource() == btnChinese) {
                txtFeedback.setText(dataManager.getChinese());
            } else if (event.getSource() == btnClear) {
                txtFeedback.setText("");
            } else if (event.getSource() == btnExit) {
                Platform.exit();
                System.exit(0);
            }
        }
    }
}