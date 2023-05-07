package DataStructures;

import org.junit.Before;
import org.junit.Test;
import DataStructures.HashMap;
import DataStructures.SlotOccupiedException;

/**
 *
 * @author evanm
 */
public class HashMapTest {

    private Hashmap map;

    @Test
    public void growMap() throws SlotOccupiedException {
        map = new HashMap(2);
        map.put("John, Doe");
        map.put("Jane, Doe");
        //Adding a third value to resize the map to test growMap
        map.put("Jonathan, Doe");
        assertEquals(3, map.size());
        assertEquals("Doe", map.get("John"));
        assertEquals("Doe", map.get("Jane"));
        assertEquals("Doe", map.get("Jonathan"));
    }
    
    @Test
    public void testSize() throws SlotOccupiedException {
        map = new HashMap(2);
        assertEquals(0, map.size());
        map.put("John, Doe");
        map.put("Jane, Doe");
    }
}
