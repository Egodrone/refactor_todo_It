package se.lexicon;


import se.lexicon.dao.db.DbConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class App
{
    public static void main( String[] args )
    {
        System.out.println( "--- Todo application ---" );

        // test connection to the database
        String query = "SELECT * FROM person";
        try (
                PreparedStatement preparedStatement = DbConnection.getConnection().prepareStatement(query)
        ) {
            ResultSet resultSet = preparedStatement.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }



}
