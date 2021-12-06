package sample.controller.singIn;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import sample.animations.Shake;
import sample.service.imp.SingUpServiceImp;

public class ControllerWSingUp {

    @FXML
    private Label label;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button registrationButton;

    @FXML
    private TextField loginField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button loginButton;

    @FXML
    void initialize() {

        loginField.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.ENTER)) {
                passwordField.requestFocus();
            }
        });

        passwordField.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.ENTER)) {
                loginButton.fire();
            }
        });

        loginButton.setOnAction(event -> {
            List<TextField> listOfFields = new ArrayList<>();
            listOfFields.add(loginField);
            listOfFields.add(passwordField);
            SingUpServiceImp sing = new SingUpServiceImp();
            if (!sing.checkInputData(listOfFields)) {
                setLabelRedShake(loginField, "");
                setLabelRedShake(passwordField, "Нет такого пользователя");
            } else {
                if (sing.getStatus(loginField.getText()).equals("admin")) {
                    sing.loginInAccountAdmin(loginButton);
                } else {
                    sing.loginInAccount(loginButton);
                }
            }
        });

        registrationButton.setOnAction(event -> {
            SingUpServiceImp sing = new SingUpServiceImp();
            sing.openRegistrationW(registrationButton);
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
}

