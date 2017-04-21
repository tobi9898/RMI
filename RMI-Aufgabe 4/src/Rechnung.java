public class Rechnung
{
    private String user;
    private float value;

    // Werte werden über Konstruktor gesetzt
    public Rechnung(String user, float value)
    {
        this.user = user;
        this.value = value;
    }

    public float getValue()
    {
        return value;
    }

    public String getUser()
    {
        return user;
    }
}