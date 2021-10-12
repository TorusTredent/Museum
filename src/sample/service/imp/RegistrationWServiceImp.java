package sample.service.imp;

import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import sample.controller.ControllerHelper;
import sample.entity.User;
import sample.repository.RegistrationWRepository;
import sample.service.RegistrationWService;

import java.util.List;

public class RegistrationWServiceImp implements RegistrationWService{

    @Override
    public boolean checkUniqFields(TextField userName, TextField mobileNumber) {
        String name = userName.getText().toLowerCase().trim();
        String number = mobileNumber.getText().replaceAll("\\s+","");
        if (number.length() == 13) {
            return RegistrationWRepository.checkUniqFields(name, number);
        } else {
            return false;
        }
    }

    @Override
    public void registrationNewUser(List<TextField> list, List<RadioButton> listOfRadButton) {
        String firstName = list.get(0).getText().trim();
        String lastName = list.get(1).getText().trim();
        String userName = list.get(2).getText().toLowerCase();
        String password = list.get(3).getText().trim();
        String mobileNumber = list.get(5).getText().replaceAll("\\s+","");
        String gender = "";
        if(listOfRadButton.get(0).isPressed()) {
            gender = "мужской";
        } else {
            gender = "женский";
        }

        User user = new User(firstName, lastName, userName, password, gender, mobileNumber);

        RegistrationWRepository.registrationUser(user);
    }

    @Override
    public void backToSingUpW(Button backToSingUpW) {
        String address = "/sample/view/singIn/WindowSingUp.fxml";
        ControllerHelper.updateWindow(backToSingUpW, address);
    }

    @Override
    public void loginInAccount(Button button) {
        String address = "/sample/view/personal/WindowPersonal.fxml";
        ControllerHelper.updateWindow(button, address);
    }
}
