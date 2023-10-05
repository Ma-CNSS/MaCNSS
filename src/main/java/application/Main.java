package application;

import application.DAO2.AgentDAO;
import application.DTO.Agent;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

import java.util.*;

public class Main extends Application {
    public static void main(String[] args){

        AgentDAO agentDAO = new AgentDAO();
        Agent agent = new Agent();

        Map<String , Object> c = new HashMap<>();
        c.put("Email","bhb@juj");


//        Agent agent1 = agentDAO.where(c);
//        System.out.println();

//        agentDAO.where("sidat").and();
//
//        for(Agent a : agentDAO.find(c)){
//            System.out.println(a.getLast_name());
//        }


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