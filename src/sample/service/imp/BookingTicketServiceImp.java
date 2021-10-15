package sample.service.imp;

import javafx.scene.control.Button;
import sample.controller.ControllerHelper;
import sample.entity.TicketInBasket;
import sample.entity.User;
import sample.repository.BookingTicketRepository;
import sample.service.BookingTicketService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class BookingTicketServiceImp implements BookingTicketService {

    @Override
    public String getNameExhibitions(LocalDate date) {
        List<String> listOfNameExhibitions;
        listOfNameExhibitions = BookingTicketRepository.getAllDateExhibitions();
        List<LocalDate> tempAfter = new ArrayList<>();


        assert false;
        for (String listOfNameExhibition : listOfNameExhibitions) {
            if (date.isAfter(LocalDate.parse(listOfNameExhibition))) {
                tempAfter.add(LocalDate.parse(listOfNameExhibition));
            }
        }

        LocalDate resultDate = tempAfter.get(0);

        for (int i = 1; i < tempAfter.size(); i++) {
            if (resultDate.isBefore(tempAfter.get(i))) {
                resultDate = tempAfter.get(i);
            }
        }
        return BookingTicketRepository.getNameExhibition(resultDate.toString());
    }

    @Override
    public String getCostOfTicket(String exhibitName, String numberTicket, int numberColor) {
        int cost = BookingTicketRepository.getCostOfTicketByName(exhibitName);

        if (!checkValue(numberTicket)) {
            return null;
        }
        int numberOfTickets = Integer.parseInt(numberTicket);

        if (numberColor == 1) {
            return String.valueOf(cost * numberOfTickets + 2);
        }
        if (numberColor == 2) {
            return String.valueOf(cost * numberOfTickets);
        }
        if (numberColor == 3) {
            return String.valueOf(cost * numberOfTickets - 2);
        }

        return null;
    }

    @Override
    public void addToBasket(LocalDate data, String exhibitName, String amountTicket, String cost) {
        int trash;

        if(BookingTicketRepository.tableIsEmpty()) {
            String lastNumberTicket = BookingTicketRepository.getLastNumberTicket();
            trash = Integer.parseInt(lastNumberTicket) + 1;
        } else {
            String lastNumberTicketFromBasket = BookingTicketRepository.getLastNumberTicketBasket();
            trash = Integer.parseInt(lastNumberTicketFromBasket) + 1;
        }

        String numberTicket = String.valueOf(trash);
        String date = data.toString();
        int amount = Integer.parseInt(amountTicket);
        int price = Integer.parseInt(cost);
        TicketInBasket ticketInBasket = new TicketInBasket(numberTicket, date, exhibitName, amount, price, User.getId());
        BookingTicketRepository.addTicketToBasket(ticketInBasket);
    }

    @Override
    public void backToPersonalMenu(Button button) {
        String address = "/sample/view/personal/WindowPersonal.fxml";
        ControllerHelper.updateWindow(button, address);
    }

    private boolean checkValue(String numberTicket) {
        return numberTicket.matches("[\\d]+");
    }
}
