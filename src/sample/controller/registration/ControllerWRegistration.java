package sample.controller.registration;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import sample.animations.Shake;
import sample.entity.User;
import sample.service.imp.RegistrationWServiceImp;

public class ControllerWRegistration {

    @FXML
    private Label label;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField lastNameRWField;

    @FXML
    private PasswordField passwordRWField;

    @FXML
    private Button enterRWButton;

    @FXML
    private TextField firstNameRWField;

    @FXML
    private TextField userNameRWField;

    @FXML
    private PasswordField passwordRepRWField;

    @FXML
    private TextField mobileNumberRegW;

    @FXML
    private RadioButton maleRWRadioButton;

    @FXML
    private RadioButton femaleRWRadioButton;

    @FXML
    private Button backToSingUpRWButton;

    private final RegistrationWServiceImp register = new RegistrationWServiceImp();

    @FXML
    void initialize() {
        enterRWButton.setOnAction(event -> {
            if (!checkFieldsForNull(userNameRWField, mobileNumberRegW, passwordRWField, passwordRepRWField,
                    firstNameRWField, lastNameRWField)) {
                setLabelRed("Введены не все значения");
            } else {
                if (!register.checkUniqFields(userNameRWField, mobileNumberRegW)) {
                    setLabelRedShake(userNameRWField, "");
                    setLabelRedShake(mobileNumberRegW, "Данные уже используются");
                } else {
                    if (!register.checkPasswordFields(passwordRWField, passwordRepRWField)) {
                        setLabelRedShake(passwordRWField, "");
                        setLabelRedShake(passwordRepRWField, "Пароли не совпали");
                    } else {
                        register.registrationNewUser(userNameRWField, mobileNumberRegW,firstNameRWField,
                                lastNameRWField, passwordRWField, maleRWRadioButton, femaleRWRadioButton);
                        User.setId(register.getUserId(userNameRWField));
                        register.loginInAccount(enterRWButton);
                    }
                }
            }
        });

        backToSingUpRWButton.setOnAction(event -> {
            RegistrationWServiceImp register = new RegistrationWServiceImp();
            register.backToSingUpW(backToSingUpRWButton);
        });
    }



    private void shakeField(TextField textField) {
        Shake shake = new Shake(textField);
        shake.playAnim();
    }

    private void setLabelRedShake(TextField textField, String str) {
        shakeField(textField);
        label.setStyle("-fx-text-fill: #fa0000");
        label.setText(str);
    }

    private void setLabelRed(String str) {
        label.setStyle("-fx-text-fill: #fa0000");
        label.setText(str);
    }


    private boolean checkFieldsForNull(TextField loginField, TextField mobileTextField, TextField passwordField,
                                       TextField firstNameField, TextField lastNameField, TextField repPasswordField) {
        String login = loginField.getText();
        String mobile = mobileTextField.getText();
        String password = passwordField.getText();
        String repPassword = repPasswordField.getText();
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();

        if (login != null && mobile != null && password != null && repPassword != null && firstName != null
                && lastName != null) {
            return !login.isEmpty() && !mobile.isEmpty() && !password.isEmpty() && !repPassword.isEmpty() &&
                    !firstName.isEmpty() && !lastName.isEmpty();
        }
        return false;
    }
}
