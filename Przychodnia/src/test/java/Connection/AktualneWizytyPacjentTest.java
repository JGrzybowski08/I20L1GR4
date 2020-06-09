package Connection;

import static org.mockito.Matchers.any;
import static org.powermock.api.mockito.PowerMockito.mock;
import static org.powermock.api.mockito.PowerMockito.when;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Connection.LekarzCon.AktualneWizytyLekarz;
import Connection.PacjentCon.AktualneWizytyPacjent;
import Models.ModelAktualneWizytyLekarz;
import Models.ModelAktualneWizytyPacjent;
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
public class AktualneWizytyPacjentTest {
    @Test
    public void WszystkieWizytyGetTest() throws SQLException {
        // given
        String testingData = "testing.data";
        String testingGodzina = "testing.godzina";
        String testingOpis = "testing.opis";
        String testingStatus = "testing.status";

        Connection connectionMock = mock(Connection.class);
        Statement statementMock = mock(Statement.class);
        ResultSet resultSetMock = mock(ResultSet.class);
        when(connectionMock.createStatement()).thenReturn(statementMock);
        when(statementMock.executeQuery(any())).thenReturn(resultSetMock);
        when(resultSetMock.getString(1)).thenReturn(testingData);
        when(resultSetMock.getString(2)).thenReturn(testingGodzina);
        when(resultSetMock.getString(3)).thenReturn(testingOpis);
        when(resultSetMock.getString(4)).thenReturn(testingStatus);

        when(resultSetMock.next()).thenReturn(true, false);
        PowerMockito.mockStatic(Polaczenie.class);
        when(Polaczenie.Connect()).thenReturn(connectionMock);

        // when
        ObservableList<ModelAktualneWizytyPacjent> list = AktualneWizytyPacjent.WszystkieWizytyGet(1);

        // then
        Assert.assertEquals("It should be one item in list", list.size(), 1);
        Assert.assertEquals("data is wrong", list.get(0).getData(), testingData);
        Assert.assertEquals("godzina is wrong", list.get(0).getGodzina(), testingGodzina);
        Assert.assertEquals("opis is wrong", list.get(0).getOpis(), testingOpis);
        Assert.assertEquals("status is wrong1", list.get(0).getStatus(), testingStatus);

    }
}

