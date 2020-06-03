package Models;

import java.util.Objects;

public class ModelZobaczLekarzy {
    private final String imie, nazwisko, telefon, specjalizacja, pesel, e_mail;

    public ModelZobaczLekarzy(String imie, String nazwisko, String telefon, String specjalizacja, String pesel, String e_mail) {
         this.imie = imie;
         this.nazwisko = nazwisko;
         this.telefon = telefon;
         this.specjalizacja = specjalizacja;
         this.pesel = pesel;
         this.e_mail = e_mail;
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public String getTelefon() {
        return telefon;
    }

    public String getSpecjalizacja() {
        return specjalizacja;
    }

    public String getPesel() {
        return pesel;
    }

    public String getE_mail() { return e_mail; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ModelZobaczLekarzy that = (ModelZobaczLekarzy) o;
        return Objects.equals(pesel, that.pesel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pesel);
    }
}
