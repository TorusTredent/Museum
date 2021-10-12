package sample.controller.personal.personalArea;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Window;
import javafx.stage.WindowEvent;
import sample.service.imp.ChangeBalanceServiceImp;

public class ControllerWChangeBalance {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button acceptButton;

    @FXML
    private TextField balanceTextField;

    @FXML
    void initialize() {
        acceptButton.setOnAction(event -> {
            ChangeBalanceServiceImp change = new ChangeBalanceServiceImp();
            if (change.checkBalanceTextField(balanceTextField)){
                change.addBalance(balanceTextField.getText());
                change.returnToPersonalAreaW(acceptButton);
            }
        });
    }
}
