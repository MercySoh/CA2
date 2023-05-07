/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Application;

import ApplicationData.Appointments;
import DataStructures.PriorityQueue;
import java.util.Scanner;

/**
 *
 * @author Mercy and Evan
 */
public class ApplicationCA2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Appointments appt1 = new Appointments("Susan", "Kelly", "2007-04-19", "Fall down and bleed", "2023-05-06", 5, "Jennifer White");

        int choice = -1;

        do {
            ApplicationCA2.DisplayMenu();
            System.out.println();
            choice = sc.nextInt();

            switch (choice) {

                case 1: {

                }
                break;

                case 2: {

                }
                break;

                case 3: {

                }

                break;

                case 4: {
                    int choice2;
                    do {
                     ApplicationCA2.Display2Menu();
                     choice2 = sc.nextInt();
                     
                    switch (choice2) {
                            case 1:
                    System.out.println("Create a new appointment:");
                    PriorityQueue newAppt = new PriorityQueue();

                    newAppt.enque(appt1);
                    
                           case 2:
                               System.out.println("Returning to Main Menu");
                               break;
                           default:
                               System.out.println("Invalid choice, choose again");
                }while (choice2 != 2);
                          
                break;
                
                case 5: {

                }
                break;

                case 6:
                    System.out.println("Exit Program.");
                    break;
                default:
                    System.out.println("Invalid choice, choose again");

            }
            System.out.println();
        } while (choice != 6);
            }
        }
        }

    /**
     * Display menu for user to choose.
     */
    public static void DisplayMenu() {
        System.out.println("==== MENU ====");
        System.out.println("1. Add a new patient.");
        System.out.println("2. Delete a patient.");
        System.out.println("3. Display all patient.");
        System.out.println("4. Create new appointment.");
        System.out.print("5. Call next patient.");
        System.out.print("6. Exit application.");
    }

    /**
     * Display menu for user to choose they can start the method or back to main menu.
     */
    public static void Display2Menu() {
        System.out.println("==== MENU ====");
        System.out.println("1. Start.");
        System.out.println("2. Exit back to menu.");
        System.out.print("Enter the number for the option you want : ");
    }
}
