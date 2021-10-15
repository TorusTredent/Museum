package sample.repository;

import sample.entity.TicketInBasket;
import sample.entity.User;
import sample.repository.configs.Configs;
import sample.repository.configs.Const;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookingTicketRepository extends Configs {

    public static List<String> getAllDateExhibitions() {
        List<String> list = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, username, password)) {

                String query = "SELECT " + Const.EXHIBITION_DATE + " FROM " + Const.EXHIBITION_TABLE + "";

                try (Statement statement = connection.createStatement()) {
                    ResultSet rs = statement.executeQuery(query);
                    while (rs.next()) {
                        list.add(rs.getString(1));
                    }
                    return list;
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getNameExhibition(String date) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, username, password)) {

                String query = "SELECT " + Const.EXHIBITION_NAME + " FROM " + Const.EXHIBITION_TABLE + " WHERE " +
                        Const.EXHIBITION_DATE + " = '" + date + "'";

                try (Statement statement = connection.createStatement()) {
                    ResultSet rs = statement.executeQuery(query);
                    if (rs.next()) {
                        return rs.getString(1);
                    }
                }
            } catch (SQLException se) {
                throw new RuntimeException(se);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public static int getCostOfTicketByName(String exhibitionName) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, username, password)) {

                String query = "SELECT " + Const.EXHIBITION_PRICE + " FROM " + Const.EXHIBITION_TABLE + " WHERE " +
                        Const.EXHIBITION_NAME + " = '" + exhibitionName + "'";

                try (Statement statement = connection.createStatement()) {
                    ResultSet rs = statement.executeQuery(query);
                    if (rs.next()) {
                        return rs.getInt(1);
                    }
                }
            } catch (SQLException se) {
                throw new RuntimeException(se);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return 0;
    }

    public static void addTicketToBasket(TicketInBasket ticketInBasket) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, username, password)) {

                String query = "INSERT INTO " + Const.TICKETS_IN_BASKET_TABLE + "(" + Const.TICKET_IN_BASKET_DATA + ", " +
                        Const.TICKET_IN_BASKET_EXHIBITION_NAME + ", " + Const.TICKET_IN_BASKET_AMOUNT + ", " +
                        Const.TICKET_IN_BASKET_COST + ", " + Const.TICKET_IN_BASKET_NUMBER + ", " +
                        Const.TICKET_IN_BASKET_USER_ID + ") " + "VALUES (?, ?, ?, ?, ?, ?)";

                try (PreparedStatement prep = connection.prepareStatement(query)) {
                    prep.setString(1, ticketInBasket.getData());
                    prep.setString(2, ticketInBasket.getExhibitionName());
                    prep.setInt(3, ticketInBasket.getAmountTicket());
                    prep.setInt(4, ticketInBasket.getCost());
                    prep.setString(5, ticketInBasket.getNumberTicket());
                    prep.setInt(6, ticketInBasket.getUserId());
                    prep.execute();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getLastNumberTicket() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, username, password)) {

                String query = "SELECT " + Const.TICKET_NUMBER + " FROM " + Const.TICKETS_TABLE + "";

                try (Statement statement = connection.createStatement()) {
                    ResultSet rs = statement.executeQuery(query);
                    while (rs.next()) {
                        if (rs.isLast()) {
                            return rs.getString(1);
                        }
                    }
                }
            } catch (SQLException se) {
                throw new RuntimeException(se);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public static String getLastNumberTicketBasket() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, username, password)) {

                String query = "SELECT " + Const.TICKET_IN_BASKET_NUMBER + " FROM " + Const.TICKETS_IN_BASKET_TABLE +
                        " WHERE " + Const.TICKET_IN_BASKET_USER_ID + " = " + User.getId() + "";

                try (Statement statement = connection.createStatement()) {
                    ResultSet rs = statement.executeQuery(query);
                    while (rs.next()) {
                        if (rs.isLast()) {
                            return rs.getString(1);
                        }
                    }
                }
            } catch (SQLException se) {
                throw new RuntimeException(se);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public static boolean tableIsEmpty() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, username, password)) {

                String query = "SELECT * FROM " + Const.TICKETS_IN_BASKET_TABLE + " WHERE " + Const.TICKET_IN_BASKET_USER_ID +
                        " = " + User.getId() + "";

                try (Statement statement = connection.createStatement()) {
                    ResultSet rs = statement.executeQuery(query);
                    return !rs.next();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
