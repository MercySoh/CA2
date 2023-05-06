package DataStructures;

import ApplicationData.Patient;

/**
 * The HashMap class contains a hash table that stores patient objects, this is
 * based on first name, last name and date of birth
 *
 * @author evanm
 */
public class HashMap {

    private static final int DEFAULT_CAPACITY = 103;
    private Patient[] data;
    private int size;

    public HashMap(Patient[] data) {
        data = new Patient[DEFAULT_CAPACITY];
    }
    
    
}
