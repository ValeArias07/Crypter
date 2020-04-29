package ui;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

	private CrypterGUI crypter;

	public static void main(String[] args) {
		launch(args);
	}

	public Main() {
		crypter = new CrypterGUI();
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
		primaryStage.getIcons().add(new Image("icon/iconito.png"));
		primaryStage.setTitle("Crypter");
		primaryStage.show();
	}
}
