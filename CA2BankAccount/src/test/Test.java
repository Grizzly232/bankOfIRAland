package test;
import java.util.Scanner;
import model.*;

public class Test {
    static String[] tableNames = {"Client", "CurrentAccount", "SavingsAccount", "ClientAcc"};
    public static void main(String[] args) {

//        BankAccount b1 = new SavingsAccount(5198, 20104, 1800.50, 0.2, 5);
//        BankAccount b2 = new CurrentAccount(516, 56697, 300.00, 0.02);
//        BankAccount b3 = new SavingsAccount(1521, 4421, 3000.50, 0.3, 3);
//        BankAccount b4 = new CurrentAccount(1660, 120, 6040.00, 0.01);
//
//        BankAccount.printBList();
        model.dbOperations db = new model.dbOperations();
        db.init();
        db.deleteFrom(tableNames[1], "balance", 1);
        
//        db.view(tableNames[1]);
//        db.em.close();
//        db.emf.close();
        //db.viewTable(tableNames[0], 32);
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
