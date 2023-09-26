package application.Controllers;

import application.DAO.AgentDAO;
import application.DTO.Agent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class AgentController {
    @FXML
    private TextField agentEmail;
    @FXML
    private PasswordField agentPassword;
    @FXML
    private Button agentLoginBtn;
    @FXML
    private Label loginWarning;
    private Agent agent;
    public AgentController() {
    }

    @FXML
    protected void submit(ActionEvent event) {
        agent = new Agent(agentEmail.getText(), agentPassword.getText());
        AgentDAO agentDAO = new AgentDAO();
        if(agentDAO.login(agent)) {
            System.out.println("logged in");
        } else {
            loginWarning.setText("Wrong Credentials");
            loginWarning.setPrefWidth(286.0);
            loginWarning.setPadding(new Insets(3, 5, 3, 5));
        };
    }
}
