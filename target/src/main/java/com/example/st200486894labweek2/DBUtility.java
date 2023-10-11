package com.example.st200486894labweek2;

import java.sql.*;
import java.time.LocalDate;
import java.time.Year;
import java.util.ArrayList;

public class DBUtility {
    private static String user = "wes";
    private static String password = "student";
    private static String url = "jdbc:mysql://localhost:3306/assignment2/statistics";

    public static String saveStat(Stat stat) throws SQLException {
        String responseMsg;

        String sql = "INSERT INTO statistics (Year,Value) VALUES (?,?)";
        try (
                Connection conn = DriverManager.getConnection(url, user, password);
                PreparedStatement ps = conn.prepareStatement(sql);
        )
        {
            ps.setDouble(1, value.getValue());
            ps.setInt(2, year.getYear());
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
    public static ArrayList<Stat> getStats()
    {
        ArrayList<Stat> stats = new ArrayList<>();

        String sql = "SELECT * FROM statistics WHERE value > 0.01 LIMIT 100";

        try(
                Connection conn = DriverManager.getConnection(url, user, password);
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
        ) {
            while (resultSet.next())
            {

                Double value = resultSet.getDouble("value");
                int year = resultSet.getInt("year");

                try{
                    Stat stat = new Stat(Year,Value);
                    stats.add(stat);
                } catch (IllegalArgumentException e)
                {
                    System.out.printf("year,value");
                }
            }}
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return stats;
    }

}





