package DataStructures;

import ApplicationData.Patient;
import java.time.LocalDate;
import java.util.LinkedList;

/**
 * The HashMap class contains a hash table that stores patient objects, this is
 * based on first name, last name and date of birth
 *
 * @author evanm
 */
public class HashMap {

    //The capacity of the hashMap
    private int capacity;

    //The array of linked lists to store patients
    private LinkedList<Patient>[] lists;

    /**
     * The constructor to create a Patient hash map with the capacity specified
     *
     * @param capacity the number of lists in the hash table
     */
    public HashMap(int capacity) {
        this.capacity = capacity;
        this.lists = new LinkedList[capacity];
    }

    public void put(Patient patient) {

    }

}
