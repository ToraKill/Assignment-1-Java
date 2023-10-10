package com.example.st200486894labweek2;

import java.sql.*;
import java.time.LocalDate;
import java.time.Year;
import java.util.ArrayList;

public class DBUtility {
    private static String user = "wes";

    private static String password = "student";

    private static String url = "jdbc:mysql://localhost:3306/statistics";

    /**
     * This method will save a Person into the users table
     */
    public static String saveStat(Stat stat) throws SQLException {
        String responseMsg;

        String sql = "INSERT INTO video_games (Year,Value) VALUES (?,?)";


        //this is called a try...with resource block
        try (
             /*connection start*/   Connection conn = DriverManager.getConnection(url, user, password);
                PreparedStatement ps = conn.prepareStatement(sql);
        )
        {
            // Setup the prepared statement



            ps.setDouble(1, stat.getValue());
            ps.setInt(2, stat.getYear());


            // Excute the prepared statement
            ps.executeUpdate();

            responseMsg = "Statistic Added";
        }
        catch (SQLIntegrityConstraintViolationException e)
        {
            return "Something went wrong!";
        }
        catch (Exception e)
        {
            e.printStackTrace();
            responseMsg = e.getMessage();
        }

        return responseMsg;
    }

    public static <Stat> ArrayList<Stat> getStats()
    {
        // Make a new ArrayList to hold our Game objects
        ArrayList<Stat> stats = new ArrayList<>();

        // The SQL Query
        String sql = "SELECT * FROM statistics WHERE value > 0.01 LIMIT 100";

        try(
                // Create a connection to the Database
                Connection conn = DriverManager.getConnection(url, user, password);

                // Create a statement
                Statement statement = conn.createStatement();

                // Excute the statement and hold the results in a ResultSet object
                ResultSet resultSet = statement.executeQuery(sql);
        )
        {
            // Loops through all the games returned from the database
            while (resultSet.next())
            {
                // Get the values of the current ResultSet (the result set shows a current row and all the columns)
                Double value = resultSet.getDouble("value");
                int year = resultSet.getInt("year");


                try{
                    // Create the Game object
                    Stat stat = new Stat(Year,Value);

                    // Add it to the list of games
                    Stats.add(stat);
                } catch (IllegalArgumentException e)
                {
                    System.out.printf("Year,Values");
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return stats;
    }


}





