package test;
import java.util.Scanner;
import model.*;

public class Test {
    static String[] tableNames = {"Client", "BankAccount", "ClientAcc"};
    public static void main(String[] args) {

//        BankAccount b1 = new SavingsAccount(5198, 20104, 1800.50, 0.2, 5);
//        BankAccount b2 = new CurrentAccount(516, 56697, 300.00, 0.02);
//        BankAccount b3 = new SavingsAccount(1521, 4421, 3000.50, 0.3, 3);
//        BankAccount b4 = new CurrentAccount(1660, 120, 6040.00, 0.01);
//
//        BankAccount.printBList();
        model.dbOperations db = new model.dbOperations();
        db.init();
           Scanner in = new Scanner(System.in);
       int choice=0;
      
      
       while(true){
       
        System.out.println("\nPress 1 to view an item");
        
        System.out.println("Press 2 to add an item");
        
        System.out.println("Press 3 to remove an item");
        
        System.out.println("Press 4 to update an item");
        System.out.println("Press 5 to exit");
        choice=in.nextInt();
        
        switch(choice){
            case 1:
                System.out.println("Enter the table name to view");
                String idView = in.next();
                db.viewTable(idView);
                break;
            case 2:
                System.out.println("Enter the table name to add to");
                String tableName = in.next();
                db.add(tableName);
                break;
            case 3:
                System.out.println("Enter the table name to delete from");
                String idDelete = in.next();
                System.out.println("Enter the column");
                String columnDelete = in.next();
                System.out.println("Enter the value");
                Object valueDelete =in.next();
                db.deleteFrom(idDelete,columnDelete,valueDelete);
                break;
            case 4:
                System.out.println("Enter the table name");
                String idUpdate=in.next();
                System.out.println("Enter the column");
                String colUpdate = in.next();
                System.out.println("Enter old value");
                Object oldValue = in.next();
                System.out.println("Enter new value");
                Object newValue= in.next();
                db.update(idUpdate,colUpdate,oldValue,newValue);
                break;
            case 5:
                System.exit(0);
            default:
                System.out.println("Invalid entry");
                System.exit(0);
                break;
            }
     
        }
            }
 
    
        
        
}
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
    

