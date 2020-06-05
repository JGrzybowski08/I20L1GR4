package Models;

import java.util.Objects;

public class ModelSpisLekarzy {
    private final String Imie, Nazwisko, Email, Specjalizacja, Numer_Domu, Kod_Pocztowy, Miejscowosc, Ulica;
    private final long Pesel;
    private final int Telefon;

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

    public String getImie() {
        return Imie;
    }

    public String getNazwisko() {
        return Nazwisko;
    }

    public String getEmail() {
        return Email;
    }

    public long getPesel() {
        return Pesel;
    }

    public int getTelefon() {
        return Telefon;
    }

    public String getSpecjalizacja() {
        return Specjalizacja;
    }

    public String getNumer_Domu() {
        return Numer_Domu;
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ModelSpisLekarzy that = (ModelSpisLekarzy) o;
        return Objects.equals(Pesel, that.Pesel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Pesel);
    }
}
