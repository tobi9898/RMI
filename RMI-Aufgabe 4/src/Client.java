import java.io.Console;
import java.net.MalformedURLException;
import java.rmi.*;

public class Client
{
    public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException
    {
        Operationen operationen = (Operationen) Naming.lookup("localhost/Server");

        Console console = System.console();
        String input = console.readLine();

        // 1 = Liste aller User
        // 2 = Rechnungen von Tobias Oberhauser

        switch(input)
        {
            case "1":
            {
                for (String result: operationen.getUser())
                {
                    System.out.println(result);
                }

                break;
            }

            case "2":
            {
                for (Rechnung result: operationen.getBill("Tobias Oberhauser"))
                {
                    System.out.println(result.getUser() + " > " + result.getValue());
                }

                break;
            }
        }
    }
}