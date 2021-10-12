package sample.service.imp;

import javafx.scene.control.Button;
import sample.controller.ControllerHelper;
import sample.service.AllExhibitionsService;

public class AllExhibitionsServiceImp implements AllExhibitionsService {
    @Override
    public void openNewW(Button button, String address) {
        ControllerHelper.updateWindow(button, address);
    }

    @Override
    public void backToPersonalW(Button button) {
        String address = "/sample/view/personal/WindowPersonal.fxml";
        ControllerHelper.updateWindow(button, address);
    }
}
