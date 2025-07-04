public class Risorsa {
    private String titolo;
    private int annoPubblicazione;
    private String codice;

    public Risorsa(String titolo, int annoPubblicazione, String codice) {
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.codice = codice;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public int getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public void setAnnoPubblicazione(int annoPubblicazione) {
        this.annoPubblicazione = annoPubblicazione;
    }

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public void visualizzaDettagli() {
        System.out.println("[Tipo di Risorsa: " + getClass().getSimpleName() + ", titolo:" + titolo + ", annoPubblicazione:"
                + annoPubblicazione + ", codice:" + codice + "]");

    }

}

class Libro extends Risorsa {
    private String autore;

    public Libro(String titolo, int annoPubblicazione, String codice, String autore) {
        super(titolo, annoPubblicazione, codice);
        this.autore = autore;
    }

    @Override
    public void visualizzaDettagli() {
        System.out.println("[Tipo di Risorsa: " + getClass().getSimpleName() + ", titolo:" + getTitolo() + ", annoPubblicazione:"
                + getAnnoPubblicazione() + ", codice:" + getCodice() + ", autore: " + getAutore() +"]");
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

}

class Rivista extends Risorsa {
    private int numero;

    public Rivista(String titolo, int annoPubblicazione, String codice, int numero) {
        super(titolo, annoPubblicazione, codice);
        this.numero = numero;
    }

    @Override
    public void  visualizzaDettagli() {
        System.out.println("[Tipo di Risorsa: " + getClass().getSimpleName() + ", titolo:" + getTitolo() + ", annoPubblicazione:"
                + getAnnoPubblicazione() + ", codice:" + getCodice() + ", numero rivista: " + getNumero() +"]");
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

}

class Ebook extends Risorsa {
    private String formato;

    public Ebook(String titolo, int annoPubblicazione, String codice, String formato) {
        super(titolo, annoPubblicazione, codice);
        this.formato = formato;
    }

    @Override
    public void visualizzaDettagli() {
        System.out.println("[Tipo di Risorsa: " + getClass().getSimpleName() + ", titolo:" + getTitolo() + ", annoPubblicazione:"
                + getAnnoPubblicazione() + ", codice:" + getCodice() + ", formato e-book: " + getFormato() +"]");
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

}
