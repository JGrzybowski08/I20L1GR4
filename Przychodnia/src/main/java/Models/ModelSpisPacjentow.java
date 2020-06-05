package Models;

public class ModelSpisPacjentow {
    private String Imie, Nazwisko, Kod_Pocztowy, Miejscowosc, Numer_Domu, Ulica;
    private long Pesel;
    private int Telefon;

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

    public String getImie() {
        return Imie;
    }

    public String getNazwisko() {
        return Nazwisko;
    }

    public long getPesel() {
        return Pesel;
    }

    public int getTelefon() {
        return Telefon;
    }

    public String getKod_Pocztowy() {
        return Kod_Pocztowy;
    }

    public String getMiejscowosc() {
        return Miejscowosc;
    }

    public String getUlica() {
        return Ulica;
    }

    public String getNumer_Domu() {
        return Numer_Domu;
    }
}
