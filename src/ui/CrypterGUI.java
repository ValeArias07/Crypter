package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
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
	@FXML
	private AnchorPane mainPaneEncrypt;

	@FXML
	private AnchorPane consolePane21Encript;

	@FXML
	private RadioButton consoleRadioEncrypt;

	@FXML
	private ToggleGroup optionTextEncript;

	@FXML
	private RadioButton textFileRadioEncrypt;

	@FXML
	private TextField consoleTextFieldEncrypt;

	@FXML
	private AnchorPane textPane21Encrypt;

	@FXML
	private Button searchFileButtonModi;

	@FXML
	private Label routeShowModi;

	@FXML
	private ChoiceBox<?> encriptionOptionsEncrypt;

	@FXML
	private TextField keyTextFieldEncrypt;

	@FXML
	private RadioButton leftDirectionEncrypt;

	@FXML
	private ToggleGroup directionEncrypt;

	@FXML
	private RadioButton rightDirectionEncrypt;

	@FXML
	private ProgressBar progressBarEncrypt;

	@FXML
	private Button encrytptActionButtonEncrypt;

	@FXML
	private Button decryptWindowEncrypt;

	@FXML
	private Button routeManagerWindowEncrypt;

	@FXML
	private Label timeShowEncrypt;

	// ROUTE-MANAGER ATTRIBUTES
	@FXML
	private AnchorPane mainPaneRoute;

	@FXML
	private ListView<?> encryptedList;

	@FXML
	private ListView<?> decryptedList;

	@FXML
	private Button showButton;

	@FXML
	private Button deleteButton;

	@FXML
	private MenuItem addFileOption;

	@FXML
	private MenuItem aboutOptionRM;

	@FXML
	private Button encryptButton;

	@FXML
	private Button decryptButton;

	// SHOW-FILES ATTRIBUTES
	@FXML
	private TextArea textArea;

	@FXML
	private MenuItem aboutOptionSF;

	@FXML
	private ChoiceBox<?> fontChoice;

	@FXML
	private ChoiceBox<?> heightChoice;

	@FXML
	private Button negritaButton;

	@FXML
	private Button cursiveButton;

	@FXML
	private Button subButton;

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

	// ENCRIPT-WINDOW METHODS
	@FXML
	void clickEncryptActionEncrypt(ActionEvent event) {

	}

	@FXML
	void clickSearchEncrypt(ActionEvent event) {

	}

	@FXML
	void consoleChoosenEncrypt(ActionEvent event) {

	}

	@FXML
	void goToDecryptEncrypt(ActionEvent event) {

	}

	@FXML
	void goToRouteManagerEncrypt(ActionEvent event) {

	}

	@FXML
	void textFileChoosenEncrypt(ActionEvent event) {

	}

	// ROUTE-MANAGER METHODS
	@FXML
	void aboutRouteManager(ActionEvent event) {

	}

	@FXML
	void addFile(ActionEvent event) {

	}

	@FXML
	void deleteFile(ActionEvent event) {

	}

	@FXML
	void goToDecrypt(ActionEvent event) {

	}

	@FXML
	void goToEncrypt_RM(ActionEvent event) {

	}

	@FXML
	void showFile(ActionEvent event) {

	}

	// SHOW-FILES METHODS
	@FXML
	void aboutShowFile(ActionEvent event) {

	}

	@FXML
	void cursiveOption(ActionEvent event) {

	}

	@FXML
	void fontOptions(MouseEvent event) {

	}

	@FXML
	void heightOption(MouseEvent event) {

	}

	@FXML
	void negritaOption(ActionEvent event) {

	}

	@FXML
	void subOption(ActionEvent event) {

	}
}
