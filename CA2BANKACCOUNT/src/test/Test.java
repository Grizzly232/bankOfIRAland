/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;
import java.util.Scanner;
import model.dbOperations;

/**
 *
 * @author x00136708
 */
public class Test {
    
    public static void main(String[] args) {
        int pin1=0;
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
        

            

    
        
        dbOperations db = new dbOperations();
        while (true) {
            System.out.println("Press 1 to view your information");
            System.out.println("Press 2 to make a deposit");
            System.out.println("Press 3 to make a withdrawal");
            System.out.println("Please press 4 to quit");
            
            
            
            

            int choice = in.nextInt();
            in.nextLine();

            switch (choice) {
                case 1:
                    
                    db.viewClientInformation(cid);
                    break;
                case 2:
                    System.out.println("Enter they amount to deposit");
                    double depAmount = in.nextDouble();
                    db.deposit(depAmount);
                    break;
                case 3:
                    System.out.println("Enter the amount to withdraw");
                    double withdrawAmount=in.nextDouble();
                    dp.withdraw(withdrawAmount);
                    break;
                case 4:
                    System.out.println("Please enter the employee id in order to view their projects");
                    int eid = in.nextInt();
                    in.nextLine();
                    jpa.viewEmpProjects(eid);
                    break;
       
            }
        }

    }

}


        }
            else {
                System.out.println("Wrong password.");
            }
            adminMenu();
    }
        else if(user==('G') || user==('g')){
            guestMenu();
        }
    }
   
    
}

