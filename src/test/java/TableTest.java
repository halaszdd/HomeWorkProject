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
    void resetTable() {
        table.resetTable();
           assertTrue(table.search(3,3)==0);
    }
}