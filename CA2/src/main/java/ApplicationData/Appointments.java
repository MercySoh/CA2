package ApplicationData;

import java.time.LocalDate;
import java.util.Objects;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 * An appointments class that have patient's first name, last name and date of
 * birth of fields and issue, date, triage level and doctor full name fields. An
 * appointments class use implements to compare triage level where 1 is higher
 * than 5 to natural order.
 *
 * @author Mercy
 */
public class Appointments implements Comparable<Appointments> {

    /**
     * Set up fields for appointments class
     */
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String issue;
    private LocalDate date;
    private int triageLevel;
    private String doctorFullName;

    /**
     * A parameterized constructor of appointments
     *
     * @param firstName patient's first name
     * @param lastName patient's last name
     * @param dateOfBirth patient's date of birth
     * @param issue of patient
     * @param date of patient visit
     * @param triageLevel of patient
     * @param doctorFullName full name of patient's doctor
     *
     * @throws IllegalArgumentException when triage level less than 0 or greater
     * than 5
     */
    public Appointments(String firstName, String lastName, String dateOfBirth, String issue, String date, int triageLevel, String doctorFullName) {
        this.firstName = firstName;
        this.lastName = lastName;
        LocalDate dOfB = LocalDate.parse(dateOfBirth);
        this.dateOfBirth = dOfB;
        this.issue = issue;
        LocalDate d = LocalDate.parse(date);
        this.date = d;
        if (triageLevel < 0 || triageLevel > 5) {
            throw new IllegalArgumentException();
        } else {
            this.triageLevel = triageLevel;
        }

        this.doctorFullName = doctorFullName;
    }

    /**
     * Get patient's first name
     *
     * @return patient's first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Set patient's first name
     *
     * @param firstName of patient
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Get patient's last name
     *
     * @return patient's last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Set patient's last name
     *
     * @param lastName of patient
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Get patient's date of birth
     *
     * @return patient's date of birth
     */
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Set patient's date of birth
     *
     * @param dateOfBirth of patient
     */
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * Get patient's issue
     *
     * @return patient's issue
     */
    public String getIssue() {
        return issue;
    }

    /**
     * Set patient's issue
     *
     * @param issue of patient
     */
    public void setIssue(String issue) {
        this.issue = issue;
    }

    /**
     * Get patient's visit date
     *
     * @return patient's visit date
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * Set patient's visit date
     *
     * @param date of visit
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }

    /**
     * Get triage level of patient
     *
     * @return triage level of patient
     */
    public int getTriageLevel() {
        return triageLevel;
    }

    /**
     * Set triage level of patient
     *
     * @param triageLevel of patient
     * @throws IllegalArgumentException when triage level less than 0 or greater
     * than 5
     */
    public void setTriageLevel(int triageLevel) {
        if (triageLevel < 0 || triageLevel > 5) {
            throw new IllegalArgumentException();
        } else {
            this.triageLevel = triageLevel;
        }
    }

    /**
     * Get patient's doctor full name
     *
     * @return doctor's full name
     */
    public String getDoctorFullName() {
        return doctorFullName;
    }

    /**
     * Set patient's doctor full name
     *
     * @param doctorFullName of patient
     */
    public void setDoctorFullName(String doctorFullName) {
        this.doctorFullName = doctorFullName;
    }

    /**
     * Hash code for first name, last name, date of birth, issue and date to
     * considered equal where patients have the same data
     *
     * @return hash's code
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 61 * hash + Objects.hashCode(this.firstName);
        hash = 61 * hash + Objects.hashCode(this.lastName);
        hash = 61 * hash + Objects.hashCode(this.dateOfBirth);
        hash = 61 * hash + Objects.hashCode(this.issue);
        hash = 61 * hash + Objects.hashCode(this.date);
        return hash;
    }

    /**
     * Equal where patients have the same data of 5 fields
     *
     * @param obj object to compare equal
     * @return true when obj equal else return false
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
        final Appointments other = (Appointments) obj;
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        if (!Objects.equals(this.issue, other.issue)) {
            return false;
        }
        if (!Objects.equals(this.dateOfBirth, other.dateOfBirth)) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        return true;
    }

    /**
     * Use to compare 2 triage level to do natural order
     *
     * @param a another appointment's triage level
     * @return 1 when this triage level is greater than a triage level, return
     * -1 when this triage level less than a triage level, return 0 when both
     * are equal.
     */
    @Override
    public int compareTo(Appointments a) {
        if (this.triageLevel > a.triageLevel) {
            return 1;
        } else if (this.triageLevel < a.triageLevel) {
            return -1;
        }
        return 0;
    }

    /**
     * Format to print out appointment's data
     *
     * @return first name, last name, date of birth, issue, date, triage level
     * and doctor full name in proper format.
     */
    @Override
    public String toString() {
        return "Appointments{" + "firstName=" + firstName + ", lastName=" + lastName + ", dateOfBirth=" + dateOfBirth + ", issue=" + issue + ", date=" + date + ", triageLevel=" + triageLevel + ", doctorFullName=" + doctorFullName + '}';
    }

}
