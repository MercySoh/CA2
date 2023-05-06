package ApplicationData;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.Objects;

/**
 * The Patients class contains information about the patients including first
 * name, last name, date of birth, the date they joined the practice and any
 * appointments the patient has made
 *
 * @author evanm
 */
public class Patient {

    //Creating instance Variables
    //Patients first name
    private String firstName;
    //Patients last name
    private String lastName;
    //Patients date of birth
    private LocalDate dateOfBirth;
    //The day the patient joined the practice
    private LocalDate dateJoinedPractice;
    //Any appointments the patient has made
    private LinkedList<Appointments> appointments;

    /**
     * The constructor to create a new patient object with the below parameters
     *
     * @param firstName - the patients first name
     * @param lastName - the patients last name
     * @param dateOfBirth - the patients date of birth
     * @param dateJoinedPractice - the day the patient joined the practice
     * @param appointments - the patients appointments
     */
    public Patient(String firstName, String lastName, LocalDate dateOfBirth, LocalDate dateJoinedPractice, LinkedList<Appointments> appointments) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.dateJoinedPractice = dateJoinedPractice;
        this.appointments = new LinkedList<>();
    }

    /**
     * Gets the patients first name
     *
     * @return The first name of the patient
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the patients first name
     *
     * @param firstName the patients first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the patients last name
     *
     * @return The last name of the patient
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the patients last name
     *
     * @param lastName the patients last name
     *
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the patients date of birth
     *
     * @return The date of birth of the patient
     */
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Sets the patients date of birth
     *
     * @param dateOfBirth the patients date of birth
     */
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * Gets the date the patient joined the practice
     *
     * @return The date the patient joined the practice
     */
    public LocalDate getDateJoinedPractice() {
        return dateJoinedPractice;
    }

    /**
     * Sets the date the patient joined the practice
     *
     * @param dateJoinedPractice the date the patient joined the practice
     */
    public void setDateJoinedPractice(LocalDate dateJoinedPractice) {
        this.dateJoinedPractice = dateJoinedPractice;
    }

    /**
     * Gets the patients appointments
     *
     * @return the patients appointments
     */
    public LinkedList<Appointments> getAppointments() {
        return appointments;
    }

    /**
     * Sets the patients appointments
     *
     * @param appointments the patients appointments
     */
    public void setAppointments(LinkedList<Appointments> appointments) {
        this.appointments = appointments;
    }

    /**
     * The hash code for the patients first name, last name and date of birth
     *
     * @return hash code
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.firstName);
        hash = 89 * hash + Objects.hashCode(this.lastName);
        hash = 89 * hash + Objects.hashCode(this.dateOfBirth);
        return hash;
    }

    /**
     * The equals for the patients first name, last name and date of birth
     *
     * @return true when obj is equal, else returns false
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Patient other = (Patient) obj;
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        return Objects.equals(this.dateOfBirth, other.dateOfBirth);
    }

}
