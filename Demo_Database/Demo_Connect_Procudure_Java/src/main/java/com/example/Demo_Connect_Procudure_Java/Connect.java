package com.example.Demo_Connect_Procudure_Java;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Connect {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/demo_db";
        String user = "root";
        String password = "Haitam77";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {

            try (PreparedStatement stmt = conn.prepareStatement("{CALL getIdOrder(?)}")) {

                stmt.setInt(1, 1);

                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    int id = rs.getInt("id");
                    int idKH = rs.getInt("customer_id");
                    String customerName = rs.getString("order_date");
                    Double total=rs.getDouble("total");

                    System.out.println("ID: " + id + ", ID KH: " + idKH + ", Customer Name: " + customerName + ", Order Date: " + total);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
