package org.example.hiredrive.Connection;

import org.example.hiredrive.advertisement.Request;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class RequestConnection {

    private static final Properties properties;

    static {
        try {
            properties = DatabaseConfig.loadProperties();
        } catch (IOException e) {
            throw new RuntimeException("Error loading database properties", e);
        }
    }

    private static final String url = properties.getProperty("db.url");
    private static final String username = properties.getProperty("db.username");
    private static final String password = properties.getProperty("db.password");


    public static void sendJobRequestToAdd(int sender_id, int add_id){
        String sql = "INSERT INTO jobRequests (sender_id, add_id) VALUES (?, ?)";
      //  String sql1 = "UPDATE TABLE advertisement SET request = request + 1 WHERE advert_id = ?";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement pstmt = conn.prepareStatement(sql);
             PreparedStatement pstmt1 = conn.prepareStatement(sql)){

            pstmt.setInt(1, sender_id);
            pstmt.setInt(2, add_id);

            pstmt.executeUpdate();

            System.out.println("Request sent successfully.");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void replyRequest(int driver_id, int add_id, boolean accepted) {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "UPDATE jobRequests SET status = ? WHERE driver_id = ? AND add_id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, accepted ? "ACCEPTED" : "REJECTED");
                preparedStatement.setInt(2, driver_id);
                preparedStatement.setInt(3, add_id);

                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Request status updated successfully.");
                } else {
                    System.out.println("No request found with the given IDs.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param user_id
     * @param status
     * @return all the requests sent from the user
     */
    public static ArrayList<Request> getSentRequests(int user_id, String status){
        ArrayList<Request> requests = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query;
            if (status != null) {
                query = "SELECT add_id, status, reciever_id FROM jobRequests WHERE sender_id = ? AND status = ?";
            } else {
                query = "SELECT add_id, status, reciever_id FROM jobRequests WHERE sender_id = ?";
            }
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, user_id);
                if (status != null) {
                    preparedStatement.setString(2, status);
                }
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {

                        int add_id = resultSet.getInt("add_id");
                        int receiver_id = resultSet.getInt("reciever_id");
                        String requestStatus = resultSet.getString("status");


                        // Create a new Request object and add it to the list
                        Request request = new Request(requestStatus, user_id, receiver_id, add_id);
                        //Request request = new Request(driver_id, advertisement, requestStatus);
                        requests.add(request);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return requests;
    }
    public static ArrayList<Request> getIncomingRequest(int userId) {
        ArrayList<Request> requests = new ArrayList<>();
        String sql = "SELECT * FROM jobRequests WHERE reciever_id = ? AND  status = 'PENDING' ";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, userId);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int addId = rs.getInt("add_id");
                int sender_id = rs.getInt("sender_id");
                String status = rs.getString("status");

                Request request = new Request(status, sender_id, userId, addId);
                requests.add(request);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }

        return requests;
    }

    public static void deleteRequest(int driver_id, int add_id) {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "DELETE FROM jobRequests WHERE driver_id = ? AND add_id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, driver_id);
                preparedStatement.setInt(2, add_id);
                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Request deleted successfully.");
                } else {
                    System.out.println("No request found with the given driver_id and add_id.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println(getSentRequests(35, "PENDING").size());
    }
}
