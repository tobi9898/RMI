import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import javax.swing.JOptionPane;

public class Client
{
    private static Quadrat look_up;

    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException
    {
        Registry registry = LocateRegistry.getRegistry("127.0.0.1", Registry.REGISTRY_PORT);
        look_up = (Quadrat) registry.lookup("//localhost/test");

        double response = look_up.quadrat(Double.parseDouble(JOptionPane.showInputDialog("Zahl eingeben:")));
        JOptionPane.showMessageDialog(null, response);
    }
}