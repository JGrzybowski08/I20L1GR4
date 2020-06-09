package Models;

/**
 * Klasa ModelSpisPacjentow - model do tabeli wyświetlającej dane pacjentów
 */

public class ModelSpisPacjentow {
    private String Imie, Nazwisko, Kod_Pocztowy, Miejscowosc, Numer_Domu, Ulica;
    private long Pesel;
    private int Telefon;

    /**
     * Konstruktor ModelSpisPacjentow - konstruktor modelu spisu pacjentów
     * @param imie
     * @param nazwisko
     * @param pesel
     * @param telefon
     * @param kod_Pocztowy
     * @param miejscowosc
     * @param ulica
     * @param numer_Domu
     */

    public ModelSpisPacjentow(String imie, String nazwisko, long pesel, int telefon, String kod_Pocztowy, String miejscowosc, String ulica, String numer_Domu) {
        Imie = imie;
        Nazwisko = nazwisko;
        Pesel = pesel;
        Telefon = telefon;
        Kod_Pocztowy = kod_Pocztowy;
        Miejscowosc = miejscowosc;
        Numer_Domu = numer_Domu;
        Ulica = ulica;
    }

    /**
     * Metoda getImie - metoda zwracająca imię pacjenta
     * @return Imie
     */

    public String getImie() {
        return Imie;
    }

    /**
     * Metoda getNazwisko - metoda zwracająca nazwisko pacjenta
     * @return Nazwisko
     */

    public String getNazwisko() {
        return Nazwisko;
    }

    /**
     * Metoda getPesel - metoda zwracająca pesel pacjenta
     * @return Pesel
     */

    public long getPesel() {
        return Pesel;
    }

    /**
     * Metoda getTelefon - metoda zwracająca numer telefonu pacjenta
     * @return Telefon
     */

    public int getTelefon() {
        return Telefon;
    }

    /**
     * Metoda getKod_Pocztowy - metoda zwracająca kod pocztowy miejscowości, w której mieszka pacjent
     * @return Kod_Pocztowy
     */

    public String getKod_Pocztowy() {
        return Kod_Pocztowy;
    }

    /**
     * Metoda getMiejscowosc - metoda zwracająca miejscowość, w któej mieszka pacjent
     * @return Miejscowosc
     */

    public String getMiejscowosc() {
        return Miejscowosc;
    }

    /**
     * Metoda getUlica - metoda zwracająca ulicę, na której jest znajduje się mieszkanie pacjenta
     * @return Ulica
     */

    public String getUlica() {
        return Ulica;
    }

    /**
     * Metoda getNumer_Domu - metoda zwracająca numer domu, pod którym mieszka pacjent
     * @return Numer_Domu
     */

    public String getNumer_Domu() {
        return Numer_Domu;
    }
}
