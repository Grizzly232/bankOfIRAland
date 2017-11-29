package model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

@Entity
@Table(name = "BankAccount")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "type")
@SuppressWarnings("SerializableInterface")
public class BankAccount {

    @Id
    int monthlyTransactions;
    protected int bid;
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name="ClientAcc",
            joinColumns = @JoinColumn(name="bid"),
            inverseJoinColumns = @JoinColumn(name="cid"))
    
    static public ArrayList<BankAccount> bList = new ArrayList<>();
    
         @Transient   
    Scanner in = new Scanner(System.in);
    
    protected ArrayList<String> holders;
    protected int pin, lastWithdrawal, lastDeposit;
    protected double balance;

    public BankAccount(){
        
    }
    
     public BankAccount(int bid, int lastWithdrawal, int lastDeposit, double balance) {
        this.bid = getLastID() + 1;
        this.lastWithdrawal = lastWithdrawal;
        
        addAccount(this);
    }

    public void addAccount(BankAccount b) {
        if (!isDuplicate(b.getBid())) {
            bList.add(b);
        }
    }
        public int getLastID() {
        return Client.getClist().size();
    }
        

    public boolean isDuplicate(int id) {
        for (BankAccount b : bList) {
            if (b.getBid() == id) {
                return true;
            }
        }
        return false;
    }
    
    
    
    public int getBid(){
        return bid; 
    }
    
    public static ArrayList<BankAccount> getBlist(){
        return bList;
    }
    
    public double getBalance(){
        return balance;
    }
     public  void printBList() {
        for(BankAccount b : bList) {
            System.out.printf("------------------------------%n"
                    + "BankAccount %d, %s %s%n"
                    + "------------------------------", b.getBid());
            System.out.println(b.toString());
        }
    }
    
    public String toString() {
        return "\nAccount ID: " + bid + "\nLast Withdrawal: " + lastWithdrawal + "\nLast Deposit: " + lastDeposit + "\nBalance: " + balance;
    }
     public int getMontlyTransactions(){
        return monthlyTransactions;
    }
    
    
    
  

}