package sample.controller.registration;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import sample.animations.Shake;
import sample.service.imp.RegistrationWServiceImp;
import sample.verification.FieldVerification;

public class ControllerWRegistration {

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



    @FXML
    void initialize() {
        enterRWButton.setOnAction(event -> {
            FieldVerification fieldVerification = new FieldVerification();
            RegistrationWServiceImp register = new RegistrationWServiceImp();

            List<TextField> listOfField = new ArrayList<>();
            listOfField.add(firstNameRWField);
            listOfField.add(lastNameRWField);
            listOfField.add(userNameRWField);
            listOfField.add(passwordRWField);
            listOfField.add(passwordRepRWField);
            listOfField.add(mobileNumberRegW);

            List<RadioButton> listOfRadButton = new ArrayList<>();
            listOfRadButton.add(maleRWRadioButton);
            listOfRadButton.add(femaleRWRadioButton);

            if (fieldVerification.checkRegistrationFields(listOfField)) {
                System.out.println("Поля пустые");
            } else {
                if (register.checkUniqFields(userNameRWField, mobileNumberRegW)) {
                    register.registrationNewUser(listOfField, listOfRadButton);
                    register.loginInAccount(enterRWButton);
                } else {
                    shakeField();
                }
            }
        });

        backToSingUpRWButton.setOnAction(event -> {
            RegistrationWServiceImp register = new RegistrationWServiceImp();
            register.backToSingUpW(backToSingUpRWButton);
        });
    }

    private void shakeField() {
        Shake userName = new Shake(userNameRWField);
        Shake mobileNumber = new Shake(mobileNumberRegW);
        userName.playAnim();
        mobileNumber.playAnim();
    }
}
