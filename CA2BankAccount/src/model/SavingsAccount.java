package model;
import javax.persistence.*;

@Entity
@Table(name="SavingsAccount")
@DiscriminatorValue(value="Savings")
@SuppressWarnings("SerializableClass")
public class SavingsAccount extends BankAccount {
    
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

    @Override
    public String toString() {
        return super.toString() + "\nMonthly Transactions: " + monthlyTransactions;
    }
    
    
}
