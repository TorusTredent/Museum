package sample.controller.personal.personalArea;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import sample.entity.Ticket;
import sample.service.imp.PersonalAreaServiceImp;

public class ControllerWPersonalArea {

    ObservableList<Ticket> ticket = FXCollections.observableArrayList();
    PersonalAreaServiceImp personal = new PersonalAreaServiceImp();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField firstNameTextField;

    @FXML
    public Button addBalanceButton;

    @FXML
    private ToggleGroup RadioButton;

    @FXML
    private RadioButton maleRadioButton;

    @FXML
    private RadioButton femaleRadioButton;

    @FXML
    private TextField passwordTextField;

    @FXML
    private TextField lastNameTextField;

    @FXML
    private TextField mobileNumberTextField;

    @FXML
    public Button acceptButton;

    @FXML
    public TableView<Ticket> table;

    @FXML
    private TableColumn<Ticket, String> columnNumberOfTicket;

    @FXML
    private TableColumn<Ticket, String> columnDate;

    @FXML
    private TableColumn<Ticket, String> columnName;

    @FXML
    private TextField loginTextField;

    @FXML
    private TextField balanceTextField;

    @FXML
    private Button backToMenuButton;

    @FXML
    void initialize() {

        loginTextField.setText(personal.takeLoginFromDB());
        firstNameTextField.setText(personal.takeFirstNameFromDB());
        lastNameTextField.setText(personal.takeLastNameFromDB());
        passwordTextField.setText(personal.takePasswordFromDB());
        mobileNumberTextField.setText(personal.takeMobileNumberFromDB());

        List<TextField> listOfOldTextField = new ArrayList<>();
        listOfOldTextField.add(firstNameTextField);
        listOfOldTextField.add(lastNameTextField);
        listOfOldTextField.add(loginTextField);
        listOfOldTextField.add(passwordTextField);
        listOfOldTextField.add(mobileNumberTextField);

        List<RadioButton> listOfOldRadButton = new ArrayList<>();
        listOfOldRadButton.add(maleRadioButton);
        listOfOldRadButton.add(femaleRadioButton);

        if(personal.takeGenderFromDB().equals("мужской")) {
            maleRadioButton.fire();
        } else {
            femaleRadioButton.fire();
        }

        if (personal.tableIsEmpty()) {
            System.out.println("Таблица пустая");
        } else {
            initializeTicketsTable();
        }

        balanceTextField.setText(personal.takeBalanceFromDB());

        addBalanceButton.setOnAction(event -> {
            personal.openChangeBalanceW(addBalanceButton);
        });

        acceptButton.setOnAction(event -> {

            List<TextField> listOfTextField = new ArrayList<>();
            listOfTextField.add(firstNameTextField);
            listOfTextField.add(lastNameTextField);
            listOfTextField.add(loginTextField);
            listOfTextField.add(passwordTextField);
            listOfTextField.add(mobileNumberTextField);

            List<RadioButton> radioButtonList = new ArrayList<>();
            radioButtonList.add(maleRadioButton);
            radioButtonList.add(femaleRadioButton);

            if(!personal.checkFieldsValue(listOfTextField, radioButtonList, listOfOldTextField, listOfOldRadButton)) {
                System.out.println("Значения неверны");
            } else {
                personal.acceptChanges(listOfTextField, radioButtonList);
                personal.updateW(acceptButton);
            }
        });

        backToMenuButton.setOnAction(actionEvent -> {
            personal.openPersonalW(backToMenuButton);
        });
    }

    private void initializeTicketsTable() {
        ticket = personal.getDataFromDb(ticket);

        columnNumberOfTicket.setCellValueFactory(new PropertyValueFactory<> ("numberTicket"));
        columnDate.setCellValueFactory(new PropertyValueFactory<> ("date"));
        columnName.setCellValueFactory(new PropertyValueFactory<>("name"));

        table.setItems(ticket);
    }

    private void updateW() {
    }
}
