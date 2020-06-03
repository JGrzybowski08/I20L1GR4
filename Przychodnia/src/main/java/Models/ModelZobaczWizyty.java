package Models;

import java.util.Objects;

public class ModelZobaczWizyty {
    private final String Data, Godzina, Lekarz, Pacjent, Opis, Status;

    public ModelZobaczWizyty(String data, String godzina, String lekarz, String pacjent, String opis, String status) {
        this.Data = data;
        this.Godzina = godzina;
        this.Lekarz = lekarz;
        this.Pacjent = pacjent;
        this.Opis = opis;
        this.Status = status;
    }

    public String getData() {
        return Data;
    }

    public String getGodzina() {
        return Godzina;
    }

    public String getLekarz() {
        return Lekarz;
    }

    public String getPacjent() {
        return Pacjent;
    }

    public String getOpis() {
        return Opis;
    }

    public String getStatus() {
        return Status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ModelZobaczWizyty that = (ModelZobaczWizyty) o;
        return Objects.equals(Lekarz, this.Lekarz);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Lekarz);
    }
}
