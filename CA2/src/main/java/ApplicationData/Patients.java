package ApplicationData;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.Objects;

/**
 *
 * @author evanm
 */
public class Patients {

    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private LocalDate dateJoinedPractice;
    private LinkedList<Appointments> appointments;

    public Patients(String firstName, String lastName, LocalDate dateOfBirth, LocalDate dateJoinedPractice, LinkedList<Appointments> appointments) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.dateJoinedPractice = dateJoinedPractice;
        this.appointments = new LinkedList<Appointments>();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public LocalDate getDateJoinedPractice() {
        return dateJoinedPractice;
    }

    public void setDateJoinedPractice(LocalDate dateJoinedPractice) {
        this.dateJoinedPractice = dateJoinedPractice;
    }

    public LinkedList<Appointments> getAppointments() {
        return appointments;
    }

    public void setAppointments(LinkedList<Appointments> appointments) {
        this.appointments = appointments;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.firstName);
        hash = 89 * hash + Objects.hashCode(this.lastName);
        hash = 89 * hash + Objects.hashCode(this.dateOfBirth);
        return hash;
    }

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
        final Patients other = (Patients) obj;
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        return Objects.equals(this.dateOfBirth, other.dateOfBirth);
    }

}
