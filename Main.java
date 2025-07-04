public class Main {
    public static void main(String[] args) {

        GlobalScanner.InitScannerInputs();

        Biblioteca biblioteca = new Biblioteca("Biblioteca");

        int scelta;
        do {
            System.out.println("\n--- Menu Biblioteca ---");
            System.out.println("1. Aggiungi libro");
            System.out.println("2. Aggiugni Ebook");
            System.out.println("3. Aggiungi utente");
            System.out.println("4. Visualizza dettagli risorse");
            System.out.println("5. Visualizza dettagli utenti");
            System.out.println("6. Ricerca risorsa per titolo");
            System.out.println("0. Esci");
            System.out.print("- Scelta: ");
            scelta = GlobalScanner.readIntInput();

            switch (scelta) {
                case 1:
                    biblioteca.addLibro();
                    break;
                case 2:
                    biblioteca.addEbook();
                    break;
                case 3:
                    biblioteca.aggiungiUtente();
                    break;
                case 4:
                    biblioteca.stampaDatiRisorse();
                    break;
                case 5:
                    biblioteca.stampaDatiUtenti();
                    break;
                case 6:
                    biblioteca.ricercaRisorsa(GlobalScanner.readStringInput());
                    break;
                case 0:
                    System.out.println("Arrivederci e grazie...");
                    break;
                default:
                    System.out.println("Scelta non valida.");
            }
        } while (scelta != 0);

        GlobalScanner.CloseScannerInputs();
    }
}