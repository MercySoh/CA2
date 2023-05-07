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
        if (key == null || value == null) {
            throw new IllegalArgumentException("Values cannot be null");
        }
        if (size == data.length) {
            data = growMap();
        }

        int slot = hash(key);
        System.out.println("Size of map: " + size + ", capacity: " + data.length);
        System.out.println("Slot calculated: " + slot);

        if (data[slot] == null) {
            Patient newPatient = new Patient(key, value);
            data[slot] = newPatient;
            size++;
            return null;
        } else {
            if (data[slot].key.equals(key)) {
                String oldValue = data[slot].updateValue(value);
                return oldValue;
            } else {
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
        Patient[] newMap = new Patient[data.length * 2];
        for (int i = 0; i < data.length; i++) {
            String key = data[i].key;
            int slot = key.hashCode();
            slot = Math.abs(slot);
            slot = slot % newMap.length;
            if (newMap[slot] != null) {
                throw new MapFullException("Cannot complete resize operation. Continued action would result in data loss.");
            }
            newMap[slot] = data[i];
        }
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
