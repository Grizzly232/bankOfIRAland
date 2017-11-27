package model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Scanner;

@Entity
@Table(name = "Accounts")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
@SuppressWarnings("SerializableInterface")
public abstract class BankAccount {

    @Id
    Scanner in = new Scanner(System.in);
    protected String bid;
    protected ArrayList<String> holders;
    protected int pin, lastWithdrawal, lastDeposit;
    protected double balance;

    public abstract void withdraw(double amount);

    public abstract void deposit();

    public void changePin(int pin) {

       
}}
