public class Utente {

    private static int idTot = 0;
    private final int id;
    private String userName;

    public Utente(String userName) {
        this.userName = userName;
        idTot++;
        this.id = idTot;
    }

    public int getId() { return id; }
    public String getUserName() { return userName; }

    public void setUserName(String userName) { this.userName = userName; }

    @Override
    public String toString() {
        return userName;
    }
}
