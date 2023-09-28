package application.Controllers;

import application.DAO.AgentDAO;
import application.DTO.Agent;
import application.ENUMS.Type;
import application.Helpers.Validator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;
import java.util.ResourceBundle;

public class AgentController implements Initializable {

    private Stage stage;
    private Parent root;
    private Scene scene;

    // text areas
    @FXML
    private TextField agentEmail;
    @FXML
    private PasswordField agentPassword;

    // buttons
    @FXML
    private Button agentLoginBtn;
    @FXML
    private Button agentDash;
    @FXML
    private Button adminLoginBtn;

    // error labels
    @FXML
    private Label loginWarning;
    private Agent agent;

    // TODO: Fix add refund file choicebox error

    // choice box
//    @FXML
//    private ChoiceBox<Type> caseFileType = new ChoiceBox<Type>(Enum.valueOf(Type.values()));

//    private String[] lft = {"hi", "how","hey"};

    public AgentController() {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    protected void submit(ActionEvent event) throws Exception {
        Validator validator = new Validator();
        if (validator.validateEmail(agentEmail) && validator.validatePassword(agentPassword)) {
            agent = new Agent(agentEmail.getText(), agentPassword.getText());
            AgentDAO agentDAO = new AgentDAO();
            if (agentDAO.login(agent)) {
//                TextInputDialog codeConfirmation = new TextInputDialog();
//                codeConfirmation.setTitle("Verification Code");
//                codeConfirmation.setHeaderText("Enter Code you received via Email");
//                Optional<String> result = codeConfirmation.showAndWait();
//                if (result.isPresent() && !result.get().isEmpty()) {
//                    if (agentDAO.verifyLogin(agent, Integer.parseInt(result.get())) != null)
                System.out.println(Arrays.toString(Type.values()));
                        agentDashBoard(event);
//                } else {
//                    logingAlert("Please Enter a Verification Code");
//                }
            } else {
                logingAlert("Wrong Credentials");
            }
        }else {
            logingAlert("Invalid Credentials");
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

    @FXML
    protected void adminLoginView(ActionEvent event) throws Exception {
        root = FXMLLoader.load(getClass().getResource("/application/views/Admin/login.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void addCaseView(ActionEvent event) throws Exception {
        root = FXMLLoader.load(getClass().getResource("/application/views/Agent/addCase.fxml"));
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
