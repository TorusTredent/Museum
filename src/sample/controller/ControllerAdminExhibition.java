package sample.controller;

import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import sample.service.imp.AdminServiceImp;

public class ControllerAdminExhibition {

    private final AdminServiceImp adminService = new AdminServiceImp();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button addExhibitionButton;

    @FXML
    private Button backAdminWButton;

    @FXML
    private TextField costTicketTextField;

    @FXML
    private DatePicker datePicker;

    @FXML
    private Label label;

    @FXML
    private TextField nameTextField;

    @FXML
    void getDate(ActionEvent event) {
    }

    @FXML
    void initialize() {
        configDatePicker();

        addExhibitionButton.setOnAction(actionEvent -> {
            String name = nameTextField.getText();
            String cost = costTicketTextField.getText();
            LocalDate myDate = datePicker.getValue();
            if (!name.equals("") && !cost.equals("") && myDate != null) {
                if (isNumberInteger(cost)) {
                    String date = myDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                    adminService.addExhibition(name, cost, date);
                    setLabelGreen("Выставка добавлена!");
                } else {
                    setLabelRed("Цена введена неверно!");
                }
            } else {
                setLabelRed("Введены неверные данные");
            }
        });

        backAdminWButton.setOnAction(actionEvent -> {
            adminService.openAdminW(backAdminWButton);
        });
    }


    private void configDatePicker() {
        datePicker.setDayCellFactory(param -> new DateCell() {
            @Override
            public void updateItem(LocalDate date, boolean empty) {
                super.updateItem(date, empty);
                setDisable(empty || date.compareTo(LocalDate.now()) < 0);
            }
        });

    }

    private void setLabelGreen(String str) {
        label.setStyle("-fx-text-fill: #097240");
        label.setText(str);
    }

    private void setLabelRed(String str) {
        label.setStyle("-fx-text-fill: #fa0000");
        label.setText(str);
    }

    private boolean isNumberInteger(String numberTicket) {
        return numberTicket.matches("[-+]?\\d+");
    }
}
