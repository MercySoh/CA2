package ApplicationData;

import java.time.LocalDate;
import java.util.Objects;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author asus
 */
public class Appointments {
     private String firstName;
     private String lastName;
     private LocalDate dateOfBirth;
     private String issue;
     private LocalDate date;
     private int triageLevel;
     private String doctorFullName;

    public Appointments(String firstName, String lastName, String dateOfBirth, String issue, String date, int triageLevel, String doctorFullName) {
        this.firstName = firstName;
        this.lastName = lastName;
         LocalDate dOfB = LocalDate.parse(dateOfBirth);
            this.dateOfBirth = dOfB;
        this.issue = issue;
        LocalDate d = LocalDate.parse(date);
            this.date = d;
            if(triageLevel <0 || triageLevel > 5){
                throw new IllegalArgumentException();
            }else{
                this.triageLevel = triageLevel;
            }
        
        this.doctorFullName = doctorFullName;
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

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getTriageLevel() {
        return triageLevel;
    }

    public void setTriageLevel(int triageLevel) {
        if(triageLevel < 0 || triageLevel > 5){
            throw new IllegalArgumentException ();
        }else{
             this.triageLevel = triageLevel;
        }
    }

    public String getDoctorFullName() {
        return doctorFullName;
    }

    public void setDoctorFullName(String doctorFullName) {
        this.doctorFullName = doctorFullName;
    }

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
    
    public boolean compareTo(Appointments a) {
        
        if(this.triageLevel>0){
            return true;
        }else if(this.triageLevel<-1){
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Appointments{" + "firstName=" + firstName + ", lastName=" + lastName + ", dateOfBirth=" + dateOfBirth + ", issue=" + issue + ", date=" + date + ", triageLevel=" + triageLevel + ", doctorFullName=" + doctorFullName + '}';
    }
     
     
     
}
