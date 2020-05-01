package ui;

import java.io.File;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.RadioButton;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

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

	// ENCRYPT_WINDOW ATTRIBUTES
	@FXML
	private Button encryptByFile;

	@FXML
	private AnchorPane borderSelected;

	@FXML
	private ImageView aesImage;

	@FXML
	private ImageView vigenereImage;

	@FXML
	private ImageView cesarImage;

	@FXML
	private ImageView atbashImage;

	@FXML
	private Button searchFile;

	@FXML
	private TextField fileRoute;

	@FXML
	private Button goToConsole;

	// ROUTE_MANAGER ATTRIBUTES
	@FXML
	private ListView<?> encryptedListViewRM;

	@FXML
	private ListView<?> decryptedListViewRM;

	// CESAR_WINDOWS ATTRIBUTES
	@FXML
	private RadioButton R;

	@FXML
	private ToggleGroup directionToggleCesar;

	@FXML
	private RadioButton L;

	@FXML
	private TextField numberKeyCesar;

	// CONSOLE ATTRIBUTES
	@FXML
	private TextArea textConsole;

	// >>>ATTRIBUTES CLASS
	private Stage secondStage;

	public CrypterGUI() {
		secondStage = new Stage();
	}

	/// >>>METHODS CLASS
	private void load(String route) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(route));
		fxmlLoader.setController(this);
		Parent parent = fxmlLoader.load();
		borderPaneMain.setCenter(parent);
	}

	// ---// LOADS
	private void loadEncryptWindow() throws IOException {

		settingsMenu.setVisible(true);
		decryptSubMenu.setVisible(false);
		encryptSubMenu.setVisible(true);
		load("EncryptWindow.fxml");
		setInputEncryptSettings();
		setTypeEncryptSettings();

	}

	private void loadDecryptWindow() throws IOException {
		load("DecryptWindow.fxml");
	}

	private void loadRouteManager() throws IOException {
		load("RouteManager.fxml");
	}

	private void loadMenu() throws IOException {
		load("Menu.fxml");
	}

	// ----// SubLOADS
	private void subLoad(String route) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(route));
		fxmlLoader.setController(this);
		Parent parent = fxmlLoader.load();
		borderSelected.getChildren().clear();
		borderSelected.getChildren().setAll(parent);
	}

	private void subLoadCesar() throws IOException {
		subLoad("CesarWindow.fxml");
	}

	private void subLoadAtbash() throws IOException {

	}

	private void subLoadAES() throws IOException {

	}

	private void subLoadVigenere() throws IOException {

	}

	// ---// SETTINGS
	private void setInputEncryptSettings() {
		if (((RadioMenuItem) textInputToggleEncrypt.getSelectedToggle()).getText().equals("Console")) {
			encryptByFile.setVisible(false);
			fileRoute.setVisible(false);
			searchFile.setVisible(false);
			goToConsole.setVisible(true);
		} else {
			if (((RadioMenuItem) textInputToggleEncrypt.getSelectedToggle()).getText().equals("Text file")) {
				encryptByFile.setVisible(true);
				fileRoute.setVisible(true);
				searchFile.setVisible(true);
				goToConsole.setVisible(false);
			}
		}
	}

	private void setTypeEncryptSettings() throws IOException {
		if (((RadioMenuItem) encryptedToggle.getSelectedToggle()).getText().equals("Cesar")) {
			vigenereImage.setVisible(false);
			atbashImage.setVisible(false);
			aesImage.setVisible(false);
			cesarImage.setVisible(true);

			subLoadCesar();
		} else {
			if (((RadioMenuItem) encryptedToggle.getSelectedToggle()).getText().equals("Atbash")) {
				vigenereImage.setVisible(false);
				atbashImage.setVisible(true);
				aesImage.setVisible(false);
				cesarImage.setVisible(false);
			} else {
				if (((RadioMenuItem) encryptedToggle.getSelectedToggle()).getText().equals("Vigenere")) {
					vigenereImage.setVisible(true);
					atbashImage.setVisible(false);
					aesImage.setVisible(false);
					cesarImage.setVisible(false);
				} else {
					vigenereImage.setVisible(false);
					atbashImage.setVisible(false);
					aesImage.setVisible(true);
					cesarImage.setVisible(false);
				}
			}
		}
	}

	// WELCOME METHODS
	@FXML
	void decryptWelcome(ActionEvent event) throws IOException {
		loadDecryptWindow();
	}

	@FXML
	void encryptWelcome(ActionEvent event) throws IOException {
		loadEncryptWindow();
	}

	@FXML
	void routeManagerWelcome(ActionEvent event) throws IOException {
		loadRouteManager();
	}

	// ---->>> MENU-BAR METHODS
	@FXML
	void aesDecryptMM(ActionEvent event) throws IOException {

	}

	@FXML
	void aesEncryptMM(ActionEvent event) throws IOException {
		setTypeEncryptSettings();
	}

	@FXML
	void atbashDecryptMM(ActionEvent event) throws IOException {

	}

	@FXML
	void atbashEncryptMM(ActionEvent event) throws IOException {
		setTypeEncryptSettings();
	}

	@FXML
	void cesarDecryptMM(ActionEvent event) throws IOException {

	}

	@FXML
	void cesarEncryptMM(ActionEvent event) throws IOException {
		setTypeEncryptSettings();
	}

	@FXML
	void consoleDecryptTIO(ActionEvent event) {

	}

	@FXML
	void consoleEncryptTIO(ActionEvent event) {
		setInputEncryptSettings();
	}

	@FXML
	void textFileDecryptTIO(ActionEvent event) {

	}

	@FXML
	void textFileEncryptTIO(ActionEvent event) {
		setInputEncryptSettings();
	}

	@FXML
	void vigenereDecryptMM(ActionEvent event) throws IOException {

	}

	@FXML
	void vigenereEncryptMM(ActionEvent event) throws IOException {
		setTypeEncryptSettings();
	}

	// ENCRYPT_WINDOW METHODS
	@FXML
	void back(ActionEvent event) throws IOException {
		loadMenu();
	}

	@FXML
	void encryptByFile(ActionEvent event) {

	}

	@FXML
	void goToConsole(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Console.fxml"));
		fxmlLoader.setController(this);
		Parent parent = fxmlLoader.load();
		Scene scene = new Scene(parent);
		secondStage.setScene(scene);
		secondStage.setResizable(false);
		secondStage.setTitle("Console");
		secondStage.show();
	}

	@FXML
	void searchFile(ActionEvent event) throws IOException {
		FileChooser fileChooser = new FileChooser();

		fileChooser.setTitle("Buscar ruta");
		// Agregar filtros para facilitar la busqueda
		fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("TXT", "*.txt"));

		File file = fileChooser.showOpenDialog(null);
		fileRoute.setText(file.getAbsolutePath());
	}

	// ROUTE_MANAGER METHODS
	@FXML
	void backRM(ActionEvent event) throws IOException {
		loadMenu();
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
		loadDecryptWindow();
	}

	@FXML
	void encryptMenu(ActionEvent event) throws IOException {
		loadEncryptWindow();
	}

	@FXML
	void routeManagerMenu(ActionEvent event) throws IOException {
		loadRouteManager();
	}

	@FXML
	void exit(ActionEvent event) {

	}

	// CONSOLE METHODS
	@FXML
	void encryptByConsole(ActionEvent event) {

	}
}
