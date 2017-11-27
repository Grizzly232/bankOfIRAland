/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;
import java.util.Scanner;
import model.*;

/**
 *
 * @author x00136708
 */
public class Test {
    public static void main(String[] args) {
        dbOperations db = new dbOperations();
        db.init();
        db.viewClients();
        
        /*int pin1=0;
        int pin=0;
        Scanner in = new Scanner(System.in);
         System.out.println("Login is Admin/Guest (A/G)");
        
        char user = in.nextLine().charAt(0);
        if (user==('A') || user==('a')) {
            System.out.println("Enter admin pin: ");
            pin = in.nextInt();
            if (pin == 8741) {
                int counter = 0;
                while (counter == 0) {

                    System.out.println("Enter pin to change");
                    pin = in.nextInt();
                    System.out.println("Re-enter pin to change");
                    int pinCheck = in.nextInt();

                    if (pin != pinCheck) {
                        System.out.println("Error: Passwords don't match. re-enter");

                    } 
                    else {

                        pin1 = pin;
                        System.out.println("Pin successfully changed");
                        counter = 1;
                    }
                 
            }
            

        }
            else {
                System.out.println("Wrong password.");
            }
            //adminMenu();
    }
        else if(user==('G') || user==('g')){
            //guestMenu();
        }
        */
    }
}

