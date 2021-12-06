package sample.service.imp;

import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import sample.controller.ControllerHelper;
import sample.entity.TableClassBasket;
import sample.repository.BasketRepository;
import sample.repository.ChangeBalanceRepository;
import sample.repository.PersonalAreaRepository;
import sample.service.BasketService;

import java.util.List;


public class BasketServiceImp implements BasketService {

    @Override
    public boolean checkExhibitionName(String nameExhibition) {
        if (!BasketRepository.checkExhibitionName(nameExhibition)) {
            return false;
        } else {
            int exhibitionId = getExhibitionId(nameExhibition);
            return BasketRepository.checkTicketByExhibitionId(exhibitionId);
        }
    }

    @Override
    public boolean checkCountNumberTicket(String exhibitionName, String ticketNumber) {
        int exhibitionId = getExhibitionId(exhibitionName);
        int countTickets = BasketRepository.getCountTicket(exhibitionId);
        return Integer.parseInt(ticketNumber) <= countTickets;

    }

    @Override
    public void removeAmountTicketByName(String nameExhibition, String amount) {
        int exhibitionId = getExhibitionId(nameExhibition);
        int amountTicket = Integer.parseInt(amount);

        for (int i = 0; i < amountTicket; i++) {
            BasketRepository.removeTicketByExhibitionId(exhibitionId);
        }
    }

    @Override
    public boolean checkNumberTicket(String numberTicket) {
        return BasketRepository.checkNumberTicket(numberTicket);
    }

    @Override
    public void removeTicketByNumber(String numberTicket) {
        BasketRepository.removeTicketByName(numberTicket);
    }

    @Override
    public boolean tableIsEmpty() {
        return BasketRepository.tableIsEmpty();
    }

    @Override
        public ObservableList<TableClassBasket> getDateFrDb(ObservableList<TableClassBasket> ticketInBasket) {
        return BasketRepository.getData(ticketInBasket);
    }


    @Override
    public boolean checkBalance() {
        String userBalance = PersonalAreaRepository.takeBalance();
        int userIntBalance = Integer.parseInt(userBalance);

        int costTickets = BasketRepository.takeCostAllTicketsInBasket();

        return userIntBalance > costTickets;
    }

    @Override
    public void buyTickets() {
        List<Integer> ticketsId = BasketRepository.getListTicketsId();

        for (int id : ticketsId) {
            String numberTicket = BasketRepository.getNumberTicket(id);
            int exhibitionId = BasketRepository.getExhibitionIdById(id);
            int exhibitionPrice = BasketRepository.getExhibitionPrice(id);
            BasketRepository.addTicket(numberTicket, exhibitionId, exhibitionPrice);
        }

        changeBalance();

        BasketRepository.removeAllTicketsInBasket();
    }

    @Override
    public void updateWindow(Button button) {
        String address = "/sample/view/personal/basket/WindowBasket.fxml";
        ControllerHelper.updateWindow(button, address);
    }

    @Override
    public void openPersonalAreaW(Button button) {
        String address = "/sample/view/personal/personalArea/WindowPersonalArea.fxml";
        ControllerHelper.updateWindow(button, address);
    }

    @Override
    public void openPersonalW(Button button) {
        String address = "/sample/view/personal/WindowPersonal.fxml";
        ControllerHelper.updateWindow(button, address);
    }

    private void changeBalance() {
        String userBalance = PersonalAreaRepository.takeBalance();
        int userIntBalance = Integer.parseInt(userBalance);
        int costTickets = BasketRepository.takeCostAllTicketsInBasket();

        int newBalance = userIntBalance - costTickets;

        ChangeBalanceRepository.addBalance(String.valueOf(newBalance));
    }

    private int getExhibitionId(String exhibitionName) {
        return BasketRepository.getExhibitionIdByName(exhibitionName);
    }
}
