package application;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

import java.util.Objects;

public class Main extends Application {
    public static void main(String[] args){
        launch();
    }
    @Override
    public void start(Stage stage) throws Exception {
        // scene config
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("views/Agent/login.fxml")));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("styles/agent-style.css")).toExternalForm());
        // stage config
        stage.setTitle("MaCNSS");
        Image appImage = new Image(Objects.requireNonNull(getClass().getResource("images/cnss-logo-2.png")).toURI().toURL().toExternalForm());
        stage.getIcons().add(appImage);
        stage.setScene(scene);
        stage.show();
    }
}