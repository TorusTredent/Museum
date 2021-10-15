package sample.controller.personal;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import sample.service.imp.PersonalWServiceImp;

public class ControllerWPersonal {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button basketPersWButton;

    @FXML
    private Button allExhibitionsPersWButton;

    @FXML
    private Button personalAreaPersWButton;

    @FXML
    private Button comingExPersWButton;

    @FXML
    private Button orderTicketsPersWButton;

    @FXML
    private Button exitPersWButton;

    @FXML
    private Button checkPictExPersWButton;

    @FXML
    private Button checkDecorExPersWButton;

    @FXML
    void initialize() {
        PersonalWServiceImp person = new PersonalWServiceImp();

        personalAreaPersWButton.setOnAction(event -> {
            person.openNewW(personalAreaPersWButton, "/sample/view/personal/personalArea/WindowPersonalArea.fxml");
        });

        allExhibitionsPersWButton.setOnAction(event -> {
           person.openNewW(allExhibitionsPersWButton, "/sample/view/personal/allExhibitions/WindowAllExhibitions.fxml");
        });
//
//        comingExPersWButton.setOnAction(event -> {
//            person.openComingExhibitW(comingExPersWButton);
//        });
//
        orderTicketsPersWButton.setOnAction(event -> {
            person.openNewW(orderTicketsPersWButton, "/sample/view/personal/bookingTicket/WindowBookingTicket.fxml");
        });
//
//        basketPersWButton.setOnAction(event -> {
//            person.openBasketW(basketPersWButton);
//        });
//
//        checkPictExPersWButton.setOnAction(event -> {
//            person.checkPictW(checkPictExPersWButton);
//        });
//
//        checkDecorExPersWButton.setOnAction(event -> {
//            person.checkDecorW(checkDecorExPersWButton);
//        });
//
        exitPersWButton.setOnAction(event -> {
            person.backToSingUpW(exitPersWButton);
        });

    }
}
