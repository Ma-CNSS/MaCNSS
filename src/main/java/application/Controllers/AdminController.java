package application.Controllers;

import application.DAO.AdminDAO;
import application.DTO.Admin;
import application.Helpers.Validator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class AdminController {

    Stage stage;
    Parent root;
    Scene scene;

    @FXML
    private TextField adminEmail;
    @FXML
    private PasswordField adminPassword;
    @FXML
    private Button adminLoginBtn;
    @FXML
    private Label loginWarning;

    private Admin admin;

    public AdminController() {
    }

    @FXML
    protected void submit(ActionEvent event) throws Exception {
        Validator validator = new Validator();
        if (validator.validateEmail(adminEmail) && validator.validatePassword(adminPassword)) {
            admin = new Admin(adminEmail.getText().strip(), adminPassword.getText().strip());
            AdminDAO adminDAO = new AdminDAO();
            // TODO: Login credentials even if true it returns false!
            if (adminDAO.login(admin))
                adminDashboard(event);
            else
                logingAlert("Wrong Credentials");
        }else {
            logingAlert("Invalid Credentials");
        }
    }

    @FXML
    protected void adminDashboard(ActionEvent event) throws Exception {
        root = FXMLLoader.load(getClass().getResource("/application/views/Admin/dashboard.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
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
