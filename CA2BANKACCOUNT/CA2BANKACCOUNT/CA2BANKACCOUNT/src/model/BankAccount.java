/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import javax.persistence.*;
import java.util.ArrayList;

/**
 *
 * @author x00136708
 */
public abstract class BankAccount {
    double balance;
    int id;
    ArrayList<Client> holders = new ArrayList(2);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      
    public BankAccount(){
        this.balance=0;
        this.id=0;
    }
    public BankAccount(double balance, int id){
        this.balance=balance;
        this.id=id;
    }
    public abstract void deposit(double amount);
    public abstract void withdraw(double amount);
        
    
    
}
