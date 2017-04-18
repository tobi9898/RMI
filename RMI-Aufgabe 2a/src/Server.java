import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server
{
    public static void main(String[] args) throws RemoteException, AlreadyBoundException
    {
        LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
        Registry registry = LocateRegistry.getRegistry(Registry.REGISTRY_PORT);

        QuadratImplementierung obj = new QuadratImplementierung();
        Quadrat stub = (Quadrat) UnicastRemoteObject.exportObject(obj, 0);

        UnicastRemoteObject.exportObject(stub, Registry.REGISTRY_PORT);

        registry.bind("//localhost/test", stub);
    }
}