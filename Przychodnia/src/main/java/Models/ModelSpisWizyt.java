package Models;

/**
 * Klasa ModelSpisWizyt - model do tabeli wyświetlającej dane wizyt
 */

public class ModelSpisWizyt {
    private final String Data, Godzina, Lekarz, Pacjent, Opis, Status;

    /**
     * Konstruktor ModelSpisWizyt - konstruktor modelu spisu wizyt
     * @param data
     * @param godzina
     * @param opis
     * @param status
     * @param pacjent
     * @param lekarz
     */

    public ModelSpisWizyt(String data, String godzina, String opis, String status, String pacjent, String lekarz) {
        this.Data = data;
        this.Godzina = godzina;
        this.Opis = opis;
        this.Status = status;
        this.Pacjent = pacjent;
        this.Lekarz = lekarz;
    }

    /**
     * Metoda getData - metoda zwracająca datę wizyty
     * @return Data
     */

    public String getData() {
        return Data;
    }

    /**
     * Metoda getGodzina - metoda zwracająca godzinę wizyty
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
     * Metoda getPacjent - metoda zwracająca imię i nazwisko pacjenta wizyty
     * @return Pacjent
     */

    public String getPacjent() {
        return Pacjent;
    }

    /**
     * Metoda getLekarz - metoda zwracająca imię i nazwisko lekarza wizyty
     * @return Lekarz
     */

    public String getLekarz() {
        return Lekarz;
    }

}
