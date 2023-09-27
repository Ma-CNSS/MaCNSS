package application.Helpers;

import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;

import java.util.function.UnaryOperator;
import java.util.regex.Pattern;

public class Validator {

    public Validator() {
    }
    public boolean validateEmail(TextField emailField) {
        boolean isValid = false;
        if (!emailField.getText().isEmpty()) {
            Pattern emailPattern = Pattern.compile("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}");
            if (emailPattern.matcher(emailField.getText()).matches()) {
                isValid = true;
            }
        }
        return isValid;
    }

    public boolean validatePassword(PasswordField passwordField) {
        boolean isValid  = false;
        if (!passwordField.getText().isEmpty()) {
            Pattern passwordPattern = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{5,}$");
            if (passwordPattern.matcher(passwordField.getText()).matches()) {
                isValid = true;
            }
        }
        return isValid;
    }
}
