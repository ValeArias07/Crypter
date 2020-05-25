package ui;

import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import exception.EmptyFieldException;
import exception.WordKeyInvalidException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DialogEvent;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.RadioButton;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polyline;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.Atbash;
import model.Cesar;
import model.Crypter;
import model.RouteManager;
import model.RouteNode;
import model.Vigenere;

public class CrypterGUI {
	
	/////////////////////////////////////////////////// ANIMATIONS//////////////////////////////////////////////////////////////////
	public static final Color[] COLOR = new Color[] {Color.web("#3D1934"),Color.web("#B81858"),Color.web("#EBD46E")};
	
	private static final String ABC = "abcdefghijklmnopqrstuvwxyz";
    @FXML
    private Polyline fUp;

    @FXML
    private Polyline fDown;
    
    @FXML
    private Label aLetter;

    @FXML
    private Label zLetter;
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 
	// WELCOME ATTRIBUTES

	@FXML
	private BorderPane borderPaneMain;

	@FXML
	private Menu settingsMenu;

	@FXML
	private Menu subMenu;

	@FXML
	private ToggleGroup textInputToggle;

	@FXML
	private ToggleGroup methodToggle;

	// ENCRYPT/DECRYPT_WINDOW ATTRIBUTES
	@FXML
	private Button encryptByFile;

	@FXML
	private Button decryptByFile;

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

	@FXML
	private ImageView decryptionTitle;

	@FXML
	private ImageView encryptionTitle;

	// ROUTE_MANAGER ATTRIBUTES
	@FXML
	private ListView<String> encryptedListViewRM;

	@FXML
	private ListView<String> decryptedListViewRM;

	// <<<SUB WINDOWS>>>
	// CESAR_WINDOW ATTRIBUTES
	@FXML
	private RadioButton R;

	@FXML
	private ToggleGroup directionToggleCesar;

	@FXML
	private RadioButton L;

	@FXML
	private TextField numberKeyCesar;

	// VIGENERE/AES_WINDOW ATTRIBUTES
	@FXML
	private TextField wordKeyVigenere_AES;
	/// <<<< >>>>

	// CONSOLE ATTRIBUTES
	@FXML
	private TextArea textConsole;

	@FXML
	private Button encryptByConsole;

	@FXML
	private Button decryptByConsole;

	// SHOW_STAGE ATTRIBUTES
	@FXML
	private TextArea textFromText;

	@FXML
	private ChoiceBox<?> fontChoice;

	@FXML
	private ChoiceBox<?> heightChoice;

	// >>>ATTRIBUTES CLASS
	private Stage secondStage;

	private Crypter crypter;

	//RELATIONS
	private RouteManager rm;
	
	public CrypterGUI (RouteManager rm) {
		this.rm = rm;
		secondStage = new Stage();
	}
	
	/// >>>METHODS CLASS

