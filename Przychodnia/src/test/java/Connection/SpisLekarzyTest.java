package Connection;

import static org.mockito.Matchers.any;
import static org.powermock.api.mockito.PowerMockito.mock;
import static org.powermock.api.mockito.PowerMockito.when;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import Connection.AdministratorCon.SpisLekarzy;
import Models.ModelSpisLekarzy;
import javafx.collections.ObservableList;

@RunWith(PowerMockRunner.class)
@PrepareForTest({Polaczenie.class})
public class SpisLekarzyTest {
    @Test
    public void WszyscyLekarzeGetTest() throws SQLException {
        // given
        String testingImie = "testing.imie";
        String testingNazwisko = "testing.nazwisko";
        String testingEmail = "testing.email";
        Long testingPesel = 123123123L;
        Integer testingTelefon = 123123312;
        String testingSpecjalizacja = "testing.specjalizacja";
        String testingKodPocztowy = "testing.kod_pocztowy";
        String testingMiejscowosc = "testing.miejscowosc";
        String testingUlica = "testing.ulica";
        String testingNumerDomu = "testing.nr_domu";

        Connection connectionMock = mock(Connection.class);
        Statement statementMock = mock(Statement.class);
        ResultSet resultSetMock = mock(ResultSet.class);
        when(connectionMock.createStatement()).thenReturn(statementMock);
        when(statementMock.executeQuery(any())).thenReturn(resultSetMock);
        when(resultSetMock.getString(1)).thenReturn(testingImie);
        when(resultSetMock.getString(2)).thenReturn(testingNazwisko);
        when(resultSetMock.getString(3)).thenReturn(testingEmail);
        when(resultSetMock.getLong(4)).thenReturn(testingPesel);
        when(resultSetMock.getInt(5)).thenReturn(testingTelefon);
        when(resultSetMock.getString(6)).thenReturn(testingSpecjalizacja);
        when(resultSetMock.getString(7)).thenReturn(testingKodPocztowy);
        when(resultSetMock.getString(8)).thenReturn(testingMiejscowosc);
        when(resultSetMock.getString(9)).thenReturn(testingUlica);
        when(resultSetMock.getString(10)).thenReturn(testingNumerDomu);

        when(resultSetMock.next()).thenReturn(true, false);
        PowerMockito.mockStatic(Polaczenie.class);
        when(Polaczenie.Connect()).thenReturn(connectionMock);

        // when
        ObservableList<ModelSpisLekarzy> list = SpisLekarzy.WszyscyLekarzeGet();

        // then
        Assert.assertEquals("It should be one item in list", list.size(), 1);
        Assert.assertEquals("Imie is wrong", list.get(0).getImie(), testingImie);
        Assert.assertEquals("Nazwisko is wrong", list.get(0).getNazwisko(), testingNazwisko);
        Assert.assertEquals("Email is wrong", list.get(0).getEmail(), testingEmail);
        Assert.assertEquals("Pesel is wrong", Long.valueOf(list.get(0).getPesel()), testingPesel);
        Assert.assertEquals("Telefon is wrong", Integer.valueOf(list.get(0).getTelefon()), testingTelefon);
        Assert.assertEquals("Specjalizacja is wrong", list.get(0).getSpecjalizacja(), testingSpecjalizacja);
        Assert.assertEquals("kKodPocztowy is wrong", list.get(0).getKod_Pocztowy(), testingKodPocztowy);
        Assert.assertEquals("Miejscowosc is wrong", list.get(0).getMiejscowosc(), testingMiejscowosc);
        Assert.assertEquals("Ulica is wrong", list.get(0).getUlica(), testingUlica);
        Assert.assertEquals("NumerDomu is wrong", list.get(0).getNumer_Domu(), testingNumerDomu);
    }
}
