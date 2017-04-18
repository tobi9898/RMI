import java.rmi.server.UnicastRemoteObject;
import java.rmi.*;
import javax.swing.*;
import java.io.IOException;

public class Client extends UnicastRemoteObject implements ClientInterface
{
    public Client() throws RemoteException
    {

    }

    public static void main(String[] argv) throws IOException, NotBoundException
    {
        new Client().execute(JOptionPane.showInputDialog("Stell eine Frage:"));
    }

    private void execute(String frage) throws IOException, NotBoundException
    {
        ServerInterface server = (ServerInterface) Naming.lookup("rmi://localhost/Server");
        server.connect(this, frage);
    }

    public void callback(String nachricht) throws RemoteException
    {
        JOptionPane.showMessageDialog(null, nachricht);
    }
}