	// ---// LOADS
	private void load(String route) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(route));
		fxmlLoader.setController(this);
		Parent parent = fxmlLoader.load();
		borderPaneMain.setCenter(parent);
	}

	private void loadEncryptWindow() throws IOException {

		settingsMenu.setVisible(true);
		subMenu.setText("Encrypt");
		load("EncryptDecryptWindow.fxml");
		encryptionTitle.setVisible(true);
		decryptionTitle.setVisible(false);
		setInputSettings();
		setTypeSettings();
	}

	private void loadDecryptWindow() throws IOException {

		settingsMenu.setVisible(true);
		subMenu.setText("Decrypt");
		load("EncryptDecryptWindow.fxml");
		encryptionTitle.setVisible(false);
		decryptionTitle.setVisible(true);
		setInputSettings();
		setTypeSettings();
	}

	private void loadRouteManager() throws IOException, InterruptedException {
		load("RouteManager.fxml");
		initializeListViews();
	}
	
	private void initializeListViews() throws InterruptedException {
		
		ArrayList<String> encrypts = rm.getRoutes(true);
		ArrayList<String> decrypts = rm.getRoutes(false);
		
		ObservableList<String> observableListEn;
		ObservableList<String> observableListDe;
		
		if(encrypts==null) {
			observableListEn = FXCollections.observableArrayList("Empty");		
		}else {
			observableListEn = FXCollections.observableArrayList(encrypts);	
		}
		encryptedListViewRM.setItems(observableListEn);
		
		if(decrypts==null) {
			observableListDe = FXCollections.observableArrayList("Empty");		
		}else {
			observableListDe = FXCollections.observableArrayList(decrypts);	
		}
		decryptedListViewRM.setItems(observableListDe);
	}

	private void loadMenu() throws IOException {
		settingsMenu.setVisible(false);
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
		subLoad("AtbashWindow.fxml");
	}

	private void subLoadVigenereAES() throws IOException {
		subLoad("Vigenere-AES-Window.fxml");
	}

	// *
	private void loadShowFile() throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ShowFile.fxml"));
		fxmlLoader.setController(this);
		Parent parent = fxmlLoader.load();

		Scene scene = new Scene(parent);
		secondStage.setScene(scene);
		secondStage.setResizable(false);
		secondStage.getIcons().add(new Image("images/iconito.png"));
		secondStage.setTitle("Show file");
		secondStage.show();
	}

	// *
	private void loadAlert(AlertType type, String title, String middle, String bot) {
		Alert alert = new Alert(type);
		alert.setContentText(bot);
		alert.setHeaderText(middle);
		alert.setTitle(title);
		alert.show();
	}

	private void loadAlert(AlertType type, String title, String middle, String bot, EventHandler<DialogEvent> e) {
		Alert alert = new Alert(type);
		alert.setContentText(bot);
		alert.setHeaderText(middle);
		alert.setTitle(title);
		alert.show();

		alert.setOnCloseRequest(e);
	}

	// ---// SETTINGS
	private void setInputSettings() {
		if (((RadioMenuItem) textInputToggle.getSelectedToggle()).getText().equals("Console")) {
			encryptByFile.setVisible(false);
			decryptByFile.setVisible(false);
			fileRoute.setVisible(false);
			searchFile.setVisible(false);
			goToConsole.setVisible(true);

		} else {
			if (((RadioMenuItem) textInputToggle.getSelectedToggle()).getText().equals("Text file")) {
				fileRoute.setVisible(true);
				searchFile.setVisible(true);
				goToConsole.setVisible(false);
				if (subMenu.getText().equals("Encrypt")) {
					encryptByFile.setVisible(true);
					decryptByFile.setVisible(false);
				} else {
					encryptByFile.setVisible(false);
					decryptByFile.setVisible(true);
				}
			}
		}
	}

	private void setTypeSettings() throws IOException {
		if (((RadioMenuItem) methodToggle.getSelectedToggle()).getText().equals("Cesar")) {
			vigenereImage.setVisible(false);
			atbashImage.setVisible(false);
			aesImage.setVisible(false);
			cesarImage.setVisible(true);

			subLoadCesar();

			L.setSelected(true);
			numberKeyCesar.setText("3");
		} else {
			if (((RadioMenuItem) methodToggle.getSelectedToggle()).getText().equals("Atbash")) {
				vigenereImage.setVisible(false);
				atbashImage.setVisible(true);
				aesImage.setVisible(false);
				cesarImage.setVisible(false);

				subLoadAtbash();
			} else {
				if (((RadioMenuItem) methodToggle.getSelectedToggle()).getText().equals("Vigenere")) {
					vigenereImage.setVisible(true);
					atbashImage.setVisible(false);
					aesImage.setVisible(false);
					cesarImage.setVisible(false);

					subLoadVigenereAES();
				} else {
					vigenereImage.setVisible(false);
					atbashImage.setVisible(false);
					aesImage.setVisible(true);
					cesarImage.setVisible(false);

					subLoadVigenereAES();
				}
			}
		}
	}

	// ---// IS?
	private String getSelectedMethod() {
		if (vigenereImage.isVisible()) {
			return "VIGENERE";
		}

		if (atbashImage.isVisible()) {
			return "ATBASH";
		}

		if (aesImage.isVisible()) {
			return "AES";
		}

		if (cesarImage.isVisible()) {
			return "CESAR";
		}

		return null;
	}

	// WELCOME METHODS
	@FXML
	void aesM(ActionEvent event) throws IOException {
		setTypeSettings();
	}

	@FXML
	void atbashM(ActionEvent event) throws IOException {
		setTypeSettings();
	}

	@FXML
	void cesarM(ActionEvent event) throws IOException {
		setTypeSettings();
	}

	@FXML
	void consoleTIO(ActionEvent event) {
		setInputSettings();
	}

	@FXML
	void decryptWelcome(ActionEvent event) throws IOException {
		loadDecryptWindow();
	}

	@FXML
	void encryptWelcome(ActionEvent event) throws IOException {
		loadEncryptWindow();
	}

	@FXML
	void routeManagerWelcome(ActionEvent event) throws IOException, InterruptedException {
		loadRouteManager();
	}

	@FXML
	void textFileTIO(ActionEvent event) {
		setInputSettings();
	}

	@FXML
	void vigenereM(ActionEvent event) throws IOException {
		setTypeSettings();
	}

	// ENCRYPT-DECRYPT_WINDOW METHODS
	@FXML
	void back(ActionEvent event) throws IOException {
		loadMenu();
	}

	@FXML
	void encryptByFile(ActionEvent event) {
		
	}

	@FXML
	void decryptByFile(ActionEvent event) {

	}

	@FXML
	void goToConsole(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Console.fxml"));
		fxmlLoader.setController(this);
		Parent parent = fxmlLoader.load();

		if (subMenu.getText().equals("Encrypt")) {
			encryptByConsole.setVisible(true);
			decryptByConsole.setVisible(false);
		} else {
			encryptByConsole.setVisible(false);
			decryptByConsole.setVisible(true);
		}

		textConsole.setText(" ");

		Scene scene = new Scene(parent);
		secondStage.setScene(scene);
		secondStage.setResizable(false);
		secondStage.getIcons().add(new Image("images/iconito.png"));
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

		if (file != null)
			fileRoute.setText(file.getAbsolutePath());
	}

	// ROUTE_MANAGER METHODS
	@FXML
	void backRM(ActionEvent event) throws IOException {
		loadMenu();
	}

    @FXML
    void showFileEnRM(ActionEvent event) throws IOException {
    	if(encryptedListViewRM.getSelectionModel().getSelectedItem()==null) {
    		loadAlert(AlertType.WARNING, "NOTHING SELECTED", "please select any route","try again");
    	}else {
    		if(encryptedListViewRM.getSelectionModel().getSelectedItem().toString().equals("Empty")) {
    			loadAlert(AlertType.INFORMATION, "LIST IS EMPTY", "Sorry","try again later");
    		}else {
    			loadShowFile();
    			textFromText.setText(rm.searchRoute(encryptedListViewRM.getSelectionModel().getSelectedItem().toString()));
    		}
    	}
    }

    @FXML
    void deleteFileEnRM(ActionEvent event) {

    }

    @FXML
    void deleteFileDeRM(ActionEvent event) {

    }

    @FXML
    void showFileDeRM(ActionEvent event) throws IOException {
    	if(decryptedListViewRM.getSelectionModel().getSelectedItem()==null) {
    		loadAlert(AlertType.WARNING, "NOTHING SELECTED", "please select any route","try again");
    	}else {
    		if(decryptedListViewRM.getSelectionModel().getSelectedItem().toString().equals("Empty")) {
    			loadAlert(AlertType.INFORMATION, "LIST IS EMPTY", "Sorry","try again later");
    		}else {
    			loadShowFile();
    			textFromText.setText(rm.searchRoute(decryptedListViewRM.getSelectionModel().getSelectedItem().toString()));
    		}
    	}
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
	void routeManagerMenu(ActionEvent event) throws IOException, InterruptedException {
		loadRouteManager();
	}

	@FXML
	void exit(ActionEvent event) {
		System.exit(0);
	}

	// CONSOLE METHODS
	
	private void writeRoute(String text, boolean type) throws IOException {
		rm.writeRoute(text, type);
	}
	
	@FXML
	void encryptByConsole(ActionEvent event) throws IOException, WordKeyInvalidException {
		try {
			if (!textConsole.getText().equals(" ")) {
				String method = getSelectedMethod();
				if (method.equals("CESAR")) {
					encryptByConsoleCesar();
				} else if (method.equals("AES")) {
						loadAlert(AlertType.INFORMATION, "INFORMATION", "This funcionality not implemented yet",
								"We are sorry");
				} else if (method.equals("VIGENERE")) {
					encryptByConsoleVigenere();
				} else if (method.equals("ATBASH")) {
					encryptByConsoleAtbash();
				}
			} else {
				throw new EmptyFieldException("CONSOLE", "ENCRYPT");
			}
		} catch (EmptyFieldException e) {
			loadAlert(AlertType.WARNING, "WARNING", e.getMessage(), "try type something");
		}
	}

	private void encryptByConsoleCesar() throws IOException, WordKeyInvalidException{
		String direction = ((RadioButton) directionToggleCesar.getSelectedToggle()).getText();
		try {
			int numberKey = Integer.parseInt(numberKeyCesar.getText());
			crypter = new Cesar(numberKey, direction);
			String returnText = crypter.encrypt(textConsole.getText());
			
			writeRoute(returnText, true);
			
			EventHandler<DialogEvent> e = new EventHandler<DialogEvent>() {
				public void handle(DialogEvent e) {
					try {
						loadShowFile();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					textFromText.setText(returnText);
				}
			};
			loadAlert(AlertType.INFORMATION, "SUSSESFUL", "THE PROCESS IS COMPLETE",
					"then the preview will open", e);

		} catch (NumberFormatException e) {
			loadAlert(AlertType.WARNING, "WARNING", "You must type a number in the numberKey field",
					"Please, type a number the next time");
		}
	}
	
	private void encryptByConsoleVigenere() throws IOException {
		try {
			String encriptionKey = wordKeyVigenere_AES.getText();
			if(encriptionKey.equals("")) {
				throw new EmptyFieldException("KEY", "DECRYPT");
			}else {
				crypter = new Vigenere(encriptionKey);
				String returnText;
				try {
					returnText = crypter.encrypt(textConsole.getText());
					writeRoute(returnText, true);
					
					EventHandler<DialogEvent> e = new EventHandler<DialogEvent>() {
						public void handle(DialogEvent e) {
							try {
								loadShowFile();
							} catch (IOException e1) {
								e1.printStackTrace();
							}
							textFromText.setText(returnText);
						}
					};
					loadAlert(AlertType.INFORMATION, "SUSSESFUL", "THE PROCESS IS COMPLETE",
							"then the preview will open", e);
				} catch (WordKeyInvalidException e) {
					loadAlert(AlertType.WARNING, "ERROR", e.getMessage(), "Try again");
				}
			}
		} catch (EmptyFieldException e) {
			loadAlert(AlertType.WARNING, "WARNING", e.getMessage(), "try type something");
		}
	}
	
	private void encryptByConsoleAtbash() throws IOException, WordKeyInvalidException{
		crypter = new Atbash();
		String returnText;
		returnText = crypter.encrypt(textConsole.getText());
		
		writeRoute(returnText, true);
		
		EventHandler<DialogEvent> e = new EventHandler<DialogEvent>() {
			public void handle(DialogEvent e) {
				try {
					loadShowFile();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				textFromText.setText(returnText);
			}
		};
		loadAlert(AlertType.INFORMATION, "SUSSESFUL", "THE PROCESS IS COMPLETE",
				"then the preview will open", e);
	}
	
	@FXML
	void decryptByConsole(ActionEvent event) throws IOException {
		try {
			if (!textConsole.getText().equals(" ")) {
				String method = getSelectedMethod();
				if (method.equals("CESAR")) {
					decryptByConsoleCesar();
				} else if (method.equals("AES")) {
						loadAlert(AlertType.INFORMATION, "INFORMATION", "This funcionality not implemented yet",
								"We are sorry");
				} else if (method.equals("VIGENERE")) {
					decryptByConsoleVigenere();
				} else if (method.equals("ATBASH")) {
					decryptByConsoleAtbash();
				}
			} else {
				throw new EmptyFieldException("CONSOLE", "DECRYPT");
			}
		} catch (EmptyFieldException e) {
			loadAlert(AlertType.WARNING, "WARNING", e.getMessage(), "try type something");
		}
	}
	
	private void decryptByConsoleCesar() throws IOException {
		String direction = ((RadioButton) directionToggleCesar.getSelectedToggle()).getText();
		try {
			int numberKey = Integer.parseInt(numberKeyCesar.getText());
			crypter = new Cesar(numberKey, direction);
			String returnText = crypter.decrypt(textConsole.getText());
			
			writeRoute(returnText, false);
			
			EventHandler<DialogEvent> e = new EventHandler<DialogEvent>() {
				public void handle(DialogEvent e) {
					try {
						loadShowFile();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					textFromText.setText(returnText);
				}
			};
			loadAlert(AlertType.INFORMATION, "SUSSESFUL", "THE PROCESS IS COMPLETE",
					"then the preview will open", e);
		} catch (NumberFormatException e) {
			loadAlert(AlertType.WARNING, "WARNING", "You must type a number in the numberKey field",
					"Please, type a number the next time");
		}
	}

	private void decryptByConsoleVigenere() throws IOException {
		try {
			String encriptionKey = wordKeyVigenere_AES.getText();
			if(encriptionKey.equals("")) {
				throw new EmptyFieldException("KEY", "DECRYPT");
			}else {
				crypter = new Vigenere(encriptionKey);
				String returnText = crypter.decrypt(textConsole.getText());
				
				writeRoute(returnText, false);
				
				EventHandler<DialogEvent> e = new EventHandler<DialogEvent>() {
					public void handle(DialogEvent e) {
						try {
							loadShowFile();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						textFromText.setText(returnText);
					}
				};
				loadAlert(AlertType.INFORMATION, "SUSSESFUL", "THE PROCESS IS COMPLETE",
						"then the preview will open", e);
			}
		} catch (EmptyFieldException e) {
			loadAlert(AlertType.WARNING, "WARNING", e.getMessage(), "try type something");
		}
	}
	
	private void decryptByConsoleAtbash() throws IOException {
		crypter = new Atbash();
		String returnText = crypter.decrypt(textConsole.getText());
		
		writeRoute(returnText, false);
		
		EventHandler<DialogEvent> e = new EventHandler<DialogEvent>() {
			public void handle(DialogEvent e) {
				try {
					loadShowFile();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				textFromText.setText(returnText);
			}
		};
		loadAlert(AlertType.INFORMATION, "SUSSESFUL", "THE PROCESS IS COMPLETE",
				"then the preview will open", e);
	}
	
	// SHOW_STAGE METHODS

	@FXML
	void cursiveOption(ActionEvent event) {
	}

	@FXML
	void negritaOption(ActionEvent event) {
		textFromText.setStyle("-fx:"+Font.BOLD);
		
	}

	@FXML
	void subOption(ActionEvent event) {

	}
	////// .setFont(Font.font("Comic Sans MS", 18));
	
	////////////////////////////////////////////////ANIMATIONS//////////////////////////////////////////////////////////////////////////
	public void updateX(boolean type, double value) {
    	if(type) {
    	fUp.setLayoutX(value);
    	}else {
    		fDown.setLayoutX(value);
    	}
    }
    
    public double getX(boolean type) {
    	if(type) {
        	 return fUp.getLayoutX();
        	}else {
        		return fDown.getLayoutX();
        	}
    }
    
    public void rotate(boolean type, double value) {
    	if(type) {
       	 fUp.setRotate(value);
       	}else {
       		fDown.setRotate(value);
       	}
    }
    
    public void changeColor(boolean type, int value) {
    	
    	if(type) {
    		fUp.setFill(COLOR[value]);

    	}else {
    		fUp.setFill(COLOR[value]);
    	}
    	
    }
    
    public double getXLetters(boolean type) {
    	if(type) {
        	 return aLetter.getLayoutX();
        	}else {
        		return zLetter.getLayoutX();
        	}
    }
  
    public void updateXLetters(boolean type, double value) {
    	if(type) {
    		aLetter.setLayoutX(value);
    	}else {
    		zLetter.setLayoutX(value);
    	}
    }
    
    public void updateContent(boolean type, int value) {
    	if(type) {
    		aLetter.setText(String.valueOf(ABC.charAt(value)).toUpperCase());
    	}else {
    		zLetter.setText(String.valueOf(ABC.charAt(value)).toUpperCase());
    	}
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}
