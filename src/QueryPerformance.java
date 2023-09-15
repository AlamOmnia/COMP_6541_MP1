package src;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class QueryPerformance {

    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/MP1_DB";
        String username = "dba";
        String password = "password";

        int[] instanceSizes = {10, 100, 1000, 10000}; // Define the instance sizes to test


        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
            Statement statement = connection.createStatement();

            // Loop through different instance sizes
            for (int size : instanceSizes) {
                // Create and populate data for R and S for the given size
                createAndPopulateData(connection, size);

                // Measure query execution time
                long startTime = System.currentTimeMillis();
                executeQuery(connection);
                long endTime = System.currentTimeMillis();

                // Calculate and display execution time
                long executionTime = endTime - startTime;
                System.out.println("Size " + size + ": Execution time = " + executionTime + " ms");
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Create and populate data for R and S for a given size
    private static void createAndPopulateData(Connection connection, int size) throws SQLException {
        // Implement your data population logic here
        // You should generate and insert data into tables R and S based on the 'size' parameter
        // You can use INSERT INTO statements or other methods to populate the tables
        // Make sure to generate unique data for each tuple and adjust accordingly
    }

    // Execute the query
    private static void executeQuery(Connection connection) throws SQLException {
        String query = "CREATE TABLE TableC AS " +
                       "SELECT R.A2, R.A3, S.B2, S.B3, CONCAT('R.I=', R.I, ', S.J=', S.J) AS K " +
                       "FROM R INNER JOIN S ON R.A2 = S.B2 AND R.A3 = S.B3";
        
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }
}
