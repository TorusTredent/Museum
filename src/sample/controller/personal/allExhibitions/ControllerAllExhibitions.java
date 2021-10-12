package sample.controller.personal.allExhibitions;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import sample.service.imp.AllExhibitionsServiceImp;

public class ControllerAllExhibitions {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField userNameRWField;

    @FXML
    private TextField userNameRWField1;

    @FXML
    private TextField userNameRWField11;

    @FXML
    private TextField userNameRWField2;

    @FXML
    private TextField userNameRWField111;

    @FXML
    private TextField userNameRWField21;

    @FXML
    private TextField userNameRWField1111;

    @FXML
    private TextField userNameRWField211;

    @FXML
    private TextField userNameRWField11111;

    @FXML
    private TextField userNameRWField2111;

    @FXML
    private Button openStreetArtWButton;

    @FXML
    private Button openPainting19VWButton;

    @FXML
    private Button openModernisityWButton;

    @FXML
    private Button openCollectShukiniWButton;

    @FXML
    private Button openGalSatchiWButton;

    @FXML
    private Button backToPersonalWButton;

    @FXML
    void initialize() {
        AllExhibitionsServiceImp allExhs = new AllExhibitionsServiceImp();

        openStreetArtWButton.setOnAction(actionEvent -> {
            allExhs.openNewW(openStreetArtWButton, "/sample/view/personal/allExhibitions/exhibitions/WindowStreetArt.fxml");
        });

        openPainting19VWButton.setOnAction(actionEvent -> {
            allExhs.openNewW(openPainting19VWButton, "/sample/view/personal/allExhibitions/exhibitions/WindowPaintings19V.fxml");
        });

        openModernisityWButton.setOnAction(actionEvent -> {
            allExhs.openNewW(openModernisityWButton,"/sample/view/personal/allExhibitions/exhibitions/WindowModernisty.fxml");
        });

        openCollectShukiniWButton.setOnAction(actionEvent -> {
            allExhs.openNewW(openCollectShukiniWButton, "/sample/view/personal/allExhibitions/exhibitions/WindowCollectionShukini.fxml");
        });

        backToPersonalWButton.setOnKeyPressed(keyEvent -> {
            if (keyEvent.getCode().equals(KeyCode.ESCAPE)) {
                allExhs.backToPersonalW(backToPersonalWButton);
            }
        });
    }
}
