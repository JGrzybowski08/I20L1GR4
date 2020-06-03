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
VALUES (111, '111', 1, 0, 0);
/* Konta Administratorow */;

/* Konta Lekarzy */;
INSERT INTO konta (Login, Haslo, Administrator, Lekarz, Pacjent)
VALUES (35412342, 'www', 0 ,1, 0);

INSERT INTO konta (Login, Haslo, Administrator, Lekarz, Pacjent)
VALUES (345164, 'eee', 0, 1 ,0);

INSERT INTO konta (Login, Haslo, Administrator, Lekarz, Pacjent)
VALUES (874457,'rrr',0,1,0);

INSERT INTO konta (Login, Haslo, Administrator, Lekarz, Pacjent)
VALUES (923456,'ttt',0,1,0);

INSERT INTO konta (Login, Haslo, Administrator, Lekarz, Pacjent)
VALUES (236576,'aaa',0,1,0);

INSERT INTO konta (Login, Haslo, Administrator, Lekarz, Pacjent)
VALUES (33335253,'ghh',0,1,0);
/* Konta Lekarzy */;

/* Konta Pacjentow */;
INSERT INTO konta (Login, Haslo, Administrator, Lekarz, Pacjent)
VALUES (312354,'yyy',0,0,1);

INSERT INTO konta (Login, Haslo, Administrator, Lekarz, Pacjent)
VALUES (67454,'uuu',0,0,1);

INSERT INTO konta (Login, Haslo, Administrator, Lekarz, Pacjent)
VALUES (96346,'iii',0,0,1);

INSERT INTO konta (Login, Haslo, Administrator, Lekarz, Pacjent)
VALUES (96347, 'ooo', 0, 0 ,1);

INSERT INTO konta (Login, Haslo, Administrator, Lekarz, Pacjent)
VALUES (96345, 'ppp', 0, 0 ,1);

INSERT INTO konta (Login, Haslo, Administrator, Lekarz, Pacjent)
VALUES (22166122, 'ppp', 0, 0 ,1);
/* Konta Pacjentow */;

/* Konta ------------------------------------- */;


/* Lekarze ----------------------------------- */;
INSERT INTO `lekarze` VALUES (1,'Roman','Kot',111123421,'Chirurg',1,35412342, 'rkot@przychodnia.pl');
INSERT INTO `lekarze` VALUES (2,'Lew','Sapiecha',923654321,'Internista',1,345164, 'lewsapiecha@przychodnia.pl');
INSERT INTO `lekarze` VALUES (3,'Damian','Rębala',323423432,'Neurolog',1,874457, 'damianrebala@przychodnia.pl');
INSERT INTO `lekarze` VALUES (4,'Daniel','Kęsy',987654567,'Kardiolog',1,923456, 'kesydaniel@przychodnia.pl');
INSERT INTO `lekarze` VALUES (5,'Rafał','Chmiel',987654367,'Internista',1,236576, 'chmiel223@przychodnia.pl');
INSERT INTO `lekarze` VALUES (7,'Jan','Kowalski',987654321,'Laryngolog',1,33335253, 'kowalski82@przychodnia.pl');
/* Lekarze ----------------------------------- */;

/* Pacjenci ----------------------------------- */;
INSERT INTO `pacjenci` VALUES (1,'Robert','Pyzdra',454573423,1,312354, 'rpyzdra@przychodnia.pl');
INSERT INTO `pacjenci` VALUES (2,'Michał','Świtał',763233432,1,67454, 'mswital@przychodnia.pl');
INSERT INTO `pacjenci` VALUES (3,'Michalina','Głowacka',98753343,2,96346, 'michglowacka@przychodnia.pl');
INSERT INTO `pacjenci` VALUES (4,'Martyna','Rąbala',56235543,3,96347, 'rabala22@przychodnia.pl');
INSERT INTO `pacjenci` VALUES (5,'Bogumiła','Luba',84456742,4,96345, 'bluba223@przychodnia.pl');
INSERT INTO `pacjenci` VALUES (6,'Piotr','Nowak',654987321,2,22166122, 'nowak293@przychodnia.pl');

/* Pacjenci ----------------------------------- */;

/* Wizyty ----------------------------------- */;
INSERT INTO `wizyty` VALUES (1,'2020-03-10','12:30:00','Test uzębienia','Trwa',2,2);
INSERT INTO `wizyty` VALUES (2,'2020-06-12','12:30:00','Test nogi','Przełożona',3,1);
INSERT INTO `wizyty` VALUES (3,'2020-04-01','12:30:00','Test ramienia','Wygasła',4,1);
INSERT INTO `wizyty` VALUES (4,'2020-07-17','12:30:00','Test głowy','Umówiona',4,3);
INSERT INTO `wizyty` VALUES (5,'2020-03-10','12:30:00','Test','Oczekuj?ca',1,1);
INSERT INTO `wizyty` VALUES (6,'2020-06-22','12:30:00','Test nadgarstka','Oczekująca',2,5);
INSERT INTO `wizyty` VALUES (7,'2020-06-22','12:30:00','Omówienie zmian','Oczekująca',3,6);
INSERT INTO `wizyty` VALUES (8,'2020-06-22','12:30:00','Boli kolano','Oczekująca',5,4);
INSERT INTO `wizyty` VALUES (9,'2020-06-22','12:30:00','Złamany palec','Oczekująca',1,2);
INSERT INTO `wizyty` VALUES (10,'2020-06-22','12:30:00','Test piszczela','Oczekująca',1,1);

/* Wizyty ----------------------------------- */;


