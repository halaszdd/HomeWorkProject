import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TableTest {
    Table table = new Table();

    @Test
    void checkParameters() {
        assertTrue(table.CheckParameters(7,5));
    }

    @Test
     void search() {
        assertEquals(table.Search(1,1),0);
    }

    @Test
    void edit() {
        assertThrows(Exception.class, ()->{table.Edit(1,1,2);});
        assertTrue(table.Search(1,1)==0);
    }
}