package sample.verification;

import javafx.scene.control.TextField;
import sample.animations.Shake;

import java.util.ArrayList;
import java.util.List;

public class FieldVerification {

    public boolean checkRegistrationFields(List<TextField> listOfField) {
        if (checkFieldsIsEmpty(listOfField)) {
            return false;
        } else {
            String password = listOfField.get(3).getText();
            String passwordRep = listOfField.get(4).getText();
            if (password.equals(passwordRep)) {
                Shake passwordField = new Shake(listOfField.get(3));
                Shake passwordRepField = new Shake(listOfField.get(4));
                passwordField.playAnim();
                passwordRepField.playAnim();
                return false;
            }
            return true;
        }
    }


    public boolean checkFieldsIsEmpty(List<TextField> listOfField) {
        List<String> listString = new ArrayList<>();
        for (TextField textField : listOfField) {
            listString.add(textField.getText());
        }
        for (int i = 0; i < listString.size(); i++) {
            if (listOfField.get(i) == null) {
                Shake userNameField = new Shake(listOfField.get(i));
                userNameField.playAnim();
                return true;
            }
        }
        return false;
    }
}

