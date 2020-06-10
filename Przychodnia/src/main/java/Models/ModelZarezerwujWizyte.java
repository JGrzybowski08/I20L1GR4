package Models;

/**
 * Klasa ModelZarezerwujWizyte - model do tabeli umożliwiającej rezerwowanie wizyt
 */

public class ModelZarezerwujWizyte {
    private final String Imie, Nazwisko, Email, Specjalizacja;
    private final int Telefon;

    /**
     * Kontruktor ModelZarezerwujWizyte - kontruktor modelu rezerwowania wizyt
     * @param imie
     * @param nazwisko
     * @param email
     * @param telefon
     * @param specjalizacja
     */

    public ModelZarezerwujWizyte(String imie, String nazwisko, String email, int telefon, String specjalizacja) {
        Imie = imie;
        Nazwisko = nazwisko;
        Email = email;
        Specjalizacja = specjalizacja;
        Telefon = telefon;
    }

    /**
     * Metoda getImie - metoda zwracająca imię
     * @return Imie
     */

    public String getImie() {
        return Imie;
    }

    /**
     * Metoda getNazwisko - metoda zwracająca nazwisko
     * @return Nazwisko
     */

    public String getNazwisko() {
        return Nazwisko;
    }

    /**
     * Metoda getEmail - metoda zwracająca E-mail
     * @return Email
     */

    public String getEmail() {
        return Email;
    }

    /**
     * Metoda getSpecjalizacja - metoda zwracająca specjalizację
     * @return Specjalizacja
     */

    public String getSpecjalizacja() {
        return Specjalizacja;
    }

    /**
     * Metoda getTelefon - metoda zwracająca numer telefonu
     * @return Telefon
     */

    public int getTelefon() {
        return Telefon;
    }
}
