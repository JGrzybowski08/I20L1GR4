package Connection;

import Connection.PacjentCon.AktualneWizytyPacjent;
import Connection.PacjentCon.ZarezerwujWizyte;
import Models.ModelAktualneWizytyPacjent;
import Models.ModelZarezerwujWizyte;
import javafx.collections.ObservableList;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.mockito.Matchers.any;
import static org.powermock.api.mockito.PowerMockito.mock;
import static org.powermock.api.mockito.PowerMockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest({Polaczenie.class})
public class ZarezerwujWizyteTest {
    @Test
    public void ZarezerwujWizyteTest() throws SQLException {
        //given
        String testingImie = "testing.imie";
        String testingNazwisko = "testing.nazwisko";
        String testingEmail = "testing.Email";
        int testingTelefon = 123456789;
        String testingSpecjalizacja = "testing.specjalizacja";


        Connection connectionMock = mock(Connection.class);
        Statement statementMock = mock(Statement.class);
        ResultSet resultSetMock = mock(ResultSet.class);
        when(connectionMock.createStatement()).thenReturn(statementMock);
        when(statementMock.executeQuery(any())).thenReturn(resultSetMock);

        when(resultSetMock.getString(1)).thenReturn(testingImie);
        when(resultSetMock.getString(2)).thenReturn(testingNazwisko);
        when(resultSetMock.getString(3)).thenReturn(testingEmail);
        when(resultSetMock.getInt(4)).thenReturn(testingTelefon);
        when(resultSetMock.getString(5)).thenReturn(testingSpecjalizacja);

        when(resultSetMock.next()).thenReturn(true, false);
        PowerMockito.mockStatic(Polaczenie.class);
        when(Polaczenie.Connect()).thenReturn(connectionMock);

        // when
        ObservableList<ModelZarezerwujWizyte> list = ZarezerwujWizyte.WszyscyLekarzeGet();

        // then
        Assert.assertEquals("It should be one item in list", list.size(), 1);
        Assert.assertEquals("Imie is wrong", list.get(0).getImie(), testingImie);
        Assert.assertEquals("Nazwisko is wrong", list.get(0).getNazwisko(), testingNazwisko);
        Assert.assertEquals("Email is wrong", list.get(0).getEmail(), testingEmail);
        Assert.assertEquals("Telefon is wrong", list.get(0).getTelefon(), testingTelefon);
        Assert.assertEquals("Specjalizacja is wrong", list.get(0).getSpecjalizacja(), testingSpecjalizacja);

    }

    @Test
    public void FiltrowaneWizytyTest() throws SQLException {
        //given
        String testingImie = "testing.imie";
        String testingNazwisko = "testing.nazwisko";
        String testingEmail = "testing.Email";
        int testingTelefon = 123456789;
        String testingSpecjalizacja = "testing.specjalizacja";


        Connection connectionMock = mock(Connection.class);
        Statement statementMock = mock(Statement.class);
        ResultSet resultSetMock = mock(ResultSet.class);
        when(connectionMock.createStatement()).thenReturn(statementMock);
        when(statementMock.executeQuery(any())).thenReturn(resultSetMock);

        when(resultSetMock.getString(1)).thenReturn(testingImie);
        when(resultSetMock.getString(2)).thenReturn(testingNazwisko);
        when(resultSetMock.getString(3)).thenReturn(testingEmail);
        when(resultSetMock.getInt(4)).thenReturn(testingTelefon);
        when(resultSetMock.getString(5)).thenReturn(testingSpecjalizacja);

        when(resultSetMock.next()).thenReturn(true, false);
        PowerMockito.mockStatic(Polaczenie.class);
        when(Polaczenie.Connect()).thenReturn(connectionMock);

        // when
        ObservableList<ModelZarezerwujWizyte> list = ZarezerwujWizyte.FiltrowaniLekarzeGet("Email", testingEmail);

        // then
        Assert.assertEquals("It should be one item in list", list.size(), 1);
        Assert.assertEquals("Imie is wrong", list.get(0).getImie(), testingImie);
        Assert.assertEquals("Nazwisko is wrong", list.get(0).getNazwisko(), testingNazwisko);
        Assert.assertEquals("Email is wrong", list.get(0).getEmail(), testingEmail);
        Assert.assertEquals("Telefon is wrong", list.get(0).getTelefon(), testingTelefon);
        Assert.assertEquals("Specjalizacja is wrong", list.get(0).getSpecjalizacja(), testingSpecjalizacja);

    }
}
