package model;
import java.util.ArrayList;
import javax.persistence.*;

@Entity
@Table(name="CurrentAccount")
@DiscriminatorValue(value="Current")
@SuppressWarnings("SerializableClass")
public class CurrentAccount extends BankAccount {

    public CurrentAccount() {
        
    }
    
    public CurrentAccount(int pin, int lastWithdrawal, int lastDeposit, double balance, double interestRate) {
        super(lastWithdrawal, lastDeposit, balance, interestRate);
        addAccount(this);
    }
    
    @Override
    public void withdraw(double amount) {
         balance -= amount;
    }
    
    @Override
    public void deposit(double amount) {
    
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

    public static ArrayList<BankAccount> getbList() {
        return bList;
    }

    public static void setbList(ArrayList<BankAccount> bList) {
        BankAccount.bList = bList;
    }

    public ArrayList<Client> getHolders() {
        return holders;
    }

    public void setHolders(ArrayList<Client> holders) {
        this.holders = holders;
    }
    
    @Override
    public String toString() {
        return super.toString();
    }
}
