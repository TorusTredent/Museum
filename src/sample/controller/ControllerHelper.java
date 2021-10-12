package sample.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sample.Main;

import java.io.IOException;

public class ControllerHelper {

    public static void setNewWindow(String address) {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource(address));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Stage stage = new Stage();
        stage.setScene(new Scene(loader.getRoot()));
        stage.setTitle("Museum");
        stage.getIcons().add(new Image("sample/assets/Icon_Museum.jpg"));
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();
        stage.centerOnScreen();
    }

    public static void updateWindow(Button button, String address) {
        Stage stage = (Stage) button.getScene().getWindow();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource(address));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        stage.setScene(new Scene(loader.getRoot()));
        stage.setTitle("Museum");
        stage.getIcons().add(new Image("sample/assets/Icon_Museum.jpg"));
        stage.show();
    }

    public static void closeWindow(Button button) {
        Stage stage = (Stage) button.getScene().getWindow();
        stage.close();
    }
}
