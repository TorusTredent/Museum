package sample.controller.singIn;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import sample.service.imp.SingUpServiceImp;

public class ControllerWSingUp {

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
                System.out.println("Не совпало с бд");
            } else {
                sing.loginInAccount(loginButton);
            }
        });

        registrationButton.setOnAction(event -> {
            SingUpServiceImp sing = new SingUpServiceImp();
            sing.openRegistrationW(registrationButton);
        });
    }
}

