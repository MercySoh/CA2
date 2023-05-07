/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package DataStructures;

import ApplicationData.Appointments;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author asus
 */
public class LinkedListTest {

    public LinkedListTest() {
    }

    /**
     * Test empty list of size method.
     */
    @Test
    public void testSize_EmptyList() {
        LinkedList instance = new LinkedList();
        int expResult = 0;
        int result = instance.size();
        assertEquals(expResult, result);
    }

    /**
     * Test populated list of size method.
     */
    @Test
    public void testSize_PopulatedList() {
        LinkedList instance = new LinkedList();
        instance.add(new Appointments("Jolin", "Smith", "1998-10-10", "Light Fever", "2023-04-14", 4, "Jennifer White"));
        instance.add(new Appointments("Ason", "Kelly", "1988-01-14", "Feel shortness of breath", "2023-04-29", 3, "Winson Murphy"));
        instance.add(new Appointments("Brian", "Carroll", "1994-05-21", "Lightheadedness", "2023-05-02", 1, "Jennifer White"));
        int expResult = 3;
        int result = instance.size();
        assertEquals(expResult, result);
    }

    /**
     * Test valid input of get method.
     */
    @Test
    public void testGet_ValidInput() {
        LinkedList instance = new LinkedList();
        instance.add(new Appointments());
        instance.add(new Appointments());
        instance.add(new Appointments());

        Appointments expResult = new Appointments();
        Appointments result = instance.get(1);
        assertEquals(expResult, result);
    }

    /**
     * Test valid input of end of list of get method.
     */
    @Test
    public void testGet_ValidInput_EndOfList() {
        LinkedList instance = new LinkedList();
        instance.add(new Appointments("Jolin", "Smith", "1998-10-10", "Light Fever", "2023-04-14", 4, "Jennifer White"));
        instance.add(new Appointments("Ason", "Kelly", "1988-01-14", "Feel shortness of breath", "2023-04-29", 3, "Winson Murphy"));
        instance.add(new Appointments("Brian", "Carroll", "1994-05-21", "Lightheadedness", "2023-05-02", 1, "Jennifer White"));

        Appointments expResult = new Appointments("Brian", "Carroll", "1994-05-21", "Lightheadedness", "2023-05-02", 1, "Jennifer White");
        Appointments result = instance.get(2);
        assertEquals(expResult, result);
    }

    /**
     * Test invalid - breaking lower bound(less than 0) of list of get method.
     */
    @Test
    public void testGet_BreakingLowerBound_LessThanZero() {
        LinkedList instance = new LinkedList();
        instance.add(new Appointments());
        instance.add(new Appointments());
        instance.add(new Appointments());

        assertThrows(IndexOutOfBoundsException.class, () -> {
            instance.get(-1);
        });
    }

    /**
     * Test invalid input - breaking upper bound(greater than size) of list of
     * get method.
     */
    @Test
    public void testGet_BreakingUpperBound_GreaterThanSize() {
        LinkedList instance = new LinkedList();
        instance.add(new Appointments());
        instance.add(new Appointments());
        instance.add(new Appointments());

        assertThrows(IndexOutOfBoundsException.class, () -> {
            instance.get(4);
        });
    }

    /**
     * Test invalid input - equal to size of get method.
     */
    @Test
    public void testGet_BreakingUpperBound_EqualToSize() {
        LinkedList instance = new LinkedList();
        instance.add(new Appointments());
        instance.add(new Appointments());
        instance.add(new Appointments());

        assertThrows(IndexOutOfBoundsException.class, () -> {
            instance.get(3);
        });
    }

    /**
     * Test appointments in the list of indexOf method.
     */
    @Test
    public void testIndexOf_AppointmentInList() {
        Appointments appt = new Appointments("Brian", "Carroll", "1994-05-21", "Lightheadedness", "2023-05-02", 1, "Jennifer White");

        LinkedList instance = new LinkedList();
        instance.add(new Appointments("Jolin", "Smith", "1998-10-10", "Light Fever", "2023-04-14", 4, "Jennifer White"));
        instance.add(new Appointments("Ason", "Kelly", "1988-01-14", "Feel shortness of breath", "2023-04-29", 3, "Winson Murphy"));
        instance.add(new Appointments("Brian", "Carroll", "1994-05-21", "Lightheadedness", "2023-05-02", 1, "Jennifer White"));

        int expResult = 2;
        int result = instance.indexOf(appt);
        assertEquals(expResult, result);
    }

    /**
     * Test appointment not in the list of indexOf method.
     */
    @Test
    public void testIndexOf_AppointmentNotInList() {
        Appointments appt = new Appointments();

        LinkedList instance = new LinkedList();
        instance.add(new Appointments("Jolin", "Smith", "1998-10-10", "Light Fever", "2023-04-14", 4, "Jennifer White"));
        instance.add(new Appointments("Ason", "Kelly", "1988-01-14", "Feel shortness of breath", "2023-04-29", 3, "Winson Murphy"));
        instance.add(new Appointments("Brian", "Carroll", "1994-05-21", "Lightheadedness", "2023-05-02", 1, "Jennifer White"));

        int expResult = -1;
        int result = instance.indexOf(appt);
        assertEquals(expResult, result);
    }

