package DataStructures;

/**
 * The MapFullException class is an exception used to tell that a map is full
 * and the value cannot currently be added
 *
 * @author evanm
 */
public class MapFullException extends RuntimeException {

    /**
     * New MapFullException with the specified message
     *
     * @param message the specified message
     */
    public MapFullException(String message) {
        super(message);
    }

    /**
     * New MapFullException with no message
     */
    public MapFullException() {
        super();
    }

}
