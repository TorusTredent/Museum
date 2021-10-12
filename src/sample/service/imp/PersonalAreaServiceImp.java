package sample.service.imp;

import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import sample.animations.Shake;
import sample.controller.ControllerHelper;
import sample.entity.Ticket;
import sample.repository.PersonalAreaRepository;
import sample.service.PersonalAreaService;

import java.util.List;

public class PersonalAreaServiceImp implements PersonalAreaService {

    @Override
    public boolean tableIsEmpty() {
        return PersonalAreaRepository.tableIsEmpty();
    }

    @Override
    public void openChangeBalanceW(Button button) {
        String address = "/sample/view/personal/personalArea/WindowChangeBalance.fxml";
        ControllerHelper.setNewWindow(address);
    }

    @Override
    public void acceptChanges(List<TextField> listOfTextField, List<RadioButton> radioButtonList) {
        String gender = "";
        if (radioButtonList.get(0).isSelected()) {
            gender = "мужской";
        } else {
            gender = "женский";
        }
        PersonalAreaRepository.updateUserDate(listOfTextField, gender);
        System.out.println("Выполенено обновление");
    }

    @Override
    public ObservableList<Ticket> getDataFromDb(ObservableList<Ticket> ticket) {
        return PersonalAreaRepository.getData(ticket);
    }

    @Override
    public void openPersonalW(Button button) {
        String address = "/sample/view/personal/WindowPersonal.fxml";
        ControllerHelper.updateWindow(button, address);
    }

    @Override
    public boolean checkFieldsValue(List<TextField> listOfTextField, List<RadioButton> radioButtonList,
                                    List<TextField> listOfOldTextField, List<RadioButton> oldRadioButtonList) {
        if(listOfTextField.get(4).getText().length() > 13) {
            shakeMobileField(listOfTextField.get(4));
            return false;
        }

        String newUserName = listOfTextField.get(2).getText().toLowerCase();
        String newMobileNumber = listOfTextField.get(4).getText().replaceAll("\\s+","");

        String oldUserName = listOfOldTextField.get(2).getText().toLowerCase();
        String oldMobileNumber = listOfOldTextField.get(4).getText().replaceAll("\\s+","");

        if(!newUserName.equals(oldUserName)) {
            if (PersonalAreaRepository.checkUsername(newUserName)) {
                if (!newMobileNumber.equals(oldMobileNumber)) {
                    return PersonalAreaRepository.checkMobileNumber(newMobileNumber);
                } else {
                    return true;
                }
            } else {
                return false;
            }
        } else {
            return newMobileNumber.equals(oldMobileNumber);
        }
    }

    @Override
    public void updateW(Button button) {
        String address = "/sample/view/personal/personalArea/WindowPersonalArea.fxml";
        ControllerHelper.updateWindow(button, address);
    }

    @Override
    public String takeFirstNameFromDB() {
        return PersonalAreaRepository.takeFirstName();
    }

    @Override
    public String takeLastNameFromDB() {
        return PersonalAreaRepository.takeLastName();
    }

    @Override
    public String takeLoginFromDB() {
        return PersonalAreaRepository.takeUserName();
    }

    @Override
    public String takePasswordFromDB() {
        return PersonalAreaRepository.takePassword();
    }

    @Override
    public String takeMobileNumberFromDB() {
        return PersonalAreaRepository.takeMobileNumber();
    }

    @Override
    public String takeGenderFromDB() {
        return PersonalAreaRepository.takeGender();
    }

    @Override
    public String takeBalanceFromDB() {
        return PersonalAreaRepository.takeBalance();
    }

    private void shakeMobileField(TextField textField) {
        Shake mobileField = new Shake(textField);
        mobileField.playAnim();
    }
    private void shakeLoginField(TextField textField) {
        Shake loginField = new Shake(textField);
        loginField.playAnim();
    }
}