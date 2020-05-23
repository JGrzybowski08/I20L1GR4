DELETE FROM adresy;
DELETE FROM konta;
DELETE FROM lekarze;
DELETE FROM pacjenci;
DELETE FROM wizyty;


/* Adresy ------------------------------------ */;
INSERT INTO adresy (Adres_ID, Ulica, Nr_domu, Kod_pocztowy, Miejscowosc)
VALUES (1, 'Okulickiego', '22', '37-450', 'Stalowa Wola');

INSERT INTO adresy (Adres_ID, Ulica, Nr_domu, Kod_pocztowy, Miejscowosc)
VALUES (2, 'Poniatowskiego', '44', '44-444', 'Łódź');

INSERT INTO adresy (Adres_ID, Ulica, Nr_domu, Kod_pocztowy, Miejscowosc)
VALUES (3, 'Rejtana', '99', '33-401', 'Rzeszów');

INSERT INTO adresy (Adres_ID, Ulica, Nr_domu, Kod_pocztowy, Miejscowosc)
VALUES (4, 'Sobieskiego','23/24','57-000','Staszów');

INSERT INTO adresy (Adres_ID, Ulica, Nr_domu, Kod_pocztowy, Miejscowosc)
VALUES (5, 'Myśliborska','29','46-422','Warszawa');

INSERT INTO adresy (Adres_ID, Ulica, Nr_domu, Kod_pocztowy, Miejscowosc)
VALUES (6, 'Konopnickiej','451','33-401','Łódź');

INSERT INTO adresy (Adres_ID, Ulica, Nr_domu, Kod_pocztowy, Miejscowosc)
VALUES (7, 'Inflacka','1A','35-401','Konstancin Jeziorna');

INSERT INTO adresy (Adres_ID, Ulica, Nr_domu, Kod_pocztowy, Miejscowosc)
VALUES (8, 'Nowowiejska','97','75-435','Tychy');

INSERT INTO adresy (Adres_ID, Ulica, Nr_domu, Kod_pocztowy, Miejscowosc)
VALUES (9, 'Bonifratów','451','00-441','Katowice');

INSERT INTO adresy (Adres_ID, Ulica, Nr_domu, Kod_pocztowy, Miejscowosc)
VALUES (10, 'Braci Wagów','64/3A','53-136','Lubawa');

/* Adresy ------------------------------------ */;

/* Konta ------------------------------------- */;

/* Konta Administratorow */;
INSERT INTO konta (Login, Haslo, Administrator, Lekarz, Pacjent)
VALUES (111111, 'qqq', 1, 0, 0);
/* Konta Administratorow */;

/* Konta Lekarzy */;
INSERT INTO konta (Login, Haslo, Administrator, Lekarz, Pacjent)
VALUES (222222, 'www', 0 ,1, 0);

INSERT INTO konta (Login, Haslo, Administrator, Lekarz, Pacjent)
VALUES (333333, 'eee', 0, 1 ,0);

INSERT INTO konta (Login, Haslo, Administrator, Lekarz, Pacjent)
VALUES (444444,'rrr',0,1,0);

INSERT INTO konta (Login, Haslo, Administrator, Lekarz, Pacjent)
VALUES (555555,'ttt',0,1,0);
/* Konta Lekarzy */;

/* Konta Pacjentow */;
INSERT INTO konta (Login, Haslo, Administrator, Lekarz, Pacjent)
VALUES (666666,'yyy',0,0,1);

INSERT INTO konta (Login, Haslo, Administrator, Lekarz, Pacjent)
VALUES (777777,'uuu',0,0,1);

INSERT INTO konta (Login, Haslo, Administrator, Lekarz, Pacjent)
VALUES (888888,'iii',0,0,1);

INSERT INTO konta (Login, Haslo, Administrator, Lekarz, Pacjent)
VALUES (9999999, 'ooo', 0, 0 ,1);

INSERT INTO konta (Login, Haslo, Administrator, Lekarz, Pacjent)
VALUES (000000, 'ppp', 0, 0 ,1);
/* Konta Pacjentow */;

/* Konta ------------------------------------- */;


/* Lekarze ----------------------------------- */;
INSERT INTO lekarze (Lekarz_ID, Imie, Nazwisko, PESEL, Telefon, Adres_ID, Login, Specjalizacja)
VALUES (1, 'Jan', 'Kowalski', 78806243129, 229496313, 1, 222222, 'Laryngolog');

INSERT INTO lekarze (Lekarz_ID, Imie, Nazwisko, PESEL, Telefon, Adres_ID, Login, Specjalizacja)
VALUES (2,'Roman','Kot', 30265613965, 945695014, 2, 333333,'Chirulg');

