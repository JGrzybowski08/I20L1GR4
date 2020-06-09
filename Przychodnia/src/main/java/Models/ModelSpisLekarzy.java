package Models;

import java.util.Objects;

/**
 * Klasa ModelAktualneSpisLekarzy - model do tabeli wyświetlającej wszystkich lekarzy
 */

public class ModelSpisLekarzy {
    private final String Imie, Nazwisko, Email, Specjalizacja, Numer_Domu, Kod_Pocztowy, Miejscowosc, Ulica;
    private final long Pesel;
    private final int Telefon;

    /**
     * Konstruktor ModelSpisLekarzy - kontruktor modelu spisu lekarzy
     * @param imie
     * @param nazwisko
     * @param email
     * @param pesel
     * @param telefon
     * @param specjalizacja
     * @param kod_pocztowy
     * @param miejscowosc
     * @param ulica
     * @param nr_domu
     */

    public ModelSpisLekarzy(String imie, String nazwisko, String email, long pesel, int telefon, String specjalizacja, String kod_pocztowy, String miejscowosc, String ulica, String nr_domu) {
        this.Imie = imie;
        this.Nazwisko = nazwisko;
        this.Email = email;
        this.Pesel = pesel;
        this.Telefon = telefon;
        this.Specjalizacja = specjalizacja;
        this.Kod_Pocztowy = kod_pocztowy;
        this.Miejscowosc = miejscowosc;
        this.Ulica = ulica;
        this.Numer_Domu = nr_domu;
    }

    /**
     *  Metoda getImie - metoda zwracająca imię lekarza
     * @return Imie
     */

    public String getImie() {
        return Imie;
    }

    /**
     *  Metoda getNazwisko - metoda zwracająca nazwisko lekarza
     * @return Nazwisko
     */

    public String getNazwisko() {
        return Nazwisko;
    }

    /**
     *  Metoda getEmail - metoda zwracająca e-mail lekarza
     * @return Email
     */

    public String getEmail() {
        return Email;
    }

    /**
     *  Metoda getPesel - metoda zwracająca numer pesel lekarza
     * @return Pesel
     */

    public long getPesel() {
        return Pesel;
    }

    /**
     *  Metoda getTelefon - metoda zwracająca numer telefonu lekarza
     * @return Telefon
     */

    public int getTelefon() {
        return Telefon;
    }

    /**
     *  Metoda getSpecjalizacja - metoda zwracająca specjalizację lekarza
     * @return Specjalizacja
     */

    public String getSpecjalizacja() {
        return Specjalizacja;
    }

    /**
     *  Metoda getNumer_Domu - metoda zwracająca numer domu, pod którym mieszka lekarz
     * @return Numer_Domu
     */

    public String getNumer_Domu() {
        return Numer_Domu;
    }

    /**
     *  Metoda getKod_Pocztowy - metoda zwracająca kod pocztowy miejscowości, w której mieszka lekarz
     * @return Kod_Pocztowy
     */

    public String getKod_Pocztowy() {
        return Kod_Pocztowy;
    }

    /**
     *  Metoda getMiejscowosc - metoda zwracająca miejscowość w której mieszka lekarz
     * @return Miejscowosc
     */

    public String getMiejscowosc() {
        return Miejscowosc;
    }

    /**
     *  Metoda getUlica - metoda zwracająca ulicę, na której znajduje się mieszkanie lekarza
     * @return Ulica
     */

    public String getUlica() {
        return Ulica;
    }

    /**
     * Metoda equals porównująca pesele lekarzy
     * @param o
     * @return
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ModelSpisLekarzy that = (ModelSpisLekarzy) o;
        return Objects.equals(Pesel, that.Pesel);
    }

    /**
     * Metoda hashCode zwracająca unikalny pesel
     * @return
     */

    @Override
    public int hashCode() {
        return Objects.hash(Pesel);
    }
}
