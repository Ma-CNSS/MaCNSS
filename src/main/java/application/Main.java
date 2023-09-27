package application;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

public class Main extends Application {
    public static void main(String[] args){
        launch();
    }
    @Override
    public void start(Stage stage) throws Exception {
        // scene config
        Parent root = FXMLLoader.load(getClass().getResource("views/Agent/login.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("styles/agent-style.css").toExternalForm());
        // stage config
        stage.setTitle("MaCNSS");
        Image appImage = new Image(getClass().getResource("images/cnss-logo-2.png").toURI().toURL().toExternalForm());
        stage.getIcons().add(appImage);
        stage.setScene(scene);
        stage.show();
    }
}