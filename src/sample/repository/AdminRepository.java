package sample.repository;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.entity.Exhibition;
import sample.entity.TableClassAdmin;
import sample.entity.TableClassBasket;
import sample.entity.User;
import sample.repository.configs.Configs;
import sample.repository.configs.Const;

import java.sql.*;

public class AdminRepository extends Configs {

    public ObservableList<TableClassAdmin> getData(ObservableList<TableClassAdmin> exhibitionList) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, username, password)) {

                String query = "SELECT * FROM exhibition";

                try (Statement statement = connection.createStatement()) {
                    ResultSet rs = statement.executeQuery(query);
                    return getDataList(rs);
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addExhibition(Exhibition exhibition) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, username, password)) {

                String query = "INSERT INTO exhibition (name, date, price) VALUES (?, ?, ?)";

                try (PreparedStatement prep = connection.prepareStatement(query)) {
                    prep.setString(1, exhibition.getName());
                    prep.setString(2, exhibition.getDate());
                    prep.setInt(3, exhibition.getPrice());
                    prep.execute();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteExhibitionById(int id) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, username, password)) {

                String query = "DELETE FROM exhibition WHERE id = " + id + "";

                try(Statement statement = connection.createStatement()) {
                    statement.execute(query);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getExhibitionIdById(int id) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, username, password)) {

                String query = "SELECT * FROM exhibition WHERE id = " + id + "";

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

    private ObservableList<TableClassAdmin> getDataList(ResultSet rs) throws SQLException {
        ObservableList<TableClassAdmin> exhibitionList = FXCollections.observableArrayList();
        while (rs.next()) {
            exhibitionList.add(new TableClassAdmin(rs.getInt(1), rs.getString(2),
                    rs.getString(3), rs.getInt(4)));
        }
        return exhibitionList;
    }
}
