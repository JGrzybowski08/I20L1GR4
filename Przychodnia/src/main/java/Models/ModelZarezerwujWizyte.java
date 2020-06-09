package Models;

public class ModelZarezerwujWizyte {
    private final String Imie, Nazwisko, Email, Specjalizacja;
    private final int Telefon;

    public ModelZarezerwujWizyte(String imie, String nazwisko, String email, int telefon, String specjalizacja) {
        Imie = imie;
        Nazwisko = nazwisko;
        Email = email;
        Specjalizacja = specjalizacja;
        Telefon = telefon;
    }

    public String getImie() {
        return Imie;
    }

    public String getNazwisko() {
        return Nazwisko;
    }

    public String getEmail() {
        return Email;
    }

    public String getSpecjalizacja() {
        return Specjalizacja;
    }

    public int getTelefon() {
        return Telefon;
    }
}
