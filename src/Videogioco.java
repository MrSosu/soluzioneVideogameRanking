import java.util.Collections;
import java.util.HashSet;
import java.util.TreeMap;

public class Videogioco {

    private static int idTot = 0;
    private final int id;
    private String nome;
    private int coefficiente;
    private TreeMap<Integer, HashSet<Utente>> classificaLocale;

    public Videogioco(String nome, int coefficiente) {
        this.nome = nome;
        this.coefficiente = coefficiente;
        idTot++;
        this.id = idTot;
        this.classificaLocale = new TreeMap<>(Collections.reverseOrder());
    }

    public String getNome() { return nome; }
    public int getCoefficiente() { return coefficiente; }
    public int getId() { return id; }
    public TreeMap<Integer, HashSet<Utente>> getClassificaLocale() { return classificaLocale; }

    public void setNome(String nome) { this.nome = nome; }
    public void setCoefficiente(int coefficiente) { this.coefficiente = coefficiente; }

    // questo metodo prende in input un utente e ritorna il record di quell'utente nel videogioco
    public int getRecord(Utente u) {
        for (Integer punteggio : classificaLocale.keySet()) {
            if (classificaLocale.get(punteggio).contains(u)) {
                return punteggio;
            }
        }
        return -1;
    }

}