    /**
     * Test add one appointment to list of add method.
     */
    @Test
    public void testAdd_Appointment() {
        Appointments appt = new Appointments("Kenny", "Ryan", "1992-03-29", "Chest pain", "2023-05-02", 2, "Winson Murphy");
        LinkedList instance = new LinkedList();

        boolean expResult = true;
        boolean result = instance.add(appt);
        assertEquals(expResult, result);

        int expSize = 1;
        int resultSize = instance.size();
        assertEquals(expSize, resultSize);

        Appointments resultappt = instance.get(0);
        assertEquals(appt, resultappt);

        resultappt = instance.tail();
        assertEquals(appt, resultappt);
    }

    /**
     * Test add 2 elements of appointments to list of add method.
     */
    @Test
    public void testAdd_AddingTwoElements_Appointments() {
        LinkedList instance = new LinkedList();

        Appointments appt1 = new Appointments("Danny", "Dunne", "1990-03-11", "Knee pain", "2023-04-02", 4, "Winson Murphy");
        instance.add(appt1);
        boolean expResult = true;

        Appointments appt2 = new Appointments("Hannah", "Kelly", "2000-11-22", "Common cold", "2023-03-28", 5, "Winson Murphy");
        boolean result = instance.add(appt2);
        assertEquals(expResult, result);

        Appointments elem2 = instance.get(1);
        assertEquals(appt2, elem2);

        int expSize = 2;
        int resultSize = instance.size();
        assertEquals(expSize, resultSize);

        Appointments resultappt = instance.tail();
        assertEquals(appt2, resultappt);
    }

    /**
     * Test of set method, of class LinkedList.
     */
    @Test
    public void testSet() {
        System.out.println("set");
        Appointments value = null;
        int pos = 0;
        LinkedList instance = new LinkedList();
        Appointments expResult = null;
        Appointments result = instance.set(value, pos);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test remove one instance in list of remove method.
     */
    @Test
    public void testRemove_RemovingOneInstance() {
        Appointments appt = new Appointments("Jolin", "Smith", "1998-10-10", "Light Fever", "2023-04-14", 4, "Jennifer White");
       
        LinkedList instance = new LinkedList();
        instance.add(new Appointments("Jolin", "Smith", "1998-10-10", "Light Fever", "2023-04-14", 4, "Jennifer White"));
        instance.add(new Appointments("Ason", "Kelly", "1988-01-14", "Feel shortness of breath", "2023-04-29", 3, "Winson Murphy"));
        instance.add(new Appointments("Brian", "Carroll", "1994-05-21", "Lightheadedness", "2023-05-02", 1, "Jennifer White"));

        boolean expResult = true;
        boolean result = instance.remove(appt);
        assertEquals(expResult, result);
       
        int expSize = 2;
        assertEquals(expSize, instance.size());
    }

    /**
     * Test remove single instance where multiple exist in list of remove method.
     */
    @Test
    public void testRemove_RemovingSingleInstanceWhereMultipleExist() {
       Appointments appt = new Appointments("Jolin", "Smith", "1998-10-10", "Light Fever", "2023-04-14", 4, "Jennifer White");
        LinkedList instance = new LinkedList();
        
        instance.add(new Appointments("Jolin", "Smith", "1998-10-10", "Light Fever", "2023-04-14", 4, "Jennifer White"));
        instance.add(new Appointments("Ason", "Kelly", "1988-01-14", "Feel shortness of breath", "2023-04-29", 3, "Winson Murphy"));
        instance.add(new Appointments("Brian", "Carroll", "1994-05-21", "Lightheadedness", "2023-05-02", 1, "Jennifer White"));
        instance.add(new Appointments("Jolin", "Smith", "1998-10-10", "Light Fever", "2023-04-14", 4, "Jennifer White"));
        
        boolean expResult = true;
        boolean result = instance.remove(appt);
        assertEquals(expResult, result);
        
        int expSize = 3;
        assertEquals(expSize, instance.size());
        int expPos = 2;
        assertEquals(expPos, instance.indexOf(appt));
    }

    /**
     * Test empty list of isEmpty method.
     */
    @Test
    public void testIsEmpty() {
        
        LinkedList instance = new LinkedList();
        boolean expResult = true;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
    }
    
    /**
     * Test populated list of isEmpty method.
     */
    @Test
    public void testIsEmpty_PopulatedList() {
        LinkedList instance = new LinkedList();
        instance.add(new Appointments("Jolin", "Smith", "1998-10-10", "Light Fever", "2023-04-14", 4, "Jennifer White"));
        instance.add(new Appointments("Ason", "Kelly", "1988-01-14", "Feel shortness of breath", "2023-04-29", 3, "Winson Murphy"));
        instance.add(new Appointments("Brian", "Carroll", "1994-05-21", "Lightheadedness", "2023-05-02", 1, "Jennifer White"));
        
        boolean expResult = false;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
    }

}
