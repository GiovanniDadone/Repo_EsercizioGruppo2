import java.util.ArrayList;

public class Biblioteca {
    // dichiarazione variabili d'istanza
    private String nome;
    private ArrayList<Risorsa> risorseDisponibili;
    private ArrayList<Utente> utenti;

    public Biblioteca(String nome) {
        this.nome = nome;
        risorseDisponibili = new ArrayList<>();
        utenti = new ArrayList<>();
    }

    public String getNome() {
        return this.nome;
    }

    public void aggiungiUtente() {
        // dichiarazione e inizializzazione variabili locali
        String nome = "";
        String idUtente = "";

        // input nome
        System.out.println("Inserire il noem dell'utente");
        nome = GlobalScanner.readStringInput();

        // se l'input non e' corretto
        while (nome.isEmpty()) {
            // input titoloRisorsa
            System.out.println("Inserire un nome valido");
            nome = GlobalScanner.readStringInput();
        }

        // input idUtente
        System.out.println("Inserire l'id dell'utente");
        idUtente = GlobalScanner.readStringInput();

        for (int i = 0; i < utenti.size(); i++) {
            // controlla se è stato inserito un id utente già esistente
            if (utenti.get(i).getIdUtente().equals(idUtente)) {
                // input idUtente
                System.out.println("L'id inserito e' gia' esistente.\nInserire un id valido");
                idUtente = GlobalScanner.readStringInput();

                // resetta l'index
                i = -1;
                continue;
            }

            // se l'input non è valido
            while (idUtente.isEmpty()) {
                // input idUtente
                System.out.println("Inserire un id valido");
                idUtente = GlobalScanner.readStringInput();

                // resetta l'index
                i = -1;
            }
        }

        // controlla se l'utente è presente nel sistema.
        // In tal caso, effettuerà il login
        for (Utente utente : utenti) {
            if (utente.getNome().equals(nome) && utente.getIdUtente().equals(idUtente)) {
                System.out.println("Loggato nel sistema con successo");
                return;
            }
        }

        // se l'utente non è presente nel sistema
        utenti.add(new Utente(nome, idUtente));
    }

    private Risorsa aggiungiRisorsa() {
        // dichiarazione e inizializzazione variabili locali
        String titoloRisorsa = "";
        int annoPubblicazione = 0;
        String codiceId = "";

        // input titoloRisorsa
        System.out.println("Inserire il titolo della risorsa");
        titoloRisorsa = GlobalScanner.readStringInput();

        // se l'input non e' corretto
        while (titoloRisorsa.isEmpty()) {
            // input titoloRisorsa
            System.out.println("Inserire un titolo valido");
            titoloRisorsa = GlobalScanner.readStringInput();
        }

        // input annoPubblicazione
        System.out.println("Inserire l'anno di pubblicazione della risorsa");
        annoPubblicazione = GlobalScanner.readIntInput();

        // se l'input non e' corretto
        while (annoPubblicazione <= 0) {
            System.out.println("Inserire un anno di pubblicazione valido");
            annoPubblicazione = GlobalScanner.readIntInput();
        }

        // input codiceId
        System.out.println("Inserire il codice univoco della risorsa");
        codiceId = GlobalScanner.readStringInput();

        while (codiceId.isBlank()) {
            System.out.println("Inserire un codice univoco non vuoto");
            codiceId = GlobalScanner.readStringInput();
        }

        for (int i = 0; i < risorseDisponibili.size(); i++) {
            // controlla se è stato inserito un codice id già esistente
            if (risorseDisponibili.get(i).getCodice().equals(codiceId)) {
                System.out.println("Il codice univoco e' gia' esistente.\nInserire un codice univoco");
                codiceId = GlobalScanner.readStringInput();

                // resetta l'index
                i = -1;
            } else {
                System.out.println("Inserire un codice univoco valido");
                codiceId = GlobalScanner.readStringInput();

                // resetta l'index
                i = -1;
                System.out.println(i);

            }
        }

        return new Risorsa(titoloRisorsa, annoPubblicazione, codiceId);
    }

    public void ricercaRisorsa() {
        System.out.println("Inserisci titolo: ");
        String titolo2 = GlobalScanner.readStringInput();
        for (Risorsa risorsa : risorseDisponibili) {
            if (risorsa.getTitolo().equalsIgnoreCase(titolo2)) {
                risorsa.visualizzaDettagli();
                return;
            }
        }
        System.out.println("Risorsa non trovata");
    }

    public void addLibro() {
        // variabili locali
        String autoreLibro = "";
        Risorsa nuovoLibro = aggiungiRisorsa();

        // input autoreLibro
        System.out.println("Inserire il nome dell'autore del libro");
        autoreLibro = GlobalScanner.readStringInput();

        // se l'input non e' corretto
        while (autoreLibro.isEmpty()) {
            // input autoreLibro
            System.out.println("Inserire un nome valido");
            autoreLibro = GlobalScanner.readStringInput();
        }

        risorseDisponibili.add(new Libro(nuovoLibro.getTitolo(), nuovoLibro.getAnnoPubblicazione(),
                nuovoLibro.getCodice(), autoreLibro));
    }

    public void addRivista() {
        // variabili locali
        String numRivista = "";
        Risorsa nuovaRivista = aggiungiRisorsa();
        int num;

        while (true) {
            // input numRivista
            System.out.println("Inserire il numero della rivista");
            numRivista = GlobalScanner.readStringInput();

            //check che non sia vuoto
            num = (numRivista.isBlank()) ? 0 : Integer.parseInt(numRivista);
            if (num > 0) {
                break;
            }
            System.out.println("Input non valido");
        }

        risorseDisponibili.add(new Rivista(nuovaRivista.getTitolo(), nuovaRivista.getAnnoPubblicazione(),
                nuovaRivista.getCodice(), num));
    }

    public void addEbook() {
        // variabili locali
        String ebookFormato = "";
        Risorsa nuovoEbook = aggiungiRisorsa();

        // input ebookFormato
        System.out.println("Inserire il nome formato dell'e-book");
        ebookFormato = GlobalScanner.readStringInput();

        // se l'input non e' corretto
        while (ebookFormato.isEmpty()) {
            // input ebookFormato
            System.out.println("Inserire un nome valido");
            ebookFormato = GlobalScanner.readStringInput();
        }

        risorseDisponibili.add(new Ebook(nuovoEbook.getTitolo(), nuovoEbook.getAnnoPubblicazione(),
                nuovoEbook.getCodice(), ebookFormato));
    }

    public void stampaDatiRisorse() {
        for (Risorsa risorsa : risorseDisponibili) {
            risorsa.visualizzaDettagli();
        }
    }

    public void stampaDatiUtenti() {
        for (Utente utente : utenti) {
            utente.stampaListaRisorse();
        }
    }
}
