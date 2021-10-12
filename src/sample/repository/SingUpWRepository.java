package sample.repository;

import sample.entity.User;
import sample.repository.configs.Configs;
import sample.repository.configs.Const;

import java.sql.*;

public class SingUpWRepository extends Configs {

    public static boolean checkUserInDb(String userName, String inputPassword) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, username, password)) {

                String query = "SELECT * FROM "+ Const.USER_TABLE + " WHERE " + Const.USER_USERNAME +
                        " = '" + userName +"'";
                try (Statement statement = connection.createStatement()) {
                    ResultSet rs = statement.executeQuery(query);
                    while (rs.next()) {
                        if (rs.getString(5).equals(inputPassword)) {
                            User.setId(rs.getInt(1));
                            return true;
                        }
                    }
                    return false;
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