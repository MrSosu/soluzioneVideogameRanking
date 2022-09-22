import java.util.*;

public class SalaGiochi {

    private HashMap<Integer, Videogioco> videogames;
    private HashMap<Integer, Utente> utenti;
    private HashMap<Utente, Integer> classificaGlobale;

    public SalaGiochi(HashMap<Integer, Videogioco> videogames) {
        this.videogames = videogames;
        this.utenti = new HashMap<>();
        this.classificaGlobale = new HashMap<>();
    }

    public HashMap<Integer, Utente> getUtenti() { return utenti; }
    public HashMap<Integer, Videogioco> getVideogames() { return videogames; }
    public HashMap<Utente, Integer> getClassificaGlobale() { return classificaGlobale; }

    public void inserisciUtente(Utente u) {
        utenti.put(u.getId(), u);
        classificaGlobale.put(u, 0);
    }
    public void inserisciVideogioco(Videogioco v) { videogames.put(v.getId(), v); }
    public void inserisciPartita(int idUser, int idVideogame, int punteggio) {
        // aggiorno la classifica locale del videogioco
        Videogioco v = videogames.get(idVideogame);
        Utente u = utenti.get(idUser);
        TreeMap<Integer, HashSet<Utente>> classificaLocale = v.getClassificaLocale();
        int record = v.getRecord(u);
        if (classificaLocale.containsKey(punteggio)) {
            HashSet<Utente> utenti = classificaLocale.get(punteggio);
            utenti.add(u);
            classificaLocale.put(punteggio, utenti);
        }
        else {
            HashSet<Utente> utenti = new HashSet<>();
            utenti.add(u);
            classificaLocale.put(punteggio, utenti);
        }
        // aggiorno quella globale
        if (punteggio > record) {
            int nuovo_punteggio = classificaGlobale.get(u) - v.getCoefficiente()*record
                    + v.getCoefficiente()*punteggio;
            classificaGlobale.put(u, nuovo_punteggio);
        }
    }

    public ArrayList<String> top3Videogioco(int idVideogioco) {
        Videogioco v = videogames.get(idVideogioco);
        ArrayList<String> classifica = new ArrayList<>();
        TreeMap<Integer, HashSet<Utente>> classificaLocale = v.getClassificaLocale();
        int count = 0;
        for (Integer points : classificaLocale.keySet()) {
            HashSet<Utente> giocatori = classificaLocale.get(points);
            for (Utente u: giocatori) {
                classifica.add(u.getUserName() + " : " + points);
                count++;
                if (count >= 3) { break; }
            }
            if (count >= 3) { break; }
        }
        return classifica;
    }

}
