package sample.controller.personal.allExhibitions.exhibitions;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import sample.service.imp.ExhibitServiceImp;

public class ControllerCollectionShukini {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button backToAllExhibWButton;


    @FXML
    void initialize() {
        backToAllExhibWButton.setOnKeyPressed(keyEvent -> {
            if (keyEvent.getCode().equals(KeyCode.ESCAPE)){
                ExhibitServiceImp exhibit = new ExhibitServiceImp();
                exhibit.backToAllExhibitW(backToAllExhibWButton);
            }
        });
    }
}
