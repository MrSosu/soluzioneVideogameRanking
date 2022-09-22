import java.util.HashMap;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) {
        Videogioco v1 = new Videogioco("Street Fighter", 3);
        Videogioco v2 = new Videogioco("Metal Slug", 5);
        Videogioco v3 = new Videogioco("Aero Fighters", 2);

        Utente u1 = new Utente("pippo");
        Utente u2 = new Utente("ciccio");
        Utente u3 = new Utente("boh");
        Utente u4 = new Utente("cheneso");
        Utente u5 = new Utente("meaveterotto");

        HashMap<Integer, Videogioco> games = new HashMap<>();
        games.put(v1.getId(), v1);
        games.put(v2.getId(), v2);

        SalaGiochi sala = new SalaGiochi(games);

        sala.inserisciVideogioco(v3);
        sala.inserisciUtente(u1);
        sala.inserisciUtente(u2);
        sala.inserisciUtente(u3);
        sala.inserisciUtente(u4);
        sala.inserisciUtente(u5);

        sala.inserisciPartita(u1.getId(), v2.getId(), 40);
        sala.inserisciPartita(u1.getId(), v1.getId(), 110);
        sala.inserisciPartita(u4.getId(), v3.getId(), 55);
        sala.inserisciPartita(u4.getId(), v1.getId(), 130);
        sala.inserisciPartita(u3.getId(), v3.getId(), 44);
        sala.inserisciPartita(u2.getId(), v2.getId(), 60);
        sala.inserisciPartita(u5.getId(), v1.getId(), 180);
        sala.inserisciPartita(u5.getId(), v2.getId(), 70);
        sala.inserisciPartita(u3.getId(), v3.getId(), 31);

        System.out.println(sala.getClassificaGlobale());

        System.out.println(v1.getClassificaLocale());
        System.out.println(v2.getClassificaLocale());
        System.out.println(v3.getClassificaLocale());

    }

}
