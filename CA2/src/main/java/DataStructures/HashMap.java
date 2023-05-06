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

    public HashMap(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Map capacity Invalid - Cannot be lower than 1");
        }
        data = new Patient[capacity];
    }

    public int size() {
        return size;
    }

    private int hash(String key) {
        int hash = key.hashCode();
        hash = Math.abs(hash);
        hash = hash % data.length;
        return hash;
    }

    public String put(String key, String value) {
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

    public String get(String key) {
        int slot = hash(key);
        if (data[slot] != null) {
            return data[slot].value;
        } else {
            return null;
        }
    }

    private Patient[] growMap() {
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
}
