package sample.service.imp;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import sample.controller.ControllerHelper;
import sample.service.PersonalWService;

public class PersonalWServiceImp implements PersonalWService {

    @Override
    public void openNewW(Button button, String address) {
        ControllerHelper.updateWindow(button, address);
    }

    @Override
    public void backToSingUpW(Button button) {
        String address = "/sample/view/singIn/WindowSingUp.fxml";
        ControllerHelper.updateWindow(button, address);
    }
}
