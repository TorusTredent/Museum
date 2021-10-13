package sample.service;

import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import sample.entity.Ticket;

import java.util.List;

public interface PersonalAreaService {
    boolean tableIsEmpty();
    void openChangeBalanceW(Button button);
    void acceptChanges(List<TextField> listOfTextField, List<RadioButton> radioButtonList);
    void updateW(Button button);
    void openPersonalW(Button button);
    ObservableList<Ticket> getDataFromDb(ObservableList<Ticket> ticket);
    String takeBalanceFromDB();
    String takeFirstNameFromDB();
    String takeLastNameFromDB();
    String takeLoginFromDB();
    String takePasswordFromDB();
    String takeMobileNumberFromDB();
    String takeGenderFromDB();
    boolean checkFieldsValue(List<TextField> listOfTextField, List<RadioButton> radioButtonList,
                             List<String> listOfOldTextField);
}
