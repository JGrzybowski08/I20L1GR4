import Connection.AdministratorCon.SpisLekarzy;
import Connection.Polaczenie;
import Models.ModelSpisLekarzy;
import javafx.collections.ObservableList;
import org.junit.Assert;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.mockito.Matchers.any;
import static org.powermock.api.mockito.PowerMockito.mock;
import static org.powermock.api.mockito.PowerMockito.when;

@PrepareForTest({Polaczenie.class})
public class SpisWizytTest {
    @Test
    public void WszyscyWizytyGetTest() throws SQLException {
      //  // given
     //   String testingData = "testing.data";
      //  String testingGodzina = "testing.godzina";
      //  String testingOpis = "testing.opis";
      //  Long  testingStatus = 1233123213L;



      //  Connection connectionMock = mock(Connection.class);
      //  Statement statementMock = mock(Statement.class);
       // ResultSet resultSetMock = mock(ResultSet.class);
       // when(connectionMock.createStatement()).thenReturn(statementMock);
       // when(statementMock.executeQuery(any())).thenReturn(resultSetMock);
       // when(resultSetMock.getString(1)).thenReturn(testingData);
      //  when(resultSetMock.getString(2)).thenReturn(testingGodzina);
      //  when(resultSetMock.getString(3)).thenReturn(testingOpis);
       // when(resultSetMock.getLong(4)).thenReturn(testingStatus);



    //    when(resultSetMock.next()).thenReturn(true, false);
     //   PowerMockito.mockStatic(Polaczenie.class);
     //   when(Polaczenie.Connect()).thenReturn(connectionMock);

        // when
     //   ObservableList<ModelSpisLekarzy> list = SpisLekarzy.WszyscyLekarzeGet();
//
        // then
   //     Assert.assertEquals("It should be one item in list", list.size(), 1);
     //   Assert.assertEquals("Data is wrong", list.get(0).getData(), testingData);
     //   Assert.assertEquals("Godzina is wrong", list.get(0).getNazwisko(), testingGodzina);
      //  Assert.assertEquals("Opis is wrong", list.get(0).getEmail(), testingOpis);
      //  Assert.assertEquals("Status is wrong", Long.valueOf(list.get(0).getPesel()), testingStatus);

    }
}
