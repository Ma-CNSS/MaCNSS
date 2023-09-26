package application.Controllers;

import application.DAO.AgentDAO;
import application.DTO.Agent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.util.Optional;

public class AgentController {

    private Stage stage;
    private Parent root;
    private Scene scene;

    @FXML
    private TextField agentEmail;
    @FXML
    private PasswordField agentPassword;
    @FXML
    private Button agentLoginBtn;
    @FXML
    private Button agentDash;
    @FXML
    private Label loginWarning;
    private Agent agent;
    public AgentController() {
    }

    @FXML
    protected void submit(ActionEvent event) throws Exception {
        agent = new Agent(agentEmail.getText(), agentPassword.getText());
        AgentDAO agentDAO = new AgentDAO();
        if(agentDAO.login(agent)) {
            TextInputDialog codeConfirmation = new TextInputDialog();
            codeConfirmation.setTitle("Verification Code");
            codeConfirmation.setHeaderText("Enter Code you received via Email");
            Optional<String> result = codeConfirmation.showAndWait();
            if (result.isPresent() && !result.get().isEmpty()) {
                System.out.println(result.get());
                System.out.println("logged in");
                agentDashBoard(event);
            }else {
                logingAlert("Please Enter a Verification Code");
            }
        } else {
            logingAlert("Wrong Credentials");
        };
    }

    @FXML
    protected void agentDashBoard(ActionEvent event) throws Exception {
        root = FXMLLoader.load(getClass().getResource("/application/views/Agent/dashboard.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void logingAlert(String message) {
        loginWarning.setText(message);
        loginWarning.setPrefWidth(286.0);
        loginWarning.setPadding(new Insets(5, 10, 5, 10));
    }
}
