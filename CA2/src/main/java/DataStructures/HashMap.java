package DataStructures;

/**
 * The HashMap class contains a hash table that stores patient objects, this is
 * based on first name, last name and date of birth
 *
 * @author evanm
 */
public class HashMap {

    //Default capacity of hash table
    private static final int DEFAULT_CAPACITY = 103;

    //Array of patient objects
    private Patient[] data;

    //The number of key value pairs
    private int size;

    /**
     * Creates a new hash map object
     *
     * @param data an array of patient objects that gets stored in the hash
     * table
     */
    public HashMap(Patient[] data) {
        data = new Patient[DEFAULT_CAPACITY];
    }

    /**
     * Creates a new Hash map object with the capacity given
     *
     * @param capacity initial capacity of hash table
     * @throws IllegalArgumentException if capacity is invalid
     */
    public HashMap(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Map capacity Invalid - Cannot be lower than 1");
        }
        data = new Patient[capacity];
    }

    /**
     * Returns the number of key value pairs
     *
     * @return the number of key value pairs
     */
    public int size() {
        return size;
    }

    /**
     * Calculates the hash value for a key
     *
     * @param key the key to calculate the hash value for
     * @return the hash value for the key
     */
    private int hash(String key) {
        int hash = key.hashCode();
        hash = Math.abs(hash);
        hash = hash % data.length;
        return hash;
    }

    /**
     * Puts the keys and values into the hash table
     *
     * @param key the key for the new entry
     * @param value the value for the new entry
     * @return old value of the key or null
     * @throws SlotOccupiedException if the current slot is already occupied
     * @throws IllegalArgumentException if either of the parameters are null
     */
    public String put(String key, String value) throws SlotOccupiedException {
        //Checking if key or value is null
        if (key == null || value == null) {
            //Throwing error message
            throw new IllegalArgumentException("Values cannot be null");
        }
        //Checking if map is big enough
        if (size == data.length) {
            //Growing the map if needed
            data = growMap();
        }

        //Calculating slot for the key
        int slot = hash(key);
        //System output
        System.out.println("Size of map: " + size + ", capacity: " + data.length);
        //System output
        System.out.println("Slot calculated: " + slot);

        //If the slot is null
        if (data[slot] == null) {
            //Creating newPatient
            Patient newPatient = new Patient(key, value);
            //Insert into newPatient
            data[slot] = newPatient;
            //Increasing size
            size++;
            //Returning null
            return null;
        } else { //Otherwise
            //If the key is already in the current slot
            if (data[slot].key.equals(key)) {
                //Update the value
                String oldValue = data[slot].updateValue(value);
                //Return the old value
                return oldValue;
            } else { //Otherwise
                //Throwing error message
                throw new SlotOccupiedException("Provided key maps to occupied slot in map. ");
            }
        }

    }

    /**
     * Gets the value using the key as a parameter
     *
     * @param key the key whose value will be returned
     * @return the value of the key used as a parameter
     */
    public String get(String key) {
        int slot = hash(key);
        if (data[slot] != null) {
            return data[slot].value;
        } else {
            return null;
        }
    }

    /**
     * Grows the capacity of the map creating a new array of double the length
     * of the previous one
     *
     * @return a new array of double the previous arrays length
     * @throws MapFullException if the array cannot be resized
     */
    private Patient[] growMap() throws MapFullException {
        //Creating a new map double the size of the old map
        Patient[] newMap = new Patient[data.length * 2];
        //for each patient in the old map
        for (int i = 0; i < data.length; i++) {
            //Getting the key of the current patient
            String key = data[i].key;
            //Calculates hashCode of the key
            int slot = key.hashCode();
            //Calculates absolute value of the slot
            slot = Math.abs(slot);
            //Calculates the slot to store the key and value
            slot = slot % newMap.length;
            //If the slot in the newMap is not null
            if (newMap[slot] != null) {
                //Throwing error message
                throw new MapFullException("Cannot complete resize operation. Continued action would result in data loss.");
            }
            //Assigning the value to the empty slot in the newMap
            newMap[slot] = data[i];
        }
        //Returning the newMap
        return newMap;
    }

    /**
     * A patient object in the hash map containing key and value variables
     */
    private static class Patient {

        //The key used by the patient object
        private final String key;
        //The value used by the patient object
        private String value;

        /**
         * Creates a new patient object with key and value specified
         *
         * @param key the key used by the patient object
         * @param value the value used by the patient object
         */
        public Patient(String key, String value) {
            this.key = key;
            this.value = value;
        }

        /**
         * Returns the key of the patient object
         *
         * @return the key of the patient object
         */
        public String getKey() {
            return key;
        }

        /**
         * Returns the value of the patient object
         *
         * @return the value of the patient object
         */
        public String getValue() {
            return value;
        }

        /**
         * Updates the value of the patient object to the new value
         *
         * @param newValue the new value to be used with the patient object
         * @return the old value from the patient object
         */
        public String updateValue(String newValue) {
            String oldValue = value;
            this.value = newValue;
            return oldValue;
        }
    }
}
