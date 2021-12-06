package sample.repository;

import javafx.collections.ObservableList;
import sample.entity.*;
import sample.repository.configs.Configs;
import sample.repository.configs.Const;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BasketRepository extends Configs {

    public static ObservableList<TableClassBasket> getData(ObservableList<TableClassBasket> ticketInBasket) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, username, password)) {

                String query = "SELECT " + Const.TICKET_IN_BASKET_NUMBER + ", " + Const.EXHIBITION_NAME + ", " +
                        Const.TICKET_IN_BASKET_DATA + ", " + Const.TICKET_IN_BASKET_COST + " FROM " +
                        Const.TICKETS_IN_BASKET_TABLE + " LEFT JOIN exhibition e on e.id = tickets_in_basket.exhibition_id" +
                        " WHERE " + Const.TICKET_IN_BASKET_USER_ID + " = " + User.getId() + "";

                try (Statement statement = connection.createStatement()) {
                    ResultSet rs = statement.executeQuery(query);
                    while (rs.next()) {
                        ticketInBasket.add(new TableClassBasket(rs.getString(1), rs.getString(2),
                                rs.getString(3), rs.getInt(4)));
                    }
                    return ticketInBasket;
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public static int takeCostAllTicketsInBasket() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, username, password)) {

                String query = "SELECT " + Const.TICKET_IN_BASKET_COST + " FROM " + Const.TICKETS_IN_BASKET_TABLE +
                        " WHERE " + Const.TICKET_IN_BASKET_USER_ID + " = " + User.getId() + "";

                try (Statement statement = connection.createStatement()) {
                    ResultSet rs = statement.executeQuery(query);
                    int sum = 0;
                    while (rs.next()) {
                        sum += rs.getInt(1);
                    }
                    return sum;
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
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

    public static boolean checkExhibitionName(String exhibitionName) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, username, password)) {

                String query = "SELECT * FROM " + Const.EXHIBITION_TABLE + " WHERE " + Const.EXHIBITION_NAME +
                        " = '" + exhibitionName + "'";

                try (Statement statement = connection.createStatement()) {
                    ResultSet rs = statement.executeQuery(query);
                    return rs.next();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean checkNumberTicket(String numberTicket) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, username, password)) {

                String query = "SELECT * FROM " + Const.TICKETS_IN_BASKET_TABLE + " WHERE " + Const.TICKET_IN_BASKET_USER_ID +
                        " = " + User.getId() + " AND " + Const.TICKET_IN_BASKET_NUMBER + " = '" + numberTicket + "'";

                try (Statement statement = connection.createStatement()) {
                    ResultSet rs = statement.executeQuery(query);
                    return rs.next();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void addTicket(String numberTicket, int exhibitionId, int exhibitionPrice) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, username, password)) {

                String query = "INSERT INTO " + Const.TICKETS_TABLE + "(" + Const.TICKET_NUMBER + ", " +
                        Const.TICKET_USER_ID + ", " + Const.TICKET_EXHIBITION_ID + ", " + Const.TICKET_COST + ") " +
                        "VALUES (?, ?, ?, ?)";

                try (PreparedStatement prep = connection.prepareStatement(query)) {
                    prep.setString(1, numberTicket);
                    prep.setInt(2, User.getId());
                    prep.setInt(3, exhibitionId);
                    prep.setInt(4, exhibitionPrice);

                    prep.execute();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void removeAllTicketsInBasket() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, username, password)) {

                String query = "DELETE FROM " + Const.TICKETS_IN_BASKET_TABLE + " WHERE " +
                        Const.TICKET_IN_BASKET_USER_ID + " = " + User.getId() + "";

                try(Statement statement = connection.createStatement()) {
                    statement.execute(query);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void removeTicketByName(String numberTicket) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, username, password)) {

                String query = "DELETE FROM " + Const.TICKETS_IN_BASKET_TABLE + " WHERE " +
                        Const.TICKET_IN_BASKET_USER_ID + " = " + User.getId() + " AND " + Const.TICKET_IN_BASKET_NUMBER +
                        " = '" + numberTicket + "'";

                try(Statement statement = connection.createStatement()) {
                    statement.execute(query);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Integer> getListTicketsId() {
        List<Integer> list = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, username, password)) {

                String query = "SELECT " + Const.TICKET_IN_BASKET_ID + " FROM " + Const.TICKETS_IN_BASKET_TABLE +
                        " WHERE " + Const.TICKET_IN_BASKET_USER_ID + " = " + User.getId() + "";

                try (Statement statement = connection.createStatement()) {
                    ResultSet rs = statement.executeQuery(query);
                    while (rs.next()) {
                        list.add(rs.getInt(1));
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

    public static String getNumberTicket(int id) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, username, password)) {

                String query = "SELECT " + Const.TICKET_IN_BASKET_NUMBER + " FROM " + Const.TICKETS_IN_BASKET_TABLE +
                        " WHERE " + Const.TICKET_IN_BASKET_ID + " = " + id + "";

                try (Statement statement = connection.createStatement()) {
                    ResultSet rs = statement.executeQuery(query);
                    if (rs.next()) {
                        return rs.getString(1);
                    }
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static int getExhibitionIdById(int id) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, username, password)) {

                String query = "SELECT " + Const.TICKET_IN_BASKET_EXHIBITION_ID + " FROM " + Const.TICKETS_IN_BASKET_TABLE +
                        " WHERE " + Const.TICKET_IN_BASKET_ID + " = " + id + "";

                try (Statement statement = connection.createStatement()) {
                    ResultSet rs = statement.executeQuery(query);
                    if (rs.next()) {
                        return rs.getInt(1);
                    }
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static int getExhibitionPrice(int id) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, username, password)) {

                String query = "SELECT " + Const.TICKET_IN_BASKET_COST + " FROM " + Const.TICKETS_IN_BASKET_TABLE +
                        " WHERE " + Const.TICKET_IN_BASKET_ID + " = " + id + "";

                try (Statement statement = connection.createStatement()) {
                    ResultSet rs = statement.executeQuery(query);
                    if (rs.next()) {
                        return rs.getInt(1);
                    }
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static int getExhibitionIdByName(String exhibitionName) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, username, password)) {

                String query = "SELECT " + Const.EXHIBITION_ID + " FROM " + Const.EXHIBITION_TABLE +
                        " WHERE " + Const.EXHIBITION_NAME + " = '" + exhibitionName + "'";

                try (Statement statement = connection.createStatement()) {
                    ResultSet rs = statement.executeQuery(query);
                    if (rs.next()) {
                        return rs.getInt(1);
                    }
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static boolean checkTicketByExhibitionId(int exhibitionId) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, username, password)) {

                String query = "SELECT * FROM " + Const.TICKETS_IN_BASKET_TABLE + " WHERE " +
                        Const.TICKET_IN_BASKET_USER_ID + " = " + User.getId() + " AND " +
                        Const.TICKET_IN_BASKET_EXHIBITION_ID + " = " + exhibitionId + "";

                try (Statement statement = connection.createStatement()) {
                    ResultSet rs = statement.executeQuery(query);
                    return rs.next();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static int getCountTicket(int exhibitionId) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, username, password)) {

                String query = "SELECT * FROM " + Const.TICKETS_IN_BASKET_TABLE + " WHERE " +
                        Const.TICKET_IN_BASKET_USER_ID + " = " + User.getId() + " AND " +
                        Const.TICKET_IN_BASKET_EXHIBITION_ID + " = " + exhibitionId + "";

                try (Statement statement = connection.createStatement()) {
                    ResultSet rs = statement.executeQuery(query);
                    int count = 0;
                    while (rs.next()) {
                        count++;
                    }
                    return count;
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static void removeTicketByExhibitionId(int exhibitionId) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, username, password)) {

                String query = "DELETE FROM " + Const.TICKETS_IN_BASKET_TABLE + " WHERE " +
                        Const.TICKET_IN_BASKET_USER_ID + " = " + User.getId() + " AND " +
                        Const.TICKET_IN_BASKET_EXHIBITION_ID + " = " + exhibitionId + " LIMIT 1";

                try(Statement statement = connection.createStatement()) {
                    statement.execute(query);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
