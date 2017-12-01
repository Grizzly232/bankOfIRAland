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
    @Column(name = "id")
    protected int bid;
    protected int monthlyTransactions;
    @Transient
    protected ArrayList<Client> holders;
    protected int pin, lastWithdrawal, lastDeposit;
    protected double balance, interestRate;
    static public ArrayList<BankAccount> bList = new ArrayList<>();

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

    public int getMontlyTransactions() {
        return monthlyTransactions;
    }

    public abstract void withdraw(double amount);

    public abstract void deposit(double amount);
}
