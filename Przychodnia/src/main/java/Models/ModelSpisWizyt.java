package Models;

import java.util.Objects;

public class ModelSpisWizyt {
    private final String Data, Godzina, Lekarz, Pacjent, Opis, Status;

    public ModelSpisWizyt(String data, String godzina, String opis, String status, String pacjent, String lekarz) {
        this.Data = data;
        this.Godzina = godzina;
        this.Opis = opis;
        this.Status = status;
        this.Pacjent = pacjent;
        this.Lekarz = lekarz;
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

    public String getLekarz() {
        return Lekarz;
    }

}
