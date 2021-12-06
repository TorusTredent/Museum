package sample.repository.configs;

import sample.entity.User;

public class Const {


    public static final String getData = "SELECT " + Const.TICKET_IN_BASKET_NUMBER + ", " + Const.EXHIBITION_NAME + ", " +
            Const.TICKET_IN_BASKET_DATA + ", " + Const.TICKET_IN_BASKET_COST + " FROM " +
            Const.TICKETS_IN_BASKET_TABLE + " LEFT JOIN exhibition e on e.id = tickets_in_basket.exhibition_id" +
            " WHERE " + Const.TICKET_IN_BASKET_USER_ID + " = " + User.getId() + "";


    public static final String USER_TABLE = "users";

    public static final String USER_ID = "id";
    public static final String USER_FIRSTNAME = "firstName";
    public static final String USER_LASTNAME = "lastName";
    public static final String USER_USERNAME = "userName";
    public static final String USER_PASSWORD = "password";
    public static final String USER_GENDER = "gender";
    public static final String USER_MOBILENUMBER = "mobileNumber";
    public static final String USER_BALANCE = "balance";


    public static final String TICKETS_TABLE = "tickets";

    public static final String TICKET_ID = "id";
    public static final String TICKET_NUMBER = "numberTicket";
    public static final String TICKET_USER_ID = "user_id";
    public static final String TICKET_EXHIBITION_ID = "exhibition_id";
    public static final String TICKET_COST = "cost";




    public static final String EXHIBITION_TABLE = "exhibition";

    public static final String EXHIBITION_ID = "id";
    public static final String EXHIBITION_NAME = "name";
    public static final String EXHIBITION_DATE = "date";
    public static final String EXHIBITION_PRICE = "price";


    public static final String TICKETS_IN_BASKET_TABLE = "tickets_in_basket";

    public static final String TICKET_IN_BASKET_ID = "id";
    public static final String TICKET_IN_BASKET_DATA = "data";
    public static final String TICKET_IN_BASKET_EXHIBITION_ID = "exhibition_id";
    public static final String TICKET_IN_BASKET_AMOUNT = "amount_tickets";
    public static final String TICKET_IN_BASKET_COST = "cost";
    public static final String TICKET_IN_BASKET_NUMBER = "number_ticket";
    public static final String TICKET_IN_BASKET_USER_ID = "user_id";

}
