package model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.util.Date;

@Entity
@Table(name = "BankAccount")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
@SuppressWarnings("SerializableInterface")
public abstract class BankAccount {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "bid", nullable=false)
    protected int bid;
    @Column(name = "pin", nullable=false)
    protected int pin;
    @Column(name = "lastWithdrawal")
    protected int lastWithdrawal;
    @Column(name = "lastDeposit")
    protected int lastDeposit;
    @Column(name = "balance", nullable=false)
    protected double balance;
    @Column(name = "interestRate")
    protected double interestRate;
    
    @Transient
    static ArrayList<BankAccount> bList = new ArrayList<>();
    
    @Transient
    protected ArrayList<Client> holders;

    public BankAccount() {

    }

    public BankAccount(int lastWithdrawal, int lastDeposit, double balance, double interestRate) {
        this.bid = getLastID() + 1;
        this.lastWithdrawal = lastWithdrawal;
        this.lastDeposit = lastDeposit;
        this.balance = balance;
        this.interestRate = interestRate;
    }

    public void addAccount(BankAccount b) {
        bList.add(b);
    }

    public int getLastID() {
        return BankAccount.getBlist().size();
    }

    public boolean isDuplicate(int id) {
        for (BankAccount b : bList) {
            if (b.getBid() == id) {
                return true;
            }
        }
        return false;
    }

    public int getAccountID() {
        return bid;
    }

    public double getBalance() {
        return balance;
    }

    public int getBid() {
        return bid;
    }

    public static ArrayList<BankAccount> getBlist() {
        return bList;
    }

    public static void printBList() {
        for (BankAccount b : bList) {
            System.out.printf("------------------------------%n"
                    + "BankAccount %d%n"
                    + "------------------------------", b.getBid());
            System.out.println(b.toString());
        }
    }

    @Override
    public String toString() {
        return "\nAccount ID: " + bid + "\nLast Withdrawal: " + lastWithdrawal + "\nLast Deposit: " + lastDeposit + "\nBalance: " + balance + "\nInterest Rate: " + interestRate;
    }

    public abstract void withdraw(double amount);

    public abstract void deposit(double amount);
}
