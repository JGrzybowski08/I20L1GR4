package Connection;

import Models.ModelSpisWizyt;
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
public class ZobaczWizytyTest {
    @Test
public void ZobaczWizytyGetTest() throws SQLException {
    // given
        String testingData = "testing.data";
        String testingGodzina = "testing.godzina";
        String testingLekarz = "testing.lekarz";
        String testingStatus = "testing.status";

    Connection connectionMock = mock(Connection.class);
    Statement statementMock = mock(Statement.class);
    ResultSet resultSetMock = mock(ResultSet.class);
    when(connectionMock.createStatement()).thenReturn(statementMock);
    when(statementMock.executeQuery(any())).thenReturn(resultSetMock);
    when(resultSetMock.getString(1)).thenReturn(null);
    when(resultSetMock.getString(2)).thenReturn(null);
    when(resultSetMock.getString(3)).thenReturn(null);
    when(resultSetMock.getString(6)).thenReturn(null);


    when(resultSetMock.next()).thenReturn(true, false);
    PowerMockito.mockStatic(Polaczenie.class);
    when(Polaczenie.Connect()).thenReturn(connectionMock);

    // when
    ObservableList<ModelSpisWizyt> list = ZobaczWizyty.ZobaczWizytyGet();

    // then
    Assert.assertEquals("It should be one item in list", list.size(), 1);
    Assert.assertEquals("Imie is wrong", list.get(0).getData(), null);
    Assert.assertEquals("Godzina is wrong", list.get(0).getGodzina(), null);
    Assert.assertEquals("Name of Lekarz is wrong", list.get(0).getLekarz(), null);
    Assert.assertEquals("Status is wrong", list.get(0).getStatus(), null);

}


}
