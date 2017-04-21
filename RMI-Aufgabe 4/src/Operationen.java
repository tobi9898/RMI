import java.rmi.*;
import java.util.List;

public interface Operationen extends Remote
{
    public List<String> getUser() throws RemoteException;

    public List<Rechnung> getBill(String username) throws RemoteException;
}