INSERT INTO lekarze (Lekarz_ID, Imie, Nazwisko, PESEL, Telefon, Adres_ID, Login, Specjalizacja)
VALUES (3,'Lew','Sapiecha', 79154873985, 866789889, 3, 444444,'Internista');

INSERT INTO lekarze (Lekarz_ID, Imie, Nazwisko, PESEL, Telefon, Adres_ID, Login, Specjalizacja)
VALUES (4,'Damian','Rębala', 88765210869, 273935893, 4, 555555,'Neurolog');
/* Lekarze ----------------------------------- */;

/* Pacjenci ----------------------------------- */;
INSERT INTO pacjenci (Pacjent_ID, Imie, Nazwisko, PESEL, Telefon, Adres_ID, Login)
VALUES (1, 'Piotr', 'Nowak', 98765432198, 167509275, 5, 666666);

INSERT INTO pacjenci (Pacjent_ID, Imie, Nazwisko, PESEL, Telefon, Adres_ID, Login)
VALUES (2, 'Robert','Pyzdra', 63982857188, 433277143, 6, 777777);

INSERT INTO pacjenci (Pacjent_ID, Imie, Nazwisko, PESEL, Telefon, Adres_ID, Login)
VALUES (3, 'Michał','Świtał', 34824963990, 613104320, 7, 888888);

INSERT INTO pacjenci (Pacjent_ID, Imie, Nazwisko, PESEL, Telefon, Adres_ID, Login)
VALUES (4, 'Michalina','Głowacka', 66774899715, 308714943, 8, 999999);

INSERT INTO pacjenci (Pacjent_ID, Imie, Nazwisko, PESEL, Telefon, Adres_ID, Login)
VALUES (5, 'Martyna','Rąbala', 64147768997, 804711115, 9, 000000);

/* Pacjenci ----------------------------------- */;

/* Wizyty ----------------------------------- */;
INSERT INTO wizyty (Wizyta_ID, Data, Godzina, Opis, Status, Pacjent_ID, Lekarz_ID)
VALUES (1, '2020-03-10', '11:45:00', 'Wizyta1', 'Odwołana', 1, 1);

INSERT INTO wizyty (Wizyta_ID, Data, Godzina, Opis, Status, Pacjent_ID, Lekarz_ID)
VALUES (2, '2020-03-25', '15:15:00', 'Wizyta2', 'Zakończona', 2, 2);

INSERT INTO wizyty (Wizyta_ID, Data, Godzina, Opis, Status, Pacjent_ID, Lekarz_ID)
VALUES (3, '2020-03-30', '13:00:00', 'Wizyta3', 'Zakończona', 3, 2);

INSERT INTO wizyty (Wizyta_ID, Data, Godzina, Opis, Status, Pacjent_ID, Lekarz_ID)
VALUES (4, '2020-04-14', '09:00:00', 'Wizyta4', 'Odwołana', 4, 3);

INSERT INTO wizyty (Wizyta_ID, Data, Godzina, Opis, Status, Pacjent_ID, Lekarz_ID)
VALUES (5, '2020-04-19', '10:30:00', 'Wizyta5', 'Zakończona', 5, 4);

INSERT INTO wizyty (Wizyta_ID, Data, Godzina, Opis, Status, Pacjent_ID, Lekarz_ID)
VALUES (6, '2020-04-27', '11:45:00', 'Wizyta6', 'Odwołana', 1, 4);

INSERT INTO wizyty (Wizyta_ID, Data, Godzina, Opis, Status, Pacjent_ID, Lekarz_ID)
VALUES (7, '2020-05-10', '14:00:00', 'Wizyta7', 'Zakończona', 2, 3);

INSERT INTO wizyty (Wizyta_ID, Data, Godzina, Opis, Status, Pacjent_ID, Lekarz_ID)
VALUES (8, '2020-05-25', '13:45:00', 'Wizyta8', 'Oczekująca', 3, 2);

INSERT INTO wizyty (Wizyta_ID, Data, Godzina, Opis, Status, Pacjent_ID, Lekarz_ID)
VALUES (9, '2020-05-29', '12:15:00', 'Wizyta9', 'Oczekująca', 4, 1);

INSERT INTO wizyty (Wizyta_ID, Data, Godzina, Opis, Status, Pacjent_ID, Lekarz_ID)
VALUES (10, '2020-06-05', '11:00:00', 'Wizyta10', 'Oczekująca', 5, 1);

/* Wizyty ----------------------------------- */;


