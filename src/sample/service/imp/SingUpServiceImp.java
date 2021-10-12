package sample.service.imp;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import sample.animations.Shake;
import sample.controller.ControllerHelper;
import sample.repository.SingUpWRepository;
import sample.service.SingUpWService;

import java.util.List;

public class SingUpServiceImp implements SingUpWService {

    @Override
    public boolean checkInputData(List<TextField> listOfFields) {
        String userName = listOfFields.get(0).getText().toLowerCase();
        String password = listOfFields.get(1).getText();

        if(SingUpWRepository.checkUserInDb(userName, password)) {
            return true;
        } else {
            Shake loginField = new Shake(listOfFields.get(0));
            Shake passwordField = new Shake(listOfFields.get(1));
            loginField.playAnim();
            passwordField.playAnim();
            return false;
        }
    }

    @Override
    public void loginInAccount(Button loginButton) {
        String window = "/sample/view/personal/WindowPersonal.fxml";
        ControllerHelper.updateWindow(loginButton, window);
    }

    @Override
    public void openRegistrationW(Button registrationButton) {
        String window = "/sample/view/registration/WindowRegistration.fxml";
        ControllerHelper.updateWindow(registrationButton, window);
    }

}