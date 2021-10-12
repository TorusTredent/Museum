package sample.repository;

import sample.entity.User;
import sample.repository.configs.Configs;
import sample.repository.configs.Const;

import java.sql.*;

public class RegistrationWRepository extends Configs {

    public static void registrationUser(User user) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, username, password)) {

                String query = "INSERT INTO " + Const.USER_TABLE + "(" + Const.USER_FIRSTNAME + ", " +
                        Const.USER_LASTNAME + ", " + Const.USER_USERNAME + ", " + Const.USER_PASSWORD + ", " +
                        Const.USER_GENDER + ", " + Const.USER_MOBILENUMBER + ") " + "VALUES (?, ?, ?, ?, ?, ?)";

                try (PreparedStatement prep = connection.prepareStatement(query)) {
                    prep.setString(1, user.getFirstName());
                    prep.setString(2, user.getLastName());
                    prep.setString(3, user.getUserName());
                    prep.setString(4, user.getPassword());
                    prep.setString(5, user.getGender());
                    prep.setString(6, user.getMobileNumber());
                    prep.execute();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean checkUniqFields(String userName, String mobileNumber) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, username, password)) {

                String query = "SELECT * FROM " + Const.USER_TABLE + " WHERE " + Const.USER_USERNAME + " = '" + userName + "' " +
                        " OR " + Const.USER_MOBILENUMBER + " = '" + mobileNumber + "'";

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


