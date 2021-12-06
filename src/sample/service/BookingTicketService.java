package sample.service;

import javafx.scene.control.Button;

import java.time.LocalDate;

public interface BookingTicketService {
    String getNameExhibitions(LocalDate date);
    String getCostOfTicket(String exhibitName, String numberTicket, int numberColor);
    void backToPersonalMenu(Button button);
    void addToBasket(LocalDate data, String exhibitName, String amountTicket, String cost);

}
