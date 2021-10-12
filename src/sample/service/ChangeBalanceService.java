package sample.service;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public interface ChangeBalanceService {
    void addBalance(String newBalance);
    boolean checkBalanceTextField(TextField textField);
    void returnToPersonalAreaW(Button button);
}
