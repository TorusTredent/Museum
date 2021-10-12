package sample.service;

import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

import java.util.List;

public interface RegistrationWService {
    boolean checkUniqFields(TextField userName, TextField mobileNumber);
    void registrationNewUser(List<TextField> list, List<RadioButton> listOfRadButton);
    void backToSingUpW(Button backToSingUpW);
    void loginInAccount(Button button);
}
