public class Package
{
    private Client client;
    private String frage;

    public Package(Client client, String frage){

        this.client = client;
        this.frage = frage;
    }

    public Client getClient()
    {
        return client;
    }

    public String getFrage()
    {
        return frage;
    }
}
