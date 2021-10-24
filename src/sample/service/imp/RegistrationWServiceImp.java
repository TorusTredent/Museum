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
    public boolean checkPasswordFields(TextField password, TextField repPassword) {
        String passwordStr = password.getText();
        String repPasswordStr = repPassword.getText();

        return passwordStr.equals(repPasswordStr);
    }

    @Override
    public void registrationNewUser(TextField login, TextField mobileNumber, TextField firstName, TextField lastName,
                                    TextField password, RadioButton male, RadioButton female) {
        String firstNameStr = firstName.getText().trim();
        String lastNameStr = lastName.getText().trim();
        String userName = login.getText().toLowerCase();
        String passwordStr = password.getText().trim();
        String mobileNumberStr = mobileNumber.getText().replaceAll("\\s+","");
        String gender = "";
        if(male.isPressed()) {
            gender = "мужской";
        } else {
            gender = "женский";
        }

        User user = new User(firstNameStr, lastNameStr, userName, passwordStr, gender, mobileNumberStr);

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

    @Override
    public int getUserId(TextField username) {
        String login = username.getText().toLowerCase();
        return RegistrationWRepository.getUserId(login);
    }
}
