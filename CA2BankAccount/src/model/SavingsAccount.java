package model;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="SavingsAccount")
@DiscriminatorValue(value="Savings")
@SuppressWarnings("SerializableClass")
public class SavingsAccount extends BankAccount {
    
    @Column(name = "monthlyTransactions")
    int monthlyTransactions;
    
    public SavingsAccount() {
        
    }
    
    public SavingsAccount(int lastWithdrawal, int lastDeposit, double balance, double interestRate, int monthlyTransactions) {
        super(lastWithdrawal, lastDeposit, balance, interestRate);
        this.monthlyTransactions = monthlyTransactions;
        addAccount(this);
    }
    
    @Override
    public void withdraw(double amount) {
        
        if(monthlyTransactions >= 6) {
            System.out.printf("Account %s has withdrawn %d times this month. No withdrawals remaining.", bid, monthlyTransactions);
        } else {
            balance -= amount;
            System.out.printf("Withdrawal successful. %d withdrawals remaining.", monthlyTransactions);
        }
        monthlyTransactions++;
    }
    
    @Override
    public void deposit(double amount) {
    
    }

    public int getMonthlyTransactions() {
        return monthlyTransactions;
    }

    public void setMonthlyTransactions(int monthlyTransactions) {
        this.monthlyTransactions = monthlyTransactions;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public int getLastWithdrawal() {
        return lastWithdrawal;
    }

    public void setLastWithdrawal(int lastWithdrawal) {
        this.lastWithdrawal = lastWithdrawal;
    }

    public int getLastDeposit() {
        return lastDeposit;
    }

    public void setLastDeposit(int lastDeposit) {
        this.lastDeposit = lastDeposit;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }
    
    @Override
    public String toString() {
        return super.toString() + "\nMonthly Transactions: " + monthlyTransactions;
    }
}
