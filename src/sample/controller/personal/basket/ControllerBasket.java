package sample.controller.personal.basket;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.animations.Shake;
import sample.entity.TableClassBasket;
import sample.repository.PersonalAreaRepository;
import sample.service.imp.BasketServiceImp;

public class ControllerBasket {


    BasketServiceImp basket = new BasketServiceImp();
    ObservableList<TableClassBasket> ticketInBasket = FXCollections.observableArrayList();


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button backToPersonalMenu;

    @FXML
    private TextField balanceTextField;

    @FXML
    private Button buyTicketButton;

    @FXML
    private TableView<TableClassBasket> tableWithTickets;

    @FXML
    private TableColumn<TableClassBasket, String> numberTicketColumn;

    @FXML
    private TableColumn<TableClassBasket, String> nameExhibitionColumn;

    @FXML
    private TableColumn<TableClassBasket, String> dateColumn;

    @FXML
    private TableColumn<TableClassBasket, Integer> costColumn;

    @FXML
    private TextField numberTicketRemoveTextField;

    @FXML
    private Button openPersonalAreaButton;

    @FXML
    private Button removeTicketButton;

    @FXML
    private Label label;

    @FXML
    private Button acceptChangiesButton;

    @FXML
    private RadioButton nameExhibitRadioButton;

    @FXML
    private ToggleGroup RadioButton;

    @FXML
    private javafx.scene.control.RadioButton numberTicketRadioButton;

    @FXML
    private TextField nameExhibRemoveTextField;

    @FXML
    private TextField numberTicketRemoveTickTextField;


    @FXML
    void initialize() {
        initializeTicketsTableBasket();
        balanceTextField.setText(PersonalAreaRepository.takeBalance());

        buyTicketButton.setOnAction(actionEvent -> {
            if (basket.tableIsEmpty()) {
                label.setStyle("-fx-text-fill: #fa0000");
                label.setText("Таблица пуста");
            } else {
                if (!basket.checkBalance()) {
                    setLabelRed(balanceTextField, "Нехватает средств");
                } else {
                    basket.buyTickets();
                    basket.updateWindow(buyTicketButton);
                }
            }
        });

        openPersonalAreaButton.setOnAction(actionEvent -> {
            basket.openPersonalAreaW(openPersonalAreaButton);
        });

        backToPersonalMenu.setOnAction(actionEvent -> {
            basket.openPersonalW(backToPersonalMenu);
        });

        removeTicketButton.setOnAction(actionEvent -> {
            numberTicketRadioButton.setVisible(true);
            nameExhibitRadioButton.setVisible(true);
        });

        numberTicketRadioButton.setOnAction(actionEvent -> {
            numberTicketRemoveTextField.setVisible(true);
            nameExhibRemoveTextField.setVisible(false);
            numberTicketRemoveTickTextField.setVisible(false);
        });

        nameExhibitRadioButton.setOnAction(actionEvent -> {
            nameExhibRemoveTextField.setVisible(true);
            numberTicketRemoveTickTextField.setVisible(true);
            numberTicketRemoveTextField.setVisible(false);
        });

        numberTicketRemoveTextField.setOnAction(actionEvent -> {
            if (basket.tableIsEmpty()) {
                label.setStyle("-fx-text-fill: #fa0000");
                label.setText("Таблица пустая");
            } else {
                if (numberTicketRemoveTextField.getText().isEmpty()) {
                    setLabelRed(numberTicketRemoveTextField, "Неправильный номер");
                } else {
                    String numberTicket = numberTicketRemoveTextField.getText();
                    if (!basket.checkNumberTicket(numberTicket)) {
                        setLabelRed(numberTicketRemoveTextField, "Нет такого номера");
                    } else {
                        acceptChangiesButton.setVisible(true);
                    }
                }
            }
        });

        nameExhibRemoveTextField.setOnAction(actionEvent -> {
            numberTicketRemoveTickTextField.setDisable(true);
            if (basket.tableIsEmpty()) {
                label.setStyle("-fx-text-fill: #fa0000");
                label.setText("Таблица пустая");
            } else {
                if (nameExhibRemoveTextField.getText().isEmpty()) {
                    setLabelRed(nameExhibRemoveTextField, "Неправильое название");
                } else {
                    String exhibitionName = nameExhibRemoveTextField.getText();
                    if (!basket.checkExhibitionName(exhibitionName)) {
                        setLabelRed(nameExhibRemoveTextField, "Нет такого названия");
                    } else {
                        numberTicketRemoveTickTextField.setDisable(false);
                    }
                }
            }
        });

        numberTicketRemoveTickTextField.setOnAction(actionEvent -> {
            if (!checkNumberTicket()) {
               setLabelRed(numberTicketRemoveTickTextField, "Неправильное количество");
            } else {
                String ticketNumber = numberTicketRemoveTickTextField.getText();
                if (!basket.checkCountNumberTicket(nameExhibRemoveTextField.getText(), ticketNumber)) {
                    setLabelRed(numberTicketRemoveTickTextField, "Количесвто превышает лимит");
                } else {
                    acceptChangiesButton.setVisible(true);
                }
            }

        });

        acceptChangiesButton.setOnAction(actionEvent -> {
            if (numberTicketRemoveTextField.isVisible()) {
                basket.removeTicketByNumber(numberTicketRemoveTextField.getText());
                basket.updateWindow(acceptChangiesButton);
            }

            if (nameExhibRemoveTextField.isVisible()) {
                basket.removeAmountTicketByName(nameExhibRemoveTextField.getText(),
                        numberTicketRemoveTickTextField.getText());
                basket.updateWindow(acceptChangiesButton);
            }
        });


    }


    private void initializeTicketsTableBasket() {
        ticketInBasket = basket.getDateFrDb(ticketInBasket);

        numberTicketColumn.setCellValueFactory(new PropertyValueFactory<>("numberTicket"));
        nameExhibitionColumn.setCellValueFactory(new PropertyValueFactory<>("exhibitionName"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("data"));
        costColumn.setCellValueFactory(new PropertyValueFactory<>("cost"));

        tableWithTickets.setItems(ticketInBasket);
    }

    private void shakeField(TextField textField) {
        Shake field = new Shake(textField);
        field.playAnim();
    }

    private boolean checkNumberTicket() {
        if (!numberTicketRemoveTickTextField.getText().isEmpty()) {
            return numberTicketRemoveTickTextField.getText().matches("[\\d]+");
        }
        return false;
    }

    private void setLabelRed(TextField textField, String str) {
        shakeField(textField);
        label.setStyle("-fx-text-fill: #fa0000");
        label.setText(str);
    }

}
