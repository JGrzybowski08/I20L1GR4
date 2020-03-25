# Specyfikacja projektu Przychodnia


### Temat projektu

Temat naszego projektu to oczywiście „przychodnia”, czyli coś z czym się spotkał każdy z nas, mowa tu oczywiście o przychodni lekarskiej. Pytanie czy mieliśmy kiedykolwiek możliwość obsługiwania takiej przychodni poprzez strone internetową.

### Zakres projektu

Projekt obejmuje wykonanie strony internetowej poświęconej przychodni, której głównym celem ma być ułatwienie nam rezerwowania wizyt oraz wykonanie bazy danych, która będzie  ją obsługiwała.


### Funkcjonalność
	Logowanie
	Rejestrowanie
	Możliwość zmiany danych
	Linki do stron zewnętrznych
	Przeglądanie aktualności
	Kontakt z przychodnia
	Anulowanie wizyt
	Przekładanie wizyt

### Wymagania stawiane aplikacji/systemowi
	Bezbłędna współpraca pomiędzy systemem a bazą danych
	Czytelny i przyjazny interfejs użytkownikom
	Responsywność strony
	Prosta obsługa przychodni
	Bezpieczeństwo i pofuność danych

## Użytkownicy aplikacji wraz z uprawnieniami
       
### Administrator
	Dodawanie wizyt
	Edytowanie wizyt
	Usuwanie wizyt
	Aktualizowanie profilu użytkownika/pacjenta
	Dodawanie użytkowników do grup
	Dodawanie lekarzy
	Przeglądanie lekarzy
	Usuwanie lekarzy
	Generowanie raportów
	Zarządzanie panele administracyjnym
    
### Pacjent/Lekarz
	Logowanie/rejestracja
	Przeglądanie swoich wizyt
	Przeglądanie statusu danej wizyty
	Dodawanie wizyt
	Edytowanie wizyt
	Usunięcie wizyty
	
## Klienci aplikacji

Dla naszej aplikacji o nazwie „Przychodnia”, która obsługuję przychodnie lekarską, potencjalnym użytkownikiem jest nikt inny jak pacjent. Aplikacja ma za zadanie takiemu pacjentowi pozwolić na umówienie się w danym terminie na wizytę. Z racji, że pacjenci mogą być różni responsywność oraz czytelność aplikacji jest bardzo wysoka.

## Wykorzystane technologie

### JavaFX

Rodzina technologii i produktów firmy Sun Microsystems, przeznaczonych głównie do tworzenia Rich Internet Application. W skład JavaFX wchodzi język skryptowy JavaFX Script oraz system dla urządzeń mobilnych Java ME.

### CSS

Czyli kaskadowe arkusze stylów (od ang. Cascading Style Sheets) to język używany do opisu układu elementów na stronie WWW. Można za jego pomocą zdefiniować wiele parametrów, takich jak rodzaj czcionek, kolor tła, wyrównanie elementów na stronie itp. Powstał w 1996 roku w celu odseparowania struktury dokumentu od formy jego prezentacji. Jest kilka sposobów stosowania CSS, przykładowo: użycie wewnątrz danego dokumentu znacznika „style”, jednak najbardziej użyteczną jest posłużenie się osobnym arkuszem stylów, w którym zawrzemy wszystkie informacje dotyczące układu graficznego strony.

## Diagramy UML

### Przypadków użycia
![Przypadków użycia](https://user-images.githubusercontent.com/37274710/77594557-1e25e980-6ef7-11ea-802b-86b8467b6d98.PNG)

### Przypadków klas
![Przypadków klas](https://user-images.githubusercontent.com/37274710/77594616-4877a700-6ef7-11ea-8ef5-c004e817e0a9.PNG)

### Przypadków związków encji
![Przypadków związków encji](https://user-images.githubusercontent.com/37274710/77594615-47df1080-6ef7-11ea-95e9-6714ef6e59a4.PNG)

### Przypadków aktywności
![Przypadków aktywności](https://user-images.githubusercontent.com/37274710/77594612-47467a00-6ef7-11ea-95c5-6e71e9e9038b.PNG)

### Przypadków stanów
![Przypadków stanów](https://user-images.githubusercontent.com/37274710/77594619-49103d80-6ef7-11ea-845f-7e6d553109eb.PNG)

### Przypadków sekwencji
![Przypadków sekwencji](https://user-images.githubusercontent.com/37274710/77594621-49103d80-6ef7-11ea-989c-151fc76a20f7.PNG)
