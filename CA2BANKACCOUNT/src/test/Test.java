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
                    ;
                    break;
                case 5:
                    System.out.println("Please enter the department id in order to view the employees");
                    int did = in.nextInt();
                    in.nextLine();
                    jpa.viewDepEmps(did);
                    break;
                case 6:
                    System.out.println("please enter the number of the project you wish to change the duration of");
                    int pid = in.nextInt();
                    in.nextLine();
                    System.out.println("please enter the new duration");
                    double duration = in.nextDouble();
                    jpa.changeProjDuration(pid, duration);
                    break;
                case 7:
                    System.out.println("Please enter the name of the department you wish to add");
                    String dName = in.nextLine();
                    d = new Department(dName);
                    jpa.addDepartment(d);
                    break;
                case 8:
                    System.out.println("Please enter the name of the FT employee you wish to add");
                    String eName = in.nextLine();
                    System.out.println("Please enter the salary of the employee you wish to add");
                    double eSal = in.nextDouble();
                    System.out.println("Please enter the start year of the employee");
                    int year = in.nextInt();
                    in.nextLine();
                    System.out.println("Please enter the start month of the employee");
                    int month = in.nextInt();
                    in.nextLine();
                    System.out.println("Please enter the start day of the employee");
                    int day = in.nextInt();
                    in.nextLine();
                    Calendar dob1 = Calendar.getInstance();
                    dob1.set(year, month, day);
                    FullTimeEmployee ft1 = new FullTimeEmployee(eSal, eName, dob1);
                    jpa.addFTEmployee(ft1);
                    System.out.println("Please enter the address for: " + eName);
                    String address = in.nextLine();
                    System.out.println("Please enter the eircode for: " + eName);
                    String eirCode = in.nextLine();
                    Address add1 = new Address(address, eirCode);
                    jpa.addAddress(add1);
                    jpa.addEmpAddress(ft1, add1);
                    break;
                case 9:
                    System.out.println("Please enter the name of the project you wish to add");
                    String pName = in.nextLine();
                    System.out.println("Please enter the duration of the project in months");
                    double dur = in.nextDouble();
                    jpa.addProject(new Project(pName, dur));
                    break;
                case 10:
                    System.out.println("please enter the number of the employee you wish to change the salary of");
                    eid = in.nextInt();
                    in.nextLine();
                    System.out.println("please enter the new salary");
                    double salary = in.nextDouble();
                    jpa.changeEmpSalary(eid, salary);
                    break;
                
    }
    
   
}

        
}

