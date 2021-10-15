package sample.controller.personal.bookingTicket;

import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import sample.animations.Shake;
import sample.service.imp.BookingTicketServiceImp;

public class ControllerBookingTicket {

    BookingTicketServiceImp booking = new BookingTicketServiceImp();
    private int numberColor = 0;

    @FXML
    private Button addToBasketButton;

    @FXML
    private TextField exhibitionNameTextField;

    @FXML
    private TextField fieldColor;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button backToPersonalMenu;

    @FXML
    private TextField lowGreenTextField;

    @FXML
    private TextField mediumYellowTextField;

    @FXML
    private TextField bigRedTextField;

    @FXML
    private Label label;

    @FXML
    private TextField costTextField;

    @FXML
    private TextField amountTicketTextField;
    
    @FXML
    private DatePicker datePicker;


    @FXML
    void getDate(ActionEvent event) {
        try {
            changeBorderColor();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        LocalDate myDate = datePicker.getValue();
        String date = myDate.format(DateTimeFormatter.ofPattern("dd-MM-yy"));
        String exhibitionName = booking.getNameExhibitions(myDate);
        exhibitionNameTextField.setText(exhibitionName);
        amountTicketTextField.setText("");
        costTextField.setText("");
        addToBasketButton.setVisible(false);
    }

    @FXML
    void initialize() {
        configDatePicker();

        amountTicketTextField.setOnAction(actionEvent -> {
            String numberTicket = amountTicketTextField.getText();
            if (exhibitionNameTextField.getText().equals("")) {
                shakeField(exhibitionNameTextField);
                label.setText("Отсутствует выставка");
            } else {
                label.setText("");
                String total = booking.getCostOfTicket(exhibitionNameTextField.getText(), numberTicket, numberColor);
                if (total != null) {
                    costTextField.setText(total);
                    addToBasketButton.setVisible(true);
                } else {
                    label.setText("Неправильный ввод");
                    costTextField.setText("");
                    shakeField(amountTicketTextField);
                }
            }
        });

        addToBasketButton.setOnAction(actionEvent -> {
            booking.addToBasket(datePicker.getValue(), exhibitionNameTextField.getText(),
                    amountTicketTextField.getText(), costTextField.getText());
            label.setText("Добавление выполнено");
        });

        backToPersonalMenu.setOnAction(actionEvent -> {
            booking.backToPersonalMenu(backToPersonalMenu);
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

    private void changeBorderColor() throws ParseException {
        LocalDate myDate = datePicker.getValue();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy", java.util.Locale.ENGLISH);
        String stringDate = myDate.format(DateTimeFormatter.ofPattern("dd/MM/yy"));
        Date date = sdf.parse(stringDate);
        sdf.applyPattern("EEE");
        String sMyDate = sdf.format(date);

        switch (sMyDate) {
            case "Mon", "Wed" -> {
                changeBorderToGreen();
            }
            case "Tue", "Thu" -> {
                changeBorderToYellow();
            }
            case "Fri", "Sun", "Sat" -> {
                changeBorderToRed();
            }
        }
    }

    private void changeBorderToRed() {
        numberColor = 1;
        datePicker.setStyle("-fx-border-color: #ff5c58");
        exhibitionNameTextField.setStyle("-fx-background-radius: 12;-fx-border-radius: 12; -fx-border-color: #ff5c58");
        amountTicketTextField.setStyle("-fx-background-radius: 12;-fx-border-radius: 12; -fx-border-color: #ff5c58");
        fieldColor.setStyle("-fx-background-color: #ff5c58");
    }

    private void changeBorderToYellow() {
        numberColor = 2;
        datePicker.setStyle("-fx-border-color: #fbe226");
        exhibitionNameTextField.setStyle("-fx-background-radius: 12;-fx-border-radius: 12; -fx-border-color: #fbe226");
        amountTicketTextField.setStyle("-fx-background-radius: 12;-fx-border-radius: 12; -fx-border-color: #fbe226");
        fieldColor.setStyle("-fx-background-color: #fbe226");
    }

    private void changeBorderToGreen() {
        numberColor = 3;
        datePicker.setStyle("-fx-background-color: #097240");
        exhibitionNameTextField.setStyle("-fx-background-radius: 12;-fx-border-radius: 12; -fx-border-color: #097240");
        amountTicketTextField.setStyle("-fx-background-radius: 12;-fx-border-radius: 12; -fx-border-color: #097240");
        fieldColor.setStyle("-fx-background-color: #097240");
    }

    private void shakeField(TextField textField) {
        Shake field = new Shake(textField);
        field.playAnim();
    }
}
