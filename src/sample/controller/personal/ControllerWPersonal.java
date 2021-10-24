package sample.controller.personal;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import sample.service.imp.PersonalWServiceImp;

public class ControllerWPersonal {

    @FXML
    private Button aboutMuseumButton;

    @FXML
    private Button checkPictPauloRegoWButton;

    @FXML
    private Button checkStreetArtWButton ;

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
    private Button orderTicketsPersWButton;

    @FXML
    private Button exitPersWButton;

    @FXML
    void initialize() {
        PersonalWServiceImp person = new PersonalWServiceImp();

        personalAreaPersWButton.setOnAction(event -> {
            person.openNewW(personalAreaPersWButton, "/sample/view/personal/personalArea/WindowPersonalArea.fxml");
        });

        allExhibitionsPersWButton.setOnAction(event -> {
           person.openNewW(allExhibitionsPersWButton, "/sample/view/personal/allExhibitions/WindowAllExhibitions.fxml");
        });

        orderTicketsPersWButton.setOnAction(event -> {
            person.openNewW(orderTicketsPersWButton, "/sample/view/personal/bookingTicket/WindowBookingTicket.fxml");
        });

        basketPersWButton.setOnAction(event -> {
            person.openNewW(basketPersWButton, "/sample/view/personal/basket/WindowBasket.fxml");
        });

        checkStreetArtWButton.setOnAction(event -> {
            person.openNewW(basketPersWButton, "/sample/view/personal/allExhibitions/exhibitions/WindowStreetArt.fxml");
        });

        checkPictPauloRegoWButton.setOnAction(event -> {
            person.openNewW(basketPersWButton, "/sample/view/personal/allExhibitions/exhibitions/WindowPaulRego.fxml");
        });

        exitPersWButton.setOnAction(event -> {
            person.backToSingUpW(exitPersWButton);
        });

    }
}
