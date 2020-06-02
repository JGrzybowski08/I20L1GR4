package Connection;

import Models.ModelZobaczLekarzy;
import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.modules.junit4.PowerMockRunner;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import static org.mockito.Matchers.any;
import static org.powermock.api.mockito.PowerMockito.mock;
import static org.powermock.api.mockito.PowerMockito.when;

//TODO nie dziala do końca

@RunWith(PowerMockRunner.class)
public class SpisLekarzyTest {
    @Test
    public void WszyscyLekarzeGetTest() throws SQLException {
        // given
        Connection connectionMock = mock(Connection.class);
        Statement statementMock = mock(Statement.class);
        ResultSet resultSetMock = mock(ResultSet.class);
        ObservableList observableListMock = new ObservableList() {
            @Override
            public void addListener(InvalidationListener listener) {

            }

            @Override
            public void removeListener(InvalidationListener listener) {

            }

            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public boolean add(Object o) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean addAll(Collection c) {
                return false;
            }

            @Override
            public boolean addAll(int index, Collection c) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public boolean equals(Object o) {
                return false;
            }

            @Override
            public int hashCode() {
                return 0;
            }

            @Override
            public Object get(int index) {
                return null;
            }

            @Override
            public Object set(int index, Object element) {
                return null;
            }

            @Override
            public void add(int index, Object element) {

            }

            @Override
            public Object remove(int index) {
                return null;
            }

            @Override
            public int indexOf(Object o) {
                return 0;
            }

            @Override
            public int lastIndexOf(Object o) {
                return 0;
            }

            @Override
            public ListIterator listIterator() {
                return null;
            }

            @Override
            public ListIterator listIterator(int index) {
                return null;
            }

            @Override
            public List subList(int fromIndex, int toIndex) {
                return null;
            }

            @Override
            public boolean retainAll(Collection c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection c) {
                return false;
            }

            @Override
            public boolean containsAll(Collection c) {
                return false;
            }

            @Override
            public ModelZobaczLekarzy[] toArray(Object[] a) {
                return new ModelZobaczLekarzy[0];
            }

            @Override
            public void addListener(ListChangeListener listener) {

            }

            @Override
            public void removeListener(ListChangeListener listener) {

            }

            @Override
            public boolean addAll(Object[] elements) {
                return false;
            }

            @Override
            public boolean setAll(Object[] elements) {
                return false;
            }

            @Override
            public boolean setAll(Collection col) {
                return false;
            }

            @Override
            public boolean removeAll(Object[] elements) {
                return false;
            }

            @Override
            public boolean retainAll(Object[] elements) {
                return false;
            }

            @Override
            public void remove(int from, int to) {

            }

            public String toString() {
                return "";
            }
        };
//        FXCollections fxCollectionsMock = mock(FXCollections.class);
        when(connectionMock.createStatement()).thenReturn(statementMock);
        when(statementMock.executeQuery(any())).thenReturn(resultSetMock);
        when(resultSetMock.getString(any())).thenReturn("column value");
        when(resultSetMock.next()).thenReturn(true, false);
//        ObservableList<Object> test = mock(ObservableList.class);
//        when(FXCollections.observableArrayList()).thenReturn(test);
        when(Polaczenie.Connect()).thenReturn(connectionMock);

        // when
        SpisLekarzy.WszyscyLekarzeGet();

        // then
    }
}
