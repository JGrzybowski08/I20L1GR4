DELETE FROM adresy;
DELETE FROM konta;
DELETE FROM lekarze;
DELETE FROM pacjenci;
DELETE FROM wizyty;


INSERT INTO `konta` (`Login`, `Haslo`, `Administrator`, `Lekarz`, `Pacjent`) VALUES
(111, 'qqq', 1, 0, 0);