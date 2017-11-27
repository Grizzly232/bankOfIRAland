package model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

@Entity
@Table(name = "BankAccount")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
@SuppressWarnings("SerializableInterface")
public abstract class BankAccount {

    @Id
    protected int bid;
    protected ArrayList<String> holders;
    protected int pin, lastWithdrawal, lastDeposit;
    protected double balance;
    
    public BankAccount() {
    
    }
    
    public int getAccountID(){
        return bid; 
    }
    
    public double getBalance(){
        return balance;
    }
    
    
    public abstract double withdraw(double amount);

    public abstract void deposit();

}