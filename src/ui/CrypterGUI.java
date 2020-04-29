package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;

public class CrypterGUI {

	// DECRIPT ATTRIBUTES
	@FXML
	private AnchorPane mainPane;

	@FXML
	private AnchorPane consolePane21;

	@FXML
	private RadioButton consoleRadio;

	@FXML
	private ToggleGroup optionText;

	@FXML
	private RadioButton textFileRadio;

	@FXML
	private TextField consoleTextField;

	@FXML
	private AnchorPane textPane21;

	@FXML
	private Button searchFileButton;

	@FXML
	private Label routeShow;

	@FXML
	private ChoiceBox<?> decriptionOptions;

	@FXML
	private TextField keyTextField;

	@FXML
	private RadioButton leftDirection;

	@FXML
	private ToggleGroup direction;

	@FXML
	private RadioButton rightDirection;

	@FXML
	private ProgressBar progressBar;

	@FXML
	private Button decrytptActionButton;

	@FXML
	private Button EncryptWindow;

	@FXML
	private Button routeManagerWindow;

	@FXML
	private Label timeShow;

	// ENCRIPT-WINDOW ATTRIBUTES

	// DECRIPT METHODS
	@FXML
	void clickDecyptAction(ActionEvent event) {

	}

	@FXML
	void clickSearch(ActionEvent event) {

	}

	@FXML
	void consoleChoosen(ActionEvent event) {

	}

	@FXML
	void goToEncrypt(ActionEvent event) {

	}

	@FXML
	void goToRouteManager(ActionEvent event) {

	}

	@FXML
	void textFileChoosen(ActionEvent event) {

	}
}
