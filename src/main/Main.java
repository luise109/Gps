package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("vista/MenuSeleccion.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 450, 300);
        stage.setTitle("GPS");
        stage.setScene(scene);
        stage.show();
    }
    private static Stage primaryStage;
    public static void main(String[] args) throws IOException, InterruptedException {
        launch();
    }


    public static void popUp(String fxml, String title) throws IOException {
        Parent node = loadFXML(fxml);
        Stage popUp = new Stage();
        Scene scene = new Scene(node);
        popUp.setScene(scene);
        popUp.setTitle(title);
        popUp.initOwner(primaryStage);
        popUp.initModality(Modality.WINDOW_MODAL);
        popUp.centerOnScreen();
        popUp.show();

    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("vista/"+ fxml + ".fxml"));
        return fxmlLoader.load();
    }

}


