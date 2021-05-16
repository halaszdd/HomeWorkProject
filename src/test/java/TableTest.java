import model.Table;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TableTest {
    Table table = new Table();

    @Test
    void checkParameters() {

        assertTrue(table.checkParameters(7,5));
        assertFalse(table.checkParameters(13,-1));
    }

    @Test
     void search() {
        assertEquals(table.search(1,1),0);
    }

    @Test
    void edit() {
        assertThrows(Exception.class, ()->{table.edit(1,1,2);});
        assertTrue(table.search(1,1)==0);
        try {
            table.edit(1,1,2);
            assertEquals(table.search(1,1),2);
        }catch (Exception E){}
    }

    @Test
    void resetTable() {
        table.resetTable();
           assertTrue(table.search(3,3)==0);
    }
}