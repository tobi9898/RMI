import java.rmi.RemoteException;

public class QuadratImplementierung implements Quadrat
{
    @Override
    public double quadrat(double i) throws RemoteException
    {
        return i*i;
    }
}
