package ui;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import model.RouteManager;

public class Main extends Application {

	public static final String DATA = "SerialData/save.Crypter";
	
	private CrypterGUI crypter;
	private RouteManager rm;
	
	public static void main(String[] args) {
		launch(args);
	}

	public Main() throws ClassNotFoundException {
		load();
		crypter = new CrypterGUI(rm);
	}

	public void start(Stage primaryStage) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Welcome.fxml"));
		fxmlLoader.setController(crypter);
		Parent parent = fxmlLoader.load();

		Scene scene = new Scene(parent);
		primaryStage.setScene(scene);
		primaryStage.setHeight(635);
		primaryStage.setWidth(605);
		primaryStage.setResizable(false);
		primaryStage.getIcons().add(new Image("images/iconito.png"));
		primaryStage.setTitle("Crypter");
		primaryStage.show();
		
		EventHandler<WindowEvent> e = new EventHandler<WindowEvent>() {
			public void handle(WindowEvent e) {
				crypter.save();
			}
		};
		
		primaryStage.setOnCloseRequest(e);
	}
	
	@SuppressWarnings("resource")
	public void load() throws ClassNotFoundException {

		File file = new File(DATA);

		if(file.exists()) {
			try {
				FileInputStream fi = new FileInputStream(DATA);
				ObjectInputStream oi;
				oi = new ObjectInputStream(fi);
				rm = (RouteManager)oi.readObject();

			} catch (IOException e) {
				System.out.println(e.getMessage());
			}

		}else {
			rm = new RouteManager();
		}
	}
}
