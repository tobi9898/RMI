import java.net.MalformedURLException;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.*;
import java.util.List;

public class Server extends UnicastRemoteObject implements Operationen
{
    DbConnector DbConnector;

    public Server() throws RemoteException
    {
        DbConnector = new DbConnector();
    }

    @Override
    public List<String> getUser()
    {
        return DbConnector.getUsers();
    }

    @Override
    public List<Rechnung> getBill(String username)
    {
        return DbConnector.getBills(username);
    }

    public static void main(String[] args)
    {
        try
        {
            Naming.rebind("//localhost/Server", new Server());
        }
        catch (RemoteException e)
        {
            e.printStackTrace();
        }
        catch (MalformedURLException e)
        {
            e.printStackTrace();
        }
    }
}