package ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;

public class CrypterGUI {
	// WELCOME ATTRIBUTES
	@FXML
	private BorderPane borderPaneMain;

	@FXML
	private Menu settingsMenu;

	@FXML
	private Menu encryptSubMenu;

	@FXML
	private ToggleGroup textInputToggleEncrypt;

	@FXML
	private ToggleGroup encryptedToggle;

	@FXML
	private Menu decryptSubMenu;

	@FXML
	private ToggleGroup textInputToggleDecrypt;

	@FXML
	private ToggleGroup decryptedToggle;

	// ROUTE_MANAGER ATTRIBUTES
	@FXML
	private ListView<?> encryptedListViewRM;

	@FXML
	private ListView<?> decryptedListViewRM;

	/// >>>METHODS CLASS
	private void load(String route) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(route));
		fxmlLoader.setController(this);
		Parent parent = fxmlLoader.load();
		borderPaneMain.getChildren().setAll(parent);
	}

	// WELCOME METHODS
	@FXML
	void decryptWelcome(ActionEvent event) throws IOException {
		load("DecryptWindow.fxml");
	}

	@FXML
	void encryptWelcome(ActionEvent event) throws IOException {
		load("EncryptWindow.fxml");
	}

	@FXML
	void routeManagerWelcome(ActionEvent event) throws IOException {
		load("RouteManager.fxml");
	}

	// ROUTE_MANAGER METHODS
	@FXML
	void backRM(ActionEvent event) throws IOException {
		load("Menu.fxml");
	}

	@FXML
	void deleteFileRM(ActionEvent event) {

	}

	@FXML
	void showFileRM(ActionEvent event) {

	}

	// MENU METHODS
	@FXML
	void decryptMenu(ActionEvent event) throws IOException {
		load("DecryptWindow.fxml");
	}

	@FXML
	void encryptMenu(ActionEvent event) throws IOException {
		load("EncryptWindow.fxml");
	}

	@FXML
	void routeManagerMenu(ActionEvent event) throws IOException {
		load("RouteManager.fxml");
	}

	@FXML
	void exit(ActionEvent event) {

	}
}
