package com.example.st200486894labweek2;

import java.sql.*;
import java.time.LocalDate;
import java.time.Year;
import java.util.ArrayList;

public class DBUtility {
    //connecting to my database
    private static String user = "wes";
    private static String password = "student";
    private static String url = "jdbc:mysql://localhost:3306/statistics";

    public static String saveStat(Stat stat) throws SQLException {
        String rspMessage = "broken";

        String sql = "INSERT INTO statistics VALUES (?,?)";

        //try with resources will automatically close anything that was defined insid the () brackets
        try (
                Connection conn = DriverManager.getConnection(url, user, password);
                PreparedStatement ps = conn.prepareStatement(sql);
        ) {
            //making prepared statements individually to set them for further use
            ps.setInt(1, stat.getYear());
            ps.setDouble(2, stat.getValue());

            ps.executeUpdate();

            rspMessage = "Stat Added";
        }
        //this is a duplicate key
        catch (SQLIntegrityConstraintViolationException e) {
            rspMessage = "Stat already defined";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rspMessage;
    }

    //creating an arraylist ro get stats from each piece of data
    public static ArrayList<Stat> getStats() {
        ArrayList<Stat> stats = new ArrayList<>();

        //use try with resources to access the database and on its own to drop/cut connection, statement and result
        String sql = "SELECT * FROM statistics";

        try (
                //making connection to password user and url
                Connection conn = DriverManager.getConnection(url, user, password);
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
        ) {
            //loop over the results returned and create new user objects
            while (resultSet.next()) {
                Stat newStat = new Stat(resultSet.getInt("id"),
                        (resultSet.getDouble("value")),
                        (resultSet.getInt("year")));

                stats.add(newStat);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stats;
    }}







