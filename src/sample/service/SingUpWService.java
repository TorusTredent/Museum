package sample.service;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.util.List;

public interface SingUpWService {
    boolean checkInputData(List<TextField> listOfFields);
    void loginInAccount(Button loginButton);
    void openRegistrationW(Button registrationButton);
}
