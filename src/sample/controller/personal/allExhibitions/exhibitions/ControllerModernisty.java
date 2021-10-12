package sample.controller.personal.allExhibitions.exhibitions;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import sample.service.imp.ExhibitServiceImp;

public class ControllerModernisty {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button backToAllExhibWButton;

    @FXML
    private Button personalAreaPersWButton;

    @FXML
    void initialize() {
       backToAllExhibWButton.setOnAction(actionEvent -> {
           ExhibitServiceImp exhib = new ExhibitServiceImp();
           exhib.backToAllExhibitW(backToAllExhibWButton);
       });
    }
}
