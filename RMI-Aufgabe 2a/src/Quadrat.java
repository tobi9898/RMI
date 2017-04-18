import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Quadrat extends Remote
{
        double quadrat(double i) throws RemoteException;
}