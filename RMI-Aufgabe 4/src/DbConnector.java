import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbConnector
{
    private static Connection connection = null;
    private static Statement statement = null;
    private static PreparedStatement preparedStatement = null;
    private static ResultSet resultSet = null;

    // Connection aufbauen
    public DbConnector()
    {

        String url = "jdbc:mysql://linuxserver:3306/DB4_stobetob"; // Treiber muss eingebunden werden !!!

        try
        {
            this.connection = DriverManager.getConnection(url,"stobetob","mypass");
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    // Alle User heraussuchen
    public List<String> getUsers()
    {
        List<String> result = new ArrayList<>();

        try
        {
            String sql = "select name from user";

            statement =  connection.createStatement();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery(); // Befehl ausführen

            while (resultSet.next()) // Resultate aus Datenbank auslesen
            {
                result.add(resultSet.getString("name"));
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return result;
    }

    // Rechnungen eines Users heraussuchen
    public  List<Rechnung> getBills(String username)
    {
        List<Rechnung> result = new ArrayList<>();

        try
        {
            String sql = "select name, value from user join rechnung on users.UID = rechnung.RID where name = " + username;

            statement = connection.createStatement();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery(); // Befehl ausführen

            while (resultSet.next()) // Resultate aus Datenbank auslesen
            {
                result.add(new Rechnung(resultSet.getString("name"), Float.parseFloat(resultSet.getString("value"))));
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return result;
    }


    public static void main(String[] args)
    {
        new DbConnector();
    }
}