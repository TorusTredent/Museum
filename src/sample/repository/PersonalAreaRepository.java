package sample.repository;

import javafx.collections.ObservableList;
import javafx.scene.control.TextField;
import sample.entity.Ticket;
import sample.entity.User;
import sample.repository.configs.Configs;
import sample.repository.configs.Const;

import java.sql.*;
import java.util.List;

public class PersonalAreaRepository extends Configs {

    public static ObservableList<Ticket> getData(ObservableList<Ticket> ticket) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, username, password)) {

                String query = "SELECT " + Const.TICKET_NUMBER + ", " + Const.EXHIBITION_DATE + ", " +
                        Const.EXHIBITION_NAME + " FROM " + Const.TICKETS_TABLE + " LEFT JOIN " +
                        Const.EXHIBITION_TABLE + " " + "ON tickets.exhibition_id = exhibition.id" +
                        " WHERE tickets.user_id = " + User.getId() + "";

                try (Statement statement = connection.createStatement()) {
                    ResultSet rs = statement.executeQuery(query);
                    while(rs.next()) {
                        ticket.add(new Ticket(rs.getString(1), rs.getString(2), rs.getString(3)));
                    }
                    return ticket;
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String takeBalance() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, username, password)) {

                String query = "SELECT " + Const.USER_BALANCE + " FROM " + Const.USER_TABLE + " WHERE " + Const.USER_ID +
                        " = " + User.getId() + "";

                try (Statement statement = connection.createStatement()) {
                    ResultSet rs = statement.executeQuery(query);
                    if (rs.next()) {
                        return rs.getString(1);
                    } else {
                        return null;
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


    public static boolean tableIsEmpty() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, username, password)) {

                String query = "SELECT * FROM " + Const.TICKETS_TABLE + " WHERE " + Const.TICKET_USER_ID +
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

    public static boolean checkUsername(String inputUserName) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, username, password)) {

                String query = "SELECT * FROM " + Const.USER_TABLE + " WHERE " + Const.USER_USERNAME +
                        " = '" + inputUserName + "'";

                try (Statement statement = connection.createStatement()) {
                    ResultSet rs = statement.executeQuery(query);
                    return  !rs.next();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean checkMobileNumber(String inputMobileNumber) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, username, password)) {

                String query = "SELECT * FROM " + Const.USER_TABLE + " WHERE " + Const.USER_MOBILENUMBER +
                        " = '" + inputMobileNumber + "'";

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

    public static void updateUserDate(List<TextField> listOfTextField, String gender) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, username, password)) {

                String query = "UPDATE " + Const.USER_TABLE + " SET " + Const.USER_FIRSTNAME + " = ?, " +
                        Const.USER_LASTNAME + " = ?, " + Const.USER_USERNAME + " = ?," +
                        Const.USER_PASSWORD + " = ?, " + Const.USER_GENDER + " = ?, " + Const.USER_MOBILENUMBER + " = ?" +
                        " WHERE " + Const.USER_ID + " = " + User.getId() + "";

                try (PreparedStatement prep = connection.prepareStatement(query)) {
                    prep.setString(1, listOfTextField.get(0).getText());
                    prep.setString(2, listOfTextField.get(1).getText());
                    prep.setString(3, listOfTextField.get(2).getText().toLowerCase());
                    prep.setString(4, listOfTextField.get(3).getText());
                    prep.setString(5, gender);
                    prep.setString(6, listOfTextField.get(4).getText().replaceAll("\\s+",""));
                    prep.execute();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String takeFirstName() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, username, password)) {

                String query = "SELECT " + Const.USER_FIRSTNAME + " FROM " + Const.USER_TABLE + " WHERE " + Const.USER_ID +
                        " = " + User.getId() + "";

                try (Statement statement = connection.createStatement()) {
                    ResultSet rs = statement.executeQuery(query);
                    if (rs.next()) {
                        return rs.getString(1);
                    } else {
                        return null;
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

    public static String takeLastName() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, username, password)) {

                String query = "SELECT " + Const.USER_LASTNAME + " FROM " + Const.USER_TABLE + " WHERE " + Const.USER_ID +
                        " = " + User.getId() + "";

                try (Statement statement = connection.createStatement()) {
                    ResultSet rs = statement.executeQuery(query);
                    if (rs.next()) {
                        return rs.getString(1);
                    } else {
                        return null;
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

    public static String takeUserName() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, username, password)) {

                String query = "SELECT " + Const.USER_USERNAME + " FROM " + Const.USER_TABLE + " WHERE " + Const.USER_ID +
                        " = " + User.getId() + "";

                try (Statement statement = connection.createStatement()) {
                    ResultSet rs = statement.executeQuery(query);
                    if (rs.next()) {
                        return rs.getString(1);
                    } else {
                        return null;
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
    public static String takePassword() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, username, password)) {

                String query = "SELECT " + Const.USER_PASSWORD + " FROM " + Const.USER_TABLE + " WHERE " + Const.USER_ID +
                        " = " + User.getId() + "";

                try (Statement statement = connection.createStatement()) {
                    ResultSet rs = statement.executeQuery(query);
                    if (rs.next()) {
                        return rs.getString(1);
                    } else {
                        return null;
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

    public static String takeGender() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, username, password)) {

                String query = "SELECT " + Const.USER_GENDER + " FROM " + Const.USER_TABLE + " WHERE " + Const.USER_ID +
                        " = " + User.getId() + "";

                try (Statement statement = connection.createStatement()) {
                    ResultSet rs = statement.executeQuery(query);
                    if (rs.next()) {
                        return rs.getString(1);
                    } else {
                        return null;
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

    public static String takeMobileNumber() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, username, password)) {

                String query = "SELECT " + Const.USER_MOBILENUMBER + " FROM " + Const.USER_TABLE + " " +
                        "WHERE " + Const.USER_ID + " = " + User.getId() + "";

                try (Statement statement = connection.createStatement()) {
                    ResultSet rs = statement.executeQuery(query);
                    if (rs.next()) {
                        return rs.getString(1);
                    } else {
                        return null;
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
}
