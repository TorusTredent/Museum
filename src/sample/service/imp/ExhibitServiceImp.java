package sample.service.imp;

import javafx.scene.control.Button;
import sample.controller.ControllerHelper;
import sample.service.ExhibitService;

public class ExhibitServiceImp implements ExhibitService {
    @Override
    public void backToAllExhibitW(Button button) {
        String address = "/sample/view/personal/allExhibitions/WindowAllExhibitions.fxml";
        ControllerHelper.updateWindow(button, address);
    }
}
