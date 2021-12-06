package sample.service;

import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

import java.util.List;

public interface RegistrationWService {
    boolean checkUniqFields(TextField userName, TextField mobileNumber);
    boolean checkPasswordFields(TextField password, TextField repPassword);
    void registrationNewUser(TextField login, TextField mobileNumber, TextField firstName, TextField lastName,
                             TextField password, RadioButton male, RadioButton female);
    void backToSingUpW(Button backToSingUpW);
    void loginInAccount(Button button);
    int getUserId (TextField username);
}
