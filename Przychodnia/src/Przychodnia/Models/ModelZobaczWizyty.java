package Przychodnia.Models;


public class ModelZobaczWizyty {
    String Data, Godzina, Lekarz, Opis, Status;

    public ModelZobaczWizyty(String data, String godzina, String lekarz, String opis, String status) {
        Data = data;
        Godzina = godzina;
        Lekarz = lekarz;
        Opis = opis;
        Status = status;
    }

    public String getData() {
        return Data;
    }

    public void setData(String data) {
        Data = data;
    }

    public String getGodzina() {
        return Godzina;
    }

    public void setGodzina(String godzina) {
        Godzina = godzina;
    }

    public String getLekarz() {
        return Lekarz;
    }

    public void setLekarz(String lekarz) {
        Lekarz = lekarz;
    }

    public String getOpis() {
        return Opis;
    }

    public void setOpis(String opis) {
        Opis = opis;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }
}
