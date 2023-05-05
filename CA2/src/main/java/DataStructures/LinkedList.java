package DataStructures;

import ApplicationData.Appointments;
import java.lang.reflect.Array;

/**
 * A Linked list class include all standard components of a LinkedList structure that hold appointments. 
 *
 * @author Mercy Soh Xi En
 */
public class LinkedList {

    /**
     * Set up first and last node and size of linked list
     */
    protected Node first;
    protected Node last;
    protected int size;

    /**
     * A parameterized constructor of Linked list
     */
    public LinkedList() {
        first = null;
        last = null;
        size = 0;
    }

    /**
     * Get the size of appointments list.
     *
     * @return size in appointments list
     */
    public int size() {
        return size;
    }

    /**
     * Get the value from the specified position of appointments list.
     *
     * @param pos is use for the specified position
     * @return value of the specified position from appointments list
     * @throws IndexOutOfBoundsException when the position is less than 0 or
     * greater than size
     */
    public Appointments get(int pos) {
        if (pos < 0 || pos >= size) {
            throw new IndexOutOfBoundsException("Illegal position supplied.");
        }
        Node current = first;
        while (current.next != null) {
            current = current.next;
        }
        return current.data;
    }

    /**
     * Returns specified value's position when it founded in appointments list.
     *
     * @param value is use for the specified value
     * @return position of specified value in appointments list when founded
     * else return -1 when it not be founded
     */
    public int indexOf(Appointments value) {

        if (first == null) {
            return -1;
        }

        Node current = first;

        for (int i = 0; i < size; i++) {
            if (current.data.equals(value)) {
                return i;
            }
            current = current.next;
        }
        return -1;
    }

    /**
     * Adds an appointments to the end of the appointments list.
     *
     * @param value is use for the specified value
     * @return true when added else return false
     */
    public boolean add(Appointments value) {
        Node newNode = new Node(value);

        if (first == null) {
            first = newNode;
            last = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }
        size++;
        return true;
    }

    /**
     * Set an appointments to a specified position in the appointments list.
     *
     * @param value is use for the specified value
     * @param pos is use for the specified position
     * @return original value when new value added
     * @throws IndexOutOfBoundsException when position is less than 0 or greater
     * than size
     */
    public Appointments set(Appointments value, int pos) {

        if (pos < 0 || pos >= size) {
            throw new IndexOutOfBoundsException("Invalid position provided.");
        }

        if (pos == 0) {
            Node newNode = new Node(value);
            newNode.next = first;
            first = newNode;

            size++;
            return newNode.next.data;
        } else {
            Node current = first;

            for (int i = 0; i < pos - 1; i++) {
                current = current.next;
            }

            Node newNode = new Node(value);
            newNode.next = current.next;
            current.next = newNode;
            size++;
            return newNode.next.data;
        }
    }

    /**
     * Removed specified appointments from appointments list.
     *
     * @param value is use for the specified value
     * @return true when specified value removed else return false
     */
    public boolean remove(Appointments value) {

        Node original = first;
        Node prev = null;

        if (value.equals(original.data)) {
            original.data = first.data;
            first = first.next;

            size--;
            return true;
        }

        while (original != null) {
            if (original.data.equals(value)) {
                prev.next = original.next;
                if (prev.next == null) {
                    last = prev;
                }
                size--;
                return true;
            }
            prev.data = original.data;
            original.data = original.next.data;
        }
        return false;
    }
    
     /**
     * Check appointments list is empty or not.
     *
     * @return true when appointments list is empty else return false
     */
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * A static class of Node to set up Node
     * 
     * An Appointments call data to store appointments data
     * A Node call next to track next node
     */
    protected static class Node {

        protected Appointments data;
        protected Node next;

        /** 
         * A public class Node
         * 
         * @param value of appointment
         */
        public Node(Appointments value) {
            this.data = value;
            this.next = null;
        }

    }
}
