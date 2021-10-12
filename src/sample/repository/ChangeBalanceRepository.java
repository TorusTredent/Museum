package sample.repository;

import sample.entity.User;
import sample.repository.configs.Configs;
import sample.repository.configs.Const;

import java.sql.*;

public class ChangeBalanceRepository extends Configs {
    public static void addBalance(String newBalance) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, username, password)) {

                String query = "UPDATE " + Const.USER_TABLE + " SET " + Const.USER_BALANCE +
                        " = ? WHERE " + Const.USER_ID + " = ?";

                try (PreparedStatement prep = connection.prepareStatement(query)) {
                    prep.setString(1, newBalance);
                    prep.setLong(2, User.getId());
                    prep.execute();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
