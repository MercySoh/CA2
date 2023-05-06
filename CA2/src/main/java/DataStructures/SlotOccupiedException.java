package DataStructures;

/**
 * The SlotOccupiedException class is an exception used to tell if a slot is
 * already occupied and the value can't be overwritten
 *
 * @author evanm
 */
public class SlotOccupiedException extends Exception {

    /**
     * New SlotOccupiedException with the specified message
     *
     * @param message the specified message
     */
    public SlotOccupiedException(String message) {
        super(message);
    }

    /**
     * New SlotOccupiedException with no message
     */
    public SlotOccupiedException() {
        super();
    }

}
