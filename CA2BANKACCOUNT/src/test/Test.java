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
        dbOperations db = new dbOperations();
        
        while (true) {
            System.out.println("Please press 1 to view all clients");
            System.out.println("Please press 2 to view all accounts");
            System.out.println("Please press 3 to view client and their accounts");          
            System.out.println("Please press 4 to add a new client");
            System.out.println("Please press 5 to add a new account");
            System.out.println("Please press 6 to remove an client from an account");
            System.out.println("Please press 7 to assign a client to an account");            
            System.out.println("Please press 8 to delete an client");
            System.out.println("Please press 9 to delete an account");          
            System.out.println("Press 10 to quit"); 

            int choice = in.nextInt();
            in.nextLine();

            switch (choice) {
                case 1:
                    db.viewClients();
                    break;
                case 2:
                    db.viewAccounts();
                    break;
                case 3:
                    System.out.println("Enter the client id to view all the associated accounts");
                    int cid = in.nextInt();
                    db.viewClientAccounts(cid);
                    break;
                case 4:
                    System.out.println("Enter the client name");
                    int cName = in.nextInt();
                    in.nextLine();
                case 5:
            }}}}
               