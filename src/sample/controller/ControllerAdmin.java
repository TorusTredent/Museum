package sample.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.entity.TableClassAdmin;
import sample.service.imp.AdminServiceImp;

public class ControllerAdmin {

    private ObservableList<TableClassAdmin> exhibitionList = FXCollections.observableArrayList();
    private final AdminServiceImp adminService = new AdminServiceImp();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button acceptChangiesButton;


    @FXML
    private TextField exibitionIdTextField;

    @FXML
    private Label label;

    @FXML
    private Button logOut;

    @FXML
    private TableView<TableClassAdmin> tableWithExhibition;

    @FXML
    private TableColumn<TableClassAdmin, Integer> numberExhibitionColumn;

    @FXML
    private TableColumn<TableClassAdmin, String> nameExhibitionColumn;

    @FXML
    private TableColumn<TableClassAdmin, String> dateColumn;

    @FXML
    private TableColumn<TableClassAdmin, Integer> costColumn;

    @FXML
    private Button openAdminExhibitionWindow;

    @FXML
    private Button removeExhibitionButton;


    @FXML
    void initialize() {
        initializeTicketsTableBasket();

        removeExhibitionButton.setOnAction(actionEvent -> {
            exibitionIdTextField.setVisible(true);
        });

        exibitionIdTextField.setOnAction(actionEvent -> {
            acceptChangiesButton.setVisible(true);
        });

        acceptChangiesButton.setOnAction(actionEvent -> {
            String id = exibitionIdTextField.getText();
            if (!id.equals("")) {
                if (isNumberInteger(id)) {
                    if (adminService.isExistExhibitionId(exibitionIdTextField.getText())) {
                        adminService.deleteExhibitionById(exibitionIdTextField.getText());
                        adminService.openAdminW(acceptChangiesButton);
                    } else {
                        setLabelRed("Такого id нет!");
                    }
                } else {
                    setLabelRed("Введен неверный id!");
                }
            } else {
                setLabelRed("Не введены данные");
            }
        });

        openAdminExhibitionWindow.setOnAction(event -> {
            adminService.openAdminExhibitionWindow(openAdminExhibitionWindow);
        });

        logOut.setOnAction(actionEvent -> {
            adminService.logOut(logOut);
        });
    }


    private void initializeTicketsTableBasket() {
        exhibitionList = adminService.getDateFrDb(exhibitionList);

        numberExhibitionColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameExhibitionColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        costColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

        tableWithExhibition.setItems(exhibitionList);
    }


    private void setLabelRed(String str) {
        label.setStyle("-fx-text-fill: #fa0000");
        label.setText(str);
    }

    private boolean isNumberInteger(String numberTicket) {
        return numberTicket.matches("[-+]?\\d+");
    }
}
