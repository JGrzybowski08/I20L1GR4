package Models;

public class ModelAktualneWizytyPacjent {
    private final String Data, Godzina, Lekarz, Opis, Status;

    public ModelAktualneWizytyPacjent(String data, String godzina, String opis, String status, String lekarz) {
        Data = data;
        Godzina = godzina;
        Opis = opis;
        Status = status;
        Lekarz = lekarz;
    }

    public String getData() {
        return Data;
    }

    public String getGodzina() {
        return Godzina;
    }

    public String getOpis() {
        return Opis;
    }

    public String getStatus() {
        return Status;
    }

    public String getLekarz() {
        return Lekarz;
    }
}
