DELETE FROM adresy;
DELETE FROM konta;
DELETE FROM lekarze;
DELETE FROM pacjenci;
DELETE FROM wizyty;

INSERT INTO adresy (Ulica, Nr_domu, Kod_pocztowy, Miejscowosc)
VALUES ('Okulickiego', '22', '37-450', 'Stalowa Wola');

INSERT INTO adresy (Ulica, Nr_domu, Kod_pocztowy, Miejscowosc)
VALUES ('Poniatowskiego', '44', '44-444', 'Łódź');

INSERT INTO adresy (Ulica, Nr_domu, Kod_pocztowy, Miejscowosc)
VALUES ('Rejtana', '99', '33-401', 'Rzeszów');


INSERT INTO konta (Login, Haslo, Administrator, Lekarz, Pacjent)
VALUES (login1, 'qqq', 0, 1, 0);

INSERT INTO konta (Login, Haslo, Administrator, Lekarz, Pacjent)
VALUES (login2, 'www', 0 ,0, 1);

INSERT INTO konta (Login, Haslo, Administrator, Lekarz, Pacjent)
VALUES (login3, 'eee', 1, 0 ,0);


INSERT INTO lekarze (Imie, Nazwisko, PESEL, Telefon, Adres_ID, Login, Specjalizacja)
VALUES ('Jan', 'Kowalski', 12345678912, 987654321, 1, 111111, 'Laryngolog');


INSERT INTO pacjenci (Imie, Nazwisko, PESEL, Telefon, Adres_ID, Login)
VALUES ('Piotr', 'Nowak', 98765432198, 654987321, 2, 222222);


INSERT INTO wizyty (Data, Godzina, Opis, Status, Pacjent_ID, Lekarz_ID)
VALUES ('2020-03-10', '12:30:00', 'Test', 'Oczekująca', 1, 1);



