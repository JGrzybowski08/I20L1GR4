package Models;

/**
 * Klasa ModelAktualneWizytyLekarz - model do tabeli aktualnych wizyt lekarza
 */

public class ModelAktualneWizytyLekarz {
    private final String Data, Godzina, Pacjent, Opis, Status;

    /**
     * Konstruktor ModelAktualneWizytyLekarz - kontruktor modelu aktualnych wizyt
     * @param data
     * @param godzina
     * @param opis
     * @param status
     * @param pacjent
     */

    public ModelAktualneWizytyLekarz(String data, String godzina, String opis, String status, String pacjent) {
        this.Data = data;
        this.Godzina = godzina;
        this.Opis = opis;
        this.Status = status;
        this.Pacjent = pacjent;
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

    /**
     * Metoda getPacjent - metoda zwracająca dane pacjenta(imię i nazwisko)
     * @return Pacjent
     */

    public String getPacjent() {
        return Pacjent;
    }

}
