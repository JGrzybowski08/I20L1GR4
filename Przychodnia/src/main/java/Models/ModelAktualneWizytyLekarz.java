package Models;

public class ModelAktualneWizytyLekarz {
    private final String Data, Godzina, Pacjent, Opis, Status;

    public ModelAktualneWizytyLekarz(String data, String godzina, String opis, String status, String pacjent) {
        this.Data = data;
        this.Godzina = godzina;
        this.Opis = opis;
        this.Status = status;
        this.Pacjent = pacjent;
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

    public String getPacjent() {
        return Pacjent;
    }

}
