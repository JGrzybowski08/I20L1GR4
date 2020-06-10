package Models;

/**
 * Klasa ModelAktualneWizytyPacjent- model do tabeli aktualnych wizyt pacjenta
 */

public class ModelAktualneWizytyPacjent {
    private final String Data, Godzina, Lekarz, Opis, Status;

    /**
     * Konstruktor ModelAktualneWizytyPacjent - kontruktor modelu aktualnych wizyt
     * @param data
     * @param godzina
     * @param opis
     * @param status
     * @param lekarz
     */

    public ModelAktualneWizytyPacjent(String data, String godzina, String opis, String status, String lekarz) {
        Data = data;
        Godzina = godzina;
        Lekarz = lekarz;
        Opis = opis;
        Status = status;
    }

    /**
     * Metoda getData - metoda zwracająca datę
     * @return Data
     */

    public String getData() {
        return Data;
    }

    /**
     * Metoda getGodzina - metoda zwracająca godzinę
     * @return Godzina
     */

    public String getGodzina() {
        return Godzina;
    }

    /**
     * Metoda getLekarz - metoda zwracająca dane lekarza
     * @return Lekarz
     */

    public String getLekarz() {
        return Lekarz;
    }

    /**
     * Metoda getOpis - metoda zwracająca opis wizyty
     * @return Opis
     */

    public String getOpis() {
        return Opis;
    }

    /**
     * Metoda getStatus - metoda zwracająca status wizyty
     * @return Status
     */

    public String getStatus() {
        return Status;
    }
}
