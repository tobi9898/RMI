import java.io.IOException;
import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class Server extends UnicastRemoteObject implements ServerInterface, Runnable
{
    List <Package> List = new ArrayList <Package>();

    public static void main(String[] argv) throws IOException, NotBoundException
    {
        Naming.rebind("//localhost/Server", new Server());
    }

    public Server() throws RemoteException
    {
        super();
        new Thread(this).start();
    }

    public void connect(Client client,String frage) throws RemoteException
    {
        List.add(new Package(client, frage));
    }

    public void run()
    {
        while (true)
        {
            try
            {
                Thread.sleep(10000);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }

            for (Package set: List)
            {
                try
                {
                    set.getClient().callback("Die Antwort auf deine Frage <" + set.getFrage() + "> ist wahrscheinlich 61");
                    List.remove(set);
                }
                catch (RemoteException e)
                {
                     e.printStackTrace();
                }
            }
        }
    }
}