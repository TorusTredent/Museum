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
import sample.animations.Shake;
import sample.entity.TableClassPersonalArea;
import sample.entity.Ticket;
import sample.service.imp.PersonalAreaServiceImp;

public class ControllerWPersonalArea {

    ObservableList<TableClassPersonalArea> ticket = FXCollections.observableArrayList();
    PersonalAreaServiceImp personal = new PersonalAreaServiceImp();

    @FXML
    private Label label;

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
    public TableView<TableClassPersonalArea> table;

    @FXML
    private TableColumn<TableClassPersonalArea, String> columnNumberOfTicket;

    @FXML
    private TableColumn<TableClassPersonalArea, String> columnDate;

    @FXML
    private TableColumn<TableClassPersonalArea, String> columnName;

    @FXML
    private TextField loginTextField;

    @FXML
    private TextField balanceTextField;

    @FXML
    private Button backToMenuButton;

    @FXML
    void initialize() {
        List<String> listOfOldTextField = new ArrayList<>();

        loginTextField.setText(personal.takeLoginFromDB());
        firstNameTextField.setText(personal.takeFirstNameFromDB());
        lastNameTextField.setText(personal.takeLastNameFromDB());
        passwordTextField.setText(personal.takePasswordFromDB());
        mobileNumberTextField.setText(personal.takeMobileNumberFromDB());

        listOfOldTextField.add(personal.takeLoginFromDB());
        listOfOldTextField.add(personal.takeMobileNumberFromDB());

        if(personal.takeGenderFromDB().equals("мужской")) {
            maleRadioButton.fire();
        } else {
            femaleRadioButton.fire();
        }

        if (!personal.tableIsEmpty()) {
            initializeTicketsTable();
        }

        balanceTextField.setText(personal.takeBalanceFromDB());

        addBalanceButton.setOnAction(event -> {
            personal.openChangeBalanceW(addBalanceButton);
            acceptButton.setVisible(true);
        });

        loginTextField.setOnAction(actionEvent -> {
            acceptButton.setVisible(true);
        });

        firstNameTextField.setOnAction(actionEvent -> {
            acceptButton.setVisible(true);
        });

        lastNameTextField.setOnAction(actionEvent -> {
            acceptButton.setVisible(true);
        });

        passwordTextField.setOnAction(actionEvent -> {
            acceptButton.setVisible(true);
        });

        mobileNumberTextField.setOnAction(actionEvent -> {
            acceptButton.setVisible(true);
        });

        maleRadioButton.setOnAction(actionEvent -> {
           acceptButton.setVisible(true);
        });

        femaleRadioButton.setOnAction(actionEvent -> {
            acceptButton.setVisible(true);
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

            if(personal.checkFieldsValue(listOfTextField, radioButtonList, listOfOldTextField)) {
                personal.acceptChanges(listOfTextField, radioButtonList);
                personal.updateW(acceptButton);
            } else {
                setLabelRed("Данные уже используются");
            }
        });

        backToMenuButton.setOnAction(actionEvent -> {
            personal.openPersonalW(backToMenuButton);
        });
    }

    private void initializeTicketsTable() {
        ticket = personal.getDataFromDb(ticket);

        columnNumberOfTicket.setCellValueFactory(new PropertyValueFactory<> ("numberTicket"));
        columnDate.setCellValueFactory(new PropertyValueFactory<> ("data"));
        columnName.setCellValueFactory(new PropertyValueFactory<>("exhibitionName"));

        table.setItems(ticket);
    }

    private void shakeField(TextField textField) {
        Shake shake = new Shake(textField);
        shake.playAnim();
    }

    private void setLabelRedShake(TextField textField, String str) {
        shakeField(textField);
        label.setStyle("-fx-text-fill: #fa0000");
        label.setText(str);
    }

    private void setLabelRed(String str) {
        label.setStyle("-fx-text-fill: #fa0000");
        label.setText(str);
    }
}
