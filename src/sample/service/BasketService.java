package sample.service;

import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import sample.entity.TableClassBasket;

public interface BasketService {
    ObservableList<TableClassBasket> getDateFrDb(ObservableList<TableClassBasket> ticketInBasket);
    boolean checkBalance();
    void buyTickets();
    boolean tableIsEmpty();
    void updateWindow(Button button);
    void openPersonalAreaW(Button button);
    void openPersonalW(Button button);
    boolean checkNumberTicket(String numberTicket);
    void removeTicketByNumber(String numberTicket);
    void removeAmountTicketByName(String nameExhibition, String amount);
    boolean checkExhibitionName(String nameExhibition);
    boolean checkCountNumberTicket(String exhibitionName, String ticketNumber);
}
